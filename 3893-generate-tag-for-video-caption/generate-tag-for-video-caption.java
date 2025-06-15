class Solution {
    public String generateTag(String caption) {
        StringBuilder ans = new StringBuilder("#");
        boolean capitalizeNext = false;
        for (int i = 0; i < caption.length(); i++) {
            char ch = caption.charAt(i);
            if (ch == ' ') {
                if (ans.length() == 1) continue;
                capitalizeNext = true;
            }
            else {
                if (capitalizeNext) {
                    ans.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                }
                else {  
                    ans.append(Character.toLowerCase(ch));
                }
            }
            if (ans.length() == 100) break;
        }
        return ans.toString();
    }
}