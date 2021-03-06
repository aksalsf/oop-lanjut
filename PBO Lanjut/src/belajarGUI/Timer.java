/*
 * M3119004 - AKSAL SYAH FALAH
 * */

package belajarGUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * Gunakan Frame,TextField, Button, Label dan buat tampilan
 * */

public class Timer extends Frame implements WindowListener, ActionListener {
	
	int angka;
	Label label;
	TextField field_angka;
	Button myButton;
	
	public Timer() {
		super("Timer | M3119004 - Aksal Syah Falah");
		Panel myPanel = new Panel();
		add(myPanel);
		myPanel.setLayout(new GridLayout(2,2));
		
		// Form
		myPanel.add(field_angka = new TextField());
		myButton = new Button("Mulai");
		myButton.addActionListener(this);
		myPanel.add(myButton);
		label = new Label();
		label.setText("Isikan dengan angka!");
		myPanel.add(label);
		
		setSize(360,90);
		setVisible(true);
		addWindowListener(this);
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		new Timer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isAngka(field_angka.getText()) == true) {
			String dump;
			angka = Integer.parseInt(field_angka.getText());
			label.setText("Oke, countdown dari angka " + angka);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			label.setText("Mulai!");
			for(int i=angka;i>=0;i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
				dump = Integer.toString(angka);
				if(angka == 0) {
					label.setText("Selesai!");
				} else {
					label.setText(dump);
				}
				angka--;
			}
		} else {
			label.setText("Isian bukan angka!");
		}
	}
	
	public boolean isAngka(String arg) {
		int dump;
		try {
			dump = Integer.parseInt(arg);
			return true;
		} catch(NumberFormatException err) {
			return false;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(ABORT);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
