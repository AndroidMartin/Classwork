package Notes.Reference

import Notes.IntroToClasses.Enemy


class LogicStatements {

    fun ifStatement(){

    //      +++ USING THE "IF" STATEMENT +++
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

    //      +++ USING THE "FOR" STATEMENT +++
    fun forStatement() {
        for (i in 0..10) {  // <-- loops 11 times
        println("$i doubled is ${i * 2}")
        }

        for (i in 0 until 10) {  // <-- loops 10 times
            println("$i squared is ${i * i}")
        }

        for (i in 10 downTo 0) { // <-- counts down inclusively - 11 times
            println("$i cubed is ${i * i * i}")
        }

        for (i in 10 downTo 0 step 2) {  // <-- counts down by multiples of 2
            println("$i tripled is ${i + i + i}")
        }


        //  CHALLENGE: BETWEEN 0-100, FIND NUMBERS THAT ARE DIVISIBLE BY 3 & 5
        for (i in 0 until 100) {
            if (i % 3 == 0 && i % 5 == 0){
                println(i)
            }
        }
        for (value in 5..100 step 5) {  // <-- more efficient of the above (only tests 20 times)
            if (value % 3 == 0) {
                println(value)
            }
        }

    }

    //      +++ USING THE "WHEN" STATEMENT +++
    fun whenStatement() {
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

    //      +++ USING THE "WHILE" STATEMENT +++
    fun whileStatement() {
        val dracula = Enemy("Dracula")
//        while (dracula.lives)
    }

    //      +++ USING THE "DO-WHILE" STATEMENT +++
    fun forStatement() {

    }


}
