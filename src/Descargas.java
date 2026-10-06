import java.util.Random;

public class Descargas extends Thread {
    // atributos de la clase
    String descargar;
    Random aleatorio;
    int TiempoFinal;

    // constructor que inicializa el nombre del archivo y las variables
    public Descargas(String descarga){
        this.descargar = descarga;
        this.aleatorio = new Random();
        this.TiempoFinal = 0;

    }

    // ejecucion que hace el hilo de la descarga
    public void run() {
        int tiempo = 0;
        int Porcentaje = 0;


        for(int i = 1; i <= 10; i++){

        // genera un entero aleatorio
        int num = aleatorio.nextInt(2);

        // asignacion de tiempo de espera
        if(num == 0){
             tiempo = 100;

        }else{
              tiempo =500;
        }
        TiempoFinal = TiempoFinal + tiempo;

        // bloque que  pone a dormir el proceso
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Descarga interrumpida: " + descargar);
        }

        //calculo del porcentaje
        Porcentaje = (i * 100)/10;
            System.out.println("["+"Descarga-"+descargar+"]"+Porcentaje+ "%");
        }


        System.out.println("["+descargar+"]"+"completada en "+TiempoFinal+
                " ms");


    }

    // Getter para obtener el tiempo
    public Integer get_TiempoFinal(){
        return TiempoFinal;
    }





}
