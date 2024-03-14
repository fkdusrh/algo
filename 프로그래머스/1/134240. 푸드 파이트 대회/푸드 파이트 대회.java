class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<food.length;i++){
            for(int j=0;j<food[i]/2;j++)
                 sb.append(i);
        }
        String originSb = sb.toString();
        String reverseSb = sb.reverse().toString();
        
        StringBuilder resultSb = new StringBuilder();
        resultSb.append(originSb).append("0").append(reverseSb);
        return resultSb.toString();
    }
}