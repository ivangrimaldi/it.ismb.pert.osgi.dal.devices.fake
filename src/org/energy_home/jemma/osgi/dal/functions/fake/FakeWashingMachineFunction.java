package org.energy_home.jemma.osgi.dal.functions.fake;

import java.math.BigDecimal;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.WashingMachine;
import org.energy_home.dal.functions.data.TimeData;
import org.energy_home.dal.functions.type.TimeAttribute;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;
import org.osgi.service.dal.Units;
import org.osgi.service.dal.functions.data.BooleanData;
import org.osgi.service.dal.functions.data.LevelData;

public class FakeWashingMachineFunction extends FakeEventableFunction implements WashingMachine{

	private Dictionary serviceProperties=new Hashtable();
	private ComponentContext context;
	
	private Short cycle=1;
	private Short spin=1600;
	private BigDecimal temperature=new BigDecimal(20);
	private TimeAttribute startTime=new TimeAttribute();
	private TimeAttribute finishTime = new TimeAttribute();
	private TimeAttribute remainingtime= new TimeAttribute();
	
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		
		this.startTime.setAbsolute(false);
		this.startTime.setHours(1);
		this.startTime.setMinutes(0);
		
		this.finishTime.setAbsolute(false);
		this.finishTime.setHours(1);
		this.finishTime.setMinutes(45);
		
		this.remainingtime.setAbsolute(false);
		this.remainingtime.setHours(0);
		this.remainingtime.setMinutes(0);
	}
	public void deactivate(ComponentContext context)
	{
				
		//TODO stop thread dispatching events;
	}
	
	public FakeWashingMachineFunction(){}
	
	public FakeWashingMachineFunction(Dictionary serviceProperties)
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


	
	public LevelData getCycle() throws DeviceException {
		return new LevelData(System.currentTimeMillis(),null,"CYCLE",new BigDecimal(cycle));
	}
	
	public void setCycle(Short cycle) throws DeviceException {
		this.cycle=cycle;
		
	}
	
	public LevelData getTemperature() throws DeviceException {
		return new LevelData(System.currentTimeMillis(),null,Units.DEGREE_CELSIUS,temperature);
	}
	
	public void setTemperature(Integer temperature) throws DeviceException {
		this.temperature=new BigDecimal(temperature);
		
	}
	
	public LevelData getSpin() throws DeviceException {
		return new LevelData(System.currentTimeMillis(),null,"SPIN",new BigDecimal(spin));
	}
	
	public void setSpin(Short spin) throws DeviceException {
		this.spin=spin;
		
	}
	
	public TimeData getStartTime() throws DeviceException {
		return new TimeData(System.currentTimeMillis(), null, startTime);
	}
	
	public void setStartTime(TimeData data) throws DeviceException {
		this.startTime=data.getTimeAttribute();
		
	}
	
	public TimeData getFinishTime() throws DeviceException {
		return new TimeData(System.currentTimeMillis(), null, finishTime);
	}
	
	
	public void execStartCycle() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	
	public void execStopCycle() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	
	public void execPauseCycle() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	
	public void execOverloadPauseResume() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	public void execOverloadPause() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	
	public void execOverloadWarning() throws DeviceException {
		// TODO Auto-generated method stub
		
	}
	
	public TimeData getRemainingTime() throws DeviceException {
		return new TimeData(System.currentTimeMillis(), null, remainingtime);
	}
	public BooleanData getRemoteControl() throws DeviceException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
