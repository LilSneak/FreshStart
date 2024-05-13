package InfixExpCalc;

import java.util.Stack;

public class InfixCalculator {
	
	public int evaluateInfix(String expression){
		
		Stack<Integer> Operands = new Stack<Integer>(); //Stack for the numbers or operands
		Stack<Character> Operators = new Stack<Character>(); //Stack for the operators (* + - / %)
		
		char [] exp = expression.toCharArray();//Putting the expression into an array to easily iterate through it
		
		int numOfOpeners= 0; //Used to see if any parentheses are present
		int numOfClosers = 0;
		int numOf1Levels = 0;
		int numOf2Levels = 0;
		
		try {
			for(char c : exp) {//Loop to see how many operators of the same level and brackets there are
				if (c == '+' || c == '-') {
					numOf1Levels++;
				}
				else if(c == '*' || c == '/' || c == '%') {
					numOf2Levels++;
				}
				else if(c == '(') {
					numOfOpeners++;
				}
				else if (c == ')') {
					numOfClosers++;
				}
			}
			
			if (numOf1Levels > 0 && numOf2Levels > 0) {//If expression contains operators of 2 different levels or priorities it requires the use of parentheses
				if (numOfOpeners == 0 && numOfClosers == 0) {//No parentheses when needed
					throw new Exception ("Invalid Expression. Missing Parentheses");
				}
				else if(numOfOpeners != numOfClosers) {//Uneven amount of parentheses
					throw new Exception("Invalid Expression. Unbalanced Brackets");
				}
			}
			if (numOfOpeners == numOfClosers){//if no brackets needed or an even amount of brackets continue to evaluate
				for(int i = 0; i < exp.length; i++) {//iterating through expression
					char currentChar = exp[i];
			
					if(Character.isDigit(currentChar)) {//if the current character is a #
						int num = 0;
				
						//this while loop handles the multidigit possibility
						while(i < exp.length && Character.isDigit(exp[i])) {//Loops as long as we aren't at the end of the expression and the current character is a #
					
							//If there is another digit this expressions increases the current number by moving its decimal place by *10 then adding the subsequent digit
							num = num * 10 + (exp[i] - '0'); 
					
							i++; //this increases i to continue through the loop to see if there is another digit of this number
						}
						i--; //After exiting the multidigit loop we return i to the value where we get the next character after the digit.
				
						Operands.push(num); //Pushing num to the stack of numbers(operands)
					}
					else if(currentChar == ' ') {//If a space is encountered, move on to next character
						i++;
					}
					else if(currentChar == '(') {//Opening bracket automatically gets pushed
						Operators.push(currentChar);
					}
					else if(currentChar == ')') {//Calculate expression within brackets
						if(Operators.contains('(')){
							while(Operators.peek() != '(') {//There has to be an operator between opening and closing brackets. And Opening brackets has to exist
								
								int ans = calculate(Operands, Operators);
								if (ans == -1) {
									throw new Exception ("Invalide Expression");
								}
								Operands.push(ans);
							}
						Operators.pop();
						}
						else {
							throw new Exception ("Invalid Expression. No opening brackets in expression");
						}
					}
					else if(validOperator(currentChar)) {
						while(!Operators.isEmpty() && pemdas(currentChar) <= pemdas(Operators.peek())) {//If Operator is of lower order than top operator then expression within stack should be calculated
						
							int ans = calculate(Operands, Operators);
							if (ans == -1) {
								throw new Exception ("Invalide Expression");
							}
							Operands.push(ans);
						}
					Operators.push(currentChar);
			
					}
			
				}
				while(!Operators.isEmpty()) {//Solves whatever is left in the stack
					int ans = calculate(Operands, Operators);
					if (ans == -1) {
						throw new Exception ("Invalide Expression");
					}
					Operands.push(ans);
				}
				return Operands.pop();//Returns the evaluated answer and empties the stack.
			}
			
		}catch(Exception a) {
			System.out.println(a);
			System.out.print(" Will return a 0 value for invlaid expression. ");
		}
		
		return 0; //Default answer.
	}
	
	private boolean validOperator(char possOperator) { // Method to determine if the current character is a valid operator
		if(possOperator == '+' || possOperator == '-' || possOperator == '*' || possOperator == '/' || possOperator == '%') {
			return true;
		}
		
		return false;
	}
	
	private int pemdas(char operator) { //Method determines order of operations
		switch (operator) {
			case ('+'):
			case ('-'):
				return 1;// Addition and subtraction is of lower importance than multiplication and division
			case ('*'):
			case ('/'):
			case ('%'):
				return 2;
		}
		return -1;
	}
	
	private int calculate(Stack <Integer> numbers, Stack<Character> operators) {//Using the two stacks as parameters to calculate an expression
		//Gets the 2 most recent numbers from the stack
		int a = numbers.pop();
		int b = numbers.pop();
		int defaultReturn = 0;
		
		char operator = operators.pop();// gets most recent operator
		try {
		switch(operator) {//does the operation depending on what the current operator is
		case('+'):
			return b + a;
		case('-'):
			return b - a;
		case('*'):
			return b * a;
		case('/'):
			if (a == 0) {//Value returned to signify an error condition
				defaultReturn = -1;
				throw new Exception("Can't divide by zero. ");
			}
			return b / a;
		case('%'):
			return b % a;
			
		}
		} catch (Exception p) {
			System.out.println(p);
		}
		return defaultReturn;
	}
	
	public static void main(String[] args) {
		InfixCalculator calculator = new InfixCalculator();
		
		//Valid Expressions
		System.out.println("Result 1: " + calculator.evaluateInfix("(4+2)*3") + "\n");
		System.out.println("Result 2: " + calculator.evaluateInfix("5+(3*7)") + "\n");
		System.out.println("Result 3: " + calculator.evaluateInfix("5+3+7") + "\n");
		System.out.println("Result 4: " + calculator.evaluateInfix("1+(7%2)") + "\n");
		
		//Invalid Expressions
		System.out.println("Result 5: " + calculator.evaluateInfix("(4+5*1") + "\n");
		System.out.println("Result 6: " + calculator.evaluateInfix("4+7*3") + "\n");
		System.out.println("Result 7: " + calculator.evaluateInfix("4+(7/0)") + "\n");
		System.out.println("Result 8: " + calculator.evaluateInfix("1+8%2") + "\n");
		
		
		

	}

}
