import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Main {

    static int[][] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < col; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = row - 1; j >= row - height; j--) {
                map[j][i] = 1;
            }
        }

        cnt=0;

       /* for (int i = 0; i < row; i++)
            System.out.println(Arrays.toString(map[i]));
*/
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (map[i][j] != 0)
                    continue;

                int leftBlock = findBlockLeft(i, j);
                int rightBlock = findBlockRight(i, j);

               // System.out.println(leftBlock+"/"+rightBlock);

                if (leftBlock >= 0 && rightBlock >= 0) {
                    fillWatar(i, j, rightBlock);
                    j=rightBlock;
                }
            }
        }

       /* System.out.println("===============");
        for (int i = 0; i < row; i++)
            System.out.println(Arrays.toString(map[i]));
*/
        System.out.println(cnt);
    }

    private static void fillWatar(int currentRow, int currentCol, int rightBlock) {
        //System.out.println("벽 채우자");

        while (currentCol < rightBlock) {
            map[currentRow][currentCol++] = 2;
            cnt++;
        }
    }

    private static int findBlockRight(int i, int j) {
        while (j < map[0].length-1) {
            if (map[i][++j] == 1)
                return j;
        }
        return -1;
    }

    private static int findBlockLeft(int i, int j) {
        while (j > 0) {
            if (map[i][--j] == 1)
                return j;
        }
        return -1;

    }

}