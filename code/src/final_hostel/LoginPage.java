package final_hostel;


import java.awt.*;
import javax.swing.*;
import java.sql.*;

class LoginPage
{
	public JTextField regNo;
	public JPasswordField Pas;
	public JLabel Pass,RegNo,center;
	public JButton Login,Reset;
	public JPanel loginPage,Logo;
	public String Hostel,Block,Room;
	public int RN;
	public LoginPage()
	{  
		regNo=new JTextField();
		Pas=new JPasswordField();
		Pass=new JLabel("Password: ");
		RegNo=new JLabel("Registration Number:");
		Login=new JButton("Login");
		Reset=new JButton("Reset");
		loginPage=new JPanel();
		RegNo.setBounds(20,20,180,20);
		regNo.setBounds(200,20,150,20);
		Pass.setBounds(20,50,180,20);
		Pas.setBounds(200,50,150,20);
		Reset.setBounds(100,80,100,20);
		Login.setBounds(250,80,100,20);
		loginPage.setLayout(null);
		loginPage.setBackground(new Color(200,200,200,200));
		loginPage.add(RegNo);
		loginPage.add(regNo);
		loginPage.add(Pass);
		loginPage.add(Pas);
		loginPage.add(Reset);
		loginPage.add(Login);
		loginPage.setPreferredSize(new Dimension(400,125));
		Logo=new JPanel();
		Logo.setBackground(new Color(0,0,0,0));
		Logo.add(new JLabel(new ImageIcon("/home/varshini/Desktop/hostel/logoo.jpg")));
		 
	}
	public int loginFunc()
	{
		if(regNo.getText().length()!=0&&regNo.getText().length()!=0&&Pas.getText().length()!=0&&Pas.getText().length()!=0)
				{
					Connection conn;
					Statement stmt;
					int c=0;
						String sc=regNo.getText();
						char cs[]=new char[sc.length()];
						cs=sc.toCharArray();
						if(sc.length()!=8)
							c=-1;
						for(int i=0;i<sc.length();i++)
							{
								if(cs[i]>=65 && cs[i]<=90 || cs[i]>=97 && cs[i]<=122)
								{
									c=-1;
									break;
								}
							}
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
						stmt= conn.createStatement();
						ResultSet rs=null;
						rs=stmt.executeQuery("Select regno,pass,hostel,block,room from student where regno="+regNo.getText());
						if(rs!=null)
						{
							while(rs.next())
							{
								String s=rs.getString("pass");
								String y=Pas.getText();
								if(s.compareTo(y)==0)
									{
									loginPage.setVisible(false);
									Logo.setVisible(false);
									RN=Integer.parseInt(regNo.getText());
									if(rs.getString("hostel")==null || rs.getString("hostel")=="")
									{
										return 1;
									}
									else
									{
										Hostel=rs.getString("hostel");
										Block=rs.getString("block");
										Room=rs.getString("room");
										return 2;
									}
									}
							}
						if(c==0)
							{
								JOptionPane.showMessageDialog(null,"Wrong Password (or not registered)","Warning",JOptionPane.WARNING_MESSAGE);
								return 0;
							}
						if(c==-1)
							{
								JOptionPane.showMessageDialog(null,"Wrong Username (enter valid registration No.)","Warning",JOptionPane.WARNING_MESSAGE);
								return 0;
							}
						}
						conn.close();
					}catch(Exception e){
							System.out.println(e);
							return 0;
						}
				}
			else
				{
					JOptionPane.showMessageDialog(null,"Fields cannot be Empty");
					return 0;
				}
	return 0;
	}
	public void resetFunc()
	{
				regNo.setText("");
				Pas.setText("");
	}
}