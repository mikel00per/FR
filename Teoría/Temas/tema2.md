# Tema 2 | Servicios y Protocolos de Aplicación en Internet

## Introducción a las aplicaciones de red

  - **Protocolos TCP/IP**: El origen de esta familia de protocolos fue
  la red ARPANET (enella se desarrollaron los conceptos fundamentales de
  diseño y gestión de redes).
  Los niveles más bajos (enlace y físico) no están implementados ya que
  se diseñó para no depender de una red física concreta:
  Los protocolos ARP (Adress Resolution Protocol) y RARP (Reverse Adress
  Resolution Protocol) se encargan de enlazar los sistemas de
  direccionamiento IP y el de la red física utilizada.

    - **Capa de Red**: La base de la familia de protocolos es el nivel de Red (IP, Internet Protocol). Es un protocolo de conmutación de paquetes muy sencillo, de tipo datagrama, de forma que se pueda implementar en cualquier tipo de máquina. Existen dos versiones
    **IPv4**, **IPv6**.
      - **ICMP** (Internet Control Message Protocol): comunicación de mensajes entre nodos de la red
      - **IGMP** (Internet Group Mangement Protocol): envío de mensajes a grupos de usuarios.

    - **Capa transporte**: Implementa protocolos extremo a extremo(entre nodo origen y destino de la información). Se definen dos protocolos:
      - **TCP** (Transmission Control Protocol):Es un protocolo orientado a la conexión con control de errores, se encarga también del control de flujo, fragmentado y reensamblado de flujos (garantiza el secuenciamiento)

      - **UDP** (User Datagram Protocol): Es un protocolo sin conexión (datagrama). No realiza control de errores, no garantiza el secuenciamiento de la información, es muy rápido Útil para peticiones aisladas, o transmisión de audio o vídeo

    - **Capa de aplicación**:
      - **Protocolos basados en ICMP**:
        - PING: solicitud de eco
      - **Protocolos basados en TCP**:
        - TELNET: terminal remoto
        - FTP(File Transfer Protocol): transmisión de ficheros
        - SMTP(Simple Mail Transfer Protocol): correo electrónico
        - HTTP(HyperText Transfer Protocol: páginas web
        - RPC (Remote Procedure Call): ejecución de procesos remotos
      - **Protocolos basados en UDP**:
        - SNMP(Simple Network Management Protocol): gestión de red
        - BOOTP: arranque remoto
        - DNS(Domain Name System)
        - RPC(Remote Procedure Call): ejecución de procesos remotos
        - NFS/RPC (Network File System) (gestión de ficheros en red

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
    - ¿Para qué existe UDP?

TCP y UDP (capa de transporte) al ser usuarios del protocolo IP (capa de red) no garantizan:
  - Retardo acotado
  - Fluctuaciones acotadas
  - Mínimo throughput
  - Seguridad

## Arquitectura cliente servidor
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

Además, el vliente comienza la comunicación y el proceso servidor espera a ser contactado IP permanente y publica. Existe un proceso que envia/recive mensajes a/desde un socket. Para recibir mensajes el proceso ha de tener un identificador (IP + puerto).

  - Definimos **SOCKET** como un descriptor de una transmisión a través del cual la aplicación puede enviar y/o recibir información hacia y/o desde otro proceso de aplicación. Es una _puerta_ de acceso entre la aplicación y los servicios de transporte. En la práctica un socket es un puntero a una estructura

  Para administrar el retardo de las comunicaciones entre cliente/servidor se usan colas, teoría de colas.

## ¿Que es y define un protocolo?
  - El tipo de servicio
    - Orientado o no orientado a conexión
    - Realimentado o no
  - El tipo de mensaje
    - ej., request, response,
  - La sintaxis:
      Definición y estructura de “campos” en el mensaje
      En aplicación generalmente son orientados a texto (HTTP)
      Aunque hay excepciones (DNS)
      Tendencia : usar formato Type-Length-Value
  - La semántica:
      Significado de los “campos”
  - Las reglas:
      Cuándo los procesos envian mensajes/responden a mensajes

  - **Tipos de protocolos**:
    - **Protocolos de dominio público** (Definidos en RFCs (ej., HTTP, SMTP)) VS **propietarios**  (ej., Skype, IGRP)
    - **Protocolos in-band** VS **out-of-band**
      - **In-band Protocols**: protocolos de red con la que se regula el control de datos.
      - **Out-of-band protocols**: Llamado “Urgent Data” en TCP) Útil para la separación de dos tipos diferentes de datos. No significa que será entregado más rápido o con mayor
      prioridad que los datos en el flujo de datos dentro de la banda.

    - **Protocolos stateless VS state-full**:
      - **stateless**: es un protocolo de comunicaciones que trata cada petición como una transacción independiente que no tiene relación con cualquier solicitud anterior, de modo que la comunicación se compone de pares independientes de solicitud y respuesta.
      - **stateful**: : un protocolo que requiere el mantenimiento del estado interno en el servidor se conoce como un protocolo con estado.

    - **Protocolos persistentes VS no-persistentes**:En una conexión persistente solo se hará una conexión TCP, mientras que en una conexión no persistente se utilizarán múltiples conexiones TCP, una por cada objeto solicitado.
