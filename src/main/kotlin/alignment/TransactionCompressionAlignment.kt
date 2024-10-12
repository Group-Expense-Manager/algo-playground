package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class TransactionCompressionAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users
        val transactions = mutableListOf<AlignmentTransaction>()

        val netBalances = mutableMapOf<String, Long>()

        for (user in users) {
            netBalances[user.name] = netBalances.getOrDefault(user.name, 0L) + user.balance
        }

        val creditors = netBalances.filter { it.value > 0 }.toList().toMutableList()
        val debtors = netBalances.filter { it.value < 0 }.toList()

        for (debtor in debtors) {
            var amountOwed = -debtor.second
            for (creditor in creditors) {
                val transactionAmount = minOf(amountOwed, creditor.second)
                if (transactionAmount > 0) {
                    transactions.add(AlignmentTransaction(debtor.first, creditor.first, transactionAmount))
                    amountOwed -= transactionAmount

                    creditors[creditors.indexOf(creditor)] = creditor.first to (creditor.second - transactionAmount)

                    if (amountOwed == 0L) break
                }
            }
        }

        return transactions
    }
}