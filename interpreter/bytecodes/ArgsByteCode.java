package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class ArgsByteCode implements ByteCode {
    private int args;

    @Override
    public void init(List<String> args) {
        this.args = Integer.parseInt(args.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(args);
    }

    @Override
    public String toString() {
        return "ARGS " + args;
    }
}
