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
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author crestrepo
 */
public class ElementsPanel extends JPanel implements ActionListener {
    
    private JTextField txtInput;
    private JButton btnClear;
    
    private Window window;
    
    public ElementsPanel(Window window) {
        this.window = window;
        initElements();
    }
    
    private void initElements() {
        setLayout(new GridLayout(1,4));
        
        txtInput = new JTextField();
        txtInput.setColumns(3);
        
        btnClear = new JButton("CE");
        btnClear.setActionCommand(Constants.BTN_CLEAR);
        btnClear.addActionListener(this);
        
        add(txtInput);
        add(btnClear);
    }
    
    public void putText(String text) {
        txtInput.setText(txtInput.getText() + text);
    }
    
    public void clearText() {
        txtInput.setText("");
    }
    
    public void evaluate() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            if (!txtInput.getText().isEmpty()) {
                Object result = engine.eval(txtInput.getText());
                txtInput.setText(String.valueOf((Double)result));
            } else {
                showMessage("Debe ingresar valores para evaluar");
            }
        } catch (Exception e) {
            showMessage("La expresión no es correcta");
            clearText();
        }
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(window, message);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        window.executeOperation(e.getActionCommand());
    }
}