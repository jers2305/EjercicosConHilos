public class Estacionamiento {
    private int capacidad = 0; // Inicialmente no hay vehículos
    private final int maxCapacidad = 2; // Capacidad máxima

    public void altaVehiculo() throws InterruptedException {
        synchronized (this) {
            while (capacidad >= maxCapacidad) {
                System.out.println("Espere por la libreza del estacionamiento");
                wait(); // Espera si está lleno
            }
            // Se añade un vehículo
            capacidad++;
            System.out.println("Vehículo entró. Capacidad actual: " + capacidad);
            notifyAll(); // Notifica a otros hilos
        }
    }

    public void bajaVehiculo() throws InterruptedException {
        synchronized (this) {
            while (capacidad <= 0) {
                System.out.println("Espere por la disponibilidad del estacionamiento");
                wait(); // Espera si está vacío
            }
            // Se quita un vehículo
            capacidad--;
            System.out.println("Vehículo salió. Capacidad actual: " + capacidad);
            notifyAll(); // Notifica a otros hilos
        }
    }
}

