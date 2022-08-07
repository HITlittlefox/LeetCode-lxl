package Huawei.BufferedReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] list = br.readLine().split(" ");

        System.out.println("n:" + n);
        for (String string : list) {
            System.out.println(string);
        }

        // 不要使用Scanner.nextline方法，因为会吞空格
        // 对于输入数据的单位是以行为单位的时候就可以使用模板2
        // 采用BufferedWriter类来进行输出，没有print系列方法，使用write系列方法进行输出
        // 对于多组输入，同上：在BufferedReader对象读取数据的时候进行判空来结束输入。
    }
}
