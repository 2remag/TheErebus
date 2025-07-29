package erebus.core.handler;

import java.util.Calendar;
import java.util.List;

import erebus.ModBlocks;
import erebus.blocks.BlockBones;
import erebus.core.capabilities.player.IPlayerDeathLocationCapability;
import erebus.core.capabilities.player.PlayerDeathLocationCapability;
import erebus.core.helper.Utils;
import erebus.tileentity.TileEntityBones;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityDeathInventoryHandler {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onPlayerDrops(PlayerDropsEvent event) {

		final List<EntityItem> drops = event.getDrops();
		if (drops.isEmpty()) return;

		World world = event.getEntityLiving().world;
		if (world.isRemote)
			return;

		if (event.getEntityLiving() instanceof EntityPlayer && !world.getGameRules().getBoolean("keepInventory")) {
		}
	}
	
	public String getDeathTimeNow() {
		String[] MONTH = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		String month = MONTH[Calendar.getInstance().get(Calendar.MONTH)];
		String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		String hour = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
		String second = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
		String total = (hour.length() == 1 ? '0' + hour : hour) + ":" + (minute.length() == 1 ? '0' + minute : minute) + ":" + (second.length() == 1 ? '0' + second : second) + " " + (day.length() == 1 ? '0' + day : day) + "/" + month + "/" + year;
		return total;
	}
}
