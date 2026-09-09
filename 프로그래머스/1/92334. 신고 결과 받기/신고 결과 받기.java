import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> reportUser = new HashMap<>();
        HashMap<String, Integer> mailCount = new HashMap<>();
        
        for(String rep: report){
            String[] info = rep.split(" ");
            String from= info[0];
            String to = info[1];
            
            Set<String> set = reportUser.getOrDefault(to, new HashSet<>());
            set.add(from);
            reportUser.put(to, set);
        }
        
        for(String name: id_list){
            Set<String> froms = reportUser.getOrDefault(name, new HashSet<>());
            
            if(froms.size() >= k){
                for(String from: froms){
                    int cnt = mailCount.getOrDefault(from, 0);
                    mailCount.put(from, ++cnt);
                }
            }
        }
        
        for(int i=0;i<id_list.length;i++){
            String name = id_list[i];
            answer[i] = mailCount.getOrDefault(name, 0);
        }
        return answer;
    }
}