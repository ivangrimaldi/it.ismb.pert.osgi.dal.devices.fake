package org.energy_home.jemma.osgi.dal.functions.fake;

import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.dal.functions.ColorControl;
import org.energy_home.jemma.osgi.dal.functions.fake.utils.FakeEventableFunction;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.dal.OperationMetadata;
import org.osgi.service.dal.PropertyMetadata;

public class FakeColorControlFunction extends FakeEventableFunction implements ColorControl{

	private Dictionary serviceProperties=new Hashtable();
	
	private Short currentSaturation;
	private Integer remainingTime;
	private Integer currentX;
	private Integer currentY;
	private Short driftCompensation;
	private String compensationText;
	private Integer colorTemperature;
	private Short colorMode;
	private Short getNumberOfPrimaries;
	
	private Integer primary1X;
	private Integer primary1Y;
	private Short primary1Integerensity;
	
	private Integer primary2X;
	private Integer primary2Y;
	private Short primary2Integerensity;
	
	private Integer primary3X;
	private Integer primary3Y;
	private Short primary3Integerensity;
	
	private Integer primary4X;
	private Integer primary4Y;
	private Short primary4Integerensity;
	
	private Integer primary5X;
	private Integer primary5Y;
	private Short primary5Integerensity;
	
	private Integer primary6X;
	private Integer primary6Y;
	private Short primary6Integerensity;
	
	private Integer whitePoIntegerX;
	private Integer whitePoIntegery;
	
	private Integer colorPoIntegerRX;
	private Integer colorPoIntegerRY;
	private Short colorPoIntegerRIntegerensity;
	
	private Integer colorPoIntegerGX;
	private Integer colorPoIntegerGY;
	private Integer colorPoIntegerGIntegerensity;
	
	private Integer colorPoIntegerBX;
	private Integer colorPoIntegerBY;
	private Integer colorPoIntegerBIntegerensity;
		
	private Integer enhancedCurrentHue;
	private Short colorLoopActive;
	
	
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

	
	public Short getCurrentHue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getCurrentSaturation() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getRemainingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getCurrentX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getCurrentY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getDriftCompensation() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String getCompensationText() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer getColorTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getNumberOfPrimaries() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary1X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary1Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary1Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary2X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary2Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary2Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary3X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary3Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary3Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary4X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary4Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary4Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary5X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary5Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary5Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary6X() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getPrimary6Y() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getPrimary6Integerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getWhitePoIntegerX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getWhitePoIntegerY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerRX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerRY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorPoIntegerRIntegerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerGX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerGY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorPoIntegerGIntegerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerBX() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorPoIntegerBY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorPoIntegerBIntegerensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getEnhancedCurrentHue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getEnhancedColorMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorLoopActive() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Short getColorLoopDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorLoopTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorLoopStartEnhancedHue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorLoopStoredEnhancedHue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorCapabilities() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorTempPhysicalMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Integer getColorTempPhysicalMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void execMoveToHue(Short Hue, Short Direction, Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveHue(Short MoveMode, Short Rate) {
		// TODO Auto-generated method stub
		
	}

	
	public void execStepHue(Short StepMode, Short StepSize, Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveToSaturation(Short Saturation, Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveSaturation(Short MoveMode, Short Rate) {
		// TODO Auto-generated method stub
		
	}

	
	public void execStepSaturation(Short StepMode, Short StepSize,
			Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveToHueAndSaturation(Short Hue, Short Saturation,
			Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveToColor(Integer ColorX, Integer ColorY, Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

	
	public void execMoveColor(Integer RateX, Integer RateY) {
		// TODO Auto-generated method stub
		
	}


	public void execStepColor(Integer StepX, Integer StepY, Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}


	public void execMoveToColorTemperature(Short ColorTemperature,
			Integer TransitionTime) {
		// TODO Auto-generated method stub
		
	}

}
