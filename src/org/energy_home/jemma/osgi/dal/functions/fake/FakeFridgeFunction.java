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
	

	

	
	public PropertyMetadata getPropertyMetadata(String propertyName)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OperationMetadata getOperationMetadata(String propertyName)
			throws IllegalArgumentException {
		return null;
	}

	
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
	
	public LevelData getFridgeTemperature() throws DeviceException {
		return new LevelData(System.currentTimeMillis(), null, Units.DEGREE_CELSIUS, fridgeTemperature);
	}
	
	public LevelData getFreezerTemperature() throws DeviceException {
		return new LevelData(System.currentTimeMillis(), null, Units.DEGREE_CELSIUS, freezerTemperature);
	}
	
	public BooleanData getSuperCoolMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, superCoolMode);
	}
	
	public void setSuperCoolMode(Boolean data) throws DeviceException {
		this.superCoolMode=data;
		
	}
	
	public BooleanData getSuperFreezeMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, superFreezeMode);
	}
	
	public void setSuperFreezeMode(Boolean data) throws DeviceException {
		this.superFreezeMode=data;
		
	}
	
	public BooleanData getEcoMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, ecoMode);
	}
	
	public void setEcoMode(Boolean data) throws DeviceException {
		this.ecoMode=data;
		
	}
	
	public BooleanData getIceParty() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, iceParty);
	}
	
	public void setIceParty(Boolean data) throws DeviceException {
		this.iceParty=data;
	}
	
	public BooleanData getHolidayMode() throws DeviceException {
		return new BooleanData(System.currentTimeMillis(), null, holidayMode);
	}
	
	public void setHolidayMode(Boolean data) throws DeviceException {
		this.holidayMode=data;
	}
	
}
