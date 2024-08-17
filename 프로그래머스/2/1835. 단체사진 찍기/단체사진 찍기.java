import java.util.*;
import java.lang.*;
class Solution {
    
    public static char[][] conditions;
    public static final Character[] PEOPLE={'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static Boolean[] isInLine;
    public static int ableLineCnt=0;
    public int solution(int n, String[] data) {
        convertToCharArr(n, data);
        
        isInLine = new Boolean[PEOPLE.length];
        Arrays.fill(isInLine, false); 

        ableLineCnt=0;
        StringBuilder line = new StringBuilder();
        
        permutation(line);
        return ableLineCnt;
    }
 
    
    public void permutation(StringBuilder line){
        //기저조건
        if(line.length() == PEOPLE.length){
            if(checkCondition(line))
                ableLineCnt++;  
            return;
        }
        //순열
        for(int i = 0;i < PEOPLE.length;i++){
            if(isInLine[i])
                continue;
            line.append(PEOPLE[i]);
            isInLine[i]=true;
            //if(checkCondition(line))
              //  continue;
            permutation(line);
            line.deleteCharAt(line.length() - 1);
            isInLine[i]=false;
        }
    }
    
    public boolean checkCondition(StringBuilder line){
        for(char[] condition:conditions){
            
            int from = line.indexOf(Character.toString(condition[0]));
            int to = line.indexOf(Character.toString(condition[1]));
            
            int distance = Math.abs(from - to);
            if(condition[2]=='='){
                if(distance-1!=condition[3]-'0')
                    return false;
            }else if(condition[2]=='<'){
                if(distance > condition[3]-'0')
                    return false;
            }else{
                if(distance < condition[3]-'0' + 2)
                    return false;
            }
        }//foreach
        return true;
    }
    
    public char[][] convertToCharArr(int n, String[] datas){
        conditions = new char[n][4];

        for(int i=0;i<n;i++){
            char[] data = datas[i].toCharArray();
            conditions[i][0] = data[0];
            conditions[i][1] = data[2];
            conditions[i][2] = data[3];
            conditions[i][3] = data[4];
        }
        return conditions;
    }

}