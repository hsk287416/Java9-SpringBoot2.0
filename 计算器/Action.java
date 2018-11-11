package pack01;

public class Action {
    public static void main(String[] args) {
        String enterLine = "((11 + 1))";
        CheckUtil.check(enterLine);
        String result = Calculator.invoke(enterLine);
        System.out.println(result);
    }
}
