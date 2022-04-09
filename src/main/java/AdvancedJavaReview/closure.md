Closures
A closure is a function that remembers and accesses the variables and arguments of its outer function even after the function return. The closure able to access the variables defined between its curly brackets, the outer function’s variables and the global variables.
Example:

function greeting() {
var message = 'Hi';

    function sayHi() {
        console.log(message);
    }

    return sayHi;
}
let hi = greeting();
hi(); // prints "hi" in the console.


Normally, when the greeting() function has completed executing, the message variable is no longer accessible. In this case, we execute the hi() function that references the sayHi() function, the message variable still exists. Hence, the sayHi() function is a closure.