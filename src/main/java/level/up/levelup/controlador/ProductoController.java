package level.up.levelup.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import level.up.levelup.entidades.Producto;
import level.up.levelup.servicio.ProductoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id")int id){
        Producto producto = productoService.getProductoById(id);
        if (producto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id")int id){
        Producto producto=productoService.getProductoById(id);
        if (producto==null) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteProductoById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Producto>> listarProducto(){
        List<Producto>productos=productoService.getAll();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        Producto  nuevoProducto= productoService.save(producto);
        return ResponseEntity.ok(nuevoProducto);
    }
}
