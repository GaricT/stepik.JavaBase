package chapter4;

// Обработка исключений. Try-catch
public class Exercise_42_2 {
    public static void main(String[] args) {
        try {
            System.out.println("try");
//            System.exit(0);
//            return;
            throw new java.lang.IllegalStateException();

        } catch (Exception e) {
            System.out.println("catch");
            throw new java.lang.IllegalStateException();
        } finally {
            System.out.println("finally");
        }
    }

}
