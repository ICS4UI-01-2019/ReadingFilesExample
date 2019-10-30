
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamon
 */
public class PictureFrame extends JComponent{
    private BufferedImage image;
    
    public void setImage(BufferedImage img){
        this.image = img;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
