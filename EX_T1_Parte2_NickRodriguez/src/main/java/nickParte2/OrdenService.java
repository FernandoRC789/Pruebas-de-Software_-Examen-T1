package nickParte2;

public class OrdenService {

    private ClienteService clienteService;
    private ProductoService productoService;

    public OrdenService(ClienteService clienteService, ProductoService productoService) {
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    public String registrarOrden(String clienteId, String productoId, int cantidad, double total) {

        if (!clienteService.existeCliente(clienteId)) {
            return "Cliente no existe";
        }

        if (!clienteService.clienteActivo(clienteId)) {
            return "Cliente inactivo";
        }

        if (!productoService.tieneStock(productoId, cantidad)) {
            return "Sin stock";
        }

        if (cantidad <= 0) {
            return "Cantidad inválida";
        }

        if (total > 500) {
            total = total * 0.9;
        }

        return "Orden registrada";
    }
}