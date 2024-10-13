package pl.edu.agh.gem.settlement

import java.math.BigDecimal

interface SettlementInterface {
    fun run(settlementInput: SettlementInput): List<Settlement>
}

data class SettlementInput(
    val balances: List<Balance>
)

data class Balance(
    val userId: String,
    val value: BigDecimal,
)

data class Settlement(
    val nameFrom: String,
    val nameTo: String,
    val value: BigDecimal,
)