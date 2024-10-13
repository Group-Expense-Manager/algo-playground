package pl.edu.agh.gem.settlement

import pl.edu.agh.gem.settlement.SettlementInput
import pl.edu.agh.gem.settlement.SettlementInterface
import pl.edu.agh.gem.settlement.Settlement
import java.math.BigDecimal

class GreedySettlement : SettlementInterface {
    override fun run(settlementInput: SettlementInput): List<Settlement> {
        val users = settlementInput.balances

        val debtors = mutableListOf<Pair<String, BigDecimal>>()
        val creditors = mutableListOf<Pair<String, BigDecimal>>()

        for (user in users) {
            when {
                user.value < BigDecimal.ZERO -> debtors.add(Pair(user.userId, -user.value))
                user.value > BigDecimal.ZERO -> creditors.add(Pair(user.userId, user.value))
            }
        }

        val transactions = mutableListOf<Settlement>()
        var debtorIndex = 0
        var creditorIndex = 0

        while (debtorIndex < debtors.size && creditorIndex < creditors.size) {
            val debtor = debtors[debtorIndex]
            val creditor = creditors[creditorIndex]

            val transferAmount = minOf(debtor.second, creditor.second)
            transactions.add(Settlement(debtor.first, creditor.first, transferAmount))

            debtors[debtorIndex] = Pair(debtor.first, debtor.second - transferAmount)
            creditors[creditorIndex] = Pair(creditor.first, creditor.second - transferAmount)

            if (debtors[debtorIndex].second == BigDecimal.ZERO) {
                debtorIndex++
            }

            if (creditors[creditorIndex].second == BigDecimal.ZERO) {
                creditorIndex++
            }
        }

        return transactions
    }
}