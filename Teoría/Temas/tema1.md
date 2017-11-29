# Tema 1

## Sistemas de comunicación y redes
  - **¿Qué son las redes?**: Es un conjunto de equipos informáticos y software
  conectados entre sí por medio de dispositivos físicos que envían y reciben
  impulsos eléctricos, ondas electromagnéticas o cualquier otro medio para el
  transporte de datos, con la finalidad de compartir información, recursos y
  ofrecer servicios.

### Sistema de comunicación?
Composición de dos sistemas que comparten un canal de comunicación en por el que se mandan mensajes. Está compuesto por:
  - **Fuente**: Dispositivo que genera los datos a transmitir. (P.ej. un
    teléfono o un PC)

  - **Transmisor**: Por lo general los datos los genera la fuente, pero no los
  transmite en el formato que los genera. El transmisor, transforma y codifica
  esta información, normalmente en forma de señales Electromagnéticas (EM)
  susceptibles de ser transmitidas a través de algún sistema de transmisión o
  medio.

  - **Sistema de transmisión**: Medio a través del cual se produce el envío de
  información. Puede ser tan simple como una línea de trasmisión, hasta
  una red compleja compuesta por diferentes tecnologías.

  - **Receptor**: Elemento que recibe la información en forma de señal EM a
  través del sistema de transmisión. El receptor transforma esta señal de
  manera que el destino pueda interpretar de manera correcta el
  contenido de dicha información.

  - **Destino**: Último elemento que intervienen en el proceso de
  comunicación. Es el encargado de tomar los datos procesados por el
  receptor.

  - **Tareas del sist. comunicación**:
    - Utilización del sistema de transmisión      ->  Direccionamiento     
    - Implementación de la interfaz física        ->  Encaminamiento       
    - Generación de la señal                      ->  Recuperación         
    - Sincronización                              ->  Formato de mensajes  
    - Gestión del intercambio de la información   ->  Seguridad            
    - Detección y corrección de errores           ->                       
    - Control de flujo                            ->  Gestion de red       

### Incentivos de la red:
  - *Autonomía* -> con capacidad de procesar información
  - *Interconexión* -> mediante un sistema de comunicación
  - *Intercambio de* Información -> con eficacia y transparencia

  - **Razones para uso de redes**:
    - Compartir recursos
    - Escalabilidad
    - Fiabilidad, robustez -> Duplicidad (redundancia)
    - Ahorro de costes

### Componentes de una red
  - **Servidor**: Son computadoras que controlan las redes y se encargan de
  permitir o no el acceso de los usuarios a los recursos, también controlan los
  permisos que determinan si un nodo puede o no pertenecer a una red. La
  finalidad de los servidores es controlar el funcionamiento de una red y los
  servicios que realice cada una de estas computadoras dependerán del diseño
  de la red.

  - **Estación de trabajo**: El nombre que reciben las computadoras conectadas
  a una red pero no pueden controlarla, ni alguno de sus nodos o recursos de
  la misma. Cualquier computadora puede ser estación de trabajo, siempre que
  este conectada y se comunique a la red.

  - **Nodo de red**: Nodo de red es cualquier elemento que se encuentre
  conectado y comunicado a una red; a los periféricos que se conectan a una
  computadora se convierten en nodo si están conectados a la red y pueden
  compartir sus servicios para ser utilizados por los usuarios, como
  impresoras, carpetas.

  - **Tarjetas de red**: Son tarjetas de circuito integrados que se insertan
  en unos órganos de expansión de la tarjeta madre y cuya función es recibir
  el cable que conecta a la computadora con una red informática; así todas las
  computadoras de red podrán intercambiar información

### Medios de transmisón:
  - **Cable coaxial**: Este constituido por un hilo principal de cobre
  cubierta por una capa plástica rodeada por una película reflejante que
  reduce las interferencias, alrededor de ella existe una malla de hilos
  metálicos y todo esto esta cubierto por una capa de hule que protege a los
  conductores de la intemperie.

  - **Cable par trenzado**: Se utiliza para la conexión de redes, es el que
  tiene 4 pares de cables; pero existen 3 variaciones con esta característica
  y pueden utilizarse para comunicarse los nodos de una red.
    - UTP
    - STP
    - FTP

  - **Fibra optica**: La fibra óptica es resistente a la corrosión y a las
  altas temperaturas y gracias a la protección de la envoltura es capaz de
  soportar esfuerzos elevados de tensión en la instalación. La desventaja de
  este cable es que su costo es elevado, ya que para su elaboración se
  requiere vidrio de alta calidad además de ser sumamente frágil de manipular
  durante su fabricación.

### Topología de redes:
Se llama topología de una Red al patrón de conexión entre sus nodos, es decir,
a la forma en que están interconectados los distintos nodos que la forman. La
topología de una red es el arreglo físico o lógico en el cual los dispositivos
o nodos de una red (computadoras, impresoras, servidores, hubs, switches,
enrutadores, etc.) se interconectan entre sí sobre un medio de comunicación.

    Topología física: Se refiere al diseño actual del medio de transmisión de
    la red.

    Topología lógica: Se refiere a la trayectoria lógica que una señal a su
    paso por los nodos de la red.

  - **Topologia anillo**:
  La topología en anillo se caracteriza por un camino unidireccional cerrado
  que conecta todos los nodos. Dependiendo del control de acceso al medio, se
  dan nombres distintos a esta topología: Bucle; se utiliza para designar
  aquellos anillos en los que el control de acceso está centralizado (una de
  las estaciones se encarga de controlar el acceso a la red).

  - **Topologia estrella**:
  En esta red cada estación de trabajo o computadora esta conectada a todas
  las demás computadoras incluidas en la red.
  En esta topología todas las computadoras están interconectadas entre sí por
  medio de un tramado de cables. Esta configuración provee redundancia porque
  si un cable falla hay otros que permiten mantener la comunicación.
  Esta topología requiere mucho cableado por lo que se la considera muy costosa.
  Muchas veces la topología MALLA se va a unir a otra topología para formar
  una topología híbrida.

  - **Topologia arbol**:
  La topología en árbol es una variante de la de estrella.
  Como en la estrella, los nodos del árbol están conectados a un
  concentrador central que controla el tráfico de la red. Sin embargo, no
  todos los dispositivos se conectan directamente al concentrador central.
  La mayoría de los dispositivos se conectan a un concentrador secundario
  que, a su vez, se conecta al concentrador central.

  - **Topologia malla**:
  En esta red cada estación de trabajo o computadora esta conectada a todas
  las demás computadoras incluidas en la red.
  En esta topología todas las computadoras están interconectadas entre sí
  por medio de un tramado de cables. Esta configuración provee redundancia
  porque si un cable falla hay otros que permiten mantener la comunicación.
  Esta topología requiere mucho cableado por lo que se la considera muy
  costosa. Muchas veces la topología MALLA se va a unir a otra topología para
  formar una topología híbrida.

  - **Topologia Hibrida**:
  La tipología híbrida es una de las más frecuentes y se deriva de la unión de
  varios tipos de topologías de red, de aquí el nombre de híbridas.
  En una topología híbrida, se combinan dos o más topologías para formar un
  diseño de red completo. Raras veces, se diseñan las redes utilizando un solo
  tipo de topología. Importante: En una topología híbrida, si un solo equipo
  falla, no afecta al resto de la red.

### Clasificación de redes según su tamaño
  - **LAN**: Las redes de área local (Local Area Network) son redes de
  ordenadores cuya extensión es del orden de entre 10 metros a 1 kilómetro.
  Son redes pequeñas, habituales en oficinas, colegios y empresas pequeñas,
  que generalmente usan la tecnología de broadcast, es decir, aquella en que
  a un sólo cable se conectan todas las máquinas. Como su tamaño es
  restringido, el peor tiempo de transmisión de datos es conocido, siendo
  velocidades de transmisión típicas de LAN las que van de 10 a 100 Mbps
  (Megabits por segundo).

  - **MAN**:Las redes de área metropolitana (Metropolitan Area Network) son
  redes de ordenadores de tamaño superior a una LAN, soliendo abarcar el
  tamaño de una ciudad. Son típicas de empresas y organizaciones que poseen
  distintas oficinas repartidas en un mismo área metropolitana, por lo que,
  en su tamaño máximo, comprenden un área de unos 10 kilómetros.

  - **WAN**: Las redes de área amplia (Wide Area Network) tienen un tamaño
  superior a una MAN, y consisten en una colección de host o de redes LAN
  conectadas por una subred. Esta subred está formada por una serie de líneas
  de transmisión interconectadas por medio de routers, aparatos de red
  encargados de rutear o dirigir los paquetes hacia la LAN o host adecuado,
  enviándose éstos de un router a otro. Su tamaño puede oscilar entre 100 y
  1000 kilómetros.

  - **Internet**: Una internet es una red de redes, vinculadas mediante routers
  gateways. Un gateway o pasarela es un computador especial que puede traducir
  información entre sistemas con formato de datos diferentes. Su tamaño puede
  ser desde 10000 kilómetros en adelante, y su ejemplo más claro es Internet,
  la red de redes mundial.

  - **Inalambricas**: Las redes inalámbricas son redes cuyos medios físicos no
  son cables de cobre de ningún tipo, lo que las diferencia de las redes
  anteriores. Están basadas en la transmisión de datos mediante ondas de radio,
  microondas, satélites o infrarrojos.

### Clasificación según su transmisión
  - **Redes broadcast**: La transmisión de datos se realiza por un sólo canal
  de comunicación, compartido entonces por todas las máquinas de la red.
  Cualquier paquete de datos enviado por cualquier máquina es recibido por
  todas las de la red.

  - **Point to point**: Aquellas en las que existen muchas conexiones entre
  parejas individuales de máquinas. Para poder transmitir los paquetes desde
  una máquina a otra a veces es necesario que éstos pasen por máquinas
  intermedias, siendo obligado en tales casos un trazado de rutas mediante
  dispositivos routers.

### Clasificación según dados que soportan**:
  - **Redes de transmisión simple**: Son aquellas redes en las que los datos
  sólo pueden viajar en un sentido.

  - **Redes Half-Duplex**: Aquellas en las que los datos pueden viajar en
  ambos sentidos, pero sólo en uno de ellos en un momento dado. Es decir,
  sólo puede haber transferencia en un sentido a la vez.

  - **Redes Full-Duplex**: Aquellas en las que los datos pueden viajar en
  ambos sentidos a la vez

## Diseño y estandarización de redes

### Modelo OSI:
El modelo OSI (Open System Interconection) es utilizado por prácticamente la
totalidad de las redes del mundo.
Este modelo fue creado por el ISO (Organización Internacional de Normalización),
y consiste en siete niveles o capas donde cada una de ellas define las funciones
que deben proporcionar los protocolos con el propósito de intercambiar información
entre varios sistemas.
Esta clasificación permite que cada protocolo se desarrolle con una finalidad
determinada, lo cual simplifica el proceso de desarrollo e implementación.
Cada nivel depende de los que están por debajo de el, y a su vez proporciona
alguna funcionalidad a los niveles superiores.

                        *De más nivel a menos*


  - **Aplicación**: Ofrece a las aplicaciones la posibilidad de acceder a los
  servicios del resto de capas y define los protocolos que utilizan las
  aplicaciones para intercambiar datos como:
    - Correo electrónico (POP y SMTP),
    - Gestores de bases de datos y servidor de ficheros (FTP).
    - Muchas más….
    - Hay tantos protocolos como aplicaciones distintas y debido a que las redes
    están en continuo crecimiento, se desarrollan nuevas aplicaciones y con ello,
    el numero de protocolos.
    - Debemos tener en cuenta que el usuario normalmente no interactúa
    directamente con el nivel de aplicación, sino que interactúa con programas
    que a su vez interactúan con el nivel de aplicación pero ocultando la
    complejidad de estas tareas.

  - **Presentación**: encargarse de la representación de la información, de
  manera que aunque distintos equipos puedan tener diferentes representaciones
  internas de caracteres (ASCII, Unicode, EBCDIC), números, sonido o imágenes,
  los datos lleguen de manera reconocible.

    - Esta capa es la primera en trabajar mas el contenido de la comunicación.
    En ella se tratan aspectos tales como la semántica y la sintaxis de los
    datos transmitidos, ya que distintas computadoras pueden tener diferentes
    formas de manejarlas.

    - Esta capa también permite cifrar los datos y comprimirlos.

  - **Sesión**: establece, gestiona y finaliza las conexiones entre usuarios
  (procesos o aplicaciones) finales. Ofrece varios servicios muy importantes
  para la comunicación, como:
    - Control de la sesión a establecer entre el emisor y el receptor (quien
      transmite, quien escucha y seguimiento de esta).
    - Control de la concurrencia (que dos comunicaciones a la misma operación
      critica no se efectúen al mismo tiempo).
    - Mantener puntos de verificación que sirven para que, ante una interrupción
      de transmisión por cualquier causa, la misma se pueda reanudar desde el
      ultimo punto de verificación en lugar de repetirla desde el principio.

  - **Transporte**: La función básica de la Capa de transporte es aceptar los
  datos enviados por las capas superiores, dividirlos en pequeñas partes si es
  necesario, y pasarlos a la capa de red.
  En el caso del modelo OSI, también se asegura que lleguen correctamente al
  otro lado de la comunicación.

  - **Red**: El cometido de la capa de red es hacer que los datos lleguen desde
  el origen al destino, aun cuando ambos no estén conectados directamente. Los
  dispositivos que facilitan tal tarea se denominan Routers o enrutadores.
  La capa de red lleva un control de la congestión de red, que se produce cuando
  una saturación de un nodo tira abajo toda la red.
  La PDU de la capa 3 recibe el nombre de paquete.
  En este nivel se realiza el direccionamiento lógico y la determinación la ruta
  de los datos hasta su receptor final.

  - **Enlace Datos**: se encarga proporcionar una transmisión sin errores, es
  decir, un transito de datos fiable a través de un enlace físico.
  Debe crear y reconocer los limites de las tramas y resolver los problemas
  derivados del deterioro, perdida o duplicidad de las tramas.
  La capa de enlace de datos se ocupa del direccionamiento físico, de la
  topología de la red, del acceso a la red, de la notificación de errores, de la
  distribución ordenada de tramas y del control del flujo.

  - **Fisica**: se encarga de las conexiones físicas de la computadora hacia la
  red en lo que se refiere al medio físico; características del medio y la forma
  en la que se transmite la información. Se encarga de transformar una trama de
  datos proveniente del nivel de enlace en una señal adecuada al medio físico
  utilizado en la transmisión. Estos impulsos pueden ser eléctricos (transmisión
    por cable) o electromagnéticos (transmisión sin cables). Sus principales
    funciones:
    - Definir el medio o medios físicos por los que va a viajar la comunicación:
    cable de cobre, coaxial, guias de onda, aire, fibra ótica.
    - Definir las características materiales (componentes y conectores) y
    eléctricas (niveles de tensión) que se van a usar en la transmisión de los
    datos por los medios físicos.
    - Definir las características de la interfaz (alimentación, mantenimiento y
      liberación del enlace físico).
      - Transmitir el flujo de bits a través del medio.
      - Manejar las señales eléctricas/electromagnéticas
      - Especificar cables, conectores y componentes de interfaz con el medio de
      transmisión, polos en un enchufe, etc.
      - Garantizar la conexión (aunque no la fiabilidad de esta).

### Comparación OSI vs TCP/IP
  - TCP/IP es el protocolo común utilizado por todas las computadoras
  conectados a Internet, de manera que estas puedan comunicarse entre si.
  - Internet se encuentran conectadas computadoras de clases muy diferentes y
  con hardware y software incompatibles en muchos casos.
  - TCP/IP se encargara de que la comunicación entre todos sea posible.
  - TCP/IP es compatible con cualquier SO y con cualquier tipo de hardware.
  - TCP/IP no es un único protocolo, sino que es en realidad lo que se conoce
  con este nombre es un conjunto de protocolos que cubren los distintos niveles
  del modelo OSI.
  - Los dos protocolos mas importantes son el TCP (Transmission Control
    Protocol) y el IP (Internet Protocol), que son los que dan nombre al
    conjunto a este modelo.

En Internet se diferencian cuatro niveles o capas en las que se agrupan los
protocolos, y que se relacionan con los niveles OSI de la siguiente manera:

  - Aplicación: Se corresponde con los niveles de aplicación, presentación y
  sesión. Se incluyen protocolos destinados a proporcionar servicios, tales como
  correo electrónico (SMTP), transferencia de archivos (FTP), conexión remota
  (TELNET) y otros mas recientes como el protocolo HTTP (Hypertext Transfer
    Protocol).

  - Transporte: Coincide con el nivel de transporte del modelo OSI. Los
  protocolos de este nivel, tales como TCP y UDP, se encargan de manejar los
  datos y proporcionar la fiabilidad necesaria en el transporte de los mismos.

  - Internet: Es el nivel de red del modelo OSI. Incluye al protocolo IP, que se
  encarga de enviar los paquetes de información a sus destinos correspondientes.
  Es utilizado con esta finalidad por los protocolos del nivel de transporte.

  - Acceso al medio: Los niveles OSI correspondientes son el de enlace y el
  nivel físico. Los protocolos que pertenecen a este nivel son los encargados de
  la transmisión a través del medio físico al que se encuentra conectado cada
  host, como puede ser una línea punto a punto o una red Ethernet.

## Terminología y servicios
