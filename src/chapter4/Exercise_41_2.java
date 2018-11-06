package chapter4;

public class Exercise_41_2 {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        includeMethod();
    }

    private static void includeMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        if (stack.length <= 2)
            return null;
        else
            return stack[2].getClassName() + "#" + stack[2].getMethodName();
    }
}
