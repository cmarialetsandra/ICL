package com.iprocen.icl.seccion.switchesEt;

public class SwitcheEt {
    private Long id;
    private String puerto_cobre;
    private String puerto_especial;
    private String puerto_total;
    private String velocidad;
    private String alimentacion;
    private String area;
    private boolean condicion;
    private String desc;
    private String nmro_parte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuerto_cobre() {
        return puerto_cobre;
    }

    public void setPuerto_cobre(String puerto_cobre) {
        this.puerto_cobre = puerto_cobre;
    }

    public String getPuerto_especial() {
        return puerto_especial;
    }

    public void setPuerto_especial(String puerto_especial) {
        this.puerto_especial = puerto_especial;
    }

    public String getPuerto_total() {
        return puerto_total;
    }

    public void setPuerto_total(String puerto_total) {
        this.puerto_total = puerto_total;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
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
