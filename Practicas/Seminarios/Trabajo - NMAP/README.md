# nmap

## Introduccion
La seguridad hoy día es un tema fundamental. Los equipos y sistemas son
atacados constantamente con diferentes tecnicas una de ellas es ir a por
los puertos, bueno, al menos es una información muy util para realizar un
ataque.

## ¿Qué es nmap?
Nmap es una herramienta para el escaneo de puertos, como todas las hermientas de
seguridad el uso de esta misma tiene dos visiones:
  - Conocer la seguridad de nuestro sistema o red para protegerla y no dejar
    brechas de seguridad y desde otro punto de vista,
  - La identificación de puertos abiertos como una de las primeras etapas para
    realizar un ataque.

## ¿Cómo funciona?
El funcionamiento de nmap se basa en el envio de paquetes ip raw, crudos,
que son paquetes que no han sufrido modificaciones y son por tanto origniales
sea cual sea el protocolo y ver como cambian estos paquetes según la respuesta.

Hay varios tipos de sondeos, por ejemplo:

  - Sondo: TCP SYN
    Es necesario saber que para establecer una conexión normal se debe primero
    considerar lo siguiente. En TCP es necesario seguir una negociación de tres
    pasos. Esta negociación es iniciada con un paquete SYN en la máquina de
    origen, al cual la máquina de destino responde con un paquete SYN/ACK,
    el que es finalmente respondido por la máquina que inicia la conexión por
    un paquete ACK. Una vez que se han cumplido estos pasos, está hecha la
    conexión TCP.

    La herramienta envia paquetes SYN a los diferentes rangos de conexión mira la
    forma en la que regresan los paquetes. EL paquete puede llegar como SYN/ACK, RST
    o ICMP Port Unreachable.

Es posible otros escaneos pero para ello es necesario ajustarlo en la entrada
de parametros y opciones de la herrmienta.

## ¿Qué permite hacer?
Nos ayuda a:
  - Descubrir e identificar equipos en la red.
  - Identificar puertos abiertos.
  - Conocer los servivios que ofrecen los equipos.
  - Sistema operativo de los equipos y versión del mismo.
  - Conocer si se está usando cortafuegos.
  - Conocer algunas caracteristicas del hardware de la red

## ¿Cómo se usa?
Nmap lo podemos usar sin o con apariencia grafica, este ultimo se le conoce como
zenmap aunque hay muchas versiones distintas.

Por terminal su uso se basa en un comando con una entrada determinada:
de sondeo o analisis, diferentes opciones de configuración y especificaciones
La descripción de todos los comandos se pueden encontrar en el man de la
aplicación.

Como salida nmap nos aportará una lista de los objetivos analizados cuya parte
más importante es la tabla de puertos interesantes. Dicha tabla contine una lista
con los puertos y asociados a ellos, su estado, el nombre del servicio..

Para nmap el estado de un puerto puede ser open, filtered, colsed y unfiltered.
