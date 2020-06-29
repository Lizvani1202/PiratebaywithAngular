package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;

import java.util.List;
import java.util.Optional;

public interface iOrdenService {
    public List<Orden> findAll();
    public void save(Orden orden);
    public Orden findOrden(Orden orden);

    public void deleteOrder(Orden orden);
    public Orden updateOrden(Orden orden);
    public Optional<Orden> findOrdenByIdOrden(Long idOrden);
    public void deleteOrden(Long id);
    public Orden findByIdOrden(Long id);
    public Orden findByIdOrdenSQL(Long id);
}
