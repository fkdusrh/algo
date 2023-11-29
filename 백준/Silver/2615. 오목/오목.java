import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {

    static final int[][] DIRECTION = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //이미 6개라서 실패한걸 확인했지만 그 다음줄에서는 확인할 방법이 없다. 그렇다면 개수를 저장하는 배열 만들자
        boolean[][][] flag = new boolean[4][19][19];

        //0이 아니면 다음 줄을 확인하기 위해 정수에 저장한다.
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    int color = arr[i][j];
                    //델타배열
                    for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
                        int[] dir = DIRECTION[dirIdx];
                        //이전에 한번 확인했던 자리면 확인할 필요 없음
                        if (flag[dirIdx][i][j]) {
                            continue;
                        }
                        //범위 안벗어나고, 돌 색깔 같으면 계속 확인
                        for (int k = 1; ; k++) {
                            //범위 확인
                            if (i + dir[0] * k < 0 || i + dir[0] * k > 18 || j + dir[1] * k < 0 || j + dir[1] * k > 18) {
                                break;
                            }
                            //오목 색이 다르면 멈춤
                            if (arr[i + dir[0] * k][j + dir[1] * k] != color) {
                                break;
                            }
                            //오목 색이 같으면 확인했다는 표시 남기기
                            flag[dirIdx][i + dir[0] * k][j + dir[1] * k] = true;

                            //5연속이면
                            if (k == 4) {
                                //6번째 칸 색 확인하기 위해 범위 확인하고
                                // 범위 밖이라면 현재 돌 승
                                if (i + dir[0] * 5 < 0 || i + dir[0] * 5 > 18 || j + dir[1] * 5 < 0 || j + dir[1] * 5 > 18 || arr[i + dir[0] * 5][j + dir[1] * 5] != color) {
                                    if (dirIdx != 3) {
                                        System.out.println(color + "\n" + (i + 1) + " " + (j + 1));
                                        return;
                                    }
                                    //왼쪽 아래 -> 오른쪽 위라면 왼쪽 아래칸의 인덱스 출력
                                    System.out.println(color + "\n" + ((i + dir[0] * 4) + 1) + " " + ((j + dir[1] * 4) + 1));

                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("0");

    }
}
