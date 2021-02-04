package com.example.carnavigation;

public class Vehicles {
 private static int contarid = 0;
 private int id;
 private String modelo;
 private String marca;
 private String valor;

    public Vehicles() {


    }


    public Vehicles(String modelo, String marca, String valor) {
        this.id = contarid++;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;
    }


    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo +
                "\n" + "Marca: "+  marca +
                "\n" + "Valor(R$): " + valor;
    }
}
