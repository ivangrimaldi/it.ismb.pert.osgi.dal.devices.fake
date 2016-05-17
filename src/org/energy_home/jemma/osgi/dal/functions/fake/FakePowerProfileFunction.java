package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.energy_home.dal.functions.PowerProfileFunction;
import org.energy_home.dal.functions.data.PowerProfileConstraintsData;
import org.energy_home.dal.functions.data.PowerProfileData;
import org.energy_home.dal.functions.data.PowerProfilePhasesData;
import org.energy_home.dal.functions.type.ScheduledPhaseAttribute;
import org.energy_home.dal.functions.type.TransferredPhaseAttribute;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;

public class FakePowerProfileFunction extends FakeEventableFunction implements
		PowerProfileFunction {

	private Dictionary serviceProperties=new Hashtable();
	private ComponentContext context;
	private List<TransferredPhaseAttribute> phases=new LinkedList<TransferredPhaseAttribute>();
	
	public void activate(ComponentContext context)
	{
		this.serviceProperties=context.getProperties();
		this.context=context;
		
		TransferredPhaseAttribute tph_1=new TransferredPhaseAttribute();
		TransferredPhaseAttribute tph_2=new TransferredPhaseAttribute();
		TransferredPhaseAttribute tph_3=new TransferredPhaseAttribute();
		
		tph_1.Energy=192;
		tph_1.ExpectedDuration=11;
		tph_1.MaxActivationDelay=65535;
		tph_1.EnergyPhaseID=1;
		tph_1.MacroPhaseID=1;
		
		tph_2.Energy=150;
		tph_2.ExpectedDuration=10;
		tph_2.MaxActivationDelay=0;
		tph_2.EnergyPhaseID=2;
		tph_2.MacroPhaseID=2;
		

		tph_3.Energy=196;
		tph_3.ExpectedDuration=59;
		tph_3.MaxActivationDelay=20;
		tph_3.EnergyPhaseID=3;
		tph_3.MacroPhaseID=6;
				
		phases.add(tph_1);
		phases.add(tph_2);
		phases.add(tph_3);
	}
	
	public FakePowerProfileFunction(){}
	
	public FakePowerProfileFunction(Dictionary serviceProperties)
	{
		this.serviceProperties=serviceProperties;
	}
	
	@Override
	public OperationMetadata getOperationMetadata(String arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyMetadata getPropertyMetadata(String arg0)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getServiceProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PowerProfileConstraintsData getConstraints(Short arg0)
			throws DeviceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getEnergyRemote() throws DeviceException {
		return true;
	}

	@Override
	public Boolean getMultipleScheduling() throws DeviceException {
		return true;
	}

	@Override
	public PowerProfilePhasesData getPowerProfilePhases(Short idx)
			throws DeviceException {
		return new PowerProfilePhasesData(System.currentTimeMillis(), null,idx,Short.valueOf("1"),phases);
	}

	@Override
	public PowerProfileData getPowerProfileState() throws DeviceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Short getScheduleMode() throws DeviceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Short getTotalProfileNum() throws DeviceException {
		return Short.valueOf("1");
	}

	@Override
	public void scheduleEnergyPhases(Short arg0, ScheduledPhaseAttribute[] arg1)
			throws DeviceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setScheduleMode(Short arg0) throws DeviceException {
		// TODO Auto-generated method stub

	}

}
