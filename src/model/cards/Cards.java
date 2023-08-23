package model.cards;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;
/**
 * Class Cards gia oles tis kartes
 * @author iphigenia
 *
 */
public class Cards {
	protected ArrayList<Card> cards;
	/**
	 * Constructor.
	 * Postcondition: Creates a new Cards with a new ArrayList of Card
	 */
	public Cards(){
		this.cards=new ArrayList<Card>();
	}
	
	/**
	 * Observer: Checks if all the cards have been played
	 * Postcondition: Returns true if the list is empty
	 * @return true  if the list is empty or false instead
	 */
	public boolean isEmpty(){
		return true;
	}
	
	/**
	 * Transformer: Adds a card to the arraylist
	 * Postcondition: Card has been added to the arraylist
	 * @param Card c
	 * @throws Exception
	 */
	public void addCard(Card c) throws Exception{
		if(c==null) throw new Exception("I karta einai null");
		cards.add(c);
	}
	
	/**
	 * Accessor: Removes a card from the arraylist
	 * Postcondition: Card has been removed from the arraylist
	 * @param Card c
	 * @throws Exception
	 */
	public void removeCard(Card c) throws Exception{
		if(c==null) throw new Exception("I karta einai null");
		cards.remove(c);
	}
	
        
        public void removeCard(int c) throws Exception{
		//if(c==null) throw new Exception("I karta einai null");
		cards.remove(c);
	}
        
	/**
	 * Accessor: Returns the card in position x of the arraylist
	 * Postcondition: Card in the position x has been returned
	 * @param int x
	 * @return Card in position x
	 */
	public Card getCard(int x){
		return this.cards.get(x);
	}
	
	/**
	 * Transformer: Initializes the cards in the arraylist
	 * Postcondition: Cards in the arraylist has been initialized
	 */
	public void initCards(){
		int i;

                ImageIcon image=null;
		for(AnaktoraType type:AnaktoraType.values()){
			for(i=0;i<10;i++){
                           
                               // image = new ImageIcon((getClass().getResource("/images/cards/"+type+"Ari.jpg")));
                                
				if(i<3){
					cards.add(new Ariadne(type,("./src/images/cards/"+type+"Ari.jpg")));
					if(i<2) cards.add(new Minotaur(type,("./src/images/cards/"+type+"Min.jpg")));
				}
				cards.add(new NumberCard(i+1,type,("./src/images/cards/"+type+(i+1)+".jpg")));
				cards.add(new NumberCard(i+1,type,("./src/images/cards/"+type+(i+1)+".jpg")));
			}	
		}
		shuffleCards();
	}
	
	/**
	 * Transformer: Shuffle the cards in the arraylist
	 * Postcondition: Cards in the arraylist has been shuffled
	 */
	public void shuffleCards(){
		Collections.shuffle(cards);
	}
	
        /**
         * Accessor: Returns the sum of the cards
         * Postcondition: sum of the cards has been returned
         * @return int sumofcards
         */
	public int SumofCards(){
            return this.cards.size();
        }
        
        
}
