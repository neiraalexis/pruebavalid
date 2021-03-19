/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alexis
 */
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String apellido;

    private Integer id;

    private boolean procesado;

    /**
     *
     */
    public Cliente() {
    }

    /**
     *
     * @param id
     */
    public Cliente(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param nombre
     * @param apellido
     */
    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param id
     */
    public Cliente(String nombre, String apellido, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param id
     * @param procesado
     */
    public Cliente(String nombre, String apellido, Integer id, boolean procesado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.procesado = procesado;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public boolean isProcesado() {
        return procesado;
    }

    /**
     *
     * @param procesado
     */
    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellido);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + (this.procesado ? 1 : 0);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.procesado != other.procesado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", procesado=" + procesado + '}';
    }

}
