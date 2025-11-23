class Solution {
    public int minimumFlips(int n) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n)); 
        StringBuilder binaryRev = new StringBuilder(binary).reverse();
        int size = binary.length();
        int flips = 0;
        for (int i = 0; i < size; i++) {
            if (binary.charAt(i) != binaryRev.charAt(i)) {
                flips++;
            }
        }
        return flips;
    }
}