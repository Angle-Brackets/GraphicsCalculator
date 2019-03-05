package GraphicsCalculator;

public class OperationCalculation{
	static int operationMode = 0;
	static boolean operationsActive = false;
	//0 means nothing, 1 is add, 2 is sub, 3 is multiply, 4 is divide, 5 is modulo, TRIG functions and square root do not have operationModes.
	//Means next input automatically goes to new set of numbers. (I.E. 5 + 4 as oppose to 5+4 resulting in 54)
	static boolean secondSetActive = false;
	public static String numbers1 = "";
	public static String numbers2 = "";
	public static String currentOperation = "";
	public static double displayValue = 0;
	public static int multiFunctionActive = 0; //0 = Off, 1 = On.
	
	public static void main(String[] args) {
		
	}
	
	public static String buttonDecider(String buttonID) {
		String numberSet = numbers1;
		if(secondSetActive == true) {
			numberSet = numbers2;
		}
	if(operationsActive != true) {
		if(buttonID == "0") {
			numberSet = numberSet+"0";
		}
		if(buttonID == "1") {
			numberSet = numberSet+"1";
		}
		if(buttonID == "2") {
			numberSet = numberSet+"2";
		}
		if(buttonID == "3") {
			numberSet = numberSet+"3";
		}
		if(buttonID == "4") {
			numberSet = numberSet+"4";
		}
		if(buttonID == "5") {
			numberSet = numberSet+"5";
		}
		if(buttonID == "6") {
			numberSet = numberSet+"6";
		}
		if(buttonID == "7") {
			numberSet = numberSet+"7";
		}
		if(buttonID == "8") {
			numberSet = numberSet+"8";
		}
		if(buttonID == "9") {
			numberSet = numberSet+"9";
		}
		if(buttonID == ".") {
			numberSet = numberSet+".";
		}
		if(buttonID == "+/-") {
			if(numberSet.contains("-")) {
				Double temp = Double.valueOf(numberSet);
				temp*=-1;
				numberSet = String.valueOf(temp);
			}
			else {
				numberSet = "-"+numberSet;
			}
		}
			
		if(buttonID == "x" || buttonID == "+" || buttonID == "-" || buttonID == "÷" || buttonID == "%" || buttonID == "√" || buttonID == "sin" || buttonID == "cos" || buttonID == "tan") {
			operationMode = -1;
			if(buttonID == "+") {
				operationMode = 1;
				currentOperation = "+";
			}
			if(buttonID == "-") {
				operationMode = 2;
				currentOperation = "-";
			}
			if(buttonID == "x") {
				operationMode = 3;
				currentOperation = "x";
			}
			if(buttonID == "÷") {
				operationMode = 4;
				currentOperation = "÷";
			}
			if(buttonID == "%") {
				operationMode = 5;
				currentOperation = "%";
			}
			if(buttonID == "√") {
				double tempVal = Math.sqrt(Double.valueOf(numbers1));
				System.out.println(Math.sqrt(Double.valueOf(numbers1))+", Done via square rooting "+numbers1);
				CalcInput.displayValue = String.valueOf(tempVal);
				operationsActive = true;
			}
			if(buttonID == "sin") {
				double tempVal = Math.sin(Double.valueOf(numbers1)); 
				System.out.println(Math.sin(Double.valueOf(numbers1))+", Done via calculating the sine ratio of: "+numbers1);
				CalcInput.displayValue = String.valueOf(tempVal);
				operationsActive = true;
			}
			if(buttonID == "cos") {
				double tempVal = Math.cos(Double.valueOf(numbers1));
				System.out.println(Math.cos(Double.valueOf(numbers1))+", Done via calculating the cos ratio of: "+numbers1);
				CalcInput.displayValue = String.valueOf(tempVal);
				operationsActive = true;
			}
			if(buttonID == "tan") {
				double tempVal = Math.tan(Double.valueOf(numbers1));
				System.out.println(Math.tan(Double.valueOf(numbers1))+", Done via calculating the tangent ratio of: "+numbers1);
				CalcInput.displayValue = String.valueOf(tempVal);
				operationsActive = true;
			}
		}
		
		if(operationMode > 0 &&  secondSetActive != true) {
			secondSetActive = true;
			numberSet = "";
		}
		
		if(secondSetActive != true) {
			numbers1 = numberSet;
		}
		else {
			numbers2 = numberSet;
		}
		
		
		if(buttonID == "=" && operationMode > 0 && secondSetActive == true) {
			if(numbers2 == "") {
				numbers2 = "0"; //Failsafe to not crash
			}
			operations(operationMode,1); //1 is a dummy value, no actual calculations done with it.
			operationsActive = true;
		}
	}
	if(buttonID == "ON/C") {
		numberSet = "";
		numbers1 = "";
		numbers2 = "";
		operationMode = 0;
		operationsActive = false;
		secondSetActive = false;
		CalcInput.displayValue = "0";
		multiFunctionActive = 0;
	}
		if(secondSetActive != true) {
			CalcInput.resultArea.setText(numberSet);
		}
		else {
			CalcInput.resultArea.setText(numbers1 + " "+ currentOperation + " " + numbers2);
		}
		
		return buttonID;
	}
	
	public static void operations(int mode, double result) {
		double newNumbers1 = Double.valueOf(numbers1);
		double newNumbers2 = Double.valueOf(numbers2);
		String type = "";
		
		if(mode == 1) {
			result = newNumbers1+newNumbers2;
			type = "Done via: "+numbers1+" + "+numbers2;
		}
		if(mode == 2) {
			result = newNumbers1-newNumbers2;
			type = "Done via: "+numbers1+" - "+numbers2;
		}
		if(mode == 3) {
			result = newNumbers1*newNumbers2;
			type = "Done via: "+numbers1+" x "+numbers2;
		}
		if(mode == 4) {
			result = newNumbers1/newNumbers2;
			type = "Done via: "+numbers1+" ÷ "+numbers2;
		}
		if(mode == 5) {
			result = newNumbers1%newNumbers2;
			type = "Done via: "+numbers1+" ÷ "+numbers2+" and taking the remainder";
		}
		System.out.println(result+", "+type);
		CalcInput.displayValue = String.valueOf(result);
		
	}
}
