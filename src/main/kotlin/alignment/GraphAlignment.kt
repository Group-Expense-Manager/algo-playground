package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class GraphAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users
        val creditors = mutableListOf<Pair<String, Long>>()
        val debtors = mutableListOf<Pair<String, Long>>()

        for (user in users) {
            when {
                user.balance > 0 -> creditors.add(user.name to user.balance)
                user.balance < 0 -> debtors.add(user.name to -user.balance)
            }
        }

        val transactions = mutableListOf<AlignmentTransaction>()

        while (creditors.isNotEmpty() && debtors.isNotEmpty()) {
            val (creditorName, creditorAmount) = creditors[0]
            val (debtorName, debtorAmount) = debtors[0]
            val transactionAmount = minOf(creditorAmount, debtorAmount)

            transactions.add(AlignmentTransaction(debtorName, creditorName, transactionAmount))

            if (creditorAmount > debtorAmount) {
                creditors[0] = creditorName to (creditorAmount - transactionAmount)
                debtors.removeAt(0)
            } else {
                debtors[0] = debtorName to (debtorAmount - transactionAmount)
                creditors.removeAt(0)
            }
        }

        return transactions
    }
}