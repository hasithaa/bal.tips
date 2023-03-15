import ballerina/io;

public function main() {
    // EN-US
    Person john = {name: "John", age: 30, country: "United States"};
    io:println(john.age);

    // CN
    人 李华 = { 名字: "李华", 年龄: 25, 国家: "中国" };
    io:println(李华.年龄);

    // IN
    व्यक्ति राजेश = { नाम: "राजेश", उम्र: 30, देश: "भारत" };
    io:println(राजेश.उम्र);

    // SI
    පුද්ගලයා හසිත = { නම: "හසිත", වයස: 34, රට: "ශ්‍රී ලංකාව" };
    io:println(හසිත.වයස);

    // JP* (人 Same Unicode as CN, Hence using 人1)
    人1 たかし = { 名前: "たかし", 年齢: 35, 国: "日本" };
    io:println(たかし.年齢);

    // RU
    Человек Иван = { имя: "Иван", возраст: 25, страна: "Россия" };
    io:println(Иван.возраст);

    // ES
    Persona María = { nombre: "María", edad: 25, país: "España" };
    io:println(María.edad);

    // KO
    사람 지민 = { 이름: "지민", 나이: 28, 나라: "대한민국" };
    io:println(지민.나이);
}

type Person record {
    string name;
    int age;
    string country;
};

type 人 record {
    string 名字;
    int 年龄;
    string 国家;
};

type व्यक्ति record {  
    string नाम;
    int उम्र;
    string देश;
};

type පුද්ගලයා record {  
    string නම;
    int වයස;
    string රට;
};

type 人1 record {  
    string 名前;
    int 年齢;
    string 国;
};

type Человек record {  
    string имя;
    int возраст;
    string страна;
};

type Persona record {  
    string nombre;
    int edad;
    string país;
};

type 사람 record {  
    string 이름;
    int 나이;
    string 나라;
};
