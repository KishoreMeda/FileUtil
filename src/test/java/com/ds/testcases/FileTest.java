package test.java.com.ds.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import uk.java.com.ds.filescan.FileUtil;


public class FileTest { 
 
	FileUtil fp;
	File[] expectedCsvList = {new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle1.csv"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle11.csv"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle12.csv"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle4.csv"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle5.csv"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle7.csv")}; 

	File[] expectedXlsList = {
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle13.xls"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle14.xls"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle2.xls"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle3.xls"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle8.xls"),
			new File("C:\\Users\\dell\\workspace\\FileUtil\\src\\uk\\java\\com\\ds\\resources\\files\\Vehicle9.xls")};	
	@Before
	public void setUp(){
		fp = new FileUtil();
		fp.fileProperties();
	}
    
	@Test
	public void TestIsDirectory(){
		assertTrue(fp.isDirectory(fp.getFileDirectory()));
	}
 
	@Test
	public void TestDirectoryNotNull(){
		int fCount = fp.getFileCount();
		assertEquals(14, fCount);
	}

	@Test
	public void TestFilesCount(){
		assertTrue(fp.getFileCount() > 0);
	}

	@Test
	public void TestFileNames(){
		assertArrayEquals(expectedCsvList, fp.getFiles("csv"));
		assertArrayEquals(expectedXlsList, fp.getFiles("xls"));
	}

}
