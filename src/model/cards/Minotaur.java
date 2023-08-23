package model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.anaktora.AnaktoraType;

/**
 * Class Minotaur
 * @author iphigenia
 *
 */
public class Minotaur extends SpecialCard{

	/**
	 * Constructor.
	 * Postcondition: Creates a new Minotaur card with step -2.
	 */
	public Minotaur(AnaktoraType type,String image){
		super(-2,type,image);
	}
}
