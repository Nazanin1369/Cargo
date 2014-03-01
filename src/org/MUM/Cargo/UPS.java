package org.MUM.Cargo;

public class UPS extends ACarrier{

	final static double rate = 0.45;
	
	
	@Override
	double computeShipment(Package p) 
	{
		double cost = rate*p.weight;
		return cost;
	}


	

}
