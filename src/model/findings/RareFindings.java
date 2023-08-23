package model.findings;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.positions.FindingPosition;

/**
 * Class RareFindings
 * @author iphigenia
 *
 */
public class RareFindings extends Findings{
	/**
	 * Constructor 
	 * Postcondition: Creates a new RareFindings with name "name" and price "price"
	 * @param String name
	 * @param int price
	 */
	public RareFindings(String name,int price,String description,String message,ImageIcon icon){
		super(name,price,description,message,icon);
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
		this.position=position;
		
	}
        
       
}
