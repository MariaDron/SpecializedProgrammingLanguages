package encription.impl;

import encription.StreamEncryption;

import java.util.Arrays;
import java.util.Random;

/**
 * @author MariaDron
 */
public class XORStreamEncryption implements StreamEncryption {
    private byte[] key = new byte[16];

    @Override
    public void generateKey() {
        new Random().nextBytes(key);
    }

    @Override
    public byte[] encrypt(byte[] message) {
        byte[] encryptedResult = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            encryptedResult[i] = (byte) (message[i] ^ key[i % key.length]);
        }
        return encryptedResult;
    }

    @Override
    public byte[] decrypt(byte[] message) {
        byte[] decryptedResult = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            decryptedResult[i] = (byte) (message[i] ^ key[i % key.length]);
        }
        return decryptedResult;
    }

    public static byte[] XORencrypt(byte[] message) {
        XORStreamEncryption encryption = new XORStreamEncryption();
        encryption.printByteMess(message, "Message: ");

        encryption.generateKey();
        byte[] encryptedResult = encryption.encrypt(message);
        encryption.printByteMess(encryptedResult, "Encrypted message: ");

        byte[] decryptedResult = encryption.decrypt(encryptedResult);
        encryption.printByteMess(decryptedResult, "Decrypted message: ");

        if (!Arrays.equals(message, decryptedResult)) {
            System.out.println("ERROR: Decryption failed");
            return null;
        }

        return encryptedResult;
    }

    private void printByteMess(byte[] message, String log) {
        System.out.print(log);
        for (byte b : message) {
            System.out.print(b);
        }
        System.out.println();
    }
}
