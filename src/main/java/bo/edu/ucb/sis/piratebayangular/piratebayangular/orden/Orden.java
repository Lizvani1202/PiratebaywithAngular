package bo.edu.ucb.sis.piratebayangular.piratebayangular.orden;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    @Column(name = "numero_orden")
    private int numeroOrden;

    @Column(name = "producto_Nombre")
    private String productoNombre;

    @Column(name = "producto_tipo")
    private String productoTipo;

    @Column(name = "monto")
    private double monto;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "fecha_pagado")
    private Date fechaPagado;

    @Column(name = "fecha_preparado")
    private Date fechaPreparado;

    @Column(name = "fecha_despachado")
    private Date fechaDespachado;

    @Column(name = "fecha_entregado")
    private Date fechaEntregado;

    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date tx_date;

    @PrePersist
    public void prePersist(){
        tx_date = new Date();
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoTipo() {
        return productoTipo;
    }

    public void setProductoTipo(String productoTipo) {
        this.productoTipo = productoTipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaPagado() {
        return fechaPagado;
    }

    public void setFechaPagado(Date fechaPagado) {
        this.fechaPagado = fechaPagado;
    }

    public Date getFechaPreparado() {
        return fechaPreparado;
    }

    public void setFechaPreparado(Date fechaPreparado) {
        this.fechaPreparado = fechaPreparado;
    }

    public Date getFechaDespachado() {
        return fechaDespachado;
    }

    public void setFechaDespachado(Date fechaDespachado) {
        this.fechaDespachado = fechaDespachado;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public Date getTx_date() {
        return tx_date;
    }

    public void setTx_date(Date tx_date) {
        this.tx_date = tx_date;
    }

    private static final long serialVersionUID = 1L;

}
