class Solution {
    public char getChar(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + 48);
        }
        if (num >= 10 && num <= 35) {
            return (char) (num + 55);
        }
        return ' ';
    }
    public String concatHex36(int n) {
        int hexa = n * n;
        int tri = n * n * n;
        StringBuilder hexstr = new StringBuilder();
        StringBuilder tristr = new StringBuilder();
        while (hexa != 0) {
            int rem = hexa % 16;
            hexstr.append(getChar(rem));
            hexa = hexa / 16;
        }
        while (tri != 0) {
            int rem = tri % 36;
            tristr.append(getChar(rem));
            tri = tri / 36;
        }
        hexstr.reverse();
        tristr.reverse();
        return (hexstr.toString() + tristr.toString());
    }
}