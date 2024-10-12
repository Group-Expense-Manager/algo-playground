package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class GreedyAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users

        val debtors = mutableListOf<Pair<String, Long>>()
        val creditors = mutableListOf<Pair<String, Long>>()

        for (user in users) {
            when {
                user.balance < 0 -> debtors.add(Pair(user.name, -user.balance))
                user.balance > 0 -> creditors.add(Pair(user.name, user.balance))
            }
        }

        val transactions = mutableListOf<AlignmentTransaction>()
        var debtorIndex = 0
        var creditorIndex = 0

        while (debtorIndex < debtors.size && creditorIndex < creditors.size) {
            val debtor = debtors[debtorIndex]
            val creditor = creditors[creditorIndex]

            val transferAmount = minOf(debtor.second, creditor.second)
            transactions.add(AlignmentTransaction(debtor.first, creditor.first, transferAmount))

            debtors[debtorIndex] = Pair(debtor.first, debtor.second - transferAmount)
            creditors[creditorIndex] = Pair(creditor.first, creditor.second - transferAmount)

            if (debtors[debtorIndex].second == 0L) {
                debtorIndex++
            }

            if (creditors[creditorIndex].second == 0L) {
                creditorIndex++
            }
        }

        return transactions
    }
}