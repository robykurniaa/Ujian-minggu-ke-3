package com.juaracoidng.courseweek3.TestCourse;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;

import com.juaracoidng.courseweek3.Course.Course;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCourse {
	static final Logger log = getLogger(lookup().lookupClass());
	Course course;

	@Before
	public void setUp() throws Exception {
		course = new Course();
	}
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		@Override
		protected void succeeded (Description description) {
			log.debug("Pesan sukses : {}", description.getMethodName());
		}
		
		@Override
		protected void failed (Throwable e, Description description) {
			log.debug("Pesan failed : {}", description.getMethodName());
		}
	};
	//---------------TEST KELILING KOLAM---------------
	@Test
	@FileParameters("src/test/resources/KelilingKolam.csv")
	public void testKelilingKolam(double panjang, double lebar, double tinggi, double expect) {
		assertEquals(expect, course.KelilingKolam(panjang, lebar, tinggi), 0.0);
	}
	
	@Test
	public void testKelilingKolamBukanAngka() {
		String bukanAngka = "A";
		double convert = Double.parseDouble(bukanAngka);
		double actual = course.KelilingKolam(convert, convert, convert);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testKelilingKolamNegatif() {
		double panjang = -5;
		double lebar = -5;
		double tinggi = -5;
		double actual = course.KelilingKolam(panjang, lebar, tinggi);
		double expect = 4*(panjang+lebar+tinggi);
		assertEquals(expect, actual, 0.0);
	}
		
	@Test
	public void testKelilingKolamNull() {
		double panjang = 0;
		double lebar = 0;
		double tinggi = 0;
		Double angkaNull = null;
			
		double actual = course.KelilingKolam(panjang, lebar, tinggi);
		assertNull(angkaNull);
		assertEquals(0, actual, 0.0);
		}
	
	//---------------END TEST KELILING KOLAM---------------
	
	//---------------VOLUME KOLAM---------------

	@Test
	@FileParameters("src/test/resources/VolumeKolam.csv")
	public void testVolumeKolam(double panjang, double lebar, double tinggi, double expect) {
		assertEquals(expect, course.VolumeKolam(panjang, lebar, tinggi), 0.0);
	}
	
	@Test
	public void testVolumeKolamBukanAngka() {
		String bukanAngka = "A";
		double convert = Double.parseDouble(bukanAngka);
		double actual = course.VolumeKolam(convert, convert, convert);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamNegatif() {
		double panjang = -25;
		double lebar = -65;
		double tinggi = -15;
		
		double actual = course.VolumeKolam(panjang, lebar, tinggi);
		double expect = panjang*lebar*tinggi;
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamNull() {
		double panjang = 0;
		double lebar = 0;
		double tinggi = 0;
		Double angkaNull = null;
			
		double actual = course.KelilingKolam(panjang, lebar, tinggi);
		assertNull(angkaNull);
		assertEquals(0, actual, 0.0);
		}
	//---------------END TEST VOLUME KOLAM---------------
	
//	---------------TEST KONVERSI SUHU--------------------	
	@Test
	@FileParameters("src/test/resources/convert.csv")
	public void testConvertTemp(double f, double expect) {
		assertEquals(expect, course.ConvertTemp(f), 0.1);
	}
	@Test
	public void testConverTempKolamBukanAngka() {
		String bukanAngka = "A";
		double convert = Double.parseDouble(bukanAngka);
		double actual = course.ConvertTemp(convert);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testConvertTempNegatif() {
		double f = -25;
		double actual = course.ConvertTemp(f);
		double expect =  (f-32) * 5/9;
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	public void testConvertTempNull() {
		double f = 0;
		Double angkaNull = null;
			
		double actual = course.ConvertTemp(f);
		assertNull(angkaNull);
		assertEquals(0, actual, 0.0);
		}

}
