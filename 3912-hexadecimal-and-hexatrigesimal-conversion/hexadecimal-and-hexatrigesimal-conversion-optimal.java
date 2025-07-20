// Optimal

class Solution {
    public String concatHex36(int n) {
        int a = n*n;
        int b = n*n*n;
    
        String hex = Integer.toHexString(a).toUpperCase();       
        String base36 = Integer.toString(b, 36).toUpperCase();    
    
        return hex + base36; 
    }
}

// T.C => O(log(n))
// S.C => O(log(n))
