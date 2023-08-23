package model.board;


import java.util.ArrayList;
import javax.swing.ImageIcon;

import model.anaktora.AnaktoraType;
import model.cards.Card;
import model.cards.Cards;
import model.findings.Agalmatakia;
import model.findings.DaxtylidiMinoa;
import model.findings.DiskosFaistou;
import model.findings.KosmimaMaliwn;
import model.findings.RytoZakrou;
import model.findings.Toixografies;
import model.path.Path;
import model.positions.FindingPosition;
import model.positions.Position;
import model.positions.SimplePosition;
import model.random.Random2;
import model.random.RandomNumber;
/**
 * Class Board gia to tamplo tou paixnidiou
 * @author iphigenia
 *
 */
public class Board {
	private Path[] path=new Path[4];
	private Cards kartes=new Cards();
	
	/**
	 * Constructor.
	 * Postcondition: Creates a new Board which initializes the 4 paths of the game and the cards 
	 */
	public Board(){
		
		
		init_paths();
		
		kartes.initCards();
		
		init_other_findings();
		
                
	}
	
	/**
	 * Transformer: Initializes the 4 paths
	 * Postcondition: Paths have been initialized		
	 */
	public void init_paths(){
		path[0]=new Path(AnaktoraType.knossos);
		path[1]=new Path(AnaktoraType.malia);
		path[2]=new Path(AnaktoraType.phaistos);
		path[3]=new Path(AnaktoraType.zakros);
		
               init_fin();  //initializes the rarefindings of each path
	}
	
	/**
	 * Accessor: Returns the list of cards
	 * Postcondition: List of cards has been returned
	 * @returns the list of Cards kartes
	 */
	public Cards getCard(){
		return this.kartes;
	}
	
	/**
	 * Transformer: Sets a path 
	 * Postcondition: Path has been set
	 * @param Path path
	 */
	public void setPath(Path path){
		
	}
	
        /** Accessor: Returns the the path which is in the k index of the array
	 * Postcondition: Path has been returned
	 * @returns the path
        */
        public Path getPath(int k){
            return this.path[k];
        }
        
        /**
         * Transformer: Gets a card from cards,removes it from the list and returns it
         * @param  int i
         * @return Card card
         * @throws Exception if card not found
         */
	public Card pickCard(int i) throws Exception{
		Card card=this.kartes.getCard(i);
		kartes.removeCard(kartes.getCard(i));
		return card;
	}
	/**
	 * Accessor: Returns the path of a specific type
	 * Postcondition: Path has been returned
	 * @return AnaktoraType path if it is existed or null instead
	 */
	public Path getPath(AnaktoraType type){
		int i=0;
		while(i<path.length){
			if(path[i].getType()==type) return path[i];
		}
		return null;
	}
	
	/**
         * Transformer: Initializes the fresco and snakegodess
         * Chooses a random path and sets the finding there in a random position
         * Postcondition: Findings has been initialized
         */
	public void init_other_findings(){
		int k=0;
		while(k<16){
			int i=RandomNumber.getRandomVal(0,3);
			while(path[i].positionsNotAvailable()) {
                            i=RandomNumber.getRandomVal(0,3);
                        }
			if(k<10){
                            
                            path[i].setFinding(new Agalmatakia("Os i thea me ta fidia onomazetai o typos agalmatidioy poy brethike se anaskafes stoys Minoikoys \narxaiologikoys topoys poy paroysiazei gynaika na krataei fidia. Ta agalmatida xronologoyntai ston 16o aiona p.X.. Liges plirofories exoyme gia tin ermineia ton agalmatidion. \nO Ebans syndeei tin thea ton ofeon me tin Aigyptiaki thea Oyatzet. Einai propompos tis kritikis Reas kai paroysiazei megali omoiotita me tin frygiki Kybeli \nkai tin efesia Artemida.","Brikes ena agalma tis THeas ton Fidion!!!",new ImageIcon("src/images/findings/snakes.jpg")));
                        }
			else {
                            
				switch(k){
				case 10: path[i].setFinding(new Toixografies(20,"Omorfes Minoitisses poy koybentiazoyn. Exoyn oraia foremata, symfona me ti moda tis epoxis, \nomorfa xtenismena mallia kai polytima kosmimata.","Fotografises tin Toixografia: Oi galazeis kyries!!!",new ImageIcon("src/images/findings/fresco1_20.jpg")));
						break;
				case 11: path[i].setFinding(new Toixografies(20,"Ta tayrokathapsia itan ena agonisma poy synithizotan poly sta minoika xronia. \nPerilambane to piasimo toy tayroy apo ta kerata, to epikindyno alma sti raxi toy zooy kai telos to pidima sto edafos piso toy.","Fotografises tin Toixografia: Ta tayrokathapsia!!!",new ImageIcon("src/images/findings/fresco2_20.jpg")));
						break;
				case 12: path[i].setFinding(new Toixografies(20,"Eikonizetai epiblitiki andriki morfi, poy badizei pros ta aristera se aprosdioristo erythro fonto. \nForaei to typiko minoiko perizoma me fardia zoni, perideraio sto laimo kai ploysio kalymma kefalis diakosmimeno me krina kai ftera pagonioy. I stasi ton xerion toy deixnei oti isos eserne me to aristero toy xeri ena zoo i kapoio mythiko teras, grypa i sfigga. O neos onomasthike apo toys ereynites Β«prigkipasΒ», giati theorithike oti apodidei to basilia-ierea, poy zoyse sto anaktoro tis Knosoy.!!!","Fotografises tin Toixografia: O prigkipas me ta krina",new ImageIcon("src/images/findings/fresco4_20.jpg")));
						break;
				case 13: path[i].setFinding(new Toixografies(15,"I toixografia ayti proerxetai apo to megaro tis basilissas. \nDelfinia kolympoyn anamesa se psaria, mesa sta kymata.","Fotografises tin Toixografia: Ta delfinia!!!",new ImageIcon("src/images/findings/fresco3_15.jpg")));
						break;
				case 14: path[i].setFinding(new Toixografies(15,"Neoi lambanoyn meros se thriskeytiki pompi kai feroyn aggeia me dora gia ti theotita i gia to basilia.\n I toixografia ayti kosmoyse ton legomeno Β«diadromo tis pompisΒ» toy anaktoroy tis Knosoy.","Fotografises tin Toixografia: Pompi neon!!!",new ImageIcon("src/images/findings/fresco5_15.jpg")));
						break;
				case 15: path[i].setFinding(new Toixografies(15,"Eikonizetai mia gynaika aristokratikis katagogis se thesi profil.  Onomastike Β«ParizianaΒ» apo ton Ξ†rthoyr Ebans,\n giati to 1903 (etos poy anakalyfthike) ta megala matia, ta katsara mallia, ta entona kokkina xeili \nkai i anasikomeni myti theoroyntan ta ideodi tis gynaikeias omorfias, ta opoia mono mia omorfi gynaika \napo β€¦ to Parisi mporoyse na ta ensarkosei.","Fotografises tin Toixografia: I pariziana!!!",new ImageIcon("src/images/findings/fresco6_15.jpg")));
						break;
				}
			}
			k++;
		}
	}
        
        /**
         * Accessor: Returns the number of the cards left to be played
         * Postcondition: NumOfCards has been returned
         * @return int sumOfCards 
         */
        public int CardsLeft(){
           
            return kartes.SumofCards();
        }
        
        /**
         * Transformer:Initializes the rare findings to their path
         * Postcondition:Rare Findings has been initialized
         */
        
        public void init_fin(){
            for(int i=0;i<4;i++){
                int z=Random2.getRandomVal(0, 8);
                switch(i){
                    case 0: ((FindingPosition)path[i].getTheseis(z)).setFinding(new DaxtylidiMinoa("To Β«Daxtylidi toy MinoaΒ», ena apo ta megalytera kai spaniotera xrysa sfragidika ston kosmo, \ntheoreitai apo ta kalytera deigmata tis kritomykinaIkis sfragidikis. Ferei syntheti thriskeytiki parastasi, poy apeikonizei morfes oi opoies entassontai stin kritomykinaIki thematologia, \ndentrolatria me kathisti thea, oyrano, gi kai thalassa, me iero ploio poy exei morfi ippokampoy.","Anakalypses to Daxtylidi toy Minoa !!!",new ImageIcon("src/images/findings/ring.jpg")));
                            System.out.println("Mpkie to "+path[i].getTheseis(z)+" sti thesi "+z);
                            break;
                    case 1: ((FindingPosition)path[i].getTheseis(z)).setFinding(new KosmimaMaliwn("To xryso kosmima ton melisson poy filoxeneitai sto Arxaiologiko Moyseio Irakleioy, einai diasimo arxaiologiko eyrima apo ton Xrysolakko, ton tafiko peribolo tis nekropolis ton Malion.","Anakalypses to Kosmima ton Malion!!!",new ImageIcon("src/images/findings/kosmima.jpg")));
                    System.out.println("Mpkie to "+path[i].getTheseis(z)+" sti thesi "+z);
                               break;
                    case 2: ((FindingPosition)path[i].getTheseis(z)).setFinding(new DiskosFaistou("O Diskos tis Faistoy einai ena arxaiologiko eyrima apo ti Minoiki poli tis Faistoy \nsti notia Kriti kai xronologeitai pithanos ston 17o aiona p.X.. Apotelei ena apo ta gnostotera mystiria tis arxaiologias, \nafoy o skopos tis kataskeyis toy kai to noima ton oson anagrafontai se ayton paramenoyn agnosta. O diskos anakalyfthike stis 3 Ioylioy 1908 \napo ton Italo arxaiologo Loyitzi Pernie (Luigi Pernier) kai fylassetai simera sto Arxaiologiko Moyseio Irakleioy. ","Anakalypses to Disko tis Faistoy!!!",new ImageIcon("src/images/findings/diskos.jpg")));
                    System.out.println("Mpkie to "+path[i].getTheseis(z)+" sti thesi "+z);
                            break;
                    case 3: ((FindingPosition)path[i].getTheseis(z)).setFinding(new RytoZakrou("To aggeio brethike sto thisayrofylakio toy anaktoroy tis Zakroy mazi me alla monadika \nsto eidos toys teletoyrgika skeyi tis neoanaktorikis epoxis kai apotelei xaraktiristiko paradeigma tis efeyretikotitas \nkai kalaisthisias ton Minoiton texniton.","Anakalypses to Ryto tis Zakroy!!!",new ImageIcon("src/images/findings/ruto.jpg")));
                    System.out.println("Mpkie to "+path[i].getTheseis(z)+" sti thesi "+z);
                            break;
                }
                
            }
        }
        
}
