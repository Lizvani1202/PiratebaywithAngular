package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.controller;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;
import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service.iOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrdenRestController {



    @Autowired
    private iOrdenService ordenService;

    @GetMapping("/orden")
    @ResponseStatus(HttpStatus.OK)
    public List<Orden>getOrden(){
        return ordenService.findAll();
    }
    @PostMapping("/registrar")
    public ResponseEntity<Void>addOrden(@RequestBody Orden orden){
        ordenService.save(orden);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping("/buscar/{idOrden}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Orden> getId(@PathVariable(value = "idOrden")Long id){
        Optional<Orden> orden = ordenService.findById(id);
        return orden;
    }
}
