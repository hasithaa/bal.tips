// Auto generated file from index.md, do not modify!
import ballerina/io;

function sumIf(int num1, int num2, int max) returns int {
    // num1, num2, max are block-scope variables
    // max hides a module-scope variable with the same name

    int a = num1; // block-scope, hides module-scope identifier //4
    if a > max {
        int a = 0; // Compile time error. Already defined in a block-scope
    } else if num2 > max {
        int num2 = 0; // Compile time error. Already defined in a block-scope
    }
    return a + num2;
}

// module-scope identifiers location does not matter
int a = 100; // module-scope
public int max = 40; // module-scope and public

public function main() {
    io:println(sumIf(a, a, 200));
}
