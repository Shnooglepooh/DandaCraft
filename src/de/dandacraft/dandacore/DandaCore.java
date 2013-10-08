package de.dandacraft.dandacore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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
