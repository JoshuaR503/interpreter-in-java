package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;

public class HaltByteCode implements ByteCode {

    @Override
    public void init(List<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.halt();
    }

    @Override
    public String toString() {
        return "";
    }
}
