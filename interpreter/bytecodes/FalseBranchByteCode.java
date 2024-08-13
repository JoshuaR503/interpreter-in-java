package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;

public class FalseBranchByteCode implements ByteCode, SymbolicAddress {

    private String label;
    private int address;

    @Override
    public void init(List<String> args) {
        this.label = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.pop();

        if (value == 0) {
            vm.setProgramCounter(address);
        }

    }

    @Override
    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }
}
