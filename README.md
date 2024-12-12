


Ex1 - Number Formatting Converter and Calculator
Overview
This Java program provides utilities for working with numbers represented in custom bases (2 to 16). The program implements several key functionalities, including base conversions, validation of number formats, arithmetic operations, and utility methods for number manipulation.
This project provides a robust solution for handling, validating, and performing calculations on numbers in bases 2 to 16. Each function is designed to be modular, focusing on a specific task, from format validation to arithmetic operations.

Function Descriptions

1. number2Int(String num)
Purpose: Converts a number in the format <number>b<base> to its decimal (int) representation.
Behavior:
If the input is not valid, returns -1.
Splits the number and base and calculates the decimal value using positional notation.
2. isNumber(String a)
Purpose: Validates whether a string is in the correct <number>b<base> format.
Behavior:
Checks for valid base values (2 to 16).
Ensures digits in the number do not exceed the specified base.
Returns true if the format is valid, otherwise false.
3. int2Number(int num, int base)
Purpose: Converts a decimal integer to a string representation in the specified base.
Behavior:
If num < 0 or the base is not between 2 and 16, returns an empty string.
Uses division and modulo operations to generate the base representation.
4. equals(String n1, String n2)
Purpose: Checks if two numbers (in string format) represent the same value.
Behavior:
Converts both numbers to decimal and compares their values.
5. maxIndex(String[] arr)
Purpose: Finds the index of the largest number in an array of formatted strings.
Behavior:
Ignores invalid numbers (-1 value).
Returns the index of the first maximum if multiple values are equal.
6. checkDigit(String n)
Purpose: Validates that a string contains only numeric characters.
Behavior:
Returns true if all characters are digits, otherwise false.
7. numSwitch(String num)
Purpose: Converts a character or string representing a single digit or letter to its numeric value.
Behavior:
Handles digits (0-9) and letters (A-F) for bases above 10.
Returns -1 for invalid inputs.
8. baseSwitch(String num)
Purpose: Converts a base (in string format) to its numeric value.
Behavior:
Handles valid bases (2-16).
Returns -1 for invalid inputs.
9. multi(String n1, String n2, String base)
Purpose: Multiplies two numbers and returns the result in the specified base.
Behavior:
Converts both numbers to decimal, performs the multiplication, and converts the result back to the target base.
10. add(String n1, String n2, String base)
Purpose: Adds two numbers and returns the result in the specified base.
Behavior:
Converts both numbers to decimal, performs the addition, and converts the result back to the target base.


