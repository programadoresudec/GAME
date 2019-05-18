package controllers;

import java.util.Random;
import javax.swing.JOptionPane;

public class Questions {
    int option;
    boolean bandera=true;
    String answer;
    int punctuation=0;
    
    public void easy(){
     
        while (bandera == true){
            Random aleatorio = new Random();
            option = 1+ aleatorio.nextInt(10);
        
        switch(option){
            case 1:
                answer = JOptionPane.showInputDialog("¿Cual es el unico metodo que se llama igual que la clase?\n "
                        + "a. Metodo abstracto\n"
                        + "b. Constructor\n"
                        + "c. Clase\n"
                        + "d. Abstracción\n");
                if ("b".equals(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 2:
                answer = JOptionPane.showInputDialog("¿Qué es POO?\n "
                        + "a. Un modelo de programación\n"
                        + "b. Un metodo\n"
                        + "c. Un tipo de variable\n"
                        + "d. Una devisión de la Programación orientada a objetos\n");
                if ("a".equals(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 3:
                answer = JOptionPane.showInputDialog("¿Qué es polimorfismo?\n "
                        + "a. Usar los atributos de la clase padre\n"
                        + "b. Mismo método diferentes atributos\n"
                        + "c. Mismo método diferente implementación\n"
                        + "d. Ninguna de las anteriores\n");
                if ("c".equals(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 4:
                answer = JOptionPane.showInputDialog("¿Que es NetBeans?\n "
                        + "a. Metodo abstrapto\n"
                        + "b. Constructor\n"
                        + "c. Clase\n"
                        + "d. Ninguna de las anteriores\n");
                if ("d".equals(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 5:
                answer = JOptionPane.showInputDialog("¿Para usar los botones que clase debo heredar?\n "
                        + "a. arrayList\n"
                        + "b. actionListener\n"
                        + "c. override\n"
                        + "d. Ninguna\n");
                if ("b".equals(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 6:
                answer="   ";
                JOptionPane.showMessageDialog(null, "Complete el siguiente metodo\n"
                        + "Public double miltiplicacion(){\n"
                        + "\t\tdouble numero1, numero2;\n"
                        + "\t\tReturn"+ answer 
                        + ";\n}");
                 answer=JOptionPane.showInputDialog("Ingrese su respuesta");
                if ("numero1*numero2".equals(answer)) {
                    JOptionPane.showMessageDialog(null,"Public double miltiplicacion(){\n"
                        + "\t\tdouble numero1, numero2;\n"
                        + "\t\tReturn "+ answer 
                        + ";\n}");
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 7:
                answer = JOptionPane.showInputDialog("Corrija el error\n "
                        + "public void tamaño(){\n"
                        + "\t\tint largo, ancho tamaño;\n"
                        + "\t\ttamaño = ancho * largo;\n}"
                        + "El metodo anterior tiene un error corrijalo");
                if ("tamanio".equals(answer)||"respuesta".equals(answer)) {
                    JOptionPane.showMessageDialog(null,"public void tamaño(){\n"
                        + "\t\tint largo, ancho tamaño;\n"
                        + "\t\t"+answer+" = ancho * largo;\n}"
                        + "\nEl metodo anterior tiene un error corrijalo");
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 8:
                answer = JOptionPane.showInputDialog("Escriba la signatura para el siguiente metodo "
                        + "que retorna el area de un circulo\n"
                        + "(){\n"
                        + "\t\tdouble PI=3.1416, radio;\n"
                        + "\t\tReturn (2*pi)*radio;"
                        + "\n}");
                if ("public double areaCirculo".equals(answer)) {
                    JOptionPane.showMessageDialog(null,answer+"(){\n"
                        + "\t\tdouble PI=3.1416, radio;\n"
                        + "\t\tReturn (2*pi)*radio;"
                        + "\n}");
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 9:
                answer = JOptionPane.showInputDialog("¿Cual es el interprete de Java? \n ");
                if ("java".equalsIgnoreCase(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
            case 10:
                answer = JOptionPane.showInputDialog("¿Cual es el interprete de java?\n ");
                if ("javaC".equalsIgnoreCase(answer)) {
                    punctuation ++;
                    bandera= true;
                    JOptionPane.showMessageDialog(null, "Respuesta correcta puntuación " + punctuation + "puntos" );
                }else{
                    punctuation --;
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta puntuación " + punctuation + "puntos" );
                    bandera = false;
                }
                break;
                
        }//case
        }//while
    }//faciles
}//Questions
