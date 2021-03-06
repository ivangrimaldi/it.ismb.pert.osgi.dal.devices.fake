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
import org.osgi.service.dal.functions.MultiLevelControl;
import org.osgi.service.dal.functions.data.LevelData;

public class FakeMultiLevelControlLightFunction extends FakeEventableFunction implements MultiLevelControl{
	
	private Dictionary serviceProperties=new Hashtable();
	private LevelData data;
	
	public FakeMultiLevelControlLightFunction(){}
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		updateLevel(new BigDecimal(0));		
		//TODO start thread dispatching events;
	}
	
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	public FakeMultiLevelControlLightFunction(Dictionary serviceProperties)
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

	
	private void updateLevel(BigDecimal total){
		this.data=new LevelData(new Date().getTime(),null,Units.LUX,total);
	}

	
	public LevelData getData() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		// TODO Auto-generated method stub
		return this.data;
	}

	
	public void setData(BigDecimal level) throws UnsupportedOperationException,
			IllegalStateException, DeviceException, IllegalArgumentException {
		updateLevel(level);
		
	}

	
	public void setData(BigDecimal level, String unit)
			throws UnsupportedOperationException, IllegalStateException,
			DeviceException, IllegalArgumentException {
			updateLevel(level);
		
	}
	

}
