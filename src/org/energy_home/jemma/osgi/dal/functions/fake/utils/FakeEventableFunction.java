package org.energy_home.jemma.osgi.dal.functions.fake.utils;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public abstract class FakeEventableFunction {

	protected EventAdmin eventAdmin;
	 

	public void bindEventAdmin(EventAdmin eventAdmin)
	{
		this.eventAdmin=eventAdmin;
	}

	public void unbindEventAdmin(EventAdmin eventAdmin)
	{
		this.eventAdmin=null;
	}
	
}
