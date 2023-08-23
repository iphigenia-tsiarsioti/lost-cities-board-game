package model.positions;

import java.util.ArrayList;

import model.cards.Cards;
import model.pawns.Pawn;
import model.pawns.Pioni;

/**
 * Abstract Class Position
 * @author iphigenia
 *
 */
public abstract class Position {
	private int score;
	private ArrayList<Pioni> pionia=new ArrayList<Pioni>();	//ayto mporei na ginei kai pinakas
		
	/**
	 * Constructor
	 * Postcondition: Creates a new Position with score "score"
	 * @param int score
	 */
	public Position(int score){
		this.score=score;
	}
	
	/**
	 * Accessor: Returns the score of the position 
	 * Postcondition: Score of the position has been returned
	 * @return int score
	 */
	public int getScore(){
		return this.score;
	}
	
	/**
	 * Transformer: Sets the score of a position
	 * Postcondition: Score of the position has been set
	 * @param int score
	 */
	public void setScore(int score){
		this.score=score;
	}
	
	/**
	 * Transformer: Adds a pawn to the specific position
	 * Postcondition: Pawn added to the position
	 * @param Pawn pioni
	 */
	public void addPioni(Pioni pioni){
		this.pionia.add(pioni);
	}
	
	/**
	 * Accessor: Returns the pawn with index i
	 * Postcondition: Pawn in index i has been returned
	 * @param int i
	 * @return Pawn pioni
	 */
	public Pioni getPioni(int i){
		return this.pionia.get(i);
	}
	
        /**
         * Observer: Returns true if is finding
         * Postcondition: returns true
         * @return  true or false
         */
	public abstract boolean isFindingPosition();
        
        /**
         * Observer: Checks if the position has pawn
         * @return true or false
         */
        public boolean HasPioni(){
            if(this.pionia.size()==0) return false;
            return true;
        }
	
        /**
         * Accessor returns how many pawns are in the position
         * @return int sum
         */
        public int PioniaSize(){
            return pionia.size();
        }
}
