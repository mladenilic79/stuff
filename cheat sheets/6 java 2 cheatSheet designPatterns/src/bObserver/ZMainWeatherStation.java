package bObserver;

public class ZMainWeatherStation {

	public static void main(String[] args) {
		
		// data object
		ImplementationSubjectWeatherData weatherData = 
				new ImplementationSubjectWeatherData();
		
		// observers
		ImplementationObserverCurrentConditionsDisplay currentConditionsDisplay =
				new ImplementationObserverCurrentConditionsDisplay();
		ImplementationObserverStatisticsDisplay statisticsDisplay = 
				new ImplementationObserverStatisticsDisplay();
		
		// register observers
		weatherData.registerObserver(currentConditionsDisplay);
		weatherData.registerObserver(statisticsDisplay);
		
		// set new data & send notifications
		weatherData.setMeasurments(80, 65, (float) 30.4);
		weatherData.setMeasurments(82, 70, (float) 29.2);
		weatherData.setMeasurments(78, 90, (float) 29.2);
		
	}

}
