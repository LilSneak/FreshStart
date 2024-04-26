package discussionPractice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public abstract class practiceFrame extends JFrame implements ActionListener{

	public static void main(String[] args) { 
		GridBagConstraints layoutConst = null;
		
		//Creating button and text field
		JButton clickButton = new JButton("Click Me");
		JTextField buttonClicked = new JTextField("Press Button");
		buttonClicked.setPreferredSize(new Dimension(200,10));//Setting size of text field
		
		//Creating frame and setting color
		JFrame frame = new JFrame("FirstFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.DARK_GRAY);
		
		
		//Creating panel and setting color
		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(Color.ORANGE);
	    
		//adding the button and text field
		p.add(clickButton, BorderLayout.EAST);
	    p.add(buttonClicked, BorderLayout.WEST);
	    
	    //action listener and action event
		clickButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent event) {
				
				buttonClicked.setText("Hello Everyone!");
			}
		});
		
		//setting layout of frame to add panel
		frame.setLayout(new GridBagLayout());
		layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 10);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 0;
	     
	    //Adding frame to panel and setting size of frame.
		frame.add(p);
		frame.setVisible(true);
		frame.setSize(400, 400);
	}

}
