import java.util.*;
class Solution {
     public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> park = new HashMap<>();
        Map<String, Integer> costs = new TreeMap<>();

        for (String r : records) {
            String[] record = r.split(" ");
            int time = converMin(record[0]); // 출차 시간
            String Number = record[1]; // 차량번호
            String io = record[2]; // 출입

            if (io.equals("IN")) {
                park.put(Number, time);
                continue;
            }
            if (io.equals("OUT")) {
                if (!costs.containsKey(Number)) {
                    costs.put(Number, time - park.get(Number));
                } else { 
                    costs.put(Number, costs.get(Number) + time - park.get(Number));
                }
                park.remove(Number);
            }
        }

        if (!park.isEmpty()) {
            for (String Number : park.keySet()) {
                Integer cost = costs.get(Number);
                cost = (cost == null) ? 0 : cost;
                costs.put(Number, cost + (23 * 60 + 59) - park.get(Number));
            }
        }

        List<Integer> answer = new ArrayList<>(costs.size());
        for (Integer c : costs.values()) {
            int defaultT = fees[0];
            int defaultM = fees[1];
            int unitT = fees[2];
            int unitM = fees[3];
            
            int charge = defaultM;
            
            if (c > defaultT) {
                charge =(int) (defaultM + Math.ceil((double) (c - defaultT) / unitT) * unitM);
            } 
            
            answer.add(charge);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    
    private static int converMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}