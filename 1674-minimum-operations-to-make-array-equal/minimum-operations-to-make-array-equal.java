class Solution {
    public int minOperations(int n) {
        if (n % 2 == 0) {
        int firstTerm = 2;
        int lastTerm = 2 + ((n / 2 - 1) * 4);
        int Sn = (firstTerm + lastTerm) * (n / 2) / 2;
        return Sn / 2;

        }
        else {
            int firstTerm = 4;
            int lastTerm = 4 * (n / 2);
            int Sn = (firstTerm + lastTerm) * (n / 2) / 2;
            return Sn / 2;
        }
    }
}


// fix for odd 'n'