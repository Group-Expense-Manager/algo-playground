package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction

data class Edge(
    val from: Int,
    val to: Int,
    val capacity: Long,
    var flow: Long = 0
)

class NetworkFlowAlignment : AlignmentInterface {
    override fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction> {
        val users = alignmentInput.users
        val n = users.size
        val edges = mutableListOf<Edge>()
        val adj = Array(n + 2) { mutableListOf<Int>() }
        val source = n
        val sink = n + 1

        for ((index, user) in users.withIndex()) {
            if (user.balance > 0) {
                edges.add(Edge(source, index, user.balance))
                edges.add(Edge(index, source, 0))
                adj[source].add(edges.lastIndex - 1)
                adj[index].add(edges.lastIndex)
            } else if (user.balance < 0) {
                edges.add(Edge(index, sink, -user.balance))
                edges.add(Edge(sink, index, 0))
                adj[index].add(edges.lastIndex - 1)
                adj[sink].add(edges.lastIndex)
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (users[i].balance > 0 && users[j].balance < 0) {
                    edges.add(Edge(i, j, Long.MAX_VALUE))
                    edges.add(Edge(j, i, 0))
                    adj[i].add(edges.lastIndex - 1)
                    adj[j].add(edges.lastIndex)
                }
            }
        }

        fun bfs(parent: IntArray): Boolean {
            val visited = BooleanArray(n + 2) { false }
            val queue = mutableListOf(source)
            visited[source] = true
            while (queue.isNotEmpty()) {
                val u = queue.removeAt(0)
                for (idx in adj[u]) {
                    val edge = edges[idx]
                    val v = if (edge.from == u) edge.to else edge.from
                    if (!visited[v] && edge.capacity > edge.flow) {
                        parent[v] = idx
                        if (v == sink) return true
                        queue.add(v)
                        visited[v] = true
                    }
                }
            }
            return false
        }

        fun fordFulkerson(): Long {
            val parent = IntArray(n + 2) { -1 }
            var maxFlow = 0L
            while (bfs(parent)) {
                var pathFlow = Long.MAX_VALUE
                var s = sink
                while (s != source) {
                    val edge = edges[parent[s]]
                    pathFlow = minOf(pathFlow, edge.capacity - edge.flow)
                    s = if (edge.from == s) edge.to else edge.from
                }
                s = sink
                while (s != source) {
                    val edge = edges[parent[s]]
                    edge.flow += pathFlow
                    edges[parent[s] xor 1].flow -= pathFlow
                    s = if (edge.from == s) edge.to else edge.from
                }
                maxFlow += pathFlow
            }
            return maxFlow
        }

        fordFulkerson()

        val transactions = mutableListOf<AlignmentTransaction>()
        for (edge in edges) {
            if (edge.from != source && edge.to != sink && edge.flow > 0) {
                transactions.add(AlignmentTransaction(users[edge.to].name, users[edge.from].name, edge.flow))
            }
        }

        return transactions
    }
}
