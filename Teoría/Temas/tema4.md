# Tema 4 | Redes conmutadas e internet

## 1. Funcionalidades

La capa de red actua como una especie de interfaz o API para la capa de enlace, permitiendo que las distintas tecnologias de todas las redes de internet se puedan intercomunicar. Para ello, la capa de red implementa una serie de funcionalidades:
  - **Encaminamiento**: es la función de buscar un camino entre los todos los posibles en una red de paquetes que cuyas topolofías poseen una gran conectibidad. Dado que se trata de encontrar la mejor ruta posible, lo primero será definir que se entiende por "mejor ruta" u en consecuencia cual es la "métrica" que se debe utilizar para medirla.
  - **Conmutación**: La conmutación podría definirse como la manera de la que la información navega por la red (en forma de flujos, de circuitos, pquetes, etc.)
  - **Interconexión de redes**: Es un conjunto de redes (que pueden ser de tipos diferentes) que están interconectadas por medio de encaminadores, gateways, u otros dispositivos, para que de este modo puedan funcionar como una sola gran red.
  - **En OSI**: control de congestión se encuentra en la capa de red, sin embargo, en TCP/IP se encuentra en la capa de transporte, es decir, lo hace TCP.

### 2. Conmutación
La conmutación podría defirse como una redirección en la red. Hay dos esquemasd e conmutación:
  - **Circuitos**: Establece un circuito para la comunicación entre los dos finales. Una vez iniciada la conexión, se crea un circuito que pasa por una serie de nodos intermedios (por ejemplo, en una red de ordenadores podrían ser los routers) y siempre se mantendrá dicho circuito. De hecho, el circuito será dedicado donde los recursos estarán dedicados únicamente a dicha conexión, es decir, habrá una parte del cable reservada para dicho circuito. Se crea una especie de tubería para la comunicación entre esos dos finales, únicamente puede pasar información de dicha comunicación por esa tubería. La implementación de la conmutación es más sencilla pero estamos perdiendo recursos que dejamos dedicados para dicha comunicación.
  - **De paquetes**:
    - **Datagramas**:es la conmutación basada en paquetes propiamente dicha. En este caso, la comunicación se divide en paquetes y cada paquete es una entidad lógica independiente que viaja por internet. Un ejemplo de ello es IP, no hay conexión ya que no es necesario reservar recursos pero todos los paquetes que enviemos tendrán un retardo de procesamiento y los datagramas pueden seguir rutas diferentes.A la hora de enviar un segundo paquete, le pasará lo mismo. Todos los paquetes deben de tener un tiempo de procesamiento en cada nodo para poder ser reenviados. Cada paquete al ser una entidad independiente deberá de llevar información sobre su destino, al contrario que la conmutación de circuitos.
    - **Circuitos virtuales**: En la conmutación basada en circuitos virtuales, usamos la misma tecnología que en la conmutación basada en datagramas, pero intentando minimizar el tiempo de procesamiento que debe tener el paquete en cada nodo. Para ello, se crean circuitos virtuales por encima de la red basada en datagramas, lo cual implica que todos los paquetes son enviados por el mismo camino consiguiendo reducir así el tiempo de procesamiento dedicado al encaminamiento.

La parte negativa de usar un único camino es la robustez. Si enviamos paquetes a través de la red con la libertad de poder elegir el camino por el cual los enviamos, la red es muy robusta, ya que si se cae un enlace se puede enviar el paquete a través de cualquier otro. El paquete tardará algo más en llegar, pero llegará al destino. Si en una red telefónica se cae uno de los enlaces por los que pasa nuestra llamada se termina la llamada y se tendría que llamar otra vez. Esta limitación es heredada en la conmutación a través de circuitos virtuales.


## 3. El protocolo IP
El protocolo IP hace que sea posible la idea de internet como una intercomunicación de redes. IP nos permite abstraernos de las distintas tecnologías que usan las redes y por tanto, que todas las redes puedan comunicarse entre sí y que exista el concepto de InternerWorking.

  - IPv4 es la versión más extendida de IP. Se ha hecho un gran esfuerzo por extender IP v6, ya que soluciona bastantes problemas que IP v4 no.
  - IP permite la interconexión de redes y el direccionamiento en internet, es decir, con las direcciones IP determinamos a los distintos dispositivos en internet a los que les puede llegar un paquete.
  - Para poder enviar un paquete a través de internet, se utiliza el enrutamiento que utiliza a su vez una retransmisión salto a salto.
  - IP es parecido a UDP, de hecho los paquetes de IP se denominan datagramas al igual que UDP. No es orientado a conexión, ni es fiable, sino que es best-effort, es decir, hace el máximo esfuerzo por que el paquete llegue a su destino pero si no llega "le da igual". En IP no hay "handshake" ni existe el control de errores ni de flujo.
  - También gestiona la fragmentación, importante en internet.

### 3.1 Direcciones IP
Aunque el nombre de dominio es lo que usamos nosotros y lo que usan muchas de las aplicaciones que tenemos instaladas, a bajo nivel lo que realmente se usan son las direcciones IP. El protocolo DNS es el encargado de traducir un nombre de dominio a su dirección IP. Las direciones IP deben ser unívocas, es decir, no se pueden compartir entre servicios y además, debe existir algún mecanismo para saber el camino que debe tomar un paquete para llegar a su destino.

El protocolo IP es un direccionamiento jerárquico, compuesto por dos la subred y el dispositivo. prefijo de subred indica la dirección de un grupo de ordenadores, que es lo que subred, que están localizados en el mismo sitio y la máscara de subred determina qué parte de dirección IP pertenece a la subred y qué parte de la dirección IP identifica al ordenador de subred. **La máscara de red diferencia ambas partes, si la ponemos en binario, todos los unos serán la parte de la dirección de subred y todos los ceros serán de la parte del host.**

**¿Qué es una subred?**: Es un conjunto de ordenadores que están localizados en el mismo lugar, que comparten una parte de su dirección IP y que se accede a ellos a través del mismo camino.

**¿Cómo se elige la máscara?**: La máscara de red depende del número de hosts que haya en dicha red, ya que dependiendo del número de ceros que dejemos podremos tener un número de hosts concreto. El número de dispositivos máximo será:
                Num_dispositivos = 2^num_ceros - 2
Debemos restar dos debido a que hay dos direcciones IP que están reservadas en todas las subredes, la primera y la última. La 0..0 para la subred y la 1...1 para la difusión. Esta posiciones son referidas al ultimo octeto de la IP.

### 3.2 Direcciones públicas y privadas.
Todos los ordenadores estarán conectados a switches y ante los hosts se conectan con routers. El switch opera solo en capa de 2 y el router en cada red. Los dispositivos que no operan en capa de red, por lo que generan una frontera, pero los otros sí. Lo que me queda en verde son las subredes. Los host operan en capa de red ya que tienen dirección IP.

### 3.3 Encaminamiento
Tiene como objetivo llevar cada paquete a su destino. Es la suma de dos operaciones:
  - Encaminamiento per se (routing): que consiste en decidir la ruta del paquete.

  - Retransmisión (forwarding): es la implementación de dicho encaminamiento.

### 3.4 Retransmisión salto a salto
Por donde se envia el paquete es equivalente a decir cómo se llega al siguiente nodo. Esto se hace en el nodo inicial, y en el resto de nodos, el host inicial preguntaría al switch de la red interna, que encaminaría la pregunta y así entre switches hasta llegar al último host.

### 3.5 Tabla de encaminamiento
Es una tabla que pertenece al host, es decir, cada host tiene su propia tabla de encaminamiento, y en la cual hay mínimo tres columnas:
  - Dirección IP destino: siempre es una dirección de subred. Dado que el objetivo es hacer la tabla lo más pequeña posible, en vez de tener una fila por cada host al que podemos enviar un paquete, sólo tenemos una fila por cada subred que represente a todos y cada uno de los host pertenecientes a dicha subred.
  - Máscara: asociada a dicha subred.
  - Siguiente nodo: router más cerno.

Para determinar numéricamente la subred a la que pertecene una dirección IP destino, se realiza una operación & con todas y cada una de las máscaras de la tabla y compara el resultado con la dirección de destino de la tabla. La entrada seleccionada será la que coincida, es decir, haga matching, con la dirección IP destino de la tabla.

Si existiese una colisión se usaría la máscara más restrictiva, la que tiene más unos.


## 4. Asociación con Capa de Enlace: El protocolo ARP
De alguna forma hay que pasar los paquetes a la capa de enlace(capa de enlace nodo a nodo). Para ello usa la dirección MAC, que identifica las tarjetas de red. Necesitamos un protocolo que traduzca de IP a MAC y viceversa, este es el protocolo ARM. El formato de la dirección MAC es en hexadecimal. El ARP directo consigue la MAC a partir de la IP. Esto no lo hace siempre, lo guarda en la caché.

### 4.1 Formato ARP

  ![formato_ARP](http://)

Lo primero que se indica en un paquete ARP es el tipo de protocolo de capa de enlace y a continuación el tipo de protocolo de capa de red, por ejemplo el protocolo Ethernet se identifica con un 1 y el protocolo IP con un 8 (H significa hardware y P, Protocol), tras eso, se indica la longitud de cada una de las direcciones en bytes. En primer lugar indicamos la dirección hardware del emisor, tras eso, indicamos la dirección IP del emisor y por último, indicamos las direcciones hardware e IP del receptor.

## 5. El protocolo ICMP
Es un protocolo de capa de enlace, que está encapsulado en IP, simplemente significa que la cabecera del protocolo que encapsula va antes que la del otro, es decir, un protocolo está en una capa que da servicio a otro protocolo que está encapsulado.

Los errores siempre se envían al origen, por ejemplo, cuando intentamos hacer ping a un ordenador que no existe y vemos un mensaje en terminal indicándonos que no existe dicha dirección.

  ![ICMP](http://)
