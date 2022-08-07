// 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String nStr = String.valueOf(n);

        Stack<Character> nStack = new Stack<>();
        for (Character character : nStr.toCharArray()) {
            if (!nStack.contains(character)) {
                nStack.push(character);
            }
        }
        String res = "";
        if(nStack.peek()=='0'&&nStack.size()>1){
            nStack.pop();
        }
        if(nStack.peek()=='0'&&nStack.size()==1){
            System.out.println(Integer.valueOf('0'));
        }
        while (!nStack.isEmpty()) {
            res += nStack.pop();
        }
        System.out.println(Integer.valueOf(res));

    }
}
