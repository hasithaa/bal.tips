import ballerina/io;

public function main() {
    [string, string, int, int, int][] grades = [
        ["John", "smith", 80, 90, 100],
        ["Jane", "doe", 90, 100, 100],
        ["Jim", "carrey", 80, 80, 80]
    ];

    int average = 0;
    foreach [string, string, int...] [_, _, ...scores] in grades {
        int sum = int:sum(...scores);
        average += sum / scores.length();
    }
    io:println("Average: ", average / grades.length());

    foreach [string, string, int...] [firstName, lastName, _, _, _] in grades {
        _ = printName(firstName, lastName);
    }
}

function printName(string fname, string lname) returns boolean {
    io:println(fname, " ", lname);
    // Return only to illustrate that the return value is not used by the caller.
    return true;
}
// Auto generated file from index.md, do not modify!
