package org.MUM.Cargo;

public class USMail extends ACarrier{


	@Override
	double computeShipment(Package p) 
	{
		double cost =0.0;
		if(p.weight < 3)
			cost = 1*p.weight;
		else
			cost = 0.55*p.weight;
		return cost;
	}



}
