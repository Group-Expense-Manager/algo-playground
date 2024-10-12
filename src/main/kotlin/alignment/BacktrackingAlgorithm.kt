package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class BacktrackingAlgorithm : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users.map { it.copy() }.toMutableList()
        val transactions = mutableListOf<AlignmentTransaction>()

        fun backtrack(index: Int) {
            if (index == users.size) {
                return
            }

            for (i in users.indices) {
                for (j in users.indices) {
                    if (i != j && users[i].balance > 0 && users[j].balance < 0) {
                        val amount = minOf(users[i].balance, -users[j].balance)
                        transactions.add(AlignmentTransaction(users[j].name, users[i].name, amount))
                        users[i] = users[i].copy(balance = users[i].balance - amount)
                        users[j] = users[j].copy(balance = users[j].balance + amount)
                        backtrack(index + 1)
                        users[i] = users[i].copy(balance = users[i].balance + amount)
                        users[j] = users[j].copy(balance = users[j].balance - amount)
                        transactions.removeAt(transactions.lastIndex)
                    }
                }
            }
        }

        backtrack(0)
        return transactions
    }
}






