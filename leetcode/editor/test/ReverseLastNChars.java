package leetcode.editor.test;

import java.util.Scanner;

/**
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 * <p>
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 * <p>
 * 输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
 * <p>
 * 输出：输出共一行，为进行了右旋转操作后的字符串。
 */
public class ReverseLastNChars {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
        String s = "abcdefg";
        int n = 2;

        int len = s.length();  //获取字符串长度
        char[] chars = s.toCharArray();

        reverseString(chars, 0, len - 1);
        reverseString(chars, 0, n - 1);
        reverseString(chars, n, len - 1);
        System.out.println(chars);

    }

    public static void reverseString(char[] ch, int start, int end) {
        //异或法反转字符串，参照题目 344.反转字符串的解释
        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
}
