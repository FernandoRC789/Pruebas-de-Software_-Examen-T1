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

    //4to Test - Validar Asientos
    @Test
    @DisplayName("Validar Número de Asiento")
    void validarNumeroAsiento() {

        String r = ReservaService.validarReserva(
                "ABC123", "Fernando", "A123456789", 0, LocalDate.now().plusDays(1)
        );

        try {
            assertEquals("La cantidad de asientos debe ser mayor a cero", r);
            System.out.println("✅ TEST PASSED: Validación correcta el numero de asientos debe ser mayor a 0");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Error en validación(esta mal la validación)");
            throw e;
        }
    }

    //5to Test - Validar fechas de vuelo
    @Test
    @DisplayName("Validar Fecha de Vuelo")
    void validarFechaDeVuelo() {

        String r = ReservaService.validarReserva(
                "ABC123", "Fernando", "A123456789", 5, LocalDate.now()
        );

        try {
            assertEquals("La fecha del vuelo debe ser posterior a la fecha actual", r);
            System.out.println("✅ TEST PASSED: Validación correcta la fecha de vuelo debe ser posterior a la fecha actual");
        } catch (AssertionError e) {
            System.out.println("❌ TEST FAILED: Error en validación(esta mal la validación)");
            throw e;
        }
    }

    //6. Sexto Test -  Validar Reserva Correctamente
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