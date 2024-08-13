import java.util.Arrays;

public class Solution {
    public static long[] solution(long[] numbers) {
        long[] results = numbers.clone();
        
        for (int index = 0; index < numbers.length; index++) {
            long originalValue = numbers[index];
            long newValue = originalValue + 1;
            long difference = newValue ^ originalValue;
            results[index] = newValue + (difference >> 2);
        }
        
        return results;
    }
}
