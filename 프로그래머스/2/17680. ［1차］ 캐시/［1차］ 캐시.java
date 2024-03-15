import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
         int answer = 0;
        int time = 0;

        if (cacheSize == 0)
            return cities.length * 5;

        Frame[] cache = new Frame[cacheSize];


        for (int i = 0; i < cities.length; i++, time++) {

            Frame f = new Frame(time, cities[i]);
            boolean hit = false;
            int minIdx=0;
            for (int j = 0; j < cache.length; j++) {

                if(cache[j]==null){
                    minIdx=j;
                    break;
                }
                if (equal(cache[j].city, f.city)) {
                    hit = true;
                    cache[j].time = time;
                    answer += 1;
                }

                if(cache[minIdx].time>cache[j].time){
                    minIdx=j;
                }
            }
            if (hit)
                continue;

            cache[minIdx]=f;
            answer+=5;

        }
        return answer;
    }
    
     public boolean equal(String s1, String s2){
         if(s1.length()!=s2.length())
            return false;
        int min = Math.min(s1.length(),s2.length());
        for(int i=0;i<min;i++){
           int gap = Math.abs((int)s1.charAt(i)-(int)s2.charAt(i));
            if(gap!='a'-'A' && gap !=0){
                return false;
            }
        }

        return true;
    }
    
    
    
}

class Frame {
    int time;
    String city;

    public Frame(int time, String city) {
        this.time = time;
        this.city = city;
    }
}