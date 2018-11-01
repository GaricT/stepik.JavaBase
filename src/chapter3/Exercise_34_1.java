package chapter3;

public class Exercise_34_1 {
    public static void main(String[] args) {
        TstFinal tst = new TstFinal();
    }
}

final class TstFinal{ // В объявлении класса
    final String NonStaticFld = "NonStaticFld"; // В объявлении нестатического поля класса.
    final static String StaticFld = "StaticFld"; // В объявлении статического поля класса.

    TstFinal(){ // В объявлении конструктора.
        final String s = "asd"; // В объявлении локальной переменной.
    }

    public final void FinalMtd(){ // В объявлении метода.

    }

    public void FinalMtdParam(final String str){ // В объявлении параметра метода.

    }
}