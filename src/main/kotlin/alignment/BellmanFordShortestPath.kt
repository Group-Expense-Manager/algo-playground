package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction
import kotlin.math.abs

class BellmanFordShortestPath : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users.map { it.copy() }.toMutableList()
        val n = users.size
        val transactions = mutableListOf<AlignmentTransaction>()
        val distance = LongArray(n) { Long.MAX_VALUE }
        val predecessor = IntArray(n) { -1 }

        fun bellmanFord(source: Int) {
            distance[source] = 0
            for (i in 1 until n) {
                for (u in 0 until n) {
                    for (v in 0 until n) {
                        if (u != v && users[u].balance > 0 && users[v].balance < 0) {
                            val weight = abs(users[u].balance) + abs(users[v].balance)
                            if (distance[u] != Long.MAX_VALUE && distance[u] + weight < distance[v]) {
                                distance[v] = distance[u] + weight
                                predecessor[v] = u
                            }
                        }
                    }
                }
            }
        }

        for (source in users.indices) {
            bellmanFord(source)
            for (v in users.indices) {
                if (distance[v] < Long.MAX_VALUE && predecessor[v] != -1) {
                    val amount = minOf(users[source].balance, -users[v].balance)
                    transactions.add(AlignmentTransaction(users[v].name, users[source].name, amount))
                    users[source] = users[source].copy(balance = users[source].balance - amount)
                    users[v] = users[v].copy(balance = users[v].balance + amount)
                }
            }
        }

        return transactions
    }
}
