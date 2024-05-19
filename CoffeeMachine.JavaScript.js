// Module import for synchronous input from the console
const input = require('sync-input');

// Object containing available coffee machine resources
const availableResources = { water: 400, milk: 540, beans: 120, cups: 9, money: 550 };

// Array defining types of coffee available, each with its respective attributes
const COFFEE_TYPES = [
  { name: 'espresso', water: 250, milk: 0, beans: 16, cups: 1, cost: 4 },
  { name: 'latte', water: 350, milk: 75, beans: 20, cups: 1, cost: 7 },
  { name: 'cappuccino', water: 200, milk: 100, beans: 12, cups: 1, cost: 6 }
];

// Function to display the main menu and handle user commands
function mainMenu() {
  while (true) {
    let command = input("Write action (buy, fill, take, remaining, exit): ");
    if (command === "exit") {
      break;
    }
    switch (command) {
      case "buy":
        buy();
        break;
      case "fill":
        fill();
        break;
      case "take":
        take();
        break;
      case "remaining":
        displayStatus();
        break;
      default:
        console.log("Unknown command!");
        break;
    }
  }
}

// Function to handle taking money from the coffee machine
function take() {
  console.log(`I gave you $${availableResources.money}`);
  availableResources.money = 0;
}

// Function to handle refilling resources in the coffee machine
function fill() {
  availableResources.water += Number(input("Write how many ml of water you want to add: "));
  availableResources.milk += Number(input("Write how many ml of milk you want to add: "));
  availableResources.beans += Number(input("Write how many grams of coffee beans you want to add: "));
  availableResources.cups += Number(input("Write how many disposable cups you want to add: "));
}

// Function to handle the process of buying coffee
function buy() {
  let coffeeType = input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
  if (coffeeType === "back") {
    return;
  }

  let index = Number(coffeeType) - 1;
  if (index < 0 || index >= COFFEE_TYPES.length) {
    console.log("Unknown coffee type!");
    return;
  }

  let typeOfCoffee = COFFEE_TYPES[index];

  if (availableResources.water < typeOfCoffee.water) {
    console.log("Sorry, not enough water!");
    return;
  }
  if (availableResources.milk < typeOfCoffee.milk) {
    console.log("Sorry, not enough milk!");
    return;
  }
  if (availableResources.beans < typeOfCoffee.beans) {
    console.log("Sorry, not enough beans!");
    return;
  }
  if (availableResources.cups < typeOfCoffee.cups) {
    console.log("Sorry, not enough cups!");
    return;
  }

  availableResources.water -= typeOfCoffee.water;
  availableResources.milk -= typeOfCoffee.milk;
  availableResources.beans -= typeOfCoffee.beans;
  availableResources.cups -= typeOfCoffee.cups;
  availableResources.money += typeOfCoffee.cost;

  console.log("I have enough resources, making you a coffee!");
}

// Function to display the status of the coffee machine
function displayStatus() {
  console.log(`
The coffee machine has:
${availableResources.water} ml of water
${availableResources.milk} ml of milk
${availableResources.beans} g of coffee beans
${availableResources.cups} disposable cups
$${availableResources.money} of money\n`);
}

// Starting the main menu loop
mainMenu();
