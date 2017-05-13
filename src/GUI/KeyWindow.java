/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Michael Roth
 */
public class KeyWindow extends JPanel {
    
    private String key = null;
    private boolean hasKey = false;
    private int iterator = 0;
    private char currentKey;
    private TableKey tK;
    private boolean manual = true;
    private boolean armed = false;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 20);
        
        if(armed)
            g.setColor(new Color(255,100,100));
        else
            g.setColor(new Color(255,255,0));
        
        g.fillRect(0, 0, 20, 20);
        
        int keyIterator;
        g.setFont(new Font("TimesRoman",Font.PLAIN,12));
        g.setColor(new Color(0,0,0));
        if((key != null) && manual) {
            keyIterator = iterator % key.length();
            currentKey = key.charAt(keyIterator);
            for(int i = 0; i < 10; i++) {
                g.drawString(Character.toString(key.charAt((keyIterator+i) % key.length())).toUpperCase(), i*20+6, 15);
            } // end for()
        } // end if()
        
        
        g.drawLine(0, 0, 200, 0);
        g.drawLine(0, 20, 200, 20);
        
        for(int i = 0; i <= 10; i++) {
            g.drawLine(i*20, 0, i*20, 20);
        } // end for()
    } // end method paintComponent(Graphics)
    
    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    } // end method getMaximumSize()
    
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    } // end method getMinimumSize()
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(201,21);
    } // end method getPrefferedSize()
    public void setKey(String key) {
        this.hasKey = true;
        this.key = key;
        currentKey = currentKey = key.charAt(0);
        repaint();
    } // end setter method setKey(String)
    public char getCurrentKey() {
        return this.currentKey;
    } // end getter method getCurrentKey()
    public void setTableKey(TableKey tK) {
        this.tK = tK;
    } // end setter method setTableKey()
    public void iterate() {
        iterator++;
        repaint();
    } // end method iterate()
    public String getKey() {
        return this.key;
    } // end getter method getKey()
    public void setManual(boolean m) {
        this.manual = m;
        repaint();
    } // end setter method setManual(boolean)
    public boolean hasKey() {
        return hasKey;
    } // end getter method hasKey()
    public void setArmed(boolean a) {
        this.armed = a;
        repaint();
    } // end setter method setArmed(boolean)
    public void resetIterator() {
        iterator = 0;
    } // end setter method resetIterator()
} // end class KeyWindow
