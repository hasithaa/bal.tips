import ballerina/http;

service on new http:Listener(8080) {
  resource function get greeting(string? name) returns json { 
    if name == () {
      return {"content": "Hello, World!"};
    }  
    string content = string `Hello, ${name}!`;
    return {"content": content};
  }
}
