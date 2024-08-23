import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0;
        int jobIndex = 0;
        int completedJobs = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        while (completedJobs < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                taskQueue.add(jobs[jobIndex++]);
            }

            if (taskQueue.isEmpty()) {
                currentTime = jobs[jobIndex][0];
            } else {
                int[] currentJob = taskQueue.poll();
                totalTime += currentJob[1] + currentTime - currentJob[0];
                currentTime += currentJob[1];
                completedJobs++;
            }
        }

        return (int) Math.floor(totalTime / jobs.length);
    }
}
