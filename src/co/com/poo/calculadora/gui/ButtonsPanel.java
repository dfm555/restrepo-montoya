/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poo.calculadora.gui;

import co.com.poo.calculadora.util.Constants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author crestrepo
 */
public class ButtonsPanel extends JPanel implements ActionListener {
    
    private JButton btnCero;
    private JButton btnUno;
    private JButton btnDos;
    private JButton btnTres;
    private JButton btnCuatro;
    private JButton btnCinco;
    private JButton btnSeis;
    private JButton btnSiete;
    private JButton btnOcho;
    private JButton btnNueve;
    private JButton btnPunto;
    private JButton btnSuma;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JButton btnResultado;
    
    private Window window;
    
    public ButtonsPanel(Window window) {
        this.window = window;
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new GridLayout(4, 4));
        
        btnSiete = new JButton("7");
        btnSiete.setActionCommand(Constants.BTN_SIETE);
        btnSiete.addActionListener(this);
        add(btnSiete);
        
        btnOcho = new JButton("8");
        btnOcho.setActionCommand(Constants.BTN_OCHO);
        btnOcho.addActionListener(this);
        add(btnOcho);
        
        btnNueve = new JButton("9");
        btnNueve.setActionCommand(Constants.BTN_NUEVE);
        btnNueve.addActionListener(this);
        add(btnNueve);
        
        btnSuma = new JButton("/");
        btnSuma.setActionCommand(Constants.BTN_DIVISION);
        btnSuma.addActionListener(this);
        add(btnSuma);
        
        btnCuatro = new JButton("4");
        btnCuatro.setActionCommand(Constants.BTN_CUATRO);
        btnCuatro.addActionListener(this);
        add(btnCuatro);
        
        btnCinco = new JButton("5");
        btnCinco.setActionCommand(Constants.BTN_CINCO);
        btnCinco.addActionListener(this);
        add(btnCinco);
        
        btnSeis = new JButton("6");
        btnSeis.setActionCommand(Constants.BTN_SEIS);
        btnSeis.addActionListener(this);
        add(btnSeis);
        
        btnResta = new JButton("*");
        btnResta.setActionCommand(Constants.BTN_MULTIPLICACION);
        btnResta.addActionListener(this);
        add(btnResta);
        
        btnUno = new JButton("1");
        btnUno.setActionCommand(Constants.BTN_UNO);
        btnUno.addActionListener(this);
        add(btnUno);
        
        btnDos = new JButton("2");
        btnDos.setActionCommand(Constants.BTN_DOS);
        btnDos.addActionListener(this);
        add(btnDos);
        
        btnTres = new JButton("3");
        btnTres.setActionCommand(Constants.BTN_TRES);
        btnTres.addActionListener(this);
        add(btnTres);
        
        btnResta = new JButton("-");
        btnResta.setActionCommand(Constants.BTN_RESTA);
        btnResta.addActionListener(this);
        add(btnResta);
        
        btnCero = new JButton("0");
        btnCero.setActionCommand(Constants.BTN_CERO);
        btnCero.addActionListener(this);
        add(btnCero);
        
        btnPunto = new JButton(".");
        btnPunto.setActionCommand(Constants.BTN_PUNTO);
        btnPunto.addActionListener(this);
        add(btnPunto);
        
        btnResultado = new JButton("=");
        btnResultado.setActionCommand(Constants.BTN_RESULTADO);
        btnResultado.addActionListener(this);
        add(btnResultado);
        
        btnSuma = new JButton("+");
        btnSuma.setActionCommand(Constants.BTN_SUMA);
        btnSuma.addActionListener(this);
        add(btnSuma);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        window.executeOperation(e.getActionCommand());
    }
}