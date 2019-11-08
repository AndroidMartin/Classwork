import Notes.IntroToClasses.Enemy
import Notes.IntroToClasses.Player

fun main(args: Array<String>) {

    for (i in 0 until 100) {
        if (i % 3 == 0 && i % 5 == 0){
            println(i)
        }
    }

    for (value in 3..100 step 3) {
        if (value % 5 == 0) {
            println(value)
        }
    }


}