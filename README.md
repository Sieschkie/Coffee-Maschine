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
