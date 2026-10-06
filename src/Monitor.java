public class Monitor implements Runnable {
    private Descargas[] L_descargas;


    public Monitor(Descargas[] descargas){
        this.L_descargas = descargas;

    }

    // ejecucion que hace el hilo
    public void run() {
        int existe = 0;

        // bucle que se mantiene en ejecucion mientras existe sea igual a 0
        while (existe == 0) {
            for (Descargas descarga : L_descargas) {
                if (descarga != null && descarga.isAlive()) {
                    existe++;
                }


            }
            // si hay descargas activas, muestra el total y reinicia el contador
            if (existe != 0) {

                System.out.println("Descargas en curso: " + existe);
                existe = 0;
            } else {
                //si no finaliza el monitoreo
                System.out.println("No queda ninguna descarga en curso");
                break;
            }
            // Pausa el hilo de monitoreo
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("error" + e.getMessage());
                break;
            }


        }



    }








}
