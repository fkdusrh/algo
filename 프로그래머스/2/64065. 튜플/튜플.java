import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        String[] groups = s.split("},\\{");
        
        List<int[]> list = new ArrayList<>();
        
        for (String group : groups) {
            group = group.replace("{", "").replace("}", "");
            String[] numbers = group.split(",");
            
            int[] numberArray = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numberArray[i] = Integer.parseInt(numbers[i]);
            }
            
            list.add(numberArray);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a.length, b.length));
        
        List<Integer> answer = new ArrayList<>();
        for(int[] numbers : arr) {
            for(int number : numbers) {
                if(!map.containsKey(number)) {
                    map.put(number, 1);
                    answer.add(number);
                }
            }
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
   
        return result;
    }
}