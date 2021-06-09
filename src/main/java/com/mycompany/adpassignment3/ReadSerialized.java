/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adpassignment3;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;



/**
 *
 * @author ismaa
 */
public class ReadSerialized {
    private ObjectInputStream input;
    
    ArrayList<Customer> customer = new ArrayList<>(8);
    ArrayList<Supplier> supplier = new ArrayList<>(8);
    
    public void openFile(){
        try
            {
                input= new ObjectInputStream( new FileInputStream("stakeholder.ser"));
                System.out.println("*** ser file open for reading***");
            }
    catch (IOException ioe){
                System.out.println("error open ser file:");
        
            }  
    }
     
    public void closeFile(){
    
        try
            {
                input.close();
            }
        catch(IOException ioe)
            {
                System.out.println("error closing ser file:");
            }
    }
    
    public void readFromFile(){
    
        try
            {
                while(true)
                {
                
                customer.add((Customer)input.readObject());
                supplier.add((Supplier)input.readObject());
                }
                         

               
            }
         catch (EOFException eofe) {
           System.out.println("EOF reached");
        }
        
         catch (ClassNotFoundException ioe){
             System.out.println("Class not found"+ioe);
         } 
        
        catch(ClassCastException cce){
            
            
        }
        catch(IOException ioe){
            System.out.println("error reading from ser file"+ioe);
        }
         finally{
            
            closeFile();
            System.out.println("File closed");
        
        }
      
       } 
     public void customerArray(){
        for(int i=0;i<customer.size();i++)
        {
            System.out.println(customer.get(i));
        }
    
    }
     
      public void supplierArray(){
     
         for(int i=0;i<customer.size();i++){
             System.out.println(supplier.get(i));
         }
     }
    public static void main(String args[])  {
        ReadSerialized obj = new ReadSerialized();
        obj.openFile();
        obj.readFromFile();
        obj.customerArray();
        System.out.println("");
       obj.supplierArray();
        
    }
}

 
