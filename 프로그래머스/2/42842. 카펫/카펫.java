import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        for(int h=1;h <= yellow/h; h++){
            if(yellow%h != 0)
                continue;
            
            int width =yellow/h;
            if((width +2 )*2 + h *2 == brown){
                return new int[]{width+2, h+2};
            }
        }
        return new int[]{};
    }
}