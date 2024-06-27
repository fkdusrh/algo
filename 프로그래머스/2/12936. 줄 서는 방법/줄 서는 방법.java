import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> numbers = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }

        k--;

        int index = 0;
        while (index < n) {
            factorial /= n - index;

            int selected = (int) (k / factorial);
            result[index++] = numbers.remove(selected);

            k %= factorial;
        }

        return result;
    }
}
