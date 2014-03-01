package org.MUM.Cargo;

public class FedEx extends ACarrier{

	final static double rate1 = 0.35; //for IA, MT, OR and CA
	final static double rate2 = 0.30; //for TX, and UT
	final static double rate3 = 0.55; // FL, MA and OH
	final static double rate4 = 0.43; //others
	
	
	
	@Override
	double computeShipment(Package p)
	{
		String zone= p.zone;
		double cost = 0.0;
		if(zone.equals("IA") || zone.equals("MT") || zone.equals("CA"))
		{
			cost=rate1*p.weight;
		}
		else if(zone.equals("TX") || zone.equals("UT") )
		{
			cost = rate2*p.weight;
		}
		else if(zone.equals("FL") || zone.equals("MA") || zone.equals("OH"))
		{
			cost = rate3*p.weight;
		}
		else
		{
			cost = rate4*p.weight;
		}
		return cost;
	}

}
