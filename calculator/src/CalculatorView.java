import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CalculatorView extends JFrame implements ActionListener {
	Calculator calc;
	private JTextField input;
	private JTextArea area;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CalculatorView();
	}
	
	public CalculatorView() {
		super("Calculator");
		setSize(new Dimension(400, 400));
		setLayout(new BorderLayout());
		calc = new Calculator();
		initilaizeComponents();
		setVisible(true);
	}

	private void initilaizeComponents() {
		area = new JTextArea(20, 15);
		area.setLineWrap(true);
		area.setEditable(false);
		JScrollPane pane = new JScrollPane(area);
		add(pane, BorderLayout.NORTH);
		input = new JTextField(20);
		input.addActionListener(this);
		add(input, BorderLayout.SOUTH);
		
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			double result = calc.calculate(input.getText());
			area.setText(area.getText() + "\n" + result);
			input.setText("");
		}
	}

}
