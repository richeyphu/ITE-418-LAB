import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tree.AVLTree;
import tree.BSTree;
import tree.BTree;

public class Main {

	static AVLTree avl;
	static BSTree bst;
	static BTree bt;

	static JFrame frame;

	static JButton addB;
	static JButton avlB;
	static JButton bstB;
	static JButton btB;
	static JButton clearB;
	static JButton backB;

	static JLabel welcomeL;

	static JTextField textfield;

	static ImageIcon img;

	public static void main(String[] args) {
		bt = new BTree();
		avl = new AVLTree();
		bst = new BSTree();

		// img = new ImageIcon("icon.png");
		Image image = new ImageIcon("icon.png").getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(image);

		addB = new JButton();
		addB.setBounds(250, 30, 110, 30);
		addB.setText("Add Number");
		addB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// test.add(Integer.parseInt(JOptionPane.showInputDialog("Input a number")));
				int input = (int) Math.round(Double.parseDouble(textfield.getText()));
				bt.add(input);
				avl.add(input);
				bst.add(input);
				textfield.setText(null);
				frame.setVisible(false);
				frame.setVisible(true);
//				showFrame();
			}
		});

		btB = new JButton();
		btB.setBounds(190, 150, 110, 30);
		btB.setText("BTree");
		btB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				showBT();
			}
		});

		bstB = new JButton();
		bstB.setBounds(190, 200, 110, 30);
		bstB.setText("BSTree");
		bstB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				showBST();
			}
		});

		avlB = new JButton();
		avlB.setBounds(190, 250, 110, 30);
		avlB.setText("AVLTree");
		avlB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				showAVL();
			}
		});

		clearB = new JButton();
		clearB.setBounds(190, 320, 110, 30);
		clearB.setText("Clear Tree");
		// clearB.setBorder(null);
		clearB.setBackground(Color.PINK);
		clearB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt = new BTree();
				avl = new AVLTree();
				bst = new BSTree();
			}
		});

		backB = new JButton();
		backB.setBounds(370, 30, 80, 30);
		backB.setText("Back");
		backB.setBackground(Color.PINK);
		backB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				showFrame();
			}
		});

		textfield = new JTextField();
		textfield.setBounds(130, 30, 100, 30);
		textfield.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					addB.doClick();
				} else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
					backB.doClick();
				}

			}
		});

		showFrame();

	}

	public static void showFrame() {
		welcomeL = new JLabel("Welcome to ANYTree Project");
		welcomeL.setBounds(140, 35, 240, 150);
		welcomeL.setFont(new Font("SanSerif", Font.BOLD, 16));

		frame = new JFrame("ANYTree");
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(img.getImage());

		JLabel imgL = new JLabel(img);
		imgL.setBounds(210, 380, 60, 60);
		imgL.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using ANYTree Project 1.0", "Thank you!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.add(imgL);

		frame.add(textfield);
		frame.add(addB);
		frame.add(welcomeL);
		frame.add(btB);
		frame.add(bstB);
		frame.add(avlB);
		frame.add(clearB);

		frame.setVisible(true);
	}

	public static void showBT() {
		JLabel lbl = new JLabel("BTree");
		lbl.setBounds(20, 10, 50, 30);
		lbl.setFont(new Font("SanSerif", Font.BOLD, 16));
		
		frame = new JFrame("BTree");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(img.getImage());

		frame.add(lbl);
		frame.add(textfield);
		frame.add(addB);
		frame.add(backB);
		frame.add(bt.toCanvas());

		frame.setVisible(true);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				showFrame();
			}
		});
	}

	public static void showAVL() {
		JLabel lbl = new JLabel("AVLTree");
		lbl.setBounds(20, 10, 80, 30);
		lbl.setFont(new Font("SanSerif", Font.BOLD, 16));
		
		frame = new JFrame("AVLTree");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(img.getImage());

		frame.add(lbl);
		frame.add(textfield);
		frame.add(addB);
		frame.add(backB);
		frame.add(avl.toCanvas());

		frame.setVisible(true);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				showFrame();
			}
		});
	}

	public static void showBST() {
		JLabel lbl = new JLabel("BSTree");
		lbl.setBounds(20, 10, 80, 30);
		lbl.setFont(new Font("SanSerif", Font.BOLD, 16));
		
		frame = new JFrame("BSTree");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(img.getImage());

		frame.add(lbl);
		frame.add(textfield);
		frame.add(addB);
		frame.add(backB);
		frame.add(bst.toCanvas());

		frame.setVisible(true);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				showFrame();
			}
		});
	}

}
