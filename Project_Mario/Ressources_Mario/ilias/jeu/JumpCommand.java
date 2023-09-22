package ilias.jeu;

import ilias.audio.Audio;

public class JumpCommand implements Command {
    private final Scene scene;
    
    public JumpCommand(Scene scene) {
        this.scene = scene;
    }
    
    @Override
    public void execute() {
        if(scene.mario.isVivant() && !scene.finDePartie()) { 
            scene.mario.setSaut(true);  
            Audio.playSound("/audio/saut.wav");
        }
    }
    public void undo() {
        scene.fall();
    }
}
