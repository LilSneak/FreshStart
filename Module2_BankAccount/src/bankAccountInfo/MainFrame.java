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

public class MainFrame extends JFrame implements ActionListener{
	//Creating components for panel and frame
	JLabel userBalanceLabel;
	JLabel curBalanceLabel;
	JTextField userBalanceField;
	JTextField curBalanceField;
	JButton depositButton;
	JButton withdrawButton;
	//Creating panel and frame
	JFrame mainFrame;
	JPanel balancePanel;
	//Variables to store data values
	String userInput;
	int curBalance;
	
	public void makingMainFrame() {
		GridBagConstraints layoutConst = null;
		
		//Initializing components for main frame
		userBalanceLabel = new JLabel ("Enter Bank Balance:");
		
		userBalanceField = new JTextField(15);
		userBalanceField.setText("0");
		userBalanceField.setEditable(true);
		userBalanceField.setColumns(15);
		userBalanceField.addActionListener(this);
		
		curBalanceLabel = new JLabel("Current Balance:");
		
		curBalanceField = new JTextField(15);
		curBalanceField.setText("0");
		curBalanceField.setEditable(false);
		curBalanceField.setColumns(15);
		
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(this);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(this);
		
		//Developing Panel
		balancePanel = new JPanel(new GridBagLayout ());
		balancePanel.setBackground(Color.cyan);
			//layout for current Balance Label
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
		balancePanel.add(curBalanceLabel, layoutConst);
		
		//layout for current Balance field
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 1;
			layoutConst.gridy = 0;
		balancePanel.add(curBalanceField, layoutConst);
		
		//layout for deposit button		
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
		balancePanel.add(depositButton, layoutConst);
			
		//layout for withdraw button	
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 1;
			layoutConst.gridy = 1;
		balancePanel.add(withdrawButton, layoutConst);
				
		//Setting up Frame
		mainFrame = new JFrame("Bank Account Balance Manager");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame. setLayout (new GridBagLayout ());
		layoutConst = new GridBagConstraints();
		
		//Layout for user Balance Label
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
		mainFrame.add(userBalanceLabel, layoutConst);
		
		//Layout for user Balance input field
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 1;
			layoutConst.gridy = 0;
		mainFrame.add(userBalanceField, layoutConst);
		
		//Layout for adding panel to frame
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 2;
		mainFrame.add(balancePanel, layoutConst);
		
	
	}
	@Override
	public void actionPerformed(ActionEvent d) {
		if(d.getSource()== userBalanceField) {//Actions for input in the user text field
			WithdrawFrame withdraw = new WithdrawFrame();
			
			userInput = userBalanceField.getText();
			curBalance = Integer.parseInt(userInput);
			
			curBalanceField.setText(userInput);
			withdraw.curBalance1 = userInput;
		}
		else if(d.getSource()== withdrawButton) {//Actions if Withdraw is clicked
			WithdrawFrame wDraw = new WithdrawFrame();
			wDraw.makingWithdrawFrame();
			wDraw.withdrawFrame.setVisible(true);
			wDraw.withdrawFrame.setSize(500, 500);
			wDraw.wDoneButton.addActionListener(new ActionListener() {//Done button on Withdraw frame clicked
				@Override
				public void actionPerformed(ActionEvent e) {
					String userInput;
					int subtract;
					int curBalance;
					int newBalance;
					
						userInput = wDraw.wField.getText();
						subtract= Integer.parseInt(userInput);
						
						curBalance = Integer.parseInt(curBalanceField.getText());
						newBalance = (curBalance - subtract);
						
						curBalanceField.setText(Integer.toString(newBalance));
						
						wDraw.withdrawFrame.setVisible(false);
					}
				});
		}
		else if(d.getSource()== depositButton) {//Actions if deposit is clicked
			DepositFrame deposit = new DepositFrame();
			deposit.makingDepositFrame();
			deposit.depositFrame.setVisible(true);
			deposit.depositFrame.setSize(500, 500);
			deposit.dDoneButton.addActionListener(new ActionListener() {//Done button on deposit frame clicked
				@Override
				public void actionPerformed(ActionEvent e) {
					String userInput;
					int add;
					int curBalance;
					int newBalance;
					
						userInput = deposit.dField.getText();
						add = Integer.parseInt(userInput);//for later application
						
						curBalance = Integer.parseInt(curBalanceField.getText());
						newBalance = (curBalance + add);
						
						curBalanceField.setText(Integer.toString(newBalance));
						
						deposit.depositFrame.setVisible(false);
					}
			});
		}
	}
	
}
