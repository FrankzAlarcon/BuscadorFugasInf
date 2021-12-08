/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfugasinf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Frankz
 */
public class TestBuscador {
//hola
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        long tiempoIncial = System.currentTimeMillis();
        //Fuerza bruta
        System.out.println("Resultados gmail");
        //Busqueda
        ArrayList<Persona> personasGmailByFB = getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByFB = getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        long tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        personasGmailByFB.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Resultados yahoo");//No hay con yahoo        
        personasYahooByFB.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Tiempo de ejecucion con Fuerza bruta en ms es: " + tiempoFinal + "ms");
        System.out.println("Se encontraron un total de:\n" + personasGmailByFB.size() + " ocurrencias de gmail\n" + personasYahooByFB.size() + " ocurrencias de yahoo");        
        //KMP
        System.out.println("KMP");
        System.out.println("Resultados gmail");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByKMP = getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByKMP = getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        personasGmailByKMP.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Resultados yahoo");//No hay con yahoo        
        personasYahooByKMP.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Tiempo de ejecucion con KMP en ms es: " + tiempoFinal + "ms");
        System.out.println("Se encontraron un total de:\n" + personasGmailByKMP.size() + " ocurrencias de gmail\n" + personasYahooByKMP.size() + " ocurrencias de yahoo");
        //BM
        System.out.println("BM");
        System.out.println("Resultados gmail");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByBM = getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByBM = getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        personasGmailByBM.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Resultados yahoo");//No hay con yahoo        
        personasYahooByBM.forEach(persona -> {
            System.out.println(persona.toString());
        });        
        System.out.println("Tiempo de ejecucion con BM en ms es: " + tiempoFinal + "ms");
        System.out.println("Se encontraron un total de:\n" + personasGmailByBM.size() + " ocurrencias de gmail\n" + personasYahooByBM.size() + " ocurrencias de yahoo");
    }

    private static ArrayList<Persona> getDatosPorFB(String path, String patron) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;            
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                //System.out.println(Arrays.toString(datosPersona));
                if (AlgoritmoMatch.matcherFuerzabruta(datosPersona[3], patron) > -1) {
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
                linea = documento.readLine();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }       
        return personas;
    }
    private static ArrayList<Persona> getDatosPorKMP(String path, String patron) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;           
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                if (AlgoritmoMatch.matcherKMP(datosPersona[3], patron) > -1) {                    
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
                linea = documento.readLine();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return personas;
    }
    private static ArrayList<Persona> getDatosPorBM(String path, String patron) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;            
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                if (AlgoritmoMatch.matcherBoyerMoore(datosPersona[3], patron) > -1) {
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
                linea = documento.readLine();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return personas;
    }    
}
