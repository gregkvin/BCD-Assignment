/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bcd.assignment;

import Cryptography.Asymmetric;
import KeyGenerator.KeyAccess;
import KeyGenerator.KeyMaker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author gregoriuskevin
 */
public class FileHandle {

    public FileReader setRead(String path) throws IOException{
        File file = new File(path);
        FileReader fr = new FileReader(file);
        return fr;
    }
    
    public BufferedReader setReadLines(String path) throws IOException {
        FileReader fr = setRead(path);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }
    
    public FileWriter setWrite(String path) throws IOException{
        FileWriter fw = new FileWriter(path);
        return fw;
    }
    
    public PrintWriter setAppend(String path) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pr = new PrintWriter(br);
        return pr;
    }
    
    public int readLineNumber(String path) throws IOException {
        FileReader fs = setRead(path);
        LineNumberReader li = new LineNumberReader(fs);
        li.skip(Long.MAX_VALUE);
        int line = li.getLineNumber();
        return line;
    }
    
    public String[] declareArray() throws IOException {
        String[]demo = new String[9];
        return demo;
    }
    
    public String [] getSplit(String path,int n, String[] demo) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String specific_line_text = Files.readAllLines(Paths.get(path)).get(n);
        demo = specific_line_text.split("-");
        System.out.println(demo);
        return demo;
    }
    
    public String autoIncrement(String path, String [] id) throws IOException{
        int line = readLineNumber(path);
        int idi = Integer.parseInt(id[line-1]);
        int auto = idi + 1;
        return String.valueOf(auto);
    }

}
