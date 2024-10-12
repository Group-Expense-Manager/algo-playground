package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction
import alignment.User
import kotlin.math.min

class SetPartitionAlignment : AlignmentInterface {

    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users
        val partitions = getAllPartitions(users)

        val transactions = mutableListOf<AlignmentTransaction>()

        // Process each partition
        for (partition in partitions) {
            transactions.addAll(GreedyAlignment().run(AlignmentInput(partition)))
        }

        return transactions
    }

    // Function to get all partitions
    private fun getAllPartitions(elements: List<User>): List<List<User>> {
        return getAllPartitionsRecursive(listOf(), elements)
    }

    // Recursive function to get all partitions
    private fun getAllPartitionsRecursive(fixedParts: List<List<User>>, suffixElements: List<User>): List<List<User>> {
        if (suffixElements.size <= 3) {
            return fixedParts + listOf(suffixElements)
        }

        val tuples = filterPartitionsWithZeroSum(getTuplePartitions(suffixElements))
        if (tuples.isEmpty()) {
            return fixedParts + listOf(suffixElements)
        }

        var maxlen = -1
        var maxres: List<List<User>> = mutableListOf()

        for (suffixPartition in tuples) {
            val subPartitions = getAllPartitionsRecursive(fixedParts + listOf(suffixPartition.first), suffixPartition.second)
            if (subPartitions.size > maxlen) {
                maxlen = subPartitions.size
                maxres = subPartitions
            }
        }

        return maxres
    }

    // Function to generate all two-part partitions
    private fun getTuplePartitions(elements: List<User>): List<Pair<List<User>, List<User>>> {
        val result = mutableListOf<Pair<List<User>, List<User>>>()

        if (elements.size < 2) {
            return result
        }

        for (pattern in 1 until (1 shl (elements.size - 1))) {
            val resultSets = mutableListOf(mutableListOf<User>(), mutableListOf<User>())
            resultSets[0].add(elements[0])

            for (index in 1 until elements.size) {
                resultSets[(pattern shr (index - 1)) and 1].add(elements[index])
            }

            result.add(Pair(resultSets[0], resultSets[1]))
        }

        return result
    }

    // Function to filter partitions where the sum of the first list is zero
    private fun filterPartitionsWithZeroSum(partitions: List<Pair<List<User>, List<User>>>): List<Pair<List<User>, List<User>>> {
        return partitions.filter { partition -> partition.first.sumOf { it.balance } == 0L }
    }
}