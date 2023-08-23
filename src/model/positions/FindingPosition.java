package model.positions;

import java.util.ArrayList;

import model.findings.Findings;
/**
 * FindingPosition class
 * @author iphigenia
 *
 */
public class FindingPosition extends Position{
	private Findings finding;
        private boolean isAvailable=true;
	
	/**
	 * Constructor 
	 * Postcondition: Creates a FindingPosition with finding "finding" and score "score"
	 * @param Findings finding
	 * @param int score
	 */
	public FindingPosition(int score){
		super(score);
		this.finding=null;
	}
	
	/**
	 * Transformer: Sets the finding in a position
	 * Postcondition: Finding in position has been set
	 * @param Findings finding
	 */
	public void setFinding(Findings finding){
		this.finding=finding;
               isAvailable=false;
              
	}
	
	/**
	 * Accessor: Returns the finding in the position
	 * Postcondition: Finding in the position has been returned
	 * @return Findings finding
	 */
	public Findings getFinding(){
		return this.finding;
	}
	 /**
         * Observer: Returns true if is available
         * Postcondition: returns true
         * @return  true or false
         */
	public boolean isAvailable(){
		//if (this.finding!=null)	return false;
		//else return true;
                if(this.isAvailable) return true;
                return false;
	}
            /**
         * Observer: Returns true if is finding
         * Postcondition: returns true
         * @return  true or false
         */
	@Override
	public boolean isFindingPosition() {
		// TODO Auto-generated method stub
		return true;
	}
}
