class Solution {
    public static String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        String star;
        String number;
        for(int i=0;i<phone_number.length()-4;i++){
            sb.append("*");
        }

       
        sb.append(phone_number.substring(phone_number.length()-4,phone_number.length()));

        return sb.toString();
    }
}