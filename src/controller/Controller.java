package controller;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.anaktora.AnaktoraType;

import model.board.Board;
import model.cards.Ariadne;
import model.cards.Card;
import model.cards.Cards;
import model.cards.Minotaur;
import model.findings.Agalmatakia;
import model.findings.Findings;
import model.findings.Toixografies;
import model.path.Path;
import model.pawns.Pawn;
import model.players.Player;
import model.positions.FindingPosition;
import model.positions.Position;
import model.random.RandomNumber;
/**
 * Controller class
 * @author iphigenia
 *
 */
public class Controller {
	private Player player1=new Player();
	private Player player2=new Player();
	private ArrayList <Player> players=new ArrayList<Player>();
	private Board board=new Board();
	private boolean startCondition,roundCompleted,pathStart,IsAriadneCard,isMinotaurCard,gameFinished,CardPlayed=false,CardThrowed=false,CardCantPlayed=false;
	private int turn;
	
	/**
	 * Constructor
	 * Initializes the game 
	 * @throws Exception 
	 */
	public Controller() throws Exception{
		//board.getCard().initCards()
		
		players.add(player1);
		players.add(player2);
		
		moirasma();
		choosePlayerToStart();
                
	}
	
	/**
	 * Accessor: Returns the score of a player
	 * Postcondition: Score of the player has been returned
	 * @return int score 
	 */
	public int getScore(){
		return players.get(turn).getScore();//TODO: hmiteles
	}
		
	/**
	 * Transformer: Initializes the cards of the players
	 * Postcondition: Cards of the players have been initialized
	 * @throws Exception 
	 */
	public void moirasma() throws Exception{
		for(int i=0;i<8;i++){
			player1.setKartes(board.pickCard(i));
			player2.setKartes(board.pickCard(i));
		}
	}
	
	 /**
	  *Observer: Returns true if the game has not started and false otherwise
	  *Postcondition: Condition of the game has been returned
	  * @return true if the game has not started  false otherwise
	  */
	public boolean startCondition(){
	   return this.startCondition;
	}
	
	/**
	 * Observer: Returns true if the game has finished and false otherwise
	 * Precondition: gameHasFinished=false, startCondition=true
	 * Postcondition: Returns true if the game has finished and false otherwise
	 * @return true if the game has finished and false otherwise
	 */
	public boolean gameHasFinished(){
	    if(board.CardsLeft()==0 || checkCheckpoints())  {
               for(int i=0;i<2;i++){
                    players.get(i).setScore(players.get(i).getScore()+players.get(i).PawnsPoints());
                   System.out.println("To skor tou paixti "+i+" einai:"+players.get(i).getScore());
               }
               
               return true;
            }
            return false;
	}
	
        /**
         * Observer: Checks if checkpoints are 4
         * Postcondition: true or false
         * @return true or false
         */
        public boolean checkCheckpoints(){
           
            int sum=0;
            for(int i=0;i<4;i++){
                if(sum==4) return true;
                if(board.getPath(i).getTheseis(6).HasPioni()){
                    sum+=board.getPath(i).getTheseis(6).PioniaSize();
                }
                
                if(sum==4) return true;
            }
            return false;
        }
	
	
	/**
	 * Transformer: Sets player's turn 
	 * Postcondition: Player's turn has been set 
	 */
	public int ChangeTurn(){
		if(turn==0)	this.turn=1;
		else this.turn=0;
                return turn;
	}
	
        /**
         * Transformer: Sets the turn of the player
         * @param int turn 
         */
        public void setTurn(int turn){
            this.turn=turn;
        }
	/**
	 * Accessor: Returns the turn of the player
	 * Postcondition: Player's turn has been returned
	 * @return int turn of the player
	 */
	public int getTurn(){
		return this.turn;
	}
	
	/**
	 * Observer: Checks if we have a winner
	 * Postcondition: Returns true if we have a winner , gameHasFinished=true
	 * @return true if we have a winner or false instead
	 */
	public boolean hasWinner(){
		
                  if(players.get(0).getScore()>players.get(1).getScore()){
                      JOptionPane.showMessageDialog(null,"Νικητής!","Ο Παίχτης 1 κέρδισε!",JOptionPane.INFORMATION_MESSAGE);
                      return true;
                  }
                  else if(players.get(0).getScore()<players.get(1).getScore()){
                      JOptionPane.showMessageDialog(null,"Νικητής!","Ο Παίχτης 2 κέρδισε!",JOptionPane.INFORMATION_MESSAGE);  
                      return true;
                  }
                  else{
                      if(findWinner()==0){
                          JOptionPane.showMessageDialog(null,"Νικητής!","Ο Παίχτης 1 κέρδισε!",JOptionPane.INFORMATION_MESSAGE);
                          return true;
                      }else if(findWinner()==1){
                          JOptionPane.showMessageDialog(null,"Νικητής!","Ο Παίχτης 2 κέρδισε!",JOptionPane.INFORMATION_MESSAGE);
                          return true;
                      }
                      return false;
                  }
                 
	}
	
        /**
         * Finds the winner if there is 
         * @return int 0 if player1 wins 1 if player2 and -1 if there is tie
         */
        public int findWinner(){
              if(players.get(0).NumOfRareFindings()>players.get(1).NumOfRareFindings()) return 0;
              else if(players.get(0).NumOfRareFindings()<players.get(1).NumOfRareFindings()) return 1;
              else{
                  if(players.get(0).NumOfFresco()>players.get(1).NumOfFresco()) return 0;
                  else if(players.get(0).NumOfFresco()<players.get(1).NumOfFresco()) return 1;
                  else{
                     if(players.get(0).NumOfSnakes()>players.get(1).NumOfSnakes()) return 0;
                     else if(players.get(0).NumOfSnakes()<players.get(1).NumOfSnakes()) return 1; 
                     else return -1;
                  }
                  
              }
        
        }
	
	
	/**
	 * Transformer: Rejects a card  
	 * Postcondition: Card rejected
	 * @param Card card
	 * @throws Exception 
	 */
	public void throwCard(int i) throws Exception{
		if(!CardThrowed && !CardPlayed){
                    players.get(turn).getKartes().removeCard(i);
                    CardThrowed=true;
                }
                
	}
	
	/**
	 * Accessor: Gets a new card 
	 * Postcondition: Get new card completed 
	 * @throws Exception 
	 */
	public void getNewCard() throws Exception{
          
	    players.get(turn).setKartes(board.pickCard(0));
            CardPlayed=false;
            CardThrowed=false;
            CardCantPlayed=false;
	}
        
        /**
         * Observer:Checks if a card can be played
         * Postcondition: Returns true if it can be played and false otherwise
         * @return true or false
         */
        public boolean CardCantPlayed(){
            if(CardCantPlayed==true)    return true;
            return false;
        }
	
        /**
	 * Transformer: Plays a card 
	 * Postcondition: Card Played
	 * @param int i 
         * @throws Exception if not found 
	 */
        public void playCard(int i) throws Exception{
            //TODO: do stuff must call other methods
            //Pawn pioni;
            int k=0;
            int z;
            if(turn==0) z=1;
            else z=0;
            
            if(CardPlayed==false && CardThrowed==false)  {
                Card c=players.get(turn).getKartes().getCard(i);
                if(c.getType()==AnaktoraType.knossos)   k=0;
                else if(c.getType()==AnaktoraType.malia)   k=1;
                else if(c.getType()==AnaktoraType.phaistos)   k=2;
                else if(c.getType()==AnaktoraType.zakros)   k=3;
                if(c.matchCard(players.get(turn).getLastCard(k))){
                  
                    if(!(c instanceof Minotaur)){
                                          if(c instanceof Ariadne && players.get(turn).getLastCard(k)==null){
                            this.CardCantPlayed=true;
                            return;
           
                            
                        }else{
                            players.get(turn).movePawn(k,c).setCurrentPosition(board.getPath(k).getTheseis(players.get(turn).findPawn(k).getIndex()));
                            board.getPath(k).getTheseis(players.get(turn).findPawn(k).getIndex()).addPioni(players.get(turn).findPawn(k));
                           
                        }
                    }else if(c instanceof Minotaur ){
                        
                        if(players.get(z).getLastCard(k)==null || players.get(z).findPawn(k).getCurrentPosition()==board.getPath(k).getTheseis(0) ||  players.get(z).findPawn(k).getCurrentPosition()==board.getPath(k).getTheseis(6) ||  players.get(z).findPawn(k).getCurrentPosition()==board.getPath(k).getTheseis(7) ||  players.get(z).findPawn(k).getCurrentPosition()==board.getPath(k).getTheseis(8)){
                            this.CardCantPlayed=true;
                            return;
                        }
                        else{
                            
                            if(players.get(z).findPawn(k).getPawnType()!=Pawn.Theseus) {
                                if(players.get(z).findPawn(k).getIndex()==1){
                                    players.get(z).movePawn(k,c).setCurrentPosition(board.getPath(k).getTheseis(players.get(z).findPawn(k).getIndex()));
                                                                        board.getPath(k).getTheseis(players.get(z).findPawn(k).getIndex()).addPioni(players.get(z).findPawn(k));
                                }else if(players.get(z).findPawn(k).getIndex()==8){
                                    this.CardCantPlayed=true;
                                    return;
                                }
                                else{
                                    players.get(z).movePawn(k,c).setCurrentPosition(board.getPath(k).getTheseis(players.get(z).findPawn(k).getIndex()));
                                    board.getPath(k).getTheseis(players.get(z).findPawn(k).getIndex()).addPioni(players.get(z).findPawn(k));
                                    
                                }
                                   
                            }
                        }
                    }
                    if(!(c instanceof Ariadne) && !(c instanceof Minotaur))     players.get(turn).setLastCard(k,c);
                    players.get(turn).getKartes().removeCard(i);
                    CardPlayed=true;
                    
                    
                    if(!(c instanceof Minotaur))    z=turn;
                    
                     if(players.get(z).findPawn(k).getCurrentPosition().isFindingPosition()){  
                            FindingPosition p=(FindingPosition)players.get(z).findPawn(k).getCurrentPosition();
                            if(p.getFinding()!=null ){
                                Findings f=((FindingPosition)p).getFinding();
                                if(!players.get(z).FindingFound(f)){
                                players.get(z).addSyllogi(f);
                                if(!(f instanceof Toixografies))          p.setFinding(null);
                                JOptionPane.showMessageDialog(null,f.getDescription(),f.getMessage(),JOptionPane.INFORMATION_MESSAGE,f.getIcon());
                                if(!(f instanceof Agalmatakia)) players.get(z).setScore(players.get(z).getScore()+f.getPrice());
                                else{
                                    switch(players.get(z).NumOfSnakes()){
                                        case 1:players.get(z).setScore(players.get(z).getScore()-20);
                                                break;
                                        case 2:players.get(z).setScore(players.get(z).getScore()+5);
                                                break;
                                        case 3:players.get(z).setScore(players.get(z).getScore()+20);
                                                break;
                                        case 4:players.get(z).setScore(players.get(z).getScore()+10);
                                                break;
                                        case 5:players.get(z).setScore(players.get(z).getScore()+15);
                                                break;
                                        case 6:players.get(z).setScore(players.get(z).getScore()+15);
                                                break;
                                        case 7:players.get(z).setScore(players.get(z).getScore()+10);
                                                break;
                                        case 8:players.get(z).setScore(players.get(z).getScore()+15);
                                                break;
                                        case 9:players.get(z).setScore(players.get(z).getScore()+20);
                                                break;
                                        case 10:players.get(z).setScore(players.get(z).getScore()+10);
                                                break;        
                                    }
                                }
                                
                                }
                            }
                    }
                     else{  //ean den einai finding position kai i karta einai ariadne simainei oti perase panw apo finding position
                      //  if(c instanceof Ariadne)    if()
                     }
                     if(players.get(z).findPawn(k).getIndex()==0){
                        switch(k){
                            case 0: JOptionPane.showMessageDialog(null,"To minoiko anaktoro einai o kyrios episkepsimos xoros tis Knosoy (i Knossoy), simantikis polis kata tin arxaiotita, \nme synexi zoi apo ta neolithika xronia eos ton 5o ai. Einai xtismeno sto lofo tis Kefalas, \nme eykoli prosbasi sti thalassa alla kai sto esoteriko tis Kritis. Kata tin paradosi, ypirxe i edra toy sofoy basilia Minoa. \nSynarpastikoi mythoi, toy Labyrinthoy me to Minotayro kai toy Daidaloy me ton Ikaro, \nsyndeontai me to anaktoro tis Knossoy.", "Eftases sto Anaktoro tis Knosoy!!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/images/paths/knossosPalace.jpg"));
                                    break;
                            case 1: JOptionPane.showMessageDialog(null,"Anatolika apo ta simerina Malia brisketai to minoiko anaktoro ton Malion.\n Einai to trito se megethos anaktoro tis minoikis Kritis kai einai xtismeno se mia topothesia pronomiaki, konta sti thalassa kai pano \nsto dromo poy syndeei tin anatoliki me tin kentriki Kriti. To anaktoro ton Malion kata ti mythologia xrisimeye san katoikia toy Sarpidona, aderfoy toy Minoa, kai protoxtizetai to 1900 p.X. \nO proYparxon isxyros oikismos, apo ton opoio sozontai synoikies gyro apo to anaktoro, metatrepetai etsi se anaktoriko kentro-poli.", " Eftases sto Anaktoro ton Malion!!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/images/paths/maliaPalace.jpg"));
                                    break;
                            case 2: JOptionPane.showMessageDialog(null," To Minoiko Anaktoro tis Faistoy brisketai stin notio-kentriki Kriti, \nstin pediada tis Mesaras, 55 xiliometra notia apo to Irakleio kai se mikri apostasi apo ton arxaiologiko xoro \nstin Agia Triada, ton arxaiologiko xoro sti Gortyna kai ta Matala. To minoiko anaktoro tis Faistoy antistoixei se akmaia poli poy, oxi tyxaia, anaptyxthike stin efori pediada tis Mesaras kata toys proIstorikoys xronoys, \ndiladi apo to 6.000 p.X. peripoy mexri kai ton 1o p.X. aiona, opos epibebaionoyn ta arxaiologika eyrimata.", "  Eftases sto Anaktoro tis Faistoy!!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/images/paths/phaistosPalace.jpg"));
                                    break;
                            case 3: JOptionPane.showMessageDialog(null,"To anaktoro tis Zakroy einai to tetarto se megethostis Minoikis Kritis. \nBriskotan se simantiko stratigiko simeio, se asfalismeno kolpisko, kai itan kentro emporikon antallagon me tis xores tis Anatolis, \nopos fainetai apo ta eyrimata (xayliodontes elefanta, fagentiani, xalkos klp).  To anaktoro apotelese to kentro dioikisis, thriskeias kai emporioy. \nTo peristoixize i poli. Sto xoro den egine nea oikodomisi, ektos apo kapoies kalliergeies. ", " Eftases sto Anaktoro tis Zakroy!!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/images/paths/zakrosPalace.jpg"));
                                    break;        
                        }
                    }
                }
            }
            
            else return;
        } 
	/**
	 * Transformer: Chooses randomly who player will start first
	 * Precondition: gameHasFinished=false
	 * Postcondition: Player to play has been chosen,  
	 */
	public void choosePlayerToStart(){
		this.turn=RandomNumber.getRandomVal(0,1);
	}
	
	/**
	 * Accessor: Takes a card
	 * Postcondition: card in index i returned
	 * @param int i index of card  
	 */
	public Card getCard(int i){
		return board.getCard().getCard(i);
	}
        /**
         * Accessor:Returns the remaining cards
         * Postcondition: Remaining Cards returned
         * @return int sum
         */
        public int RemainingCards(){
            return board.CardsLeft();
        }
         
        /**
         * Accessor: Returns a player 
         * @param int i player to return
         * @return Player player
         */
        
        public Player getPlayer(int i){
            return players.get(i);
        }
        
        /**
         * Observer:Checks if a card played
         * Postcondition: Return true if it played and false otherwise
         * @return true or false
         */
        public boolean CardPlayed(){
            if(CardPlayed) return true;
            return false;
        
        }
        /**
         * Observer:Checks if a card throwed
         * Postcondition: Return true if it throwed and false otherwise
         * @return true or false
         */
        public boolean CardThrowed(){
            if(CardThrowed) return true;
            return false;
        }
        
        
}