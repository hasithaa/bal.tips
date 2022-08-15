---
title : "Type of a numeric literal"
date : 2022-07-28T01:28:56+05:30
kind : tip 
tags : ["literal", "numeric-literal", "int", "float", "decimal"]
code : ["numeric-literals.bal"]
weight : 10605030001
size : "small"
disableNavChevron : true 
seeMore : true
---

A value written in a numeric-literal always represents a precise type, which is the singleton type that the literal represents. The broad type of the literal always belongs only to one of the basic types int, float, or decimal. 

For example, the type of literal `10` is integer 10, and its broad type is `int`. This is not always true. Depending on the context, literal `10` can represent floating point value `10.0` or decimal value `10`. 

<!--more-->

{{< gencode >}}

When determining the broad type of a literal, following 3 steps [algorithm](https://ballerina.io/spec/lang/master/#numeric-literal) is used.

{{<mermaid>}}
flowchart TB
 subgraph Step1 [Step 1: Check Syntactic Form]
  direction TB
  CheckLiteral(Check Numeric Literal)
  CheckFloat{Ends With<br><code>f</code>/<code>F</code>?}
  CheckFloatHex{Floating<br>Point<br>Hex<br>Literal?}
  CheckDecimal{Ends With<br><code>d</code>/<code>D</code>?}
  CheckFloatingLiteral{Floating<br>Point<br> Literal?}
  CF[Only Candidate<br><code>float</code>]
  CD[Only Candidate<br><code>decimal</code>]
  CFD[Candidates Are<br><code>float</code>,<code>decimal</code>]
  CIFD[Candidates are<br> <code>int</code>,<code>float</code>,<code>decimal</code>]
  CandidateList[/Create Possible<br>Candidates List /]

  CheckLiteral --> CheckFloat
  CheckFloat --> |No| CheckFloatHex  
  CheckFloatHex --> |No| CheckDecimal  
  CheckDecimal --> |No| CheckFloatingLiteral
  CheckFloat --> |Yes| CF
  CheckFloatHex --> |Yes| CF
  CheckDecimal --> |Yes| CD
  CheckFloatingLiteral --> |Yes| CFD
  CheckFloatingLiteral --> |No| CIFD
  CF-->CandidateList
  CD-->CandidateList
  CFD-->CandidateList
  CIFD-->CandidateList
 end 
 subgraph Step2 [Step 2: Check With Contextually Expected Type]
  direction TB
  CandidateList1(Possible Candidates List)
  Foreach[/For Each Candidate /]
  Candidate("Possible Candidate<br>(N)")
  CheckContextType[/"Check Contextually<br> Expected Type<br>(T)"/]
  Intersect[/Check Intersection<br>T & N/]
  Empty{Empty?}
  Remove[/Remove Candidate<br>From The List/]
  CheckNext{Has<br>Next<br>Candidate?}

  CandidateList1-->Foreach
  Foreach-->Candidate
  CheckContextType-->Intersect
  Candidate-->Intersect
  Intersect-->Empty
  Empty-->|Yes|Remove
  Remove-->CheckNext
  Empty-->|No| CheckNext
  CheckNext-->|Yes|Foreach
  CheckNext-->|No|Continue
 end
 subgraph Step3 [Step 3: Check Updated Candidate List]
  direction TB
  EmptyCandidates{No<br>Possible<br>Candidates}
  HasInt{Has int?}
  HasFloat{Has float?}
  Int((<code>int</code>))
  Float((<code>float</code>))
  Decimal((<code>decimal</code>))
  Stop((Error))

  EmptyCandidates-->|Yes|Stop
  EmptyCandidates-->|No|HasInt
  HasInt-->|Yes|Int
  HasInt-->|No|HasFloat
  HasFloat-->|Yes|Float
  HasFloat-->|No|Decimal
 end
 Step1 --> Step2
 Step2 --> Step3

 {{</mermaid>}}
