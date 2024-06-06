import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int numCount;
    static StringBuilder resultBuilder;
    static char[] operators = {' ', '+', '-'};
    static char[] selectedOperators;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        resultBuilder = new StringBuilder();

        int testCases = parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCases; ++testCase) {
            numCount = parseInt(reader.readLine());
            selectedOperators = new char[numCount - 1]; // 연산자는 N-1개 존재한다.
            for (int i = 0; i < 3; ++i) {
                selectedOperators[0] = operators[i];
                performSimulation(1);
            }
            resultBuilder.append("\n");
        }
        System.out.println(resultBuilder);
    }

    private static void performSimulation(int depth) {
        if (depth >= numCount - 1) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= numCount; ++i) {
                numbers.add(i);
            }

            StringBuilder expressionBuilder = new StringBuilder();
            for (int i = 0; i < numCount - 1; ++i) {
                expressionBuilder.append(numbers.get(i)).append(selectedOperators[i]);
            }
            expressionBuilder.append(numCount);

            String expression = expressionBuilder.toString(); // 수식을 완성
            String cleanedExpression = expression.replaceAll(" ", ""); // 공백을 제거한다.
            String[] numberStrings = cleanedExpression.split("[\\-\\+]"); // 숫자만 추린다.

            int result = parseInt(numberStrings[0]);
            int index = 1;
            for (int i = 0; i < numCount - 1; ++i) {
                if (selectedOperators[i] == '+') {
                    result += parseInt(numberStrings[index]);
                    index++;
                }
                if (selectedOperators[i] == '-') {
                    result -= parseInt(numberStrings[index]);
                    index++;
                }
            }

            if (result == 0) {
                resultBuilder.append(expression).append("\n");
            }
            return;
        }
        for (int i = 0; i < 3; ++i) {
            selectedOperators[depth] = operators[i];
            performSimulation(depth + 1);
        }
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
