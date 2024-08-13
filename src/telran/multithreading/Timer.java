package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Timer extends Thread{

	public DateTimeFormatter typeOfTime;
	public long timePeriod ;
	public long duration ;

	public Timer(DateTimeFormatter typeOfTime, long timePeriod,  long duration) {
		this.typeOfTime =  typeOfTime;
		this.timePeriod = timePeriod;
		this.duration = duration;
		setDaemon(true);
}
	
public void run() {
	long endTime = System.currentTimeMillis() + duration;
	boolean wasInterrupted = false;

	while (System.currentTimeMillis() < endTime) {
		System.out.println(LocalTime.now().format(typeOfTime));

		try {
			sleep(timePeriod);
		} catch (InterruptedException e) {
			System.out.println("Timer was interrupted");
			wasInterrupted = true;
			break;
		}

	}
	if (!wasInterrupted) {
		System.out.println("Timer has ended");
	}

}


	public void stopTimer() {
		 try (Scanner scanner = new Scanner(System.in)) {
	            System.out.println("Enter 'stop' to stop the timer.");
	            String command = scanner.nextLine();
	            if ("stop".equalsIgnoreCase(command)) {
	            	interrupt(); 
	            }
	        }
	    }
	}