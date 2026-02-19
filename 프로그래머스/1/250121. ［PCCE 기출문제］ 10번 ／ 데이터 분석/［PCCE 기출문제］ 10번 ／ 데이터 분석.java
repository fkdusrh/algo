import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        final String[] DATA = {"code", "date", "maximum", "remain"};
        int[][] arr = new int[data.length][4];
        int selectStd, sortStd;
        
        for(selectStd=0;selectStd<data.length;selectStd++){
            if(ext.equals(DATA[selectStd]))
                break;
        }
        
        for(sortStd=0;sortStd<data.length;sortStd++){
            if(sort_by.equals(DATA[sortStd]))
                break;
        }
        
        int idx = 0;
        for(int i=0;i<data.length;i++){
            if(data[i][selectStd] < val_ext){
                arr[idx++] = data[i]; 
            }
        }
        
        int[][] answer = Arrays.copyOf(arr, idx);
        answer = sort(answer, sortStd);
        
        return answer;
    }
    
    public int[][] sort(int[][] datas, int standard){
        Arrays.sort(datas, (a,b)->
            Integer.compare(a[standard],b[standard])
        );
        
        return datas;
    }
}