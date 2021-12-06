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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(AlgoritmoMatch.matcherKMP("zBACDCABACFJABACJFBDSIFDBSABACDCABACFJABACFNSDIFSDABACDCABACFJABACJFNSDIF", "ABACDCABACFJABAC"));
    }

    private static ArrayList<Persona> getDatosPorFB(String path, String patron) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            boolean existePatron;
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                if (AlgoritmoMatch.matcherFuerzabruta(datosPersona[2], patron) > -1) {
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
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
            boolean existePatron;
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                if (AlgoritmoMatch.matcherKMP(datosPersona[2], patron) > -1) {
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
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
            boolean existePatron;
            while (linea != null) {
                datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                if (AlgoritmoMatch.matcherBoyerMoore(datosPersona[2], patron) > -1) {
                    personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return personas;
    }    
}
