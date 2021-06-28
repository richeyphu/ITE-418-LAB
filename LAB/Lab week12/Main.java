//import java.awt.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import AVLTree.AVLTree;

public class Main {
	
	static AVLTree test;
	static JFrame frame;
	static JButton jb;
	static JTextField textfield;
	
	public static void main(String[] args) {
		test = new AVLTree();
		
		jb = new JButton();
		jb.setBounds(230,30,110,30);
		jb.setText("Add Number");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//test.add(Integer.parseInt(JOptionPane.showInputDialog("Input a number")));
				test.add(Integer.parseInt(textfield.getText()));
				textfield.setText(null);
				frame.setVisible(false);
				showFrame();
			}
		});
		
		textfield = new JTextField();
		textfield.setBounds(120,30,100,30);
		textfield.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					jb.doClick();
				}
				
			}
		});
		
		showFrame();

	}
	
	public static void showFrame() {
		frame = new JFrame("AVL TREE");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		setColor();

		frame.add(textfield);
		frame.add(jb);
		frame.add(test.toCanvas());
		
		frame.setVisible(true);
	}
	
	public static void setColor() {
		int max = 255;
		int min = 100;
		int r = (int) ((Math.random() * ((max - min) + 1)) + min);
		int g = (int) ((Math.random() * ((max - min) + 1)) + min);
		int b = (int) ((Math.random() * ((max - min) + 1)) + min);
		
		frame.getContentPane().setBackground(new Color(r,g,b));
	}

}
