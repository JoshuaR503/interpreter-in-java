package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class StoreByteCode implements ByteCode {
    private int offset;
    private String identifier;
    private int poppedValue;

    @Override
    public void init(List<String> args) {
        this.offset = Integer.parseInt(args.get(1));

        if (args.size() > 2) {
            this.identifier = args.get(2);
        } else {
            this.identifier = null;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        if ( offset < 0 || offset >= vm.getCurrentFrameSize()) {
            return;
        }

        this.poppedValue = vm.pop();
        vm.store(offset);


    }

    @Override
    public String toString() {
        if (identifier != null) {
            return "STORE " + offset + " " + identifier + "\t\t\t " + identifier + " = " + this.poppedValue;
        } else {
            return "STORE " + offset;
        }
    }
}
