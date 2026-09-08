import java.util.*;

public class Solution {
    
    public int[] solution(int []arr) {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(arr[0]);
        
        for(int n : arr){
            if(ls.get(ls.size()-1) != n){
                ls.add(n);
            }
        }

        return ls.stream().mapToInt(i->i).toArray();
    }
}