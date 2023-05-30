// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() returns error? {
    json inputJson = check io:fileReadJson("data.json");
    Customer customer = check inputJson.cloneWithType(Customer);

    string fullName = customer.customer\.first\.name + " " + customer.customer\.last\.name;

    io:println("Full Name: ", fullName);
}

type CustomerAddress record {
    string street;
    string city;
    string state;
    string zip;
};

type Customer record {
    string customer\.first\.name;
    string customer\.last\.name;
    int customer\.age;
    string customer\.email\-address;
    string customer\#phone\-number;
    CustomerAddress customer\$address;
};
