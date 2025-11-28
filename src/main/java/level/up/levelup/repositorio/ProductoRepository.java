package level.up.levelup.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import level.up.levelup.entidades.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
