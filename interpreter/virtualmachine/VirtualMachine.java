package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import interpreter.bytecodes.ByteCode;
import interpreter.loaders.Program;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean isVerbose;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
        this.isVerbose = false;
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);

            code.execute(this);

            if (isVerbose) {
                System.out.println(code);
                System.out.println(runTimeStack.verboseDisplay());
            }

            programCounter++;
        }
    }

    public int push(int value) {
        return this.runTimeStack.push(value);
    }

    public int pop() {
        return this.runTimeStack.pop();
    }

    public int store(int offset) {
        return this.runTimeStack.store(offset);
    }

    public int load(int offset) {
        return this.runTimeStack.load(offset);
    }

    public int peek() {
        return this.runTimeStack.peek();
    }

    public void newFrameAt(int offset) {
        this.runTimeStack.newFrameAt(offset);
    }

    public void popFrame() {
        this.runTimeStack.popFrame();
    }

    public void setProgramCounter(int address) {
        this.programCounter = address;
    }

    public int getProgramCounter() {
        return this.programCounter;
    }

    public void pushReturnAddress(int address) {
        this.returnAddress.push(address);
    }

    public int popReturnAddress() {
        return this.returnAddress.pop();
    }

    public void halt() {
        this.isRunning = false;
    }

    public void setVerbose(boolean verbose) {
        this.isVerbose = verbose;
    }

    public int getStackSize() {
        return this.runTimeStack.getStackSize();
    }

    public int getCurrentFrameSize() {
        return this.runTimeStack.getCurrentFrameSize();
    }

    public List<Integer> getCurrentFrameContents () {
        return this.runTimeStack.getCurrentFrameContents();
    }

}
