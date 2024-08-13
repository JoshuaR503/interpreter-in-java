package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import java.util.List;
import java.util.StringJoiner;

public class CallByteCode implements ByteCode, SymbolicAddress {

    private String label;
    private String functionName;
    private int address;
    private List<Integer> arguments;

    @Override
    public void init(List<String> args) {
        label = args.get(1);

        int index = label.indexOf("<<");

        functionName = (index != -1)
                ? label.substring(0, index)
                : label;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter());

        vm.setProgramCounter(address);

        if (!functionName.isEmpty()) {
            this.arguments = vm.getCurrentFrameContents();
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

        StringJoiner joiner = new StringJoiner(", ");

        // i wasn't sure how else to display the items other than getting them from the stack and display one by one 🥶
        // i know this may break encapsulation, but technically they are not the same ones as they are a copy, and they are not all of them. 🥶🥶
        if (arguments != null && !arguments.isEmpty()) {
            for (Integer number : arguments) {
                joiner.add(number.toString());
            }
        }

        return "CALL " + label + "\t\t" + functionName + "(" + joiner + ")";
    }
}
