public class Monitor implements Runnable {
    private Descargas[] L_descargas;


    public Monitor(Descargas[] descargas){
        this.L_descargas = descargas;

    }

    @Override
    public void run() {
        int existe = 0;

        while (existe == 0) {
            for (Descargas descarga : L_descargas) {
                if (descarga != null && descarga.isAlive()) {
                    existe++;
                }


            }

            if (existe != 0) {
                System.out.println("Descargas en curso: " + existe);
                existe = 0;
            } else {
                System.out.println("No queda ninguna descarga en curso");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("error" + e.getMessage());
                break;
            }


        }



    }








}
