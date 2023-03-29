/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author gregoriuskevin
 */
public class KeyMaker {
    
    private static final String algo = "RSA";
    KeyPairGenerator keygen;
    KeyPair keypair;
    static PublicKey publicKey;
    static PrivateKey privateKey;
    
    public KeyMaker() throws NoSuchAlgorithmException{
            keygen = KeyPairGenerator.getInstance(algo);
            keygen.initialize(1024);
    }
    
    public static void createKeyPair() throws NoSuchAlgorithmException, IOException{
        KeyMaker km = new KeyMaker();
        km.keypair = km.keygen.generateKeyPair();
        publicKey = km.keypair.getPublic();
        privateKey = km.keypair.getPrivate();
        KeyMaker.storeKeyPair(publicKey.getEncoded(), "KeyPair/public-key");
        KeyMaker.storeKeyPair(privateKey.getEncoded(), "KeyPair/private-key");
    }
    
    public static void storeKeyPair(byte[] key, String path) throws IOException{
        File f = new File(path);
        f.getParentFile().mkdirs();
        Files.write(Paths.get(path), key, StandardOpenOption.CREATE);
        System.out.println("Keypair stored into file:");
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyMaker.createKeyPair();
    }
}
