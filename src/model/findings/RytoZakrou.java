package model.findings;

import javax.swing.ImageIcon;

/**
 * Class RytoZakrou
 * @author iphigenia
 *
 */
public class RytoZakrou extends RareFindings{
	/**
	 * Constructor
	 * Postcondition: Creates a new RytoZakrou with name "Ryto Zakrou" and price 25
	 */
	public RytoZakrou(String description,String message,ImageIcon icon){
		super("Ryto Zakrou",25,description,message,icon);
	}
}
