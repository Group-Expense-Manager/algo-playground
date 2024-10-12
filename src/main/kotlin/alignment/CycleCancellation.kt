package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class CycleCancellation : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users.map { it.copy() }.toMutableList()
        val transactions = mutableListOf<AlignmentTransaction>()

        for (i in users.indices) {
            for (j in users.indices) {
                if (i != j && users[i].balance > 0 && users[j].balance < 0) {
                    val amount = minOf(users[i].balance, -users[j].balance)
                    transactions.add(AlignmentTransaction(users[j].name, users[i].name, amount))
                    users[i] = users[i].copy(balance = users[i].balance - amount)
                    users[j] = users[j].copy(balance = users[j].balance + amount)
                }
            }
        }

        val adjustedTransactions = transactions.toMutableList()
        val visited = mutableSetOf<Pair<String, String>>()

        for (t in transactions) {
            if (Pair(t.nameTo, t.nameFrom) !in visited) {
                visited.add(Pair(t.nameFrom, t.nameTo))
                adjustedTransactions.removeIf { it.nameFrom == t.nameTo && it.nameTo == t.nameFrom && it.amount == t.amount }
            }
        }

        return adjustedTransactions
    }
}





