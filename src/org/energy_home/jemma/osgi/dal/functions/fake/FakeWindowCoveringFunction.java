package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.DoorLock;
import org.energy_home.dal.functions.WindowCovering;
import org.energy_home.dal.functions.data.DoorLockData;
import org.energy_home.dal.functions.data.WindowCoveringData;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.Function;
import org.osgi.service.dal.FunctionEvent;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;
import org.osgi.service.dal.functions.BooleanControl;
import org.osgi.service.dal.functions.BooleanSensor;
import org.osgi.service.event.Event;

public class FakeWindowCoveringFunction extends FakeEventableFunction implements WindowCovering{

	private Dictionary serviceProperties=new Hashtable();
	private WindowCoveringData status;
	private ComponentContext context;
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		this.updateData((short) 0);
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeWindowCoveringFunction(){}
	
	public FakeWindowCoveringFunction(Dictionary serviceProperties)
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
	private void updateData(Short status)
	{
		
		this.status=new WindowCoveringData(new Date().getTime(),null,status);
		Hashtable properties=new Hashtable();
		
		properties.put(FunctionEvent.PROPERTY_FUNCTION_UID, context.getProperties().get(Function.SERVICE_UID));
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_NAME, "status");
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_VALUE, this.status);
		
		Event evt=new Event(FunctionEvent.TOPIC_PROPERTY_CHANGED,(Dictionary)properties);

		this.eventAdmin.postEvent(evt);
	}
	

	
	public WindowCoveringData getStatus() throws DeviceException {
		return status;
	}
	
	public void openUp() throws DeviceException {
		this.updateData((short) 255);
		
	}
	public void closeDown() throws DeviceException {
		this.updateData((short) 0);
		
	}

	
}
