package org.energy_home.jemma.osgi.dal.functions.fake;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.Fridge;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.Function;
import org.osgi.service.dal.FunctionEvent;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;
import org.osgi.service.dal.Units;
import org.osgi.service.dal.functions.data.BooleanData;
import org.osgi.service.dal.functions.data.LevelData;
import org.osgi.service.event.Event;

public class FakeFridgeFunction extends FakeEventableFunction implements Fridge{

	private Dictionary serviceProperties=new Hashtable();
	private BooleanData data;
	private ComponentContext context;
	
	BigDecimal fridgeTemperature=new BigDecimal(-5);
	BigDecimal freezerTemperature=new BigDecimal(-18);
	Boolean ecoMode=false;
	Boolean holidayMode=false;
	Boolean iceParty=false;
	Boolean superCoolMode=false;
	Boolean superFreezeMode=false;
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeFridgeFunction(){}
	
	public FakeFridgeFunction(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	

	

	@Override
	public PropertyMetadata getPropertyMetadata(String propertyName)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationMetadata getOperationMetadata(String propertyName)
			throws IllegalArgumentException {
		return null;
	}

	@Override
	public Object getServiceProperty(String propName) {
		return serviceProperties.get(propName);
	}

	@SuppressWarnings("unchecked")
	private void updateData(boolean data)
	{
		this.data=new BooleanData(new Date().getTime(),null,data);
		Hashtable properties=new Hashtable();
		
		properties.put(FunctionEvent.PROPERTY_FUNCTION_UID, context.getProperties().get(Function.SERVICE_UID));
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_NAME, "data");
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_VALUE, this.data);
		
		Event evt=new Event(FunctionEvent.TOPIC_PROPERTY_CHANGED,(Dictionary)properties);

		this.eventAdmin.postEvent(evt);
	}
	@Override
	public LevelData getFridgeTemperature() throws DeviceException {
		return new LevelData(System.currentTimeMillis(), null, Units.DEGREE_CELSIUS, fridgeTemperature);
	}
	@Override
	public LevelData getFreezerTemperature() throws DeviceException {
		return new LevelData(System.currentTimeMillis(), null, Units.DEGREE_CELSIUS, freezerTemperature);
	}
	@Override
	public BooleanData getSuperCoolMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, superCoolMode);
	}
	@Override
	public void setSuperCoolMode(Boolean data) throws DeviceException {
		this.superCoolMode=data;
		
	}
	@Override
	public BooleanData getSuperFreezeMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, superFreezeMode);
	}
	@Override
	public void setSuperFreezeMode(Boolean data) throws DeviceException {
		this.superFreezeMode=data;
		
	}
	@Override
	public BooleanData getEcoMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, ecoMode);
	}
	@Override
	public void setEcoMode(Boolean data) throws DeviceException {
		this.ecoMode=data;
		
	}
	@Override
	public BooleanData getIceParty() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, iceParty);
	}
	@Override
	public void setIceParty(Boolean data) throws DeviceException {
		this.iceParty=data;
	}
	@Override
	public BooleanData getHolidayMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, holidayMode);
	}
	@Override
	public void setHolidayMode(Boolean data) throws DeviceException {
		this.holidayMode=data;
	}
	
}
