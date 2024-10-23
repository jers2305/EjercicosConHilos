public class Main {
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento();

        Thread coche1 = new Thread(() -> {
            try {
                estacionamiento.altaVehiculo();

                Thread.sleep(2000);
                estacionamiento.bajaVehiculo();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        });

        Thread coche2 = new Thread(() -> {
            try {
                estacionamiento.altaVehiculo();
                Thread.sleep(2000);
                estacionamiento.bajaVehiculo();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        });

        Thread coche3 = new Thread(() -> {
            try {
                estacionamiento.altaVehiculo();
                Thread.sleep(2000);
                estacionamiento.bajaVehiculo();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        });

        coche1.start();
        coche2.start();
        coche3.start();
    }
}
