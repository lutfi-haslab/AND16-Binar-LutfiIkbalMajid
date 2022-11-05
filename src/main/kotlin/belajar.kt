import kotlin.system.exitProcess

private var input: String = ""
private var user: String = ""
private var comp: String = ""
private var titleGame1: String = """
================================
   GAME SUIT TERMINAL VERSION 1
================================
masukan pilihan anda: """

var titleGame2: String = """
================================
   GAME SUIT TERMINAL VERSION 2
================================
masukan pilihan player1: """
var player2: String = "masukan pilihan player2: "

fun main(args: Array<String>) {
//  forLoop()
//  Game Suit Menggunakan Do While
//    suitGame()
//  Game Suit Menggunakan For (unlimited loop)
//    suitDenganFor()

//    var perulanganDenganNama = CallFunction().perulanganSatu("Lutfi")
//    var perulanganTanpaNama = CallFunction().perulanganSatu()
//    var player1 = CallFunction().userSatu()
//    var player2 = CallFunction().userDua()
//    var panggilabstract = ManggilAbstract().perulanganSatu()
//    var panggilBapak = Bapak().ngantuk()
//    var panggilAnak = Anak().ngantuk()
    var typeDouble = Menghitung().typeData(10.00)
    var typeFloat = Menghitung().typeData(20.0F)
    println(typeDouble)
    println(typeFloat)
}

open class Bapak {
    open fun ngantuk(){
        println("Bapak Ngantuk")
    }
}
abstract class FunctionToCall {
    abstract fun perulanganSatu(name: String)
    abstract fun perulanganSatu()
    abstract fun perulanganDua()
    abstract fun userSatu(): String
    abstract fun userDua(): String
}

class  Menghitung {
    fun typeData(r: Float): Float {
        return r
    }

    fun typeData(r: Double): Double {
        return r
    }
}

open class Anak: Bapak() {
    override fun ngantuk(){
        println("Anak belum mengantuk")
    }
    open fun keliling(){
        print("Anak Jalan Jalan")
    }
}

class Cucu: Anak(){
    override fun keliling(){

    }
}

class ManggilAbstract : FunctionToCall() {
    override fun perulanganSatu(name: String) {}

    override fun perulanganSatu() {
        println("perulangan satu class manggil abstract")
    }

    override fun perulanganDua() {
    }

    override fun userSatu(): String {
        return "userSatu"
    }

    override fun userDua(): String {
        return "userDua"
    }
}

class CallFunction : FunctionToCall() {
    override fun perulanganSatu(name: String) {
        for (i in 1..6 step 2) {
            println(i)
        }
        println("Haloo nama saya $name")
    }

    override fun perulanganSatu() {
        println("ini tanpa nama")
    }

    override fun perulanganDua() {
        TODO("Not yet implemented")
    }

    override fun userSatu(): String {
        print("Masukan pilihan: ")
        input = readLine().toString().lowercase()
        println(input)
        return input
    }

    override fun userDua(): String {
        print("Masukan pilihan: ")
        input = readLine().toString().lowercase()
        println(input)
        return input
    }
}

fun forLoop() {
    for (i in 10..0) {
        println(i)
    }

//    for (i in 30 downTo 5) {
//        if (i % 3 == 0) {
//            println(i)
//        }
//    }
//
//    for (i in 0..20 step 3) {
//        println(i)
//    }
}

fun suitDenganFor() {
    for (i in generateSequence(0) { it }) {
        print("Masukan pilihan: ")
        input = readLine().toString().lowercase()
//        Jika input selain "gunting" jawabannya akan salah
//        Jika input sama dengan "gunting" jawabannya akan benar, dan pada for loop harus menggunakan "return" untuk menghentikan loop
        if (input == "gunting") {
            println("Ya Anda Benar")
            return
        }
    }
}

fun suitGame() {

    do {
        print(titleGame1)
        input = readLine().toString().lowercase()
        println()
//        Jika input selain "gunting" jawabannya akan salah
//        Jika input sama dengan "gunting" jawabannya akan benar, dan melanjutkan pada game suit kedua
        if (input == "gunting") {
            println("Benar jawaban anda: $input")
            println(
                """
            Langkah pertama berhasil.
            Selanjutnya akan bermain game 2 player.
            """.trimIndent()
            )
            suitGame2()
        } else {
            println("Mohon maaf inputan tidak sesuai")
        }
//        Jika inputan empty maka akan stop loop, jika not empty maka akan terus loop
    } while (input.isNotEmpty())
}

fun suitGame2() {
//    mengambil inputan player 1
    print(titleGame2)
    user = readLine().toString().lowercase()
    println(user)
//    mengambil inputan player 2
    print(player2)
    comp = readLine().toString().lowercase()
    println(comp)

    when {
//        logika ketika player1 = gunting & player2 = kertas atau player1 = batu & player2 = gunting, maka pemain satu menang
        user == "gunting" && comp == "kertas" || user == "batu" && comp == "gunting" -> {
            println("Pemain 1 Menang!")
            exitProcess(1)
        }
//        logika ketika player1 = gunting & player2 = batu atau player1 = batu & player2 = kertas, maka pemain dua menang
        user == "gunting" && comp == "batu" || user == "batu" && comp == "kertas" -> {
            println("Pemain 2 Menang!")
            exitProcess(1)
        }
//        Bila player1 dan player2 sama, maka akan hasilnya Draw / imbang
        user == comp -> {
            println("Draw")
            exitProcess(1)
        }
    }
    if (user == "gunting" && comp == "kertas" || user == "batu" && comp == "gunting") {
        println("Pemain 1 Menang!")
        exitProcess(1)
    }

}
//CTRL+ALT+L format code