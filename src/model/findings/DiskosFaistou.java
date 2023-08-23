package model.findings;

import javax.swing.ImageIcon;

/**
 * Class DiskosFaistou
 * @author iphigenia
 *
 */
public class DiskosFaistou extends RareFindings{
	/**
	 * Constructor
	 * Postcondition: Creates a new DiskosFaistou with name "Diskos Faistou" and price 35
	 */
	public DiskosFaistou(String description,String message,ImageIcon icon){
		super("Diskos tis Faistou",35,description,message,icon);
	}
}
