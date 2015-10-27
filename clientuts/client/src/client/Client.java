/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
    import java.io.IOException;
    import java.net.Socket;
    import java.io.InputStream;
    import java.io.OutputStream;
    import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
           try {
            Scanner sc= new Scanner(System.in);
            byte[] buf = new byte[10];
            Socket socket = new Socket("10.151.34.155", 6666);
            
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            int len;
            String strbuf = new String(buf);
            while(true) {
                buf = new byte[30];
                len = is.read(buf);
                if(len == -1) {
                    break;
                }
                
                System.out.print(new String(buf));
            }
            String kak;
            kak = sc.nextLine();
            System.out.println(kak);
            kak = kak.trim();

            os.write(kak.getBytes());
            os.flush();
           
            while(true) {
            buf = new byte[10];
            len = is.read(buf);
            if(len == -1) {
                break;
            }
                
                System.out.print(new String(buf));
            }
//            
            os.close();
            is.close();
            socket.close();
        } 
           catch(IOException ex){
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    }
    }
    

