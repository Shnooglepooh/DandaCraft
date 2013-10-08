package de.dandacraft.dandacore.power;

import net.minecraftforge.common.ForgeDirection;

public interface IPowerProvider
{
	boolean CanProvidePowerFrom(ForgeDirection side);
	float ProvidePower(float amount);
	float PowerProvidable();
}
