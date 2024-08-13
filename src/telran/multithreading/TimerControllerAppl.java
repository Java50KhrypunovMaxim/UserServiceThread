package telran.multithreading;

import java.time.format.DateTimeFormatter;

public class TimerControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer(DateTimeFormatter.ofPattern("HH:mm:ss"), 2000, 10000);
		
		timer.start();
        timer.stopTimer(); 
        
	

	}

}