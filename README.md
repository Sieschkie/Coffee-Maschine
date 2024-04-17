# Coffee Machine

This simple Kotlin program simulates a coffee machine where users can buy different types of coffee, refill ingredients, take money, and check the remaining resources.

## Features

- **Buy Coffee**: Choose from three types of coffee (espresso, latte, cappuccino) to purchase.
- **Refill Ingredients**: Add water, milk, coffee beans, and disposable cups to the coffee machine.
- **Take Money**: Withdraw the money earned from selling coffee.
- **Check Remaining Resources**: View the current levels of water, milk, coffee beans, disposable cups, and money.

## Usage

1. Run the program.
2. Follow the on-screen prompts to interact with the coffee machine:
   - Choose "buy" to buy coffee.
   - Choose "fill" to refill ingredients.
   - Choose "take" to take money.
   - Choose "remaining" to check remaining resources.
   - Choose "exit" to exit the program.

## Example

Write action (buy, fill, take, remaining, exit):
buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
1
I have enough resources, making you a coffee!

## Notes

- The coffee machine is initialized with default ingredient levels: 400ml of water, 540ml of milk, 120g of coffee beans, 9 disposable cups, and $550 of money.
- Coffee recipes and prices are predefined in the `Coffee` enum.
- The program runs until the user chooses to exit.
-----------------------------------------------------------------------------------

The following knowledge and concepts were utilized in writing this program:

Object-Oriented Programming (OOP): The program employs classes and objects to model the coffee machine and coffee types.

Enums: Usage of enums Coffee and State to represent coffee types and program states respectively.

Control Structures (if-else, when): The program uses when and if-else constructs to manage states and perform various actions based on user input.

Input/Output Handling: Interaction with the user occurs through console input/output, utilizing the Scanner class.

Error Handling and Exceptions: The program handles potential errors and exceptions, such as insufficient resources to brew coffee.

Loops (do-while): The program employs a do-while loop to execute the main interaction process with the user until the user chooses to exit the program.

Methods and Functions: Various program actions (such as purchasing coffee, adding ingredients, displaying remaining resources, etc.) are organized into separate methods to enhance code readability and modularity.

Object Initialization: Usage of the class constructor CoffeeMachine to initialize initial ingredient and money values in the coffee machine.

Working with Arrays and Collections: The program utilizes the Coffee.values() array to access different coffee types, as well as the mutableListOf collection to store and manage the current state of the coffee machine.
