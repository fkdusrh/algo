class Solution {
    public String solution(String X, String Y) {
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for(int i=0;i<X.length();i++){ 
            cntX[X.charAt(i)-'0'] += 1;
        }        
        for(int i=0;i<Y.length();i++){
            cntY[Y.charAt(i)-'0'] += 1;
        }
        
        int total = 0;
        for(int i=0;i<=9;i++){
            total += Math.min(cntX[i],cntY[i]);
        }
        
        if(total == 0)
            return "-1";
        
        if( total == Math.min(cntX[0],cntY[0]))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=9;i>=0;i--){
            int equal = Math.min(cntX[i],cntY[i]);
            
            for(int j=0;j<equal;j++)
                sb.append(i);
        }
       
        return sb.toString();
    }
}