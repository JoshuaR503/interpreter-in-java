package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class WriteByteCode implements ByteCode {

    @Override
    public void init(List<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int topValue = vm.peek();
        System.out.println(topValue);

    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
