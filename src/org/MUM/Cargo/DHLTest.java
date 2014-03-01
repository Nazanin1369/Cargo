package org.MUM.Cargo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DHLTest {

	@Test
	public void testComputeShipment() {
		Package p = new Package("eggs",7,"IA");
		DHL dhl = new DHL();
		double s= dhl.computeShipment(p);
		assertEquals(0.0, s, 0.001 );
	}

}
