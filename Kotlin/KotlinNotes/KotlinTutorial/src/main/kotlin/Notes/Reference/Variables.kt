package Notes.Reference


fun variables(){

    // First print outs to test terminal emulator
    println("Hello World")
    println("My first Kotlin program")

//      +++ INTRO TO VARIABLES +++
    // Variable Declaration
    val firstName: String = "Tim"  // <-- Best to initialize right away,
    val lastName: String           //     but you can do it separately
    lastName = "Buchalka"          //     (as seen on this line)
    println(firstName + lastName)

    val timSalaryWk: Int = 32
    val timSalaryMt: Int = timSalaryWk * 4
    println(timSalaryMt)

    //Kotlin doesn't need expressed variable types: most often it can "infer" based on the assignment
    val apples = 6
    val oranges = 8   // <--  These values are automatically assigned as Int because that's the input
    val fruit: Int = apples + oranges
    println(fruit)

    var total: Double = fruit * 1.5
    val price = .25
    println(total)

    println("My name is $firstName $lastName")  // <-- same as "My name is " + firstName + " " + lastName"
    println("A quarter of the apples is ${apples / 4}")  // <-- Allows you to do arithmetic: {}   -but because it's of type Int it won't properly divide
    println("$apples apples plus $oranges oranges ($fruit), comes to ${fruit * price}")
    println("You can easily include the $ symbol when surrounded by text...")
    println("but to print it followed by a value, you need to double up: $${fruit * price}")
    println("If you want to print the actual text, you can type \$fruit to display the variable name, NOT value")


//      +++ VAR VS VAL +++
    /*
          Val = value (these are immutable: not going to be changed)
          Var = variable (these can be reassigned later)
    */
    total = fruit * price  // <-- reassigns a 'var' type - cannot do that if a 'val' type
    println("Your total price is: $total")


//      +++ ***** +++

}