package model.positions;
/**
 * SimplePosition Class 
 * @author iphigenia
 *
 */
public class SimplePosition extends Position{

	/**
	 * Constructor
	 * Postcondition: Creates a new SimplePosition with score "score"
	 * @param int score
	 */
	public SimplePosition(int score){
		super(score);
	}
	
 /**
         * Observer: Returns true if is finding
         * Postcondition: returns true
         * @return  true or false
         */
	@Override
	public boolean isFindingPosition() {
		// TODO Auto-generated method stub
		return false;
	}
}
