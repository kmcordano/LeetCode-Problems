class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> solutions = new ArrayList<>();

        for(int index = 0; index < expression.length(); index++) {
            char currentChar = expression.charAt(index);

            if(currentChar == '+' || currentChar == '-' || currentChar == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, index));
                List<Integer> s2 = diffWaysToCompute(expression.substring(index + 1));

                for(int a : s1) {
                    for(int b : s2) {
                        if(currentChar == '+') {
                            solutions.add(a + b);
                        }
                        else if(currentChar == '-') {
                            solutions.add(a - b);
                        }
                        else if(currentChar == '*') {
                            solutions.add(a * b);
                        }
                    }
                }
            }
        }

        if(solutions.isEmpty()) {
            solutions.add(Integer.parseInt(expression));
        }

        return solutions;
    }
}
