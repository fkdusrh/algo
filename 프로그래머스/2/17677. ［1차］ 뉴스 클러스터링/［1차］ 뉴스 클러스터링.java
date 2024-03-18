import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        ArrayList<String> unionSet = new ArrayList<>();
        ArrayList<String> interSet = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i=0;i<str1.length()-1;i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);

            if(first>='a' && first<='z' && second>='a' && second<='z'){
                sb.append(first).append(second);
                set1.add(sb.toString());
                sb.setLength(0);
            }
        }

        System.out.println(set1.toString());

        for(int i=0;i<str2.length()-1;i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);

            if(first>='a' && first<='z' && second>='a' && second<='z'){
                sb.append(first).append(second);
                set2.add(sb.toString());
                sb.setLength(0);
            }
        }

        Collections.sort(set1);
        Collections.sort(set2);

        for(String s : set1){
            if(set2.remove(s)){
                interSet.add(s);
            }

            unionSet.add(s);
        }

        for(String s : set2)
            unionSet.add(s);

        double num=1;

        if(unionSet.size()!=0){
           num=(double)interSet.size() / (double) unionSet.size();
        }


        return (int)(num*65536);
    }
}