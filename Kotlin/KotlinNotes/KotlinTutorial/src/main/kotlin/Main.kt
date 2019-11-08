import Notes.IntroToClasses.Enemy
import Notes.IntroToClasses.Player

fun main(args: Array<String>) {

    val player1 = Player("Andrew")  // <-- creates Player type variable with basic information
    val player2 = Player("Volkan")  // <-- no level is specified, so the "constructor" uses default assigned value

    player1.level = 5  // <-- level can be assigned later, but it really should be assigned when constructing the object

    val player3 = Player("Louise", 5) // <-- overwrites the default value assigned in "java-like constructor"

    player1.oldPrint()
    player2.newPrint()
    player3.newPrint()

    val enemy1 = Enemy("Goblin")
    val enemy2 = Enemy("Spore",5)
    val enemy3 = Enemy("Orc", 5,3,3)

    enemy1.bio()
    enemy2.bio()
    enemy3.bio()

    // Using a Java-like constructor


}