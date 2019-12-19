package data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cars.Car;

public class Data {
	
	private BufferedReader csvReader;
	private String pathToDataSet = "C:\\Users\\xiaomi\\Desktop\\LP\\Прикладне\\Laba 4\\data.csv";
	private ArrayList<Car> cars;
	
	public Data() {
		
		cars = new ArrayList<Car>();
	}
	
	public ArrayList<Car> generateDataFromCsv(int size){
		try {
			csvReader = new BufferedReader(new FileReader(pathToDataSet));
		} catch (FileNotFoundException e) {
			System.out.println("Database doesn't exist");
			return null;
		}
		
		//miss first row with headers
		try { csvReader.readLine();} catch (IOException e) { e.printStackTrace(); }
		String row;
		ArrayList<String[]> data = new ArrayList<String[]>();
		cars = new ArrayList<Car>();
		try {
			while((row = csvReader.readLine()) != null) {
				String s[] = row.split(",");
				if(s.length > 16)//дані в 10 рядку (9 індекс) зберігаються в "" через КОМУ
					s = formString(s);
				data.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//get random data
		for(int i = 0; i < size; i++) {
			int randomIndex = (int)(Math.random() * data.size());
			cars.add(new Car(data.get(randomIndex)));
		}
		
		return cars;
	}
	
	private String[] formString(String s[]) {
		String formedS[] = new String[16];
		String bugColumn = "";
		
		int i = 0;
		for( ; i < 9; i++)
			formedS[i] = s[i];
		
		int numOfBugColumns = s.length - 16;
		int j = i;
		for(; j < i + numOfBugColumns + 1; j++) {
			if(bugColumn == "")
				bugColumn += s[j];
			else
				bugColumn += ", " +  s[j];
		}
		
		formedS[i] = bugColumn;
		i++;
		
		
		for(; i < 16; i++) 
			formedS[i] = s[j++];
		
		return formedS;
	}
	
	
	
}
