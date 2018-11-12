package pack01;

import java.util.regex.Pattern;

public class CheckUtil {
    /**
     * 检查输入的字符串是否合法
     * @param enterLine
     * @return
     */
    public static boolean check(String enterLine) {
        // 检测是否包含英文字母
        Pattern alphabetPattern = Pattern.compile("[a-z]+");
        if (alphabetPattern.matcher(enterLine).find()) {
            throw new RuntimeException("输入的字符串中包含非法字符");
        }

        return true;
    }

}
