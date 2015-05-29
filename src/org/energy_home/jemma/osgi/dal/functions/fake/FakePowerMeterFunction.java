package org.energy_home.jemma.osgi.dal.functions.fake;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;
import org.osgi.service.dal.Units;
import org.osgi.service.dal.functions.Meter;
import org.osgi.service.dal.functions.data.LevelData;

public class FakePowerMeterFunction extends FakeEventableFunction implements Meter{
	
	private Dictionary serviceProperties=new Hashtable();
	private LevelData current;
	private LevelData total;
	
	public FakePowerMeterFunction(){}
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		updateCurrent(new BigDecimal(0));		
		updateTotal(new BigDecimal(0));
		//TODO start thread dispatching events;
	}
	
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	public FakePowerMeterFunction(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	
	
	public PropertyMetadata getPropertyMetadata(String propertyName)
			throws IllegalArgumentException {
		return null;
	}

	
	public OperationMetadata getOperationMetadata(String propertyName)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getServiceProperty(String propName) {
		return serviceProperties.get(propName);
	}

	
	public LevelData getCurrent() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		return current;
	}

	
	public LevelData getTotal() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		return total;
	}

	
	public void resetTotal() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		updateTotal(new BigDecimal(0));
	}
	
	private void updateTotal(BigDecimal total){
		this.total=new LevelData(new Date().getTime(),null,Units.WATT_PER_HOUR,total);
	}
	
	private void updateCurrent(BigDecimal current){
		this.current=new LevelData(new Date().getTime(),null,Units.WATT,current);
	}

}
