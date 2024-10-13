package pl.edu.agh.gem.settlement

import pl.edu.agh.gem.settlement.TestInput.inputList
import pl.edu.agh.gem.settlement.TestInput.solversList
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

object TestInput {
    val solversList = listOf(
        GreedySettlement(),
        DebtRoundingPairing(),
        SetPartitionSettlement()
    )
    val inputList = listOf(
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-462")),
                Balance(userId = "User 1", value = BigDecimal("462"))
            )
        ),        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("248")),
                Balance(userId = "User 1", value = BigDecimal("-183")),
                Balance(userId = "User 2", value = BigDecimal("-65"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-345")),
                Balance(userId = "User 1", value = BigDecimal("96")),
                Balance(userId = "User 2", value = BigDecimal("249"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("1735")),
                Balance(userId = "User 1", value = BigDecimal("-432")),
                Balance(userId = "User 2", value = BigDecimal("-1303"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-1207")),
                Balance(userId = "User 1", value = BigDecimal("578")),
                Balance(userId = "User 2", value = BigDecimal("629"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("789")),
                Balance(userId = "User 1", value = BigDecimal("-789"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-999")),
                Balance(userId = "User 1", value = BigDecimal("347")),
                Balance(userId = "User 2", value = BigDecimal("652"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("555")),
                Balance(userId = "User 1", value = BigDecimal("-233")),
                Balance(userId = "User 2", value = BigDecimal("-322"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("0")),
                Balance(userId = "User 1", value = BigDecimal("0")),
                Balance(userId = "User 2", value = BigDecimal("0"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-1")),
                Balance(userId = "User 1", value = BigDecimal("-1")),
                Balance(userId = "User 2", value = BigDecimal("1")),
                Balance(userId = "User 3", value = BigDecimal("1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-999")),
                Balance(userId = "User 1", value = BigDecimal("999"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-4")),
                Balance(userId = "User 1", value = BigDecimal("4")),
                Balance(userId = "User 2", value = BigDecimal("0"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-7")),
                Balance(userId = "User 1", value = BigDecimal("3")),
                Balance(userId = "User 2", value = BigDecimal("4"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-19")),
                Balance(userId = "User 1", value = BigDecimal("9")),
                Balance(userId = "User 2", value = BigDecimal("10")),
                Balance(userId = "User 3", value = BigDecimal("0"))
            )
        ),

        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-34")),
            Balance(userId = "User 1", value = BigDecimal("8")),
            Balance(userId = "User 2", value = BigDecimal("14")),
            Balance(userId = "User 3", value = BigDecimal("6")),
            Balance(userId = "User 4", value = BigDecimal("2")),
            Balance(userId = "User 5", value = BigDecimal("4"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-62")),
            Balance(userId = "User 1", value = BigDecimal("23")),
            Balance(userId = "User 2", value = BigDecimal("14")),
            Balance(userId = "User 3", value = BigDecimal("10")),
            Balance(userId = "User 4", value = BigDecimal("8")),
            Balance(userId = "User 5", value = BigDecimal("4")),
            Balance(userId = "User 6", value = BigDecimal("3"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-78")),
            Balance(userId = "User 1", value = BigDecimal("31")),
            Balance(userId = "User 2", value = BigDecimal("13")),
            Balance(userId = "User 3", value = BigDecimal("12")),
            Balance(userId = "User 4", value = BigDecimal("8")),
            Balance(userId = "User 5", value = BigDecimal("10")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-90")),
            Balance(userId = "User 1", value = BigDecimal("39")),
            Balance(userId = "User 2", value = BigDecimal("20")),
            Balance(userId = "User 3", value = BigDecimal("13")),
            Balance(userId = "User 4", value = BigDecimal("5")),
            Balance(userId = "User 5", value = BigDecimal("7")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("2")),
            Balance(userId = "User 8", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-111")),
            Balance(userId = "User 1", value = BigDecimal("41")),
            Balance(userId = "User 2", value = BigDecimal("29")),
            Balance(userId = "User 3", value = BigDecimal("25")),
            Balance(userId = "User 4", value = BigDecimal("13")),
            Balance(userId = "User 5", value = BigDecimal("3")),
            Balance(userId = "User 6", value = BigDecimal("0")),
            Balance(userId = "User 7", value = BigDecimal("0")),
            Balance(userId = "User 8", value = BigDecimal("0")),
            Balance(userId = "User 9", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-127")),
            Balance(userId = "User 1", value = BigDecimal("45")),
            Balance(userId = "User 2", value = BigDecimal("28")),
            Balance(userId = "User 3", value = BigDecimal("18")),
            Balance(userId = "User 4", value = BigDecimal("22")),
            Balance(userId = "User 5", value = BigDecimal("8")),
            Balance(userId = "User 6", value = BigDecimal("6")),
            Balance(userId = "User 7", value = BigDecimal("0")),
            Balance(userId = "User 8", value = BigDecimal("0")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-144")),
            Balance(userId = "User 1", value = BigDecimal("50")),
            Balance(userId = "User 2", value = BigDecimal("34")),
            Balance(userId = "User 3", value = BigDecimal("10")),
            Balance(userId = "User 4", value = BigDecimal("35")),
            Balance(userId = "User 5", value = BigDecimal("6")),
            Balance(userId = "User 6", value = BigDecimal("5")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("1")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-158")),
            Balance(userId = "User 1", value = BigDecimal("51")),
            Balance(userId = "User 2", value = BigDecimal("42")),
            Balance(userId = "User 3", value = BigDecimal("22")),
            Balance(userId = "User 4", value = BigDecimal("21")),
            Balance(userId = "User 5", value = BigDecimal("8")),
            Balance(userId = "User 6", value = BigDecimal("6")),
            Balance(userId = "User 7", value = BigDecimal("5")),
            Balance(userId = "User 8", value = BigDecimal("3")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-176")),
            Balance(userId = "User 1", value = BigDecimal("62")),
            Balance(userId = "User 2", value = BigDecimal("42")),
            Balance(userId = "User 3", value = BigDecimal("20")),
            Balance(userId = "User 4", value = BigDecimal("28")),
            Balance(userId = "User 5", value = BigDecimal("12")),
            Balance(userId = "User 6", value = BigDecimal("8")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("1")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-190")),
            Balance(userId = "User 1", value = BigDecimal("65")),
            Balance(userId = "User 2", value = BigDecimal("33")),
            Balance(userId = "User 3", value = BigDecimal("66")),
            Balance(userId = "User 4", value = BigDecimal("12")),
            Balance(userId = "User 5", value = BigDecimal("8")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("2")),
            Balance(userId = "User 8", value = BigDecimal("0")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0")),
            Balance(userId = "User 14", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-203")),
            Balance(userId = "User 1", value = BigDecimal("68")),
            Balance(userId = "User 2", value = BigDecimal("29")),
            Balance(userId = "User 3", value = BigDecimal("69")),
            Balance(userId = "User 4", value = BigDecimal("15")),
            Balance(userId = "User 5", value = BigDecimal("12")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("2")),
            Balance(userId = "User 9", value = BigDecimal("1")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0")),
            Balance(userId = "User 14", value = BigDecimal("0")),
            Balance(userId = "User 15", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-221")),
            Balance(userId = "User 1", value = BigDecimal("70")),
            Balance(userId = "User 2", value = BigDecimal("34")),
            Balance(userId = "User 3", value = BigDecimal("82")),
            Balance(userId = "User 4", value = BigDecimal("12")),
            Balance(userId = "User 5", value = BigDecimal("11")),
            Balance(userId = "User 6", value = BigDecimal("6")),
            Balance(userId = "User 7", value = BigDecimal("4")),
            Balance(userId = "User 8", value = BigDecimal("2")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0")),
            Balance(userId = "User 14", value = BigDecimal("0")),
            Balance(userId = "User 15", value = BigDecimal("0")),
            Balance(userId = "User 16", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-240")),
            Balance(userId = "User 1", value = BigDecimal("76")),
            Balance(userId = "User 2", value = BigDecimal("38")),
            Balance(userId = "User 3", value = BigDecimal("94")),
            Balance(userId = "User 4", value = BigDecimal("13")),
            Balance(userId = "User 5", value = BigDecimal("9")),
            Balance(userId = "User 6", value = BigDecimal("5")),
            Balance(userId = "User 7", value = BigDecimal("4")),
            Balance(userId = "User 8", value = BigDecimal("1")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0")),
            Balance(userId = "User 14", value = BigDecimal("0")),
            Balance(userId = "User 15", value = BigDecimal("0")),
            Balance(userId = "User 16", value = BigDecimal("0")),
            Balance(userId = "User 17", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-250")),
            Balance(userId = "User 1", value = BigDecimal("70")),
            Balance(userId = "User 2", value = BigDecimal("35")),
            Balance(userId = "User 3", value = BigDecimal("100")),
            Balance(userId = "User 4", value = BigDecimal("17")),
            Balance(userId = "User 5", value = BigDecimal("13")),
            Balance(userId = "User 6", value = BigDecimal("11")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("1")),
            Balance(userId = "User 9", value = BigDecimal("0")),
            Balance(userId = "User 10", value = BigDecimal("0")),
            Balance(userId = "User 11", value = BigDecimal("0")),
            Balance(userId = "User 12", value = BigDecimal("0")),
            Balance(userId = "User 13", value = BigDecimal("0")),
            Balance(userId = "User 14", value = BigDecimal("0")),
            Balance(userId = "User 15", value = BigDecimal("0")),
            Balance(userId = "User 16", value = BigDecimal("0")),
            Balance(userId = "User 17", value = BigDecimal("0")),
            Balance(userId = "User 18", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-1")),
            Balance(userId = "User 1", value = BigDecimal("1"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-4")),
            Balance(userId = "User 1", value = BigDecimal("4")),
            Balance(userId = "User 2", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-7")),
            Balance(userId = "User 1", value = BigDecimal("3")),
            Balance(userId = "User 2", value = BigDecimal("4"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-19")),
            Balance(userId = "User 1", value = BigDecimal("9")),
            Balance(userId = "User 2", value = BigDecimal("10")),
            Balance(userId = "User 3", value = BigDecimal("0"))
        )),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-21")),
            Balance(userId = "User 1", value = BigDecimal("7")),
            Balance(userId = "User 2", value = BigDecimal("11")),
            Balance(userId = "User 3", value = BigDecimal("3")),
            Balance(userId = "User 4", value = BigDecimal("0"))
        )),

    SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-34")),
                Balance(userId = "User 1", value = BigDecimal("8")),
                Balance(userId = "User 2", value = BigDecimal("-6")),
                Balance(userId = "User 3", value = BigDecimal("6")),
                Balance(userId = "User 4", value = BigDecimal("2")),
                Balance(userId = "User 5", value = BigDecimal("24"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-62")),
                Balance(userId = "User 1", value = BigDecimal("23")),
                Balance(userId = "User 2", value = BigDecimal("46")),
                Balance(userId = "User 3", value = BigDecimal("20")),
                Balance(userId = "User 4", value = BigDecimal("-32")),
                Balance(userId = "User 5", value = BigDecimal("4")),
                Balance(userId = "User 6", value = BigDecimal("1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-78")),
                Balance(userId = "User 1", value = BigDecimal("31")),
                Balance(userId = "User 2", value = BigDecimal("6")),
                Balance(userId = "User 3", value = BigDecimal("12")),
                Balance(userId = "User 4", value = BigDecimal("14")),
                Balance(userId = "User 5", value = BigDecimal("10")),
                Balance(userId = "User 6", value = BigDecimal("4")),
                Balance(userId = "User 7", value = BigDecimal("1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-90")),
                Balance(userId = "User 1", value = BigDecimal("39")),
                Balance(userId = "User 2", value = BigDecimal("13")),
                Balance(userId = "User 3", value = BigDecimal("13")),
                Balance(userId = "User 4", value = BigDecimal("11")),
                Balance(userId = "User 5", value = BigDecimal("7")),
                Balance(userId = "User 6", value = BigDecimal("4")),
                Balance(userId = "User 7", value = BigDecimal("2")),
                Balance(userId = "User 8", value = BigDecimal("1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-111")),
                Balance(userId = "User 1", value = BigDecimal("41")),
                Balance(userId = "User 2", value = BigDecimal("31")),
                Balance(userId = "User 3", value = BigDecimal("25")),
                Balance(userId = "User 4", value = BigDecimal("10")),
                Balance(userId = "User 5", value = BigDecimal("3")),
                Balance(userId = "User 6", value = BigDecimal("1")),
                Balance(userId = "User 7", value = BigDecimal("1")),
                Balance(userId = "User 8", value = BigDecimal("-4")),
                Balance(userId = "User 9", value = BigDecimal("3"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-127")),
                Balance(userId = "User 1", value = BigDecimal("45")),
                Balance(userId = "User 2", value = BigDecimal("33")),
                Balance(userId = "User 3", value = BigDecimal("18")),
                Balance(userId = "User 4", value = BigDecimal("12")),
                Balance(userId = "User 5", value = BigDecimal("8")),
                Balance(userId = "User 6", value = BigDecimal("6")),
                Balance(userId = "User 7", value = BigDecimal("4")),
                Balance(userId = "User 8", value = BigDecimal("2")),
                Balance(userId = "User 9", value = BigDecimal("3")),
                Balance(userId = "User 10", value = BigDecimal("-4"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-154")),
                Balance(userId = "User 1", value = BigDecimal("50")),
                Balance(userId = "User 2", value = BigDecimal("66")),
                Balance(userId = "User 3", value = BigDecimal("10")),
                Balance(userId = "User 4", value = BigDecimal("12")),
                Balance(userId = "User 5", value = BigDecimal("8")),
                Balance(userId = "User 6", value = BigDecimal("6")),
                Balance(userId = "User 7", value = BigDecimal("3")),
                Balance(userId = "User 8", value = BigDecimal("1")),
                Balance(userId = "User 9", value = BigDecimal("-1")),
                Balance(userId = "User 10", value = BigDecimal("-2")),
                Balance(userId = "User 11", value = BigDecimal("1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-158")),
                Balance(userId = "User 1", value = BigDecimal("51")),
                Balance(userId = "User 2", value = BigDecimal("42")),
                Balance(userId = "User 3", value = BigDecimal("20")),
                Balance(userId = "User 4", value = BigDecimal("18")),
                Balance(userId = "User 5", value = BigDecimal("12")),
                Balance(userId = "User 6", value = BigDecimal("6")),
                Balance(userId = "User 7", value = BigDecimal("5")),
                Balance(userId = "User 8", value = BigDecimal("4")),
                Balance(userId = "User 9", value = BigDecimal("3")),
                Balance(userId = "User 10", value = BigDecimal("-1")),
                Balance(userId = "User 11", value = BigDecimal("-1")),
                Balance(userId = "User 12", value = BigDecimal("-1"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-176")),
                Balance(userId = "User 1", value = BigDecimal("62")),
                Balance(userId = "User 2", value = BigDecimal("67")),
                Balance(userId = "User 3", value = BigDecimal("20")),
                Balance(userId = "User 4", value = BigDecimal("18")),
                Balance(userId = "User 5", value = BigDecimal("12")),
                Balance(userId = "User 6", value = BigDecimal("8")),
                Balance(userId = "User 7", value = BigDecimal("3")),
                Balance(userId = "User 8", value = BigDecimal("1")),
                Balance(userId = "User 9", value = BigDecimal("-1")),
                Balance(userId = "User 10", value = BigDecimal("-2")),
                Balance(userId = "User 11", value = BigDecimal("-3")),
                Balance(userId = "User 12", value = BigDecimal("-4")),
                Balance(userId = "User 13", value = BigDecimal("-5"))
            )
        ),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-190")),
                Balance(userId = "User 1", value = BigDecimal("65")),
                Balance(userId = "User 2", value = BigDecimal("33")),
                Balance(userId = "User 3", value = BigDecimal("17")),
                Balance(userId = "User 4", value = BigDecimal("81")),
                Balance(userId = "User 5", value = BigDecimal("8")),
                Balance(userId = "User 6", value = BigDecimal("4")),
                Balance(userId = "User 7", value = BigDecimal("2")),
                Balance(userId = "User 8", value = BigDecimal("1")),
                Balance(userId = "User 9", value = BigDecimal("-1")),
                Balance(userId = "User 10", value = BigDecimal("-2")),
                Balance(userId = "User 11", value = BigDecimal("-3")),
                Balance(userId = "User 12", value = BigDecimal("-4")),
                Balance(userId = "User 13", value = BigDecimal("-5")),
                Balance(userId = "User 14", value = BigDecimal("-6"))
            )
        ),
        SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-203")),
            Balance(userId = "User 1", value = BigDecimal("68")),
            Balance(userId = "User 2", value = BigDecimal("100")),
            Balance(userId = "User 3", value = BigDecimal("19")),
            Balance(userId = "User 4", value = BigDecimal("15")),
            Balance(userId = "User 5", value = BigDecimal("12")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("2")),
            Balance(userId = "User 9", value = BigDecimal("1")),
            Balance(userId = "User 10", value = BigDecimal("-1")),
            Balance(userId = "User 11", value = BigDecimal("-2")),
            Balance(userId = "User 12", value = BigDecimal("-3")),
            Balance(userId = "User 13", value = BigDecimal("-4")),
            Balance(userId = "User 14", value = BigDecimal("-5")),
            Balance(userId = "User 15", value = BigDecimal("-6"))
        )),

                SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-215")),
            Balance(userId = "User 1", value = BigDecimal("70")),
            Balance(userId = "User 2", value = BigDecimal("131")),
            Balance(userId = "User 3", value = BigDecimal("21")),
            Balance(userId = "User 4", value = BigDecimal("11")),
            Balance(userId = "User 5", value = BigDecimal("10")),
            Balance(userId = "User 6", value = BigDecimal("4")),
            Balance(userId = "User 7", value = BigDecimal("3")),
            Balance(userId = "User 8", value = BigDecimal("1")),
            Balance(userId = "User 9", value = BigDecimal("-1")),
            Balance(userId = "User 10", value = BigDecimal("-2")),
            Balance(userId = "User 11", value = BigDecimal("-3")),
            Balance(userId = "User 12", value = BigDecimal("-4")),
            Balance(userId = "User 13", value = BigDecimal("-5")),
            Balance(userId = "User 14", value = BigDecimal("-6")),
            Balance(userId = "User 15", value = BigDecimal("-7")),
            Balance(userId = "User 16", value = BigDecimal("-8"))
        )),

                SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("-223")),
            Balance(userId = "User 1", value = BigDecimal("71")),
            Balance(userId = "User 2", value = BigDecimal("170")),
            Balance(userId = "User 3", value = BigDecimal("19")),
            Balance(userId = "User 4", value = BigDecimal("12")),
            Balance(userId = "User 5", value = BigDecimal("3")),
            Balance(userId = "User 6", value = BigDecimal("2")),
            Balance(userId = "User 7", value = BigDecimal("1")),
            Balance(userId = "User 8", value = BigDecimal("-1")),
            Balance(userId = "User 9", value = BigDecimal("-2")),
            Balance(userId = "User 10", value = BigDecimal("-3")),
            Balance(userId = "User 11", value = BigDecimal("-4")),
            Balance(userId = "User 12", value = BigDecimal("-5")),
            Balance(userId = "User 13", value = BigDecimal("-6")),
            Balance(userId = "User 14", value = BigDecimal("-7")),
            Balance(userId = "User 15", value = BigDecimal("-8")),
            Balance(userId = "User 16", value = BigDecimal("-9")),
            Balance(userId = "User 17", value = BigDecimal("-10"))
        )),

                SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("120")),
            Balance(userId = "User 1", value = BigDecimal("270")),
            Balance(userId = "User 2", value = BigDecimal("-150")),
            Balance(userId = "User 3", value = BigDecimal("315")),
            Balance(userId = "User 4", value = BigDecimal("-420")),
            Balance(userId = "User 5", value = BigDecimal("540")),
            Balance(userId = "User 6", value = BigDecimal("-620")),
            Balance(userId = "User 7", value = BigDecimal("110")),
            Balance(userId = "User 8", value = BigDecimal("-115")),
            Balance(userId = "User 9", value = BigDecimal("-50"))
        )),

                SettlementInput(balances = listOf(
            Balance(userId = "User 0", value = BigDecimal("12")),
            Balance(userId = "User 1", value = BigDecimal("-24")),
            Balance(userId = "User 2", value = BigDecimal("12")),
            Balance(userId = "User 3", value = BigDecimal("-65")),
            Balance(userId = "User 4", value = BigDecimal("44")),
            Balance(userId = "User 5", value = BigDecimal("19")),
            Balance(userId = "User 6", value = BigDecimal("2")),
            Balance(userId = "User 7", value = BigDecimal("13")),
            Balance(userId = "User 8", value = BigDecimal("2")),
            Balance(userId = "User 9", value = BigDecimal("-23")),
            Balance(userId = "User 10", value = BigDecimal("18")),
            Balance(userId = "User 11", value = BigDecimal("-20")),
            Balance(userId = "User 12", value = BigDecimal("12")),
            Balance(userId = "User 13", value = BigDecimal("-2")),
            Balance(userId = "User 14", value = BigDecimal("-20")),
            Balance(userId = "User 15", value = BigDecimal("10")),
            Balance(userId = "User 16", value = BigDecimal("-8")),
            Balance(userId = "User 17", value = BigDecimal("19")),
            Balance(userId = "User 18", value = BigDecimal("-2")),
            Balance(userId = "User 19", value = BigDecimal("1"))
        )),
        SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("-440")),
                Balance(userId = "User 1", value = BigDecimal("-120")),
                Balance(userId = "User 2", value = BigDecimal("-240")),
                Balance(userId = "User 3", value = BigDecimal("-145")),
                Balance(userId = "User 4", value = BigDecimal("-85")),
                Balance(userId = "User 5", value = BigDecimal("-265")),
                Balance(userId = "User 6", value = BigDecimal("-85")),
                Balance(userId = "User 7", value = BigDecimal("165")),
                Balance(userId = "User 8", value = BigDecimal("-95")),
                Balance(userId = "User 9", value = BigDecimal("120")),
                Balance(userId = "User 10", value = BigDecimal("-50")),
                Balance(userId = "User 11", value = BigDecimal("235")),
                Balance(userId = "User 12", value = BigDecimal("-260")),
                Balance(userId = "User 13", value = BigDecimal("340")),
                Balance(userId = "User 14", value = BigDecimal("-470")),
                Balance(userId = "User 15", value = BigDecimal("510")),
                Balance(userId = "User 16", value = BigDecimal("-310")),
                Balance(userId = "User 17", value = BigDecimal("420")),
                Balance(userId = "User 18", value = BigDecimal("-185")),
                Balance(userId = "User 19", value = BigDecimal("510")),
                Balance(userId = "User 20", value = BigDecimal("225")),
                Balance(userId = "User 21", value = BigDecimal("-150")),
                Balance(userId = "User 22", value = BigDecimal("375"))
            )
        ),

        SettlementInput(
                balances = listOf(
                    Balance(userId = "User 0", value = BigDecimal("-450")),
                    Balance(userId = "User 1", value = BigDecimal("-130")),
                    Balance(userId = "User 2", value = BigDecimal("-240")),
                    Balance(userId = "User 3", value = BigDecimal("-145")),
                    Balance(userId = "User 4", value = BigDecimal("-85")),
                    Balance(userId = "User 5", value = BigDecimal("-265")),
                    Balance(userId = "User 6", value = BigDecimal("-85")),
                    Balance(userId = "User 7", value = BigDecimal("165")),
                    Balance(userId = "User 8", value = BigDecimal("-95")),
                    Balance(userId = "User 9", value = BigDecimal("120")),
                    Balance(userId = "User 10", value = BigDecimal("-50")),
                    Balance(userId = "User 11", value = BigDecimal("235")),
                    Balance(userId = "User 12", value = BigDecimal("-260")),
                    Balance(userId = "User 13", value = BigDecimal("340")),
                    Balance(userId = "User 14", value = BigDecimal("-470")),
                    Balance(userId = "User 15", value = BigDecimal("510")),
                    Balance(userId = "User 16", value = BigDecimal("-310")),
                    Balance(userId = "User 17", value = BigDecimal("420")),
                    Balance(userId = "User 18", value = BigDecimal("-185")),
                    Balance(userId = "User 19", value = BigDecimal("335")),
                    Balance(userId = "User 20", value = BigDecimal("-245")),
                    Balance(userId = "User 21", value = BigDecimal("110")),
                    Balance(userId = "User 22", value = BigDecimal("-80")),
                    Balance(userId = "User 23", value = BigDecimal("410")),
                    Balance(userId = "User 24", value = BigDecimal("-385")),
                    Balance(userId = "User 25", value = BigDecimal("225")),
                    Balance(userId = "User 26", value = BigDecimal("-150")),
                    Balance(userId = "User 27", value = BigDecimal("475")),
                    Balance(userId = "User 28", value = BigDecimal("-120")),
                    Balance(userId = "User 29", value = BigDecimal("365")),
                    Balance(userId = "User 30", value = BigDecimal("-430")),
                    Balance(userId = "User 31", value = BigDecimal("510")),
                    Balance(userId = "User 32", value = BigDecimal("-240")),
                    Balance(userId = "User 33", value = BigDecimal("160")),
                    Balance(userId = "User 34", value = BigDecimal("120")),
                    Balance(userId = "User 35", value = BigDecimal("-335")),
                    Balance(userId = "User 36", value = BigDecimal("170")),
                    Balance(userId = "User 37", value = BigDecimal("-250")),
                    Balance(userId = "User 38", value = BigDecimal("415")),
                    Balance(userId = "User 39", value = BigDecimal("-60")),
                    Balance(userId = "User 40", value = BigDecimal("340")),
                    Balance(userId = "User 41", value = BigDecimal("-470")),
                    Balance(userId = "User 42", value = BigDecimal("255")),
                    Balance(userId = "User 43", value = BigDecimal("-315")),
                    Balance(userId = "User 44", value = BigDecimal("510")),
                    Balance(userId = "User 45", value = BigDecimal("-510")),
                    Balance(userId = "User 46", value = BigDecimal("390")),
                    Balance(userId = "User 47", value = BigDecimal("-170")),
                    Balance(userId = "User 48", value = BigDecimal("320")),
                    Balance(userId = "User 49", value = BigDecimal("-370"))
                )
        )


,SettlementInput(
            balances = listOf(
                Balance(userId = "User 0", value = BigDecimal("340")),
                Balance(userId = "User 1", value = BigDecimal("-95")),
                Balance(userId = "User 2", value = BigDecimal("-956")),
                Balance(userId = "User 3", value = BigDecimal("-78")),
                Balance(userId = "User 4", value = BigDecimal("129")),
                Balance(userId = "User 5", value = BigDecimal("-46")),
                Balance(userId = "User 6", value = BigDecimal("183")),
                Balance(userId = "User 7", value = BigDecimal("-32")),
                Balance(userId = "User 8", value = BigDecimal("89")),
                Balance(userId = "User 9", value = BigDecimal("-59")),
                Balance(userId = "User 10", value = BigDecimal("243")),
                Balance(userId = "User 11", value = BigDecimal("-102")),
                Balance(userId = "User 12", value = BigDecimal("67")),
                Balance(userId = "User 13", value = BigDecimal("-98")),
                Balance(userId = "User 14", value = BigDecimal("190")),
                Balance(userId = "User 15", value = BigDecimal("-300")),
                Balance(userId = "User 16", value = BigDecimal("270")),
                Balance(userId = "User 17", value = BigDecimal("-320")),
                Balance(userId = "User 18", value = BigDecimal("180")),
                Balance(userId = "User 19", value = BigDecimal("-60")),
                Balance(userId = "User 20", value = BigDecimal("45")),
                Balance(userId = "User 21", value = BigDecimal("150")),
                Balance(userId = "User 22", value = BigDecimal("-400")),
                Balance(userId = "User 23", value = BigDecimal("130")),
                Balance(userId = "User 24", value = BigDecimal("-210")),
                Balance(userId = "User 25", value = BigDecimal("370")),
                Balance(userId = "User 26", value = BigDecimal("-185")),
                Balance(userId = "User 27", value = BigDecimal("195")),
                Balance(userId = "User 28", value = BigDecimal("-65")),
                Balance(userId = "User 29", value = BigDecimal("75")),
                Balance(userId = "User 30", value = BigDecimal("-55")),
                Balance(userId = "User 31", value = BigDecimal("350")),
                Balance(userId = "User 32", value = BigDecimal("-30")),
                Balance(userId = "User 33", value = BigDecimal("40")),
                Balance(userId = "User 34", value = BigDecimal("-100")),
                Balance(userId = "User 35", value = BigDecimal("110")),
                Balance(userId = "User 36", value = BigDecimal("-90")),
                Balance(userId = "User 37", value = BigDecimal("25")),
                Balance(userId = "User 38", value = BigDecimal("-25")),
                Balance(userId = "User 39", value = BigDecimal("195")),
                Balance(userId = "User 40", value = BigDecimal("-115")),
                Balance(userId = "User 41", value = BigDecimal("50")),
                Balance(userId = "User 42", value = BigDecimal("-50")),
                Balance(userId = "User 43", value = BigDecimal("300")),
                Balance(userId = "User 44", value = BigDecimal("-120")),
                Balance(userId = "User 45", value = BigDecimal("215")),
                Balance(userId = "User 46", value = BigDecimal("-215")),
                Balance(userId = "User 47", value = BigDecimal("125")),
                Balance(userId = "User 48", value = BigDecimal("-205")),
                Balance(userId = "User 49", value = BigDecimal("170")),
                Balance(userId = "User 50", value = BigDecimal("-370")),
                Balance(userId = "User 51", value = BigDecimal("295")),
                Balance(userId = "User 52", value = BigDecimal("-295")),
                Balance(userId = "User 53", value = BigDecimal("55")),
                Balance(userId = "User 54", value = BigDecimal("-35")),
                Balance(userId = "User 55", value = BigDecimal("85")),
                Balance(userId = "User 56", value = BigDecimal("-60")),
                Balance(userId = "User 57", value = BigDecimal("230")),
                Balance(userId = "User 58", value = BigDecimal("-230")),
                Balance(userId = "User 59", value = BigDecimal("190")),
                Balance(userId = "User 60", value = BigDecimal("-190")),
                Balance(userId = "User 61", value = BigDecimal("140")),
                Balance(userId = "User 62", value = BigDecimal("-140")),
                Balance(userId = "User 63", value = BigDecimal("230")),
                Balance(userId = "User 64", value = BigDecimal("-130")),
                Balance(userId = "User 65", value = BigDecimal("210")),
                Balance(userId = "User 66", value = BigDecimal("-210")),
                Balance(userId = "User 67", value = BigDecimal("110")),
                Balance(userId = "User 68", value = BigDecimal("-110")),
                Balance(userId = "User 69", value = BigDecimal("60")),
                Balance(userId = "User 70", value = BigDecimal("-60")),
                Balance(userId = "User 71", value = BigDecimal("30")),
                Balance(userId = "User 72", value = BigDecimal("-30")),
                Balance(userId = "User 73", value = BigDecimal("180")),
                Balance(userId = "User 74", value = BigDecimal("-180")),
                Balance(userId = "User 75", value = BigDecimal("400")),
                Balance(userId = "User 76", value = BigDecimal("-400")),
                Balance(userId = "User 77", value = BigDecimal("250")),
                Balance(userId = "User 78", value = BigDecimal("-250")),
                Balance(userId = "User 79", value = BigDecimal("150")),
                Balance(userId = "User 80", value = BigDecimal("-150")),
                Balance(userId = "User 81", value = BigDecimal("80")),
                Balance(userId = "User 82", value = BigDecimal("-80")),
                Balance(userId = "User 83", value = BigDecimal("20")),
                Balance(userId = "User 84", value = BigDecimal("-20")),
                Balance(userId = "User 85", value = BigDecimal("10")),
                Balance(userId = "User 86", value = BigDecimal("-10")),
                Balance(userId = "User 87", value = BigDecimal("30")),
                Balance(userId = "User 88", value = BigDecimal("-30")),
                Balance(userId = "User 89", value = BigDecimal("60")),
                Balance(userId = "User 90", value = BigDecimal("-60")),
                Balance(userId = "User 91", value = BigDecimal("45")),
                Balance(userId = "User 92", value = BigDecimal("-45")),
                Balance(userId = "User 93", value = BigDecimal("75")),
                Balance(userId = "User 94", value = BigDecimal("-75")),
                Balance(userId = "User 95", value = BigDecimal("85")),
                Balance(userId = "User 96", value = BigDecimal("-85")),
                Balance(userId = "User 97", value = BigDecimal("100")),
                Balance(userId = "User 98", value = BigDecimal("-110")),
                Balance(userId = "User 99", value = BigDecimal("10"))
            )
        ),
        )
}

fun checkCorrect(settlementInput: SettlementInput, result:List<Settlement>):Boolean{
    val users = settlementInput.balances
    val userMap = users.associate { it.userId to it.value }
    val userMap2 = users.associate { it.userId to BigDecimal.ZERO }.toMutableMap()
    result.forEach {
        userMap2[it.nameFrom] = userMap2[it.nameFrom]!! - it.value
        userMap2[it.nameTo] = userMap2[it.nameTo]!! + it.value
    }
    return userMap == userMap2
}

fun scoreResult(settlementInput: SettlementInput, result:List<Settlement>, elapsedTime: Long):Long{
    val baseMultiplayer =  settlementInput.balances.size - result.size -1
    return (baseMultiplayer).toLong()
}

class SettlementTestException(settlementInput: SettlementInput, result:List<Settlement>):RuntimeException("Test failed for input $settlementInput and result $result")

fun main() {
    val bestScore = mutableMapOf<Long,List<Pair<String,Long>>>()
    val bestResult = mutableMapOf<Long,List<Pair<String,Long>>>()
    val bestTime = mutableMapOf<Long,List<Pair<String,Long>>>()
    val scoreList = mutableListOf<String>()
    val formatter = NumberFormat.getInstance(Locale.US)
    solversList.forEach { solver ->
        println("=====================================================================================================")
        println("Solver: ${solver.javaClass.simpleName}")
        println("=====================================================================================================")
        var totalScore = 0L
        var index = 0L
        inputList.forEach { input ->
            val currentTime = System.nanoTime()
            val result = solver.run(input)
            val elapsedTime = System.nanoTime() - currentTime
            if(!checkCorrect(input,result)) throw SettlementTestException(input,result)
            val score = scoreResult(input,result,elapsedTime)
            totalScore += score
            println("------------------------------------")
            println("Input: $input")
            println("Elapsed time: $elapsedTime ns")
            println("Users count: ${input.balances.size}")
            println("Transactions count: ${result.size}")
            println("Score: $score")
            println("Result: $result")
            println("------------------------------------")
            if(!bestScore.containsKey(index) || bestScore[index]!!.first().second <= score){
                if(bestScore[index]?.first()?.second == score){
                    bestScore[index] = bestScore[index]!! + Pair(solver.javaClass.simpleName,score)
                }else
                    bestScore[index] = listOf(Pair(solver.javaClass.simpleName,score))
            }
            if(!bestResult.containsKey(index) || bestResult[index]!!.first().second >= result.size.toLong()){
                if(bestResult[index]?.first()?.second == result.size.toLong()){
                    bestResult[index] = bestResult[index]!! + Pair(solver.javaClass.simpleName,result.size.toLong())
                }else
                    bestResult[index] = listOf(Pair(solver.javaClass.simpleName,result.size.toLong()))
            }
            if(!bestTime.containsKey(index) || bestTime[index]!!.first().second >= elapsedTime){
                if(bestTime[index]?.first()?.second == elapsedTime){
                    bestTime[index] = bestTime[index]!! + Pair(solver.javaClass.simpleName,elapsedTime)
                }else
                    bestTime[index] = listOf(Pair(solver.javaClass.simpleName,elapsedTime))
            }
            index+=1L
        }
        println("=====================================================================================================")
        println("Solver: ${solver.javaClass.simpleName}, Total score: $totalScore")
        scoreList.add("Solver: ${solver.javaClass.simpleName}, Total score: ${formatter.format(totalScore)}")
        println("=====================================================================================================")
    }

    println("=====================================================================================================")
    println("=====================================================================================================")
    println("=====================================================================================================")

    println("Best score:")
    bestScore.forEach { (index, _) ->
        println("------------------------------------ $index ------------------------------------")
        println("Input: ${inputList[index.toInt()]}")
        println("Solver: ${bestScore[index]!!.map { it.first }}, BestScore: ${bestScore[index]!!.first().second}")
        println("Solver: ${bestResult[index]!!.map { it.first }}, BestResult: ${bestResult[index]!!.first().second}")
        println("Solver: ${bestTime[index]!!.map { it.first }}, BestTime: ${bestTime[index]!!.first().second}")
        println("------------------------------------")
    }
    println("=====================================================================================================")
    scoreList.forEach { println(it) }
    println("=====================================================================================================")
}