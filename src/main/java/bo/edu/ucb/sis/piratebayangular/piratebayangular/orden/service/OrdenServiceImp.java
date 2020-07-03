package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden.service;

import bo.edu.ucb.sis.piratebayangular.piratebayangular.dto.Estado;
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

    public int update(Orden orden){
        int response=0;

        Orden ordenEntity=iOrdenDao.findByOrden(orden.getNumeroOrden());

        switch (ordenEntity.getEstado())
        {
            case 1:  response=update_pagado(ordenEntity,orden);
                break;
            case 2:  response=update_preparado(ordenEntity,orden);
                break;
            case 3:  response=update_despachado(ordenEntity,orden);
                break;
            case 4:  response=update_entregado(ordenEntity,orden);
                break;
            default: response = 400;
                break;
        }
        return response;
    }
    public int update_pagado(Orden orden,Orden ordenfecha){
        if(orden.getEstado()==Estado.NO_PAGADO.getEstado()){
            orden.setFechaPagado(ordenfecha.getFechaPagado());
            orden.setEstado(Estado.PAGADO.getEstado());
            iOrdenDao.save(orden);
            return 200;
        }else {
            return 400;
        }
    }
    public int update_preparado(Orden orden,Orden ordenfecha){
        if(orden.getEstado()==Estado.PAGADO.getEstado()){
            orden.setFechaPreparado(ordenfecha.getFechaPreparado());
            orden.setEstado(Estado.PREPARADO.getEstado());
            iOrdenDao.save(orden);
            return 200;
        }else {
            return 400;
        }
    }
    public int update_despachado(Orden orden,Orden ordenfecha){
        if(orden.getEstado()==Estado.PREPARADO.getEstado()){
            orden.setFechaDespachado(ordenfecha.getFechaDespachado());
            orden.setEstado(Estado.DESPACHADO.getEstado());
            iOrdenDao.save(orden);
            return 200;
        }else {
            return 400;
        }
    }
    public int update_entregado(Orden orden,Orden ordenfecha){
        if(orden.getEstado()==Estado.DESPACHADO.getEstado()){
            orden.setFechaEntregado(ordenfecha.getFechaEntregado());
            orden.setEstado(Estado.ENTREGADO.getEstado());
            iOrdenDao.save(orden);
            return 200;
        }else {
            return 400;
        }
    }

}
