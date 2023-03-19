/* The conditional (ternary) operator is the only JavaScript operator that takes three operands: a condition followed by a question mark (?), 
then an expression to execute if the condition is truthy followed by a colon (:), and finally the expression to execute if the condition is falsy. 
This operator is frequently used as a shortcut for the if statement. */

// Basic if statement //

let canAfford = (itemPrice, accountBalance) => {
    if (itemPrice > accountBalance) {
        return 'Cannot afford!'
    } else {
        return 'Can afford!'
    }
}

// Ternary Statement //
let canAfford2 = (itemPrice, accountBalance) => {
    return itemPrice > accountBalance
        ? 'Cannot afford!'
        : "Can afford";
}