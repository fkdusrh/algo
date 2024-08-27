class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        boolean foundPalindrome = false;

        for (int length = n; length >= 1; length--) {
            for (int start = 0; start <= n - length; start++) {
                boolean isPalindrome = true;
                int left = start;
                int right = start + length - 1;

                while (left < right) { 
                    if (s.charAt(left) != s.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isPalindrome) {
                    answer = length;
                    foundPalindrome = true;
                    break;
                }
            }

            if (foundPalindrome) {
                break;
            }
        }

        return answer;
    }
}
