package model.path;

import java.util.ArrayList;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;
import model.findings.DaxtylidiMinoa;
import model.findings.DiskosFaistou;
import model.findings.Findings;
import model.findings.KosmimaMaliwn;
import model.findings.RytoZakrou;
import model.positions.FindingPosition;
import model.positions.Position;
import model.positions.SimplePosition;
import model.random.Random2;
import model.random.RandomNumber;
/**Class Path 
 * 
 * @author iphigenia
 *
 */
public class Path {
	
	private ArrayList<Position> theseis=new ArrayList<Position>();
	private AnaktoraType type;
	private boolean positionsNotAvailable=false;
        private int sumOfFindings;
	
	/**
	 * Constructor. Creates a new path   
	 * @param AnaktoraType type 
	 */
	public Path(AnaktoraType type){
		this.type=type;
                this.sumOfFindings=0;
		init_positions();
		
		
	}
	
	/**
	 * Transformer: Initializes the 9 positions of the path
	 * Postcondition: Positions has been initialized
	 */
	public void init_positions(){
		int points=-20;
		
		for(int i=0;i<9;i++){
			theseis.add(new SimplePosition(-20));
			theseis.add(new FindingPosition(-15));
                        theseis.add(new SimplePosition(-10));
			theseis.add(new FindingPosition(5));
                        theseis.add(new SimplePosition(10));
			theseis.add(new FindingPosition(15));
                        theseis.add(new SimplePosition(30));
			theseis.add(new FindingPosition(35));
                        theseis.add(new FindingPosition(50));
		}
		
                
        }
	
	/**
	 * Transformer: Adds a position to the arraylist
	 * Postcondition: Position added to the arraylist
	 * @param Position position
	 */
	public void addPosition(Position position){
		theseis.add(position);
	}
	
	/**
	 * Accessor: Returns the arraylist of positions 
	 * Postcondition: Arraylist of positions has been returned
	 * @return ArrayList<Position> theseis
	 */
	public ArrayList<Position> getPosition(){
		return this.theseis;
	}
	
	/**
	 * Transformer: Sets the type of the path
	 * Postcondition: Type of the path has been set
	 * @param AnaktoraType type
	 */
	public void setType(AnaktoraType type){
		this.type=type;
	}
	
	/**
	 * Accessor: Returns the type of the path
	 * Postcondition: Type of the path has been set
	 * @return AnaktoraType type
	 */
	public AnaktoraType getType(){
		return this.type;
	}
	
        /**
         * Observer: Returns true if isAvailable and false otherwise
         * Postcondition: Returns true if isAvailable and false otherwise
         * @return Returns true if isAvailable and false otherwise
         */
	public boolean positionsNotAvailable(){
                if(sumOfFindings==4)    return true;
                return false;
	}
	
	/**
         * Transformer: Set a finding to a random position of the path
	 * Postcondition: Finding has been set
	 * @param Findings finding
	 */
	
	public void setFinding(Findings finding){
		int i=findAvailablePosition();
		((FindingPosition)theseis.get(i)).setFinding(finding);
                this.sumOfFindings++;
	}
        
     
        /**
         * Accessor:Find a available position and returns its index
         * Postcondition: Index has been returned
         * @return int index
         */ 
        public int findAvailablePosition(){
            int i;
            i=Random2.getRandomVal(0,8);
            while(!((FindingPosition)theseis.get(i)).isAvailable()){
                i=Random2.getRandomVal(0,8);
             
            }
            return i;
        }    
	
        /**
         * Accessor: Returns position in index
         * Postcondition: Position has been returned
         * @return Position position
         */
        
        public Position getTheseis(int i){
            return theseis.get(i);
        }
        
        /**
         * Accessor: Returns the finding in the position i
         * Postcondition: Finding returned
         * @param int i index of position
         * @return Findings finding in position i
         */
        public Findings getfind(int i){
            Position p=this.theseis.get(i);
            if(p.isFindingPosition()){
                if(((FindingPosition) p).getFinding()!=null) return ((FindingPosition) p).getFinding();
            }
            return null;
        }
}
