package de.dandacraft.dandacore.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerReceiver
{
	boolean CanReceivePowerFrom(ForgeDirection side);
	float ReceivePower(float amount);
	float PowerRequested();
}
