/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.umg.proyecto;

import java.util.Date;

/**
 *
 * @author didhyer
 */
public class Proyecto {

    public static void main(String[] args) {

        class Cliente {

            String dpi;
            String nombre;
            String apellido;
            String direccion;
            String telefono;
            String correo;
            String ocupacion;
            double ingresosMensuales;

            Cliente(String dpi, String nombre, String apellido, String direccion, String telefono, String correo, String ocupacion, double ingresosMensuales) {
                this.dpi = dpi;
                this.nombre = nombre;
                this.apellido = apellido;
                this.direccion = direccion;
                this.telefono = telefono;
                this.correo = correo;
                this.ocupacion = ocupacion;
                this.ingresosMensuales = ingresosMensuales;
            }

            @Override
            public String toString() {
                return nombre + " " + apellido;
            }
        }

        class Cuenta {

            static int nextAccountNumber = 1000;
            int numeroCuenta;
            String dpiCliente;
            int tipoCuenta; // 1 para monetario, 2 para ahorro
            double montoInicial;
            Date fechaApertura;
            double saldo;

            Cuenta(String dpiCliente, int tipoCuenta, double montoInicial) {
                this.numeroCuenta = nextAccountNumber++;
                this.dpiCliente = dpiCliente;
                this.tipoCuenta = tipoCuenta;
                this.montoInicial = montoInicial;
                this.fechaApertura = new Date();
                this.saldo = montoInicial;
            }

            @Override
            public String toString() {
                return "Cuenta #" + numeroCuenta + ", Saldo: " + saldo;
            }
        }

    }
}
