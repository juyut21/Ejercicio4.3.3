/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;


import static java.lang.Math.pow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class Lambda extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        //Creacion de botón, label y TextField
        Button btn1 = new Button("Calculate");
        Label label1 = new Label("Annual Interest Rate: ");
        Label label2 = new Label("Number of Years: ");
        Label label3 = new Label("Loan Amount: ");
        Label label4 = new Label("Monthly Payment: ");
        Label label5 = new Label("Total Payment: ");
        TextField texto1 = new TextField("");
        TextField texto2 = new TextField("");
        TextField texto3 = new TextField("");
        TextField texto4 = new TextField("");
        TextField texto5 = new TextField("");
        
        
        
        GridPane root = new GridPane();
        
        //Label
        
        root.add(label1, 2, 2);
        root.add(label2, 2, 3);
        root.add(label3, 2, 4);
        root.add(label4, 2, 5);
        root.add(label5, 2, 6);
        
        //TextField
        
        root.add(texto1, 3, 2);
        root.add(texto2, 3, 3);
        root.add(texto3, 3, 4);
        root.add(texto4, 3, 5);
        root.add(texto5, 3, 6);
        
        texto1.setAlignment(Pos.CENTER_RIGHT);
        texto2.setAlignment(Pos.CENTER_RIGHT);
        texto3.setAlignment(Pos.CENTER_RIGHT);
        texto4.setAlignment(Pos.CENTER_RIGHT);
        texto5.setAlignment(Pos.CENTER_RIGHT);
        
        //Bloquea el texto4 y texto 5 para no escribir en ellos
        texto4.setEditable(false);
        texto5.setEditable(false);
        
        //Botón
        root.add(btn1, 3, 7);
        
        
       
        
        btn1.setOnAction((ActionEvent event) -> {
              
            //Adigna variables a los distintos textos
            double i = Double.parseDouble(texto1.getText());
            double h = Double.parseDouble(texto3.getText());
            double n = Double.parseDouble(texto2.getText());
            
            //Formula que complementa a la principal
            double r = i / (100*12);
            
            //Formula para calcular Pago mensual
            double m = (h * r) / (1 - pow((1+r), (-12 * n)));
            
            //Asigna al texto4 el pago mensual
            texto4.setText(String.format("$" + "%.2f", m));
            
            //Calculo para el pago total
            double total = m * (n * 12);
            
            //Asigna al texto 5 el pago total
            texto5.setText(String.format("$" + "%.2f", total));
            
            
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Lambda Expresion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
