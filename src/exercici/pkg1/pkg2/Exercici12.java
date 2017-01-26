
package exercici.pkg1.pkg2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class Exercici12 {


    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
           
                NetworkInterface interfaz = interfaces.nextElement();
                System.out.println("Interfaz: " + interfaz.getName());
                byte[] direccion = interfaz.getHardwareAddress();

        } catch(SocketException e) {
            System.out.println(e);
        }
    }
    
}
