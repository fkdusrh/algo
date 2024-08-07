class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int currentDeliveryLoad = 0; 
        int currentPickupLoad = 0; 

        for (int i = n - 1; i >= 0; i--) {
            currentDeliveryLoad -= deliveries[i];
            currentPickupLoad -= pickups[i];

            while (currentDeliveryLoad < 0 || currentPickupLoad < 0) {
                currentDeliveryLoad += cap;
                currentPickupLoad += cap;
                answer += (i + 1) * 2; 
            }
        }

        return answer;
    }
}
