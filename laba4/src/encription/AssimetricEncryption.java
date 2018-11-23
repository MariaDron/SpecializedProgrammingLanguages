package encription;

/**
 * @author MariaDron
 */
public interface AssimetricEncryption extends Encryption {
    void generatePublicKey();
    void generatePrivateKey();
}
