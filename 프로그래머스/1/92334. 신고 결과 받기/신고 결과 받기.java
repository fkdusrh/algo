import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> reportsMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        int[] answer = new int[id_list.length];


        for (String r : report) {
            String[] parts = r.split(" ");
            String from = parts[0];
            String to = parts[1];

            reportsMap.putIfAbsent(to, new HashSet<>());
            reportsMap.get(to).add(from);
        }
        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }


        for (Map.Entry<String, Set<String>> entry : reportsMap.entrySet()) {
            Set<String> reporters = entry.getValue();
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    int idx = indexMap.get(reporter);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
