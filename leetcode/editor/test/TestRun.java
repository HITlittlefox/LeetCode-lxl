package leetcode.editor.test;

import java.util.Arrays;

public class TestRun {

    public static void main(String[] args) {
        int a = 1001;
        int b = 1;

        System.out.println(a ^ b);
        System.out.println(a ^ b ^ b);
        System.out.println(b ^ a ^ b);
        System.out.println(b ^ b ^ a);


        char[] ch = new char[]{'1', '1', '2', '3'};
        reverse(ch, 1, 2);

        System.out.println(Arrays.toString(ch));
    }

    /**
     * 定义翻转函数，反转ch[i] 到 ch[j]
     *
     * @param ch
     * @param i
     * @param j
     */
    public static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}

