package model.pawns;

import java.awt.Image;


import model.anaktora.AnaktoraType;
import model.positions.Position;
/**
 * Class enum Pawn
 * @author iphigenia
 *
 */
public enum Pawn {
	Theseus("Theseus"),Arxaiologos("Arxaiologos");

	private String name;
	
	/**
	 * Constructor
	 * Postcondition: Creates a new Pawn with name "name" and position "null"
	 * @param String name
	 */
	Pawn(String name){
		this.name=name;
		
	}
	

}
