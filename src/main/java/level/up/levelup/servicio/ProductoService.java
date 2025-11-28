package level.up.levelup.servicio;

import java.util.List;


import org.springframework.stereotype.Service;

import level.up.levelup.entidades.Producto;
import level.up.levelup.repositorio.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public List<Producto>getAll(){
        return productoRepository.findAll();
    }
    public Producto getProductoById(int id){
        return productoRepository.findById(id).orElse(null);
    }
    public Producto save(Producto producto){
        Producto nuevProducto=productoRepository.save(producto);
        return nuevProducto;
    }
    public void deleteProductoById(int id){
        productoRepository.deleteById(id);
    }
    

}
