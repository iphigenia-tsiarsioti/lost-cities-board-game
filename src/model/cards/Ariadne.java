package model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.anaktora.AnaktoraType;

/**
 * Class Ariadne 
 * 
 */
public class Ariadne extends SpecialCard{

	/**
	 * Constructor.
	 * Postcondition: Creates a new Ariadne card with step 2.
	 */
	public Ariadne(AnaktoraType type,String image){
		super(2,type,image);
	}
}
