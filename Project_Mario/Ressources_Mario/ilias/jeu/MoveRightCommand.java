package ilias.jeu;

public class MoveRightCommand implements Command {
    private final Scene scene;
    
    public MoveRightCommand(Scene scene) {
        this.scene = scene;
    }
    
    @Override
    public void execute() {
        if(scene.mario.isVivant() && !scene.finDePartie()) {
            // Annule le décalage de 1 crée par deplacementFond (PanJeu)
            if(scene.getxPos() == -1) { 
                scene.setxPos(0);
                scene.setxFond1(-50);
                scene.setxFond2(750);
            }
            scene.mario.setVersDroite(true);       	
            scene.mario.setMarche(true);
            scene.setDx(1);
        }
    }
    
    public void undo() {
        scene.moveLeft();
    }
}
