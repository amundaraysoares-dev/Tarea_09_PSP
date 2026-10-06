
public class GestorDescargasParte3 {
    public static void main(String[] args) {

        // Creacion de los objetos
        Descargas p1 = new Descargas("cuarzos.png");
        Descargas p2 = new Descargas("meditacion.mp4");
        Descargas p3 = new Descargas("mantras.mp3");
        Descargas p4 = new Descargas("horoscopo.pdf");

        long tInicio = System.currentTimeMillis();

        //iniciador de procesos
        p1.start();
        p2.start();
        p3.start();
        p4.start();

        //iniciador de procesos del intalador
        Thread HInstalador = new Thread(new Instalador(p2, p3), "Instalador");
        HInstalador.start();


        //try que espera que los procesos acaben
        try {
            //Comprobador del que el proceso sigue vivo desppues de 3 segundos
            p2.join(3000);
            if (p2.isAlive()) {
                System.out.println("[Main] meditacion.mp4 sigue en segundo plano"); }


            p1.join();

            p3.join();
            p4.join();

            HInstalador.join();

        }catch (InterruptedException e) {
            System.out.println("Fallo del proceso");

        }
        long tFin = System.currentTimeMillis();
        //calculo del tiempo real transcurrido
        long TiempoReal = tFin - tInicio;

        int T_DescargasSeguidas = p1.get_TiempoFinal() + p2.get_TiempoFinal()+ p3.get_TiempoFinal()+p4.get_TiempoFinal();
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real: "+TiempoReal+" ms");
        System.out.println("Si se hubieran descargado una detrás de otra: "+T_DescargasSeguidas);
    }


}