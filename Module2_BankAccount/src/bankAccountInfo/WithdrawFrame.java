package bankAccountInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawFrame extends JFrame{
	JFrame withdrawFrame;
	JLabel wLabel;
	JTextField wField;
	JButton wDoneButton;
	String userInput1;
	int subtract;
	
	public void makingWithdrawFrame() {
		GridBagConstraints layoutConst = null;
		wLabel = new JLabel ("Enter Amount to Withdraw");
		
		wField = new JTextField(15);
		wField.setText("0");
		wField.setEditable(true);
		wField.setSize(1, 10);
		
		wDoneButton = new JButton("Done");
		
		withdrawFrame = new JFrame("Withdrawal Window");
		withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		withdrawFrame.setBackground(Color.BLUE);
		withdrawFrame. setLayout (new GridBagLayout ());
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 0;
		withdrawFrame.add(wLabel, layoutConst);
		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 1;
		withdrawFrame.add(wField, layoutConst);
		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 3;
		withdrawFrame.add(wDoneButton, layoutConst);
	
		
	}
	
	
	
	
}
