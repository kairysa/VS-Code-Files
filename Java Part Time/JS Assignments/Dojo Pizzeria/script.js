var pizza = {
    crustType: ["regular", "thin crust", "deep dish"],
    sauceType: ["traditional", "creamy alfredo sauce", "pesto sauce"],
    cheese: ["mozzerella", "feta", "parmesan", "ricotta"],
    toppings: ["pepperoni", "sausage", "mushroom", "peppers", "ham", "pineapple", "olives"],
}

function pizzaOven(crustType, sauceType, cheese, toppings){
    var pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}

var s1 = pizzaOven("thin crust", "traditional", "parmesan", "pepperoni");
console.log(s1);

