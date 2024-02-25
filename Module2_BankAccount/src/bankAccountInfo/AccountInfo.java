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
import javax.swing.JTextField;
import javax. swing. JPanel;

public class AccountInfo extends JFrame implements ActionListener{

	public static void main(String[] args) {
		GridBagConstraints layoutConst = null;
		
		//Creating components for frame
		JLabel userBalanceLabel;
		JTextField userBalanceField;
		
		//Creating components for panel on frame
		JLabel curBalanceLabel;
		JTextField curBalanceField;
		JButton depositButton;
		JButton withdrawButton;
		
		//Creating panel and frame
		JFrame mainFrame;
		JPanel balancePanel;
	
		//Initializing components for main frame
		userBalanceLabel = new JLabel ("Enter Bank Balance:");
		userBalanceField = new JTextField(15);
		userBalanceField.setText("0");
		userBalanceField.setEditable(true);
		userBalanceField.setSize(1, 10);
		
		curBalanceLabel = new JLabel("Current Balance:");
		curBalanceField = new JTextField(15);
		curBalanceField.setText("0");
		curBalanceField.setEditable(false);
		curBalanceField.setSize(1, 10);
		
		depositButton = new JButton("Deposit");
		withdrawButton = new JButton("Withdraw");
		
		//Developing Panel
		balancePanel = new JPanel(new GridBagLayout ());
		balancePanel.setBackground(Color.YELLOW);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
			balancePanel.add(curBalanceLabel, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
			balancePanel.add(curBalanceField, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
				balancePanel.add(depositButton, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
				balancePanel.add(withdrawButton, layoutConst);
				
		//Setting Frame
		mainFrame = new JFrame("Bank Account Balance Manager");
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setBackground(Color.BLUE);
			mainFrame. setLayout (new GridBagLayout ());
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
			mainFrame.add(userBalanceLabel, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
			mainFrame.add(userBalanceField, layoutConst);
		//adding panel to frame
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets (10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
			mainFrame.add(balancePanel, layoutConst);
		
		
		userBalanceField.addActionListener(new ActionListener(){
			@Override
		public void actionPerformed(ActionEvent e) {
				String userInput;
				int curBalance;
				
				userInput = userBalanceField.getText();
				curBalance = Integer.parseInt(userInput);//for later application
				
				curBalanceField.setText(userInput);
			}
		});
		
		WithdrawFrame wDraw = new WithdrawFrame();
		withdrawButton.addActionListener(new ActionListener(){
			@Override
		public void actionPerformed(ActionEvent e) {
				wDraw.makingWithdrawFrame();
				wDraw.withdrawFrame.setVisible(true);
				wDraw.withdrawFrame.setSize(500, 500);
				wDraw.wDoneButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String userInput;
						int subtract;
						int curBalance;
						int newBalance;
						
							userInput = wDraw.wField.getText();
							subtract= Integer.parseInt(userInput);//for later application
							
							curBalance = Integer.parseInt(userBalanceField.getText());
							newBalance = (curBalance - subtract);
							
							curBalanceField.setText(Integer.toString(newBalance));
							
							wDraw.withdrawFrame.setVisible(false);
						}
					});
			}
		});
		
	
		mainFrame.setVisible(true);
		mainFrame.setSize(700, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
