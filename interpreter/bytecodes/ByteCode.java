package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public interface ByteCode {

    // force classes to have this
    String toString();

    void init (List<String> args);

    void execute(VirtualMachine vm);
}
