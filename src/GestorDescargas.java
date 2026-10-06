import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class GestorDescargas {
    public static void main(String[] args) {
        boolean ejecutor = true;
        Scanner teclado = new Scanner(System.in);
        List<String> Archivos = new ArrayList<>();

        while (true){
            System.out.println("dime un archivo para descargar o ejecutar para lanzar la descarga");
            String opcion = teclado.nextLine().trim();
            if (opcion.equalsIgnoreCase("ejecutar")){

                break;
            }else{
                Archivos.add(opcion);
            }

        }
        if (Archivos.size()==0){
            Archivos.add("meditacion.mp4");
            Archivos.add("documental.mkv");
            Archivos.add("musica.mp3");
            Archivos.add("tutorial.pdf");

        }

        Descargas[] L_descargas = new Descargas[Archivos.size()];

        for (int i =0;i < Archivos.size(); i++){
            L_descargas[i] = new Descargas(Archivos.get(i));
        }
        long tInicio = System.currentTimeMillis();

        for (Descargas descarga : L_descargas) {
            descarga.start();
        }
        Monitor monitor = new Monitor(L_descargas);
        Thread monitoreo = new Thread(monitor,"monitor");
        monitoreo.start();

        for (Descargas descarga : L_descargas) {
            try {
                descarga.join();
                monitoreo.join();
            } catch (InterruptedException e) {
                System.err.println("El hilo principal fue interrumpido: " + e.getMessage());
            }
        }





        long tFin = System.currentTimeMillis();
        long TiempoReal = tFin - tInicio;


        int T_DescargasSeguidas = 0;
        for (Descargas descarga : L_descargas) {
            T_DescargasSeguidas += descarga.get_TiempoFinal();
        }
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real: "+TiempoReal+" ms");
        System.out.println("Si se hubieran descargado una detrás de otra: "+T_DescargasSeguidas+ "ms");
    }


}
