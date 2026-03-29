package nickParte2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrdenServiceTest {

    @Test
    void clienteNoExiste() {

        // MOCKS
        ClienteService clienteMock = mock(ClienteService.class);
        ProductoService productoMock = mock(ProductoService.class);

        // COMPORTAMIENTO
        when(clienteMock.existeCliente("C1")).thenReturn(false);

        OrdenService ordenService = new OrdenService(clienteMock, productoMock);

        String r = ordenService.registrarOrden("C1", "P1", 1, 100);

        assertEquals("Cliente no existe", r);
    }

    @Test
    void productoSinStock() {

        ClienteService clienteMock = mock(ClienteService.class);
        ProductoService productoMock = mock(ProductoService.class);

        when(clienteMock.existeCliente("C1")).thenReturn(true);
        when(clienteMock.clienteActivo("C1")).thenReturn(true);
        when(productoMock.tieneStock("P1", 5)).thenReturn(false);

        OrdenService ordenService = new OrdenService(clienteMock, productoMock);

        String r = ordenService.registrarOrden("C1", "P1", 5, 200);

        assertEquals("Sin stock", r);
    }
}