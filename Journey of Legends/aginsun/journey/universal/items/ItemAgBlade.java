package aginsun.journey.universal.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;

public class ItemAgBlade extends ItemSword
{
	public static EnumToolMaterial AgBlade = EnumHelper.addToolMaterial("AgBlade", 3, -1, 50.0F, 10000, 22);
	public ItemAgBlade(int par1) 
	{
		super(par1, EnumToolMaterial.EMERALD);
		this.setCreativeTab(null);
	}
	
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	if(player.username.equals("aginsun"))
    		return false;
    	else
    		return true;
    }
}
