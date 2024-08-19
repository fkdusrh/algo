import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = convertToAdjList(n, edges);
        
        return bfs(adjList, n);
    }
    
    public static int bfs(List<List<Integer>> adjList, int n){
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[n];
        
        q.add(0);
        visited[0]=true;
        distances[0] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode: adjList.get(node)){
                if(visited[adjNode])
                    continue;
                q.add(adjNode);
                visited[adjNode]=true;
                distances[adjNode] = distances[node]+1; 
            }
        }
        
        Arrays.sort(distances);
        int max = distances[n-1];
        int cnt = 1;
        for(int i=n-2;i>=0;i--){
            if(max == distances[i])
                cnt++;
            else 
                break;
        }
        return cnt;
    }
    
    public static List<List<Integer>> convertToAdjList(int n, int[][] edges){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int start = edge[0];
            int end = edge[1];
            
            adjList.get(start-1).add(end-1);
            adjList.get(end-1).add(start-1);
        }
        return adjList;        
    }
}