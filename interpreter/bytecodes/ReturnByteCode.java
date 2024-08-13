package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class ReturnByteCode implements ByteCode {

    private String label;
    private String baseId;
    private int returnVal;

    @Override
    public void init(List<String> args) {
        if (args.size() > 1) {
            label = args.get(1);

            int index = label.indexOf("<<");
            if (index != -1) {
                baseId = label.substring(0, index);
            } else {
                baseId = label;
            }
        }
    }


    @Override
    public void execute(VirtualMachine vm) {
        this.returnVal = vm.peek();

        vm.popFrame();

        vm.push(returnVal);

        int returnAddress = vm.popReturnAddress();
        vm.setProgramCounter(returnAddress);
    }

    @Override
    public String toString() {
        if (label != null) {
            return "RETURN " + label + " EXIT " + baseId + " : " + returnVal;
        } else {
            return "RETURN";
        }
    }
}
