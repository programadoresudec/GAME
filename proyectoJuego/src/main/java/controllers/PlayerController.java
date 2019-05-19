
package controllers;
// Importanmos con * para llamar todas las librerias dependiendo si es un swing o awt o awt.event.
import java.awt.event.*;
// se importa libreria io para utilizar ficheros.
import java.io.*;
import javax.swing.*;
//Se importan las librerías de java.util.* donde se concentran la mayor parte de las Clases del "Collection Framework". 
import java.util.*;
import models.Player;
import views.PlayerView;


public class PlayerController implements ActionListener
{
    private ArrayList<Player> listPlayer;
    private PlayerView view;

    public PlayerController(ArrayList<Player> listPlayer, PlayerView view) 
    {
        //the objects are matched with the parameters
        this.listPlayer = listPlayer;
        this.view = view;
        // the button is implemented to work.
        this.view.btnRegister.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource() == view.btnRegister)
       {
           // we send parameters to the add method to save what is written in the text boxes.
           addData(view.inputName.getText(),view.inputCountry.getText());
           saveFile();
       }
    }

    private void addData(String namePlayer, String countryPlayer)
    {
       listPlayer.add(new Player(namePlayer, countryPlayer));
       System.out.println("Se ha agregado el jugador satisfactoriamente.");
       // it's called the method.
       cleanBoxes();
    }
    // method to clean jtexfield panel.
    private void cleanBoxes() 
    {
        JTextField texBox;
        for (int i = 0; i < view.getComponentCount(); i++) 
        {
            if (view.getComponent(i).getClass().getName().equals("javax.swing.JTextField"))
            {
                texBox = (JTextField)view.getComponent(i);
                texBox.setText("");
            }
        }
    }
     public void saveFile()
    {
         BufferedWriter bw = null;
         FileWriter fw = null;
         try 
         {
            System.out.println("Escribiendo en archivo");
            File file = new File("src/main/resources/file/jugadores.txt");
            // If the file does not exist, it is created!
            if (!file.exists())
            {
                file.createNewFile();
            }
            // flag true, Indicates attach information to the file.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for(Player elemento: listPlayer)
                {
                    bw.write("\n" + elemento.toString());
                }
            System.out.println("información agregada!");
         } 
         catch (IOException e)
         {
             e.printStackTrace();
         } 
         finally
         {
             try 
             {
                //Close instances of FileWriter and BufferedWriter
                if (bw != null)
                {
                    bw.close();
                }
                    
                if (fw != null)
                {
                    fw.close();
                }  
             }
             catch (IOException ex)
             {
                 ex.printStackTrace();
             }
         } 
    }
}

