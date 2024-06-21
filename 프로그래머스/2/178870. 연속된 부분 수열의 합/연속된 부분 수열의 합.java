class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int start = 0, end = n;
        int currentSum = 0;

        for(int left = 0, right = 0; left < n; left++) {
            while(right < n && currentSum < k) {
                currentSum += sequence[right++];
            }

            if (currentSum == k) {
                int currentRange = right - left - 1;
                if((end - start) > currentRange) {
                    start = left;
                    end = right - 1;
                }
            }

            currentSum -= sequence[left];
        }

        return new int[]{start, end};
    }
}
