# Tema 1 | Introducción Fundamentos de redes

## 1.1 Sistemas de comunicación y redes

**¿Qué son las redes?**: Es un conjunto de equipos informáticos y software conectados entre sí por medio de dispositivos físicos que envían y reciben impulsos eléctricos, ondas electromagnéticas o cualquier otro medio para el transporte de datos, con la finalidad de compartir información, recursos y ofrecer servicios.

**¿Qué es el sistema de comunicación?** Es el conjunto de elementos y dispositicos involucrado en la transmisión de información entre dos puntos remotos, estos elementos son:

  ![esquema_sis_comunicación](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img1-tema1.png)

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

**¿Tareas del sist. comunicación?**:
  - Utilización del sistema de transmisión      ->  Direccionamiento     
  - Implementación de la interfaz física        ->  Encaminamiento       
  - Generación de la señal                      ->  Recuperación         
  - Sincronización                              ->  Formato de mensajes  
  - Gestión del intercambio de la información   ->  Seguridad            
  - Detección y corrección de errores           ->              
  - Control de flujo                            ->  Gestion de red       

**Pincipales características**:
  - **Autonomía** -> con capacidad de procesar información por si mismo, los equipos de una red son independientes en cuanto a su funcionamiento.
  - **Interconexión** -> mediante un sistema de comunicación, implica la existencia de uno o varios canales de transmisiñib qye permite la comunicación entre los diferentes equipos de la red.
  - **Intercambio de Información** -> con eficacia y transparencia, que implica el hecho de poder intercambiar información.

### 1.1 Usos y clasificación de las redes

**Razones para uso de redes**:
  - **Compartir recursos**: Principal caracteristica de los sistemas de redes.
  - **Escalabilidad**: La amplicaciñon del sericio a un númeor mayor de usuarios en un entorno podría es facilemente aplicable.
  - **Seguridad**: Al existir varios equipos con capacidades de intercqambio de información, cada uno con sus propias unidades de disco, memoria, etc, puede habeber duplicación de recursos, lo que, en ultima instancia, se traduce en un aumento de la seguridad.
  - **Minimizaación de costes**: Es evidente que resulta menos costosa la reparación o sustitución de un equipo PC que la de un superordenador. Por ello el uso de quipos sencillo interconectados es más económico que un solo equipo muy potente.

**Clasificación de redes según su tamaño**:
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

**Clasificación según su topología**, es decir, de la dorma en la que están conectados los equipos:
  - **Difusión**: En este caso existen un único medio de transmisión, compartido pr todos los equipos, sobre el que se realizan todas las transmisiones.
  - **Punto a punto**: Frente a la disposición de único canal de transmisión por parte de varios terminales, los enlaces con con solo dos de ellos, uno haciendo las veces de emisor y el otro de receptor se denominan conexiones punto a punto.
  - **Totalmente conectada**: Cuando el número de enlaces es igual al número de parejas posibles, es decir, todos están conectados con todos dos a dos.


**Componentes de una red**:
  - **Hots**: El nombre que reciben las computadoras conectadas
  a una red pero no pueden controlarla, ni alguno de sus nodos o recursos de
  la misma. Cualquier computadora puede ser estación de trabajo, siempre que
  este conectada y se comunique a la red.

  - **Subred**: es el conjunto de elementos que posibilitan la interconexión de los hots. La subred está compuesta a su vez de:
    - **Lineas de teansmisión**: canales o enlaces de comunicación.
    - **Nodos de conexión**: dispositivos que transportan datos desde un origen a un destino dados.

## 1.2 Diseño y estandarización de las redes.
Cuando se plantea el diseño de una red hay que resolver diversos problemas (transmisión de bits, acceso al medio, control de errores) a fin de conseguir una comunicación eficaz y transparente de los hots involucrados. Para solucionarlos de usan:
  - **Paquetes**: unidades de información que identifican los datos necesarios que se necesitan entre hots. Estos paquetes incluyen cabeceras que tiene que ver con el punto siguiente.
  - **Capas**: Equivalente a agrupar en funciones o tareas relacionadas de modo que se minimixa el trasvase de información entre las capas. Esto permite conseguir un sistema más modular y flexible.
  - **La estandarización**: El conjunto de capas y funciones asociadas se denomina modelo de referencia. Tanto desde el punto de vista del propietario o distibuidor como del consumidor interesa la existencia de estandares.

Así nacen dos formas de ver los modelos de referencia:
  - **de facto**: han sido adptados sin haber seguido un proceso de estandarización normal.
  - **de jure**: han sido desarrollados por organismos de estandarización.

### 1.2.1 Modelo ISO
El modelo OSI (Open System Interconection) es utilizado por prácticamente la totalidad de las redes del mundo. Este modelo fue creado por el ISO (Organización Internacional de Normalización), y consiste en siete niveles o capas donde cada una de ellas define las funciones que deben proporcionar los protocolos con el propósito de intercambiar información entre varios sistemas. Esta clasificación permite que cada protocolo se desarrolle con una finalidad determinada, lo cual simplifica el proceso de desarrollo e implementación. Cada nivel depende de los que están por debajo de el, y a su vez proporciona alguna funcionalidad a los niveles superiores.

  - **Capa física**: En ella se llevan a cabo funciones relacionadas con la transmisión de datos desde el punto de vista de la gestión de características eléctricas, mecánicas y funcionales para una adecuada transferencia sobre el canal. Sería la tarjeta de red.
  - **Capa de enlace**: los bits de datos se agrupan en bloques llamados tramas, tiene tres funciones:
    - **delimitación de tramas**, para conocer el principio y el fin de un bloque de
    datos y sincronizar al emisor y al receptor
    - control de errores**, para conseguir que la información recibida se corresponda
    con la enviada
    - **control de flujo**, para evitar que el emisor sature el buffer de recepción del
    destino debido a una velocidad u ocupación diferente de las dos partes.
  - **Capa de red**: Tiene que tres funciones basicas:
    - **encaminamiento**, cuyo objetivo es el establecimiento de la ruta (secuencia de líneas y nodos de conmutación en la subred) a seguir desde un origen hasta un destino.
    - **control de congestión**, evita la saturación de la capacidad de la subred como consecuencia de un elevado tráfico.
    - **interconexión de redes**, posibilita la transmisión de datos entre estaciones finales situadas en redes distintas.
  - **Capa de transporte**: Mismas funciones de la capa de red pero ve los numerosos caminos de conexión como una sola entidad donde ya se ha resuelto esto delimitando así la gestión unicamente entre dos hots.
  - **Capa de sesión**: turno de palabra, cuando habla uno y cuando habla el otro.
  - **Capa de presentación**: capa encargada de la representación de los datos que viene de la capa superior, por ejemplo atraves del cifrado o codificación de los mismo. Esta capa permite recolver las heterogeneidades respecto de la diferencia de representación interna de la información en cada uno de los hots extremos.
  - **Capa de aplicación**: cualquier tipo de aplicación que tenemos que se comunica con Internet. Ahí tenemos los protocolos.

El modelo OSI tiene capas con muy poco contenido, por eso, en otros modelos se emplea un número menor de capas mediante trasvase de funciones asociadas a otros niveles.

### 1.2.2 Modelo TCP/IP
Es una arquitectura, no un modelo. Tiene tres capas:
  - **Aplicación**: servicios de usuario como telnet, ftp, smtp.. etc.
  - **Transporte**: Conntrol del flujo, de errores, de congestión y de conexión extremo a extremo.
  - **Red**: función de encaminamiento.

TCP/IP es una red software, ya que puede implementarse sobre cualquier tecnología de red sin ser dependiente de ella, por ello, TCP/IP es el modelo más extendido en la actualidad y un ejemplo de de facto. ¿Por qué en TCP/IP no se considera la red subyacente como parte del modelo? Porque TCP/IP es software estándar, pero la red subyacente puede variar en cada ordenador.

### 1.3 Terminología y servicios
Dadas dos capas adyacentes, N y N+1, la capa inferior se denomina proveedora de servicios y la superior usuarioa de servicios, por cuanto que la capa N ofrece una sere de funciones o prestaciones (servicios) transparentes a la superior.

Existen, pues, dos tipos de comunicación entre un emisor y un receptor:
  - **Real o vertical**: Es el flujo que sigue la informaciń entre el emisor y el receptor: intercambio de datos entre capas adyacentes, en sentido descendente (aplicación -> fisica) en el emisor y ascendente (fisica -> aplicación) en el receptor.
  - **Virtual u horizontal**: Es la comunicación observada desde el punto de vista de las entidades paritarias. Es decir, la realización de una función dada implica la colaboración de las entidades pares emisora y receptora. En cada capa, salvo la fisica, se añade una serie de información suplementaria, llamda cabecera destinada a permitir una comunicación coherente entre las entidades paritarias involucradas.

En relación con la comunicación horizontal, un protocolo es el conjunto de reglas y convenciones que se tienen que aplicar en una comunicación entre dos entidades. A las capas y protocolos asociados se les denominan **arquitectura de red**. En este sentido OSI no es una arquitectura porque no se definen los protocolos, mientras que TCP/IP sí es una arquitectura, ya que en cada capa se conocen los protocolos que se tienen que tener en cuenta. La especificación en capas de una arquitectura de red se conoce como pila de protocolos.


Los servicios ofrecidos por cada una de las capas pueden ser de dos tipos:
  - **Servicios orientados a conexión**: hay un inicio de conexión antes de empezar el servicio.
  - **No orientado a conexión**: se usa cuando se necesita alta velocidad o necesitamos que llegue a tiempo.
  - **Confirmado**: el host emisor tiene constancia de que al host receptor le ha legado el paquete.
  - **No confirma**: Lo contrario.


### 1.4 Internet, aquitectura y direccionamiento
  - **Arquitectura**: Existen varios tipos de red, estableciendo una topología jerárquica:
    1. **Intranets** (Ethernet) del usuario: zona pública+zona privada. Se refieren a  las redes locales de cada usuario donde se incluyen direcciones privadas  para su subred local y direcciones públicas para acceder a la red.  
    2. **Redes de acceso**: xDSL (toda la familia DSL, por ejemplo, ADSL), RDSI, FTTH  (Fibre To The Home (fibra óptica)), etc del ISP.  
    3. **Redes troncales**: ATM, SDH, SONET, etc... de grandes operadores de telecomunicaciones.  Un ejemplo de red troncal sería la red iris, que conecta a  la comunidad investigadora y las distintas universidades en España. Hay  varios tipos de redes troncales, según su tamaño: Tier-1, Tier-2 y Tier-3.

Los puntos neutros son puntos en los cuales las distintas redes ISP se interconectan  para intercambiar tráfico.

  - **Direccionamiento hhtp**: Cuando queremos acceder a una página web, se forma un paquete de datos con una determinada información en las distintas capas que se iban trasmitiendo entre los distintos nodos a través de internet hasta llegar al destino, devolviendo la información requerida. El direccionamiento dependiendo se la capa se hace de distintas formas:
    - **Nombre del domino**: En la capa de aplicación, para direccionar se usa el nombr del dominio debido a que la capa de aplicación es justo la que intercciona con nosotros y un nombre del domino es más facil de recordar.
    - **Dir. IP**: Se localiza en la capa de red e identifica a los host, tanto fuente ocmo destino.
    - **Puertos**: Un puerto sirve para contestar peticiones que nos envien otros dispositivos. Hay puertos de proposito específico, dinámicos, etc. Se localizan en la capa de transporte.
