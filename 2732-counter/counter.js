/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let current = n; // Initialize current with the initial value n

    return function() {
        return current++; // Return current value and then increment it
    };
};

/** 
 * const counter = createCounter(10)
 * console.log(counter()) // 10
 * console.log(counter()) // 11
 * console.log(counter()) // 12
 */

// Example usage:
const counter = createCounter(10);
console.log(counter()); 
console.log(counter()); 
console.log(counter()); 