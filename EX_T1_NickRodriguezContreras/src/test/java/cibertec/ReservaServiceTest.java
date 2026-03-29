package cibertec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceTest {

    //1er Test - Validar Campos vacios
    @Test
    @DisplayName("Validar campos vacíos")
    void camposVacios() {

        String r = ReservaService.validarReserva(
                "", "Carlos", "A1234567", 2, LocalDate.now().plusDays(1)
        );

        try {
            assertEquals("Debe ingresar todos los datos requeridos", r);
            System.out.println("✅ TEST PASSED: Validación correcta hay uno o más campos vacios");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Error en validación de campos vacíos");
            throw e;
        }
    }

    //2do Test - Validar Nombre de Pasajeros
    @Test
    @DisplayName("Validar Nombre de Pasajeros")
    void validarNombres() {

        String r = ReservaService.validarReserva(
                "ABC123", "Nick", "A1234567", 2, LocalDate.now().plusDays(1)
        );

        try {
            assertEquals("El nombre del pasajero debe tener al menos cinco caracteres alfabéticos", r);
            System.out.println("✅ TEST PASSED: Validación correcta el nombre minimo 5 caracteres");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Error en validación.");
            throw e;
        }
    }

    //3er Test - Validar Número de pasaporte
    @Test
    @DisplayName("Validar Número de pasaporte")
    void validarNumeroPasaporte() {

        String r = ReservaService.validarReserva(
                "ABC123", "Fernando", "A123", 2, LocalDate.now().plusDays(1)
        );

        try {
            assertEquals("Ingrese un número de pasaporte válido", r);
            System.out.println("✅ TEST PASSED: Validación correcta el numero de pasaporte debe tener entre 8 y 10 caracteres");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Error en validación(esta mal la validación)");
            throw e;
        }
    }

    //Sexto Test -  Validar Reserva Correctamente
    @Test
    @DisplayName("✅ Test: Validar reserva correcta")
    void reservaCorrecta() {
        String r = ReservaService.validarReserva(
                "ABC123", "Fernando", "A1234567", 2, LocalDate.now().plusDays(1)
        );

        try {
            assertEquals("La reserva ha sido registrada correctamente", r);
            System.out.println("✅ TEST PASSED: Datos correctamente");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Datos en blanco (NULL) o incorrectos");
            throw e;
        }
    }


}