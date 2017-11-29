// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class ProcesadorYodafy{
  // Referencia a un socket para enviar/recibir las peticiones/respuestas
  private DatagramSocket socketServicio;
  private DatagramPacket paquete;
  byte []buferRecepcion = new byte[256];
  byte []buferEnvio;
  InetAddress direccion;
  int port;

  // Para que la respuesta sea siempre diferente, usamos un generador de números aleatorios.
  private Random random;

  // Constructor que tiene como parámetro una referencia al socket abierto en por otra clase
  public ProcesadorYodafy(DatagramSocket socketServicio) {
  	this.socketServicio=socketServicio;
  	random=new Random();
  }

  //Aquí es donde se realiza el procesamiento realmente:
  void procesa(){

  	try {
      //Creamos la petición para recibir el paquete
      paquete = new DatagramPacket(buferRecepcion,buferRecepcion.length);
      //Recibimos el paquete
      socketServicio.receive(paquete);
      //Obtenemos la dirección
      direccion = paquete.getAddress();
      //Obtenemos el puerto
      port = paquete.getPort();

      String respuesta, desordena;
      // Creamos el string donde se almacenará el mensaje desordenado
      desordena = new String(buferRecepcion,0,buferRecepcion.length);
      // Obtenemos la respuesta
      respuesta = yodaDo(desordena);

      // Obtenemos los bytes del bufer de envío con la respuesta
      buferEnvio = respuesta.getBytes();
      // Creamos el DatagramPacket para la peticion
      paquete = new DatagramPacket(buferEnvio,buferEnvio.length,direccion,port);
      // Enviamos la petición
      socketServicio.send(paquete);
  	}
      catch (IOException e) {
          System.err.println("Error al obtener los flujos de entrada/salida.");
      }
  }

    // Yoda interpreta una frase y la devuelve en su "dialecto":
  private String yodaDo(String peticion) {
    // Desordenamos las palabras:
    String[] s = peticion.split(" ");
    String resultado="";

    for(int i=0;i<s.length;i++){
      int j=random.nextInt(s.length);
      int k=random.nextInt(s.length);
      String tmp=s[j];

      s[j]=s[k];
      s[k]=tmp;
    }

    resultado=s[0];
    for(int i=1;i<s.length;i++){
      resultado+=" "+s[i];
    }

    return resultado;
  }
}
