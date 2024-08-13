package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

public class ReadByteCode implements ByteCode {

    private int input;

    @Override
    public void init(List<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter an integer: ");
            String userInput = scanner.nextLine();

            try {
                input = Integer.parseInt(userInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        vm.push(input);
    }

    @Override
    public String toString() {
        return "READ";
    }
}
