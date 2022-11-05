var judulGame: String = """
================================
   GAME SUIT TERMINAL VERSION
================================
"""

fun main() {
    getResult().result()
}

abstract class FunctionToCall2() {
    abstract fun playerOne(inputan: String): String
    abstract fun playerTwo(inputan: String): String
}

class CallingFun : FunctionToCall2() {
    override fun playerOne(inputan: String): String {
        return inputan
    }

    override fun playerTwo(inputan: String): String {
        return inputan
    }
}

class getResult {
    private var inputPlayer1: String = ""
    private var inputPlayer2: String = ""
    private var state = true

    fun exitCall(): Boolean {
        print("Apakah ingin lanjut? (y/n): ")
        var lanjut = readLine().toString().lowercase()
        if (lanjut == "y") {
            return true
        } else {
            return false
        }
    }

    fun result() {
        println(judulGame)
        while (state) {
            print("1. Masukan pemain 1: ")
            inputPlayer1 = readLine().toString().lowercase()
            var player1 = CallingFun().playerOne(inputPlayer1)
            print("2. Masukan pemain 2: ")
            inputPlayer2 = readLine().toString().lowercase()
            var player2 = CallingFun().playerTwo(inputPlayer2)

            when {
                player1 == player2 -> {
                    println("Hasil:")
                    println("DRAW!")
                    state = exitCall()
                }

                player1 == "batu" && player2 == "gunting" || player1 == "kertas" && player2 == "batu" || player1 == "gunting" && player2 == "kertas" -> {
                    println("Hasil:")
                    println("Pemain 1 MENANG!")
                    state = exitCall()
                }

                player1 == "gunting" && player2 == "batu" || player1 == "batu" && player2 == "kertas" || player1 == "kertas" && player2 == "gunting" -> {
                    println("Hasil:")
                    println("Pemain 2 MENANG!")
                    state = exitCall()
                }
            }
        }
    }
}