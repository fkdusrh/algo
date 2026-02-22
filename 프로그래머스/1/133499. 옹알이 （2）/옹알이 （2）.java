class Solution {// 7:20
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String s:babbling){
            String pre = "";
            
            while(s.length()>0){
                boolean matched = false;
                
                for(String word : words){
                    if(s.startsWith(word) && !word.equals(pre)){
                        s = s.substring(word.length());
                        pre = word;
                        matched = true;
                        break;
                    }
                }

                if(!matched)
                    break;
            }
            
            if(s.length() == 0 )
                answer++;
        }
        
        return answer;
    }
}