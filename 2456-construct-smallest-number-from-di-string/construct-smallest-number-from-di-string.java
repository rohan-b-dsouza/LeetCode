class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i <= n; i++) {
            if(i == n || pattern.charAt(i) == 'I') {
                stack.push(cnt);
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                cnt += 1;
            }
            else {
                stack.push(cnt++);
            }
        }
        return sb.toString();
    }
}