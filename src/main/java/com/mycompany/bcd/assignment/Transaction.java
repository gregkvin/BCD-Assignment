package com.mycompany.bcd.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gregoriuskevin
 */
public class Transaction {
    public static final int SIZE = 10;
    public List<String> trans;
    
    public List<String> getTranxLst() {
		return trans;
	}

    
    public Transaction(){
        trans = new ArrayList<>(SIZE);
    }
    
    	public void add( String tranx ) {
		trans.add(tranx);
	}
	
	@Override
	public String toString() {
		return "Transaction [tranxLst=" + trans + "]";
	}
    
}
