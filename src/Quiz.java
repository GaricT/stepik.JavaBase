import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class Quiz {

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes(StandardCharsets.UTF_8.name()));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }
    }
}