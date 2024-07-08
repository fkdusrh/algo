import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int maxDefeated = enemy.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int currentHealth = n;
        int powerUpsRemaining = k;

        for (int i = 0; i < enemy.length; i++) {
            currentHealth -= enemy[i];
            maxHeap.add(enemy[i]);

            if (currentHealth < 0) {
                if (powerUpsRemaining > 0 && !maxHeap.isEmpty()) {
                    currentHealth += maxHeap.poll();
                    powerUpsRemaining--;
                } else {
                    maxDefeated = i;
                    break;
                }
            }
        }

        return maxDefeated;
    }
}
