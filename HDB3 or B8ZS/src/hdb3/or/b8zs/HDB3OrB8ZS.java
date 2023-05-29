/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hdb3.or.b8zs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Dell
 */
public class HDB3OrB8ZS {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    public static void main(String[] args)throws IOException {
        
        System.out.print("Enter File Name(name.txt)"); // Get the filename.
        try (Scanner sc = new Scanner(System.in)) {
            String name = sc.nextLine();
            File file = new File(name); // Open the file.
            try (Scanner input = new Scanner(file)) {
                String in = input.nextLine();
                
                int b = 0, zeros=0, ones=0, tmp1=0, tmp2=0, choice=0;
                boolean sign=true;
                String out="";
                
                while(choice!=1 || choice!=2){
                    System.out.println(" Choose method: \n 1-) HDB3 \n 2-) B8ZS \n");
                    choice=sc.nextInt();
                }

                for(b=0; b < in.length(); b++){
                    b=in.charAt(b);
                    
                    if(in.charAt(b)=='-')
                        sign=false;
                    
                    if(b==1){
                        if(sign==false)
                            b= -1;
                        
                        out+=b;
                        zeros=0;
                        ones++;
                        tmp1=b;
                    }
                    if(b==0){
                        ones=0;
                        zeros++;
                        tmp2 = -1*tmp1;
                        
                        if (zeros==4 && choice ==1){//HDB3
                            
                            if(ones%2==0){//even 100V
                                out+= tmp2 + "00" + tmp2;
                            }
                            else//odd 000V
                                out+="000"+ tmp2 ;
                        }
                        
                        if (zeros==8 && choice ==2){//B8ZS (000 V 10 V 1)
                            out+="000"+ tmp1 + tmp2 +"0"+ tmp2 +tmp1;
                        }
                    }
                }   
                System.out.println("file name " + name + "\n before = " + input + "after" + out);

                try (FileWriter filew = new FileWriter("After.txt")) {
                    filew.write(out);
                    filew.close();
                }
            }
        }
    }   
}