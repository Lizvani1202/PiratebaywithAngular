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
    public Optional<Orden> findById(Long id) {
        return iOrdenDao.findByIdOrden(id);
    }

    @Override
    @Transactional
    public void save(Orden orden) {
        iOrdenDao.save(orden);
    }



    @Override
    @Transactional
    public Orden updateOrden(Orden orden) {
        return (Orden)iOrdenDao.save(orden);
    }

    @Override
    public Optional<Orden> findOrdenById(Long id) {
        return (Optional<Orden>)iOrdenDao.findByIdOrden(id);
    }


    @Override
    @Transactional(readOnly = true)
    public Orden findByIdOrden(Long id) {
        return iOrdenDao.findByIdOrden(id).orElse(null);
    }

    @Override
    public Orden findByIdSQL(Long id) {
        return iOrdenDao.findByIdOrdenSQL(id);
    }


}
