// Auto generated file from index.md, do not modify!
import ballerina/io;

type Employee record {
    int id;
    string name;
    decimal salary;
};

public function main() {

    Employee emp = {name: "Bob", id: 2, salary: 45000};
    string department = "IT";

    string s1 = string `Hello, ${emp.name}!`;
    string s2 = string `Your id is ${emp.id}
Your department is ${department}
Your salary is ${emp.salary}`;

    io:println(s1);
    io:println(s2);
}
