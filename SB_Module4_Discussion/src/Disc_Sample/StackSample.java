package Disc_Sample;

import java.util.Stack;

public class StackSample {

	public static void main(String[] args) {
		Stack<String> alarmStack = new Stack<String>();
		
		//Adding alarms to the stack as they arise
		alarmStack.push("Alarm 1");
		alarmStack.push("Alarm 57");

		System.out.println("The most recent active alarm: " + alarmStack.peek() + "\n"); //Getting the most recent alarm
		
		alarmStack.pop(); //Clears the most recent alarm
		
		System.out.println("Number of active alarms remaining: " + alarmStack.size() + "\n"); //Seeing how many alarms are still active
		
		//Adding alarms to the stack as they arise
		alarmStack.push("Alarm 60");
		alarmStack.push("Alarm 112");
		alarmStack.push("Alarm 7");
		alarmStack.push("Alarm 12");
		
		System.out.println("List of active alarms: " + alarmStack + "\n"); //Seeing all active alarms.
		
		alarmStack.pop(); //Clears the most recent alarm
		
		System.out.println("List of active alarms after clearing most recent: " + alarmStack + "\n"); //Seeing all active alarms.
	}

}
