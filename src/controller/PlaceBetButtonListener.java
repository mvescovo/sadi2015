package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import view.MainFrame;
import model.GameEngineClientStub;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBetButtonListener implements ActionListener {
	GameEngine gameEngine;
	MainFrame mainFrame;
	
	public PlaceBetButtonListener(GameEngine gameEngine, MainFrame mainFrame) {
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String bet = null;
		final int betInt;
		boolean betOk = true;

		// TODO fix this later to do validation using the validation class
		// get bet from user
		bet = mainFrame.getTableAndToolbarContainerPanel().getToolBar().getBetTextField().getText();
		betInt = Integer.parseInt(bet);
		
		// place the bet to the gameEngine
		gameEngine.placeBet(null, betInt);
		
		// TODO move this logic to the model then the model should return with an error and then display the error
//		
//		if (bet != null) {
//			try {
//				betInt = Integer.parseInt(bet);
//			} catch (NumberFormatException e2){
//				JOptionPane.showMessageDialog(mainFrame, "Bet needs to be a number.", "Invalid bet", 0);
//				System.out.println("bet not a number");
//				betOk = false;
//			}
//		}
//		
//		if ((betOk == true) && betInt < 0) {
//			JOptionPane.showMessageDialog(mainFrame, "Bet needs to be 0 or greater.", "Invalid bet", 0);
//			System.out.println("bet needs to be 0 or greater.");
//			betOk = false;
//		}
//		
//		if (betOk == true) {
//			// change model
//			if (gameEngine.placeBet(currPlayer, betInt) == true) {
//				// change view
//				System.out.printf("%s%d\n", "placed bet for: ", currPlayer.getBet());
		
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						mainFrame.getPlayerPanel().deductPoints(betInt);
						mainFrame.getPlayerPanel().setBetPoints(betInt);
						mainFrame.getPlayerPanel().showBet();
						mainFrame.getTableAndToolbarContainerPanel().getToolBar().disableBet();
						mainFrame.getMenu().getplaceBetMenuItem().setEnabled(false);
						mainFrame.getTableAndToolbarContainerPanel().getToolBar().getRollPlayerButton().setEnabled(true);
						mainFrame.getMenu().getRollPlayerMenuItem().setEnabled(true);
						mainFrame.getTableAndToolbarContainerPanel().getToolBar().focusPlayerRoll();
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getGameStatusLabel().setText("Roll the dice to continue");
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getPlayerResultLabel().setText("Player result: N/A");
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getPlayerResultLabel().setVisible(false);
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getHouseResultLabel().setText("House result: N/A");
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getHouseResultLabel().setVisible(false);
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getGameResultLabel().setText("Winner: N/A");
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getGameStatusPanel().getGameResultLabel().setVisible(false);
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getDicePanel().getDice1().setVisible(false);
						mainFrame.getTableAndToolbarContainerPanel().getGameTablePanel().getDicePanel().getDice2().setVisible(false);
					}
				});

//			} else {
//				// change view
//				System.out.printf("%s%d\n", "not enough points for bet of: ", currPlayer.getBet());
//				mainFrame.getPlayerPanel().notEnoughPoints();
//			}
//		}
	}
}
