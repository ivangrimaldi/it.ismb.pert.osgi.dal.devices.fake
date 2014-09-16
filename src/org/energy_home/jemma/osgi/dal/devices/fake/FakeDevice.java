package org.energy_home.jemma.osgi.dal.devices.fake;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.Device;
import org.osgi.service.dal.DeviceException;

public class FakeDevice implements Device{

	Dictionary serviceProperties=new Hashtable();
	
	public FakeDevice(){}
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
				
		//TODO start thread dispatching events;
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeDevice(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	
	@Override
	public Object getServiceProperty(String propName) {
		return serviceProperties.get(propName);
	}

	@Override
	public void remove() throws DeviceException, UnsupportedOperationException,
			SecurityException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

}
