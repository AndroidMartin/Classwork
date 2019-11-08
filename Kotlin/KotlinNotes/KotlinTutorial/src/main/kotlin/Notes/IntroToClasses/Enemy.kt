package Notes.IntroToClasses

class Enemy (var name: String, var level: Int = 3, var attack: Int = 4, var defense: Int = 2, var lives: Boolean = true){

    fun bio() {
        println("""
            Name: $name
            Level: $level
            Attack: $attack
            Defense: $defense
            """)
    }
}