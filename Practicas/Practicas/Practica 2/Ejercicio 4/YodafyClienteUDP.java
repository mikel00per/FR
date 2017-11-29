// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteUDP {

  public static void main(String[] args) {

  byte []buferEnvio;
  byte []buferRecepcion=new byte[256];

  //Abrimos un datagramSocket y un datagramPacket
  DatagramSocket socket;
  DatagramPacket paquete;
  InetAddress direccion;

  // Nombre del host donde se ejecuta el servidor:
  String host="localhost";
  int port=8989;


	try {
    // Creamos un socket
    socket = new DatagramSocket();

    // Si queremos enviar una cadena de caracteres por un OutputStream, hay que pasarla primero
    // a un array de bytes:
    buferEnvio="Al monte del volcán debes ir sin demora".getBytes();

    //Obtenemos la dirección host
    direccion = InetAddress.getByName(host);

    //Creamos el datagrama (paquete) con la frase, la dirección y puerto
    paquete = new DatagramPacket(buferEnvio, buferEnvio.length,direccion,port);

    //Enviamos el paquete
    socket.send(paquete);

    //Creamos el datagrama donde obtendremos la frase
    paquete = new DatagramPacket(buferRecepcion,buferRecepcion.length);
    socket.receive(paquete);

    // Imprimimos el paquete recibido
    String caracteres = new String(buferRecepcion);
    System.out.println(caracteres);
    //////////////////////////////////////////////////////

    // Una vez terminado el servicio, cerramos el socket (automáticamente se cierran
    // el inpuStream  y el outputStream)
    //////////////////////////////////////////////////////
    socket.close();
    //////////////////////////////////////////////////////

  }
    catch (UnknownHostException e) {
        System.err.println("Error: Nombre de host no encontrado.");
    }
    catch (IOException e) {
        System.err.println("Error de entrada/salida al abrir el socket.");
    }
  }
}
