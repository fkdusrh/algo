import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int computerN = Integer.parseInt(br.readLine().trim());
        boolean[][] network = new boolean[computerN][computerN];

        int connetionN = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<connetionN;i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a-1][b-1]=true;
            network[b-1][a-1]=true;
        }

   
        Stack<Integer> s = new Stack<>();
        boolean[] flag = new boolean[computerN];
        s.add(0);
        int cnt=0;
        while(!s.isEmpty()){
            int cur = s.pop();

            for(int i=0;i<computerN;i++){
                if(network[cur][i]){
                    network[cur][i]=false;
                    s.add(i);
                    flag[i]=true;
                }
            }
        }

        for(int i=1;i<computerN;i++)
            if(flag[i])
                cnt++;

        System.out.println(cnt);
    }



}
