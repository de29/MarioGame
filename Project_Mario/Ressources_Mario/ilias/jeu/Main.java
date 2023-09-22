package ilias.jeu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Main {
	//**** VARIABLES ****//
	private static final int COMMAND_HISTORY_LIMIT = 10;
	private static List<Command> commandHistory = new ArrayList<>();
	private static int commandHistoryIndex = -1;
	public static Scene scene; // Toutes les classes ont accès à l'objet scene (static)

	public static void main(String[] args) {
		// Création de la fenetre de l'application
		JFrame fenetre = new JFrame("Mario Game");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);

		// Instanciation de l'objet scene
		scene = new Scene();
		fenetre.setContentPane(scene); // On associe la scene à la fenetre de l'application
		// create the command objects
		Command moveLeftCommand = new MoveLeftCommand(scene);
		Command moveRightCommand = new MoveRightCommand(scene);
		Command jumpCommand = new JumpCommand(scene);

		// create the invoker object
		Clavier clavier = new Clavier(moveRightCommand, moveLeftCommand, jumpCommand);
	
		// map the commands to the keys
		clavier.mapCommandToKey(moveLeftCommand, KeyEvent.VK_LEFT);
		clavier.mapCommandToKey(moveRightCommand, KeyEvent.VK_RIGHT);
		clavier.mapCommandToKey(jumpCommand, KeyEvent.VK_SPACE);
		// add the invoker as the key listener
		scene.addKeyListener(clavier);

		fenetre.setVisible(true);
	}

	public static void executeCommand(Command command) {
		command.execute();
		// add the executed command to the command history
		commandHistoryIndex++;
		if (commandHistoryIndex >= COMMAND_HISTORY_LIMIT) {
			commandHistory.remove(0);
			commandHistoryIndex--;
		}
		commandHistory.add(command);
	}

	public static void undoLastCommand() {
		if (commandHistoryIndex >= 0) {
			Command commandToUndo = commandHistory.get(commandHistoryIndex);
			commandToUndo.undo();
			commandHistoryIndex--;
		}
	}

	public static void redoLastUndoneCommand() {
		if (commandHistoryIndex < commandHistory.size() - 1) {
			commandHistoryIndex++;
			Command commandToRedo = commandHistory.get(commandHistoryIndex);
			commandToRedo.execute();
		}
	}
}
