package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    // This stack is used to record the beginning of each activation record (frame).
    private final Stack<Integer> framePointer;

    // This list is used to represent the runtime stack.
    // It will be an ArrayList because we will need to access ALL locations of the runtime stack.
    private final ArrayList<Integer> runTimeStack;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    /**
     * Used for displaying the current state of the runTimeStack.
     * It will print portions of the stack based on respective frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6
     */
    public String verboseDisplay() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < framePointer.size(); i++) {
            int start = framePointer.get(i);
            int end = (i == framePointer.size() - 1) ? runTimeStack.size() : framePointer.get(i + 1);

            List<Integer> frameContents = runTimeStack.subList(start, end);

            stringBuilder.append("[");
            for (int j = 0; j < frameContents.size(); j++) {
                stringBuilder.append(frameContents.get(j));
                if (j < frameContents.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            if (i < framePointer.size() - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    /**
     * returns the top of the runtime stack, but does not remove
     * @return copy of the top of the stack.
     */
    public int peek(){
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    /**
     * push the value i to the top of the stack. *
     * @param i value to be pushed
     * @return value pushed
     */
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    /**
     * removes to the top of the runtime stack. *
     * @return the value popped.
     */
    public int pop() {
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    /**
     * Takes the top item of the run time stack,
     * store it into a offset starting from the current frame.
     * @param offsetInFrame number of slots above current frame marker
     * @return the item just stored */
    public int store(int offsetInFrame) {

        int valueToStore = runTimeStack.get(runTimeStack.size() - 1);
        int currentFramePointer = framePointer.peek();

        runTimeStack.set(currentFramePointer + offsetInFrame, valueToStore);

        return valueToStore;
    }

    /**
     * Takes a value from the run time stack that is at offset from the current frame marker and pushes it onto the top of the runtime stack.
     *
     * @param offsetInFrame number of slots above current frame marker
     * @return item just loaded into the offset */
    public int load(int offsetInFrame) {

        int currentFrameMarker = framePointer.peek();
        int targetIndex = currentFrameMarker + offsetInFrame;

        int valueToLoad = runTimeStack.get(targetIndex);

        runTimeStack.add(valueToLoad);

        return valueToLoad;
    }


    /**
     * create a new frame pointer at the index offset slots down from the top of the runtime stack.
     * @param offsetFromTopOfRunStack slots down from the top of the runtime stack
     */
    public void newFrameAt(int offsetFromTopOfRunStack) {
        framePointer.push( runTimeStack.size() -  offsetFromTopOfRunStack);
    }

    /**
     * pop the current frame off the runtime stack.
     * Removes the frame pointer value from the FramePointer Stack.
     */
    public void popFrame() {
        int currentFramePointer = framePointer.pop();
        while (runTimeStack.size() > currentFramePointer) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
    }

    public int getStackSize() {
        return runTimeStack.size();
    }

    /**
     * Gets the size of the current frame.
     * @return the size of the current frame
     */
    public int getCurrentFrameSize() {
        return this.runTimeStack.size() - framePointer.peek();
    }

    /**
     * returns a copy of the current frame in the stack.
     * */
    public List<Integer> getCurrentFrameContents() {
        int startIndex = framePointer.peek();
        int endIndex = runTimeStack.size();

        List<Integer> args = new ArrayList<>(endIndex - startIndex);

        for (int i = startIndex; i < endIndex; i++) {
            args.add(runTimeStack.get(i));
        }

        return args;
    }
}
