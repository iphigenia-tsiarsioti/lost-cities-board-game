package model.players;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.anaktora.AnaktoraType;
import model.cards.Ariadne;

import model.cards.Card;
import model.cards.Cards;
import model.cards.Minotaur;
import model.cards.NumberCard;
import model.findings.Agalmatakia;
import model.findings.Findings;
import model.findings.RareFindings;
import model.findings.Toixografies;
import model.pawns.Pawn;
import model.pawns.Pioni;
import model.positions.Position;

/**
 * Class Player
 * @author iphigenia
 *
 */
public class Player {
	
	private ArrayList<Pioni> pionia=new ArrayList<Pioni>();
	private int score;
	private Cards kartes=new Cards();
	private Card[] LastCardPlayed=new Card[4]; 
	private ArrayList<Findings> syllogi=new ArrayList<Findings>();
	
	/**
	 * Constructor. Creates a new player with name "name",cardsPlayed "null" and points to 0.
	 * @param String name
	 */
	public Player(){
		
		this.score=0;
		//this.LastCardPlayed=null;
		init_pawns();
                init_lastCards();
	}
	
        /**
	 * Transformer:Add a finding to syllogi
	 * Postcondition: Finding added to syllogi
	 * @param Findings finding
	 */
        public void addSyllogi(Findings finding){
            syllogi.add(finding);
        }
        
        /**
	 * Transformers: Initializes the last cards to null
	 * Postcondition: Last cards initialized
	 * 
	 */
         public void init_lastCards(){
             for(int i=0;i<4;i++){
                 this.LastCardPlayed[i]=null;
             }
         }
	
	/**
	 * Accessor: Return the points of the player
	 * Postcondition: Points of the player has been returned
	 * @return int points
	 */
	public int getScore(){
		return this.score;
	}
	
	/**
	 * Transformer: Set the points of the player
	 * Postcondition: Points of the player has been set
	 * @param int points
	 */
	public void setScore(int points){
		this.score=points;
	}
	
        /**
	 * Transformer: Set karte to player
	 * Postcondition: Kartes set
	 * @param Card c
         * @throws Exception if card not found
	 */
	public void setKartes(Card c) throws Exception{
		kartes.addCard(c);
	}
	/**
	 * Accessor: Returns the ccards
	 * Postcondition: Cards has been returned
	 * @return Cards cards
	 */
	public Cards getKartes(){
		return this.kartes;
	}
	
	/**
	 * Transformer: Initializes the pawns of the player
	 * Postcondition: Pawns initialized
	 */
	public void init_pawns(){
		pionia.add(new Pioni(Pawn.Arxaiologos));
		pionia.add(new Pioni(Pawn.Arxaiologos));
                pionia.add(new Pioni(Pawn.Arxaiologos));
		pionia.add(new Pioni(Pawn.Theseus));
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
	 * Transformer: Sets the last card played by the player
	 * Postcondition: Last played card has been set
	 * @param Card c
	 */
        public void setLastCard(int i,Card c){
            this.LastCardPlayed[i]=c;
        }
        /**
	 * Accessor: Returns the last card played by the player
	 * Postcondition: Last card has been returned
	 * @return Card card
	 */
        public Card getLastCard(int i){
            if(this.LastCardPlayed[i]==null)    return null;
            return this.LastCardPlayed[i];
        }
        
        /**
	 * Accessot: Returns the number of arxaiologoi
	 * Postcondition: arxaiologoi returned
	 * @return int sum
	 */
        public int NumOfArch(){
            int sum=0;
            for(int i=0;i<3;i++){
               if(pionia.get(i).getCurrentPosition()==null)   sum++;
               
            }
            return sum;
        }
        
        /**
         * Observer
         * Postcondition: returns true if theseas is available and false otherwise
         * @return true or false
         */
        public boolean TheseusAvailable(){
            if(pionia.get(3).getCurrentPosition()==null) return true;
            return false;
        }    
        
        /**
         * Accessor: Gets pawn 
         * @return Pioni pawn
         */
        
        public Pioni getPawn(){
            int i=0;
            while(pionia.get(i).getCurrentPosition()!=null && i<pionia.size()) i++;
            if(pionia.get(i)!=null && i<pionia.size()) return pionia.get(i);
            return null;
        }
        
        /**
         * Accessor: Returns a available pawn
         * @param int k of the arraylist
         * @return Pioni pioni
         */
        public Pioni takeAvailablePawn(int k){
            int i=0;
            AnaktoraType type=null;
            if(k==0)  type=AnaktoraType.knossos;
            else if(k==1)  type=AnaktoraType.malia;
            else if(k==2) type=AnaktoraType.phaistos;
            else if(k==3) type=AnaktoraType.zakros;
           
            while(pionia.get(i).getType()!=null && i<pionia.size()-1)  i++;
            if(i<pionia.size()){
                if(pionia.get(i).getType()==null){
                    pionia.get(i).setType(type);
                    pionia.get(i).setIndex(0);
                    return pionia.get(i);
                }
            }
            return null;
        }
      
        /**
         * Transformer: Moves a pawn to a new position
         * Postcondition: Pawn moved
         * @param int k the type of path
         * @param Card c the card
         * @return Pioni pawn
         */
        public Pioni movePawn(int k,Card c){
            int i=0,y;
            AnaktoraType type=null;
            if(k==0)  type=AnaktoraType.knossos;
            else if(k==1)  type=AnaktoraType.malia;
            else if(k==2) type=AnaktoraType.phaistos;
            else if(k==3) type=AnaktoraType.zakros;
            if( this.getLastCard(k)==null) {
                if(TheseusAvailable() ){
                    y= Integer.parseInt(JOptionPane.showInputDialog( "Enter 1 for Arxaiologos or 2 for Theseus: "));
                    if(y==2){
                        pionia.get(3).setType(type);
                        pionia.get(3).setIndex(0);
                        return pionia.get(3);
                    }
                }
                while(pionia.get(i).getType()!=null && i<pionia.size())  i++;
                if(i<pionia.size()){
                    if(pionia.get(i).getType()==null){
                        pionia.get(i).setType(type);
                        pionia.get(i).setIndex(0);
                        return pionia.get(i);
                    }
                }
            }else{
                while(pionia.get(i).getType()!=type && i<pionia.size())  i++;
                if(pionia.get(i).getType()==type){
                    if(c instanceof Minotaur && pionia.get(i).getIndex()==1)     pionia.get(i).setIndex(0);
                    else if(c instanceof Ariadne && pionia.get(i).getIndex()==7)    pionia.get(i).setIndex(8);
                    else    pionia.get(i).setIndex((pionia.get(i).getIndex()+c.getSteps()));
                    
                    return pionia.get(i);
                }
           
            }
             return null;
        }
        
        /**
         * Accessor: Returns the pawn of type k
         * @param int k the type
         * @return Pioni pawn
         */
        public Pioni findPawn(int k){
            AnaktoraType type=null;
            if(k==0)  type=AnaktoraType.knossos;
            else if(k==1)  type=AnaktoraType.malia;
            else if(k==2) type=AnaktoraType.phaistos;
            else if(k==3) type=AnaktoraType.zakros;
            int i=0;
            while(pionia.get(i).getType()!=type && i<pionia.size()-1)  i++;
            if(pionia.get(i).getType()==type){
                return pionia.get(i);
            }
            return null;
        }
        
         /**
         * Accessor: Returns the pawn in index k
         * @param int k the index
         * @return Pioni pawn
         */
         public int findPawnIndex(int k){
            AnaktoraType type=null;
            if(k==0)  type=AnaktoraType.knossos;
            else if(k==1)  type=AnaktoraType.malia;
            else if(k==2) type=AnaktoraType.phaistos;
            else if(k==3) type=AnaktoraType.zakros;
            int i=0;
            while(pionia.get(i).getType()!=type && i<pionia.size()-1)  i++;
            if(pionia.get(i).getType()==type){
                return i;
            }
            return 0;
        }
         
          /**
         * Accessor: Returns the index of pawn
         * @param int k the type
         * @return Pioni pawn 
         */
        public int getIndexOfPawn(int k){
            int i=0;
         AnaktoraType type=null;
            if(k==0)  type=AnaktoraType.knossos;
            else if(k==1)  type=AnaktoraType.malia;
            else if(k==2) type=AnaktoraType.phaistos;
            else if(k==3) type=AnaktoraType.zakros;
            while(pionia.get(i).getType()!=type && i<pionia.size()-1)  i++;
                if(pionia.get(i).getType()==type){
                    //pionia.get(i).setIndex((pionia.get(i).getIndex()+c.getSteps()));
                    //System.out.println("to type einai "+ k +"kai to index tou pawn einai"+pionia.get(i).getIndex());
                    return pionia.get(i).getIndex();
                }
            return 0;    
        } 
        
       /**
         * Observer: Returns true if a finding is found by the player
         * @param Findings finding
         * @return true if found or false
         */
        public boolean FindingFound(Findings finding){
            int i=0;
            while(i<this.syllogi.size()){
                if(syllogi.get(i)==finding) return true;
                i++;
            }
            return false;
        }
        
        /**
         * Accessor: Returns the number of snakes found
         * Postcondition: number of snakes found returned
         * @return  int sum
         */
        public int NumOfSnakes(){
            int i=0,sum=0;
            if(this.syllogi==null)  return 0;
            while(i<this.syllogi.size()){
                if(syllogi.get(i) instanceof Agalmatakia) sum++;
                i++;
            }
            return sum;
        }
        
        /**
         * Accessor: Returns the number of rare findings found
         * Postcondition: number of rare findnigs found returned
         * @return  int sum
         */
        public int NumOfRareFindings(){
            int i=0,sum=0;
            if(this.syllogi==null)  return 0;
            while(i<this.syllogi.size()){
                if(syllogi.get(i) instanceof RareFindings) sum++;
                i++;
            }
            return sum;
        }
        
        /**
         * Accessor: Returns the number of fresco found
         * Postcondition: number of fresco found returned
         * @return  int sum
         */
        public int NumOfFresco(){
            int i=0,sum=0;
            if(this.syllogi==null)  return 0;
            while(i<this.syllogi.size()){
                if(syllogi.get(i) instanceof Toixografies) sum++;
                i++;
            }
            return sum;
        }
        
        /**
         * Accessor: Returns the finding in index i
         * Postcondition: finding in index i returned
         * @return  int sum
         */
        public Findings getSyllogi(int i){
            return this.syllogi.get(i);
        }
        
        /**
         * Accessor: Returns the size of the syllogu
         * Postcondition: size of syllogu returned
         * @return  int sum
         */
        public int SyllogiSize(){
            return this.syllogi.size();
        }
        
        /**
         * Accessor: Returns the points of the pawns in the position
         * Postcondition: points returned
         * @return  int sum
         */
        public int PawnsPoints(){
            int i=0,sum=0;
            while(i<pionia.size()){
               if(pionia.get(i).getCurrentPosition()!=null){
                   if(pionia.get(i).getPawnType()==Pawn.Theseus)  sum+= pionia.get(i).getCurrentPosition().getScore();
                   sum+= pionia.get(i).getCurrentPosition().getScore();
               
               }
               i++;
            }
            return sum;
        }
    
}
