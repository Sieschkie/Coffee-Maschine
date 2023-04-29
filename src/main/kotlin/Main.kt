package machine

import java.util.*

enum class Coffee(val water: Int, val milk: Int, val beans: Int, val money: Int, val cups: Int) {
    DEFAULT(0,0,0,0,0),
    ESPRESSO(250, 0, 16, 4,1),
    LATTE(350, 75, 20, 7, 1),
    CAPPUCINO(200, 100, 12, 6, 1);
}
enum class State {
    MAIN_MENU, BUY, FILL, TAKE, REMAINING, EXIT
}

class CoffeeMachine(var water: Int = 0, var milk: Int = 0, var beans: Int = 0, var cups: Int = 0, var money: Int = 0, var state: State = State.MAIN_MENU) {
    val scanner = Scanner(System.`in`)


    fun process() {
        when (this.state) {
            State.MAIN_MENU -> main_menu()
            State.BUY -> buy()
            State.FILL -> fill()
            State.TAKE -> take()
            State.REMAINING -> remaining()
            else -> throw RuntimeException("Unknown state")
        }
    }

    fun main_menu() {
        val todo: String
        println(" Write action (buy, fill, take, remaining, exit): ")
        todo = scanner.next().toString()
        this.state = when (todo) {
            "buy" -> State.BUY // to return main menu - "back"
            "fill" -> State.FILL
            "take" -> State.TAKE
            "remaining" -> State.REMAINING
            "exit" -> State.EXIT
            else -> {
                println("Unknown operation")
                State.MAIN_MENU
            }
        }
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val operation = scanner.next()
        var order: Coffee = Coffee.DEFAULT
        state = State.MAIN_MENU
        when (operation) { // back - coffee machine service menu
            "back" -> this.state = State.MAIN_MENU
            "1" -> order = Coffee.values()[1]
            "2" -> order = Coffee.values()[2]
            "3" -> order = Coffee.values()[3]
            else -> main_menu()
        }
            if (water >= order.water && milk >= order.milk && beans >= order.beans && cups >= 1) {
                println("I have enough resources, making you a coffee!")
                water -= order.water
                milk -= order.milk
                beans -= order.beans
                money += order.money
                cups -= order.cups
            } else {
                if (water < order.water) println("Sorry, not enough water!")
                if (milk < order.milk) println("Sorry, not enough milk!")
                if (beans < order.beans) println("Sorry, not enough coffe beans!")
                if (cups < 1) println("Sorry, not enough cups!")
                println("Unknown operation")
                state = State.MAIN_MENU
            }
        }


    fun fill() {
        println("Write how many ml of water you want to add:")
        water += scanner.next().toInt()
        println("Write how many ml of milk you want to add: ")
        milk += scanner.next().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        beans += scanner.next().toInt()
        println("Write how many disposable cups you want to add: ")
        cups += scanner.next().toInt()
        state = State.MAIN_MENU
    }

    fun take() {
        println("I gave you $money")
        money = 0
        this.state = State.MAIN_MENU
    }

    fun remaining() {
        println(
            """
        The coffee machine has:
        $water  ml of water
        $milk ml of milk
        $beans g of coffee beans
        $cups disposable cups
        ${'$'}$money of money""".trimIndent()
        )
        this.state = State.MAIN_MENU
    }
}

fun main() {
    val CoffeeMachine = CoffeeMachine(400,540,120,9,550).run {
        do process() while (this.state != State.EXIT)
    }
}

