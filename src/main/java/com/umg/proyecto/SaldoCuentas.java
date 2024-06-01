/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyecto;

/**
 *
 * @author didhyer
 */
public class SaldoCuentas {
    private int cuenta;
    private String tipo;
    private double saldo;
    private String dpi;
    private String nombre;
    private String apellido;

    public SaldoCuentas() {
    }
    
    

    public SaldoCuentas(int cuenta, String tipo, double saldo, String dpi, String nombre, String apellido) {
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
