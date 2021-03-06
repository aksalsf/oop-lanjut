package belajarGUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LatihanRadioCombo extends JFrame implements WindowListener, ActionListener, ChangeListener {

	ButtonGroup bg;
	JRadioButton rb1,rb2;
	JComboBox cb;
	JButton b;
	Label label;
	int jumlahBeli;
	TextField field_jumlahBeli;
	final String[] jenis = {"PC","Laptop", "Monitor"};
	JMenuBar mb;
	JMenu m;
	
	public LatihanRadioCombo() {
		super("Latihan Radio Combo | M3119004 - Aksal Syah Falah");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(4,2));
		mb = new JMenuBar();
		mb.add(m=new JMenu("exit"));
		m.addChangeListener((ChangeListener) this);;
		this.setJMenuBar(mb);
		cp.add(label = new Label("Pilih Barang"));
		cp.add(cb =new JComboBox(jenis));
		cp.add(rb1 = new JRadioButton("Member"));
		cp.add(rb2 = new JRadioButton("Non Member"));
		bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		cp.add(label = new Label("Jumlah Pembelian"));
		cp.add(field_jumlahBeli = new TextField());
		cp.add(b = new JButton("Simpan"));
		
		setSize(360,180);
		setVisible(true);
		b.addActionListener((ActionListener) this);
	}
	
	public static void main(String args[])
	{
		new LatihanRadioCombo();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double harga = 0, total = 0, diskon = 0.1;
		if(e.getSource() == b)
		{
		jumlahBeli = Integer.parseInt(field_jumlahBeli.getText());
		String radio=null;
		if(rb1.isSelected() == true)
		{
		radio = rb1.getText();
		}else{
		radio = rb2.getText();
		} 
		String combo = cb.getSelectedItem().toString();
		if (combo == "PC") {
			harga = 2000000;
		} else if(combo == "Laptop") {
			harga = 5000000;
		} else {
			harga = 900000;
		}
		System.out.println("Nama Barang: "+combo);
		System.out.println("Jumlah Pembelian: "+jumlahBeli);
		System.out.println("Status: " + radio);
		if (radio == "Member") {
			total = harga - (diskon * harga);
		} else {
			total = harga;	
		}
		System.out.println("Total: " + total);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == m)
		{
		System.exit(0);
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
