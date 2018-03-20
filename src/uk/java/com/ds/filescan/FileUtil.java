package uk.java.com.ds.filescan;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

import uk.java.com.ds.util.PropertyHandler;


 

public class FileUtil {
 	PropertyHandler proprities; 
 	 
	//String fileDir;
	File fileDirectory; 
	
	File[] fileList;
	
	String mimeType;
	String fileName;
	String fileExt;
	long fileSize;
	int fileCount;
  
	// Constructor to read Directory info from config.properties
	// By default read directory info from config.properties file
	public FileUtil(){
		proprities = new PropertyHandler();
		String fileDir = System.getProperty("user.dir") + "/src" + proprities.getProperty("sourcedir");
	
		// Verify configured source directory is exists
		fileDirectory = new File(fileDir);
		
		if(!isDirectory(fileDirectory)){
			System.out.println(fileDir + " is not a Directory");
			System.exit(0);
		}
	}

	// Constructor with Directory info
	public FileUtil(String dirName){
		
		fileDirectory = new File(dirName);
		// Verify configured source directory is exists
		if(!isDirectory(fileDirectory)){
			System.out.println(dirName + " is not a Directory");
			System.exit(0);
		}
	}
	
	public File getFileDirectory(){
		return fileDirectory;
	}

	public void setFileDirectory(String dirName){
		this.fileDirectory = new File(dirName);
	}
	
	// Return all files within the give Directory
	public File[] getFiles(){
		return (getFileDirectory().listFiles());
	}
	
	// Return file list of specific extension
	public File[] getFiles(String ext){
		File[] files = getFiles();
		File[] list = new File[files.length];
		int j = 0;
		int count = 0;
		for(int i = 0; i < files.length; i++){
			File file = files[i];
			if ( getFileExtension(file).endsWith(ext) ){
				count++;
				list[j++] = file;
				System.out.println("File:" + list[j-1] );
			}
		}
		File[] fList = new File[count];
		for (int i=0; i < count; i++){
			fList[i] = list[i];
		}
		return fList;
	}
	
	public String getFileExtension(File file){
		String fileName = file.getName();
		return (fileName.substring(fileName.lastIndexOf('.') + 1));
	}
	
	public void fileProperties(){
		// Get the *.csv and *.xls files and display File Properties
		System.out.println("Total Files Count:" + getFiles().length );
		
		fileCount = getFileDirectory().listFiles().length;
		
		// Loop through the *.csv and display file properties
		File[] csvFiles = getFiles("csv");
		
		for (int i=0; i < csvFiles.length; i++){
			displayFileProperties(csvFiles[i]);
		}
		
		System.out.println("No. of csv Files:" + csvFiles.length );
		// Loop through the *.xls and display file properties
		File[] xlsFiles = getFiles("xls");
		
		for (int i=0; i < xlsFiles.length; i++){
			displayFileProperties(xlsFiles[i]);
		}
		
		System.out.println("No. of xls Files:" + xlsFiles.length );
		
		System.out.println("Total Files Count:" + csvFiles.length + xlsFiles.length );
	}

	public void displayFileProperties(File file){
		System.out.println("##################");
		fileName = file.getName();
		fileSize = file.length();
		fileExt =  fileName.substring(fileName.lastIndexOf('.') + 1);
		mimeType = new MimetypesFileTypeMap().getContentType(file);
		System.out.println("##################");
		System.out.println("FileName: " + fileName);
		System.out.println("FileSize: " + fileSize + " bytes");
		System.out.println("FileExtension: " + fileExt);
		System.out.println("File Mime Type: " + mimeType);
		System.out.println("##################");

	}

	public int getFileCount(){
		return fileCount;
	}
	
	public boolean isDirectory(File file){
		return (file.isDirectory());
		
	}

	
	public File[] getFileList(){
		return fileList;
	}
	
	public static void main(String args[]){
		System.out.println("hello");
		FileUtil dir = new FileUtil();
		dir.fileProperties();
	}
}
