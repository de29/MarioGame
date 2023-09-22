package ilias.affichage;

import java.util.ArrayList;
import java.util.List;

public class Score implements Observer{
	//**** VARIABLES ****//
	private final int NBRE_TOTAL_PIECES = 10;
	private int nbrePieces;
	 private List<Observer> observers = new ArrayList<>();	
	//**** CONSTRUCTEUR ****//
	public Score(){
		this.nbrePieces = 0;
	}		
	//**** GETTERS ****//
	public int getNbrePieces() {return nbrePieces;}

	public int getNBRE_TOTAL_PIECES() {return NBRE_TOTAL_PIECES;}

			
	//**** SETTERS ****//
	public void setNbrePieces(int nbrePieces) {this.nbrePieces = nbrePieces;}
	
	
	//**** METHODES ****//
	public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateObservers() {
        for (Observer observer : observers) {
            observer.update(nbrePieces);
        }
    }
    @Override
	public void update(int score) {
    	nbrePieces += score;
        updateObservers();
		
	}
    
    
    
    
}