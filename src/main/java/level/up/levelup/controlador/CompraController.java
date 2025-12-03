package level.up.levelup.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import level.up.levelup.entidades.Compra;
import level.up.levelup.servicio.CompraService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService compraService;

    @GetMapping("/id")
    public ResponseEntity<Compra> obtenerCompra(@PathVariable("id") int id) {
        Compra compra = compraService.getCompraById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compra);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Compra> eliminarCompra(@PathVariable("id") int id) {
        Compra compra = compraService.getCompraById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        compraService.deleteCompraById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Compra>> listarCompra() {
        List<Compra> compras = compraService.getAll();
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compras);
    }
    @PostMapping
    public ResponseEntity<Compra> guardarCompra(@RequestBody Compra compra) {
        Compra nuevaCompra = compraService.save(compra);
        return ResponseEntity.ok(nuevaCompra);
    }

    
}
