# 🚀 Tarea 09 — Gestor de Descargas

> **📌 Nota aclaratoria:**
> Tuve un enfoque distinto en el gestor de archivos, pero luego hice un cambio para mejorar mi código por recomendación de un compañero (Isaac). Aclaro que el trabajo **no está copiado** y soy totalmente consciente de qué hace cada parte de mi código.

---

## 🛠️ 1. Clase `Descarga`

Lo primero que tendremos que hacer es crear la clase y asignarle sus respectivos atributos:
* `descarga`
* `aleatorio`
* `TiempoFinal`

Luego crearemos un constructor e iniciaremos los atributos:
* `descargar`: será igual al `String` con el nombre de la descarga que reciba.
* `aleatorio`: será un nuevo objeto de tipo `Random`.
* `TiempoFinal`: lo iniciaremos a `0`.

![foto](psp_9/Captura%20de%20pantalla%202026-10-06%20123225.png)

### 🔄 Método `run()` (Seguimiento del proceso)

- Vamos a crear una variable de tiempo que se inicia en `0`, junto a otra de porcentaje que también se inicia en `0`.
- Ahora haremos un bucle el cual se ejecutará **10 veces** y se encargará de hacer lo siguiente:
  - En una variable `num` va a almacenar aleatoriamente uno de estos dos dígitos (`0` o `1`) y, dependiendo de cuál toque, le asignará un tiempo en ms al proceso (`0 = 100 ms` o `1 = 500 ms`).
  - Vamos a ir guardando en la variable `TiempoFinal` la suma de cada tiempo que genere el bucle.
  - Luego haremos un bloque `try` que probará hacer que el proceso duerma usando `Thread.sleep(tiempo)` y, en caso de error, ejecutará el `catch`.
  - Por último, para ir calculando el porcentaje, la variable `i` del bucle se irá multiplicando por `100` y dividiendo por el máximo al cual puede llegar, que en este caso es `10` *(también habría sido más fácil poner simplemente `i * 10`)*.

![foto](psp_9/Captura%20de%20pantalla%202026-10-06%20124047.png)

- Y ya para acabar la clase, vamos a crear un *getter* para la variable `TiempoFinal`:

![foto](psp_9/Captura%20de%20pantalla%202026-10-06%20130006.png)

---

## ⚙️ 2. Clase `GestorDescargas`

- Lo primero será crear un array de `String` el cual guardará el nombre de las descargas:

![Captura de pantalla 2026-10-06 130201.png](psp_9/Captura%20de%20pantalla%202026-10-06%20130201.png)

- Ahora tendremos que hacer un array de objetos de nuestra clase `Descarga`, el cual llamaremos `l_descargas` (lista descargas), cuya longitud será el tamaño de la lista de archivos.
- Luego haremos un bucle que irá almacenando los nombres de las descargas en el array `l_descargas`.
- Iniciaremos `System.currentTimeMillis()` para registrar el tiempo exacto en el que empieza la ejecución (`tInicio`).
- Con todo lo anterior listo, lanzamos los procesos creando un bucle que sacará los objetos `Descarga` del array e iniciará cada hilo con el método `.start()`.

![Captura de pantalla 2026-10-06 130212.png](psp_9/Captura%20de%20pantalla%202026-10-06%20130212.png)

- Haremos otro bucle equivalente para esperar a que terminen los hilos utilizando `.join()` dentro de un bloque `try-catch`.
- Registraremos en una variable `tFin` el tiempo de finalización.
- Restando `tFin - tInicio` obtendremos el **tiempo real** transcurrido.
- **Tiempo secuencial:** Es el tiempo que tardarían los procesos si se ejecutaran uno detrás de otro. Para calcularlo, llamaremos a todos los métodos `get_TiempoFinal()` y los sumaremos.

![Captura de pantalla 2026-10-06 130230.png](psp_9/Captura%20de%20pantalla%202026-10-06%20130230.png)

---

## ❓ 3. Preguntas y Resultados

### 📊 Tabla de Ejecuciones

| Ejecución | Descarga más lenta | Tiempo real (ms) | Suma (ms) |
| :---: | :---: | :---: | :---: |
| **1** | 4200 ms | 4205 ms | 12000 ms |
| **2** | 3000 ms | 3008 ms | 8800 ms |
| **3** | 3400 ms | 3408 ms | 12000 ms |

### 💡 Cuestiones

1. **¿Por qué el tiempo real es mucho menor que la suma?**
   > Porque el tiempo real corresponde a la duración del proceso **más lento** cuando todos se lanzan de forma concurrente (en paralelo). En cambio, la suma representa el tiempo si los procesos se ejecutaran en secuencia uno tras otro.

2. **¿Qué pasa si hacéis `start()` y `join()` dentro del mismo bucle? Probadlo y poned el tiempo real que os sale.**
   > Al llamar a `join()` inmediatamente después de `start()` dentro del mismo bucle, el hilo principal espera a que termine el proceso actual antes de iniciar el siguiente. Por lo tanto, los hilos pierden la concurrencia y pasan a ejecutarse uno por uno.

![Captura de pantalla 2026-10-06 121220.png](psp_9/Captura%20de%20pantalla%202026-10-06%20121220.png)

> **🔍 Comprobación de usuario:**
> *(El usuario de mi ordenador es `seta`, lo cual se puede verificar en la ruta del terminal del sistema).*

```plaintext
C:\Users\seta\.jdks\openjdk-27\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.3\lib\idea_rt.jar=49336" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\seta\IdeaProjects\Gestor de Descargas\out\production\Gestor de Descargas" GestorDescargas
[Descarga-meditacion.mp4]10%
[Descarga-meditacion.mp4]20%
[Descarga-meditacion.mp4]30%
[Descarga-meditacion.mp4]40%
[Descarga-meditacion.mp4]50%
[Descarga-meditacion.mp4]60%
[Descarga-meditacion.mp4]70%
[Descarga-meditacion.mp4]80%
[Descarga-meditacion.mp4]90%
[Descarga-meditacion.mp4]100%
[meditacion.mp4]completada en 3400 ms
[Descarga-documental.mkv]10%
[Descarga-documental.mkv]20%
[Descarga-documental.mkv]30%
[Descarga-documental.mkv]40%
[Descarga-documental.mkv]50%
[Descarga-documental.mkv]60%
[Descarga-documental.mkv]70%
[Descarga-documental.mkv]80%
[Descarga-documental.mkv]90%
[Descarga-documental.mkv]100%
[documental.mkv]completada en 2600 ms
[Descarga-musica.mp3]10%
[Descarga-musica.mp3]20%
[Descarga-musica.mp3]30%
[Descarga-musica.mp3]40%
[Descarga-musica.mp3]50%
[Descarga-musica.mp3]60%
[Descarga-musica.mp3]70%
[Descarga-musica.mp3]80%
[Descarga-musica.mp3]90%
[Descarga-musica.mp3]100%
[musica.mp3]completada en 3000 ms
[Descarga-tutorial.pdf]10%
[Descarga-tutorial.pdf]20%
[Descarga-tutorial.pdf]30%
[Descarga-tutorial.pdf]40%
[Descarga-tutorial.pdf]50%
[Descarga-tutorial.pdf]60%
[Descarga-tutorial.pdf]70%
[Descarga-tutorial.pdf]80%
[Descarga-tutorial.pdf]90%
[Descarga-tutorial.pdf]100%
[tutorial.pdf]completada en 3800 ms
Todas las descargas han terminado.
Tiempo real: 12833 ms
Si se hubieran descargado una detrás de otra: 12800

Process finished with exit code 0
```
## 🖥️ Parte 2 — Entrada Dinámica y Monitorización

- Para la parte dos, tuve que cambiar el gestor para agregarle un método el cual detecte nuestro teclado y haga procesos de descarga con los nombres que le pasemos.
- Básicamente hago un `ArrayList` que se llama `archivos` y en un bucle voy a ir preguntando los nombres, que luego se almacenarán con un `.add()` en el array.
- Luego, como anteriormente, ese array lo leerá un bucle y se irá almacenando en una lista del tipo `Descargas` que ya teníamos anteriormente, `L_descargas`.

![Captura de pantalla 2026-10-06 155734.png](psp_9/Captura%20de%20pantalla%202026-10-06%20155734.png)

- Por último, haremos un `if` el cual comprueba si nuestra lista de archivos está vacía (`archivos.size() == 0`) y, en caso de serlo, agrega 4 archivos por defecto (*default*).

![img.png](psp_9/img.png)

---

### 📊 Clase `Monitor`

- Para la clase monitor, empezaremos creando una lista de tipo objetos `Descarga` que se llama `L_descargas` y luego haremos el constructor, el cual recibirá los objetos y los asignará a `L_descargas`.

![Captura de pantalla 2026-10-06 172409.png](psp_9/Captura%20de%20pantalla%202026-10-06%20172409.png)

- Ahora para hacer el monitoreo, voy primero a crear una variable `existe` que empezará siendo cero.
- Luego un `if` que, si `existe` es igual a `0`, haga lo siguiente:
    * Hará un bucle interno que revisará los procesos de la lista y, si es distinto de `null` y están vivos, va a agregar esa misma cantidad de procesos a la variable `existe`.
    * Si `existe` es distinto de `0`, me mostrará cuántas descargas quedan en pie; de lo contrario, mostrará por pantalla el mensaje *"no queda ninguna descarga en curso"* y romperá el bucle.
    * Ahora, en un bloque `try`, haremos que el proceso descanse `500 ms` entre cada *tick* de comprobación.

![Captura de pantalla 2026-10-06 172423.png](psp_9/Captura%20de%20pantalla%202026-10-06%20172423.png)