package com.iprocen.icl.seccion.switchesAd;

public class SwitchesAd {
    private Long id;
    private String puerto_cobre;
    private String puerto_fibra;
    private String puerto_combinado;
    private String velocidad;
    private String caracteristica;
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

    public String getPuerto_fibra() {
        return puerto_fibra;
    }

    public void setPuerto_fibra(String puerto_fibra) {
        this.puerto_fibra = puerto_fibra;
    }

    public String getPuerto_combinado() {
        return puerto_combinado;
    }

    public void setPuerto_combinado(String puerto_combinado) {
        this.puerto_combinado = puerto_combinado;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
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
