/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplelinearregression;

import jade.core.Agent;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author Omar Israel Navarro Oliva
 * Simulacion 
 * 10 de Octubre del 2021
 * 
 */

public class MultipleLinearRegression extends Agent{
    public void setup(){
        MLR tabla= new MLR();
        
        String num = JOptionPane.showInputDialog(null,"Cuantos Registros tiene X?");
        int ValorXren=Integer.parseInt(num);
        num = JOptionPane.showInputDialog(null,"Cuantas Columnas tiene X?");
        int ValorXcol=Integer.parseInt(num);
                
        num = JOptionPane.showInputDialog(null,"Cuantos Registros tiene Y?");
        int ValorY=Integer.parseInt(num);
        
        tabla.MatrizX(ValorXren, ValorXcol);
        tabla.MatrizY(ValorY);
        
        for (int i=0; i<=ValorXren-1; i++){
            tabla.NRegistroX(i);
        }
        
        tabla.NRegistroY();
        
        
        tabla.DoMLR();
        JOptionPane.showMessageDialog(null, tabla.getFormula());
        
        num = JOptionPane.showInputDialog(null,"Predicción: "+tabla.getFormula()+"\n X1=");
        float x1=Float.parseFloat(num);
        num = JOptionPane.showInputDialog(null,"Predicción: "+tabla.getFormula()+"\n X2=");
        float x2=Float.parseFloat(num);
        
        JOptionPane.showMessageDialog(null,"Predicción: "+tabla.getFormula()+
                "\n X1="+x1+" X2="+x2+" "+tabla.prediccion(x1, x2));
        System.out.print(tabla.getFormula());
        System.out.print(tabla.prediccion(x1, x2));
    }
}
//String.format("%.3f",x[i][j])