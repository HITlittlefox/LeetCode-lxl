package HARD;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

// HJ19 简单错误记录
// 将每一个数据都存入到HashMap中，最后输出的时候只输出8个即可。
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (sc.hasNext()) {
            String str = sc.next();
            int LineNum = sc.nextInt();
            // 第一第三个\是java转义符，第二个\是正则表达式转义符，第四个\是真正意义上的字符”\"
            String[] split = str.split("\\\\"); // 根据\分割
            String FileName = split[split.length - 1];
            // 只保留最后16位
            if (FileName.length() > 16)
                FileName = FileName.substring(FileName.length() - 16);
            // 记录出错的代码所在的文件名称和行号
            String key = FileName + " " + LineNum;
            // 次数
            int number = 1;
            // 放入到HashMap中
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else {
                map.put(key, number);
            }
        }
        sc.close();
        // 输出最后八个记录
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8))
                System.out.println(string + " " + map.get(string));
        }
    }
}
