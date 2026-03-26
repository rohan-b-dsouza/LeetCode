class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int ops = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            ops += cnt;
            answer[i] = ops;
            cnt += boxes.charAt(i) - '0';
        }
        ops = 0;
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            ops += cnt;
            answer[i] += ops;
            cnt += boxes.charAt(i) - '0';
        }
        return answer;
    }
}