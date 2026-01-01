class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> list = new LinkedList<>(); 
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int currDigit = digits[i] + carry;
            if (currDigit == 10) {
                carry = 1;
                list.addFirst(0);
            }
            else {
                carry = 0;
                list.addFirst(currDigit);
            }
            
        }
        if (carry == 1) list.addFirst(carry);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}