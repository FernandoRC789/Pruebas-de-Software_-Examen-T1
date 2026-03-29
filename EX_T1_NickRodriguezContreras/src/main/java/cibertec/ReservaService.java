package cibertec;

import java.time.LocalDate;

public class ReservaService {

    public static String validarReserva(String codigoReserva, String nombreReserva, String pasaporteReserva, int asientosReserva, LocalDate fechaVuelo) {

        //Validacion de Campos vacíos
        if (codigoReserva == null || nombreReserva == null || pasaporteReserva == null || fechaVuelo == null
                || codigoReserva.isEmpty() || nombreReserva.isEmpty() || pasaporteReserva.isEmpty()) {
            return "Debe ingresar todos los datos requeridos";
        }

        //Codigo de reserva (ABC123)
        if (!codigoReserva.matches("^[A-Z]{3}[0-9]{3}$")) {
            return "Ingrese un código de reserva válido";
        }

        //Nombre (solo letras, mínimo 5)
        if (!nombreReserva.matches("^[A-Za-z]{5,}$")) {
            return "El nombre del pasajero debe tener al menos cinco caracteres alfabéticos";
        }

        //Pasaporte (8 a 10 alfanuméricos)
        if (!pasaporteReserva.matches("^[A-Za-z0-9]{8,10}$")) {
            return "Ingrese un número de pasaporte válido";
        }

        //Asientos debe ser mayor a 0
        if (asientosReserva <= 0) {
            return "La cantidad de asientos debe ser mayor a cero";
        }

        //Fecha mayor a la fecha actual (hoy)
        if (!fechaVuelo.isAfter(LocalDate.now())) {
            return "La fecha del vuelo debe ser posterior a la fecha actual";
        }

        //si todos los datos son correctos
        return "La reserva ha sido registrada correctamente";
    }
}