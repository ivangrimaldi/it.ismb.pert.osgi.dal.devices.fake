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
import org.osgi.service.dal.functions.MultiLevelSensor;
import org.osgi.service.dal.functions.data.LevelData;

public class FakeMultiLevelSensorThermostatFunction extends FakeEventableFunction implements MultiLevelSensor {

	private Dictionary serviceProperties=new Hashtable();
	private LevelData data;
	
	public FakeMultiLevelSensorThermostatFunction(){}
	
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
	public FakeMultiLevelSensorThermostatFunction(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	
	@Override
	public PropertyMetadata getPropertyMetadata(String propertyName)
			throws IllegalArgumentException {
		return null;
	}

	@Override
	public OperationMetadata getOperationMetadata(String propertyName)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getServiceProperty(String propName) {
		return serviceProperties.get(propName);
	}

	
	private void updateLevel(BigDecimal total){
		this.data=new LevelData(new Date().getTime(),null,Units.KELVIN,total);
	}

	@Override
	public LevelData getData() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		// TODO Auto-generated method stub
		return this.data;
	}

}
