import java.util.*;
class Solution {
    public static int maxSub = 0;
    public static int maxPrice = 0;
    public static int userCnt;
    public static int[] discounts = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        userCnt = users.length;
        
        int[] discountApplied = new int[emoticons.length];
        combination(users, emoticons, discountApplied, 0);  
            
        return new int[]{maxSub, maxPrice};
    }
    
    public void combination(int[][] users, int[] emoticons, int[] discountApplied, int start) {
        if (start == emoticons.length) {
            int[] result = calculate(users, emoticons, discountApplied);
            
            int subCount = result[0];
            int totalPrice = result[1];

            if (subCount > maxSub || (subCount == maxSub && totalPrice > maxPrice)) {
                maxSub = subCount;
                maxPrice = totalPrice;
            }
            return;
        }

        for (int discount : discounts) {
            discountApplied[start] = discount;
            combination(users, emoticons, discountApplied, start + 1);
        }
    }
    
    public int[] calculate(int[][] users, int[] emoticons, int[] discountApplied) {
        int subCount = 0;
        int totalPrice = 0;

        for (int[] user : users) {
            int userDiscount = user[0];
            int userLimit = user[1];
            int userTotal = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discountApplied[i] >= userDiscount) {
                    userTotal += emoticons[i] * (100 - discountApplied[i]) / 100;
                }
            }

            if (userTotal >= userLimit) {
                subCount++;
            } else {
                totalPrice += userTotal;
            }
        }

        return new int[]{subCount, totalPrice};
    }
}