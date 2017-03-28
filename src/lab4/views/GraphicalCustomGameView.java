/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author fabien
 */
public class GraphicalCustomGameView extends JPanel implements Observer{
    public GraphicalCustomGameView() {
        super();
        this.setLayout(new BorderLayout());
        
        /* Radio Button Panel */
        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.PAGE_AXIS));
        
        /* Radio Button Beginner */
        JRadioButton beginnerRadio = new JRadioButton("Beginner : 10 mines in a 9 x 9 field");
        beginnerRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelRadio.add(beginnerRadio);
        
        /* Radio Button Intermediaire */
        JRadioButton intermediaireRadio = new JRadioButton("Intermediaire : 40 mines in a 16 x 16 field");
        intermediaireRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelRadio.add(intermediaireRadio);
        
        /* Radio Button Expert */
        JRadioButton expertRadio = new JRadioButton("Expert : 90 mines in a 16 x 30 field");
        expertRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelRadio.add(expertRadio);
        
        /* Radio Button Custom */
        JRadioButton customRadio = new JRadioButton("Custom");
        customRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelRadio.add(customRadio);
        
        
        /* Add to global panel at NORTH position */
        this.add(panelRadio,BorderLayout.NORTH);
        
        
        /* Sliders Panel */
        JPanel sliderPanel = new JPanel(new GridLayout(3,3,0,0));
        
        JTextField jinputRow = new JTextField();
        JTextField jinputColumn = new JTextField();
        JTextField jinputMines = new JTextField();
        
        JSlider rows = new JSlider(JSlider.HORIZONTAL,9, 23, 9);
        rows.setMajorTickSpacing(2);
        rows.setMinorTickSpacing(1);
        rows.setPaintTicks(true);
        rows.setPaintLabels(true);
        
        JSlider columns = new JSlider(JSlider.HORIZONTAL, 9, 29, 19);
        columns.setMajorTickSpacing(4);
        columns.setMinorTickSpacing(2);
        columns.setPaintTicks(true);
        columns.setPaintLabels(true);
        
        JSlider mines = new JSlider(JSlider.HORIZONTAL, 9, 139, 76);
        mines.setMajorTickSpacing(26);
        mines.setMinorTickSpacing(13);
        mines.setPaintTicks(true);
        mines.setPaintLabels(true);
        
        JLabel labelText = new JLabel("Rows");
        labelText.setHorizontalAlignment(SwingConstants.CENTER);
        
        sliderPanel.add(labelText);
        sliderPanel.add(rows);
        sliderPanel.add(jinputRow);
        
        labelText = new JLabel("Columns");
        labelText.setHorizontalAlignment(SwingConstants.CENTER);
        
        sliderPanel.add(labelText);
        sliderPanel.add(columns);
        sliderPanel.add(jinputColumn);
        
        labelText = new JLabel("Mines");
        labelText.setHorizontalAlignment(SwingConstants.CENTER);
        
        sliderPanel.add(labelText);
        sliderPanel.add(mines);
        sliderPanel.add(jinputMines);
        
        /* Add to global panel at CENTER position */
        this.add(sliderPanel,BorderLayout.CENTER);
        
        /* Add validation button at SOUTH position */
        this.add(new JButton("OK"),BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
