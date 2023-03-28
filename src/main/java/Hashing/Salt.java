/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Hashing;

import com.mycompany.bcd.assignment.FileHandle;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

/**
 *
 * @author putubgs
 */
public class Salt {
    
    //+generate() : byte[]
    public static byte[] generate(){
        int size = 16;
        byte[] b = new byte[size];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(b);
        return b;
    }
    
    public static void main(String [] args) throws IOException{
        FileHandle fh = new FileHandle();
        PrintWriter pr = fh.setAppend("salt.txt");
        byte [] salt = generate();
        pr.print(salt);
        pr.flush();
        pr.close();
    }
}