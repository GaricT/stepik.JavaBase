package chapter3;

import java.util.*;

public class AsciiCharSequence implements java.lang.CharSequence {
    byte[] str;

    public AsciiCharSequence(byte[] arg){
        str = arg.clone();
    }

    @Override
    public int length() {
        return str.length;
    }

    @Override
    public char charAt(int index) {
        return (char)str[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(str, start, end));
    }

}
