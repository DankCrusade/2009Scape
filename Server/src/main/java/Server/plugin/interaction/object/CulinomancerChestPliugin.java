package plugin.interaction.object;

import core.cache.def.impl.ObjectDefinition;
import core.game.interaction.OptionHandler;
import core.game.node.Node;
import core.game.node.entity.player.Player;
import core.game.node.object.GameObject;
import core.game.node.object.ObjectBuilder;
import core.game.system.mysql.impl.ShopSQLHandler;
import core.game.world.map.Location;
import core.game.world.map.RegionManager;
import core.plugin.InitializablePlugin;
import core.plugin.Plugin;

/**
 * Handles the culinomancer chest.
 * @author Vexia
 */
@InitializablePlugin
public final class CulinomancerChestPliugin extends OptionHandler {

	@Override
	public Plugin<Object> newInstance(Object arg) throws Throwable {
		ObjectDefinition.forId(12309).getConfigurations().put("option:bank", this);
		ObjectDefinition.forId(12309).getConfigurations().put("option:buy-items", this);
		ObjectDefinition.forId(12309).getConfigurations().put("option:buy-food", this);
		GameObject object = RegionManager.getObject(new Location(3219, 9623, 0));
		ObjectBuilder.replace(object, object.transform(object.getId(), 3));
		return this;
	}

	@Override
	public boolean handle(Player player, Node node, String option) {
		switch (option) {
		case "bank":
			player.getBank().open();
			return true;
		case "buy-items":
			ShopSQLHandler.openUid(player, 178);
			return true;
		case "buy-food":
			ShopSQLHandler.openUid(player, 177);
			return true;
		}
		return true;
	}

}
