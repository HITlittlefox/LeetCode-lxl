// 废案,不能从数组中拿东西连接到string
// class Solution {
//     public String replaceSpace(String s) {

//         String[] temp = new String[s.length()];
//         int i = 0;
//         for (char perChar : s.toCharArray()) {
//             // System.out.println(String.valueOf(perChar));
//             temp[i++] = String.valueOf(perChar);
//         }

//         for (String string : temp) {
            
//             if (string.equals(" ")) {
//                 // System.out.println("aaa");
//                 string = "%" + "2" + "0";
//             }
//         }
        
//         String result = "";
//         for (String string : temp) {
//             result += String.valueOf(string);
//             // System.out.println(string);
//         }

//         return result;
//     }

// }


// 数组遍历,遇到空格直接把%20连接到string,并continue,而不是从数组中拿到
class Solution {
    public String replaceSpace(String s) {

        // 辅助数组(存放每一个字符串的字符)
        String[] temp = new String[s.length()];
        int i = 0;
        for (char perChar : s.toCharArray()) {
            temp[i++] = String.valueOf(perChar);
        }

        // 如果是空格,result连接的就是%20
        String result = "";
        for (String string : temp) {
            if (string.equals(" ")) {
                // result += "%" + "2" + "0";
                result += "%20";
                continue;
            }
            result += string;
        }
        return result;
    }

}
