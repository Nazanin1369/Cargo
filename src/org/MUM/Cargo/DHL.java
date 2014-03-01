package org.MUM.Cargo;

public class DHL extends ACarrier
{
	static final double rate = 8.9;
	
	@Override
	double computeShipment(Package p) 
	{
		double cost = rate*p.weight;
		return cost;
	}


}
