package pl.edu.agh.gem.alignment

import alignment.AlignmentInput
import alignment.AlignmentInterface
import alignment.AlignmentTransaction
import alignment.User
import pl.edu.agh.gem.alignment.TestInput.inputList
import pl.edu.agh.gem.alignment.TestInput.solversList
import java.text.NumberFormat
import java.util.*

object TestInput {
    val solversList = listOf(
        GreedyAlignment(),
        GraphAlignment(),
        TransactionCompressionAlignment(),
        PriorityBasedAlignment(),
        NetworkFlowAlignment(),
        DebtRoundingPairing(),
        CycleCancellation(),
    )
    val inputList = listOf(
        AlignmentInput(users = listOf(User(name = "User 0", balance = -462), User(name = "User 1", balance = 462))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 248), User(name = "User 1", balance = -183), User(name = "User 2", balance = -65))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -345), User(name = "User 1", balance = 96), User(name = "User 2", balance = 249))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 1735), User(name = "User 1", balance = -432), User(name = "User 2", balance = -1303))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -1207), User(name = "User 1", balance = 578), User(name = "User 2", balance = 629))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 789), User(name = "User 1", balance = -789))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -999), User(name = "User 1", balance = 347), User(name = "User 2", balance = 652))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 555), User(name = "User 1", balance = -233), User(name = "User 2", balance = -322))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 0), User(name = "User 1", balance = 0), User(name = "User 2", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -1), User(name = "User 1", balance = -1), User(name = "User 2", balance = 1), User(name = "User 3", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -999), User(name = "User 1", balance = 999))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -4), User(name = "User 1", balance = 4), User(name = "User 2", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -7), User(name = "User 1", balance = 3), User(name = "User 2", balance = 4))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -19), User(name = "User 1", balance = 9), User(name = "User 2", balance = 10), User(name = "User 3", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -21), User(name = "User 1", balance = 7), User(name = "User 2", balance = 11), User(name = "User 3", balance = 3), User(name = "User 4", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -34), User(name = "User 1", balance = 8), User(name = "User 2", balance = 14), User(name = "User 3", balance = 6), User(name = "User 4", balance = 2), User(name = "User 5", balance = 4))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -62), User(name = "User 1", balance = 23), User(name = "User 2", balance = 14), User(name = "User 3", balance = 10), User(name = "User 4", balance = 8), User(name = "User 5", balance = 4), User(name = "User 6", balance = 3))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -78), User(name = "User 1", balance = 31), User(name = "User 2", balance = 13), User(name = "User 3", balance = 12), User(name = "User 4", balance = 8), User(name = "User 5", balance = 10), User(name = "User 6", balance = 4), User(name = "User 7", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -90), User(name = "User 1", balance = 39), User(name = "User 2", balance = 20), User(name = "User 3", balance = 13), User(name = "User 4", balance = 5), User(name = "User 5", balance = 7), User(name = "User 6", balance = 4), User(name = "User 7", balance = 2), User(name = "User 8", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -111), User(name = "User 1", balance = 41), User(name = "User 2", balance = 29), User(name = "User 3", balance = 25), User(name = "User 4", balance = 13), User(name = "User 5", balance = 3), User(name = "User 6", balance = 0), User(name = "User 7", balance = 0), User(name = "User 8", balance = 0), User(name = "User 9", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -127), User(name = "User 1", balance = 45), User(name = "User 2", balance = 28), User(name = "User 3", balance = 18), User(name = "User 4", balance = 22), User(name = "User 5", balance = 8), User(name = "User 6", balance = 6), User(name = "User 7", balance = 0), User(name = "User 8", balance = 0), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -144), User(name = "User 1", balance = 50), User(name = "User 2", balance = 34), User(name = "User 3", balance = 10), User(name = "User 4", balance = 35), User(name = "User 5", balance = 6), User(name = "User 6", balance = 5), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -158), User(name = "User 1", balance = 51), User(name = "User 2", balance = 42), User(name = "User 3", balance = 22), User(name = "User 4", balance = 21), User(name = "User 5", balance = 8), User(name = "User 6", balance = 6), User(name = "User 7", balance = 5), User(name = "User 8", balance = 3), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -176), User(name = "User 1", balance = 62), User(name = "User 2", balance = 42), User(name = "User 3", balance = 20), User(name = "User 4", balance = 28), User(name = "User 5", balance = 12), User(name = "User 6", balance = 8), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -190), User(name = "User 1", balance = 65), User(name = "User 2", balance = 33), User(name = "User 3", balance = 66), User(name = "User 4", balance = 12), User(name = "User 5", balance = 8), User(name = "User 6", balance = 4), User(name = "User 7", balance = 2), User(name = "User 8", balance = 0), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0), User(name = "User 14", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -203), User(name = "User 1", balance = 68), User(name = "User 2", balance = 29), User(name = "User 3", balance = 69), User(name = "User 4", balance = 15), User(name = "User 5", balance = 12), User(name = "User 6", balance = 4), User(name = "User 7", balance = 3), User(name = "User 8", balance = 2), User(name = "User 9", balance = 1), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0), User(name = "User 14", balance = 0), User(name = "User 15", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -221), User(name = "User 1", balance = 70), User(name = "User 2", balance = 34), User(name = "User 3", balance = 82), User(name = "User 4", balance = 12), User(name = "User 5", balance = 11), User(name = "User 6", balance = 6), User(name = "User 7", balance = 4), User(name = "User 8", balance = 2), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0), User(name = "User 14", balance = 0), User(name = "User 15", balance = 0), User(name = "User 16", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -240), User(name = "User 1", balance = 76), User(name = "User 2", balance = 38), User(name = "User 3", balance = 94), User(name = "User 4", balance = 13), User(name = "User 5", balance = 9), User(name = "User 6", balance = 5), User(name = "User 7", balance = 4), User(name = "User 8", balance = 1), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0), User(name = "User 14", balance = 0), User(name = "User 15", balance = 0), User(name = "User 16", balance = 0), User(name = "User 17", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -250), User(name = "User 1", balance = 70), User(name = "User 2", balance = 35), User(name = "User 3", balance = 100), User(name = "User 4", balance = 17), User(name = "User 5", balance = 13), User(name = "User 6", balance = 11), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = 0), User(name = "User 10", balance = 0), User(name = "User 11", balance = 0), User(name = "User 12", balance = 0), User(name = "User 13", balance = 0), User(name = "User 14", balance = 0), User(name = "User 15", balance = 0), User(name = "User 16", balance = 0), User(name = "User 17", balance = 0), User(name = "User 18", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -1), User(name = "User 1", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -4), User(name = "User 1", balance = 4), User(name = "User 2", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -7), User(name = "User 1", balance = 3), User(name = "User 2", balance = 4))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -19), User(name = "User 1", balance = 9), User(name = "User 2", balance = 10), User(name = "User 3", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -21), User(name = "User 1", balance = 7), User(name = "User 2", balance = 11), User(name = "User 3", balance = 3), User(name = "User 4", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -34), User(name = "User 1", balance = 8), User(name = "User 2", balance = -6), User(name = "User 3", balance = 6), User(name = "User 4", balance = 2), User(name = "User 5", balance = 24))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -62), User(name = "User 1", balance = 23), User(name = "User 2", balance = 46), User(name = "User 3", balance = 20), User(name = "User 4", balance = -32), User(name = "User 5", balance = 4), User(name = "User 6", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -78), User(name = "User 1", balance = 31), User(name = "User 2", balance = 6), User(name = "User 3", balance = 12), User(name = "User 4", balance = 14), User(name = "User 5", balance = 10), User(name = "User 6", balance = 4), User(name = "User 7", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -90), User(name = "User 1", balance = 39), User(name = "User 2", balance = 13), User(name = "User 3", balance = 13), User(name = "User 4", balance = 11), User(name = "User 5", balance = 7), User(name = "User 6", balance = 4), User(name = "User 7", balance = 2), User(name = "User 8", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -111), User(name = "User 1", balance = 41), User(name = "User 2", balance = 31), User(name = "User 3", balance = 25), User(name = "User 4", balance = 10), User(name = "User 5", balance = 3), User(name = "User 6", balance = 1), User(name = "User 7", balance = 1), User(name = "User 8", balance = -1), User(name = "User 9", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -127), User(name = "User 1", balance = 45), User(name = "User 2", balance = 33), User(name = "User 3", balance = 18), User(name = "User 4", balance = 12), User(name = "User 5", balance = 8), User(name = "User 6", balance = 6), User(name = "User 7", balance = 4), User(name = "User 8", balance = 2), User(name = "User 9", balance = -1), User(name = "User 10", balance = 0))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -154), User(name = "User 1", balance = 50), User(name = "User 2", balance = 66), User(name = "User 3", balance = 10), User(name = "User 4", balance = 12), User(name = "User 5", balance = 8), User(name = "User 6", balance = 6), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = -1), User(name = "User 10", balance = -2), User(name = "User 11", balance = 1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -158), User(name = "User 1", balance = 51), User(name = "User 2", balance = 42), User(name = "User 3", balance = 20), User(name = "User 4", balance = 18), User(name = "User 5", balance = 12), User(name = "User 6", balance = 6), User(name = "User 7", balance = 5), User(name = "User 8", balance = 4), User(name = "User 9", balance = 3), User(name = "User 10", balance = -1), User(name = "User 11", balance = -1), User(name = "User 12", balance = -1))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -176), User(name = "User 1", balance = 62), User(name = "User 2", balance = 67), User(name = "User 3", balance = 20), User(name = "User 4", balance = 18), User(name = "User 5", balance = 12), User(name = "User 6", balance = 8), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = -1), User(name = "User 10", balance = -2), User(name = "User 11", balance = -3), User(name = "User 12", balance = -4), User(name = "User 13", balance = -5))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -190), User(name = "User 1", balance = 65), User(name = "User 2", balance = 33), User(name = "User 3", balance = 17), User(name = "User 4", balance = 81), User(name = "User 5", balance = 8), User(name = "User 6", balance = 4), User(name = "User 7", balance = 2), User(name = "User 8", balance = 1), User(name = "User 9", balance = -1), User(name = "User 10", balance = -2), User(name = "User 11", balance = -3), User(name = "User 12", balance = -4), User(name = "User 13", balance = -5), User(name = "User 14", balance = -6))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -203), User(name = "User 1", balance = 68), User(name = "User 2", balance = 100), User(name = "User 3", balance = 19), User(name = "User 4", balance = 15), User(name = "User 5", balance = 12), User(name = "User 6", balance = 4), User(name = "User 7", balance = 3), User(name = "User 8", balance = 2), User(name = "User 9", balance = 1), User(name = "User 10", balance = -1), User(name = "User 11", balance = -2), User(name = "User 12", balance = -3), User(name = "User 13", balance = -4), User(name = "User 14", balance = -5), User(name = "User 15", balance = -6))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -215), User(name = "User 1", balance = 70), User(name = "User 2", balance = 131), User(name = "User 3", balance = 21), User(name = "User 4", balance = 11), User(name = "User 5", balance = 10), User(name = "User 6", balance = 4), User(name = "User 7", balance = 3), User(name = "User 8", balance = 1), User(name = "User 9", balance = -1), User(name = "User 10", balance = -2), User(name = "User 11", balance = -3), User(name = "User 12", balance = -4), User(name = "User 13", balance = -5), User(name = "User 14", balance = -6), User(name = "User 15", balance = -7), User(name = "User 16", balance = -8))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -223), User(name = "User 1", balance = 71), User(name = "User 2", balance = 170), User(name = "User 3", balance = 19), User(name = "User 4", balance = 12), User(name = "User 5", balance = 3), User(name = "User 6", balance = 2), User(name = "User 7", balance = 1), User(name = "User 8", balance = -1), User(name = "User 9", balance = -2), User(name = "User 10", balance = -3), User(name = "User 11", balance = -4), User(name = "User 12", balance = -5), User(name = "User 13", balance = -6), User(name = "User 14", balance = -7), User(name = "User 15", balance = -8), User(name = "User 16", balance = -9), User(name = "User 17", balance = -10))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 120),User(name = "User 1", balance = 270),User(name = "User 2", balance = -150),User(name = "User 3", balance = 315),User(name = "User 4", balance = -420),User(name = "User 5", balance = 540),User(name = "User 6", balance = -620),User(name = "User 7", balance = 110),User(name = "User 8", balance = -115),User(name = "User 9", balance = -50))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -354),User(name = "User 1", balance = -405),User(name = "User 2", balance = 1070),User(name = "User 3", balance = -319),User(name = "User 4", balance = -523),User(name = "User 5", balance = 241),User(name = "User 6", balance = -127),User(name = "User 7", balance = 189),User(name = "User 8", balance = -356),User(name = "User 9", balance = 567),User(name = "User 10", balance = -274),User(name = "User 11", balance = 389),User(name = "User 12", balance = -120),User(name = "User 13", balance = 433),User(name = "User 14", balance = -561),User(name = "User 15", balance = 298),User(name = "User 16", balance = -379),User(name = "User 17", balance = 466),User(name = "User 18", balance = -188),User(name = "User 19", balance = -47))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = -450),User(name = "User 1", balance = -130),User(name = "User 2", balance = -240),User(name = "User 3", balance = -145),User(name = "User 4", balance = -85),User(name = "User 5", balance = -265),User(name = "User 6", balance = -85),User(name = "User 7", balance = 165),User(name = "User 8", balance = -95),User(name = "User 9", balance = 120),User(name = "User 10", balance = -50),User(name = "User 11", balance = 235),User(name = "User 12", balance = -260),User(name = "User 13", balance = 340),User(name = "User 14", balance = -470),User(name = "User 15", balance = 510),User(name = "User 16", balance = -310),User(name = "User 17", balance = 420),User(name = "User 18", balance = -185),User(name = "User 19", balance = 335),User(name = "User 20", balance = -245),User(name = "User 21", balance = 110),User(name = "User 22", balance = -80),User(name = "User 23", balance = 410),User(name = "User 24", balance = -385),User(name = "User 25", balance = 225),User(name = "User 26", balance = -150),User(name = "User 27", balance = 475),User(name = "User 28", balance = -120),User(name = "User 29", balance = 365),User(name = "User 30", balance = -430),User(name = "User 31", balance = 510),User(name = "User 32", balance = -240),User(name = "User 33", balance = 160),User(name = "User 34", balance = 120),User(name = "User 35", balance = -335),User(name = "User 36", balance = 170),User(name = "User 37", balance = -250),User(name = "User 38", balance = 415),User(name = "User 39", balance = -60),User(name = "User 40", balance = 340),User(name = "User 41", balance = -470),User(name = "User 42", balance = 255),User(name = "User 43", balance = -315),User(name = "User 44", balance = 510),User(name = "User 45", balance = -510),User(name = "User 46", balance = 390),User(name = "User 47", balance = -170),User(name = "User 48", balance = 320),User(name = "User 49", balance = -370))),
        AlignmentInput(users = listOf(User(name = "User 0", balance = 340),User(name = "User 1", balance = -95),User(name = "User 2", balance = -956),User(name = "User 3", balance = -78),User(name = "User 4", balance = 129),User(name = "User 5", balance = -46),User(name = "User 6", balance = 183),User(name = "User 7", balance = -32),User(name = "User 8", balance = 89),User(name = "User 9", balance = -59),User(name = "User 10", balance = 243),User(name = "User 11", balance = -102),User(name = "User 12", balance = 67),User(name = "User 13", balance = -98),User(name = "User 14", balance = 190),User(name = "User 15", balance = -300),User(name = "User 16", balance = 270),User(name = "User 17", balance = -320),User(name = "User 18", balance = 180),User(name = "User 19", balance = -60),User(name = "User 20", balance = 45),User(name = "User 21", balance = 150),User(name = "User 22", balance = -400),User(name = "User 23", balance = 130),User(name = "User 24", balance = -210),User(name = "User 25", balance = 370),User(name = "User 26", balance = -185),User(name = "User 27", balance = 195),User(name = "User 28", balance = -65),User(name = "User 29", balance = 75),User(name = "User 30", balance = -55),User(name = "User 31", balance = 350),User(name = "User 32", balance = -30),User(name = "User 33", balance = 40),User(name = "User 34", balance = -100),User(name = "User 35", balance = 110),User(name = "User 36", balance = -90),User(name = "User 37", balance = 25),User(name = "User 38", balance = -25),User(name = "User 39", balance = 195),User(name = "User 40", balance = -115),User(name = "User 41", balance = 50),User(name = "User 42", balance = -50),User(name = "User 43", balance = 300),User(name = "User 44", balance = -120),User(name = "User 45", balance = 215),User(name = "User 46", balance = -215),User(name = "User 47", balance = 125),User(name = "User 48", balance = -205),User(name = "User 49", balance = 170),User(name = "User 50", balance = -370),User(name = "User 51", balance = 295),User(name = "User 52", balance = -295),User(name = "User 53", balance = 55),User(name = "User 54", balance = -35),User(name = "User 55", balance = 85),User(name = "User 56", balance = -60),User(name = "User 57", balance = 230),User(name = "User 58", balance = -230),User(name = "User 59", balance = 190),User(name = "User 60", balance = -190),User(name = "User 61", balance = 140),User(name = "User 62", balance = -140),User(name = "User 63", balance = 230),User(name = "User 64", balance = -130),User(name = "User 65", balance = 210),User(name = "User 66", balance = -210),User(name = "User 67", balance = 110),User(name = "User 68", balance = -110),User(name = "User 69", balance = 60),User(name = "User 70", balance = -60),User(name = "User 71", balance = 30),User(name = "User 72", balance = -30),User(name = "User 73", balance = 180),User(name = "User 74", balance = -180),User(name = "User 75", balance = 400),User(name = "User 76", balance = -400),User(name = "User 77", balance = 250),User(name = "User 78", balance = -250),User(name = "User 79", balance = 150),User(name = "User 80", balance = -150),User(name = "User 81", balance = 80),User(name = "User 82", balance = -80),User(name = "User 83", balance = 20),User(name = "User 84", balance = -20),User(name = "User 85", balance = 10),User(name = "User 86", balance = -10),User(name = "User 87", balance = 30),User(name = "User 88", balance = -30),User(name = "User 89", balance = 60),User(name = "User 90", balance = -60),User(name = "User 91", balance = 45),User(name = "User 92", balance = -45),User(name = "User 93", balance = 75),User(name = "User 94", balance = -75),User(name = "User 95", balance = 85),User(name = "User 96", balance = -85),User(name = "User 97", balance = 100),User(name = "User 98", balance = -110),User(name = "User 99", balance = 10)))
    )
}

fun checkCorrect(alignmentInput:AlignmentInput,result:List<AlignmentTransaction>):Boolean{
    val users = alignmentInput.users
    val userMap = users.associate { it.name to it.balance }
    val userMap2 = users.associate { it.name to 0L }.toMutableMap()
    result.forEach {
        userMap2[it.nameFrom] = userMap2[it.nameFrom]!! - it.amount
        userMap2[it.nameTo] = userMap2[it.nameTo]!! + it.amount
    }
    return userMap == userMap2
}

fun scoreResult(alignmentInput:AlignmentInput,result:List<AlignmentTransaction>,elapsedTime: Long):Long{
    val baseMultiplayer = (1000 * alignmentInput.users.size.toDouble() / (result.size + 1))
    return (baseMultiplayer/elapsedTime*baseMultiplayer*baseMultiplayer).toLong()
}

class AlignmentTestException(alignmentInput:AlignmentInput,result:List<AlignmentTransaction>):RuntimeException("Test failed for input $alignmentInput and result $result")

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
            if(!checkCorrect(input,result)) throw AlignmentTestException(input,result)
            val score = scoreResult(input,result,elapsedTime)
            totalScore += score
            println("------------------------------------")
            println("Input: $input")
            println("Elapsed time: $elapsedTime ns")
            println("Users count: ${input.users.size}")
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