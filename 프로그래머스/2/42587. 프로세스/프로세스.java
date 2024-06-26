import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int printOrder = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐에 모든 우선순위 추가
        for (int priority : priorities) {
            maxHeap.add(priority);
        }

        // 우선순위 큐가 비워질 때까지 반복
        while (!maxHeap.isEmpty()) {
            for (int index = 0; index < priorities.length; index++) {
                if (priorities[index] == maxHeap.peek()) {
                    maxHeap.poll();
                    printOrder++;
                    if (index == location) {
                        return printOrder;
                    }
                }
            }
        }
        
        return printOrder;
    }
}
