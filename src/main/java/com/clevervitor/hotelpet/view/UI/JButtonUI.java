/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.view.UI;

import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.view.dialogs.DlgCadPet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author vitor
 */
public class JButtonUI extends LayerUI<Component> {

    private Shape forma;
    private boolean mousePressionado;
    private boolean mouseHovered;
    
    
    public JButtonUI() {

    }
    
    @Override
    public void paint(Graphics grphcs, JComponent jcomp){
        super.paint(grphcs, jcomp);
        Graphics2D g2d = (Graphics2D) grphcs.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int tamanho = 40;
        int x = jcomp.getWidth() - tamanho - 15; 
        int y = jcomp.getHeight()- tamanho - 15; 
        forma = new Ellipse2D.Double(x, y, tamanho, tamanho);
        g2d.setColor(new Color(51, 51, 51));
        g2d.fill(forma);
        g2d.dispose();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    @Override
    protected void processMouseEvent(MouseEvent e, JLayer<? extends Component> l) {
        System.out.println("Mouse funfou");
    }
    
    
}
