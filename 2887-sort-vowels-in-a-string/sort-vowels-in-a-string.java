class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        char[] arr = new char[n];
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                list.add(s.charAt(i));
            }
            else {
                arr[i] = s.charAt(i);
            }
        }
        list.sort(null);
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = list.removeFirst();
            }
        }
        String ans = new String(arr);
        return ans;
    }
}