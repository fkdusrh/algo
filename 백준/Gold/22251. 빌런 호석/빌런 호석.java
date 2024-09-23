import java.io.*;
import java.util.*;

public class Main {

    static int n, k, p, x;
    static int[][] display = {
        {1, 1, 1, 0, 1, 1, 1}, 
        {0, 0, 1, 0, 0, 0, 1}, 
        {0, 1, 1, 1, 1, 1, 0}, 
        {0, 1, 1, 1, 0, 1, 1}, 
        {1, 0, 1, 1, 0, 0, 1}, 
        {1, 1, 0, 1, 0, 1, 1}, 
        {1, 1, 0, 1, 1, 1, 1}, 
        {0, 1, 1, 0, 0, 0, 1}, 
        {1, 1, 1, 1, 1, 1, 1}, 
        {1, 1, 1, 1, 0, 1, 1}
    };
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] x_digit = num_to_digit(x);
        check(x_digit);
        System.out.println(count);
    }

    public static void check(int[] x_digit) {
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            if (can_reverse(i, x_digit)) count++;
        }
    }

    public static boolean can_reverse(int target, int[] x_digit) {
        int[] target_digit = num_to_digit(target);

        int diff_count = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (display[x_digit[i]][j] != display[target_digit[i]][j]) {
                    diff_count++;
                    if (diff_count > p) return false;
                }
            }
        }
        return true;
    }

    public static int[] num_to_digit(int x) {
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
}
