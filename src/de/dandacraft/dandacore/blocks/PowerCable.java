package de.dandacraft.dandacore.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.dandacraft.dandacore.DandaCore;
import de.dandacraft.dandacore.Resource;
import de.dandacraft.dandacore.power.IPowerCable;
import de.dandacraft.dandacore.power.PowerNetwork;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class PowerCable extends Block
{
	public PowerCable(int par1)
	{
		super(par1, Material.anvil);
		this.setHardness(1);
		this.setStepSound(soundAnvilFootstep);
		this.setUnlocalizedName(Resource.MODID + "Cable");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Resource.MODID+":cable");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	@Override
	public void onBlockPreDestroy(World par1World, int x, int y, int z, int metadata)
	{
		
		super.onBlockPreDestroy(par1World, x, y, z, metadata);
	}
	
	@Override
	public int onBlockPlaced(World par1World, int x, int y, int z,
			int side, float par6, float par7, float par8, int metadata)
	{
		PowerNetwork.ManageCableAdd(x, y, z);
		return super.onBlockPlaced(par1World, x, y, z, side, par6, par7, par8, metadata);
	}
}
