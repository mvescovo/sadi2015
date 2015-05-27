/**
 * 
 */
package model;

import java.io.Serializable;

import model.interfaces.CommandInterface;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * @author "Michael Vescovo - s3459317"
 *
 */
public class IntermediateResultCommand implements Serializable,
		CommandInterface {
	private static final long serialVersionUID = -6927655603196819235L;
	Player player = null;
	DicePair dicePair = null;
	
	public IntermediateResultCommand(Player player, DicePair dicePair) {
		this.player = player;
		this.dicePair = dicePair;
	}

	@Override
	public void execute(GameEngine gameEngine, HandleAClient handleAClient) {
		((GameEngineClientStub)gameEngine).getGameEngineCallback().intermediateResult(player, dicePair, gameEngine);
	}
}
