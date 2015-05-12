package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.DoorLock;
import org.energy_home.dal.functions.data.DoorLockData;
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

public class FakeDoorLockFunction extends FakeEventableFunction implements DoorLock{

	private Dictionary serviceProperties=new Hashtable();
	private DoorLockData data;
	private ComponentContext context;
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		this.updateData(DoorLockData.STATUS_OPEN);
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeDoorLockFunction(){}
	
	public FakeDoorLockFunction(Dictionary serviceProperties)
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
	private void updateData(String status)
	{
		if(this.data!=null&&(this.data.getStatus().equals(status)))
		{
			//do not update the status if nothing changed
			return;
		}
		this.data=new DoorLockData(new Date().getTime(),null,status);
		Hashtable properties=new Hashtable();
		
		properties.put(FunctionEvent.PROPERTY_FUNCTION_UID, context.getProperties().get(Function.SERVICE_UID));
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_NAME, "status");
		properties.put(FunctionEvent.PROPERTY_FUNCTION_PROPERTY_VALUE, this.data);
		
		Event evt=new Event(FunctionEvent.TOPIC_PROPERTY_CHANGED,(Dictionary)properties);

		this.eventAdmin.postEvent(evt);
	}
	
	public void open() throws DeviceException {
		updateData(DoorLockData.STATUS_OPEN);
		
	}
	
	public void close() throws DeviceException {
		updateData(DoorLockData.STATUS_CLOSED);
		
	}
	
	public DoorLockData getStatus() throws DeviceException {
		return data;
	}
	
}
