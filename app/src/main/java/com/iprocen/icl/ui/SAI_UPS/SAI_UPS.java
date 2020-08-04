package com.iprocen.icl.ui.SAI_UPS;

public class SAI_UPS {
    private Long id;
    private int aliment;
    private String entrada;
    private String salida;
    private String desc;
    private String nmro_parte;
    private String alm_energia;
    private String t_alm_energia;

    public SAI_UPS() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAliment() {
        return aliment;
    }

    public void setAliment(int aliment) {
        this.aliment = aliment;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
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

    public String getAlm_energia() {
        return alm_energia;
    }

    public void setAlm_energia(String alm_energia) {
        this.alm_energia = alm_energia;
    }

    public String getT_alm_energia() {
        return t_alm_energia;
    }

    public void setT_alm_energia(String t_alm_energia) {
        this.t_alm_energia = t_alm_energia;
    }
}
