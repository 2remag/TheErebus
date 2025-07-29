package erebus.core.handler;

import erebus.ModItems;
import erebus.core.capabilities.player.IPlayerDeathLocationCapability;
import erebus.core.capabilities.player.PlayerDeathLocationCapability;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeathCompassRespawnEvent {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onClonePlayer(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			if (!event.getOriginal().getEntityWorld().getGameRules().getBoolean("keepInventory")) {
			if (event.getOriginal().hasCapability(PlayerDeathLocationCapability.CAPABILITY_PLAYER_DEATH_LOCATION, null)) {
			}
			}
		}
	}
}
