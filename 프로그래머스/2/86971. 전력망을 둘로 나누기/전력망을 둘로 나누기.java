import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;        
        List<int[]> wiresList = new ArrayList<>();
        
        for (int[] wire : wires) {
            wiresList.add(wire); 
        }
        
        for(int i=0;i<wires.length;i++){
            int[] wire = wiresList.remove(0);
            int diff = bfs(n, wiresList);
            if(diff < answer)
                answer = diff;
            wiresList.add(wire);
          
        }
        
        return answer;
    }
    
    public int bfs(int n, List<int[]> wires){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        List<Integer> componentCnt = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            q.add(i);
            visited[i] = true;
            int cnt = 0;
            while(!q.isEmpty()){
                int node = q.poll();

                for(int[] edge : wires){
                    if(edge[0] == node && !visited[edge[1]]){
                        q.add(edge[1]);
                        visited[edge[1]]=true;
                    }
                    else if(edge[1]==node && !visited[edge[0]]){
                        q.add(edge[0]);
                        visited[edge[0]]=true;
                    }
                }
               cnt++;
            }
             componentCnt.add(cnt);
         }
        
        return Math.abs(componentCnt.get(0)-componentCnt.get(1));
    }
}