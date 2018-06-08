package fonctions;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import bdContactsMain.Contacts;

public class ContactListRenderer extends JPanel implements ListCellRenderer<Contacts> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Contacts> list, Contacts value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		return null;
	}

}
