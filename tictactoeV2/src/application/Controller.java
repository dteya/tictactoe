package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text Text;
    

    @FXML
    void resetGame(ActionEvent event) {
    	ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
    	
    	buttons.forEach(button -> {
    		button.setDisable(false);
    		button.setText("");
    	});
    	
    	Text.setText("Tic-Tac-Toe");
    }

    
    @FXML
    void handleButtonClick(ActionEvent event) {
    	
    	ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
    	
    	Button pButton = (Button) event.getTarget();
    	pButton.setText("X");
    	pButton.setDisable(true);
    	checkIfGameIsOver();
    	
    	buttons.remove(pButton);
    	
    	while (true) {
    		int index = (int)(Math.random() * buttons.size());
        	
        	Button cButton = buttons.get(index);
        	
        	if (cButton.getText().isEmpty()) {
        		cButton.setText("O");
            	cButton.setDisable(true);
            	checkIfGameIsOver();
            	buttons.remove(cButton);
            	break;
        	}
        	
    	}
    	
    	
    }
    
    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                Text.setText("Player won!");
                disableAllButtons();
            }

            //O winner
            else if (line.equals("OOO")) {
                Text.setText("Comp won!");
                disableAllButtons();
            }
            
        }
        
        //Draw
        if (gridIsFull()) {
        	Text.setText("Draw");
        	disableAllButtons();
        }
    }
    
    public boolean gridIsFull() {
    	
    	ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
    	
    	int i = 0; 
    	
    	for (Button button : buttons) {
    		if (button.isDisabled()) {
    			i++;
    		}
    	}
    	
    	if (i == buttons.size() - 1) {
    		return true;
    	}
    	
    	return false;
    }
    
    public void disableAllButtons() {
    	ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
    	
    	buttons.forEach(button -> {
    		button.setDisable(true);
    	});
    	
    }

}
