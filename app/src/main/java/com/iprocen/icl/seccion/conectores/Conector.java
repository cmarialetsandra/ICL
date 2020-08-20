package com.iprocen.icl.seccion.conectores;

public class Conector {
    private Long id;
    private String heavycon;
    private String polos;
    private String tecnologia;
    private String desc_f;
    private String nmro_parte_f;
    private String desc_m;
    private String nmro_parte_m;
    private String cubierta_c;
    private String cubierta_s;
    private String superior_bajo;
    private String superior_alto;
    private String lateral_bajo;
    private String lateral_alto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeavycon() {
        return heavycon;
    }

    public void setHeavycon(String heavycon) {
        this.heavycon = heavycon;
    }

    public String getPolos() {
        return polos;
    }

    public void setPolos(String polos) {
        this.polos = polos;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getDesc_f() {
        return desc_f;
    }

    public void setDesc_f(String desc_f) {
        this.desc_f = desc_f;
    }

    public String getNmro_parte_f() {
        return nmro_parte_f;
    }

    public void setNmro_parte_f(String nmro_parte_f) {
        this.nmro_parte_f = nmro_parte_f;
    }

    public String getDesc_m() {
        return desc_m;
    }

    public void setDesc_m(String desc_m) {
        this.desc_m = desc_m;
    }

    public String getNmro_parte_m() {
        return nmro_parte_m;
    }

    public void setNmro_parte_m(String nmro_parte_m) {
        this.nmro_parte_m = nmro_parte_m;
    }

    public String getCubierta_c() {
        return cubierta_c;
    }

    public void setCubierta_c(String cubierta_c) {
        this.cubierta_c = cubierta_c;
    }

    public String getCubierta_s() {
        return cubierta_s;
    }

    public void setCubierta_s(String cubierta_s) {
        this.cubierta_s = cubierta_s;
    }

    public String getSuperior_bajo() {
        return superior_bajo;
    }

    public void setSuperior_bajo(String superior_bajo) {
        this.superior_bajo = superior_bajo;
    }

    public String getSuperior_alto() {
        return superior_alto;
    }

    public void setSuperior_alto(String superior_alto) {
        this.superior_alto = superior_alto;
    }

    public String getLateral_bajo() {
        return lateral_bajo;
    }

    public void setLateral_bajo(String lateral_bajo) {
        this.lateral_bajo = lateral_bajo;
    }

    public String getLateral_alto() {
        return lateral_alto;
    }

    public void setLateral_alto(String lateral_alto) {
        this.lateral_alto = lateral_alto;
    }
}
