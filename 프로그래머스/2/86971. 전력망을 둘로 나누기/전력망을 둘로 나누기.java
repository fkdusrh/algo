import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = initGraph(n,wires);
        int minGap = n;
        
        for(int i=0 ; i< wires.length ;i++){
            int ignoreNode1 = wires[i][0];
            int ignoreNode2 = wires[i][1];
            
            int areaTopCnt = bfs(graph, ignoreNode1, ignoreNode2, n);
            
            int gap = Math.abs(n - 2* areaTopCnt);
            if(minGap > gap)
                minGap = gap;
        }
        return minGap;
    }
    
    
    public int bfs(Map<Integer, List<Integer>> graph, int ignoreNode1, int ignoreNode2, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        q.add(1);
        visited[0] = true;
        int areaTopCnt=1;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nextNode: graph.get(node)){
                if(visited[nextNode-1])
                    continue;
                if(node == ignoreNode1 && nextNode == ignoreNode2)
                    continue;
                if(nextNode == ignoreNode1 && node == ignoreNode2)
                    continue;   

                q.add(nextNode);
                areaTopCnt++;
                visited[nextNode-1]=true;
            }
        }
        return areaTopCnt;
    }
    
    public Map<Integer, List<Integer>> initGraph(int n, int[][] wires){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<wires.length;i++){
            graph.putIfAbsent(wires[i][0], new LinkedList<>());
            graph.get(wires[i][0]).add(wires[i][1]);
            
            graph.putIfAbsent(wires[i][1], new LinkedList<>());
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        return graph;
    }
}