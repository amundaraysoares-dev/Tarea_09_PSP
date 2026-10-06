public class Instalador implements Runnable {
    // atributos de la clase
    private Descargas descargas;
    private Descargas descargas2;

    // constructor que inicializa los artibutos
    public Instalador(Descargas descargas,Descargas descargas2) {
        this.descargas = descargas;
        this.descargas2 = descargas2;

    }
    // ejecucion que hace el hilo del Instalador
    public void run() {
        try {

            // Comprobador de si los procesos acabaron
            if (descargas != null){
                descargas.join();
            }
            if (descargas2 != null){
                descargas2.join();
            }
            System.out.println("[Instalador] Meditación y mantras listos: instalando...");
            System.out.println("[Instalador] Instalación terminada");

        }catch(Exception e) {
            System.out.println("Fallo del proceso");
        }





    }
}