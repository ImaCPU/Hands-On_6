/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

public class MLR extends Agent{
    
    HelperArithmetic HA = new HelperArithmetic();
    boolean comando = HA.DoMLR();
    double [][] mlr = HA.getProducto();
       
   public void formula(){
       System.out.println(HA.getFormula());
       JOptionPane.showMessageDialog(null, HA.getFormula());
       
   }
   
   public void predict(){
        float x1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X1: "));
        float x2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X2: "));

        System.out.println("Prediccion: " +HA.prediccion(x1, x2));
        JOptionPane.showMessageDialog(null, "Prediccion: " +HA.prediccion(x1, x2));
    }
    
    @Override
   protected void setup (){
       System.out.println("Agent " + getLocalName() + " Started.");
       addBehaviour(new MyOneShotBehaviour());
   }
   
   public class MyOneShotBehaviour extends OneShotBehaviour{

    @Override
        public void action(){
            MLR mlr = new MLR();
            mlr.formula();
            mlr.predict();
            
        }
    
        @Override
        public int onEnd(){
            
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}