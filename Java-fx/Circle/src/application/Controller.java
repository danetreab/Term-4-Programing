package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {
	@FXML
	private Circle mycircle;
	private double x;
	private double y;
    public void up(ActionEvent e){
        System.out.println("up");
        mycircle.setCenterY(y=y-1);
    }
    public void down(ActionEvent e){
        System.out.println("down");
        mycircle.setCenterY(y=y+1);
    }
    public void right(ActionEvent e){
        System.out.println("right");
        mycircle.setCenterX(x+=1);
    }
    public void left(ActionEvent e){
        System.out.println("left");
        mycircle.setCenterX(x-=1);
    }
}
