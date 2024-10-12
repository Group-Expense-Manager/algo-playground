package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction
import kotlin.math.abs

import kotlin.math.min

fun hungarianAlgorithm(cost: Array<IntArray>): IntArray {
    val n = cost.size - 1
    val u = IntArray(n + 1)
    val v = IntArray(n + 1)
    val p = IntArray(n + 1)
    val way = IntArray(n + 1)

    for (i in 1..n) {
        val minv = IntArray(n + 1) { Int.MAX_VALUE }
        val used = BooleanArray(n + 1)
        var j0 = 0
        p[0] = i
        do {
            used[j0] = true
            val i0 = p[j0]
            var delta = Int.MAX_VALUE
            var j1 = 0
            for (j in 1..n) {
                if (!used[j]) {
                    val cur = cost[i0][j] - u[i0] - v[j]
                    if (cur < minv[j]) {
                        minv[j] = cur
                        way[j] = j0
                    }
                    if (minv[j] < delta) {
                        delta = minv[j]
                        j1 = j
                    }
                }
            }
            for (j in 0..n) {
                if (used[j]) {
                    u[p[j]] += delta
                    v[j] -= delta
                } else {
                    minv[j] -= delta
                }
            }
            j0 = j1
        } while (p[j0] != 0)

        do {
            val j1 = way[j0]
            p[j0] = p[j1]
            j0 = j1
        } while (j0 != 0)
    }

    return p
}

class HungarianAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users.map { it.copy() }
        val creditors = users.filter { it.balance > 0 }.toMutableList()
        val debtors = users.filter { it.balance < 0 }.toMutableList()

        val n = maxOf(creditors.size, debtors.size)
        val cost = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

        for (i in creditors.indices) {
            for (j in debtors.indices) {
                cost[i + 1][j + 1] = abs(debtors[j].balance.toInt())
            }
        }

        val assignment = hungarianAlgorithm(cost)
        val transactions = mutableListOf<AlignmentTransaction>()

        for (i in 1 until creditors.size + 1) {
            val j = assignment[i]
            if (j > 0) {
                while (creditors[i - 1].balance > 0) {
                    val amount = min(creditors[i - 1].balance, -debtors[j - 1].balance)
                    transactions.add(AlignmentTransaction( debtors[j - 1].name, creditors[i - 1].name, amount))
                    creditors[i - 1] = creditors[i - 1].copy(balance = creditors[i - 1].balance - amount)
                    debtors[j - 1] = debtors[j - 1].copy(balance = debtors[j - 1].balance + amount)

                    if (debtors[j - 1].balance == 0L) break
                }
            }
        }

        return transactions
    }
}


