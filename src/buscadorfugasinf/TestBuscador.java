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
        ArrayList<Persona> personasGmailByFB = castingToPersona(getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByFB = castingToPersona(getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        long tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        String resultados = "Resultados gmail\n";
        resultados += personaToString(personasGmailByFB);
        resultados += "Resultados yahoo";
        resultados += personaToString(personasYahooByFB);//No hay con yahoo 
        System.out.println(resultados);
        jftabla.setValoresFB(resultados);

        System.out.println("Tiempo de ejecucion con Fuerza bruta en ms es: " + tiempoFinal + "ms");
        String ocurrencias = personasGmailByFB.size() + " ocurrencias de gmail    " + personasYahooByFB.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatos("Fuerza Bruta ", tiempoFinal, ocurrencias);
        //KMP
        System.out.println("KMP");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByKMP = castingToPersona(getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByKMP = castingToPersona(getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail\n";
        resultados += personaToString(personasGmailByKMP);
        resultados += "Resultados yahoo\n";
        resultados += personaToString(personasYahooByKMP);
        jftabla.setValoresKMP(resultados);
        System.out.println(resultados);
        System.out.println("Tiempo de ejecucion con KMP en ms es: " + tiempoFinal + "ms");
        ocurrencias = personasGmailByKMP.size() + " ocurrencias de gmail    " + personasYahooByKMP.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatos("KMP ", tiempoFinal, ocurrencias);
        //BM
        System.out.println("BM");
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByBM = castingToPersona(getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByBM = castingToPersona(getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail\n";
        resultados += personaToString(personasGmailByBM);
        resultados += "Resultados yahoo\n";
        resultados += personaToString(personasYahooByBM);
        jftabla.setValoresBM(resultados);
        System.out.println(resultados);
        System.out.println("Tiempo de ejecucion con BM en ms es: " + tiempoFinal + "ms");
        ocurrencias = personasGmailByBM.size() + " ocurrencias de gmail    " + personasYahooByBM.size() + " ocurrencias de yahoo";
        System.out.println(ocurrencias);
        jftabla.agregarDatos("Boyer Moore ", tiempoFinal, ocurrencias);
        jftabla.setVisible(true);
        //---------------------------------------------------------------------------//
        //Caso phiser
        ArrayList<Usuario> usuariosConAni = castingToUsuario(getDatosPorFB("src\\buscadorfugasinf\\phisher.txt", "ani", 2));
        ArrayList<Usuario> usuariosConLang = castingToUsuario(getDatosPorFB("src\\buscadorfugasinf\\phisher.txt", "lang", 2));
        System.out.println(usuarioToString(usuariosConAni));
    }

    private static String personaToString(ArrayList<Persona> lista) {
        String resultado = "";
        for (Persona persona : lista) {
            resultado += persona.toString() + "\n";
        }
        return resultado;
    }

    private static String usuarioToString(ArrayList<Usuario> lista) {
        String resultado = "dfsdfsd";
        for (Usuario usuario : lista) {
            resultado += usuario.toString() + "\n";
        }
        return resultado;
    }

    private static ArrayList<Persona> castingToPersona(ArrayList<Object> lista) {
        ArrayList<Persona> personas = new ArrayList<>();
        for (Object persona : lista) {
            if (persona instanceof Persona) {
                personas.add((Persona) persona);
            }
        }
        return personas;
    }

    private static ArrayList<Usuario> castingToUsuario(ArrayList<Object> lista) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Object usuario : lista) {
            if (usuario instanceof Persona) {
                usuarios.add((Usuario) usuario);
            }
        }
        return usuarios;
    }

    //ALGORTIMO FUERZA BRUTA
    private static ArrayList<Object> getDatosPorFB(String path, String patron, int tipo) {
        ArrayList<Object> item = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                    //System.out.println(Arrays.toString(datosPersona));
                    if (AlgoritmoMatch.matcherFuerzabruta(datosPersona[3], patron) > -1) {
                        item.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();                    
                }
            } else if (tipo == 2) {
                int contador = 0;
                String[] password = null;
                String[] email = null;
                int counter = 0;
                while(linea != null){
                    if(!linea.equals("")){
                        if(contador == 1){
                            password = linea.split("=");
                        }else if(contador == 0){
                            email = linea.split("=");
                        }                        
                        if(email != null && password != null && email.length == 2 && password.length == 2){      
                            System.out.println("creado");
                            item.add(new Usuario(email[1], password[1]));
                            System.out.println(item.get(counter).toString());
                            counter++;
                        }
                        contador++;
                        linea = documento.readLine();
                    } else {
                        contador = 0;
                        password = null;
                        email = null;
                        linea = documento.readLine();
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return item;
    }

    //ALGORTIMO KMP
    private static ArrayList<Object> getDatosPorKMP(String path, String patron, int tipo) {
        ArrayList<Object> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                    if (AlgoritmoMatch.matcherKMP(datosPersona[3], patron) > -1) {
                        personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();
                }
            } else if (tipo == 2) {

            }

        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return personas;
    }

    //ALGORTIMO BM
    private static ArrayList<Object> getDatosPorBM(String path, String patron, int tipo) {
        ArrayList<Object> personas = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                    if (AlgoritmoMatch.matcherBoyerMoore(datosPersona[3], patron) > -1) {
                        personas.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();
                }
            } else if (tipo == 2) {

            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return personas;
    }
}
