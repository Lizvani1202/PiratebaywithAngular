package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.controller;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;
import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service.iOrdenService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateOrden(@PathVariable(value = "id")Long id, @RequestBody Orden orden){
        Orden ordenDb = null;
        ordenDb = ordenService.findByIdOrden(id);
        if(ordenDb != null){
            ordenDb.setFechaPagado(orden.getFechaPagado());
            ordenDb.setFechaPreparado(orden.getFechaPreparado());
            ordenDb.setFechaDespachado(orden.getFechaDespachado());
            ordenDb.setFechaEntregado(orden.getFechaEntregado());
            ordenService.updateOrden(ordenDb);
            return new ResponseEntity<>(ordenDb,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public HashMap<String,Integer> updateOrden(@Valid @RequestBody Orden orden, BindingResult bindingResult){
        HashMap<String,Integer> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("Message", 400);
        }else{
            int response=ordenService.update(orden);
            map.put("Message", response);
        }
        return map;
    }







}
