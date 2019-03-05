package GraphicsCalculator;

import java.awt.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

//Finished By Ankit Joju on Monday May 21st, 2018 at 9:32AM.

public class CalcInput extends Frame implements ActionListener{
	public static String displayValue = "0";
	public static JTextArea resultArea = new JTextArea(2,16);
	public Button[] numButton = new Button[10];
	public CalcInput(){
		JPanel calcPanel = new JPanel();		//This is the code that displays values calculated.
		calcPanel.add(resultArea);
		calcPanel.setSize(195,180);
		calcPanel.setBounds(195,200,200,50);
		add(calcPanel);
		resultArea.setBorder(BorderFactory.createLineBorder(Color.black));
		calcPanel.setVisible(true);
		Button num0 = new Button("0");
		Button num1 = new Button("1");
		Button num2 = new Button("2");
		Button num3 = new Button("3");
		Button num4 = new Button("4");
		Button num5 = new Button("5");
		Button num6 = new Button("6");
		Button num7 = new Button("7");
		Button num8 = new Button("8");
		Button num9 = new Button("9");
		Button clear = new Button("ON/C");
		Button decimal = new Button(".");
		Button equal = new Button("=");
		Button add = new Button("+");
		Button subtract = new Button("-");
		Button multiply = new Button("x");
		Button divide = new Button("÷");
		Button modulo = new Button("%"); //Yeah I know its really percent, but modulo for fun :)
		Button inverse = new Button("+/-");
		Button squareRoot = new Button("√");
		Button sine = new Button("sin");
		Button cosine = new Button("cos");
		Button tangent = new Button("tan");
		
		/**Button debug = new Button("debug");
		//debug.setBounds(500,300,50,50);
		debug.addActionListener(this); 		Debug Button Code, only used when testing.
		add(debug);**/
		
		setSize(600,600);
		setTitle("Calculator");
		setLayout(null);
		setVisible(true);
		num0.setBounds(250,500,50,50);
		num1.setBounds(200,450,50,50);
		num2.setBounds(250,450,50,50);
		num3.setBounds(300,450,50,50);
		num4.setBounds(200,400,50,50);
		num5.setBounds(250,400,50,50);
		num6.setBounds(300,400,50,50);
		num7.setBounds(200,350,50,50);
		num8.setBounds(250,350,50,50);
		num9.setBounds(300,350,50,50);
		clear.setBounds(200,500,50,50);
		decimal.setBounds(300,500,50,50);
		equal.setBounds(350,450,50,100);
		add.setBounds(350,400,50,50);
		subtract.setBounds(350,350,50,50);
		multiply.setBounds(350,300,50,50);
		divide.setBounds(350,250,50,50);
		modulo.setBounds(300,250,50,50);
		inverse.setBounds(200,250,50,50);
		squareRoot.setBounds(250,250,50,50);
		sine.setBounds(200,300,50,50);
		cosine.setBounds(250,300,50,50);
		tangent.setBounds(300,300,50,50);
		add(num0);
		add(num1);
		add(num2);
		add(num3);
		add(num4);
		add(num5);
		add(num6);
		add(num7);
		add(num8);
		add(num9);
		add(clear);
		add(decimal);
		add(equal);
		add(add);
		add(subtract);
		add(multiply);
		add(divide);
		add(modulo);
		add(inverse);
		add(squareRoot);
		add(sine);
		add(cosine);
		add(tangent);
		resultArea.setEditable(false);
		num0.addActionListener(this);
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		equal.addActionListener(this);
		decimal.addActionListener(this);
		clear.addActionListener(this);
		modulo.addActionListener(this);
		inverse.addActionListener(this);
		squareRoot.addActionListener(this);
		sine.addActionListener(this);
		cosine.addActionListener(this);
		tangent.addActionListener(this);
		resultArea.setText("0");
	}
	
	public static void main(String[] args) {
		CalcInput fr = new CalcInput();
		fr.addWindowListener(new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);
		    }
		});
	}

	public void actionPerformed(ActionEvent actionEvent) {
		OperationCalculation.buttonDecider(actionEvent.getActionCommand());
		
		if(actionEvent.getActionCommand() == "=" && OperationCalculation.operationMode != -1) {
			resultArea.setText(OperationCalculation.numbers1 + " " + OperationCalculation.operationMode + " " + OperationCalculation.numbers2 + " = " + displayValue);
			multiFunction();
		}
		if(actionEvent.getActionCommand() == "tan" || actionEvent.getActionCommand() == "sin" || actionEvent.getActionCommand() == "cos" || actionEvent.getActionCommand() == "√") {
			resultArea.setText(displayValue);
		}
	}
	
	public static void multiFunction() {
		if(OperationCalculation.operationMode >= 1 || OperationCalculation.operationMode <= 5
				) {
			resultArea.setText("");
			OperationCalculation.numbers1 = displayValue;
			resultArea.setText(OperationCalculation.numbers1);
			OperationCalculation.numbers2 = "0";
			OperationCalculation.multiFunctionActive = 1;
			OperationCalculation.operationsActive = false;
			OperationCalculation.secondSetActive = false;
		}
	}	
}
