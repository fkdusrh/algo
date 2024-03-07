import java.util.*;

class Solution {
     public  int solution(int n) {
        int answer = 0;
        Stack<Integer>  stack = new Stack<>();

        while(n>=3){
            stack.add(n%3);
            n/=3;
        }
        stack.add(n);
        //System.out.println(Arrays.toString(stack.toArray()));
        int product = 1;

        while(!stack.isEmpty()){
            answer += (product * stack.pop());
            product*=3;

        }

        return answer;
    }
}