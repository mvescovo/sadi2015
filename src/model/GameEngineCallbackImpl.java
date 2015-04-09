package model;

import view.MainFrame;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback {
	MainFrame mainFrame;
	
	public GameEngineCallbackImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair,
			GameEngine engine) {
		int num1 = dicePair.getDice1();
		int num2 = dicePair.getDice2();
		int total = num1 + num2;
		
		// update console view
		System.out.printf("%s%s%s%d%s%d%s%d\n", "Player: ", player.getPlayerName(),
				", intermediate result = Dice 1: ", num1,
				", Dice 2: ", num2, " .. Total: ", total);
		
		// update GUI view
		mainFrame.getDicePanel().setDice1(Integer.toString(num1));
		mainFrame.getDicePanel().setDice2(Integer.toString(num2));
	}

	@Override
	public void result(Player player, DicePair dicePair, GameEngine engine) {
		int num1 = dicePair.getDice1();
		int num2 = dicePair.getDice2();
		int total = num1 + num2;
		
		// update console view
		System.out.printf("%s%s%s%d%s%d%s%d\n", "Player: ", player.getPlayerName(),
				", final result = Dice 1: ", num1,
				", Dice 2: ", num2, " .. Total: ", total);
		
		// update GUI view
		mainFrame.getDicePanel().setDice1(Integer.toString(num1));
		mainFrame.getDicePanel().setDice2(Integer.toString(num2));
		mainFrame.getToolBar().enableHouseRoll();
		mainFrame.getToolBar().focusHouseRolls();
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine engine) {
		int num1 = dicePair.getDice1();
		int num2 = dicePair.getDice2();
		int total = num1 + num2;
		
		// update console view
		System.out.printf("%s%s%d%s%d%s%d\n", "House: ",
				", intermediate result = Dice 1: ", num1,
				", Dice 2: ", num2, " .. Total: ", total);
		
		// update GUI view
		mainFrame.getDicePanel().setDice1(Integer.toString(num1));
		mainFrame.getDicePanel().setDice2(Integer.toString(num2));
	}

	@Override
	public void houseResult(DicePair dicePair, GameEngine engine) {
		int num1 = dicePair.getDice1();
		int num2 = dicePair.getDice2();
		int total = num1 + num2;
		
		// update console view
		System.out.printf("%s%s%d%s%d%s%d\n", "House: ",
				", final result = Dice 1: ", num1,
				", Dice 2: ", num2, " .. Total: ", total);
		
		// update GUI view
		mainFrame.getDicePanel().setDice1(Integer.toString(num1));
		mainFrame.getDicePanel().setDice2(Integer.toString(num2));
		mainFrame.getToolBar().enableDisplayResults();
		mainFrame.getToolBar().focusDisplayResults();
	}
}
