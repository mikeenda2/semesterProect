package semesterProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dataFiles {

	private final static Scanner STDIN = new Scanner(System.in);
	
	private final personsList pList;
	private final assetsList aList;
	
	public dataFiles(){
		this.pList = new personsList();
		this.aList = new assetsList();
		loadPersons();
		loadAssets();
	}
	
	private void loadPersons() {
		Scanner s = null;
		try {
			s = new Scanner(new File("Data/Persons.csv"));
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		int count = Integer.parseInt(s.nextLine());
		for(int i = 0; i <= count; i++) {
			String line = s.nextLine();
			String tokens[] = line.split(",");
			String personCode = tokens[0];
			String lastName = tokens[1];
			String firstName = tokens[2];
			String address = tokens[3];
			String city = tokens[4];
			String state = tokens[5];
			String zip = tokens[6];
			String country = tokens[7];
			//To Do: figure out how to read in the emails if theres multiple
			//String email = tokens
			
			person p = new person(personCode,lastName,firstName,address,city,state,zip,country,email);
			p.setPersonCode(personCode);
			p.setLastName(lastName);
			p.setFirstName(firstName);
			p.setAddress(address);
			p.setCity(city);
			p.setState(state);
			p.setZip(zip);
			p.setCountry(country);
			p.setEmail(email);
			pList.addperson(p);

		}
	}
	private void loadAssets() {
		Scanner s = null;
		try {
			s = new Scanner(new File("Assets/Persons.csv"));
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		int count = Integer.parseInt(s.nextLine());
		for(int i = 0; i <= count; i++) {
			String line = s.nextLine();
			String tokens[] = line.split(",");
			if(tokens[0].equals("P")){
				String code = tokens[0];
				String type = tokens[1];
				String label = tokens[2];
				double appraisedValue = Double.parseDouble(tokens[3]);
			}
			else if(tokens[0].equals("S")) {
				String code = tokens[0];
				String type = tokens[1];
				String label = tokens[2];
				String symbol = tokens[3];
				double sharePrice = Double.parseDouble(tokens[4]);
			}
			else if(tokens[0].equals("C")) {
				String code = tokens[0];
				String type = tokens[1];
				String label = tokens[2];
				double exchangeRate = Double.parseDouble(tokens[3]);
				double exchangeFeeRate = Double.parseDouble(tokens[4]);
			}
			else {
				throw new RuntimeException("Asset code invalid");
			}
		}
	}
}












	
