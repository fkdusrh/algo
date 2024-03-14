class Solution {
    public int solution(String s) {
          int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder alpabet = new StringBuilder();
        String[]  NUMBER = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c>='0' && c<='9'){
                sb.append(c);
                continue;
            }

            alpabet.append(c);

            for(int j=0;j<NUMBER.length;j++){
                if(alpabet.toString().equals(NUMBER[j])){
                    System.out.println("나는 숫자"+j+alpabet.toString());
                    alpabet.setLength(0);
                    sb.append(j);

                    break;
                }
            }

        }
        return Integer.parseInt(sb.toString());
    }
}