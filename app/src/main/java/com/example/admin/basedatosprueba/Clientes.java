package com.example.admin.basedatosprueba;

/**
 * Created by admin on 20/05/2017.
 */

public class Clientes {
    public String apellido;
    public String barrio;
    public String cedula;
    public String deuda;
    public String direccion;
    public String fechapago;
    public String nombre;
    public String telefono;





    public Clientes() {
    }

    public Clientes(String apellido, String barrio, String cedula, String deuda, String direccion, String fechapago, String nombre, String telefono) {
        this.apellido = apellido;
        this.barrio = barrio;
        this.cedula = cedula;
        this.deuda = deuda;
        this.direccion = direccion;
        this.fechapago = fechapago;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
