/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyecto;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author didhyer
 */

public class Clase_Principal {

        private static int correlativoCuenta = 0;

        private static Scanner scanner = new Scanner(System.in);
        private static List<Cliente> clientes = new ArrayList<>();
        private static List<Cuenta> cuentas = new ArrayList<>();
        private static List<Operacion> operaciones = new ArrayList<>();
        private static List<SaldoCuentas> saldos = new ArrayList<>();

        public static void main(String[] args) {
            while (true) {
                System.out.println("\nMENU:");
                System.out.println("1. Registro Cliente");
                System.out.println("2. Ver Cliente");
                System.out.println("3. Actualización Cliente");
                System.out.println("4. Apertura de Cuenta");
                System.out.println("5. Realizar Depósito");
                System.out.println("6. Retirar Dinero");
                System.out.println("7. Estado de Cuenta");
                System.out.println("8. Operaciones del dia");
                System.out.println("9. Saldo de todas las cuentas");
                System.out.println("10. Salir");

                System.out.print("Seleccione una opción: ");
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2:
                        verCliente();
                        break;
                    case 3:
                        actualizarCliente();
                        break;
                    case 4:
                        aperturaCuenta();
                        break;
                    case 5:
                        realizarDeposito();
                        break;
                    case 6:
                        retirarDinero();
                        break;
                    case 7:
                        estadoCuenta();
                        break;
                    case 8:
                        operacionesDia();
                        break;
                    case 9:
                        saldoTodasLasCuentas();
                        break;
                    case 10:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } 

        
        private static void registrarCliente() {
            System.out.print("DPI: ");
            String dpi = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            System.out.print("Ocupación: ");
            String ocupacion = scanner.nextLine();
            System.out.print("Ingresos Mensuales: ");
            double ingresosMensuales = Double.parseDouble(scanner.nextLine());

            Cliente cliente = new Cliente(dpi, nombre, apellido, direccion, telefono, correo, ocupacion, ingresosMensuales);
       
            clientes.add(cliente);
            System.out.println("Cliente registrado exitosamente.");
        }
        
        
        private static void verCliente() {
            System.out.print("Ingrese el DPI del cliente a buscar: ");
            String dpi = scanner.nextLine();

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getDpi().equals(dpi)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
            System.out.println("DPI:" + cliente.getDpi());   
            System.out.println("Nombre:" + cliente.getNombre());   
            System.out.println("Apellido:" + cliente.getApellido());   
            System.out.println("Dirección:" + cliente.getDireccion());          
            System.out.println("Teléfono:" + cliente.getTelefono());           
            System.out.println("Correo:" + cliente.getCorreo()); 
            System.out.println("Ocupación:" + cliente.getOcupacion());
            System.out.println("Ingresos Mensuales:" + cliente.getIngresosMensuales());

        }

       private static void actualizarCliente() {
            System.out.print("Ingrese el DPI del cliente a actualizar: ");
            String dpi = scanner.nextLine();

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getDpi().equals(dpi)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }

            System.out.print("Nueva Dirección (" + cliente.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            System.out.print("Nuevo Teléfono (" + cliente.getTelefono() + "): ");
            String telefono = scanner.nextLine();
            System.out.print("Nuevo Correo (" + cliente.getCorreo() + "): ");
            String correo = scanner.nextLine();
            System.out.print("Nueva Ocupación (" + cliente.getOcupacion() + "): ");
            String ocupacion = scanner.nextLine();
            System.out.print("Nuevos Ingresos Mensuales (" + cliente.getIngresosMensuales() + "): ");
            String ingresosMensualesStr = scanner.nextLine();
           
            double ingresosMensuales = ingresosMensualesStr.isEmpty() ? cliente.getIngresosMensuales() : Double.parseDouble(ingresosMensualesStr);
            cliente.setDireccion(direccion.isEmpty() ? cliente.getDireccion() : direccion);
            cliente.setTelefono(telefono.isEmpty() ? cliente.getTelefono() : telefono);
            cliente.setCorreo(correo.isEmpty() ? cliente.getCorreo() : correo);
            cliente.setOcupacion(ocupacion.isEmpty() ? cliente.getOcupacion() : ocupacion);
            cliente.setIngresosMensuales(ingresosMensuales);

            System.out.println("Cliente actualizado exitosamente.");
        }

        private static void aperturaCuenta() {
            System.out.print("Ingrese el DPI del Cliente para aperturar su cuenta: ");
            String dpi = scanner.nextLine();

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getDpi().equals(dpi)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }

            System.out.print("Monto Inicial: ");
            double montoInicial = Double.parseDouble(scanner.nextLine());
            System.out.print("Tipo de Cuenta (1 para Monetario, 2 para Ahorro): ");
            int tipoCuenta = Integer.parseInt(scanner.nextLine());
            
            correlativoCuenta++;
            Cuenta cuenta = new Cuenta(correlativoCuenta, dpi, tipoCuenta, montoInicial);
            
            cuentas.add(cuenta);
            System.out.println("Cuenta creada exitosamente para el cliente con DPI: " + dpi + " número de cuenta: " + correlativoCuenta);
        }

        
        private static void realizarDeposito() {
            System.out.print("Número de Cuenta: ");
            int numeroCuenta = Integer.parseInt(scanner.nextLine());
            System.out.print("Monto a Depositar: ");
            double monto = Double.parseDouble(scanner.nextLine());

            Cuenta cuenta = null;
            for (Cuenta c : cuentas) {
                if (c.getNumeroCuenta() == numeroCuenta) {
                    cuenta = c;
                    break;
                }
            }

            if (cuenta == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }
            
            cuenta.setSaldo(cuenta.getSaldo()+monto);
            Operacion operacion = new Operacion(cuenta.getNumeroCuenta(),cuenta.getDpi(),"Deposito",monto);
            operaciones.add(operacion);
            System.out.println("Depósito realizado exitosamente. Nuevo saldo: " + cuenta.getSaldo());
        }

        
        private static void retirarDinero() {
            System.out.print("Número de Cuenta: ");
            int numeroCuenta = Integer.parseInt(scanner.nextLine());
            System.out.print("Monto a Retirar: ");
            double monto = Double.parseDouble(scanner.nextLine());

            Cuenta cuenta = null;
            for (Cuenta c : cuentas) {
                if (c.getNumeroCuenta() == numeroCuenta) {
                    cuenta = c;
                    break;
                }
            }

            if (cuenta == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }

            if (cuenta.getSaldo() < monto) {
                System.out.println("Saldo insuficiente.");
                return;
            }

            cuenta.setSaldo(cuenta.getSaldo()-monto);
            Operacion operacion = new Operacion(cuenta.getNumeroCuenta(),cuenta.getDpi(),"Retiro",monto);
            operaciones.add(operacion);
            System.out.println("Retiro realizado exitosamente. Nuevo saldo: " + cuenta.getSaldo());
        }

        private static void estadoCuenta() {
            
            //Buscar cuenta
            System.out.print("Número de Cuenta: ");
            int numeroCuenta = Integer.parseInt(scanner.nextLine());
            

            Cuenta cuenta = null;
            for (Cuenta c : cuentas) {
                if (c.getNumeroCuenta() == numeroCuenta) {
                    cuenta = c;
                    break;
                }
            }

            if (cuenta == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }
            
            //Si encuentro la cuenta busco al cliente
            
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getDpi().equals(cuenta.getDpi())) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
            
            String tipo="";
            if (cuenta.getTipoCuenta()==1){
                tipo="Monetaria";
            }else{
                tipo="Ahorro";
            }
            
            String encabezado = "Cuenta: " + cuenta.getNumeroCuenta() 
                    + " Tipo: " + tipo 
                    + " Saldo: " + cuenta.getSaldo()
                    + " DPI: " + cliente.getDpi() 
                    + " Nombre: " + cliente.getNombre() 
                    + " Apellido: " + cliente.getApellido();
            
            try (FileWriter fichero = new FileWriter("estadoCuenta" + cuenta.getNumeroCuenta() + ".txt")){
                PrintWriter pw = new PrintWriter(fichero);
                
                //Imprimiendo encabezado
                System.out.println(encabezado);
                pw.println(encabezado);
                
                //Imprimiendo operaciones
                //Buscando las operaciones
                Operacion operacion = null;
                int contador = 0;
                for (Operacion o : operaciones) {
                    if (o.getNumeroCuenta() == numeroCuenta) {
                        contador++;
                        String descripcionOperacion = contador + " " + "Fecha: " +o.getFecha()
                                + " Tipo:" + o.getTipo() 
                                + " Monto:" + o.getMonto();
                        
                        System.out.println(descripcionOperacion);
                        pw.println(descripcionOperacion);
                    }
                }
                    
                    
            } catch (Exception e) {
                e.printStackTrace();
            } 
            
        }
        
        private static void operacionesDia() {
         
           
            
            try (FileWriter fichero = new FileWriter("operacionesDia.txt")){
                PrintWriter pw = new PrintWriter(fichero);
                
             
                
                //Imprimiendo operaciones
                //Buscando las operaciones
                Operacion operacion = null;
                int contador = 0;
                double totalDeposito=0;
                double totalRetiro=0;
                
                for (Operacion o : operaciones) {
                    //if (o.getNumeroCuenta() == numeroCuenta) {
                        contador++;
                        String descripcionOperacion = contador + " " 
                                + "Cuenta: " + o.getNumeroCuenta()
                                + "Fecha: " +o.getFecha()
                                + " Tipo:" + o.getTipo() 
                                + " Monto:" + o.getMonto();
                        
                        System.out.println(descripcionOperacion);
                        pw.println(descripcionOperacion);
                        
                        if (o.getTipo().equalsIgnoreCase("Deposito")==true) totalDeposito+=o.getMonto();
                        else totalRetiro+=o.getMonto();
                       
                    //}
                }
                System.out.println("Total depositos: " + totalDeposito);
                 System.out.println("Total retiros: " + totalRetiro);
                
                 pw.println("Total depositos: " + totalDeposito);
                 pw.println("Total retiros: " + totalRetiro); 
                    
                    
            } catch (Exception e) {
                e.printStackTrace();
            } 
            
            
        }
        
        
        private static void saldoTodasLasCuentas() {
            //Busco todas las cuentas
            for (Cuenta cuenta : cuentas) {
                  // busco al cliente de la cuenta
                Cliente cliente = null;
                for (Cliente clien : clientes) {
                    if (clien.getDpi().equals(cuenta.getDpi())) {
                        cliente = clien;
                        break;
                    }
                }
                String nombre="";
                String apellido="";
                //Si el cliente no existe se pone un valor por default para nombre y apellido
                if (cliente == null) {
                    nombre="Desconocido";
                    apellido="Desconocido";
                    //return;
                }else{
                    nombre=cliente.getNombre();
                    apellido=cliente.getApellido();
                }

                String tipo="";
                if (cuenta.getTipoCuenta()==1){
                    tipo="Monetaria";
                }else{
                    tipo="Ahorro";
                }
                
                
                
                SaldoCuentas objSaldo = new SaldoCuentas(cuenta.getNumeroCuenta(),tipo,cuenta.getSaldo(),
                                                         cuenta.getDpi(),nombre,apellido);
                
                saldos.add(objSaldo);
            }
            Reportes r = new Reportes();
            r.generarReporteExcel(saldos);
          
        }

}
