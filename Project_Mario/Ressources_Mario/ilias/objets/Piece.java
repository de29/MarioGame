package ilias.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import ilias.affichage.Observer;
import ilias.affichage.Score;


public class Piece extends Objet  implements Runnable,Observer{

	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int compteur;
	private Score score;

    
	
	//**** CONSTRUCTEUR	****//
    public Piece(int x, int y,Score score){
	    super(x, y, 30, 30);
	    
	    super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
        super.imgObjet = super.icoObjet.getImage();
	    
	    this.compteur = 0;
	    this.score = score;
	    if (score != null) {
	        score.addObserver(this);
	    }
    }

    //**** METHODES ****//
    public Image bouge(){ // Mouvement de la pièce   
    	
    	String str;
        this.compteur++;
		if (this.compteur / 100 == 0) {str = "/images/piece1.png";}
		else{str = "/images/piece2.png";}							    
		if (this.compteur == 200) {this.compteur = 0;}
		
		// Affichage de l'image du personnage
		ImageIcon ico = new ImageIcon(getClass().getResource(str));
        Image img = ico.getImage();
		return img;
    	
	}
    
    @Override
    public void update(int score) {
        // Add 1 to the player's score when a coin is collected
        this.score.setNbrePieces(this.score.getNbrePieces() + 1);
    }
    
	@Override
	public void run() {
		
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient compl�tement cr��s
		catch (InterruptedException e){}		
			
		while(true){ // boucle infinie											
			this.bouge();
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}	
		
	}
}
