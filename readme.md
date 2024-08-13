# X language Interpreter in Java

**Joshua Garcia**

### 1.1 Project Overview

This is a small project designed to read and make sense of the instructions in a code file for a language called X.

### 1.2 Technical Overview

This program functions as an interpreter that processes bytecodes from a source file for a programming language called X.

### 1.3 Summary of Work Completed

- Implemented all bytecode classes inside the `bytecodes` folder.
  - Implemented `toString`, `execute`, and `init` methods for each class.
  - Implemented `ByteCode` interface.
- Implemented `ByteCodeLoader` to load files.
- Implemented `CodeTable` to map ByteCode structures.
- Implemented `Program` to resolve addresses.
- Implemented the virtual machine to keep track of the program state.
- Implemented the runtime stack to:
  - Manipulate stack content.
  - Display stack content.
  - Keep track of activation records.

## 2. Development Environment

- **Amazon Corretto 20**
- **IntelliJ IDEA Ultimate Edition**
