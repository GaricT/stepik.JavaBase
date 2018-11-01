package chapter3;

public class Exercise_34_2 {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        System.out.println("===== ===== =====");
        double re = 1;
        double im = 1;

        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
    }

}
final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof ComplexNumber && obj != null){
            ComplexNumber cNumber = (ComplexNumber)obj;
            return re == cNumber.re && im == cNumber.im;
        }
        else {
            return false;
        }

    }

    @Override
    public int hashCode(){
        return (Double.valueOf(re).toString() + ":" + Double.valueOf(im).toString()).hashCode();
    }
}

