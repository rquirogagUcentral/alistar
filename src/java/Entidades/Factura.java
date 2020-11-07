/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Rosemberg
 */
public class Factura {
    private int idFactura;
    private int idOrden;
    private int idUsuario;
    private int idEvento;
    private String autorizacion;
    private String estado;
    private int valorTotal;

    public Factura(int idFactura, int idOrden, int idUsuario, int idEvento, String autorizacion, String estado, int valorTotal) {
        this.idFactura = idFactura;
        this.idOrden = idOrden;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.autorizacion = autorizacion;
        this.estado = estado;
        this.valorTotal = valorTotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
}
