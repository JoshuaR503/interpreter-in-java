package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class BopByteCode implements ByteCode {
    private String operator;

    @Override
    public void init(List<String> args) {
        operator = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

        int secondOperator = vm.pop();
        int firstOperator = vm.pop();

        switch (operator) {
            case "+" -> vm.push(firstOperator + secondOperator);

            case "-" -> vm.push(firstOperator - secondOperator);

            case "*" -> vm.push(firstOperator * secondOperator);

            case "/" -> vm.push(firstOperator / secondOperator);

            case "==" -> vm.push((firstOperator == secondOperator) ? 1 : 0);

            case "!=" -> vm.push((firstOperator != secondOperator) ? 1 : 0);

            case "<=" -> vm.push((firstOperator <= secondOperator) ? 1 : 0);

            case "<" -> vm.push((firstOperator < secondOperator) ? 1 : 0);

            case ">=" -> vm.push((firstOperator >= secondOperator) ? 1 : 0);

            case ">" -> vm.push((firstOperator > secondOperator) ? 1 : 0);

            case "|" -> {
                if (firstOperator == 1) {
                    vm.push(1);
                    break;
                }

                if (firstOperator == 0) {
                    if (secondOperator == 1) {
                        vm.push(1);
                        break;
                    }
                }

                vm.push(0);
            }
            case "&" -> {
                if (firstOperator >= 0 && firstOperator <= 1) {
                    if (secondOperator >= 0 && secondOperator <= 1) {
                        if (firstOperator == secondOperator) {
                            vm.push(1);
                            break;
                        }
                    }
                }

                vm.push(0);
            }
            default -> vm.push(0);
        }
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
