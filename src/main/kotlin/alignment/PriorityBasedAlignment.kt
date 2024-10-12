package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

data class UserWithPriority(
    val name: String,
    var balance: Long,
    val priority: Int
)

class PriorityBasedAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {

        val iterations = 1000
        var bestTransactions: List<AlignmentTransaction> = emptyList()
        var bestTransactionsCount = Long.MAX_VALUE

        for (i in 0 until iterations) {
            val users = alignmentInput.users.map { UserWithPriority(it.name, it.balance, (0..alignmentInput.users.size).random()) }
            val transactions = mutableListOf<AlignmentTransaction>()

            val creditors = users.filter { it.balance > 0 }.sortedByDescending { it.priority }
            val debtors = users.filter { it.balance < 0 }.sortedBy { it.priority }

            for (debtor in debtors) {
                for (creditor in creditors) {
                    if (debtor.balance < 0) {
                        val amount = minOf(-debtor.balance, creditor.balance)
                        transactions.add(AlignmentTransaction(debtor.name, creditor.name, amount))
                        debtor.balance += amount
                        creditor.balance -= amount
                    }
                }
            }

            if (bestTransactionsCount > transactions.size) {
                bestTransactions = transactions
                bestTransactionsCount = transactions.size.toLong()
            }
        }

        return bestTransactions
    }
}