package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.Function;
import org.osgi.service.dal.FunctionEvent;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;
import org.osgi.service.dal.functions.BooleanControl;
import org.osgi.service.dal.functions.BooleanSensor;
import org.osgi.service.dal.functions.data.BooleanData;
import org.osgi.service.event.Event;

public class FakeOnOffFunction extends FakeEventableFunction implements BooleanControl,BooleanSensor{

	private Dictionary serviceProperties=new Hashtable();
	private BooleanData data;
	private ComponentContext context;
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		this.updateData(false);
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeOnOffFunction(){}
	
	public FakeOnOffFunction(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	
	public BooleanData getData() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		return data;
	}

	@Override
	public void setData(boolean data) throws UnsupportedOperationException,
			IllegalStateException, DeviceException, IllegalArgumentException {
		updateData(data);
		
	}

	@Override
	public void reverse() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		updateData(!this.data.getValue());
	}

	@Override
	public void setTrue() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		updateData(true);
	}

	@Override
	public void setFalse() throws UnsupportedOperationException,
			IllegalStateException, DeviceException {
		updateData(false);
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
	
}
