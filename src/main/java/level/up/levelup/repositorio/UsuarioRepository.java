package level.up.levelup.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import level.up.levelup.entidades.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer >{

}
