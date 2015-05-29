package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.ColorControl;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;

public class FakeColorControlFunction extends FakeEventableFunction implements ColorControl{

	private Dictionary serviceProperties=new Hashtable();
	
	private Short[] HS=new Short[2];
	
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();				
		
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
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
	
	public void setHS(Short hue, Short saturation) throws DeviceException {
		this.HS[0]=hue;
		this.HS[1]=saturation;
		
	}
	
	public Short[] getHS() throws DeviceException {
		return HS;
	}

	

}
