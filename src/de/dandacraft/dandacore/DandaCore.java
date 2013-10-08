package de.dandacraft.dandacore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import de.dandacraft.dandacore.blocks.BlockList;
import de.dandacraft.dandacore.blocks.PowerCable;

@Mod(modid=Resource.MODID, name=Resource.MODNAME, version=Resource.MODVERSION)
@NetworkMod(clientSideRequired=true)
public class DandaCore
{
	@Instance(value = "DandaCore")
	public static DandaCore dandacore;
	
	@SidedProxy(clientSide="de.dandacraft.dandacore.client.ClientProxy", serverSide="de.dandacraft.dandacore.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
	{
		BlockList.powerCable = new PowerCable(500);
		GameRegistry.registerBlock(BlockList.powerCable, BlockList.powerCable.getUnlocalizedName());
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
