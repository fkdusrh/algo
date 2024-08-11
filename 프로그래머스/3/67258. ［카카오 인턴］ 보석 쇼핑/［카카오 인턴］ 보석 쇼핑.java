import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int gemTypes = new HashSet<>(Arrays.asList(gems)).size(); 

        int[] result = new int[2];
        int minLength = Integer.MAX_VALUE;
        int left = 0;

        Map<String, Integer> gemCount = new HashMap<>();

        for (int right = 0; right < gems.length; right++) {
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);

            while (gemCount.get(gems[left]) > 1) {
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                left++;
            }

            if (gemCount.size() == gemTypes && (right - left) < minLength) {
                minLength = right - left;
                result[0] = left + 1;
                result[1] = right + 1;
            }
        }

        return result;
    }
}
