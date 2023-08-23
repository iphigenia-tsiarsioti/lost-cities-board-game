package model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;

/**
 * Interface Card
 *
 */
public interface Card {
	
	/**
	 * Transformer: Sets the value of the card
	 * Postcondition: Value of the card has been set
	 * @param int value
	 */
	public void setValue(int value);

	/**
	 * Accessor: Returns the value of the card
	 * Postcondition: Value of the card has been returned 
	 * @return int value
	 */
	public int getValue() ;

	
	/**
	 * Transformer: Sets the steps of the card
	 * Postcondition: Steps of the card has been set 
	 * @param int steps
	 */
	public void setSteps(int steps);
	
	/**
	 * Accessor: Returns the steps of the card
	 * Postcondition: Steps of the card has been returned
	 * @return int steps
	 */
	public int getSteps();
	
	/**
	 * Transformer: Sets the type of the card
	 * Postcondition: Type of the card has been set
	 * @param AnaktoraType type
	 */
	public void setType(AnaktoraType type);
	

	/**
	 * Accessor: Return the type of the card
	 * Postcondition: Type of the card has been returned
	 * @return AnaktoraType type of the card
	 */
	public AnaktoraType getType();
	
	/**
	 * Observer: Checks if a card can be played 
	 * @param Card c
	 * @return true if it can be played and false instead
	 */
	public boolean matchCard(Card c);
	
        /**
         * Transformer: Sets image for the card
         * Postcondition: image has been set
         * @param String image 
         */
	public void setImage(String image);
        
        /**
         * Accessor: Returns the image of the card
         * Postcondition: Image has been returned
         * @return Image image
         */
        public String getImage();
}
