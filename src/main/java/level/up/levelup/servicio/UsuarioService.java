package level.up.levelup.servicio;

import java.util.List;


import org.springframework.stereotype.Service;

import level.up.levelup.entidades.Usuario;
import level.up.levelup.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario=usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
    public void deleteUserById(int id){
        usuarioRepository.deleteById(id);
    }



}
