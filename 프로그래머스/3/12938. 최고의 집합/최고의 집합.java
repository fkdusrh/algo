class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int baseValue = s / n; 
        int remainder = s % n; 

        for (int i = 0; i < n; i++) {
            answer[i] = baseValue;
        }

        for (int i = n - 1; i >= n - remainder; i--) {
            answer[i]++;
        }

        return answer;
    }
}
