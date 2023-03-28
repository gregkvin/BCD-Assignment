/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author gregoriuskevin
 */
public class KeyAccess {
    
    public static PublicKey getPublicKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] key = Files.readAllBytes(Paths.get(filename));
        X509EncodedKeySpec sp = new X509EncodedKeySpec(key);
        return KeyFactory.getInstance("RSA").generatePublic(sp);
    }
    
    public static PrivateKey getPrivateKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] key = Files.readAllBytes(Paths.get(filename));
        PKCS8EncodedKeySpec sp = new PKCS8EncodedKeySpec(key);
        return KeyFactory.getInstance("RSA").generatePrivate(sp);
    }
}


