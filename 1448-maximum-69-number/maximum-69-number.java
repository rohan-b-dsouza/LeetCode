class Solution {
    public int maximum69Number (int num) {
        String x = String.valueOf(num);
        char[] strArr = x.toCharArray();
        for (int i = 0; i < x.length(); i++) {
            if (strArr[i] == '6') {
                strArr[i] = '9';
                break;
            }
        }
        String newNum = new String(strArr);
        return Integer.valueOf(newNum);
    }
}