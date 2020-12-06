package final_hostel;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Register extends JFrame implements ActionListener,KeyListener
{
	Container cp;
	public JTextField regNo;
	public JPasswordField Pas,Pas1;
	public JLabel Pass,Pass1,RegNo,Back;
	JPanel Top,Logo;
	JButton register,cancel;
	Connection conn;
	Statement stmt;
	public Register()
	{
		super("Hostel Booking Registration");
		Back=new JLabel(new ImageIcon("/home/varshini/Desktop/hostel/hostel.jpg"));
		Logo=new JPanel();
		Logo.setBackground(new Color(0,0,0,0));
		Logo.add(new JLabel(new ImageIcon("LPU_logo.jpg")));
		cp=getContentPane();
		regNo=new JTextField("");
		Pas=new JPasswordField("");
		Pass=new JLabel("Enter Password: ");
		Pas1=new JPasswordField("");
		Pass1=new JLabel("Re-enter Password: ");
		RegNo=new JLabel("Registration Number:");
		RegNo.setBounds(20,20,180,20);
		regNo.setBounds(200,20,150,20);
		Pass.setBounds(20,50,180,20);
		Pas.setBounds(200,50,150,20);
		Pass1.setBounds(20,80,180,20);
		Pas1.setBounds(200,80,150,20);
		register=new JButton("Register");
		register.addActionListener(this);
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		regNo.addKeyListener(this);
		Pas.addKeyListener(this);
		Pas1.addKeyListener(this);
		cancel.setBounds(498,525,100,20);
		register.setBounds(600,525,100,20);
		Top=new JPanel();
		Top.setLayout(null);
		Top.setBackground(new Color(200,200,200,200));
		Logo.setBounds(437,150,150,150);
		Top.setBounds(320,400,400,125);
		Top.add(RegNo);
		Top.add(regNo);
		Top.add(Pass);
		Top.add(Pas);
		Top.add(Pass1);
		Top.add(Pas1);
		Back.add(Top);
		Back.add(Logo);
		Back.add(register);
		Back.add(cancel);
		cp.add(Back);
		pack();
		setResizable(false);
		setVisible(true);
		setSize(1000,1000);
	}
	public boolean checkRegNo()
	{
		String str=regNo.getText();
		if(str.length()==8)
			for (int i = 0; i < str.length(); i++) 
			{
   				if (!Character.isDigit(str.charAt(i)))
   					return false;
			}
		else
			return false;
		return true;
	}
	public boolean passMatch()
	{
		String str=Pas.getText();
		String str1=Pas1.getText();
		if(str.equals(str1))
			return true;
		return false;
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==register)
		if(regNo.getText().length()==0 || Pas.getText().length()==0 || Pas1.getText().length()==0)
			JOptionPane.showMessageDialog(null,"Fields Cannot be Empty","Warning",JOptionPane.WARNING_MESSAGE);
		else if(!checkRegNo())
		{
			JOptionPane.showMessageDialog(null,"Enter valid 8 digit Registration No.","Warning",JOptionPane.WARNING_MESSAGE);
			regNo.setText("");
		}
		else if(!passMatch())
		{
			JOptionPane.showMessageDialog(null,"Passwords don't match","Warning",JOptionPane.WARNING_MESSAGE);
			Pas.setText("");
			Pas1.setText("");
		}
		else
		{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
				stmt= conn.createStatement();
				int temp=Integer.parseInt(regNo.getText());
				stmt.executeUpdate("insert into student(regno,pass) values ("+temp+",'"+Pas.getText()+"')");
				conn.close();
				JOptionPane.showMessageDialog(null,"Successfully Registered!!!","Done",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Already Registered!!!","Done",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		}
		else if(a.getSource()==cancel)
			setVisible(false);
	}
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode()==KeyEvent.VK_ENTER)
		if(regNo.getText().length()==0 || Pas.getText().length()==0 || Pas1.getText().length()==0)
			JOptionPane.showMessageDialog(null,"Fields Cannot be Empty","Warning",JOptionPane.WARNING_MESSAGE);
		else if(!checkRegNo())
		{
			JOptionPane.showMessageDialog(null,"Enter valid 8 digit Registration No.","Warning",JOptionPane.WARNING_MESSAGE);
			regNo.setText("");
		}
		else if(!passMatch())
		{
			JOptionPane.showMessageDialog(null,"Passwords don't match","Warning",JOptionPane.WARNING_MESSAGE);
			Pas.setText("");
			Pas1.setText("");
		}
		else
		{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
				stmt= conn.createStatement();
				int temp=Integer.parseInt(regNo.getText());
				stmt.executeUpdate("insert into student(regno,pass) values ("+temp+",'"+Pas.getText()+"')");
				conn.close();
				JOptionPane.showMessageDialog(null,"Successfully Registered!!!","Done",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Already Registered!!!","Done",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		}
	}
	public void keyReleased(KeyEvent k)
	{
	}
	public void keyTyped(KeyEvent k)
	{
	}
}