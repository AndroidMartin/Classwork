package Notes.IntroToClasses

class Player (val name: String, var level: Int = 1) {
    // set default values
    var lives = 3
//    var level = 1  // <-- don't need because it's set to 1 above
    var score = 0

    // set a default weapon
    var weapon: Weapon = Weapon("Fist", 1)  // <-- calling on the class Weapon.kt constructor



    //  ASSIGNING ARRAYLIST
    val inventory = ArrayList<LootArray>()  // <-- By declaring it <LootArray> it will ONLY hold that type,
                                            //     otherwise, it could hold anything (e.g. player type)





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
            weapon: ${weapon.name}
            damage: ${weapon.damageInflicted}
            """)
    }
    // --------

    override fun toString(): String {  // <--Overriding the method so you can call "println(player2)"
//        return """
//            name: $name
//            lives: $lives
//            level: $level
//            score: $score
//            weapon: ${weapon.name}
//            damage: ${weapon.damageInflicted}
//            ==============================
//            """
        return """
            Name: $name
            Lives: $lives
            Level: $level
            Score: $score
            Weapon: $weapon
            Inventory: ${inventory[0]}
            Inventory: ${showInventory()}
            ==============================
            """
    }

    fun isAlive(){
        if (lives < 0) {
            println("$name is dead")
        } else {
            println("$name is alive")
        }
    }

    fun showItem(){
        println("********")
        println("$name's Selected Item in Inventory")
        println(inventory.get(0))
        println("********")
    }

    fun showInventory(){
        for (item in inventory) {
            print(item)
        }
    }




}