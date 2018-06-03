package fonctions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/*
 * Classe de gestion de la combobox du choix de couleur du smartphone de FrameSettings
 * code copié :  https://www.developpez.net/forums/d302785/java/interfaces-graphiques-java/awt-swing/faire-combo-simple-choix-couleur/
 * modifications Valentin Borntici
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class ImgComboRenderer extends JPanel implements ListCellRenderer {

	protected ImageIcon m_c = new ImageIcon();

	public ImgComboRenderer() {
		super();
		setBorder(new CompoundBorder(new MatteBorder(2, 10, 2, 10, Color.gray), new LineBorder(Color.black)));
		setSize(100, 100);
	}

	public Component getListCellRendererComponent(JList list, Object obj, int row, boolean sel, boolean hasFocus) {
		
		
//		if (obj instanceof ImageIcon) {
//			m_c = (ImageIcon) obj;
//
//		}
			
			 JLabel label = new JLabel((ImageIcon) obj) {
			      public Dimension getPreferredSize() {
			        return new Dimension(150, 80);
			      }
			    };
			    
		

		return label;
	}

	public void paint(Graphics g) {
		// setBackground(m_c);
		super.paint(g);
	}
}