/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pawns;

import model.anaktora.AnaktoraType;
import model.positions.Position;

/**
 *
 * @author iphigenia
 */
public class Pioni {
    
private Position position;
	private Pawn name;
	private AnaktoraType type;
        private int index;
        
	/**
	 * Constructor
	 * Postcondition: Creates a new Pioni with name "name" and position "null"
	 * @param String name
	 */
	public Pioni(Pawn name){
		this.name=name;
		this.position=null;
                this.type=null;
                this.index=0;
	}
	
	/**
	 * Transformer: Sets the current position of the pawn 
	 * Postcondition: Current position of the pawn has been set
	 * @param Position position
	 */
	public void setCurrentPosition(Position position){
		this.position=position;
                
	}
	
	/**
	 * Accessor: Returns the current position of the pawn
	 * Postcondition: Current position of the pawn has been returned
	 * @return Position position
	 */
	public Position getCurrentPosition(){
		return this.position;
	}
	
        /**
	 * Transformer: Sets the index of the pawn 
	 * Postcondition: Index of the pawn has been set
	 * @param int index
	 */
        public void setIndex(int index){
            this.index=index;
        }
        /**
	 * Accessor: Returns the current index of the pawn
	 * Postcondition: Current index of the pawn has been returned
	 * @return int index
	 */
        public int getIndex(){
            return this.index;
        }

        /**
	 * Transformer: Sets the anaktoratype of the pawn 
	 * Postcondition:Type of the pawn has been set
	 * @param AnaktoraType type
	 */
        public void setType(AnaktoraType type){
            this.type=type;
        }
        /**
	 * Accessor: Returns the anaktoratype of the pawn
	 * Postcondition:Type of the pawn has been returned
	 * @return AnaktoraType type
	 */
        public AnaktoraType getType(){
            return this.type;
        }
        
        /**
	 * Accessor: Returns the type of the pawn
	 * Postcondition: Type of the pawn has been returned
	 * @return Pawn type of the pioni
	 */
        public Pawn getPawnType(){
            return this.name;
        }
        
       
}
