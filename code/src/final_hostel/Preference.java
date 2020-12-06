package final_hostel;



import java.awt.*;
 import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Preference implements ItemListener,ActionListener
{ 
	public JComboBox Hostel,Block,Floor,Seater;
	public JRadioButton AC,NonAC;
	public ButtonGroup ac;
	public JLabel hostel,block,floor,acNonac,Logo,Welcome,Pref,seater,avail;
	public JButton next,Check,Book,logout;
	public JPanel Prefer,Prefer1,Top;
	public String Hostel1,Block1,AC1;
	public int Floor1,Seater1;
	Connection conn;
	Statement stmt;
	private int s=1;
	public Preference()
	{ 
		Top=new JPanel();
		Top.setLayout(null);
		Top.setBackground(new Color(255,255,255,150));
		Top.setSize(900,140);
		Logo=new JLabel(new ImageIcon("/home/varshini/Desktop/hostel/logoo.jpg"));
		Welcome=new JLabel("Welcome to Hostel Booking Page");
		next=new JButton("click to continue...");
		next.setForeground(Color.blue);
		next.setBackground(new Color(255,255,255,255));
		next.setBounds(700,110,180,20);
		Logo.setBounds(10,10,250,120);
		Welcome.setBounds(300,50,600,50);
		Welcome.setFont(new Font("Comic Sans MS",Font.PLAIN, 35));
		Top.setVisible(false);
		Top.add(Logo);
		Top.add(next);
		Top.add(Welcome);
		hostel=new JLabel("Hostel: ");
		hostel.setFont(new Font("Times New Roman",Font.BOLD, 20));
		String str[]={"--Select Hostel--","Boys Hostel 1","Boys Hostel 2","Boys Hostel 3","Boys Hostel 4","Girls Hostel 1","Girls Hostel 2","Girls Hostel 3"};
		Hostel=new JComboBox(str);
		hostel.setBounds(100,110,80,20);
		Hostel.setBounds(200,110,150,20);
		Hostel.addItemListener(this);
		block=new JLabel("Block: ");
		block.setFont(new Font("Times New Roman",Font.BOLD, 20));
		String str1[]={"--Select Block--"};
		Block=new JComboBox(str1);
		block.setBounds(100,230,80,20);
		Block.setBounds(200,230,150,20);
		floor=new JLabel("Floor: ");
		floor.setFont(new Font("Times New Roman",Font.BOLD, 20));
		String str2[]={"--Select Floor--"};
		Floor=new JComboBox(str2);
		floor.setBounds(100,270,80,20);
		Floor.setBounds(200,270,150,20);
		seater=new JLabel("Seater: ");
		seater.setFont(new Font("Times New Roman",Font.BOLD, 20));
		String str3[]={"--Select Seater--"};
		Seater=new JComboBox(str3);
		seater.setBounds(100,150,80,20);
		Seater.setBounds(200,150,150,20);
		AC=new JRadioButton("AC");
		NonAC=new JRadioButton("Non AC");
		ac=new ButtonGroup();
		ac.add(AC);
		ac.add(NonAC);
		acNonac=new JLabel("AC/NonAC");
		acNonac.setFont(new Font("Times New Roman",Font.BOLD, 20));
		acNonac.setBounds(100,190,150,20);
		AC.setBounds(200,190,80,20);
		NonAC.setBounds(280,190,80,20);
		AC.setEnabled(false);
		NonAC.setEnabled(false);
		Pref=new JLabel("Select Your Preference...");
		Pref.setFont(new Font("Times New Roman",Font.BOLD, 40));
		Pref.setBounds(50,20,500,60);
		Check=new JButton("Check Availability");
		Check.setBounds(400,250,150,20);
		Check.addActionListener(this);
		avail=new JLabel("");
		avail.setFont(new Font("Times New Roman",Font.BOLD, 20));
		avail.setBounds(400,160,250,40);
		Book=new JButton("Book");
		Book.setBounds(435,220,80,20);
		Book.setVisible(false);
		logout=new JButton("Logout");
		logout.setFont(new Font("Times New Roman",Font.BOLD, 16));
		logout.setBounds(800,190,100,30);
		logout.setVisible(false);
		logout.addActionListener(this);
		Prefer=new JPanel();
		Prefer1=new JPanel();
		Prefer.setLayout(null);
		Prefer1.setBackground(new Color(200,200,200,180));
		Prefer.setSize(600,300);
		Prefer1.setSize(600,300);
		Prefer.setOpaque(false);
		Prefer.add(hostel);
		Prefer.add(Hostel);
		Prefer.add(block);
		Prefer.add(Block);
		Prefer.add(floor);
		Prefer.add(Floor);
		Prefer.add(acNonac);
		Prefer.add(AC);
		Prefer.add(NonAC);
		Prefer.add(Pref);
		Prefer.add(seater);
		Prefer.add(Seater);
		Prefer.add(Check);
		Prefer.add(avail);
		Prefer.add(Book);
	}
	public void itemStateChanged(ItemEvent i)
	{
		if (i.getSource()==Hostel)
		{
			if(i.getItem().toString().equals("--Select Hostel--"))
			{
				Seater.removeItem("1");
				Seater.removeItem("2");
				Seater.removeItem("3");
				Block.removeItem("A");
				Block.removeItem("B");
				Block.removeItem("C");
				AC.setEnabled(false);
				NonAC.setEnabled(false);
				Seater.removeItemListener(this);
				Hostel1=null;
				Floor1=0;
				Block1=null;
				Block.removeItemListener(this);
				Seater1=0;
				s=1;
			}
			else
			{
				Hostel1=i.getItem().toString();
				if(s==1)
				{
				AC.setEnabled(true);
				NonAC.setEnabled(true);
				Seater.addItem("1");
				Seater.addItem("2");
				Seater.addItem("3");
				Block.addItem("A");
				Block.addItem("B");
				Block.addItem("C");
				Block.addItemListener(this);
				Seater.addItemListener(this);
				s=0;
				}
			avail.setText("");
			Book.setVisible(false);
			}	
		}
		else if (i.getSource()==Seater)
		{
			if(i.getItem().toString().equals("--Select Seater--"))
			{
				AC.removeActionListener(this);
				NonAC.removeActionListener(this);
				Floor.removeAllItems();
				Floor.addItem("--Select Floor--");
				Floor.removeItemListener(this);
				Seater1=0;
				Floor1=0;
				avail.setText("");
				Book.setVisible(false);
			}
			else
			{
				Seater1=Integer.parseInt(i.getItem().toString());
				AC.addActionListener(this);
				NonAC.addActionListener(this);
				Floor.addItemListener(this);
				if(Seater1==1)
				{
					Floor.removeAllItems();
					Floor.addItem("--Select Floor--");
					Floor.addItem("1");
					Floor.addItem("2");
				}
				else if(Seater1==2)
				{
					Floor.removeAllItems();
					Floor.addItem("--Select Floor--");
					Floor.addItem("3");
					Floor.addItem("4");
					Floor.addItem("5");
				}
				else if(Seater1==3)
				{
					Floor.removeAllItems();
					Floor.addItem("--Select Floor--");
					Floor.addItem("6");
					Floor.addItem("7");
					Floor.addItem("8");
				}
				avail.setText("");
				Book.setVisible(false);
			}
			
		}
		else if (i.getSource()==Floor)
		{
			if(i.getItem().toString().equals("--Select Floor--"))
			{
				Floor1=0;
			}
			else
			{
				Floor1=Integer.parseInt(i.getItem().toString());
			}
				avail.setText("");
				Book.setVisible(false);
		}
		else if (i.getSource()==Block)
		{
			if(i.getItem().toString().equals("--Select Block--"))
			{
				Block1=null;
			}
			else
			{
				Block1=i.getItem().toString();
			}
				avail.setText("");
				Book.setVisible(false);
		}
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==AC)
		{
			if(AC.isSelected())
			{
				AC1=AC.getText();
			}
				avail.setText("");
				Book.setVisible(false);
		}
		else if(a.getSource()==NonAC)
		{
			if(NonAC.isSelected())
			{
				AC1=NonAC.getText();
			}
				avail.setText("");
				Book.setVisible(false);
		}
		else if(a.getSource()==Check)
		{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
				stmt= conn.createStatement();
						ResultSet rs=stmt.executeQuery("SELECT count(Distinct(room)) AS rooms FROM hostel WHERE hostel='"+Hostel1+"' and block='"+Block1+"' and Floor="+Floor1+" and type='"+AC1+"' and regno=0");
						if(rs!=null)
							while(rs.next())
							{
								if(Hostel1!="--Select Hostel--"&&Block1!="--Select Block--"&&Floor1!=0&&Seater1!=0&&AC1!=null)
								if(rs.getInt("rooms")<2)
								{
									avail.setForeground(Color.red);
									avail.setText(rs.getInt("rooms")+"  room(s) available");
									Book.setVisible(true);
								}
								else
								{
									avail.setForeground(new Color(0,100,0));
									avail.setText(rs.getInt("rooms")+"  room(s) available");
									Book.setVisible(true);
								}
							}
						rs.close();
						conn.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}