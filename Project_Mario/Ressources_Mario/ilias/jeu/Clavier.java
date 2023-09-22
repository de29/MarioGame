package ilias.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;


public class Clavier implements KeyListener {
	private Map<Integer, Command> keyCommandMap = new HashMap<>();

    


    public Clavier(Command moveRightCommand, Command moveLeftCommand, Command jumpCommand) {
    }
    public void mapCommandToKey(Command command, int keyCode) {
        keyCommandMap.put(keyCode, command);
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    	Command command = keyCommandMap.get(e.getKeyCode());
        if (command != null) {
            command.execute();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.scene.mario.setMarche(false);
            Main.scene.setDx(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
	}
