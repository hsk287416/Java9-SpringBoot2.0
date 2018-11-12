package pack01;

public class Action {
    public static void main(String[] args) {
        String enterLine = "(((1 + 6) * 3) + (15 - 5)) * 10";
        CheckUtil.check(enterLine);
        String result = Calculator.invoke(enterLine);
        System.out.println("算式: " + enterLine);
        System.out.println("結果: " + result);
    }
}
