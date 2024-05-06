import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int currentLeft = 10;
        int currentRight = 12;
        int zero = 11;
        for(int i=0;i<numbers.length;i++){
            int currentNum = numbers[i];
            //1,4,7 은 무조건 L
            if(currentNum == 1 || currentNum == 4 || currentNum == 7){
                sb.append("L");
                currentLeft = currentNum;
                continue;
            }
                //3,6,9 는 무조건 R
            if(currentNum == 3 || currentNum == 6 || currentNum == 9){
                sb.append("R");
                currentRight = currentNum;
                continue;
            }
            //차이가 작은 쪽으로
            if(currentNum == 0)
                currentNum = zero;
            int leftGap = Math.abs(currentLeft - currentNum);
            int rightGap = Math.abs(currentRight - currentNum);
            if(leftGap/3 + leftGap%3 >rightGap/3 + rightGap%3){
                sb.append("R");
                currentRight = currentNum;
                continue;
            }
            if(leftGap/3 + leftGap%3 <rightGap/3 + rightGap%3){
                sb.append("L");
                currentLeft = currentNum;
                continue;
            }
            //차이가 같다면 무슨손잡인지에 따라서
            if(hand.equals("left")){
                sb.append("L");
                currentLeft = currentNum;
                continue;
            }
            
            sb.append("R");
            currentRight= currentNum;
            
        }
        
        return sb.toString();
    }
}