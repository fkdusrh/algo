class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n % 3);
            n /= 3;
        }
        
        String s = new String(sb);
        int size = s.length();
        int num = 1;
        
        for(int i=0;i<s.length();i++){
            answer += (num * (s.charAt(size-i-1)-'0'));
            num*=3;
        }
        
        return answer;
    }
}

/*

1. n % 3 -> sb.append -> new String(sb) -> s.charAt() - '0'
2.  for(i ; < arr.length; i*=3)
    1) sum += ( * i)
}

*/
