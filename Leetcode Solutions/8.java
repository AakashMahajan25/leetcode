class Solution {
    // TC->O(N) SC->O(N)
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        // Step 1: Removing Trailing and Leading spaces
        s = s.trim();
        if (s.length() == 0) return 0;

        // Step 2: Checking for signs
        int pointer = 0;
        int stringLength = s.length();
        char firstCharacter = s.charAt(0);
        if (firstCharacter == '+' || firstCharacter == '-') {
            sb.append(firstCharacter);
            pointer++;
        }

        // Step 3: Only returning digits
        while(pointer<stringLength && Character.isDigit(s.charAt(pointer))) {
            sb.append(s.charAt(pointer));
            pointer++;
        }

        // Return Statement + Rounding Off
        String str = sb.toString();
        if (str.length() == 1 && (firstCharacter == '+' || firstCharacter == '-')) {
            return 0;
        }
        int ans = 0;
        if (!str.equals("")) {
            try {
                ans = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (str.charAt(0) == '-') return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        } else return 0;
        
        return ans;
    }
}