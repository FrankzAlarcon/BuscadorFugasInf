/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfugasinf;

import formularios.JfResultados;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTree;

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
        JfResultados jftabla = new JfResultados();
        long tiempoIncial = System.currentTimeMillis();
        //Fuerza bruta
        //Busqueda
        ArrayList<Persona> personasGmailByFB = getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByFB = getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        long tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        String resultados = "Resultados gmail\n";
        resultados += listaToString(personasGmailByFB);
        resultados += "Resultados yahoo";
        resultados += listaToString(personasYahooByFB);//No hay con yahoo 
        System.out.println(resultados);
        jftabla.setValoresFB(resultados);

        System.out.println("Tiempo de ejecucion con Fuerza bruta en ms es: " + tiempoFinal + "ms");
        String ocurrencias = personasGmailByFB.size() + " ocurrencias de gmail    " + personasYahooByFB.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatosLeaked("Fuerza Bruta ", tiempoFinal, ocurrencias);
        //KMP
        System.out.println("KMP");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByKMP = getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByKMP = getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail\n";
        resultados += listaToString(personasGmailByKMP);
        resultados += "Resultados yahoo\n";
        resultados += listaToString(personasYahooByKMP);
        jftabla.setValoresKMP(resultados);
        System.out.println(resultados);
        System.out.println("Tiempo de ejecucion con KMP en ms es: " + tiempoFinal + "ms");
        ocurrencias = personasGmailByKMP.size() + " ocurrencias de gmail    " + personasYahooByKMP.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatosLeaked("KMP ", tiempoFinal, ocurrencias);
        //BM
        System.out.println("BM");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByBM = getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "gmail");
        ArrayList<Persona> personasYahooByBM = getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "yahoo");
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail\n";
        resultados += listaToString(personasGmailByBM);
        resultados += "Resultados yahoo\n";
        resultados += listaToString(personasYahooByBM);
        jftabla.setValoresBM(resultados);
        System.out.println(resultados);
        System.out.println("Tiempo de ejecucion con BM en ms es: " + tiempoFinal + "ms");
        ocurrencias = personasGmailByBM.size() + " ocurrencias de gmail    " + personasYahooByBM.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatosLeaked("Boyer Moore ", tiempoFinal, ocurrencias);
        jftabla.setVisible(true);
    }

    private static String listaToString(ArrayList<Persona> lista) {
        String resultado = "";
        for (Persona persona : lista) {
            resultado += persona.toString() + "\n";
        }
        return resultado;
    }

    //ALGORTIMO FUERZA BRUTA
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

    //ALGORTIMO KMP
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

    //ALGORTIMO BM
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
