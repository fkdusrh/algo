import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        Arrays.sort(weights);
        Map<Double, Integer> frequencyMap = new HashMap<>();
        
        for (int weight : weights) {
            double original = weight * 1.0;
            double twoThirds = (weight * 2.0) / 3.0;
            double half = (weight * 1.0) / 2.0;
            double threeFourths = (weight * 3.0) / 4.0;
            
            result += frequencyMap.getOrDefault(original, 0);
            result += frequencyMap.getOrDefault(twoThirds, 0);
            result += frequencyMap.getOrDefault(half, 0);
            result += frequencyMap.getOrDefault(threeFourths, 0);
            
            frequencyMap.put(original, frequencyMap.getOrDefault(original, 0) + 1);
        }
        
        return result;
    }
}
