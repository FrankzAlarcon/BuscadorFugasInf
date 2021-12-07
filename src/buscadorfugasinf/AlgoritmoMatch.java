/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfugasinf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Frankz
 */
public class AlgoritmoMatch {

    public static int matcherFuerzabruta(String texto, String patron) {
        int longTexto = texto.length();
        int longPatron = patron.length();
        if (longPatron > longTexto) {
            return -1;
        }
        
        int indexPatron;
        for (int i = 0; i <= longTexto - longPatron; i++) {
            indexPatron = 0;
            while (indexPatron < longPatron && texto.charAt(i + indexPatron) == patron.charAt(indexPatron)) {
                indexPatron++;
            }
            if (indexPatron == longPatron) {
                return i;
            }
        }
        return -1;
    }

    private static int[] funcionFallo(String patron) {
        int longPatron = patron.length();
        int[] fail = new int[longPatron];
        int mainIndex = 1;
        int countRepetitionIndex = 0;
        while (mainIndex < longPatron) {
            if (patron.charAt(mainIndex) == patron.charAt(countRepetitionIndex)) {
                fail[mainIndex] = countRepetitionIndex + 1;
                countRepetitionIndex++;
                mainIndex++;
            } else if (countRepetitionIndex > 0) {
                countRepetitionIndex = fail[countRepetitionIndex - 1];
            } else {
                mainIndex++;
            }
        }
        return fail;
    }

    public static int matcherKMP(String texto, String patron) {
        int longTexto = texto.length();
        int longPatron = patron.length();
        int result = -1;
        if (longPatron == 0 || (longPatron > longTexto)) {
            return result;
        }
        int[] fail = funcionFallo(patron);
        int textIndex = 0;
        int patternIndex = 0;
        while (textIndex < longTexto) {
            if (texto.charAt(textIndex) == patron.charAt(patternIndex)) {
                if (patternIndex == (longPatron - 1)) {
                    return textIndex - longPatron + 1;                    
                }
                textIndex++;
                patternIndex++;
            } else if (patternIndex > 0) {
                patternIndex = fail[patternIndex - 1];
            } else {
                textIndex++;
            }
        }
        return result;
    }

    public static int matcherBoyerMoore(String texto, String patron) {
        int posicionCoincidencia = -1;
        //Longitudes del patron y del texto
        int n = texto.length();
        int m = patron.length();
        if (m == 0) {
            return posicionCoincidencia;//-1;
        }
        //Tabla D1
        Map<Character, Integer> vectorCaracteres = new HashMap<>();
        for (int i = 0; i < n; i++) {
            vectorCaracteres.put(texto.charAt(i), -1);
        }
        for (int i = 0; i < m; i++) {
            vectorCaracteres.put(patron.charAt(i), i);
        }

        int j = m - 1;
        int k = m - 1;

        while (j < n) {
            if (texto.charAt(j) == patron.charAt(k)) {
                if (k == 0) {
                    posicionCoincidencia = j;
                    return posicionCoincidencia;
                }
                j--;
                k--;
            } else {
                j += m - Math.min(k, 1 + vectorCaracteres.get(texto.charAt(j)));
                k = m - 1;
            }
        }
        return posicionCoincidencia;
    }
}
