package bo.edu.ucb.sis.piratebayangular.piratebayangular.security.service;


import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.entity.Usuario;
import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.entity.UsuarioPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);

    }
}
