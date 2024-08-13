package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class LitByteCode implements ByteCode {

    private String label;
    private int value;

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(this.value);
    }

    @Override
    public void init(List<String> args) {
        this.value = Integer.parseInt(args.get(1));

        if (args.size() > 2) {
            this.label = args.get(2);
        }
    }

    @Override
    public String toString() {
        String retVal = "LIT " + this.value;

        if (this.label != null ) {
            retVal += this.label + "\t\t\t\tint "  + this.label;
        }

        return  retVal;
    }
}
