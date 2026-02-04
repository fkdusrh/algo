import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 가로 열
        int b = sc.nextInt();// 세로 행
        
        StringBuilder sb = new StringBuilder(a*b+a);
        
        for(int i=0;i<b;i++){
            for(int j= 0;j<a;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}