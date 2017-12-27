# Tema 2 | Servicios y Protocolos de Aplicación en Internet

## 1. Introducción a las aplicaciones de red

**Protocolos TCP/IP**: El origen de esta familia de protocolos fue la red ARPANET (en ella se desarrollaron los conceptos fundamentales de diseño y gestión de redes). Los niveles más bajos (enlace y físico) no están implementados ya que se diseñó para no depender de una red física concreta: Los protocolos ARP (Adress Resolution Protocol) y RARP (Reverse Adress Resolution Protocol) se encargan de enlazar los sistemas de direccionamiento IP y el de la red física utilizada.

  - **Capa de Red**: La base de la familia de protocolos es el nivel de Red (IP, Internet Protocol). Es un protocolo de conmutación de paquetes muy sencillo, de tipo datagrama, de forma que se pueda implementar en cualquier tipo de máquina. Existen dos versiones **IPv4**, **IPv6**.
    - **ICMP** (Internet Control Message Protocol): comunicación de mensajes entre nodos de la red
    - **IGMP** (Internet Group Mangement Protocol): envío de mensajes a grupos de usuarios.

  - **Capa transporte**: Implementa protocolos extremo a extremo(entre nodo origen y destino de la información). Se definen dos protocolos:
    - **TCP** (Transmission Control Protocol):Es un protocolo orientado a la conexión con control de errores, se encarga también del control de flujo, fragmentado y reensamblado de flujos (garantiza el secuenciamiento)
    - **UDP** (User Datagram Protocol): Es un protocolo sin conexión (datagrama). No realiza control de errores, no garantiza el secuenciamiento de la información, es muy rápido Útil para peticiones aisladas, o transmisión de audio o vídeo

  - **Capa de aplicación**:
    - **Protocolos basados en TCP**:
      - TELNET: terminal remoto
      - FTP(File Transfer Protocol): transmisión de ficheros
      - SMTP(Simple Mail Transfer Protocol): correo electrónico
      - HTTP(HyperText Transfer Protocol: páginas web
    - **Protocolos basados en UDP**:
      - SNMP(Simple Network Management Protocol): gestión de red
      - DNS(Domain Name System)

En defenitiva:
  - Servicio TCP:
    - Orientado a conexión
    - Transporte fiable
    - Control de flujo
    - Control de congestión
  - Servicio UDP:
    - No orientado a conexión
    - Transporte no fiable
    - Sin control de flujo
    - Sin control de congestión,
    - ¿Para qué existe UDP? -> DNS rutas de direccionamiento??


### 1.1 Arquitectura cliente servidor
La arquitectura cliente-servidor es una forma especifica de diseño de aplicaciones, aunque también se conoce con este nombre a las computadoras en las que estas aplicaciones son ejecutadas.

El cliente es la computadora que se encarga de efectuar una petición o solicitar un servicio. El cliente no posee control sobre los recursos, sino que es el servidor el encargado de manejarlos.

La computadora remota que actúa como servidor evalúa la petición del cliente y decide aceptarla o rechazarla consecuentemente.

Una vez que el servidor acepta el pedido la información requerida es suministrada al cliente que efectuó la petición, siendo este ultimo el responsable de proporcionar los datos al usuario con el formato adecuado.

Finalmente debemos precisar que cliente y servidor no tienen que estar necesariamente en computadoras separadas, sino que pueden ser programas diferentes que se ejecuten en la misma computadora.

  - **Ventajas**: El modelo cliente/servidor se recomienda, en particular, para redes que requieran un alto grado de fiabilidad. Las principales ventajas son:
    - **Recursos centralizados**: debido a que el servidor es el centro de la red, puede administrar los recursos que son comunes a todos los usuarios.
    - **Seguridad mejorada**: la cantidad de puntos de entrada que permite el acceso a los datos no es importante.
    - **Administración al nivel del servidor**: ya que los clientes no juegan un papel importante en este modelo, requieren menos
    administración.
    - **Red escalable**: es posible quitar o agregar clientes sin afectar el funcionamiento de la red y sin la necesidad de realizar mayores modificaciones.

  - **Desventajas**: La arquitectura cliente/servidor también tiene las siguientes desventajas:
    - **Costo elevado**: debido a la complejidad técnica del servidor.
    - **Servidor es el eslabón débil**: el servidor es el único eslabón débil en la red de cliente/servidor, debido a que toda la red está construida en torno a él. Afortunadamente, el servidor es altamente tolerante a los fallos (principalmente gracias al sistema RAID).

En definitiva:

  - Servidor:
    - Siempre en funcionamiento
    - IP permanente & pública
    - Agrupados en “granjas”

  - Cliente:
    - Funcionando intermitentemente
    - Pueden tener IP dinámica & privada
    - Se comunican con el servidor
    - No se comunican entre sí

Además, el cliente comienza la comunicación y el proceso servidor espera a ser contactado IP permanente y publica. Existe un proceso que envia/recive mensajes a/desde un socket. Para recibir mensajes el proceso ha de tener un identificador (IP + puerto).

**SOCKET**: como un descriptor de una transmisión a través del cual la aplicación puede enviar y/o recibir información hacia y/o desde otro proceso de aplicación. Es una _puerta_ de acceso entre la aplicación y los servicios de transporte. En la práctica un socket es un puntero a una estructura

Para administrar el retardo de las comunicaciones entre cliente/servidor se usan colas, teoría de colas.

## 1.2 ¿Que es y define un protocolo?
Un protocolo define una serie de tipos de servicios. Dentro de un mismo protocolo hay varios tipos de mensajes: mensaje de solicitud, mensaje de respuesta. El mensaje más gordo es el de respuesta. Las cabeceras tienen que tener una sintaxis, es decir, un formato. Lo que nosotros recibimos en la tarjeta de red es un flujo de bits. Finalmente hay unas reglas, por ejemplo en P2P las reglas son mucho más sofisticadas. Hay distintos tipos:

**¿Que los definen?**: Lo que define a un protocolo es:
  - El tipo de servicio:
    - Orientado o no orientado a conexión.
    - Realimentado o no.
  - El tipo de mensaje:
    - Request: petición
    - Responde: respuesta
  - La propia sintaxis: Definición y estructura de sus campos en el mensaje.
  - La semantica: Significado de los propios campos
  - Las reglas: Cuendo los procesos envian mensajes -> responden a mensajes. Para que la comunicación sea efectiva deben de existir una serie de reglas.


## 1.3 Tipos de protocolos
Existen pues diferentes tipos de protocolos:

  - **Protocolos de dominio publico**: este tipo de protocolos buscan la colaboración/feedback de la gente para encontrarle fallos o mejorarlos}. Normalmente buscan ser estandarizados. Por ejemplo HTTP, SMTP, etc. VS propietarios, al contrario que los de dominio público, son creados por una empresa e implantados en un producto. Estas empresas intentan esconderlo lo máximo posible para que nadie sepa cómo funciona el protocolo.

  - **Protocolos in-band**: Mandan en el mismo paquete la información completa, tanto de datos como de control (HTTP), VS out-of-band, usan canales distintos para cada cosa (FTP). Por ejemplo, FTP envía la información de control (usuario, contraseña, comandos get/post, etc) por una conexión y los datos, por otra conexión paralela separada.

  - **Protocolos stateless**: No guardan información del cliente, a no ser que tengan una intranet o un fichero como las cookies, VS state-full, son servicios que guardan el estado del cliente, por ejemplo, el carrito de la compra, si eres premium o no.

  - **Protocolos persistentes**: Siempre están conectados, VS no-persistentes, crean una conexión cada vez que se manda un trozo de información.

La tendencia para hace rprotocolos flexibles con:
  - Una cabecera fija.
  - Una serie de "trozos" opcionales y obligatorios.

La tendencia hoy en día, para no trabajar con cabeceras muy grandes, es hacer cabeceras flexibles, es decir, poner una cabecera fija muy pequeñita y luego añadir trozos según lo que necesitemos. Al principio de cada trozo se indica su longitud y la información que contiene dicho trozo.

Los trozos pueden incluir una cabecera específica más una serie de datos en forma de parámetros:
  - Fijos: deben seguir un determinado orden.
  - De longitud variable u opcionales.
  - Siguiendo el formato TLV:

Todo esto implica una serie de **características** que son:

 - **Pérdidas de datos (errores)**: algunas aplicaciones (como por ejemplo de audio o de video) pueden tolerar alguna pérdida de datos, ya que el usuario no se da cuenta si pierde un frame del video o un microsegundo de una canción. Sin embargo, otras (como por ejemplo TELNET) requieren una transferencia 100% fiable sin pérdida alguna.

  - **Requisitos temporales**: Algunas apps denominadas inelásticas (ej., telefonía Internet, juegos interactivos) requieren retardo acotado (delay) para ser efectivas.

  - **Ancho de banda**: Algunas apps requieren envío de datos a un ritmo determinado.◦ Seguridad: Encriptación, autenticación, no repudio (es decir, no poder negar las acciones que has hecho)...

  - **Seguridad**: Encriptación, autenticación, no repudio (es decir, no poder negar las acciones que has hecho)...

## 1.4 Protocolos de transporte
Dependiendo si están orientados a conexión o no:
  - **Servicio TCP**: lo usan los servicios que quieren fiabilidad, que no se pierdan datos. Está orientado a conexión, tiene control de flujo y de congestión implementados.

  - **Servicio UDP**: lo usan los servicios que quieren rapidez. UDP no tiene nada de lo que TCP tiene implementado, aunque nosotros podemos implementarlo.


TCP y UDP, que están en la capa de transporte, al ser usuarios del protocolo IP, que está en la capa de red, no garantizan:
  - **Retardo acotado**: no garantizan que la respuesta se obtenga en un intervalo de tiempo máximo.
  - **Fluctuaciones acotadas**: no garantiza que haya una velocidad fija en la red.
  - **Mínimo throughput**: no garantiza el envío de paquetes a un ritmo mínimo constante.
  - **Seguridad**: no garantiza que los envíos lleguen tal cual se han enviado.


## 2 Servicio de Nombres de Dominio (DNS)

La comunicación en Internet precisa de direcciones IP asociadas a las interfaces finales involucradas en esta comunicación. Estas direcciones IP son las direcciones que identifican a cada máquina y las que se usan para direccionarlas. Como para los usuarios usar esto no es cómodo, se utilizan los nombres de dominios, que están asociados a dichas IP's. Debido a esto, se necesita un sistema para convertir los nombres de dominio a direcciones IP (servicio de resolución de nombres) y así surge el sistema de nombres de dominio o Domain Name System, DNS.

    Goliat.ugr.es ← → 150.214.20.3








-
