/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfugasinf;

/**
 *
 * @author Frankz
 */
public class Persona {
    private String nombres;//1
    private String apellidos;//2
    private String email;//3
    
    public Persona(String nombres, String apellidos, String email){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombres + ", Apellido=" + apellidos + ", email=" + email;
    }
    
}
