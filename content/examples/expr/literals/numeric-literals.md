---
title : "Type of a numeric literal"
date : 2022-07-28T01:28:56+05:30
kind : tip 
tags : ["literal", "numeric-literal", "int", "float", "decimal"]
code : ["numeric-literals.bal"]
weight : 0605030001
size : "small"
disableNavChevron : true 
seeMore : true
---

A value written in a numeric-literal always represents a precise type, which is the singleton type that the literal represents. The broad type of the literal always belongs only to one of the basic types int, float, or decimal. 

For example, the type of literal `10` is integer 10, and its broad type is `int`. This is not always true. Depending on the context, literal `10` can represent floating point value `10.0` or decimal value `10`. 

<!--more-->

{{< gencode >}}

When determining the broad type of a literal following [algorithm](https://ballerina.io/spec/lang/master/#numeric-literal) is used.


{{<mermaid>}}
graph TD;

 subgraph Step 1: Check syntactic form
  CheckLiteral(Check Numeric Literal) --> CheckFloat{Ends with 'f'/'F'?}
  CheckFloat --> |No|CheckFloatHex{Floating Hex Literal?}
  CheckFloatHex --> |No|CheckDecimal{Ends with 'd'/'D'?}
  CheckFloat --> |Yes|F1[float]
  CheckFloatHex --> |Yes|F1
  CheckDecimal --> |No|CheckFloatingLiteral{Floating point literal?}
  CheckDecimal --> |Yes|D1[decimal]
  CheckFloatingLiteral --> |Yes|FD[Candidates are float or decimal]
  CheckFloatingLiteral --> |No|IFD[Candidates are int, float or decimal]
  FD-->Candidates(Possible Candidates - N)
  IFD-->Candidates
 end
 subgraph Step 2: Check Contextually expected type
  CheckContextType(Check contextually expected type T)-->Intersect(Intersection T & N)
  Candidates-->Intersect
  Intersect-->MultipleCandidates{Multiple Candidates?}
  MultipleCandidates-->|No|SingleCandidates{Single Candidates?}
  SingleCandidates-->|int|I2[int]
  SingleCandidates-->|float|F2[float]
  SingleCandidates-->|decimal|D2[decimal]
  SingleCandidates-->|Empty|Error((Error))
  MultipleCandidates-->|yes|HasInt{Has int?}
  HasInt-->|No|HasFloat{Has float?}
  HasInt-->|Yes|I2
  HasFloat-->|Yes|F2
  HasFloat-->|No|D2
end

 {{</mermaid>}}
