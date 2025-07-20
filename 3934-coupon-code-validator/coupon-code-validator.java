class Solution {
    public boolean isAlphaN(String code) {
        if (code.length() == 0)
            return false;
        for (char ch : code.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    public boolean isBusiness(String business) {
         return business.equals("electronics") ||
           business.equals("grocery") ||
           business.equals("pharmacy") ||
           business.equals("restaurant");
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String> ans = new ArrayList<>();
        List<String[]> valid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isAlphaN(code[i]) && isBusiness(businessLine[i]) && isActive[i]) {
                valid.add(new String[] {businessLine[i], code[i]});
            }
        }
        HashMap<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);
        Collections.sort(valid, (a, b) -> {
            int cmp = Integer.compare(order.get(a[0]), order.get(b[0]));
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });
        for (int i = 0; i < valid.size(); i++) {
            ans.add(valid.get(i)[1]);
        }
        return ans;
    }
}