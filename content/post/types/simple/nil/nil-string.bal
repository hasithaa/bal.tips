import ballerina/lang.value;
import ballerina/io; //!

public function main() returns error? {

    () a = ();
    string ts = a.toString(); //$
    string tbs = a.toBalString(); //$
    string tjs = a.toJsonString(); //$
    () fjwt = check value:fromJsonStringWithType("null");

    io:println("toString:", ts);
    io:println("toBalString:", tbs);   
    io:println("toJsonString:", tjs);
    io:println("fromJsonStringWithType:", fjwt);
}
