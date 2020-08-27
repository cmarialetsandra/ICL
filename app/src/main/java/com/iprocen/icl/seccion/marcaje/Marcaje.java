package com.iprocen.icl.seccion.marcaje;

public class Marcaje {
    private Long id;
    private int tipo;
    private String material;
    private String campo1;
    private String campo2;
    private String campo3;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
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
