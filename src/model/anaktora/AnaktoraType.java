package model.anaktora;
/**
 * Enum class AnaktoraType pou perigrafei ta 4 diaforetika anaktora
 * @author iphigenia
 *
 */
public enum AnaktoraType {
	knossos("Knossos"),malia("Malia"),zakros("Zakros"),phaistos("Phaistos");
	
	private String name;
	
	/**
	 * Constructor.
	 * Postcondition:Creates a new AnaktoraType with the specific name "name"
	 * @param String name
	 */
	AnaktoraType(String name){
		this.name=name;
	}
}
