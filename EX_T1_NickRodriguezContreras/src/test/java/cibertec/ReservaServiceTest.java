package cibertec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceTest {

    //1. Validar campos vacios
    @Test
    @DisplayName("✅ Test: Validar reserva correcta")
    void reservaCorrecta() {
        String r = ReservaService.validarReserva(
                "ABC123", "Fernando", "A1234567", 2, LocalDate.now().plusDays(1)
        );
        if (r.equals("La reserva ha sido registrada correctamente")) {
            System.out.println("✅ TEST PASSED: Datos correctamente");
        } else {
            System.out.println("❌ TEST FAILED: Datos en blanco (NULL) o incorrectos");
        }
    }
}