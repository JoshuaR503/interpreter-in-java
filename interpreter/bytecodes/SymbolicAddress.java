package interpreter.bytecodes;

public interface SymbolicAddress {
    String getLabel();
    void setAddress(int address);
}
