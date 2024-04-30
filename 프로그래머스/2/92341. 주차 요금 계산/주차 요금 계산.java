import java.util.*;
class Solution {
     public static int[] solution(int[] fees, String[] records) {


        HashMap<String,Integer> map = new HashMap<>();//<차량번호, 입차 시간 분으로 환산>
        HashMap<String,Integer> time = new HashMap<>(); // <차량번호, 총 체류 시간 분으로 환산>
        for(int i=0;i<records.length;i++){
            String[] temp = records[i].split(" ");
            int currentTime = convertToMinute(temp[0]); // 00:00
            String number = temp[1];
            String init = temp[2];// IN vs OUT

            if(init.equals("IN")){
                map.put(number,currentTime);
                continue;
            }
            int startTime = map.get(number);

            int totalTime = time.getOrDefault(number,0) + circulateTime(startTime, currentTime);
            map.remove(number);
            time.put(number,totalTime);

        }
        // map 에 하나라도 있으면 싹다 23:59 로 해서 계산해서 time 으로 옮기기
        map.forEach((carNum, startTime) -> {
            int totalTime = time.getOrDefault(carNum, 0) + circulateTime(startTime, 1439);
            time.put(carNum, totalTime);
        });
         
        //time.sort((s1[0], s2[0]) -> s1.compareTo(s2));
        Map<String, Integer> sortedMap = new TreeMap<>(time);
        //time 에 있는 모든 값들에 대하여 요금 계산
        List<Integer> fromMap = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : sortedMap.entrySet()){
            int money = entry.getValue();
            fromMap.add(money);
        }


        List<Integer> ans = new ArrayList<>();

        for(int a : fromMap){
            int basic = fees[1];
            int overTime = a - fees[0];
            if(overTime<0){
                ans.add(basic);
                continue;
            }
            int unitTime = overTime / fees[2];

            if(overTime % fees[2]>0) {
                unitTime++;
            }

            ans.add(basic + unitTime * fees[3]);

        }


        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static int convertToMinute(String time){
        String[] temp = time.split(":");

        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);

        return minute + hour*60;
    }

    public static int circulateTime(int start, int end){
        return end - start;
    }
}