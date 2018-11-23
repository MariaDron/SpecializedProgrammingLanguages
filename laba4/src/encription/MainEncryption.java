package encription;

import encription.impl.XORStreamEncryption;

import java.util.Random;

/**
 * @author MariaDron
 */
public class MainEncryption {
    public static void main(String[] args) {
        System.out.println("============================================\nTASK 5");
        byte[] message = new byte[64];
        new Random().nextBytes(message);
        XORStreamEncryption.XORencrypt(message);
    }
}
