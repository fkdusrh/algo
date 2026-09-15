import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return cities.length * 5;
        class Node{
            String name;
            int time;
            
            Node(String s, int n){
                name = s;
                time = n;
            }
        }
        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        List<Node> ls = new ArrayList<>();
        int minIdx = 0;
        int t = 0;
        for(String city:cities){
            t++;
            boolean hit = false;
            
            for(int i=0;i<ls.size();i++){
                Node n = ls.get(i); 
                
                if(n.name.equals(city)){
                    n.time = t;
                    ls.set(i, n);
                    
                    hit = true;
                    answer += 1;
                    break;
                }
                
                if(n.time < ls.get(minIdx).time){
                    minIdx = i;
                }
            }
            //캐시에 없으면 ls(minIdx) 제거하고, 새로 넣기 
            if(!hit){
                answer += 5;
                
                if(ls.size() < cacheSize){
                    ls.add(new Node(city, t));
                    continue;
                }
                
                ls.remove(minIdx);
                minIdx = 0;
                ls.add(new Node(city, t));
            }
            
        }
        return answer;
    }
}