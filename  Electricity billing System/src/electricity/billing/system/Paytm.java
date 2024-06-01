package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    
    String meter;
    JButton back;
    Paytm(String meter) {
        this.meter = meter;
        
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try {
            j.setPage("https://paytm.com");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load html</html>");
        }
        
        JScrollPane pane = new JScrollPane(j); // Add j to the JScrollPane
        add(pane, BorderLayout.CENTER); // Add the JScrollPane to the frame's content pane
        
        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);
        
        setSize(800, 600);
        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new PayBill(meter);
    }
    
    public static void main(String[] ags) {
        new Paytm("");
    }
}
