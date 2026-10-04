public class GestorDescargas {
    public static void main(String[] args) {
        Descargas p1 = new Descargas("Descarga-cuarzos.png");
        Descargas p2 = new Descargas("Descarga-meditacion.mp4");
        Descargas p3 = new Descargas("Descarga-mantras.mp3");
        Descargas p4 = new Descargas("Descarga-horoscopo.pdf");


        p1.start();
        p2.start();
        p3.start();
        p4.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();

        }catch (InterruptedException e) {
            System.out.println("Fallo del proceso");

        }
        int TiempoReal =Math.max(Math.max(p1.get_TiempoFinal(), p2.get_TiempoFinal()),
                Math.max(p3.get_TiempoFinal(), p4.get_TiempoFinal()));

        int T_DescargasSeguidas = p1.get_TiempoFinal() + p2.get_TiempoFinal()+ p3.get_TiempoFinal()+p4.get_TiempoFinal();
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real: "+TiempoReal+" ms");
        System.out.println("Si se hubieran descargado una detrás de otra: "+T_DescargasSeguidas);
    }


}
