package model.findings;

import javax.swing.ImageIcon;

/**
 * Class KosmimaMaliwn
 * @author iphigenia
 *
 */
public class KosmimaMaliwn extends RareFindings{
	/**
	 * Constructor
	 * Postcondition: Creates a new KosmimaMaliwn with name "Kosmima Maliwn" and price 25
	 */
	public KosmimaMaliwn(String description,String message,ImageIcon icon){
		super("Kosmima Maliwn",25,description, message,icon);
	}
}
