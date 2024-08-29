import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] charValues = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int length = str.length();
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                charValues[c - 'A'] += Math.pow(10, length - 1 - j);
            }
        }

        Arrays.sort(charValues);

        int num = 9;
        int ans = 0;
        for (int i = 25; i >= 0 && charValues[i] != 0; i--) {
            ans += charValues[i] * num;
            num--;
        }

        System.out.println(ans);
    }
}
