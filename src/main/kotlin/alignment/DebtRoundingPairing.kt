package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

class DebtRoundingPairing : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users.map { it.copy() }
        val creditors = users.filter { it.balance > 0 }.sortedByDescending { it.balance }.toMutableList()
        val debtors = users.filter { it.balance < 0 }.sortedByDescending { -it.balance }.toMutableList()
        val transactions = mutableListOf<AlignmentTransaction>()

        while (creditors.isNotEmpty() && debtors.isNotEmpty()) {
            val creditor = creditors.removeAt(0)
            val debtor = debtors.removeAt(0)
            val amount = minOf(creditor.balance, -debtor.balance)

            transactions.add(AlignmentTransaction(debtor.name, creditor.name, amount))

            val newCreditorBalance = creditor.balance - amount
            val newDebtorBalance = debtor.balance + amount

            if (newCreditorBalance > 0) {
                creditors.add(creditor.copy(balance = newCreditorBalance))
            } else if (newDebtorBalance < 0) {
                debtors.add(debtor.copy(balance = newDebtorBalance))
            }

            creditors.sortByDescending { it.balance }
            debtors.sortByDescending { -it.balance }
        }

        return transactions
    }
}


