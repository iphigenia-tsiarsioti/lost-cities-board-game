package model.findings;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;
import model.positions.FindingPosition;

/**
 * Class Findings
 * @author iphigenia
 *
 */
public abstract class Findings {
	protected String name,desription,message;
	protected int price;
	protected FindingPosition position;
	protected AnaktoraType type;
        protected boolean isAvailable;
        protected ImageIcon icon;
	
	/**
	 * Constructor 
	 * Postcondition: Creates a new Findings with name "name" and price "price"
	 * @param String name
	 * @param int price
	 */
	public Findings(String name,int price,String description,String message,ImageIcon icon){
		this.name=name;
		this.price=price;
		this.desription=description;
		this.position=null;
		this.type=null;
                this.isAvailable=true;
                this.message=message;
                this.icon=icon;
	}
	
	/**
	 * Abstract method
	 * Transformer: Sets the name of the finding
	 * Postcondition: Name of the finding has been set
	 * @param String name
	 */
	public abstract void setName(String name);
	
	/**
	 * Accessor: Returns the name of the finding
	 * Postcondition: Name of the finding has been set
	 * @return String name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Abstract method
	 * Transformer: Sets the description of the finding
	 * Postcondition: Description of the finding has been set
	 * @param String description
	 */
	public abstract void setDescription(String description);
	
	/**
	 * Accessor: Returns the description of the finding
	 * Postcondition: Description of the finding has been returned
	 * @return String description
	 */
	public String getDescription(){
		return this.desription;
	}
	
	/**
	 * Abstract method
	 * Transformer: Sets the price of the finding
	 * Postcondition: Price of the finding has been set
	 * @param int price
	 */
	public abstract void setPrice(int price);
	
	/**
	 * Accessor: Returns the price of the finding
	 * Postcondition: Price of the finding has been returned
	 * @return int price
	 */
	public int getPrice(){
		return this.price;
	}
	
	/**
	 * Abstract method
	 * Transformer: Sets the position of the finding
	 * Postcondition: Position of the finding has been set
	 * @param FindingPosition position
	 */
	public abstract void setPosition(FindingPosition position);
	
	/**
	 * Accessor: Returns the position of the finding
	 * Postcondition: Position of the finding has been returned
	 * @return FindingPosition position
	 */
	public FindingPosition getPosition(){
		return this.position;
	}
	
	/**
	 * Transformer: Sets the type of the card
	 * Postcondition: Type of the card has been set
	 * @param AnaktoraType type
	 */
	
	public void setType(AnaktoraType type){
		this.type=type;
	}
	
	/**
	 * Accessor: Return the type of the card
	 * Postcondition: Type of the card has been returned
	 * @return AnaktoraType type of the card
	 */
	
	public AnaktoraType getType(){
		return this.type;
	}
	
        /**
         * Transformer: sets the isAvailable
         * Postcondition: isAvailable has been set
         * @param boolean available 
         */
        public void setIsAvailable(boolean available){
            this.isAvailable=available;
        }
        /**
         * Observer: Returns true if isAvailable and false otherwise
         * Postcondition: Returns true if isAvailable and false otherwise
         * @return Returns true if isAvailable and false otherwise
         */
         public boolean getIsAvailable(){
            return this.isAvailable;
        }
                 
         /**
         * Accessor: Returns the message of the finding
         * Postcondition: Message of the finding has been returned
         * @return String message
         */
         public String getMessage(){
             return this.message;
         }
         
         /**
          * Accessor: Returns the icon of the finding
          * Postcondition: Icon of the finding has been returned
          * @return ImageIcon icon
          */
         public ImageIcon getIcon(){
            return this.icon;
         }    
}