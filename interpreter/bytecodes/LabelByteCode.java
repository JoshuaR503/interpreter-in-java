package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class LabelByteCode implements ByteCode {

    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        if (label != null) {
            return "LABEL " + label;
        }
        return "LABEL";
    }

}
