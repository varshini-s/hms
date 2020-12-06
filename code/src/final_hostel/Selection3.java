package final_hostel;


import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Selection3 implements ActionListener
{
	JPanel Rooms;
	JLabel Select;
	JButton room[]=new JButton[24];
	JButton Confirm,back;
	Connection conn;
	Statement stmt;
	ResultSet rs=null;
	String Selection;
	String Hostel;
	String Block;
	int Floor;
	String Type;
	int RegNo;
	int selection;
	public Selection3()
	{
		back=new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD, 16));
		back.setBounds(680,600,70,30);
		back.setVisible(false);
		Rooms=new JPanel();
		Rooms.setBackground(new Color(200,200,200,180));
		Rooms.setSize(600,300);
		Rooms.setLayout(null);
		Confirm=new JButton("Confirm");
		Confirm.setFont(new Font("Times New Roman",Font.BOLD, 16));
		Confirm.setBounds(490,260,100,30);
		Confirm.setVisible(false);
		Select=new JLabel("Select Room");
		Select.setFont(new Font("Times New Roman",Font.BOLD, 40));
		Select.setBounds(100,50,300,50);
		Rooms.add(Select);
		for(int i=0;i<24;i++)
			room[i]=new JButton("");
	}
	public void DrawRooms(String Hostel,String Block,int Floor,String Type,int RegNo)
	{
		this.Hostel=Hostel;
		this.Block=Block;
		this.Floor=Floor;
		this.Type=Type;
		this.RegNo=RegNo;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			stmt= conn.createStatement();
			rs=stmt.executeQuery("SELECT room,bed,regno,type FROM hostel WHERE hostel='"+Hostel+"' and block='"+Block+"' and floor="+Floor);
			if(rs!=null)
			for(int i=0;i<24;i++)
			{
				rs.next();
				room[i].setText(rs.getString("room")+"-"+rs.getString("bed"));
				room[i].setFont(new Font("Times New Roman",Font.BOLD, 16));
				if(rs.getInt("regno")==0 && Type.equals(rs.getString("type")))
				{
					room[i].setBackground(new Color(255,255,255,255));
					room[i].setDefaultCapable(true);
					room[i].addActionListener(this);
				}
				else
				{
					room[i].setBackground(new Color(139,134,130,255));
					room[i].setDefaultCapable(false);
				}
			}
			int x=130,y=160,x1=130,y1=270;
			for(int i=0;i<8;i++)
			{
				if(i<4)
				{
					room[i*3].setBounds(x,y,80,20);
					room[i*3+1].setBounds(x,y+20,80,20);
					room[i*3+2].setBounds(x,y+40,80,20);
					x+=100;
				}
				else
				{
					room[i*3].setBounds(x1,y1,80,20);
					room[i*3+1].setBounds(x1,y1-20,80,20);
					room[i*3+2].setBounds(x1,y1-40,80,20);
					x1+=100;
				}
				
			}
			rs.close();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		for(int i=0;i<24;i++)
		{
			Rooms.add(room[i]);
		}
	}
	public void actionPerformed(ActionEvent a)
	{
		for(int i=0;i<24;i++)
		{
			if(a.getSource()==room[i])
			{
				room[i].setBackground(new Color(0,100,0,255));
				Selection=room[i].getText();
				selection=i;
				Confirm.setVisible(true);
			}
			else
			{
				if(room[i].isDefaultCapable())
					{
					room[i].setBackground(new Color(255,255,255,255));
					}
			}
		}
	}
	public int DoIt()
	{
		int b=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			stmt= conn.createStatement();
			b=stmt.executeUpdate("update student set hostel='"+Hostel+"', block='"+Block+"', room='"+Selection+"' where regno="+RegNo);
			String s[]=Selection.split("-");
			int r=Integer.parseInt(s[0]);
			b+=stmt.executeUpdate("update hostel set regno="+RegNo+" where hostel='"+Hostel+"' and block='"+Block+"' and floor="+Floor+" and room="+r+" and bed='"+s[1]+"'");
			conn.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return selection;
	}
}