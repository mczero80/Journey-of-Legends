package aginsun.journey.core.handlers.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import aginsun.journey.api.ExperienceKeeper;
import aginsun.journey.api.GoldKeeper;
import aginsun.journey.api.StatKeeper;
import aginsun.journey.client.guis.GuiQuestActive;
import aginsun.journey.client.guis.GuiRaceSelect;
import aginsun.journey.core.handlers.CommonTickHandler;
import aginsun.journey.core.handlers.RaceKeeper;
import aginsun.journey.entities.TileEntityKingdom;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommandJourneyofLegends extends CommandBase
{
	private GoldKeeper gold;
	private StatKeeper stats;
	private World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
	
	@Override
	public String getCommandName() 
	{
		return "JourneyofLegends";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) 
	{
		if(args[0].matches("stats"))
		{
			if(args[1].matches("Worthy"))
			{
				if(args.length >= 3)
				{
					int i = parseIntWithMin(sender, args[2], 1);
					ExperienceKeeper.setExperience((EntityPlayer)sender, i);
				}
			}
			if(args[1].matches("Strength"))
			{
				if(args.length >= 3)
				{
					int i = parseIntWithMin(sender, args[2], 1);
					stats.setStrengthPoints((EntityPlayer)sender, i);
				}
			}
			if(args[1].matches("Dexerity"))
			{
				if(args.length >= 3)
				{
					int i = parseIntWithMin(sender, args[2], 1);
					stats.setDexerityPoints((EntityPlayer)sender, i);
				}
			}
			if(args[1].matches("Intelligence"))
			{
				if(args.length >= 3)
				{
					int i = parseIntWithMin(sender, args[2], 1);
					stats.setIntelligencePoints((EntityPlayer)sender, i);
				}
			}
		}
		
		if(args[0].matches("TileEntityCheck"))
		{
			int x = parseInt(sender, args[1]);
			int y = parseInt(sender, args[2]);
			int z = parseInt(sender, args[3]);
			TileEntityKingdom tileentity = (TileEntityKingdom)world.getBlockTileEntity(x, y, z);
			int BlockID = parseIntWithMin(sender, args[4], 1);
			int MetaData = 0;
			if(args.length >= 5)
			{
				MetaData = parseInt(sender, args[5]);
			}
			ItemStack item = new ItemStack(BlockID, 1, MetaData);
			int LALA = tileentity.nbttagcompound.getInteger(item.getItem().getUnlocalizedName());
			sender.sendChatToPlayer(new StringBuilder().append(LALA).toString());
		}
		
		if(args[0].matches("Reset"))
		{
			RaceKeeper.Race.clear();
		}
		if(args[0].matches("guis"))
		{
			if(args[1].matches("Race"))
			{
				FMLCommonHandler.instance().showGuiScreen(new GuiRaceSelect());
			}
			if(args[1].matches("things"))
				FMLCommonHandler.instance().showGuiScreen(new GuiQuestActive((EntityPlayer) sender));
		}
	}
}