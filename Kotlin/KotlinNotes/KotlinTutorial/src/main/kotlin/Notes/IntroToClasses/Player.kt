package Notes.IntroToClasses

class Player (val name: String, var level: Int = 1) {
    var lives = 3
//    var level = 1  // <-- don't need because it's set to 1 above
    var score = 0

    // ----The following two methods do exactly the same thing, just Kotlin has a neater trick
    fun oldPrint(){
        val tim = Player("Tim")
        println(tim.name)
        println(tim.lives)
        println(tim.level)
        println(tim.score)
    }

    fun newPrint(){
        println("""
            name: $name
            lives: $lives
            level: $level
            score: $score
            """)
    }
    // --------


}