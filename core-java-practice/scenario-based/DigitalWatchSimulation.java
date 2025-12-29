public class DigitalWatchSimulation {
	public static void main(String[] args) {
		System.out.println("Digital Watch Simulation - 24 Hour Format\n");
		// Nested for-loop for hours and minutes
		for(int hour=0;hour<24;hour++) {
			for(int minute=0;minute<60;minute++) {
				if(hour==13 && minute==0) {
					System.out.println("\nPower Cut! Watch stopped at 13:00");
					break;
				}
				System.out.printf("%02d:%02d\n",hour,minute);
			}
			// Break from outer loop when power cut happens
			if(hour==13) break;
		}
	}
}
