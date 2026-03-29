package cibertec;

import java.time.LocalDate;

public class Reserva {
    public static void main(String[] args) {

        String resultado = ReservaService.validarReserva(
                "ABC123",
                "Carlos",
                "A1234567",
                2,
                LocalDate.now().plusDays(1)
        );

        System.out.println(resultado);
    }
}
