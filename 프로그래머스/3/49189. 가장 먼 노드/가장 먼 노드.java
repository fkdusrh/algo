import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> adjList = convertToAdjList(n,edge);
        int[] distance = findMinDistance(adjList, n);
        return findMinDistanceCnt(distance, n);
    }
    
    public static int findMinDistanceCnt(int[] distance, int n){
        Arrays.sort(distance);
        int max = distance[n-1];
        int cnt = 1;
        for(int i=n-2;i>=0;i--){
            if(max == distance[i])
                cnt++;
            else 
                break;
        }
        return cnt;
    }
    
    public static int[] findMinDistance(List<List<Integer>> adjList, int n){
        int distance[] = new int[adjList.size()];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));

        pq.add(new int[]{0, 0});
        visited[0] = true;
        distance[0] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];
            
            if (dist > distance[node]) continue;
            
            for(int adjNode:adjList.get(node)){
                if(dist + 1 < distance[adjNode]){
                    distance[adjNode] = dist + 1;
                    pq.add(new int[] {adjNode, distance[adjNode]});
                }
            }
        }
        return distance;
    }
    public static List<List<Integer>> convertToAdjList(int n, int[][] adges){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] adge:adges){
            int u = adge[0];
            int v = adge[1];
            
            adjList.get(u-1).add(v-1);
            adjList.get(v-1).add(u-1);
        }
        return adjList;
    }
}