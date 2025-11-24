class Solution {
    public int waviness(int num) {
        String a = String.valueOf(num);
        int sum = 0;
        for (int i = 1; i < a.length() - 1; i++) {
            if ((a.charAt(i) > a.charAt(i - 1) && a.charAt(i) > a.charAt(i + 1))
                    || (a.charAt(i) < a.charAt(i - 1) && a.charAt(i) < a.charAt(i + 1))) {
                sum++;
            }
        }
        return sum;
    }

    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += waviness(i);
        }
        return sum;
    }
}