package pl.edu.agh.gem.settlement

import java.math.BigDecimal

class DebtRoundingPairing : SettlementInterface {
    override fun run(settlementInput: SettlementInput): List<Settlement> {
        val users = settlementInput.balances.map { it.copy() }
        val creditors = users.filter { it.value > BigDecimal.ZERO }.sortedByDescending { it.value }.toMutableList()
        val debtors = users.filter { it.value < BigDecimal.ZERO }.sortedByDescending { -it.value }.toMutableList()
        val transactions = mutableListOf<Settlement>()

        while (creditors.isNotEmpty() && debtors.isNotEmpty()) {
            val creditor = creditors.removeAt(0)
            val debtor = debtors.removeAt(0)
            val amount = minOf(creditor.value, -debtor.value)

            transactions.add(Settlement(debtor.userId, creditor.userId, amount))

            val newCreditorBalance = creditor.value - amount
            val newDebtorBalance = debtor.value + amount

            if (newCreditorBalance > BigDecimal.ZERO) {
                creditors.add(creditor.copy(value = newCreditorBalance))
            } else if (newDebtorBalance < BigDecimal.ZERO) {
                debtors.add(debtor.copy(value = newDebtorBalance))
            }

            creditors.sortByDescending { it.value }
            debtors.sortByDescending { -it.value }
        }

        return transactions
    }
}


