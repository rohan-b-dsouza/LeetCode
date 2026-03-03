class Solution {
    public String reverseInvert(StringBuilder sb) {
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            temp.append(ch == '0' ? "1" : "0");
        } 
        return temp.reverse().toString();
    }
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder("");
            temp.append(sb).append("1");
            temp.append(reverseInvert(sb));   
            sb = temp;
        }
        System.out.println(sb.toString());
        return sb.charAt(k - 1);
    }
}