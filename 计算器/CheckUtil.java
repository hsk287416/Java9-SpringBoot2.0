package pack01;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {
    /**
     * 检查输入的字符串是否合法
     * @param enterLine
     * @return
     */
    public static boolean check(String enterLine) {
        // 1.检测是否包含英文字母
        Pattern alphabetPattern = Pattern.compile("[a-z]+");
        if (alphabetPattern.matcher(enterLine).find()) {
            throw new RuntimeException("输入的字符串中包含非法字符");
        }

        // 2.检测运算符号是否合法
//        checkOperator(enterLine);
        return true;
    }

    private static boolean checkOperator(String enterLine) {
        Stack<String> stack = new Stack<String>();
        Pattern pattern = Pattern.compile("([0-9]+|\\(|\\)|\\+|\\*|-|/)");
        Pattern numberPattern = Pattern.compile("^[0-9]+$");
        Pattern operatorPattern = Pattern.compile("^(\\+|\\*|-|/)$");

        // 1 + 10
        Matcher matcher = pattern.matcher(enterLine);
        while (matcher.find()) {
            String item = matcher.group();
            if (stack.empty()) {
                stack.push(item);
            } else {
                String prevItem = stack.peek();
                // 如果上一个item是运算符的话，那么当前item不应该是运算符
                if (operatorPattern.matcher(prevItem).find()) {
                    if (operatorPattern.matcher(item).find()) {
                        throw new RuntimeException("运算符不合法");
                    }

                }
            }
        }

        return false;
    }
}
