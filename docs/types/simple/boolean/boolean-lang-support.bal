import ballerina/io;

function demoSupportedOperations() {

    boolean x = true;
    boolean y = false;

    string output = string `Logical Operators:
    x && y: ${x && y}
    x || y: ${x || y}
    !x: ${!x}
    `;
    io:println(output);

    int a = 5;
    int b = 10;

    output = string `Various Boolean Expressions:
    a == b: ${a == b}
    a != b: ${a != b}
    a < b: ${a < b}
    a <= b: ${a <= b}
    a > b: ${a > b}
    a >= b: ${a >= b}
    a === b: ${a === b}
    a !== b: ${a !== b}
    a is b: ${a is int}
    a !is b: ${b !is int}
    `;
    io:println(output);
}

function demoLanguageUsage(boolean isTrue = true) {

    if isTrue {
        io:println("If Statement: It's true");
    } else {
        io:println("If Statement: It's false");
    }

    string result = isTrue ? "It's true" : "It's false";
    io:println("Ternary Expression: ", result);

    int i = 0;
    while i < 5 { // This boolean expression is used to determine whether to continue looping or not.
        io:println("While Loop Iteration: ", i);
        i = i + 1;
    }
}

public function main() returns error? {
    demoSupportedOperations();
    demoLanguageUsage();
}