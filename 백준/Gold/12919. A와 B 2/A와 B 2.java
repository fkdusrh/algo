import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        System.out.println(dfs(s, t));
    }

    public static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            if (dfs(s, sb.reverse().toString()) == 1) {
                return 1;
            }
        }

        if (t.charAt(t.length() - 1) == 'A') {
            if (dfs(s, t.substring(0, t.length() - 1)) == 1) {
                return 1;
            }
        }

        return 0;
    }
}
