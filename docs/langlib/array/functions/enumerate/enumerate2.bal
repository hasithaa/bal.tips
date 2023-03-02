import ballerina/io;

public function main() {

    [float, boolean, string] data = [3.14, true, "hello"];

    [int, float|boolean|string][] dataPairs = data.enumerate();
    foreach [int, float|boolean|string] pair in dataPairs {
        if pair[1] is float {
            io:println(pair[0], ": float");
        } else if pair[1] is boolean {
            io:println(pair[0], ": boolean");
        } else {
            io:println(pair[0], ": string");
        }
    }

}
