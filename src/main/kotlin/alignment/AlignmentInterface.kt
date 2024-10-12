package alignment

interface AlignmentInterface {
    fun run(alignmentInput: AlignmentInput): List<AlignmentTransaction>
}

data class AlignmentInput(
    val users: List<User>
)

data class User(
    val name: String,
    val balance: Long
)

data class AlignmentTransaction(
    val nameFrom: String,
    val nameTo: String,
    val amount: Long
)