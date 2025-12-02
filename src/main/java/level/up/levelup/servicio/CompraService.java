package level.up.levelup.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import level.up.levelup.entidades.Compra;
import level.up.levelup.repositorio.CompraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository compraRepository;
     
    public List<Compra> getAll(){
        return compraRepository.findAll();
    }
    public Compra getCompraById(int id){
        return compraRepository.findById(id).orElse(null);
    }
    public Compra save(Compra compra){
        Compra nuevaCompra=compraRepository.save(compra);
        return nuevaCompra;
    }
    public void deleteCompraById(int id){
        compraRepository.deleteById(id);
    }




}
