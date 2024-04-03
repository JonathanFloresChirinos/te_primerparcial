package com.emergentes.modelo;

public class calificaciones {
    private int id;
    private String nombre;
    private int P1;
    private int P2;
    private int P3;
    private int nota;

    public calificaciones() {
        this.id = 0;
        this.nombre = "";
        this.P1 = 0;
        this.P2 = 0;
        this.P3 = 0;
        this.nota = P1+P2+P3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getP1() {
        return P1;
    }

    public void setP1(int P1) {
        this.P1 = P1;
    }

    public int getP2() {
        return P2;
    }

    public void setP2(int P2) {
        this.P2 = P2;
    }

    public int getP3() {
        return P3;
    }

    public void setP3(int P3) {
        this.P3 = P3;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
