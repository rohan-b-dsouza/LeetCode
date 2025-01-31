// Recursive - Approach

class Solution {
public:
    int fib(int n) {
        if (n <= 1) return n;
        int last = fib(n - 1);
        int slast = fib(n - 2);
        return slast + last;
    }
};

// T.C => O(2^n)
// S.C => O(n)
