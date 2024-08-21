class Solution {
    public int solution(int[] stones, int k) {
        int result = 0;
        int low = 1;
        int high = 200000000;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canCross(stones, k, mid)) {
                low = mid + 1;
                result = Math.max(result, mid);
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canCross(int[] stones, int k, int people) {
        int consecutiveSkips = 0;
        
        for (int stone : stones) {
            if (stone - people < 0)
                consecutiveSkips++;
            else
                consecutiveSkips = 0;
            
            if (consecutiveSkips >= k)
                return false;
        }
        
        return true;
    }
}
