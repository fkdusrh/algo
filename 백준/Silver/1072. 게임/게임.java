import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x, y;

         x = Long.parseLong(st.nextToken());
         y = Long.parseLong(st.nextToken());



        long left = 0;
        long right = 2000000000;

        long z = 100 * y / x;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }


        while (left < right) {
            long center = (left+right)/2;
            long newWin = 100 * (y + center) / (x + center) ;

             if (newWin > z ) {
                right = center;
            }else{
                left = center + 1;
            }
        }

        System.out.println(String.valueOf(right));


    }
}