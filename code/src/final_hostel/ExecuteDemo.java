package final_hostel;


import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ExecuteLoginPage extends JFrame implements ActionListener,KeyListener
{
	Container cp;
	JLabel loginPageL;
	JButton register;
	LoginPage l;
	Preference p;
	Done d;
	Selection1 s1;
	Selection2 s2;
	Selection3 s3;
	public ExecuteLoginPage()
	{
		super("Hostel Booking");
		loginPageL=new JLabel(new ImageIcon("/home/varshini/Desktop/hostel/hostel.jpg"));
		cp=getContentPane();
		 
		register=new JButton("Click to Register");
		l=new LoginPage();
		p=new Preference();
		d=new Done();
		d.logout.addActionListener(this);
		s1=new Selection1();
		s1.Rooms.setBounds(200,300,600,300);
		s1.Rooms.setVisible(false);
		s1.Confirm.setBounds(470,600,100,30);
		s1.Confirm.setVisible(false);
		s2=new Selection2();
		s2.Rooms.setBounds(200,300,600,300);
		s2.Rooms.setVisible(false);
		s2.Confirm.setBounds(470,600,100,30);
		s2.Confirm.setVisible(false);
		s3=new Selection3();
		s3.Rooms.setBounds(200,300,600,300);
		s3.Rooms.setVisible(false);
		s3.Confirm.setBounds(470,600,100,30);
		s3.Confirm.setVisible(false);
		s1.Confirm.addActionListener(this);
		s2.Confirm.addActionListener(this);
		s3.Confirm.addActionListener(this);
		s1.back.addActionListener(this);
		s2.back.addActionListener(this);
		s3.back.addActionListener(this);
		p.next.addActionListener(this);
		l.Logo.setBounds(437,150,150,150);
		l.loginPage.setBounds(320,400,400,125);
		register.setBounds(550,525,150,20);
		l.Login.addActionListener(this);
		l.regNo.addKeyListener(this);
		l.Pas.addKeyListener(this);
		l.Reset.addActionListener(this);
		register.addActionListener(this);
		p.Book.addActionListener(this);
		p.Top.setBounds(50,50,900,140);
		p.Top.setVisible(false);
		loginPageL.add(p.Top);
		p.logout.addActionListener(this);
		p.Prefer.setBounds(200,250,600,300);
		p.Prefer.setVisible(false);
		p.Prefer1.setBounds(200,250,600,300);
		p.Prefer1.setVisible(false);
		loginPageL.add(s1.Rooms);
		loginPageL.add(s1.Confirm);
		loginPageL.add(s2.Rooms);
		loginPageL.add(s2.Confirm);
		loginPageL.add(s3.Rooms);
		loginPageL.add(s3.Confirm);
		loginPageL.add(s1.back);
		loginPageL.add(s2.back);
		loginPageL.add(s3.back);
		loginPageL.add(p.Prefer);
		loginPageL.add(p.Prefer1);
		loginPageL.add(l.loginPage);
		loginPageL.add(l.Logo);
		loginPageL.add(register);
		loginPageL.add(d.thanks);
		loginPageL.add(d.logout);
		loginPageL.add(p.logout);
		
		cp.add(loginPageL);
		pack();
		setResizable(false);
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==l.Login)
		{
			int b=l.loginFunc();
			if(b==1)
			{
				p.Top.setVisible(true);
				p.next.setVisible(true);
				register.setVisible(false);
			}
			else if(b==2)
			{
				p.Top.setVisible(true);
				p.next.setVisible(false);
				register.setVisible(false);
				d.DoIt(l.Hostel,l.Block,l.Room);
				d.thanks.setVisible(true);
				d.logout.setVisible(true);
			}
		}
		else if(a.getSource()==l.Reset)
		{
			l.resetFunc();
		}
		else if(a.getSource()==p.next)
		{
			p.next.setVisible(false);
			p.logout.setVisible(true);
			p.Prefer.setVisible(true);
			p.Prefer1.setVisible(true);
		}
		else if(a.getSource()==p.Book)
		{
			int response=JOptionPane.showConfirmDialog(null,"Continue to book?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			if(p.Seater1==1)
			{
				p.Prefer.setVisible(false);
				p.Prefer1.setVisible(false);
				p.logout.setVisible(false);
				s1.DrawRooms(p.Hostel1,p.Block1,p.Floor1,p.AC1,l.RN);
				s1.Rooms.setVisible(true);
				s1.back.setVisible(true);
			}
			else if(p.Seater1==2)
			{
				p.Prefer.setVisible(false);
				p.Prefer1.setVisible(false);
				p.logout.setVisible(false);
				s2.DrawRooms(p.Hostel1,p.Block1,p.Floor1,p.AC1,l.RN);
				s2.Rooms.setVisible(true);
				s2.back.setVisible(true);
			}
			else if(p.Seater1==3)
			{
				p.Prefer.setVisible(false);
				p.Prefer1.setVisible(false);
				p.logout.setVisible(false);
				s3.DrawRooms(p.Hostel1,p.Block1,p.Floor1,p.AC1,l.RN);
				s3.Rooms.setVisible(true);
				s3.back.setVisible(true);
			}
		}
		else if(a.getSource()==s1.Confirm)
		{
			int response=JOptionPane.showConfirmDialog(null,"Confirm Room "+s1.Selection+" in "+p.Hostel1+" - "+p.Block1+" Block","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			{
				int a1=s1.DoIt();
				s1.room[a1].setDefaultCapable(false);
				s1.Rooms.setVisible(false);
				s1.Confirm.setVisible(false);
				s1.back.setVisible(false);
				p.Top.setVisible(true);
				d.DoIt(s1.Hostel,s1.Block,s1.Selection);
				d.thanks.setVisible(true);
				d.logout.setVisible(true);
			}
		}
		else if(a.getSource()==s2.Confirm)
		{
			int response=JOptionPane.showConfirmDialog(null,"Confirm Room "+s2.Selection+" in "+p.Hostel1+" - "+p.Block1+" Block","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			{
				int a1=s2.DoIt();
				s2.room[a1].setDefaultCapable(false);
				s2.Rooms.setVisible(false);
				s2.Confirm.setVisible(false);
				s2.back.setVisible(false);
				p.Top.setVisible(true);
				d.DoIt(s2.Hostel,s2.Block,s2.Selection);
				d.thanks.setVisible(true);
				d.logout.setVisible(true);
			}
		}
		else if(a.getSource()==s3.Confirm)
		{
			int response=JOptionPane.showConfirmDialog(null,"Confirm Room "+s3.Selection+" in "+p.Hostel1+" - "+p.Block1+" Block","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			{
				int a1=s3.DoIt();
				s3.room[a1].setDefaultCapable(false);
				s3.Rooms.setVisible(false);
				s3.Confirm.setVisible(false);
				s3.back.setVisible(false);
				p.Top.setVisible(true);
				d.DoIt(s3.Hostel,s3.Block,s3.Selection);
				d.thanks.setVisible(true);
				d.logout.setVisible(true);
			}
		}
		else if(a.getSource()==d.logout)
		{
			d.thanks.setVisible(false);
			d.logout.setVisible(false);
			p.Top.setVisible(false);
			p.Hostel.setSelectedIndex(0);
			p.ac.clearSelection();
			register.setVisible(true);
			l.loginPage.setVisible(true);
			l.Logo.setVisible(true);
			l.regNo.setText("");
			l.Pas.setText("");
		}
		else if(a.getSource()==register)
		{
			Register r=new Register();
		}
		else if(a.getSource()==p.logout)
		{
			p.Prefer.setVisible(false);
			p.Prefer1.setVisible(false);
			p.Top.setVisible(false);
			p.logout.setVisible(false);
			p.Hostel.setSelectedIndex(0);
			p.ac.clearSelection();
			register.setVisible(true);
			l.loginPage.setVisible(true);
			l.Logo.setVisible(true);
			l.regNo.setText("");
			l.Pas.setText("");
		}
		else if(a.getSource()==s1.back)
		{
			s1.Rooms.setVisible(false);
			s1.Confirm.setVisible(false);
			s1.back.setVisible(false);
			p.Top.setVisible(true);
			p.Prefer.setVisible(true);
			p.Prefer1.setVisible(true);
			p.logout.setVisible(true);
			p.Hostel.setSelectedIndex(0);
		}
		else if(a.getSource()==s2.back)
		{
			s2.Rooms.setVisible(false);
			s2.Confirm.setVisible(false);
			s2.back.setVisible(false);
			p.Top.setVisible(true);
			p.Prefer.setVisible(true);
			p.Prefer1.setVisible(true);
			p.logout.setVisible(true);
			p.Hostel.setSelectedIndex(0);
		}
		else if(a.getSource()==s3.back)
		{
			s3.Rooms.setVisible(false);
			s3.Confirm.setVisible(false);
			s3.back.setVisible(false);
			p.Top.setVisible(true);
			p.Prefer.setVisible(true);
			p.Prefer1.setVisible(true);
			p.logout.setVisible(true);
			p.Hostel.setSelectedIndex(0);
		}
	}
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode()==KeyEvent.VK_ENTER)
		{
			int b=l.loginFunc();
			if(b==1)
			{
				p.Top.setVisible(true);
				p.next.setVisible(true);
				register.setVisible(false);
			}
			else if(b==2)
			{
				p.Top.setVisible(true);
				p.next.setVisible(false);
				register.setVisible(false);
				d.DoIt(l.Hostel,l.Block,l.Room);
				d.thanks.setVisible(true);
				d.logout.setVisible(true);
			}
		}
	}
	public void keyTyped(KeyEvent k)
	{
	}
	public void keyReleased(KeyEvent k)
	{
	}
}

class ExecuteDemo
{
	public static void main(String a[])
	{
		ExecuteLoginPage e=new ExecuteLoginPage();
		e.setVisible(true);
		
	}
}