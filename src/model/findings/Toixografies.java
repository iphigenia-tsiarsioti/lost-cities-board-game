package model.findings;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.positions.FindingPosition;

/**
 * Class Toixografies
 * @author iphigenia
 *
 */
public class Toixografies extends Findings{
	//private Image image;
	/**
	 * Constructor
	 * Postcondition: Creates a new Toixografies with name "Toixografia" and price "price" 
	 * @param price
	 */
	public Toixografies(int price,String description,String message,ImageIcon icon){
		super("Toixografies",price,description, message,icon);
		//this.image=image;	//TODO: na valw kai foto stis parametrous
	}


	/**
	 * Transformer: Sets the name of the finding
	 * Postcondition: Name of the finding has been set
	 * @param String name
	 */
	@Override
	public void setName(String name) {
		this.name=name;
		
	}
	
	/**
	 * Transformer: Sets the description of the finding
	 * Postcondition: Description of the finding has been set
	 * @param String description
	 */
	@Override
	public void setDescription(String description) {
		this.desription=description;
		
	}
	
	/**
	 * Transformer: Sets the price of the finding
	 * Postcondition: Price of the finding has been set
	 * @param int price
	 */
	@Override
	public void setPrice(int price) {
		
		this.price=price;
	}

	/**
	 * Transformer: Sets the position of the finding
	 * Postcondition: Position of the finding has been set
	 * @param FindingPosition position
	 */
	@Override
	public void setPosition(FindingPosition position) {
		this.price=price;
		
	}
       
}
