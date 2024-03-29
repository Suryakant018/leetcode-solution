
public class Solution {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>() {{
        put("+", (a, b) -> a + b);
        put("-", (a, b) -> a - b);
        put("/", (a, b) -> a / b);
        put("*", (a, b) -> a * b);
    }};

    private static final Map<String, Integer> digits = new HashMap<>() {{
        for (int digit = -200; digit <= 200; digit++) {
            put(String.valueOf(digit), digit);
        }
    }};

    public int evalRPN(String[] tokens) {
        Stack<Integer> evaluations = new Stack<>();

        for (String token : tokens) {
            if (!evaluations.isEmpty() && operators.containsKey(token)) {
                int b = evaluations.pop();
                int a = evaluations.pop();

                evaluations.push(operators.get(token).apply(a, b));
            } else {
                evaluations.push(digits.get(token));
            }
        }

        return evaluations.peek();
    }
}