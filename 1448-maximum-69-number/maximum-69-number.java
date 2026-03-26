class Solution {
    public int maximum69Number (int num) {
        int n = num;
        int cnt = 0;
        int idx = -1;
        while (n != 0) {
            int dig = n % 10;
            if (dig == 6) {
                idx = cnt;
            }
            cnt++;
            n = n / 10;
       }
        if (idx == -1) return num;
       long pow = 1;
       for (int i = 1; i <= idx; i++) {
        pow *= 10;
       }

        return (int) (num + (3 * pow));
         
    }
}