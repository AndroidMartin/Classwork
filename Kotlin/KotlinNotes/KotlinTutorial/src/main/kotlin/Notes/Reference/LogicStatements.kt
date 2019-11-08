package Notes.Reference


class LogicStatements {

    fun ifStatement(){

    //      +++ IF STATEMENT +++
        val lives = 3
        var isGameOver = (lives < 1)  // <-- Setting a boolean based on a value
        if (isGameOver) {  // <-- Passing variable as a parameter
            println("Game Over!")
        } else {
            println("You're still alive...")
        }

    //    val age = 15
    //    val message: String
    //    message = if (age < 18) {  // <-- the Kotlin way to do it; is equivalent of:  if (age < 18) {message = "You're too young to vote"}
    //        "You're too young to vote"
    //    } else if (age < 21) {  // <-- Runs AFTER the <18 check
    //        "You can't buy alcohol"
    //    } else if (age == 100) {
    //        "Congrats, you made it!!!"
    //    } else {
    //        "You're able to do whatever you want"
    //    }
    }


    fun whenStatement() {
        //      +++ USING THE "WHEN" STATEMENT +++
        val age = 15
        val message: String
        message = when {
            age < 18 -> "You're too young to vote"
            age < 21 -> "You can't buy alcohol"
            age == 100 -> "Congrats, you made it!!!"
            else -> "You're able to do whatever you want"
            //  much cleaner than long If statements - as noted in the commented section above
        }
        println(message)

    }
}
