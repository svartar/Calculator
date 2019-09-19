package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private Button buttonUndo;
    @FXML
    private Button buttonClearEntry;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonPlusMinus;
    @FXML
    private Button buttonRoot;
    @FXML
    private Button buttonSplit;
    @FXML
    private Button buttonPercent;
    @FXML
    private Button buttonMultiply;
    @FXML
    private Button buttonInverse;
    @FXML
    private Button buttonSubtract;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEqual;
    @FXML
    private Button buttonDot;
    @FXML
    private Button buttonZero;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private TextField textFieldDisplay;

    private String displayTemp;
    private String sign;
    private boolean newAmount; //each push buttonEqual changes this variable to true, and push button like +, -, *, / etc. change to false
    //this variable is needed, becouse without it after push buttonEqual and next push any of buttoNambers, You get new amount that look in this way: if old amount is 15 (it's a result obtainted
    //from previously action and push buttonEqual), and new amount is 5, You'll get 155 instead of 5.

    @FXML
    public void initialize(){
        displayTemp = "";
        sign = "";
        textFieldDisplay.setText("");
        newAmount=false;
    }

    @FXML
    public void undo(){
        if(!textFieldDisplay.getText().equals("")){
            int length = textFieldDisplay.getText().length();
            textFieldDisplay.setText(textFieldDisplay.getText().substring(0,length-1));
        }
    }
    @FXML
    public void absoluteValue(){
        if(!textFieldDisplay.getText().equals("")&&textFieldDisplay.getText().charAt(0) == '-'){
            textFieldDisplay.setText(textFieldDisplay.getText().substring(1));
            newAmount = true;
        }
    }
    @FXML
    public void clear(){
        initialize();
    }
    @FXML
    public void plusMinus(){
        if (textFieldDisplay.getText().equals("")) {
            textFieldDisplay.setText("-");
        }
        else if (textFieldDisplay.getText().charAt(0) == '-') {
            textFieldDisplay.setText(textFieldDisplay.getText().substring(1));
        }
        else {
            textFieldDisplay.setText("-" + textFieldDisplay.getText());
        }
    }
    @FXML
    public void root(){
        if(!textFieldDisplay.getText().equals("")){
            double amount = Double.parseDouble(textFieldDisplay.getText());
            double result = Math.sqrt(amount);
            textFieldDisplay.setText(Double.toString(result));
            newAmount = true;
        }
    }
    @FXML
    public void split(){
        action();
        sign="/";
        newAmount = false;
    }
    @FXML
    public void percent(){
        double result;
        if(sign.equals("+")||sign.equals("-")){
            result = (Double.parseDouble(displayTemp))*(Double.parseDouble(textFieldDisplay.getText()))/100;
        }
        else if(sign.equals("*")||sign.equals("/")){
            result = Double.parseDouble(textFieldDisplay.getText())/100;
        }
        else{
            result = Double.parseDouble(textFieldDisplay.getText())/100;
        }
        textFieldDisplay.setText(Double.toString(result));
        equal();
    }
    @FXML
    public void multiply(){
        action();
        sign="*";
        newAmount = false;
    }
    @FXML
    public void inverse(){
        if(!textFieldDisplay.getText().equals("")){
            double result = 1/(Double.parseDouble(textFieldDisplay.getText()));
            textFieldDisplay.setText(Double.toString(result));
            newAmount = true;
        }
    }
    @FXML
    public void subtract(){
        action();
        sign="-";
        newAmount = false;
    }
    @FXML
    public void add(){
        action();
        sign="+";
        newAmount = false;
    }
    @FXML
    public void equal(){
        if(displayTemp.equals("")||textFieldDisplay.getText().equals("")){
            //do nothing
        }
        else {
            double result;
            if (sign.equals("+")) {
                result = Double.parseDouble(displayTemp) + Double.parseDouble(textFieldDisplay.getText());
                showResult(result);
            } else if (sign.equals("-")) {
                result = Double.parseDouble(displayTemp) - Double.parseDouble(textFieldDisplay.getText());
                showResult(result);
            } else if (sign.equals("*")) {
                result = Double.parseDouble(displayTemp) * Double.parseDouble(textFieldDisplay.getText());
                showResult(result);
            } else if (sign.equals("/")) {
                result = Double.parseDouble(displayTemp) / Double.parseDouble(textFieldDisplay.getText());
                showResult(result);
            }
        }
    }
    @FXML
    public void dot(){
        if(textFieldDisplay.getText().contains(".")){
            //do nothing becouse You can't have two dots
        }
        else if(textFieldDisplay.getText().equals("")){
            textFieldDisplay.setText(textFieldDisplay.getText()+"0.");
        }
        else{
            textFieldDisplay.setText(textFieldDisplay.getText()+".");
        }
    }
    @FXML
    public void zero(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"0");
    }
    @FXML
    public void one(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"1");
    }
    @FXML
    public void two(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"2");
    }
    @FXML
    public void three(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"3");
    }
    @FXML
    public void four(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"4");
    }
    @FXML
    public void five(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"5");
    }
    @FXML
    public void six(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"6");
    }
    @FXML
    public void seven(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"7");
    }
    @FXML
    public void eight(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"8");
    }
    @FXML
    public void nine(){
        check();
        textFieldDisplay.setText(textFieldDisplay.getText()+"9");
    }
    public void action(){
        if(sign.equals("+")||sign.equals("-")||sign.equals("*")||sign.equals("/")){
            equal();
        }
        else{
            displayTemp = textFieldDisplay.getText();
            textFieldDisplay.setText("");
        }
    }
    public void check(){
        if(newAmount){
            initialize();
        }
    }
    public void showResult(double result){
        displayTemp = Double.toString(result);
        textFieldDisplay.setText(Double.toString(result));
        sign = "";
        newAmount = true;
    }

}
