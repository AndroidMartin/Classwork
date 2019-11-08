package Notes.IntroToClasses

fun main(args: Array<String>) {

    // Using a Java-like constructor
    val player1 = Player("Andrew")  // <-- creates Player type variable with basic information
    val player2 = Player("Volkan")  // <-- no level is specified, so the "constructor" uses default assigned value

    player1.level = 5  // <-- level can be assigned later, but it really should be assigned when constructing the object
    val player3 = Player("Louise", 5) // <-- overwrites the default value assigned in "java-like constructor"

//    player1.oldPrint()
//    player2.newPrint()
//    player3.newPrint()

    val enemy1 = Enemy("Goblin")
    val enemy2 = Enemy("Spore",5)
    val enemy3 = Enemy("Orc", 5,3,3)

//    enemy1.bio()
//    enemy2.bio()
//    enemy3.bio()

    player1.oldPrint()
    println(player1.weapon.name.toUpperCase())
    println(player1.weapon.damageInflicted)

    // You can define a weapon and THEN assign it to a player
    val axe = Weapon("Axe",12)
    player3.weapon = axe
    println("Player ${player3.name} is carrying a ${player3.weapon.name} (${player3.weapon.damageInflicted})")
    axe.damageInflicted = 18
    println("Axe now does ${axe.damageInflicted} after ${player3.name} picked it up")

    //  OR you can define an new weapon AND assign it to the player directly - then it ONLY exists for this player
    player1.weapon = Weapon("Sword",8)
    println("${player1.name} is carrying a ${player1.weapon.name}")
    // player2.weapon = sword  won't work because there is no variable assigned to that weapon (no other reference)


    //  You can sort of get around that IF you reassign that item to another object before replacing it
    player3.weapon = player1.weapon  // <-- Player 3 takes the sword created solely for player 1
    player1.weapon = axe        // <-- Player 1 takes on the object we created earlier, the axe
    player1.newPrint()      //  But the sword still only exists as an object tied to a player
//    player3.newPrint()  //  If player3.weapon is replaces, the sword disappears completely

    val redPotion = LootArray("Red Potion", LootType.POTION, 7.50)
    player2.inventory.add(redPotion)
    player3.inventory.add(redPotion)
    val chestArmor = LootArray("Chain Mail",LootType.ARMOR,80.00)
    player3.inventory.add(chestArmor)

//    player2.newPrint()
    player2.showItem()
    println(player2)  // <-- Can only get this output because you overrode toString method in Player.kt
//    println(player1.toString())  // <-- Otherwise you need to do this
    player3.isAlive()
    player3.showInventory()
    println(player3)
    player1.inventory.add(LootArray("Ring of Protection",LootType.RING,40.25))
    player1.inventory.add(LootArray("Leather Vest",LootType.ARMOR,15.30))
//    player1.showInventory()
    println(player1)



}