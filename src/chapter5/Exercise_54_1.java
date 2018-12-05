package chapter5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Exercise_54_1 {
    public static void main(String[] args) {

    }
    public static Animal[] deserializeAnimalArray(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream oin = null;
        Animal[] result;
        try {
            oin = new ObjectInputStream(bis);
            int count = oin.readInt();
            result = new Animal[count];
            for (int i = 0; i < count; i++){
                result[i] = (Animal) oin.readObject();
            }
        }
        catch (Exception ex) {
            throw new java.lang.IllegalArgumentException();
        }
        finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            }
            catch (java.io.IOException ex) {
                throw new java.lang.IllegalArgumentException();
            }
            finally {

            }
            try {
                if (oin != null) {
                    oin.close();
                }
            }
            catch (java.io.IOException ex) {
                throw new java.lang.IllegalArgumentException();
            }
            finally {

            }
        }
        return result;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}