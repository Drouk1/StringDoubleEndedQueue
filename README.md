# Project Title: Data Structures in Java - DNA Palindrome Checker and Prefix to Infix Converter

## Table of Contents
- [Part A: Generic Double-Ended Queue Implementation](#part-a-generic-double-ended-queue-implementation)
- [Part B: Prefix to Infix Conversion](#part-b-prefix-to-infix-conversion)
- [Part C: DNA Palindrome Checker](#part-c-dna-palindrome-checker)

---

## Part A: Generic Double-Ended Queue Implementation
In this section, we present the implementation of a generic double-ended queue (`GenericDoubleEndedQueueImpl<T>`), a fundamental data structure that allows efficient insertion and removal operations at both ends. 

### Features
- **Generic Implementation**: Works with any object type.
- **Constant Time Operations**: Insertions and deletions (`addFirst`, `addLast`, `removeFirst`, `removeLast`) are performed in O(1) time.
- **Size Retrieval**: The `size` method provides O(1) access to the number of elements in the queue.

---

## Part B: Prefix to Infix Conversion
The application converts arithmetic expressions from prefix notation to infix notation, demonstrating the practical use of the double-ended queue implemented in Part A.

### Process
- The program reads a prefix expression from the user input.
- Each character of the expression is processed in reverse order.
- Operands are directly enqueued, while operators trigger the formation of sub-expressions using elements from the queue.
- The final result is an infix expression, formatted with appropriate parentheses.

### Example
For the prefix expression `*+AB-CD`, the output will be `((A+B)*(C-D))`.

---

## Part C: DNA Palindrome Checker
This section introduces a DNA Palindrome Checker, which leverages the double-ended queue to determine if a given DNA sequence is a Watson-Crick complemented palindrome.

### Functionality
- Validates the input DNA sequence for the presence of only the characters A, T, C, and G.
- Analyzes the sequence to check if it is a Watson-Crick complemented palindrome, a special sequence where each nucleotide is matched with its complement (A with T, and C with G) in a reversed order.

### Usage
- The user inputs a DNA sequence.
- The program assesses the sequence and outputs whether it is a Watson-Crick complemented palindrome.

---

## Getting Started
These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites
- Java Development Kit (JDK)
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans) or a simple text editor

### Installation
1. Clone the repo or download the source code.
2. Open the project in your IDE or compile the source files using the Java compiler from the command line.
3. Run the main methods in each part to test the functionalities.

### Contributing
Contributions to enhance the functionalities or improve the efficiency of the algorithms are welcome. Please feel free to fork the repository and submit pull requests.

### License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

---

## Contact
For any queries or suggestions, please open an issue in the GitHub repository or contact the repository owner directly.

---
