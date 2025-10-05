class Solution {
    public String removeSubstring(String s, int k) {
        Deque<int[]> dq = new ArrayDeque<>(); // each int[] = {chAsInt, count}
        
        for (char c : s.toCharArray()) {
            if (dq.isEmpty() || dq.peekLast()[0] != c) {
                dq.addLast(new int[]{c, 1});
            } else {
                dq.peekLast()[1]++; // increment count of last run
            }
            
            // try to remove k-balanced blocks at the top while possible
            while (dq.size() >= 2) {
                // pop right then left
                int[] right = dq.removeLast();
                int[] left  = dq.removeLast();
                
                if (left[0] == '(' && right[0] == ')' && left[1] >= k && right[1] >= k) {
                    // remove k from both runs
                    left[1]  -= k;
                    right[1] -= k;
                    // push back non-empty runs in the correct order (left before right)
                    if (left[1] > 0) dq.addLast(left);
                    if (right[1] > 0) dq.addLast(right);
                    // continue the while — removing these might enable further removals
                } else {
                    // not removable: restore runs in original order and stop checking
                    dq.addLast(left);
                    dq.addLast(right);
                    break;
                }
            }
        }
        
        // reconstruct result from deque
        StringBuilder sb = new StringBuilder();
        for (int[] run : dq) {
            char ch = (char) run[0];
            int cnt = run[1];
            for (int i = 0; i < cnt; i++) sb.append(ch);
        }
        return sb.toString();
    }
}
