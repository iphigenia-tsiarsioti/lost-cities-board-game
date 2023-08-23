package model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;

/**
 * Class NumberCard
 * @author iphigenia
 *
 */
public class NumberCard implements Card{
	private int value,steps;
	private AnaktoraType type;
        private String image;
	
	
	/**
	 * Constructor.
	 * Postcondition: Creates a new NumberCard with value between 1 and 10 and step 1 and type "type"
	 * @param int value
	 */
	
	public NumberCard(int value,AnaktoraType type,String image){
		this.value=value;
		this.steps=1;
		this.type=type;
		this.image=image;
	}

	/**
	 * Transformer: Sets the value of the card
	 * Postcondition: Value of the card has been set
	 * @param int value
	 */
	@Override
	public void setValue(int value) {
		this.value=value;
		
	}

	/**
	 * Accessor: Returns the value of the card
	 * Postcondition: Value of the card has been returned 
	 * @return int value
	 */
	@Override
	public int getValue() {
		return this.value;
	}

	/**
	 * Transformer: Sets the steps of the card
	 * Postcondition: Steps of the card has been set
	 * @param int steps
	 */
	@Override
	public void setSteps(int steps) {
		this.steps=steps;
		
	}
	
	/**
	 * Accessor: Returns the steps of the card
	 * Postcondition: Steps of the card has been set
	 * @return int steps
	 */
	@Override
	public int getSteps() {
		return this.steps;
	}
	
	/**
	 * Transformer: Sets the type of the card
	 * Postcondition: Type of the card has been set
	 * @param AnaktoraType type
	 */
	@Override
	public void setType(AnaktoraType type){
		this.type=type;
	}
	
	/**
	 * Accessor: Return the type of the card
	 * Postcondition: Type of the card has been returned
	 * @return AnaktoraType type of the card
	 */
	@Override
	public AnaktoraType getType(){
		return this.type;
	}
	
	/**
	 * Observer: Checks if a card can be played 
	 * @param Card c
	 * @return true if it can be played and false instead
	 */
            @Override
            public boolean matchCard(Card c){
            if(c==null) return true;
            if(c.getType()==this.type){
		if(this.value>=c.getValue()) return true;
            }
		return false;
	}
	
         /**
         * Transformer: Sets image for the card
         * Postcondition: image has been set
         * @param String image 
         */    
	public void setImage(String image){
		this.image=image;
	}
        /**
         * Accessor: Returns the image of the card
         * Postcondition: Image has been returned
         * @return Image image
         */
        public String getImage(){
            return this.image;
        }
}
