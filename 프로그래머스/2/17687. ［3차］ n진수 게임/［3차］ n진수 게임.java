class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int currentTurn = 0;
        
        for (int number = 0; sb.length() < t * m; number++) {
            String convertedNumber = convertToBase(number, n);
            
            for (char digit : convertedNumber.toCharArray()) {
                currentTurn++;
                
                if (currentTurn == p) {
                    sb.append(digit);
                }
                
                if (currentTurn == m) {
                    currentTurn = 0;
                }
            }
        }
        
        return sb.toString().substring(0, t);
    }
    
    private String convertToBase(int number, int base) {
        if (number == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            sb.insert(0, remainder < 10 ? (char)('0' + remainder) : (char)('A' + remainder - 10));
            number /= base;
        }
        return sb.toString();
    }
}
