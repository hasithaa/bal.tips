---
title: "Converting Numerical Values"
description: "This section describes how to convert numerical values in Ballerina."
date: 2023-06-1
weight : 6300
ballerina_type : [int, float, decimal]
ballerina_lang : [type]
ballerina_module : []
highlight : [numeric_conversion.bal]
menu: 
  main:
    parent: types
    name: 'Numeric Conversion'
    params:
      group: "conversion"
---

# Conversion of Numerical Values

In contrast to certain programming languages, Ballerina does not facilitate implicit conversion among its numerical types. This implies that without explicit conversion, a numerical value cannot be assigned to a variable of a differing numerical type.

Ballerina takes this approach to prevent unintended loss of precision and to safeguard against unexpected program behavior. For instance, when a `float` value is assigned to an `int` variable, the fractional portion of the `float` value will be discarded. Similarly, assigning an `int` value to a `float` variable converts the value to a `float`, introducing a fractional part of zero. While these transformations may not pose a problem when done knowingly, unawareness can lead to unpredictable program behavior. Consequently, Ballerina insists on explicit conversion of numerical values.

## Conversion Rules

In the specification, the conversion rules are defined as follows: (See under NumericConvert)

<table class="tip-table text-center">
    <thead>
        <tr>
            <th>From \ To</th>
            <th>float</th>
            <th>decimal</th>
            <th>int</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>float</td>
            <td>unchanged</td>
            <td>closest math value</td>
            <td rowspan="2">round, error for NaN or out of int range</td>
        </tr>
        <tr>
            <td>decimal</td>
            <td>closest math value</td>
            <td>unchanged</td>
        </tr>
        <tr>
            <td>int</td>
            <td>same math value</td>
            <td>same math value</td>
            <td>unchanged</td>
        </tr>
    </tbody>
</table>


# Explicit Conversion

## Type Casting

If required, you can use a type-cast expression to do a numeric conversion. This is useful when converting a mapping value to another with the same field name but with a different numerical type.

```ballerina {filename="numeric_conversion.bal" lines="9-14" result="output" title="Numeric Conversion"}
import ballerina/io; //!
//!
public function main() {
//!
    int intValue = 10; //$
    float floatValue = 2.1; //$
    decimal decimalValue = 5.0; //$
//$
    int v1 = <int>floatValue; //$
    int v2 = <int>decimalValue; //$
    float v3 = <float>intValue; //$
    float v4 = <float>decimalValue; //$
    decimal v5 = <decimal>intValue; //$
    decimal v6 = <decimal>floatValue; //$
//!
    io:println("v1:", v1);  //!
    io:println("v2:", v2);  //!
    io:println("v3:", v3);  //!
    io:println("v4:", v4);  //!
    io:println("v5:", v5);  //!
    io:println("v6:", v6);  //!
}
```

**Code Breakdown**
{.tip-code-full}

* Line 9: This is the same as `<int>f.round(0)`. This uses Ballerina default round-to-nearest rounding mode. It is the same as IEEE roundToIntegralTiesToEven operation.
* Line 10: This is the same as `<int>d.round(0)`. This uses Ballerina default round-to-nearest rounding mode. It is the same as IEEE roundToIntegralTiesToEven operation with a minor exception to handling positive exponent.
{.tip-code-full}

## Using `value:cloneWithType()`

Another way to convert a numerical value is to use the `value:cloneWithType()` function. 

🚧 More Details Coming Soon!
{.alert .alert-info}