package Notes.IntroToClasses


enum class LootType{
    POTION, RING, ARMOR
}

class LootArray(val name: String, val type: LootType, val value: Double) {


    override fun toString(): String {
        return """
            * [$type] $name - $$value
            """
    }

}