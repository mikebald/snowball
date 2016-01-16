package main.java.snowball.item;

import main.java.snowball.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemSnowball extends net.minecraft.item.ItemSnowball {

    public ItemSnowball()
    {
        this.maxStackSize = 16;
        this.setUnlocalizedName("snowball");

    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }

        worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new main.java.snowball.entities.EntitySnowball(worldIn, playerIn));
        }

        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(Item.getByNameOrId("minecraft:snowball"))]);

        System.out.println( itemStackIn.getItem().getRegistryName() );

        return itemStackIn;
    }
}
