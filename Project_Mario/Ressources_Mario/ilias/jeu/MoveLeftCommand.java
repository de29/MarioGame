package ilias.jeu;

public class MoveLeftCommand implements Command {
    private final Scene scene;
    
    public MoveLeftCommand(Scene scene) {
        this.scene = scene;
    }
    
    @Override
    public void execute() {
        if(scene.mario.isVivant() && !scene.finDePartie()) {
            // Annule le décalage de 1 crée par deplacementFond (PanJeu)
            if(scene.getxPos() == 4431) { 
                scene.setxPos(4430);
                scene.setxFond1(-50);
                scene.setxFond2(750);
            }
            scene.mario.setVersDroite(false);       	
            scene.mario.setMarche(true);
            scene.setDx(-1);
        }
    }
    public void undo() {
        scene.moveRight();
    }
}
