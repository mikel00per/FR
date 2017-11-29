//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AhorcadoCliente {

        @SuppressWarnings("empty-statement")
	public static void main(String[] args) {

		String buferEnvio, buferRecepcion;
		int bytesLeidos=0;

		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
		// Puerto en el que espera el servidor:
		int port=8989;

		// Socket para la conexión TCP
		Socket socketServicio=null;
                
                //Para escribir texto.     
                PrintWriter outPrinter; 
                BufferedReader inReader; 

                //Para leer los caracteres tecleados por el usuario (System.in).
                InputStreamReader inputstr = new InputStreamReader(System.in);
                BufferedReader buferLector = new BufferedReader(inputstr);
                
                boolean salir = false, jugar = true;


		try {
                    // Creamos un socket que se conecte a "host" y "port":				
                    socketServicio = new Socket(host,port);	

                    InputStream inputStream = socketServicio.getInputStream();
                    OutputStream outputStream = socketServicio.getOutputStream();

                    outPrinter = new PrintWriter(outputStream,true);
                    inReader = new BufferedReader(new InputStreamReader(inputStream));
                    
                    do{
                        buferRecepcion = inReader.readLine();
                        System.out.println(buferRecepcion);
                        
                        String opcion = buferLector.readLine();
                        outPrinter.println(opcion);
                        outPrinter.flush();
                        
                        if("jugar".equals(opcion)){
                            salir = false;
                            jugar = true;
                            do{
                                buferRecepcion = inReader.readLine();
                                System.out.println(buferRecepcion);   

                                String letra = buferLector.readLine();
                                outPrinter.println(letra);
                                outPrinter.flush();
                                
                                if(!letra.equals("salir") && !letra.equals("rendir")){
                                    buferRecepcion = inReader.readLine();
                                    System.out.println(buferRecepcion);
                                    
                                    if(buferRecepcion.equals("-->   ## HAS GANADO!! ##  ")){
                                        jugar=false;
                                    }
                                    
                                    
                                }else{
                                    jugar = false;
                                }                               
                            }while(jugar);
                            
                        }else
                            salir = true;
                        
                    }while(!salir);
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}

