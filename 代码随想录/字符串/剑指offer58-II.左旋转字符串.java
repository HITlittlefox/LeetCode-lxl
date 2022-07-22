// 反转区间为前n的子串
// 反转区间为n到末尾的子串
// 反转整个字符串
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char perChar : s.toCharArray()) {
            sb.append(perChar);
        }
        int splitStart = 0;
        int splitEnd = n - 1;
        int restStart = n;
        int restEnd = s.length() - 1;
        reverseString(sb, splitStart, splitEnd);
        reverseString(sb, restStart, restEnd);
        reverseString(sb, splitStart, restEnd);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

}