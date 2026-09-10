import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] arr = {wallpaper.length, wallpaper[0].length(), 0,0};

        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[0].length();j++){
                if(wallpaper[i].charAt(j) == '#'){
                    arr[0] = Math.min(arr[0], i);
                    arr[1] = Math.min(arr[1], j);
                    arr[2] = Math.max(arr[2], i+1);
                    arr[3] = Math.max(arr[3], j+1);
                }
            }
        }
        
        return arr;
    }
}