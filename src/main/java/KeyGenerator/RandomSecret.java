/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyGenerator;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;

/**
 *
 * @author gregoriuskevin
 */
public class RandomSecret {
    
    private static final String algo = "AES";
    
    public static Key generate() throws NoSuchAlgorithmException{
   
            KeyGenerator kg = KeyGenerator.getInstance(algo);
            kg.init(256, new SecureRandom());
            return kg.generateKey();
    }
}
