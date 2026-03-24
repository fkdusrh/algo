import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return 5 * cities.length;
        
        int answer = 0;
        List<String> ls = new ArrayList<>();
        
        for(String city:cities){
            city = city.toLowerCase();
            int index = -1;
            
            for(int i=0;i<ls.size();i++){
                if(city.equals(ls.get(i))){
                    index = i;
                    break;
                }
            }
            
            if(index  == -1){//캐시에 없음
                if(ls.size() == cacheSize) //캐시가 꽉 찼을 때
                    ls.remove(0);// 가장 오래 안쓰인 프레임 지운다.
                answer += 5; 
            }else{//캐시에 있음
                ls.remove(index);
                answer++;
            }
            
            ls.add(city);
        }
        return answer;
    }
}