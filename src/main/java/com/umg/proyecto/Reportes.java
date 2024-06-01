/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.proyecto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author didhyer
 */

public class Reportes {
    
    
    
    public void generarReporteExcel(List<SaldoCuentas> saldos) {
        
     
        
       
        // Establecer el nombre del reporte
        String nombreReporte = System.getProperty("user.dir") + "/Reporte.xlsx";
        
        // Crear un nuevo libro de trabajo
        Workbook workbook = new XSSFWorkbook();
        
        // Crear una hoja
        Sheet hoja = workbook.createSheet("Reporte");
        
        // Establecer los titulos del encabezado
        String[] titulos = {"Cuenta", "Tipo", "Saldo", "DPI", "Nombre", "Apellido"};
        
        // Crear la fila del encabezado
        Row filaEncabezados = hoja.createRow(0);
        
        // Llenar la fila del encabezado
        for(int i = 0; i < titulos.length; i++) {
            Cell celda = filaEncabezados.createCell(i);
            celda.setCellValue(titulos[i]);
            hoja.autoSizeColumn(i);
        }
        
        // Llenar el resto de datos
        for(int i = 0; i<saldos.size(); i++) {
            
            Row filaDatos = hoja.createRow(i+1);
            
            for(int dato = 0; dato < titulos.length; dato++) { 
            
                Cell celdaDato = filaDatos.createCell(dato);
                
                
                int cuenta = saldos.get(i).getCuenta();
                String tipo = saldos.get(i).getTipo() != null ? saldos.get(i).getTipo() : "";
                Double saldo = saldos.get(i).getSaldo();
                String dpi = saldos.get(i).getDpi() != null ? saldos.get(i).getDpi() : "";
                String nombre = saldos.get(i).getNombre() != null ? saldos.get(i).getNombre() : "";
                String apellido = saldos.get(i).getApellido() != null ? saldos.get(i).getApellido() : "";
                
                     
         
                
                switch (dato) {
                    case 0: { celdaDato.setCellValue(cuenta); break; }
                    case 1: { celdaDato.setCellValue(tipo); break; }
                    case 2: { celdaDato.setCellValue(saldo); break; } 
                    case 3: { celdaDato.setCellValue(dpi); break; } 
                    case 4: { celdaDato.setCellValue(nombre); break; } 
                    case 5: { celdaDato.setCellValue(apellido); break; } 
             
                }
                
                hoja.autoSizeColumn(dato);
                
            }
            
        }
        
        // Guardar el libro de trabajo en un archivo
        try (FileOutputStream fileOut = new FileOutputStream(nombreReporte)) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel Creado Correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el libro de trabajo
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}

   
