package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class LoadByteCode implements ByteCode {
    private int offset;
    private String identifier;

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

        vm.load(offset);
    }

    public String toString() {
        if (identifier != null) {
            return "LOAD " + offset + " " + identifier + "\t\t\t    <load " + identifier + ">";
        } else {
            return "LOAD " + offset;
        }
    }
}
