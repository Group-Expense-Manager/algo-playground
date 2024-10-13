package pl.edu.agh.gem.settlement

import java.math.BigDecimal

class SetPartitionSettlement : SettlementInterface {

    override fun run(settlementInput: SettlementInput): List<Settlement> {
        val (remainingBalances, settlements) = removeBalancesSummingToZero(settlementInput.balances.filter { it.value != BigDecimal.ZERO })
        if (remainingBalances.size <= 5) {
            settlements.addAll(GreedySettlement().run(SettlementInput(remainingBalances)))
        } else if (remainingBalances.size <= 20) {
            val partitions = getAllPartitions(remainingBalances)

            for (partition in partitions) {
                settlements.addAll(GreedySettlement().run(SettlementInput(partition)))
            }
        } else {
            settlements.addAll(DebtRoundingPairing().run(SettlementInput(remainingBalances)))
        }

        return settlements
    }

    private fun removeBalancesSummingToZero(balances: List<Balance>): Pair<List<Balance>, MutableList<Settlement>> {
        val filteredBalances = mutableListOf<Balance>()
        val settlements = mutableListOf<Settlement>()

        for (balance in balances) {
            val oppositeBalanceValue = balance.value.negate()
            val oppositeBalance = filteredBalances.find { it.value == oppositeBalanceValue }

            if (oppositeBalance != null) {
                filteredBalances.remove(oppositeBalance)
                settlements.add(toSettlement(balance, oppositeBalance))
            } else {
                filteredBalances.add(balance)
            }
        }

        return Pair(filteredBalances, settlements)

    }

    private fun toSettlement(a: Balance, b: Balance) = Settlement(
        nameFrom = if (a.value < BigDecimal.ZERO)  a.userId else b.userId,
        nameTo = if (a.value < BigDecimal.ZERO)  b.userId else a.userId,
        value = a.value.abs(),
    )

    private fun getAllPartitions(elements: List<Balance>): List<List<Balance>> {
        return getAllPartitionsRecursive(listOf(), elements)
    }

    private fun getAllPartitionsRecursive(fixedParts: List<List<Balance>>, suffixElements: List<Balance>): List<List<Balance>> {
        if (suffixElements.size <= 3) {
            return fixedParts + listOf(suffixElements)
        }

        val tuples = filterPartitionsWithZeroSum(getTuplePartitions(suffixElements))
        if (tuples.isEmpty()) {
            return fixedParts + listOf(suffixElements)
        }

        var maxLen = -1
        var bestResult: List<List<Balance>> = mutableListOf()

        for (suffixPartition in tuples) {
            val subPartitions = getAllPartitionsRecursive(fixedParts + listOf(suffixPartition.first), suffixPartition.second)
            if (subPartitions.size > maxLen) {
                maxLen = subPartitions.size
                bestResult = subPartitions
            }
        }

        return bestResult
    }

    private fun getTuplePartitions(elements: List<Balance>): List<Pair<List<Balance>, List<Balance>>> {
        val result = mutableListOf<Pair<List<Balance>, List<Balance>>>()

        if (elements.size < 2) {
            return result
        }

        for (pattern in 1 until (1 shl (elements.size - 1))) {
            val resultSets = mutableListOf(mutableListOf<Balance>(), mutableListOf<Balance>())
            resultSets[0].add(elements[0])

            for (index in 1 until elements.size) {
                resultSets[(pattern shr (index - 1)) and 1].add(elements[index])
            }

            result.add(Pair(resultSets[0], resultSets[1]))
        }

        return result
    }

    private fun filterPartitionsWithZeroSum(partitions: List<Pair<List<Balance>, List<Balance>>>): List<Pair<List<Balance>, List<Balance>>> {
        return partitions.filter { partition -> partition.first.sumOf { it.value } == BigDecimal.ZERO }
    }
}