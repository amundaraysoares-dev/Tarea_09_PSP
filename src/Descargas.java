import java.util.Random;

public class Descargas extends Thread {
    String descargar;
    Random aleatorio;
    int TiempoFinal;

    public Descargas(String descarga){
        this.descargar = descarga;
        this.aleatorio = new Random();
        this.TiempoFinal = 0;

    }
    @Override
    public void run() {
        int tiempo = 0;

        int Porcentaje = 0;
        for(int i = 1; i <= 10; i++){
        int num = aleatorio.nextInt(2);
        if(num == 0){
             tiempo = 100;

        }else{
              tiempo =500;
        }

        TiempoFinal = TiempoFinal + tiempo;
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Descarga interrumpida: " + descargar);
        }

        Porcentaje = (i * 100)/10;
            System.out.println("["+"Descarga-"+descargar+"]"+Porcentaje+ "%");
        }


        System.out.println("["+descargar+"]"+"completada en "+TiempoFinal+
                " ms");


    }
    public Integer get_TiempoFinal(){
        return TiempoFinal;
    }





}
