class Solution {
    public int solution(int storey) {
        String storeyString = Integer.toString(storey);
        int[] digits = new int[storeyString.length()];
        
        for (int index = 0; index < storeyString.length(); index++) {
            digits[index] = storeyString.charAt(index) - '0';
        }
        
        int stepsRequired = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > 5) {
                stepsRequired += 10 - digits[i];
                if (i == 0) {
                    stepsRequired++;
                } else {
                    digits[i - 1]++;
                }
            } else if (digits[i] == 5 && i > 0 && digits[i - 1] >= 5) {
                digits[i - 1]++;
                stepsRequired += 5;
            } else {
                stepsRequired += digits[i];
            }
        }
        
        return stepsRequired;
    }
}
