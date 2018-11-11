package pack01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 计算器
 */
public class Calculator {

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static String invoke(String enterLine) {
        CheckUtil.check(enterLine);
        List<String> enterList = splitEnterLine(enterLine);
        String result = compute(enterList);
        return result;
    }

    /**
     * 将用户输入的字符串分割成字符串List
     * @param enterLine 用户输入的字符串
     * @return 字符串List
     */
    private static List<String> splitEnterLine(String enterLine) {
        Pattern pattern = Pattern.compile("([0-9]+|\\(|\\)|\\+|\\*|-|/)");
        Matcher matcher = pattern.matcher(enterLine);
        List<String> result = new ArrayList<String>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    private static String compute(List<String> itemList) {
        boolean isOperateBySub = false;
        Stack<String> stack = new Stack<String>();
        List<String> subItemList = new ArrayList<String>();
        Pattern operatorPattern = Pattern.compile("^(\\+|\\*|-|/)$");
        Pattern bracketPattern = Pattern.compile("^(\\(|\\))$");
        Pattern numberPattern = Pattern.compile("^[0-9]+$");
        stack.push("0");
        stack.push("+");

        for (int i = 0; i < itemList.size(); i++) {
            String item = itemList.get(i);
            String prevItem = stack.peek();
            // 上一个元素和当前元素不能同时是运算符
            if (!isOperateBySub && operatorPattern.matcher(prevItem).find() && operatorPattern.matcher(item).find()) {
                throw new RuntimeException("运算符不合法");
            }

            // 如果当前元素是运算符，那么上一个元素应该不是括号
            if (operatorPattern.matcher(item).find() && bracketPattern.matcher(prevItem).find()) {
                throw new RuntimeException("运算符与括号的搭配不合法");
            }

            // 如果当前元素是数字，那么上一个元素应该不是右括号
            if (numberPattern.matcher(item).find() && RIGHT_BRACKET.equals(prevItem)) {
                throw new RuntimeException("数字与括号的搭配不合法");
            }

            // 如果当前元素是数字，而且取出stack的上一个元素（运算符）以及上上一个元素（数字），算出结果
            if (numberPattern.matcher(item).find()) {
                if (isOperateBySub) {
                    subItemList.add(item);
                } else {
                    handlerCurrentNum(prevItem, item, stack, i, itemList);
                }

            } else if (operatorPattern.matcher(item).find()) {
                // 如果当前元素是运算符，那么直接加入stack
                if (isOperateBySub) {
                    subItemList.add(item);
                } else {
                    stack.push(item);
                }

            } else {
                if (LEFT_BRACKET.equals(item)) {
                    isOperateBySub = true;
                } else {
                    String subResult = compute(subItemList);
                    handlerCurrentNum(prevItem, subResult, stack, i, itemList);
                    subItemList.clear();
                    isOperateBySub = false;
                }
            }
        }

        System.out.println(stack);
        String result = lastOperate(stack);

        return result;
    }

    /**
     * 判断当前运算符
     * 如果当前运算符是*或者/的话，取出上一个运算符和数字，进行运算
     * 如果当前运算符是+或者-的话
     *     判断下一个运算符
     *     如果下一个运算符是*或者/的话，把当前数字存入stack中
     *     如果下一个元素服是+或者-或者null的话，取出上一个运算符和数字，进行运算
     *
     * @param prevItem 当前运算符
     * @param item 当前数字
     * @param stack Stack
     * @param i 当前索引
     * @param itemList itemList
     */
    private static void handlerCurrentNum(String prevItem, String item, Stack<String> stack, int i, List<String> itemList) {
        if (MULTIPLY.equals(prevItem) || DIVIDE.equals(prevItem)) {
            String operator = stack.pop();
            String prevNum = stack.pop();
            String operateResult = operate(item, prevNum, operator);
            stack.push(operateResult);
        } else {
            String nextOperator = getNextOperator(i, itemList);
            if (MULTIPLY.equals(nextOperator) || DIVIDE.equals(nextOperator)) {
                stack.push(item);
            } else {
                String operator = stack.pop();
                String prevNum = stack.pop();
                String operateResult = operate(item, prevNum, operator);
                stack.push(operateResult);
            }
        }
    }


    /**
     * 加减乘除运算
     * @param num1 数字1
     * @param num2 数字2
     * @param operator 运算符
     * @return 结果
     */
    private static String operate(String num1, String num2, String operator) {
        BigDecimal decimal1 = BigDecimal.valueOf(Double.valueOf(num1));
        BigDecimal decimal2 = BigDecimal.valueOf(Double.valueOf(num2));
        BigDecimal result = BigDecimal.ZERO;

        if (operator.equals(ADD)) {
            // 加法
            result = decimal1.add(decimal2);
        } else if (operator.equals(SUBTRACT)) {
            // 减法
            result = decimal1.subtract(decimal2);
        } else if (operator.equals(MULTIPLY)) {
            // 乘法
            result = decimal1.multiply(decimal2);
        } else {
            // 除法
            result = decimal1.divide(decimal2);
        }

        return result.toString();
    }

    /**
     * 获取下一个运算符
     * @param currentIndex 当前索引
     * @param itemList ItemList
     * @return 下一个运算符（如果没有则返回null）
     */
    private static String getNextOperator(int currentIndex, List<String> itemList) {
        Pattern operatorPattern = Pattern.compile("^(\\+|\\*|-|/)$");
        for (int i = currentIndex; i < itemList.size(); i++) {
            String item = itemList.get(i);
            if (operatorPattern.matcher(item).find()) {
                return item;
            }
        }
        return null;
    }

    private static String lastOperate(Stack<String> stack) {
        String num1 = stack.pop();
        if (stack.empty()) {
            return num1;
        }
        String operator = stack.pop();
        String num2 = stack.pop();

        String result = operate(num1, num2, operator);
        stack.push(result);
        return lastOperate(stack);
    }
}
