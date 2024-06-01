package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener {
    
    JTextField tfname ,tfaddress,tfstate,tfcity,tfemail,tfphone;
    JButton next,cancel;
    JLabel lblmeter;
    Choice meterlocation,metertype,pahsecode,billtype;
    String meternumber;
    MeterInfo(String meter){
        this.meternumber = meter;
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setForeground(new Color(173,216,230));
        add(p);
        
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tachoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        JLabel lbmeternumber = new JLabel(meternumber);
        lbmeternumber.setBounds(240,80,100,20);
        p.add(lbmeternumber);
        
        JLabel lblmeterlocation = new JLabel("Meter Location");
        lblmeterlocation.setBounds(100,120,100,20);
        p.add(lblmeterlocation);
        
        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation);

        
        JLabel lbladdress = new JLabel("Meter Type");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240,160,200,20);
        p.add(metertype);
        
        JLabel lblcity = new JLabel("Phase Code");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        
        pahsecode = new Choice();
        pahsecode.add("011");
        pahsecode.add("022");
        pahsecode.add("033");
        pahsecode.add("044");
        pahsecode.add("055");
        pahsecode.add("066");
        pahsecode.add("077");
        pahsecode.add("088");
        pahsecode.add("099");
        pahsecode.setBounds(240,200,200,20);
        p.add(pahsecode);
        
        JLabel lblstate = new JLabel("Bill Type");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        
       billtype = new Choice();
       billtype.add("Domestic");
       billtype.add("Industrial");
       billtype.setBounds(240,240,200,20);
        p.add(billtype);
        
        JLabel lblemail = new JLabel("Days");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
             
        JLabel lblmails = new JLabel("30 Days");
        lblmails.setBounds(240,280,100,20);
        p.add(lblmails);
        
        JLabel lblphone = new JLabel("Note");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        
       JLabel lblphones = new JLabel("By Default bill is calculated for 30 Days only");
       lblphones.setBounds(240,320,500,20);
       p.add(lblphones);
        
        next = new JButton("Submit");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(220,390,100,25);
        next.addActionListener(this);
        p.add(next);
        
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = pahsecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";
            
             String query = "insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
             
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
                 setVisible(false);
                 
                 //new farme
             }catch (Exception e){
                 e.printStackTrace();
             }
             
        }else{
            setVisible(false);
        }
    } 
    
    public static void main (String[] args){

        new MeterInfo("");
    }
}

