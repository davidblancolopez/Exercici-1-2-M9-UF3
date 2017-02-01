package exercici.pkg1.pkg2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Exercici12 {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress ip;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            NetworkInterface interfaz = interfaces.nextElement();
            System.out.println("Interfaz: " + interfaz.getName());

            ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            
            //Recolleix la MAC pero esta en un format que no es correcte perque no mostrara la informació
            //com cal.
            byte[] mac = network.getHardwareAddress();

            System.out.print("Direcció MAC : ");

            //Es crea una cadena on anirem posant la direcció MAC donant el format correcte a l'array mac. 
            StringBuilder cadenaDireccioMAC = new StringBuilder();
            
            //El bucle va afegint a la cadena la informació que recorre en l'array mac, aplica format amb "%02X%s"
            //i afegeix el '-' per a separar els numeros.
            for (int i = 0; i < mac.length; i++) {
                cadenaDireccioMAC.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            //S'imprimeix la cadena amb la MAC formatada.
            System.out.println(cadenaDireccioMAC.toString());

        } catch (SocketException e) {
            System.out.println(e);
        }
    }

}
