package com.iprocen.icl.seccion.circuitBr;

public class CircuitBr {
    private Long id;
    private int tipo;
    private String ul;
    private String nmro_polos;
    private String curva;
    private String amperaje;
    private String canal;
    private String funcion;
    private String accesorio;
    private String desc;
    private String nmro_parte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUl() {
        return ul;
    }

    public void setUl(String ul) {
        this.ul = ul;
    }

    public String getNmro_polos() {
        return nmro_polos;
    }

    public void setNmro_polos(String nmro_polos) {
        this.nmro_polos = nmro_polos;
    }

    public String getCurva() {
        return curva;
    }

    public void setCurva(String curva) {
        this.curva = curva;
    }

    public String getAmperaje() {
        return amperaje;
    }

    public void setAmperaje(String amperaje) {
        this.amperaje = amperaje;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNmro_parte() {
        return nmro_parte;
    }

    public void setNmro_parte(String nmro_parte) {
        this.nmro_parte = nmro_parte;
    }

}
