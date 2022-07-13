package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lamia
 */
public class GUI extends Frame implements ActionListener{
Button b1 = new Button("OK");

GUI()
{
    setLayout(null);
    setBounds(100,100,500,400);
    b1.setBounds(150,150,100,50);
    add(b1);
    b1.addActionListener(this);
    setVisible(true);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI g = new GUI();
        // TODO code application logic here
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1)
            setBackground(Color.GREEN);
        
    }
    
}

