package interpreter.loaders;

import interpreter.bytecodes.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Program {

    private final List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addCode(ByteCode c) {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList
     * resolving addrss for Goto,Call and FalseBranch
     * bytecodes. These bytecodes can only jump to Label
     * codes that have a matching label value.
     * HINT: make note of what type of data-structure
     * ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {

        HashMap<String, Integer> labelAddressMap = new HashMap<>();

        for (int position = 0; position < this.getSize(); position++) {
            ByteCode currentByteCode = program.get(position);
            if (currentByteCode instanceof LabelByteCode labelByteCode) {
                labelAddressMap.put(labelByteCode.getLabel(), position);
            }
        }

        for (ByteCode byteCode : program) {
            if (byteCode instanceof SymbolicAddress symbolicAddress) {
                Integer address = labelAddressMap.get(symbolicAddress.getLabel());
                if (address != null) {
                    symbolicAddress.setAddress(address);
                }
            }
        }
    }

}