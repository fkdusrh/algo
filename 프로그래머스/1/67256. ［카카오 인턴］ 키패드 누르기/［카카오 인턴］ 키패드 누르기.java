class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftPosition = 10;
        int zeroPosition = 11;
        int rightPosition = 12;
        boolean right = hand.equals("right") ? true:false;
        
        for(int number : numbers){
            if(number % 3 == 1){
                leftPosition = number;
                sb.append('L');
            }
            else if(number == 3 || number == 6 || number == 9){
                rightPosition = number;
                sb.append('R');
            }
            else{
                int leftCnt = moveCount(leftPosition, number);
                int rightCnt = moveCount(rightPosition, number);
                
                if(leftCnt < rightCnt){
                    leftPosition = number;
                    sb.append('L');
                 }else if(leftCnt > rightCnt){
                    rightPosition = number;
                    sb.append('R');
                }else{
                    char h = hand.equals("right")? 'R' : 'L' ;
                    sb.append(h);
                    
                    if(h == 'R')
                        rightPosition = number;
                    else
                        leftPosition = number;
                }
            }
        }
        
        return sb.toString();
    }
    
    public int moveCount(int curNum, int targetNum){
        if (targetNum == 0)
            targetNum = 11;
        if(curNum == 0)
            curNum = 11;
        
        int number = targetNum - curNum;
        if(number<0)
            number *= -1;
        
        int move =  number / 3 + number % 3;
        
        return move;
    }
}