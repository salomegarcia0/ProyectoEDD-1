/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author Alejandra Oporto
 */
public class Validaciones {
    
  /**
     * Método privado que verifica si una cadena contiene solo números.
     *
     * @param cadena La cadena que se va a validar.
     * @return true si la cadena solo contiene números, false en caso contrario.
     */
    private boolean verificarNumeros(String cadena) {
        // Usamos una expresión regular para comprobar si la cadena consiste únicamente en dígitos
        return cadena.matches("[0-9]*");
    }
    
    /**
     * Método público que valida un número en formato de cadena y lo convierte a entero.
     *
     * @param entrada La cadena que representa el número a validar.
     * @return El número como un entero si es válido; -1 si la cadena no es un número válido.
     */
    public int validarEntrada(String entrada) {
        // Verificamos si la cadena es un número válido
        if (verificarNumeros(entrada)) {
            // Si es válido, convertimos la cadena a un entero
            int numeroEntero = Integer.parseInt(entrada);
            return numeroEntero; // Retornamos el número entero
        } else {
            // Si no es válido, retornamos -1 como indicador de error
            return -1;
        }
    }
}


