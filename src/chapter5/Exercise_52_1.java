package chapter5;
import java.io.IOException;
import java.io.InputStream;

/*
Контрольная сумма данных вычисляется по следующему алгоритму:

- Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
- Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
  Cn+1=rotateLeft(Cn) xor bn+1 , где Cn — контрольная сумма первых n байт данных,
  rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте
  Integer.rotateLeft), bn — n-ный байт данных.

Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов
InputStream исключение должно выбрасываться из метода.
 */
public class Exercise_52_1 {
    public static void main(String[] args) {
        class NullStream extends InputStream{
            int pos = 0;
            byte[] data = new byte[]{(byte)0x33,(byte)0x45, (byte)0x01};


            @Override
            public int read() throws IOException {
                return (pos < data.length)? data[pos++]: -1;
            }
        };

        try {
            System.out.println(checkSumOfStream(new NullStream()));
        }
        catch (IOException e){

        }

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        int data;
        int hash = 0;
        while ((data = inputStream.read()) > 0) {
            hash = Integer.rotateLeft(hash, 1) ^ data;

        }
        return hash;
    }
}
