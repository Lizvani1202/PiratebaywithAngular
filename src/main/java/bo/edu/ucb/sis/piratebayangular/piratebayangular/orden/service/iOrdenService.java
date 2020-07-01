package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface iOrdenService {
    public List<Orden> findAll();
    Optional<Orden> findById(Long id);
    public void save(Orden orden);
   public Orden updateOrden(Orden orden);
   public Optional<Orden>findOrdenById(Long id);
   public Orden findByIdOrden(Long id);
   public Orden findByIdSQL(Long id);
    public int update(Orden orden);


}
