package DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ParkingLot {

	int parkingSpaceCount = 100;
	boolean isFull,isEmpty;
	Vector<ParkingSpace> parkedSpaces = new Vector<ParkingSpace>();
	Vector<ParkingSpace> vacantSpaces = new Vector<ParkingSpace>();
	
	ParkingSpace  findNearestVacant(parking_type type)
	{
		Iterator<ParkingSpace> itr = vacantSpaces.iterator();
		while(itr.hasNext())
		{
			ParkingSpace x = itr.next();
			if(x.parkingType==type)
				return x;
		}
		return null;
	}
	public void parkVehicle(parking_type z, Vehicle v)
	{
		if(!isFull)
		{
			ParkingSpace pspace = findNearestVacant(z);
			if(pspace!=null)
			{
				pspace.vehicle=v;
				pspace.isVacant=false;
				
				vacantSpaces.remove(pspace);
				parkedSpaces.add(pspace);
				
				if(parkedSpaces.size()==parkingSpaceCount)
					isFull=true;
				isEmpty=false;
			}
		}
		
	}
	
	public void removeVehicle(Vehicle v)
	{
		if(!isEmpty)
		{
			Iterator<ParkingSpace> itr = parkedSpaces.iterator();
			
			while(itr.hasNext())
			{
				ParkingSpace x = itr.next();
				if(x.vehicle==v)
				{
					parkedSpaces.remove(v);
					vacantSpaces.add(x);
					
					if(vacantSpaces.size() == parkingSpaceCount)
						isEmpty = true;
					isFull=false;
				}
				
			}
		}
		
		
	}
	
	public enum parking_type
	{
		HANDICAPPED,
		NORMAL,
		REGULAR
	}
}
