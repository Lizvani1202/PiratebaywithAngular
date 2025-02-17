package bo.edu.ucb.sis.piratebayangular.piratebayangular.security.contoller;
//
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.dto.Mensaje;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.dto.JwtDto;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.dto.LoginUsuario;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.dto.NuevoUsuario;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.entity.Rol;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.entity.Usuario;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.enums.RolNombre;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.jwt.JwtProvider;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.jwt.JwtTokenFilter;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.service.RolService;
//import bo.edu.ucb.sis.piratebayangular.piratebayangular.security.service.UsuarioService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashSet;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//public class AuthController {
//
//    private final static Logger LOGGER= LoggerFactory.getLogger(AuthController.class);
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    @Autowired
//    RolService rolService;
//
//    @Autowired
//    JwtProvider jwtProvider;
//
//    @PostMapping("/nuevo")
//    public ResponseEntity<?>nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return new ResponseEntity(new Mensaje("campos mal ingresados o email invalido"), HttpStatus.BAD_REQUEST);
//        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
//        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
//            return new ResponseEntity(new Mensaje("Ese email ya existe"),HttpStatus.BAD_REQUEST);
//        Usuario usuario =
//                new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(),
//                        passwordEncoder.encode(nuevoUsuario.getPassword()));
//        Set<Rol>roles = new HashSet<>();
//        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
//        if(nuevoUsuario.getRoles().contains("admin"))
//            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
//        usuario.setRoles(roles);
//        usuarioService.save(usuario);
//        return new ResponseEntity(new Mensaje("usuario guardado"),HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
//        System.out.println(loginUsuario);
//        LOGGER.error(loginUsuario+ " ");
//        Authentication authentication =
//                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtProvider.generateToken(authentication);
//        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
//        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
//        return new ResponseEntity(jwtDto, HttpStatus.OK);
//    }

//}
