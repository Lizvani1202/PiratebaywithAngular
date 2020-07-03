package bo.edu.ucb.sis.piratebayangular.piratebayangular.dto;


public enum Estado  {
    NO_PAGADO(1),PAGADO(2),PREPARADO(3), DESPACHADO(4), ENTREGADO(5) ;

    Estado(int estado) {
        this.estado = estado;
    }

    private int estado;

    public int getEstado() {
        return estado;
    }
}