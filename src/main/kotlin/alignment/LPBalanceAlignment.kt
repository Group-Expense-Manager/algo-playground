package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

data class Equation(val coefficients: DoubleArray, val constant: Double)

class SimplexSolver {
    fun solve(equations: List<Equation>, objective: DoubleArray): DoubleArray {
        val numberOfVariables = objective.size
        val numberOfEquations = equations.size
        val table = Array(numberOfEquations + 1) { DoubleArray(numberOfVariables + numberOfEquations + 1) }

        for (i in equations.indices) {
            table[i][numberOfVariables + i] = 1.0
            for (j in objective.indices) {
                table[i][j] = equations[i].coefficients[j]
            }
            table[i][table[i].lastIndex] = equations[i].constant
        }
        for (j in objective.indices) {
            table[numberOfEquations][j] = -objective[j]
        }

        fun pivot(col: Int, row: Int) {
            val pivotElement = table[row][col]
            for (j in table[row].indices) table[row][j] /= pivotElement
            for (i in table.indices) {
                if (i != row) {
                    val factor = table[i][col]
                    for (j in table[i].indices) {
                        table[i][j] -= factor * table[row][j]
                    }
                }
            }
        }

        while (true) {
            val pivotCol = table[numberOfEquations].dropLast(1).withIndex().minByOrNull { it.value }?.index ?: break
            if (table[numberOfEquations][pivotCol] >= 0) break

            val ratios = table.dropLast(1).withIndex()
                .filter { it.value[pivotCol] > 0 }
                .map { it.index to it.value.last() / it.value[pivotCol] }

            val pivotRow = ratios.minByOrNull { it.second }?.first ?: break
            pivot(pivotCol, pivotRow)
        }

        val solution = DoubleArray(numberOfVariables)
        for (i in 0 until numberOfVariables) {
            val column = table.withIndex().indexOfFirst { it.value[i] == 1.0 && it.index < numberOfEquations }
            if (column != -1 && column < numberOfEquations) solution[i] = table[column].last()
        }

        return solution
    }
}

class LPBalanceAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users
        val n = users.size
        val transactions = mutableListOf<AlignmentTransaction>()

        val equations = mutableListOf<Equation>()
        val objective = DoubleArray(n * (n - 1))

        users.forEachIndexed { i, user ->
            val coefficients = DoubleArray(n * (n - 1)) { 0.0 }
            for (j in users.indices) {
                if (i != j) coefficients[i * (n - 1) + j - if (j > i) 1 else 0] = 1.0
            }
            equations.add(Equation(coefficients, user.balance.toDouble()))
            for (k in i * (n - 1) until (i + 1) * (n - 1)) {
                objective[k] = 1.0
            }
        }

        val simplexSolver = SimplexSolver()
        val solution = simplexSolver.solve(equations, objective)

        users.forEachIndexed { i, userFrom ->
            users.forEachIndexed { j, userTo ->
                if (i != j) {
                    val index = i * (n - 1) + j - if (j > i) 1 else 0
                    if (solution[index] > 0) {
                        transactions.add(AlignmentTransaction(userFrom.name, userTo.name, solution[index].toLong()))
                    }
                }
            }
        }

        return transactions
    }
}



