package bankAccountInfo;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	//Creating panel and frame
	JFrame mainFrame;
	
	//Variables to store data values
	
	
	public void makingMainFrame() {
		GridBagConstraints layoutConst = null;
		BalanceAndButtonPanel panel = new BalanceAndButtonPanel();
		panel.mainPanel();
		//Setting up Frame
		mainFrame = new JFrame("Bank Account Balance Manager");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame. setLayout (new GridBagLayout ());
		layoutConst = new GridBagConstraints();
		
		
		
		//Layout for adding panel to frame
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets (10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
		mainFrame.add(panel.balancePanel, layoutConst);
		
	
	
	}
	
}
