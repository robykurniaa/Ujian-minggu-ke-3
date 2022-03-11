package com.juaracoidng.courseweek3.Course;

public class Course {
	
	
	public double KelilingKolam(double panjang, double lebar, double tinggi) {

		return 4*(panjang+lebar+tinggi);
	}
	
	public double VolumeKolam(double panjang, double lebar, double tinggi) {

		return panjang*lebar*tinggi;
	}
	
	public double ConvertTemp(double f) {

		return (f-32) * 5/9;
	}

}
