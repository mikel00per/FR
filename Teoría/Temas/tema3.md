# Tema 3 | Capa de Transporte en Internet

## 1. Introducción

Los principales servicios a los que vamos a acceder en capa de transporte son la comunicación extremo/extremo controlando dicha comunicación y además, la multiplexación/demultiplexación de aplicaciones utilizando puertos.

Hasta ahora siempre hemos hablado de dispositivos (Servidor y Cliente), dentro de cada dispositivo tenemos miles de procesos y muchos de ellos se quieren comunicar con internet. Así, cuando llega un nuevo paquete por la tarjeta de red, debemos indicar al sistema operativo a qué aplicación va destinado dicho paquete y así el sistema operativo pueda mantener varias comunicaciones en paralelo.

Ésto se hace mediante el uso de los distintos tipos de puertos que hay.

## 2. Protocolo de datagrama de usuario (UDP)
UDP, podemos decir que prácticamente lo único que hace es utilizar los puertos, ya que es un servicio no orientado a conexión, no fiable, etc. es decir, no implementa casi funcionalidad alguna. Por tanto, UDP es un protocolo best-effort, ya que intentará que el paquete llegue a su destino, pero si no llega no se preocupa en realizar el reenvío del paquete.

  ![UDP](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img1-tema3.png)

Como vemos tenemos 8 bytes distribuidos en 4 campos de dos bytes cada uno donde tenemos en primer el puerto origen, el puerto destino, la longitud UDP del datagrama.

En UDP, al no haber conexión, nos solemos referir al paquete de datos como Datagrama, que es el nombre usado en internet para paquetes que van individualmente a su destino que nos da el tamaño de la cabecera y el payload que guarda toda la información de los protocolos de la capa de aplicación y por último, tenemos la comprobación que nos permite hacer un pequeño control de errores sobre el paquete.

## 3. Protocolo de contro de transmisión

### 3.1 Introducción a TCP

En TCP a cada paquete del flujo de datos se le llama segmento pues hace referencia a un segmento dentro de una linea recta, una parte del todo.

TCP es un servicio orientado a conexión por lo que hace una operación de conexión y otra de desconexión antes de empezar la transmisión de los datos, ésto se conoce como handshaking. Permite la entrega ordenada y el full-duplex, ésto significa que la conexión TCP permite el envío de datos en ambos sentidos de la comunicación.

Mecanismo de detección y recuperación de errores (ARQ):
  - Confirmaciones positivas, que son paquetes de control que permiten controlar cuándo ha llegado un segmento a la otra dirección, los paquetes que se usan para confirmar se denominan ACK.
  - No se usan confirmaciones negativas para indicar que un paquete ha llegado mal o no ha llegado, sino que el emisor cada vez que manda un paquete inicia un temporizador, si al finalizar dicho temporizador no ha recibido confirmación vuelve a enviar el paquete. *De aquí viene el hecho de decir que TCP es un servicio fiable.*

La incorporación de confirmaciones (piggybacking) minimiza el número de paquetes enviados de señalización de control, con esta técnica, en vez de enviar ACK en un paquete individual, éste es incluido dentro del próximo paquete a enviar.

  ![TCP](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img2-tema3.png)

El principio es el mismo que en UDP: puerto origen y puerto destino, tras esto tenemos dos números de secuencia:
  - Número de secuencia, para llevar la cuenta de los paquetes enviados.
  - Número de “acuse” de recibo, para llevar la cuenta de los paquetes que hemos confirmado.

Ambos llevan la cuenta de por donde va la información en ambas direcciones, en ambos sentidos de la comunicación.

Después tenemos un campo para almacenar la longitud de la cabecera TCP, una zona reservada que se usa para temas de investigación. A continuación un campo de flags que son bits que marcan segmentos especiales con algún tipo de infomación especial y es uno de los primeros campos que se mira para saber el valor del resto.

Tras este campo tenemos un parámetro “ventana”, que se utiliza en el control de flujo para poder enviar varios segmentos a la vez, seguidamente la comprobación y un puntero que permite diferenciar en el payload datos que deben tener máxima prioridad de datos que no.

Por último las opciones, que es variable, pueden o no tener opciones, entre las opciones nos podemos encontrar que la longitud de la cabecera sea variable.

Cada segmento TCP se encapsula en un datagrama IP.

### 3.2 Control de la conexión (TCP)
Implica un inicio de la conexión y una desconexión, entre medias de ambos se realiza el envío de datos. En la handshake vemos el esquema de conexión inicial en TCP. Dicho diagrama se denomina three way handshake porque casi siempre se utilizan tres segmentos: uno del origen al destino, otro del destino al origen y otro final del origen al destino. En resumen, se usan tres paquetes para iniciar la conexión.

  ![ack](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img3-tema3.png)

En un primer paquete se inicializa el número de secuencia (con un número pseudo-aleatorio que sea difícil de predecir para no tener problemas con distintos tipos de conexiones, por ejemplo al iniciar varias conexiones en paralelo que es lo que hacemos al iniciar un navegador web) que irá en la dirección destino-origen y se inicializa el flag SYN (sincronización) a uno. Tras esto, el sistema operativo asigna un puerto a la conexión y se envía dicho paquete sin payload, ya que no es más que un paquete de control.

Cuando dicho paquete llega al destino, con un determinado puerto asignado al receptor (servidor) y si consiguen conectarse, el destino enviará un paquete con el flag ACK será establecido a uno. Cuando el flag ACK se establece a uno significa que hay un número válido en el acuse de recibo: el número de secuencia más uno. Esto le deja claro al emisor original que dicha confirmación se refiere a su paquete, así realizamos una doble comprobación.

Al tener una conexión full-duplex, el destino también inicializa su dirección de la conexión haciendo lo mismo que el emisor: inicializa su número de secuencia con un valor pseudo-aleatorio independiente del número de secuencia del emisor y establece el flag de sincronización SYN a uno.

Cuando éste último paquete llega al emisor original, establece el flag ACK a uno y da el acuse de recibo de lo que ha recibido.

*Note: TCP incrementa el número de secuencia de cada segmento según los bytes que tenía el segmento anterior, con una sola excepción: los flags SYN y FIN, cuando están puestos, incrementan en 1 el número de secuencia. ACK no incrementa el número de secuencia. Son campos de 32 bits.*

### 3.3 Cierre de la conexión.
Es muy parecida a la conexión, con la diferencia de que tenemos un flag denominado FIN. Ocurre lo mismo que en la conexión, con la diferencia de que aquí ya ha habido intercambio de datos entre finales anteriormente, es decir, entre la conexión y la desconexión está todo el servicio proporcionado.

Para hacer la desconexión, el que quiere desconectar manda un segmento en el que establece el flag FIN a uno y va con un determinado número de secuencia que será el número de secuencia original más el número de bytes enviados.

Cuando dicho segmento llega al destino, éste lo confirma y si quiere cerrar también la conexión, establece también su flag FIN a uno e incrementa su número de acuse de recibo.

*Un detalle importante es que el que inicia la desconexión, tras mandar el último paquete de desconexión, inicializa un temporizador antes de cerrar definitivamente.*

### 3.4 Autómata de estados finitos TCP
Cada nodo representa un estado en el que puede estar cualquiera de los dos fines de TCP (tanto cliente como servidor). Sobre cada flecha que une dos nodos vemos una / que separa las acciones que hace cada parte para cambiar de estado, si vemos un símbolo “-” significa que esa parte no ha hecho nada para cambiar de estado sino que cambia de estado por una acción realizada por la otra parte.

  ![automata_tcp](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img4-tema3.png)

  1. En el lado del cliente, el que inicia la conexión, se envia en primer lugar un syn (estado SYN_SENT), tras esto, esperará un segmento con syn + ack y finalmente, mandará un ack, pasando al estado ESTABLISHED tras el cual podemos empezar a mandar datos. Este proceso sería una apertura activa.

  2. En el lado del servidor se realiza una apertura pasiva. Inicialmente el servidor se encuentra en estado LISTEN, en el cual se encontrará escuchando peticiones en un determinado puerto. En esa escucha, recibe un syn por parte de un cliente, a lo que le responde con un syn + ack y pasa al estado SYN_RCVD. Cuando reciba un ack sin decir él nada, pasará al estado ESTABLISHED.

  3. Una vez en ESTABLISHED, podemos cerrar la conexión mediante el cierre activo. Para ello, debemos enviar un fin y, sin nosotros recibir nada, pasaremos al estado FIN_WAIT_1. Cuando nos llegue un fin + ack, nosotros mandaremos un ack y pasaremos al estado TIME_WAIT donde esperaremos el intervalo de tiempo que debía esperar el que iniciaba la desconexión antes de cerrarla del todo.

  4. En el cierre pasivo, recibiremos un fin y nosotros responderemos con un ack pasando al estado CLOSE_WAIT. Cuando estemos preparados para cerrar, responderemos con un fin pasando al estado LAST_ACK y cuando recibamos un ack volveremos al estado inicial, CLOSED.


### 3.5 Control de errores
Tanto el control de flujo como el control de congestión reducen la velocidad de transmisión cuando sea necesario. El control de congestión lo hace para no congestionar la red y el control de flujo, para no saturar al receptor. Además, también comprueba que todos los paquetes han sido recibidos y que además, se hayan recibido en orden.

Sería natural pensar que TCP, al enviar un segmento, espera a recibir la confirmación (ack) del receptor para mandar el siguiente segmento (esta estrategia se denomina stop&wait) pero tiene un problema: presenta una gran pérdida de velocidad de transmisión, tiempo muerto (timeout).

Escenarios de la transmisión:

  ![escenarios](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img5-tema3.png)

  1. Caso izquierda: En el caso de la izquierda, Host A está enviando un segmento de 8 bytes de longitud. El número de secuencia que se ve es el segmento por el que va en ese momento, el número de secuencia se puede haber inicializado a 91, por eso espera el 92. Cuando Host B recibe el paquete, realiza el checksum, para ver que no hay problemas y responde con un ack indicando el siguiente segmento que espera (en este caso, 92 + 8, es decir, Seq + NumBytes = 100). Si se pierde ese ack, se acabará el timeout y el emisor volverá a mandar el segmento. Entonces, Host B verá que es lo mismo que ha recibido antes y volverá a mandar el ack. En este escenario estámos mandando una ventana de un único segmento, por lo que cuando llegue el ack se enviará el siguiente incrementándose el número de secuencia.

  2. Caso derecha: En el segundo caso, tenemos una ventana con dos segmentos, por lo tanto se pueden enviar dos segmentos esperando solo una confirmación. Se envía el primer segmento con número de secuencia 92, 8 bytes de datos y se inicializa su timeout y acto seguido, se envía el segundo segmento, inicializando también su timeout. Cuando llega el primero, se confirma indicando que lo siguiente que espera es 100, es decir el segundo segmento que hemos mandado y cuando llega el segundo, se manda el ack indicando que lo siguiente que espera es 120. El problema es que el primer ack llega tarde y expira el primer timeout. Una vez expirado, se vuelve a reenviar el primer segmento, pero justo después llega el ack del segundo segmento dentro del timeout. Por lo tanto, el Host A sabe que han llegado ambos segmentos y sabe que el siguiente segmento que espera es el 120.


**¿Cómo se estiman los timeouts?**
No podemos poner un tiempo ni demasiado grande ni demasiado pequeño, ya que si se pone demasiado grande, aunque parezca que le puede dar tiempo a mandar el segmento y recibir el ack, podemos mandar los paquetes de forma muy lenta. Y si se pone demasiado pequeño, no le dará tiempo a ningún segmento a ser confirmado, porque no le dará tiempo al ack a llegar, por lo que podríamos estar siempre mandando el mismo segmento.

Es algo que hay que estimar en función de la velocidad de red, por lo tanto debe estar ajustado a la velocidad de esta, y debe ser ajustado en el momento, es decir, de forma dinámica. Hay que ver como va la red y fijar un valor de acuerdo al estado de esta.


### 3.6 Control de flujo
El objetivo del control de flujo era no saturar al receptor (evitar unbuffer overfow), para implementar esto el receptor avisa al emisor de cuando está dispuesto a recibir datos. La información que puede recibir el receptor se mide en créditos: si el receptor puede recibir 4KB, el crédito será de 4KB y si no puede recibir nada, el crédito será de 0KB y se detendría el envío de datos TCP.

  ![venta_flujo](https://github.com/mikel00per/FR/blob/master/Teor%C3%ADa/Temas/Imagenes/img6-tema3.png)

En la imagen tenermos una comunicación entre un emisor y un receptor, en el emisor la capa de aplicación envía 2KB a TCP y al ser su Maximum Segment Size de 2KB lo envía directamente al receptor en un sólo segmento. El segmento es recibido por el receptor, cuyo buffer de recepción es de 4KB y en ese momento se encuentra vacío, y tras almacenarlo en dicho buffer, envía un ACK de esos 2048 bytes indicando que le quedan libres otros 2KB en su ventana. El emisor, al no tener más información que enviar, no hace nada más que hasta que la aplicación vuelve a enviar información, 3KB, a TCP. Dicha infomación se divide en segmentos y TCP se dacuenta de que no puede enviarlo todo, pues sólo le han dado crédito para enviar 2KB, por tanto, envía esos 2KB y se queda esperando a poder enviar los 1024 bytes restantes. El receptor al recibir dicho segmento, lo almacena en su buffer y le envía la confirmación correspondiente indicando un crédito de 0 bytes, es decir, que no hay espacio en el buffer. En algún momento la aplicación del receptor preocesará 2KB del buffer y volverá a dejar espacio libre. En ese instante, el receptor envía un ACK duplicado al amisor con el mismo número de secuencia pero dándole 2KB de crédito para enviar, como el emisor tenía pendiente enviar 1KB, lo envía y finaliza la comunicación entre ambos.

**Inconvaniente**: si el emisor envía datos a TCP muy rápido y el receptor los procesa muy lentamente, al final el emisor enviará muchos paquetes con segmentos pequeños ya que al recibir crédito del receptor, por mínimo que sea, enviará inmeditamente segmentos con ese tamaño. Esto se conoce como ventana tonta.

**Solución. Ventana optimista**: el receptor asume que el emisor va procesando datos conforme éste se los va enviando y por tanto, no hace falta considerar los bytes en tránsito en la ventana útil, porque conforme los ha ido enviando el emisor, los ha ido procesando el emisor. Así, no se reduce el tamaño de la ventana y se usan todos los créditos que ha concedido el emisor. Si se llega a un buffer overflow, el emisor no enviará confirmación y el receptor tendrá que volver a enviar el segmento de acuerdo a su temporizador.

### 3.7 Control de congestión.
El objetivo del control de congestión es el mismo del control de flujo pero cambiando al agente, es decir, a quien no se quiere saturar. En el control de flujo dejábamos que el receptor nos dijese cuanta información podíamos enviarle, sin embargo en el control de congestión no tiene a nadie que le diga cuando está la red congestionada, sino que tiene que darse cuenta el mismo. Para ello el emisor debe medir el tiempo de alguna forma y la forma más sencilla es contabilizar la pérdida o el retraso de ACKs: si el ACK no ha llegado dentro del temporizador, significa que ha pasado algo. Puede ser que el receptor se haya saturado, que se haya perdido el paquete sin haber congestión en la red...


## 4. Extensiones TCP








-
