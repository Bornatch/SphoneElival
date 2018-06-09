package fonctions;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import BDContacts.Contacts;

public class ContactListRenderer extends JPanel implements ListCellRenderer<Contacts> {
	
	
	public ContactListRenderer() {
		super();
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Contacts> list, 
			Contacts value, int index,
			boolean isSelected, 
			boolean cellHasFocus) {
		
		
		
		//setText(value.ToString());
		return this;
	}

	

}
