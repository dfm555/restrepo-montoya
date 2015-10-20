/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poo.calculadora.gui;

import co.com.poo.calculadora.util.Constants;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author crestrepo
 */
public class Window extends JFrame implements ActionListener {
    
    private ElementsPanel elementsPanel;
    
    private static final String CLEAR_ACTION = "CLEAR";
    private static final String CREDITS_ACTION = "CREDITS";
    private static final String EXIT_ACTION = "EXIT";
    
    public Window() {
        initComponents();
    }
    
    private void initComponents(){
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(300,180);
        setLocationRelativeTo(null);
        
        elementsPanel = new ElementsPanel(this);
        
        // Ícono
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("calculadora.png"));
        setIconImage(image);
        
        initMenu();
        
        ButtonsPanel buttonsPanel = new ButtonsPanel(this);
        add(elementsPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApplication();
            }
        });
    }
    
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        
        JMenuItem clearMenu = new JMenuItem("Clear");
        clearMenu.setActionCommand(CLEAR_ACTION);
        clearMenu.addActionListener(this);
        
        JMenuItem creditsMenu = new JMenuItem("Credits");
        creditsMenu.setActionCommand(CREDITS_ACTION);
        creditsMenu.addActionListener(this);
        
        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.setActionCommand(EXIT_ACTION);
        exitMenu.addActionListener(this);
        
        menu.add(clearMenu);
        menu.add(creditsMenu);
        menu.add(exitMenu);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    
    private void closeApplication(){
        int response = JOptionPane.showOptionDialog(this, "Desea cerrar la ventana",
                "Terminar programa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Si", "No"}, "Default");

        if (response == JOptionPane.OK_OPTION) {
            dispose();
        }
    }
    
    public void executeOperation(String operation) {
       try {
           switch (operation) {
               case Constants.BTN_CERO:
                   elementsPanel.putText("0");
                   break;
               case Constants.BTN_UNO:
                   elementsPanel.putText("1");
                   break;
                case Constants.BTN_DOS:
                   elementsPanel.putText("2");
                   break;
                case Constants.BTN_TRES:
                   elementsPanel.putText("3");
                   break;
                case Constants.BTN_CUATRO:
                   elementsPanel.putText("4");
                   break;
                case Constants.BTN_CINCO:
                   elementsPanel.putText("5");
                   break;
                case Constants.BTN_SEIS:
                   elementsPanel.putText("6");
                   break;
                case Constants.BTN_SIETE:
                   elementsPanel.putText("7");
                   break;
                case Constants.BTN_OCHO:
                   elementsPanel.putText("8");
                   break;
                case Constants.BTN_NUEVE:
                   elementsPanel.putText("9");
                   break;
                case Constants.BTN_PUNTO:
                   elementsPanel.putText(".");
                   break;
                case Constants.BTN_SUMA:
                   elementsPanel.putText("+");
                   break;
                case Constants.BTN_RESTA:
                   elementsPanel.putText("-");
                   break;
                case Constants.BTN_MULTIPLICACION:
                   elementsPanel.putText("*");
                   break;
                case Constants.BTN_DIVISION:
                   elementsPanel.putText("/");
                   break;
                case Constants.BTN_RESULTADO:
                   elementsPanel.evaluate();
                   break;
                case Constants.BTN_CLEAR:
                    elementsPanel.clearText();
                    break;
           }
       } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el dato de entrada");
       }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case CLEAR_ACTION:
                elementsPanel.clearText();
                break;
            case CREDITS_ACTION:
                JOptionPane.showMessageDialog(null, "Elaborado por:\nCarlos Restrepo\nDuber Montoya\n2015");
                break;
            case EXIT_ACTION:
                closeApplication();
                break;
        }
    }
}