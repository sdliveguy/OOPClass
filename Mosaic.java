// Author: Steven Nguyen
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

class XAndOTile extends JPanel {
    private int red, green, blue;
    private String letter;

    XAndOTile() {
        super();
        SetRandomValues();
    }

    final public void SetRandomValues() {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        // List of letters for random
        letter = "A";
        if (GetNumberBetween(0,25) == 1) {
            letter = "B";
        } else if (GetNumberBetween(0,25) == 2) {
            letter = "C";
        } else if (GetNumberBetween(0,25) == 3) {
            letter = "D";
        } else if (GetNumberBetween(0,25) == 4) {
            letter = "E";
        } else if (GetNumberBetween(0,25) == 5) {
            letter = "F";
        } else if (GetNumberBetween(0,25) == 6) {
            letter = "G";
        } else if (GetNumberBetween(0,25) == 7) {
            letter = "H";
        } else if (GetNumberBetween(0,25) == 8) {
            letter = "I";
        } else if (GetNumberBetween(0,25) == 9) {
            letter = "J";
        } else if (GetNumberBetween(0,25) == 10) {
            letter = "K";
        } else if (GetNumberBetween(0,25) == 11) {
            letter = "L";
        } else if (GetNumberBetween(0,25) == 12) {
            letter = "M";
        } else if (GetNumberBetween(0,25) == 13) {
            letter = "N";
        } else if (GetNumberBetween(0,25) == 14) {
            letter = "O";
        } else if (GetNumberBetween(0,25) == 15) {
            letter = "P";
        } else if (GetNumberBetween(0,25) == 16) {
            letter = "Q";
        } else if (GetNumberBetween(0,25) == 17) {
            letter = "R";
        } else if (GetNumberBetween(0,25) == 18) {
            letter = "S";
        } else if (GetNumberBetween(0,25) == 19) {
            letter = "T";
        } else if (GetNumberBetween(0,25) == 20) {
            letter = "U";
        } else if (GetNumberBetween(0,25) == 21) {
            letter = "V";
        } else if (GetNumberBetween(0,25) == 22) {
            letter = "W";
        } else if (GetNumberBetween(0,25) == 23) {
            letter = "X";
        } else if (GetNumberBetween(0,25) == 24) {
            letter = "Y";
        } else if (GetNumberBetween(0,25) == 25) {
            letter = "Z";
        }
    }

    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Oval color and shape
        g.setColor(new Color(red,green,blue));
        g.fillOval (10, 10, panelWidth-20, panelHeight-20);

        g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));

        final int fontSize=100;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2)-30;
        int stringY = (panelHeight/2)+30;
        g.drawString(letter,stringX,stringY);
    }

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn+128)%256);
    }
}

class MosaicFrame extends JFrame implements ActionListener {
    private ArrayList<XAndOTile> tileList;

    public MosaicFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton randomize = new JButton("Randomize");
        buttonPanel.add(randomize);
        randomize.addActionListener(this);

        JPanel xAndOGridPanel = new JPanel();
        contentPane.add(xAndOGridPanel, BorderLayout.CENTER);
        xAndOGridPanel.setLayout(new GridLayout(12,12));

        tileList = new ArrayList<XAndOTile>();
        for(int i=1; i<145; i++) {
            XAndOTile tile = new XAndOTile();
            tileList.add(tile);
            xAndOGridPanel.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(XAndOTile tile : tileList) {
            tile.SetRandomValues();
        }
        repaint();
    }
}

public class Mosaic {
    public static void main(String[] args) {
        System.out.println("Start paint***");

        MosaicFrame myMosaicFrame = new MosaicFrame();
        myMosaicFrame.setVisible(true);
    }
}