import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MiniGameGui extends JFrame implements ActionListener
{
	private HeldenApp heldenApp;
	
	public MiniGameGui(HeldenApp heldenApp) 
	{
		this.heldenApp = heldenApp;
		
		
		JButton button = new JButton("Kampf starten");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(button);
		
		setSize(300, 300);
		setVisible(true);
		button.setSize(150, 150);
		
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		heldenApp.kampfVorbeiten();
		heldenApp.kampf(2000);
	}
}
