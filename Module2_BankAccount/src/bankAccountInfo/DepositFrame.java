package bankAccountInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DepositFrame extends JFrame {
	//Creating components and variables to use
	JFrame depositFrame;
	JLabel dLabel;
	JTextField dField;
	JButton dDoneButton;
	String userInput2;
	String curBalance2;
	int add;
	public void makingDepositFrame() {
		GridBagConstraints layoutConst = null;
		dLabel = new JLabel ("Enter Amount to Withdraw");
		
		dField = new JTextField(15);
		dField.setText("0");
		dField.setEditable(true);
		dField.setSize(1, 10);
		
		dDoneButton = new JButton("Done");

		depositFrame = new JFrame("Withdrawal Window");
		depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		depositFrame. setLayout (new GridBagLayout ());
		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 0;
		depositFrame.add(dLabel, layoutConst);
		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 1;
		depositFrame.add(dField, layoutConst);
		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 4;
			layoutConst.gridy = 3;
		depositFrame.add(dDoneButton, layoutConst);
		
		
	}
}
