import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Kuongea extends JFrame implements ActionListener {

	JScrollPane pane;
	JTextArea area;
	JTextField input;
	ChatClient client;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			client.send(input.getText());
			input.setText("");
			
	
		}
	

	}
	
	class UpdateTask extends TimerTask {

		@Override
		public void run() {
			update();
			
		}
		
	}
	
	private void update() {
		String text = client.receive();
		while(text != null) {
			area.setText(area.getText() + "\n" + text);
			text = client.receive();
		}
		JScrollBar bar = pane.getVerticalScrollBar();
		bar.setValue(bar.getMaximum());
	
	}
	
	public Kuongea() {
		super("Kuongea");
		setSize(new Dimension(400, 595));
		setLayout(new BorderLayout());
		initializeComponents();
		
		
		String ip = JOptionPane.showInputDialog("What is the server's IP address?");
		client = new ChatClient(ip, 9090);
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTask(), 1000, 500);
		
		setVisible(true);
		
	}

	private void initializeComponents() {
		area = new JTextArea(34, 20);
		area.setEditable(false);
		area.setLineWrap(true);
		pane = new JScrollPane(area);
		input = new JTextField(20);
		input.addActionListener(this);
		add( pane, BorderLayout.NORTH);
		add( input, BorderLayout.SOUTH);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Kuongea();
	

	}

}
