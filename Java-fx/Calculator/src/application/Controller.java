package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable{
    @FXML Button button;
    @FXML TextField display;
    String op ="";
    double number1;
    double number2;
    public void Onclickbtn(ActionEvent event){
        String buttontxt = ((Button)event.getSource()).getText();
        display.setText(display.getText()+buttontxt);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    public void operation(ActionEvent event){
        String operationtxt = ((Button)event.getSource()).getText();
        if (!operationtxt.equals("=")){      
            if(!op.equals("")){
                return;
            }
            op = operationtxt;
            number1 = Double.parseDouble((display.getText()));
            display.setText("");
        }else {       
            if(op.equals("")){
                return;
            }
            number2 = Double.parseDouble((display.getText()));
            calculate(number1, number2, op);
            op="";
        }
    }
    public void clear(ActionEvent event){
    String buttontxt=((Button)event.getSource()).getText();
        if (buttontxt.equals("C")) {
                number1=0;
                number2=0;
                op="";
                display.setText("");
        }
    }
    public void calculate (Double n1, Double n2, String op){
        switch (op){
            case "mod": display.setText(n1%n2+"");break;
            case "+" : display.setText(n1 + n2 + "");break;
            case "-" : display.setText(n1 - n2 + "");break;
            case "*" : display.setText(n1 * n2 + "");break;
            case "/" : 
                if (n2 == 0){
                    display.setText("Error");break;
                }
            display.setText(n1/n2+ "");break;  
        }
    }
}
