import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class YodafyServidorIterativo {

  public static void main(String[] args) {

    //Abrimos el datagram en modo pasivo.
    DatagramSocket socketServidor;

    // Puerto de escucha
    int port=8989;

    try {

      do {
        // Aceptamos una nueva conexión con accept()
        //Para que se quede esperando una petición de conexión.
        /////////////////////////////////////////////////
        socketServidor = new DatagramSocket(port);
        /////////////////////////////////////////////////

        // Creamos un objeto de la clase ProcesadorYodafy, pasándole como
        // argumento el nuevo socket, para que realice el procesamiento
        // Este esquema permite que se puedan usar hebras más fácilmente.
        ProcesadorYodafy procesador=new ProcesadorYodafy(socketServidor);
        procesador.procesa();

        //Cerramos el socket.
        socketServidor.close();

      } while (true);
    }
      catch (IOException e) {
      System.err.println("Error al escuchar en el puerto "+port);
    }
  }
}
