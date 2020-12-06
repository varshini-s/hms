package final_hostel;

import java.awt.*;
import javax.swing.*;

class Done
{
	JPanel thanks;
	JLabel thanksTxt,hostel,block,room;
	JButton logout;
	JTextField hostel1,block1,room1;
	public Done()
	{
		thanks=new JPanel();
		thanks.setBackground(new Color(200,200,200,180));
		thanks.setBounds(240,350,600,200);
		thanks.setLayout(null);
		thanksTxt=new JLabel("Thanks! You have selected your Hostel");
		hostel=new JLabel("Hostel: ");
		room=new JLabel("Room: ");
		block=new JLabel("Block:");
		hostel1=new JTextField();
		block1=new JTextField();
		room1=new JTextField();
		hostel1.setForeground(new Color(0,100,0));
		hostel1.setFont(new Font("Times New Roman",Font.BOLD, 22));
		block1.setForeground(new Color(0,100,0));
		block1.setFont(new Font("Times New Roman",Font.BOLD, 22));
		room1.setForeground(new Color(0,100,0));
		room1.setFont(new Font("Times New Roman",Font.BOLD, 22));
		thanksTxt.setBounds(60,30,700,50);
		thanksTxt.setForeground(new Color(0,100,0));
		thanksTxt.setFont(new Font("Times New Roman",Font.BOLD, 24));
		hostel.setBounds(30,90,150,50);
		hostel1.setBounds(130,95,200,40);
		hostel.setForeground(new Color(0,100,0));
		hostel.setFont(new Font("Times New Roman",Font.BOLD, 24));
		block.setBounds(350,90,120,50);
		block1.setBounds(440,95,140,40);
		block.setForeground(new Color(0,100,0));
		block.setFont(new Font("Times New Roman",Font.BOLD, 24));
		room.setBounds(160,150,100,50);
		room1.setBounds(260,155,150,40);
		room.setForeground(new Color(0,100,0));
		room.setFont(new Font("Times New Roman",Font.BOLD, 24));
		thanks.setVisible(false);
		logout=new JButton("Logout");
		logout.setFont(new Font("Times New Roman",Font.BOLD, 16));
		logout.setBounds(800,190,100,30);
		logout.setVisible(false);
		thanks.add(thanksTxt);
		thanks.add(hostel);
		thanks.add(room);;
		thanks.add(block);
		thanks.add(hostel1);
		thanks.add(room1);
		thanks.add(block1);
		hostel1.setEditable(false);
		block1.setEditable(false);
		room1.setEditable(false);
	}
	public void DoIt(String Hostel,String Block, String Room)
	{
		hostel1.setText(" "+Hostel);
		room1.setText("       "+Room);
		block1.setText("          "+Block);
	}
}