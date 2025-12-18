
public class VolumeofEarth {
	public static void main(String[] args) {
		int radiusInKm=6378;
		double radiusInMile=radiusInKm/1.6;
		double volumeInKm=(4/3)*3.14*radiusInKm*radiusInKm*radiusInKm;
		double volumeInMiles=(4/3)*3.14*radiusInMile*radiusInMile*radiusInMile;
		System.out.println("The volume of earth in cubic kilometers is "+volumeInKm+" and cubic miles is: "+volumeInMiles);
	}
}
