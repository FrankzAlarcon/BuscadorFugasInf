package buscadorfugasinf;

import formularios.JfResultados;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Frankz el demoledor
 */
public class TestBuscador {

    public static void main(String[] args) {
        JfResultados jftabla = new JfResultados(); //Inicializamos el formulario grafico        
        //Leaked Data
        //Fuerza bruta
        long tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByFB = castingToPersona(getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByFB = castingToPersona(getDatosPorFB("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        long tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        String resultados = "Resultados gmail:\n" + personaToString(personasGmailByFB);
        resultados += "Resultados yahoo:" + personaToString(personasYahooByFB);//No hay con yahoo
        //Valores a agregar en la interfaz grafica
        String ocurrencias = personasGmailByFB.size() + " ocurrencias de gmail  ||  " + personasYahooByFB.size() + " ocurrencias de yahoo";
        jftabla.setValoresFB(resultados); //Establecemos los resultados en el formulario
        jftabla.agregarDatosLeaked("Fuerza Bruta ", tiempoFinal, ocurrencias);

        //KMP
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Persona> personasGmailByKMP = castingToPersona(getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByKMP = castingToPersona(getDatosPorKMP("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail: \n" + personaToString(personasGmailByKMP);
        resultados += "Resultados yahoo\n" + personaToString(personasYahooByKMP);
        //Valores a agregar en la interfaz grafica
        ocurrencias = personasGmailByKMP.size() + " ocurrencias de gmail  ||  " + personasYahooByKMP.size() + " ocurrencias de yahoo";
        jftabla.setValoresKMP(resultados);
        jftabla.agregarDatosLeaked("KMP ", tiempoFinal, ocurrencias);

        //BM
        //Busqueda
        tiempoIncial = System.currentTimeMillis();
        //La siguientes lineas almacenan un objeto de tipo persona en un arraylist, pasando por un cast del los objetos de la lita recibida del metodo
        //de busqueda por Booyer Moore
        ArrayList<Persona> personasGmailByBM = castingToPersona(getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "gmail", 1));
        ArrayList<Persona> personasYahooByBM = castingToPersona(getDatosPorBM("src\\buscadorfugasinf\\LeakedData.txt", "yahoo", 1));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resutados
        resultados = "Resultados gmail\n" + personaToString(personasGmailByBM);
        resultados += "Resultados yahoo\n" + personaToString(personasYahooByBM);
        //Valores a agregar en la interfaz grafica
        ocurrencias = personasGmailByBM.size() + " ocurrencias de gmail  ||  " + personasYahooByBM.size() + " ocurrencias de yahoo";
        jftabla.setValoresBM(resultados);
        jftabla.agregarDatosLeaked("Boyer Moore ", tiempoFinal, ocurrencias);

        //Hacer visible el formulario de la interfaz grafica
        jftabla.setVisible(true);
//------------------------------------------------------------------------------------------------------------------------------------------------//
        //CASO PHISHER
        //Fuerza Bruta
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Usuario> usuariosConAniByFB = castingToUsuario(getDatosPorFB("src\\buscadorfugasinf\\phisher.txt", "ani", 2));
        ArrayList<Usuario> usuariosConLangByFB = castingToUsuario(getDatosPorFB("src\\buscadorfugasinf\\phisher.txt", "lang", 2));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resultados
        resultados = "Usuarios con \"ani\" en email y/o password:\n" + usuarioToString(usuariosConAniByFB);
        resultados += "Usuarios con \"lang\" en email y/o password:\n" + usuarioToString(usuariosConLangByFB);
        //Valores a agregar en la interfaz grafica
        ocurrencias = usuariosConAniByFB.size() + " ocurrencias con \"ani\"  || " + usuariosConLangByFB.size() + " ocurrencias con \"lang\"";
        jftabla.setValoresFB2(resultados);
        jftabla.agregarDatosPhisher("Fuerza Bruta ", tiempoFinal, ocurrencias);

        //KMP
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Usuario> usuariosConAniByKMP = castingToUsuario(getDatosPorKMP("src\\buscadorfugasinf\\phisher.txt", "ani", 2));
        ArrayList<Usuario> usuariosConLangByKMP = castingToUsuario(getDatosPorKMP("src\\buscadorfugasinf\\phisher.txt", "lang", 2));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resultados
        resultados = "Usuarios con \"ani\" en email y/o password: \n" + usuarioToString(usuariosConAniByKMP);
        resultados += "Usuarios con \"lang\" en email y/o password\n" + usuarioToString(usuariosConLangByKMP);
        //Valores a agregar en la interfaz grafica
        ocurrencias = usuariosConAniByKMP.size() + " ocurrencias con \"ani\"  || " + usuariosConLangByKMP.size() + " ocurrencias con \"lang\"";
        jftabla.setValoresKMP2(resultados);
        jftabla.agregarDatosPhisher("KMP ", tiempoFinal, ocurrencias);

        //BM
        tiempoIncial = System.currentTimeMillis();
        ArrayList<Usuario> usuariosConAniByBM = castingToUsuario(getDatosPorBM("src\\buscadorfugasinf\\phisher.txt", "ani", 2));
        ArrayList<Usuario> usuariosConLangByBM = castingToUsuario(getDatosPorBM("src\\buscadorfugasinf\\phisher.txt", "lang", 2));
        tiempoFinal = System.currentTimeMillis() - tiempoIncial;
        //Impresion de resultados
        resultados = "Usuarios con \"ani\" en email y/o password\n" + usuarioToString(usuariosConAniByBM);
        resultados += "Usuarios con \"lang\" en email y/o password\n" + usuarioToString(usuariosConLangByBM);
        //Valores a agregar en la interfaz grafica
        ocurrencias = usuariosConAniByBM.size() + " ocurrencias con \"ani\"  || " + usuariosConLangByBM.size() + " ocurrencias con \"lang\"";
        jftabla.setValoresBM2(resultados);
        jftabla.agregarDatosPhisher("Booyer Moore ", tiempoFinal, ocurrencias);

    }

    //Metodo para devolver un String con todos los datos de la lista de Persona recibida
    private static String personaToString(ArrayList<Persona> lista) {
        String resultado = "";
        for (Persona persona : lista) {
            resultado += persona.toString() + "\n";
        }
        return resultado;
    }

    //Metodo para devolver un String con todos los datos de la lista de usuarios recibida
    private static String usuarioToString(ArrayList<Usuario> lista) {
        String resultado = "";
        for (Usuario usuario : lista) {
            resultado += usuario.toString() + "\n";
        }
        return resultado;
    }

    //Metodo para realizar un casting desde una lista de OBJETOS a una lista de PERSONAS
    private static ArrayList<Persona> castingToPersona(ArrayList<Object> lista) {
        ArrayList<Persona> personas = new ArrayList<>();
        for (Object persona : lista) {
            if (persona instanceof Persona) {
                //Anade objetos de tipo Persona desde la lista de tipo Object recibida haciendo un casting de cada uno hacia la nueva lista de tipo Personas.
                personas.add((Persona) persona);
            }
        }
        return personas;
    }

    //Metodo para realizar un casting desde una lista de OBJETOS a una lista de USUARIOS
    private static ArrayList<Usuario> castingToUsuario(ArrayList<Object> lista) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Object usuario : lista) {
            if (usuario instanceof Usuario) {
                //Anade objetos de tipo Usuario desde la lista de tipo Object recibida haciendo un casting de cada uno hacia la nueva lista
                usuarios.add((Usuario) usuario);
            }
        }
        return usuarios;
    }

    //ALGORTIMO FUERZA BRUTA
    private static ArrayList<Object> getDatosPorFB(String path, String patron, int tipo) {
        ArrayList<Object> items = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//0:codigo,1:nombres,2:apellidos,3:email
                    if (AlgoritmoMatch.matcherFuerzabruta(datosPersona[3], patron) > -1) {
                        items.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();
                }
            } else if (tipo == 2) {
                int contador = 0;
                String[] password = null;
                String[] email = null;
                while (linea != null) {
                    if (!linea.equals("")) {
                        if (contador == 1) {
                            password = linea.split("=");//0:palabra,1:password
                        } else if (contador == 0) {
                            email = linea.split("=");//0:palabra,1:email
                        }
                        if (email != null && password != null && email.length == 2 && password.length == 2) {
                            if (AlgoritmoMatch.matcherFuerzabruta(email[1], patron) > -1 || AlgoritmoMatch.matcherFuerzabruta(password[1], patron) > -1) {
                                items.add(new Usuario(email[1], password[1]));
                            }

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
        return items;
    }

    //ALGORTIMO KMP
    private static ArrayList<Object> getDatosPorKMP(String path, String patron, int tipo) {
        ArrayList<Object> items = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                    if (AlgoritmoMatch.matcherKMP(datosPersona[3], patron) > -1) {
                        items.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();
                }
            } else if (tipo == 2) {
                int contador = 0;
                String[] password = null;
                String[] email = null;
                while (linea != null) {
                    if (!linea.equals("")) {
                        if (contador == 1) {
                            password = linea.split("=");
                        } else if (contador == 0) {
                            email = linea.split("=");
                        }
                        if (email != null && password != null && email.length == 2 && password.length == 2) {
                            if (AlgoritmoMatch.matcherKMP(email[1], patron) > -1 || AlgoritmoMatch.matcherKMP(password[1], patron) > -1) {
                                items.add(new Usuario(email[1], password[1]));
                            }

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

        return items;
    }

    //ALGORTIMO BM
    private static ArrayList<Object> getDatosPorBM(String path, String patron, int tipo) {
        ArrayList<Object> items = new ArrayList<>();
        try {
            BufferedReader documento = new BufferedReader(new FileReader(new File(path)));
            String linea = documento.readLine();
            String[] datosPersona;
            if (tipo == 1) {
                while (linea != null) {
                    datosPersona = linea.split(",");//1:nombres,2:apellidos,3:email
                    if (AlgoritmoMatch.matcherBoyerMoore(datosPersona[3], patron) > -1) {
                        items.add(new Persona(datosPersona[1], datosPersona[2], datosPersona[3]));
                    }
                    linea = documento.readLine();
                }
            } else if (tipo == 2) {
                int contador = 0;
                String[] password = null;
                String[] email = null;
                while (linea != null) {
                    if (!linea.equals("")) {
                        if (contador == 1) {
                            password = linea.split("=");
                        } else if (contador == 0) {
                            email = linea.split("=");
                        }
                        if (email != null && password != null && email.length == 2 && password.length == 2) {
                            if (AlgoritmoMatch.matcherBoyerMoore(email[1], patron) > -1 || AlgoritmoMatch.matcherBoyerMoore(password[1], patron) > -1) {
                                items.add(new Usuario(email[1], password[1]));
                            }

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

        return items;
    }
}
