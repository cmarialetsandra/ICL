package com.iprocen.icl.seccion.reles;

public class Rele {
    private Long id;
    private int tipo;
    private String tipo_rele;
    private String voltaje;
    private String salida;
    private String contacto;
    private String conexion;
    private String desc;
    private String nmro_parte;
    private String accesorio;
    private String desc_acc;
    private String nmro_parte_acc;

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

    public String getTipo_rele() {
        return tipo_rele;
    }

    public void setTipo_rele(String tipo_rele) {
        this.tipo_rele = tipo_rele;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
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

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public String getDesc_acc() {
        return desc_acc;
    }

    public void setDesc_acc(String desc_acc) {
        this.desc_acc = desc_acc;
    }

    public String getNmro_parte_acc() {
        return nmro_parte_acc;
    }

    public void setNmro_parte_acc(String nmro_parte_acc) {
        this.nmro_parte_acc = nmro_parte_acc;
    }

}
