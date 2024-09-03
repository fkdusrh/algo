import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        int[] stack = new int[n];
        int top = -1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (top != -1 && sequence[stack[top]] < sequence[i]) {
                sequence[stack[top--]] = sequence[i];
            }
            stack[++top] = i;
        }

        for (int i = top; i >= 0; i--) {
            sequence[stack[i]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : sequence) {
            sb.append(value).append(' ');
        }

        System.out.println(sb);
    }
}
