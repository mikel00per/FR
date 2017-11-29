import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AhorcadoServidor {

    public static void main(String[] args) {
	
        // Puerto de escucha
        int port=8989;	           

        //Creamos el socket para dar servicio al servidor       
        ServerSocket socketServidor;
        //Socket para establecer la conexión
        Socket socketServicio=null;	

        try {
            // Abrimos el socket en modo pasivo, escuchando el en puerto indicado por "port"			
            socketServidor = new ServerSocket(port);
            System.out.println("Servidor concurrente iniciado...");

            // Mientras ... siempre!
            do {

                // Aceptamos una nueva conexión con accept()				
                socketServicio = socketServidor.accept();

                // Creamos un objeto de la clase ProcesadorYodafy, pasándole como 
                // argumento el nuevo socket, para que realice el procesamiento
                // Este esquema permite que se puedan usar hebras más fácilmente.
                ProcesadorYodafy procesador=new ProcesadorYodafy(socketServicio);
                procesador.start();

            }while (true);

        }
        catch (IOException e) {
            System.err.println("Error al escuchar en el puerto "+port);
        }
    }
}
