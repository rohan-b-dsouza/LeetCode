class Solution {
    public int maximum69Number (int num) {
        long n = num;
        long rev = 0;
        while (n != 0) {
            long dig = n % 10;
            rev = rev * 1L * 10 + dig;
            n = n / 10;
        }
        long result = 0;
        long prod = 1;
        boolean flag = false;
        while (rev != 0) {
            long dig = rev % 10;
            if (dig == 6 && !flag) {dig = 9; flag = true;};
            result = dig * prod + result;
            prod *= 10;
            rev = rev / 10;
        }
        long finalResult = 0;
        while (result != 0) {
            long dig = result % 10;
            finalResult = finalResult * 1L * 10 + dig;
            result = result / 10; 
        }
        return (int) finalResult;
    }
}