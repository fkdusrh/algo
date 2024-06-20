class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int remainder = n % 3;
            n = (remainder == 0) ? (n / 3) - 1 : n / 3;
            answer.insert(0, numbers[remainder]);
        }
        
        return answer.toString();
    }
}
