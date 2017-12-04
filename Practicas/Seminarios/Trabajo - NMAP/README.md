# nmap

## Introduccion
La seguridad hoy día es un tema fundamental. Los equipos y sistemas son
atacados constantamente con diferentes tecnicas y uno de los principales 
focos de vulnerabilidad son los puertos, bueno, al menos es una información 
muy util para realizar un ataque. Por ello decidimos hacer el trabajo sobre 
Nmap.

## ¿Qué es nmap?
Nmap es una herramienta multiplataforma para el escaneo de puertos, como 
todas las hermientas de seguridad el uso de esta misma tiene dos visiones:

  - Conocer la seguridad de nuestro sistema o red para protegerla y no dejar
    brechas de seguridad y desde otro punto de vista,
  - La identificación de puertos abiertos como una de las primeras etapas para
    realizar un ataque.

## ¿Qué permite hacer?
Nos ayuda a:
  - Descubrir e identificar equipos en la red.
  - Identificar puertos abiertos.
  - Conocer los servivios que ofrecen los equipos.
  - Sistema operativo de los equipos y versión del mismo.
  - Conocer si se está usando cortafuegos.
  - Conocer algunas caracteristicas del hardware de la red

## ¿Cómo funciona?
El funcionamiento de nmap se basa en el envio de paquetes IP raw, crudos,
que son paquetes que no han sufrido modificaciones y son por tanto origniales
sea cual sea el protocolo y ver como cambian estos paquetes según la respuesta.

Hay varios tipos de sondeos, pero explicaremos uno:

  - Sondeo: TCP SYN (-sS)
    Es necesario saber que para establecer una conexión normal se debe primero
    considerar lo siguiente. En TCP se sigue una negociación de tres
    pasos. Esta negociación es iniciada con un paquete SYN en la máquina de
    origen, al cual la máquina de destino responde con un paquete SYN/ACK,
    el que es finalmente respondido por la máquina que inicia la conexión por
    un paquete ACK. Una vez que se han cumplido estos pasos, está hecha la
    conexión TCP.

    La herramienta envia paquetes SYN a los diferentes rangos de conexión mira la
    forma en la que regresan los paquetes. El paquete puede llegar como SYN/ACK, RST
    o ICMP (filtrado no alcanzable) 
    
  - Sondeo TCP connect() con -sT
  - Sondeo UDP -sU
  - otros sondeos TCP Null, FIN, Xmas, TCP ACK etc con -sN, -sF y -sX -sW
  

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

## Conclusión
Esta herramienta es sumamente poderosa, solo hemos tocado algunos aspectos. Saber
que está expuesto en nuestra red es el primer paso para poder protegerla, si se
encuentran puertos extraños que deberían estar abiertos, debemos cerralos, estos
pueden ser entradas para los atacantes e incluso virus. Algunos puertos normales
como el SSH  si no se usa, lo mejor es cerrarlo o redireccionarlo a otro puerto. 
Mientras más controlado esté nuestro sistema menos oportunidades daremos para 
que este sea roto por un acante. 
