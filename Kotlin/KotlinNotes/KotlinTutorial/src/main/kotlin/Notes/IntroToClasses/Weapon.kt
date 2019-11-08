package Notes.IntroToClasses

class Weapon(val name: String, var damageInflicted: Int) {


    override fun toString(): String {
        return """
            $name ($damageInflicted)
        """.trimIndent()
    }

}