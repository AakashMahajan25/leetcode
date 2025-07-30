class Solution {
    // TC->O(N) SC->O(N) (due to recursion stack)
    private int recursiveParse(String s, int index, int result, int sign) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return result * sign;
        }

        int digit = s.charAt(index) - '0';

        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        result = result * 10 + digit;

        return recursiveParse(s, index + 1, result, sign);
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        return recursiveParse(s, index, 0, sign);
    }



    // TC->O(N) SC->O(N)
    // public int myAtoi(String s) {
    //     StringBuilder sb = new StringBuilder();
        // Step 1: Removing Trailing and Leading spaces
        // s = s.trim();
        // if (s.length() == 0) return 0;

        // Step 2: Checking for signs
        // int pointer = 0;
        // int stringLength = s.length();
        // char firstCharacter = s.charAt(0);
        // if (firstCharacter == '+' || firstCharacter == '-') {
        //     sb.append(firstCharacter);
        //     pointer++;
        // }

        // Step 3: Only returning digits
        // while(pointer<stringLength && Character.isDigit(s.charAt(pointer))) {
        //     sb.append(s.charAt(pointer));
        //     pointer++;
        // }

        // Return Statement + Rounding Off
        // String str = sb.toString();
        // if (str.length() == 1 && (firstCharacter == '+' || firstCharacter == '-')) {
        //     return 0;
        // }
        // int ans = 0;
        // if (!str.equals("")) {
        //     try {
        //         ans = Integer.parseInt(str);
        //     } catch (NumberFormatException e) {
        //         if (str.charAt(0) == '-') return Integer.MIN_VALUE;
        //         else return Integer.MAX_VALUE;
        //     }
        // } else return 0;
        
        // return ans;
    // }
}