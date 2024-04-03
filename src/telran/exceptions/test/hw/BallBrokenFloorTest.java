package telran.exceptions.test.hw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.hw.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = 100;

	@Test
	void test() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
	}

	private Integer getMinBrokenFloor(BallBrokenFloor bbf) {
		//using binary search algorithm and only
		//of the class BallBrokenFloor
		//you should find minimal floor, from which a ball will be broken
			
		int lowFloor = 1;
		int highFloor = N_FLOORS;	
		int middleFloor = (lowFloor + highFloor) / 2;
		
		while (highFloor - lowFloor > 1) {
			boolean broken = false;
			
			try{
			      bbf.checkFloor(middleFloor);
			 }catch (Exception e) {
			      broken = true;
			 }  
	        	
            if(broken) {
    			highFloor = middleFloor;
    		}else {
    			lowFloor = middleFloor;
    		}
            middleFloor = (lowFloor + highFloor) / 2;  
	 }    			
		return highFloor;   	
	}
}