import java.util.HashMap;
import java.util.Map;
class Solution {


    public int solution(int[] toppings) {
        int count = 0;

        Map<Integer, Integer> brotherMap = new HashMap<>();
        Map<Integer, Integer> sisterMap = new HashMap<>();

        for (int topping : toppings) {
            sisterMap.put(topping, sisterMap.getOrDefault(topping, 0) + 1);
        }

        for (int topping : toppings) {
            brotherMap.put(topping, brotherMap.getOrDefault(topping, 0) + 1);

            if (sisterMap.get(topping) == 1) {
                sisterMap.remove(topping);
            } else {
                sisterMap.put(topping, sisterMap.get(topping) - 1);
            }

            if (brotherMap.size() == sisterMap.size()) {
                count++;
            }
        }

        return count;
    }

}