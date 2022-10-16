package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements MouseListener{

	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	JButton btnC = new JButton("C");
	JButton btnSwitch = new JButton("+/-");
	JButton btnPercent = new JButton("%");
	JButton btnDivison = new JButton("÷");
	JButton btnMultiplication = new JButton("x");
	JButton btnMinus = new JButton("-");
	JButton btnPlus = new JButton("+");
	JButton btnDec = new JButton(".");
	JButton btnEqual = new JButton("=");
	JTextField txtf = new JTextField();

	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	
	public Calculator() {
		setTitle("Calculator");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		txtf.setEditable(false);
		
		
		functionButtons[0] = btnPlus;
		functionButtons[1] = btnMinus;
		functionButtons[2] = btnMultiplication;
		functionButtons[3] = btnDivison;
		functionButtons[4] = btnEqual;
		functionButtons[5] = btnC;
		functionButtons[6] = btnSwitch;
		functionButtons[7] = btnPercent;
		functionButtons[8] = btnDec;
		
		for (int i = 0; i < functionButtons.length; i++) {
			 functionButtons[i].addMouseListener(this);
			 functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addMouseListener(this);
			numberButtons[i].setFocusable(false);
		}
		
		
		
		JPanel pnl1 = new JPanel(new GridLayout(5, 4));
		
		pnl1.add(btnC);
		pnl1.add(btnSwitch);
		pnl1.add(btnPercent);
		pnl1.add(btnDivison);
		pnl1.add(numberButtons[7]);
		pnl1.add(numberButtons[8]);
		pnl1.add(numberButtons[9]);
		pnl1.add(btnMultiplication);
		pnl1.add(numberButtons[4]);
		pnl1.add(numberButtons[5]);
		pnl1.add(numberButtons[6]);
		pnl1.add(btnMinus);
		pnl1.add(numberButtons[1]);
		pnl1.add(numberButtons[2]);
		pnl1.add(numberButtons[3]);
		pnl1.add(btnPlus);
		pnl1.add(numberButtons[0]);
		pnl1.add(btnDec);
		pnl1.add(btnEqual);
		
		
		
		add(txtf, BorderLayout.NORTH);
		add(pnl1, BorderLayout.CENTER);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		new Calculator().setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		for (int i = 0; i < numberButtons.length; i++) {
			if(e.getSource() == numberButtons[i]) {
				txtf.setText(txtf.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == btnC) {
			txtf.setText("");
		}
		if(e.getSource() == btnSwitch) {
			double temp = Double.parseDouble(txtf.getText());
			temp *= -1;
			txtf.setText(String.valueOf(temp));
		}
		if(e.getSource() == btnPercent) {
			double percent = Double.parseDouble(txtf.getText())/100;
			txtf.setText(String.valueOf(percent));
		}
		if(e.getSource() == btnDivison) {
			num1 = Double.parseDouble(txtf.getText());
			operator = '/';
			txtf.setText("");
		}
		if(e.getSource() == btnMultiplication) {
			num1 = Double.parseDouble(txtf.getText());
			operator = 'x';
			txtf.setText("");
		}
		if(e.getSource() == btnMinus) {
			num1 = Double.parseDouble(txtf.getText());
			operator = '-';
			txtf.setText("");
		}
		if(e.getSource() == btnPlus) {
			num1 = Double.parseDouble(txtf.getText());
			operator = '+';
			txtf.setText("");
		}
		if(e.getSource() == btnEqual) {
			num2 = Double.parseDouble(txtf.getText());
			
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			txtf.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == btnDec) {
			txtf.setText(txtf.getText().concat("."));
		}
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
