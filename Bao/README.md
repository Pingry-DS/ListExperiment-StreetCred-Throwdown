List Experiments
================

A set of quick and dirty methods to benchmark the performance of various List implementations in Java.

Overview
--------
The program records and prints the time required to execute the following methods

1. HeadInsert creates a List and inserts the given payload the specified number of times at the head of the list
2. TailInsert creates a List and inserts the given payload the specified number of times at the tail.
3. MidpointInsert creates a List and inserts the given payload the specified number of times in the middle of the list.
   Rounds down to the nearest integer when calculating midpoint
4. AlternateInsert creates a List and inserts the given payload the specified number of times as if the List
   items were arranged in a circle with new items inserted after every other existing item.

Usage
-----
To run this program,

1. Compile it using the command line "javac 'filename'.java"
2. Run the program using the command line "java 'filename'"

Authors
-------
Bao Pham
Roberto YU

License
-------
Copyright 2017 Bao Pham

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.