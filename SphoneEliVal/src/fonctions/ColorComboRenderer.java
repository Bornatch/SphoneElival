package fonctions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

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
public class ColorComboRenderer extends JPanel implements ListCellRenderer {

	protected Color m_c = Color.black;

	public ColorComboRenderer() {
		super();
		setBorder(new CompoundBorder(new MatteBorder(2, 10, 2, 10, Color.white), new LineBorder(Color.black)));
	}

	public Component getListCellRendererComponent(JList list, Object obj, int row, boolean sel, boolean hasFocus) {
		if (obj instanceof Color)
			m_c = (Color) obj;
		return this;
	}

	public void paint(Graphics g) {
		setBackground(m_c);
		super.paint(g);
	}
}