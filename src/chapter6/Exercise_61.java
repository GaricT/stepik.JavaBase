package chapter6;

public class Exercise_61 {
    public static void main(String[] args) {
//        Pair<Integer, String> pair = Pair.of(null, "hello");
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        System.out.println("getFirst()=" + i + " : " + "1");
        String s = pair.getSecond(); // "hello"
        System.out.println("getSecond() = " + s + " : " + "hello");

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println("equals() = " + mustBeTrue + " : " + "true");
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("hashCode() = " + mustAlsoBeTrue + " : " + "true");
    }
}

class Pair <X, Y> {
    X x;
    Y y;
    private Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getFirst() {
        return x;
    }

    public Y getSecond() {
        return y;
    }

    public Boolean equals(Pair <X, Y> arg) {
        X x = arg.getFirst();
        Y y = arg.getSecond();
        Boolean resX = false;
        Boolean resY = false;

        if ((x == null) && (this.x == null))
            resX = true;
        else if ((x != null) && (this.x != null))
            resX = this.x.equals(x);

        if ((y == null) && (this.y == null))
            resY = true;
        else if ((y != null) && (this.y != null))
            resY = this.y.equals(y);

        return resX && resY;
    }

    public static <X, Y> Pair <X, Y> of(X x, Y y){
        return new Pair<X, Y>(x, y);
    }

    public int hashCode() {

        return ((x != null) ? x.hashCode() : 0) + ((y != null) ? y.hashCode() : 0);
    }
}
