package DAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseService implements I_DatabaseService {

    private List<String> data = new ArrayList<String>();
    private File aFile;
    private Scanner aScanner;
    private String filename;

	////////////////////Constructor\\\\\\\\\\\\\\\\\\\\
	
    DatabaseService(String filename) {
        this.filename =  filename;
        openFile(filename);       
        readFile();
    }                      
	
	////////////////////Core Methods\\\\\\\\\\\\\\\\\\\\
	
	private void openFile(String filename) {		//Was Protected
        
		try {
            aFile = new File(filename);				//Not sure about this statement!!!
            aScanner = new Scanner(aFile);
        } 
		catch(FileNotFoundException e) {
            System.out.println("Exception: " + e + "\n Exiting program.");
            System.exit(0);
        }	
    }
	
	private void readFile() {
		
        try {
            while (aScanner.hasNext()) {
                data.add(aScanner.next());
            }
        } 
		catch (NullPointerException e) {
			System.out.println("Exception: " + e + "\n Exiting program.");
            System.exit(0);
        }
    }
	
	////////////////////Interface Methods\\\\\\\\\\\\\\\\\\\\
	
	public List<String> getData() {
        return data;      
    }
	
	public void changeData(int info) {
        writeData(data);     
    }                 

	public void deleteData(String[] info) {
        deleteFileRow(info);
    }		
	
	public void addData(String info) {
        data.add(info);
        writeData(data);
    }
	
	////////////////////Interface Sub Methods\\\\\\\\\\\\\\\\\\\\
	
	private void writeData(List<String> newData) {
        
		try {
            FileWriter aFileWriter = new FileWriter(filename);
            for (String str : newData) {						//Not sure about this statement!!!
                aFileWriter.write(str + "\n");					//Not sure about this statement!!!
            }
            aFileWriter.close();
        } 
		catch (IOException e) {
			System.out.println("Exception: " + e + "\n Exiting program.");
            System.exit(0);
		}
    }
	
	private void deleteFileRow(String[] newRow) {
		
		String[] rowElements;
		boolean complete = false;
		for(int i = 1; i < data.size() && complete == false; i++) {
			rowElements = data.get(i).split(",");
			if(Integer.parseInt(rowElements[0]) == Integer.parseInt(newRow[0])) 
			{
				data.remove(i);
				writeData(data);
				complete = true;
			}
		}
	}
	
	////////////////////Custom Methods\\\\\\\\\\\\\\\\\\\\
	
	private String[] readFileRow(int id) {
	
        String[] rowElements;
        boolean complete = false;
        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            try {
                if (Integer.parseInt(rowElements[0]) == id) {
                    return rowElements;
                }
            } catch (NumberFormatException e) {
				//System.out.println("Exception: " + e + "\n Exiting program.");
				//System.exit(0);
			}
        }

        return null;
    }
	
	public String showData(int chosenItemID) {
		
        List<String> fileData = getData();
        for (int i = 1; i < fileData.size(); i++) {
            String itemInfo;
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == chosenItemID) 
			{
                itemInfo = fileData.get(i);
                return itemInfo;
            }
        }
        return null;
    }
	
    private void updateFileRow(String[] newRow) {
        
		String newLine = "";
        String[] rowElements;
        for(int i = 1; i < data.size(); i++) {
            rowElements = data.get(i).split(",");
            if(Integer.parseInt(rowElements[0]) == Integer.parseInt(newRow[0])) {
                for (int j = 0; j < newRow.length; j++) 
				{
                    newLine += newRow[j];
                    if (j != (newRow.length - 1)) {
                        newLine += ",";
                    }
                }
                data.add(newLine);
                data.remove(i);
                newLine = "";
            }
        }
    }
    
	public void changeItemData(String changedRow) {
        
		List<String> fileData = getData();

        for (int i = 1; i < fileData.size(); i++) 
		{
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == Integer.parseInt(changedRow.substring(0, changedRow.indexOf(",")))) {
                fileData.set(i, changedRow);
                break;
            }
        }
        writeData(fileData);
    }
	
	public boolean checkData(String UserID){
	
		List<String> cus = getData();
        for (int i = 1; i < cus.size(); i++) {
            String[] detail = cus.get(i).split(",");
            if (Integer.parseInt(detail[0]) == Integer.parseInt(UserID)) {
                return true;
            }
        }
        return false;
    }
}