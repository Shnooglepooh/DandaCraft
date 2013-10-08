package de.dandacraft.dandacore.power;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;

public class PowerNetwork
{
	// Static Manager Stuff
	private static HashMap<Integer, PowerNetwork> networks;
	private static HashMap<String, Integer> blockToNetworkMapping;
	
	static
	{
		networks = new HashMap<Integer, PowerNetwork>();
		blockToNetworkMapping = new HashMap<String, Integer>();
	}
	
	public static PowerNetwork GetNetworkAtBlock(int x, int y, int z)
	{
		return GetNetworkByID(GetNetworkIDAtBlock(x, y, z));
	}
	
	public static int GetNetworkIDAtBlock(int x, int y, int z)
	{
		String hash = x + "," + y + "," + z;
		if(blockToNetworkMapping.containsKey(hash))
			return blockToNetworkMapping.get(hash);
		return -1;
	}
	
	public static PowerNetwork GetNetworkByID(int id)
	{
		if(!networks.containsKey(id))
			return null;
		
		return networks.get(id);
	}
	
	public static int GetNextUnusedNetworkID()
	{
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			if(!networks.containsKey(i))
				return i;
		}
		
		return -1;
	}
	
	public static void ManageCableAdd(int x, int y, int z)
	{
		PowerNetwork[] neighborNets = GetNeighborPowerNetworks(x, y, z);
		
		if(neighborNets.length == 0)
		{
			// No compatible network found, create new
			PowerNetwork.Create(x, y, z);
		}
		else
		{
			// Irgendwie kabel zum netzwerk hinzufügen
			PowerNetwork.Merge(neighborNets);
		}
	}

	public static void ManageBlockRemove(int x, int y, int z)
	{
		
	}
	
	public static void Create(int x, int y, int z)
	{
	}
	
	public static void Merge(PowerNetwork[] networks)
	{
		if(networks.length > 1)
		{
			
		}
	}
	
	public static void Split(PowerNetwork net, int x, int y, int z)
	{
	}
	
	public static PowerNetwork[] GetNeighborPowerNetworks(int x, int y, int z)
	{
		ArrayList<PowerNetwork> foundNetworks = new ArrayList<PowerNetwork>();
		String hash;
		// Top
		hash = x + "," + (y + 1) + "," + z;
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		// bottom
		hash = x + "," + (y - 1) + "," + z;
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		// left
		hash = (x - 1) + "," + y + "," + z;
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		// right
		hash = (x + 1) + "," + y + "," + z;
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		// front
		hash = x + "," + y + "," + (z + 1);
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		// back
		hash = x + "," + y + "," + (z - 1);
		if(networks.containsKey(hash))
		{
			foundNetworks.add(networks.get(hash));
		}
		
		return (PowerNetwork[])foundNetworks.toArray();
	}
	
	// Non-Static Network stuff
	private int networkid;
	private List<IPowerCable> cables;
	private List<IPowerReceiver> receivers;
	private List<IPowerProvider> providers;
	private boolean isInvalid;
	
	private PowerNetwork()
	{
		this.cables = new ArrayList<IPowerCable>();
		this.receivers = new ArrayList<IPowerReceiver>();
		this.providers = new ArrayList<IPowerProvider>();
		this.networkid = GetNextUnusedNetworkID();
		this.isInvalid = true;
	}
	
	public void Invalidate()
	{
		this.isInvalid = true;
	}
	
	public void Pulse()
	{
		if(!this.isInvalid)
		{
			
		}
	}

	public int GetNetworkID()
	{
		return networkid;
	}
}
