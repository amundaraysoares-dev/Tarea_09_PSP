public class GestorDescargas {
    public static void main(String[] args) {


        String[] Archivos = {
                "meditacion.mp4",
                "documental.mkv",
                "musica.mp3",
                "tutorial.pdf"
        };

        Descargas[] L_descargas = new Descargas[Archivos.length];

        for (int i =0;i < Archivos.length; i++){
            L_descargas[i] = new Descargas(Archivos[i]);
        }
        long tInicio = System.currentTimeMillis();

        for (Descargas descarga : L_descargas) {
            descarga.start();
        }


        for (Descargas descarga : L_descargas) {
            try {
                descarga.join();
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
