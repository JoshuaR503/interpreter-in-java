package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class PopByteCode implements ByteCode {

    private int offset;

    @Override
    public void init(List<String> args) {
        this.offset = Integer.parseInt(args.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {

        if ( offset < 0 || offset >= vm.getCurrentFrameSize()) {
            return;
        }

        for(int i = 0; i < offset; i++) {
            vm.pop();
        }
    }

    @Override
    public String toString() {
        return "POP " + offset;
    }

}
