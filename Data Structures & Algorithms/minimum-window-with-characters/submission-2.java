public class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        // Frequency of characters required from t
        Map<Character, Integer> countT = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // Frequency of characters in current window
        Map<Character, Integer> window = new HashMap<>();

        int have = 0;
        int need = countT.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            // This character now satisfies its required frequency
            if (countT.containsKey(c)
                    && window.get(c).intValue() == countT.get(c).intValue()) {
                have++;
            }

            // Current window contains everything required
            while (have == need) {

                // Update minimum window
                if (right - left + 1 < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (countT.containsKey(leftChar)
                        && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE
                ? ""
                : s.substring(res[0], res[1] + 1);
    }
}