---
title : "Base64 Byte Array Literal"
date : 2022-07-25T22:52:46+05:30
kind : tip 
tags : ["literal", "byte-array-literal", "byte", "Base64Literal"]
code : ["Base64Literal.bal"]
weight : 10605050002
size : "small"
disableNavChevron : true 
seeMore : true
---

You can use Base64 Byte Array Literal syntax to represent bytes in Base64 encoded form.
<!--more-->

- Base64 Literal uses Base64 alphabet; `A..Z` | `a..z` | `0..9` | `+` | `/`
  - Total 64 characters = 26 Uppercase Letters + 26 Lowercase Letters + 10 numbers + 2 chars. 
  - Each Base64 character represents 6 bits.
  - The [Encoding table](#base-64-encoding-table) is the same as RFC 4648. 

- You need four Base64 characters to represent 3 bytes. 
  - 4 x 6 bits = 24 bits = 3 bytes
- The length of Base64 literal must be a multiple of four. 
  - You can add one or two padding characters `=` to make its length multiple of 4.
  - Single `=` means the last four characters will represent only two bytes.
  - `==` means the last four characters will represent only one byte.
  - `=` or `==` always comes at the end of the literal.
  - [See Examples](#base64-to-byte-explained)
- You can have any white space in between two Base64 Characters. 
  - Group Base64 Characters to improve the readability of your code. 
  - Writing Base64 Characters in a group of 4 characters is a good option. 

{{< gencode >}}

#### Known Limitation. 

- [The byte array type is not inferred properly](https://github.com/ballerina-platform/ballerina-lang/issues/32542)

### Base 64 Encoding Table

<!-- {{<md >}}
|  # | Char | Bits |   |  # | Char | Bits |   |  # | Char | Bits |   |  # | Char | Bits | 
|----|----------|----------|---|----|----------|----------|---|----|----------|----------|---|----|----------|----------|
|  0 | A    |  000000  |   | 16 | Q    |  010000  |   | 32 | g    |  100000  |   | 48 | w    |  110000  |
|  1 | B    |  000001  |   | 17 | R    |  010001  |   | 33 | h    |  100001  |   | 49 | x    |  110001  |
|  2 | C    |  000010  |   | 18 | S    |  010010  |   | 34 | i    |  100010  |   | 50 | y    |  110010  |
|  3 | D    |  000011  |   | 19 | T    |  010011  |   | 35 | j    |  100011  |   | 51 | z    |  110011  |
|  4 | E    |  000100  |   | 20 | U    |  010100  |   | 36 | k    |  100100  |   | 52 | 0    |  110100  |
|  5 | F    |  000101  |   | 21 | V    |  010101  |   | 37 | l    |  100101  |   | 53 | 1    |  110101  |
|  6 | G    |  000110  |   | 22 | W    |  010110  |   | 38 | m    |  100110  |   | 54 | 2    |  110110  |
|  7 | H    |  000111  |   | 23 | X    |  010111  |   | 39 | n    |  100111  |   | 55 | 3    |  110111  |
|  8 | I    |  001000  |   | 24 | Y    |  011000  |   | 40 | o    |  101000  |   | 56 | 4    |  111000  |
|  9 | J    |  001001  |   | 25 | Z    |  011001  |   | 41 | p    |  101001  |   | 57 | 5    |  111001  |
| 10 | K    |  001010  |   | 26 | a    |  011010  |   | 42 | q    |  101010  |   | 58 | 6    |  111010  |
| 11 | L    |  001011  |   | 27 | b    |  011011  |   | 43 | r    |  101011  |   | 59 | 7    |  111011  |
| 12 | M    |  001100  |   | 28 | c    |  011100  |   | 44 | s    |  101100  |   | 60 | 8    |  111100  |
| 13 | N    |  001101  |   | 29 | d    |  011101  |   | 45 | t    |  101101  |   | 61 | 9    |  111101  |
| 14 | O    |  001110  |   | 30 | e    |  011110  |   | 46 | u    |  101110  |   | 62 | +    |  111110  |
| 15 | P    |  001111  |   | 31 | f    |  011111  |   | 47 | v    |  101111  |   | 63 | /    |  111111  |
{{</md>}} -->

<table class="center-ele center-txt tip-data">
    <thead>
        <tr>
            <td>#</td>
            <td>Char</td>
            <td>Bits</td>
            <td style=""></td>
            <td>#</td>
            <td>Char</td>
            <td>Bits</td>
            <td style=""></td>
            <td>#</td>
            <td>Char</td>
            <td>Bits</td>
            <td style=""></td>
            <td>#</td>
            <td>Char</td>
            <td>Bits</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>0</td>
            <td>A</td>
            <td>000000</td>
            <td rowspan="16" style=""></td>
            <td>16</td>
            <td>Q</td>
            <td>010000</td>
            <td rowspan="16" style=""></td>
            <td>32</td>
            <td>g</td>
            <td>100000</td>
            <td rowspan="16" style=""></td>
            <td>48</td>
            <td>w</td>
            <td>110000</td>
        </tr>
        <tr>
            <td>1</td>
            <td>B</td>
            <td>000001</td>
            <td>17</td>
            <td>R</td>
            <td>010001</td>
            <td>33</td>
            <td>h</td>
            <td>100001</td>
            <td>49</td>
            <td>x</td>
            <td>110001</td>
        </tr>
        <tr>
            <td>2</td>
            <td>C</td>
            <td>000010</td>
            <td>18</td>
            <td>S</td>
            <td>010010</td>
            <td>34</td>
            <td>i</td>
            <td>100010</td>
            <td>50</td>
            <td>y</td>
            <td>110010</td>
        </tr>
        <tr>
            <td>3</td>
            <td>D</td>
            <td>000011</td>
            <td>19</td>
            <td>T</td>
            <td>010011</td>
            <td>35</td>
            <td>j</td>
            <td>100011</td>
            <td>51</td>
            <td>z</td>
            <td>110011</td>
        </tr>
        <tr>
            <td>4</td>
            <td>E</td>
            <td>000100</td>
            <td>20</td>
            <td>U</td>
            <td>010100</td>
            <td>36</td>
            <td>k</td>
            <td>100100</td>
            <td>52</td>
            <td>0</td>
            <td>110100</td>
        </tr>
        <tr>
            <td>5</td>
            <td>F</td>
            <td>000101</td>
            <td>21</td>
            <td>V</td>
            <td>010101</td>
            <td>37</td>
            <td>l</td>
            <td>100101</td>
            <td>53</td>
            <td>1</td>
            <td>110101</td>
        </tr>
        <tr>
            <td>6</td>
            <td>G</td>
            <td>000110</td>
            <td>22</td>
            <td>W</td>
            <td>010110</td>
            <td>38</td>
            <td>m</td>
            <td>100110</td>
            <td>54</td>
            <td>2</td>
            <td>110110</td>
        </tr>
        <tr>
            <td>7</td>
            <td>H</td>
            <td>000111</td>
            <td>23</td>
            <td>X</td>
            <td>010111</td>
            <td>39</td>
            <td>n</td>
            <td>100111</td>
            <td>55</td>
            <td>3</td>
            <td>110111</td>
        </tr>
        <tr>
            <td>8</td>
            <td>I</td>
            <td>001000</td>
            <td>24</td>
            <td>Y</td>
            <td>011000</td>
            <td>40</td>
            <td>o</td>
            <td>101000</td>
            <td>56</td>
            <td>4</td>
            <td>111000</td>
        </tr>
        <tr>
            <td>9</td>
            <td>J</td>
            <td>001001</td>
            <td>25</td>
            <td>Z</td>
            <td>011001</td>
            <td>41</td>
            <td>p</td>
            <td>101001</td>
            <td>57</td>
            <td>5</td>
            <td>111001</td>
        </tr>
        <tr>
            <td>10</td>
            <td>K</td>
            <td>001010</td>
            <td>26</td>
            <td>a</td>
            <td>011010</td>
            <td>42</td>
            <td>q</td>
            <td>101010</td>
            <td>58</td>
            <td>6</td>
            <td>111010</td>
        </tr>
        <tr>
            <td>11</td>
            <td>L</td>
            <td>001011</td>
            <td>27</td>
            <td>b</td>
            <td>011011</td>
            <td>43</td>
            <td>r</td>
            <td>101011</td>
            <td>59</td>
            <td>7</td>
            <td>111011</td>
        </tr>
        <tr>
            <td>12</td>
            <td>M</td>
            <td>001100</td>
            <td>28</td>
            <td>c</td>
            <td>011100</td>
            <td>44</td>
            <td>s</td>
            <td>101100</td>
            <td>60</td>
            <td>8</td>
            <td>111100</td>
        </tr>
        <tr>
            <td>13</td>
            <td>N</td>
            <td>001101</td>
            <td>29</td>
            <td>d</td>
            <td>011101</td>
            <td>45</td>
            <td>t</td>
            <td>101101</td>
            <td>61</td>
            <td>9</td>
            <td>111101</td>
        </tr>
        <tr>
            <td>14</td>
            <td>O</td>
            <td>001110</td>
            <td>30</td>
            <td>e</td>
            <td>011110</td>
            <td>46</td>
            <td>u</td>
            <td>101110</td>
            <td>62</td>
            <td>+</td>
            <td>111110</td>
        </tr>
        <tr>
            <td>15</td>
            <td>P</td>
            <td>001111</td>
            <td>31</td>
            <td>f</td>
            <td>011111</td>
            <td>47</td>
            <td>v</td>
            <td>101111</td>
            <td>63</td>
            <td>/</td>
            <td>111111</td>
        </tr>
    </tbody>
</table>

<br/>

### Base64 to Byte Explained

Example 1: ``base64 `AAAB` ``

<table class="center-ele center-txt tip-data">
  <tr>
    <td>Base64</td>
    <td colspan="6">A</td>
    <td colspan="6">A</td>
    <td colspan="6">A</td>
    <td colspan="6">B</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">0</td>
    <td colspan="6">0</td>
    <td colspan="6">0</td>
    <td colspan="6">1</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0000 00001</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">0</td>
    <td colspan="8">0</td>
    <td colspan="8">1</td>
  </tr>
</table>

Example 2: ``base64 `ABB=` ``

<table class="center-ele center-txt tip-data">
  <tr>
    <td>Base64</td>
    <td colspan="6">A</td>
    <td colspan="6">B</td>
    <td colspan="6">B</td>
    <td colspan="6">=</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">0</td>
    <td colspan="6">1</td>
    <td colspan="6">1</td>
    <td colspan="6">X</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0001 0000</td>
    <td colspan="8">x</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">0</td>
    <td colspan="8">16</td>
    <td colspan="8"></td>
  </tr>
</table>

Example 3: ``base64 `BC==` ``

<table class="center-ele center-txt tip-data">
  <tr class>
    <td>Base64</td>
    <td colspan="6">B</td>
    <td colspan="6">C</td>
    <td colspan="6">=</td>
    <td colspan="6">=</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">1</td>
    <td colspan="6">2</td>
    <td colspan="6">X</td>
    <td colspan="6">X</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>1</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0100</td>
    <td colspan="8">X</td>
    <td colspan="8">X</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">4</td>
    <td colspan="8"></td>
    <td colspan="8"></td>
  </tr>
</table>