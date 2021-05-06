/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author md.jubayer
 */
public class ApiProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
            System.out.print("Enter a postcode: ");  
            String str= sc.nextLine();              //reads string  
            HTTPConnector.requestForAddressesUsingPostCode(str);
 }
}
    
    
    

