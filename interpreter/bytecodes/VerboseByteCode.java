package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Objects;

public class VerboseByteCode implements ByteCode {

    private boolean isOn;

    @Override
    public void init(List<String> args) {
        isOn = Objects.equals((String) args.get(1), "ON");
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setVerbose(isOn);
    }

    @Override
    public String toString() {
        return "VERBOSE " + (isOn ? "ON" : "OFF");
    }
}
