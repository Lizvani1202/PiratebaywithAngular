package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.Entity.Orden;
import bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.dao.iOrdenDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImp implements iOrdenService{

    @Autowired
    private iOrdenDao iOrdenDao;

    @Override
    @Transactional(readOnly = true)
    public List<Orden> findAll() {
        return (List<Orden>)iOrdenDao.findAll();
    }

    @Override
    @Transactional
    public void save(Orden orden) {
        iOrdenDao.save(orden);
    }

    @Override
    @Transactional(readOnly = true)
    public Orden findOrden(Orden orden) {
        return (Orden)iOrdenDao.findByFechaEntregado(orden.getFechaEntregado());
    }

    @Override
    @Transactional
    public void deleteOrder(Orden orden) {
        iOrdenDao.deleteById(orden.getIdOrden());
    }

    @Override
    @Transactional
    public Orden updateOrden(Orden orden) {
        return (Orden)iOrdenDao.save(orden);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Orden> findOrdenByIdOrden(Long idOrden) {
        return (Optional<Orden>)iOrdenDao.findByIdOrden(idOrden);
    }

    @Override
    @Transactional
    public void deleteOrden(Long id) {
        iOrdenDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Orden findByIdOrden(Long id) {
        return iOrdenDao.findByIdOrden(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Orden findByIdOrdenSQL(Long id) {
        return iOrdenDao.findByIdOrdenSQL(id);
    }
}
