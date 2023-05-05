import ballerina/io;

public function main() {

    boolean truth = true;
    boolean falseValue = false;

    string output = string `Boolean Literal:
    Truth: ${truth}
    False: ${falseValue} 
    `;
    io:println(output);
}
