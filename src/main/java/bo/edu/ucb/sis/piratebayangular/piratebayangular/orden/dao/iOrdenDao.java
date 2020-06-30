package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.dao;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface iOrdenDao extends CrudRepository<Orden,Long> {

    public Optional<Orden> findById(Long id);
    public Optional<Orden>findByIdOrden(Long idOrden);

    @Query("select o from Orden o where o.idOrden=?1")
    public Orden findByIdOrdenSQL(Long id);

}
