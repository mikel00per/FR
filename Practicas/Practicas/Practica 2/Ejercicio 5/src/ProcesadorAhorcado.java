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
import java.util.ArrayList;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeString.substring;


//
// Nota: si esta clase extendiera la clase Thread, y el procesamiento lo hiciera el método "run()",
// ¡Podríamos realizar un procesado concurrente!
//
public class ProcesadorAhorcado extends Thread{
	// Referencia a un socket para enviar/recibir las peticiones/respuestas
	private Socket socketServicio;
	// stream de lectura (por aquí se recibe lo que envía el cliente)
	private InputStream inputStream;
	// stream de escritura (por aquí se envía los datos al cliente)
	private OutputStream outputStream;

	// Para que la respuesta sea siempre diferente, usamos un generador de números aleatorios.
	private Random random;

        private ArrayList<String> palabras;
        private String palabraElegida, descubriendoPalabra;
        boolean yaJugado;
        
        
	// Constructor que tiene como parámetro una referencia al socket abierto en por otra clase
	public ProcesadorYodafy(Socket socketServicio) {
		this.socketServicio=socketServicio;
		random=new Random();
                yaJugado=true;
                palabras=new ArrayList();
                palabras.add("relativismo");
                palabras.add("misantropia");
                palabras.add("uranofobia");
                palabras.add("conjunción");
                palabras.add("diagnostico");
                palabras.add("incredulo");
                palabras.add("apoteosico");
                palabras.add("desternillante");
                palabras.add("esternocleidomastoideo");
                
	}

        private void seleccionaPalabra(){
            if(yaJugado){
                palabraElegida="";
                descubriendoPalabra="";
            }
            
            int limite = palabras.size();
            int num_palabra= (int)(Math.random()*limite);
            palabraElegida=palabras.get(num_palabra);
            descubriendoPalabra="";
            int tam = palabraElegida.length();
            for (int i = 0; i < tam; i++) {
                descubriendoPalabra += "_";
            }
            System.out.println("Ha selecionado: " + palabraElegida + "\n");
        }
        
        
        // Busco en la palabra original.
        private boolean existeLetra(char letra){
            boolean existe=false;
            
            int pos = palabraElegida.indexOf(letra);
            if (pos != -1) {
                existe = true;
            }
            System.out.println("existeLetra?: "+ existe);
            return existe;
        }
        
        // Busco en la que está adivinando
        private boolean yaDescubierta(char letra){
            boolean descubierta=false;
            
            int pos = descubriendoPalabra.indexOf(letra);
            if (pos != -1) {
                descubierta = true;
            }
            
            System.out.println("yaDescubierta?: "+ descubierta);
            
            return descubierta;
        }    
        
        private String buscaLaLetra(char letra){
            
            String msg = "";
            
            System.out.println("Letra que me ha llegado: " + letra);
            boolean existe = existeLetra(letra);
            boolean descubierta = yaDescubierta(letra);
            
            if(existe && !descubierta){
                msg="--> Muy bien! Has descubierto la letra: " + letra;
                descubrirLetraOculta(letra);
            }
            
            if(existe && descubierta){
                msg="--> Ya me dijiste eso LELOOOooOOo000 :''(";
            }
            
            if(!existe){
                msg="--> FALLASTE!! :'((";
            }
            
            return msg;
        }
        
        void descubrirLetraOculta(char letra){
            int tam = palabraElegida.length();
            char letraIteradora;
            int anterior = 0;
            
            for (int i = 0; i < tam; i++) {
                letraIteradora = palabraElegida.charAt(i);
                if(letraIteradora == letra){
                    String cero_a_encontrado = substring(descubriendoPalabra,0,i);
                    String encontrado_a_final= substring(descubriendoPalabra,i+1,tam);
                    
                    descubriendoPalabra=cero_a_encontrado;
                    descubriendoPalabra += letra;
                    descubriendoPalabra += encontrado_a_final;
                    
                    
                    anterior = i;
                }
            }
        }
        
        @Override
        public void run(){
            //Para leer/escribir texto.                  
            PrintWriter outPrinter; 
            BufferedReader inReader;     
            boolean salir = false;
            boolean jugar = true;
            
            try{
                // Obtiene los flujos de escritura/lectura
                inputStream=socketServicio.getInputStream();
                outputStream=socketServicio.getOutputStream();
                //Para escribir
                outPrinter = new PrintWriter(outputStream,true);
                inReader = new BufferedReader(new InputStreamReader(inputStream));
                String letra;
                do{
                    outPrinter.println("--> ¿Jugar o salir?: ");
                    outPrinter.flush();
                    
                    String opcion = inReader.readLine();
                    String msg;
                    
                    if("jugar".equals(opcion)){
                        salir = false;
                        jugar = true;
                        this.seleccionaPalabra();
                        this.yaJugado = true;
                        do{
                            msg = "--> Dime una letra | tú: " +this.descubriendoPalabra;
                            outPrinter.println(msg);
                            outPrinter.flush();
                            
                            letra = inReader.readLine();
                            
                            if(!letra.equals("salir") && !letra.equals("rendir")){
                                String resultado;
                                
                                if(letra.equals(palabraElegida)){
                                    jugar = false;
                                    resultado = "-->   ## HAS GANADO!! ##  ";
                                }else{
                                    
                                    resultado = this.buscaLaLetra(letra.charAt(0));
                                }  
                                
                                outPrinter.println(resultado);
                                outPrinter.flush();
                            }else{
                                jugar = false;
                            }
                        }while(jugar);
                    }else
                        salir = true;
                    
                }while(!salir);
                
                
            }catch(IOException e){
                System.err.println("Error al obtener los flujos de entrada/salida.");
            }
        }

	// Aquí es donde se realiza el procesamiento realmente:
	void procesa(){
		// Como máximo leeremos un bloque de 1024 bytes. Esto se puede modificar.
		byte [] datosRecibidos=new byte[1024];
		int bytesRecibidos=0;

		// Array de bytes para enviar la respuesta. Podemos reservar memoria cuando vayamos a enviarka:
		byte [] datosEnviar;

                boolean acierto = false;
                
		try {
			// Obtiene los flujos de escritura/lectura
			inputStream=socketServicio.getInputStream();
			outputStream=socketServicio.getOutputStream();

			// Lee la frase a Yodaficar:
			//bytesRecibidos = inputStream.read(datosRecibidos);
			BufferedReader inReader = new BufferedReader(new InputStreamReader(inputStream));

			// Yoda hace su magia:
			// Creamos un String a partir de un array de bytes de tamaño "bytesRecibidos":
			String peticion=inReader.readLine();
			// Yoda reinterpreta el mensaje:
			String respuesta=buscaLaLetra(peticion.charAt(0));
			// Convertimos el String de respuesta en una array de bytes:
			PrintWriter outPrinter = new PrintWriter(outputStream, true);

			// Enviamos la traducción de Yoda:
			outPrinter.println(respuesta);


		} catch (IOException e) {
			System.err.println("Error al obtener los flujso de entrada/salida.");
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

