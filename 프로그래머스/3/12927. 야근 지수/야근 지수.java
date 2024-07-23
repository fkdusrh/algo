import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int task : works) {
            taskQueue.offer(task);
        }

        for (int i = 0; i < n; i++) {
            int largestTask = taskQueue.poll();
            if (largestTask <= 0) break;
            taskQueue.offer(largestTask - 1);
        }

        return calculateSquaredSum(taskQueue);
    }

    private long calculateSquaredSum(PriorityQueue<Integer> taskQueue) {
        long totalSum = 0;
        while (!taskQueue.isEmpty()) {
            int remainingTask = taskQueue.poll();
            totalSum += (long) remainingTask * remainingTask;
        }
        return totalSum;
    }
}
