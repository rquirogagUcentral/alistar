/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.Model.util;

/**
 *
 * @author Rosemberg
 */
public class AlistarModelTrace {
    public class APICreateEntityRequestType{
        public int nitEntidad ;
        public String nombreEntidad;
        public String correo;
        public String descripcion;
        public String dirección;
        public int telefonoContacto;

        public int getNitEntidad() {return nitEntidad;}
        public void setNitEntidad(int nitEntidad) {this.nitEntidad = nitEntidad;}
        public String getNombreEntidad() {return nombreEntidad;}
        public void setNombreEntidad(String nombreEntidad) {this.nombreEntidad = nombreEntidad;}
        public String getCorreo() {return correo;}
        public void setCorreo(String correo) {this.correo = correo;}
        public String getDescripcion() {return descripcion;}
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
        public String getDirección() {return dirección;}
        public void setDirección(String dirección) {this.dirección = dirección;}
        public int getTelefonoContacto() {return telefonoContacto;}
        public void setTelefonoContacto(int telefonoContacto) {this.telefonoContacto = telefonoContacto;}
    }
    
    public class APICreateEntityResponseType{
        public String estado;
        public String drescripcionEstado;
    }
}
