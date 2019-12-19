package data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cars.Car;
import cars.carFeatures;

public class Autopark {
	public static enum sortingType{
		ascending, descending
	}
	private sortingType sType;
	
	private List<Car> cars;	
	private Data data;
	private final File dataFile = new File("savedData.data");
	
	
	public Autopark() {
		cars = new ArrayList<Car>();
		data = new Data();
	}
	
	public void generateAutopark(int size) {
		
		setCars(data.generateDataFromCsv(size));
	}
	
	public void showPark() {
		
		if(getCars().isEmpty()) {
			System.out.println("Автопарк пустий");
			return;
		}
		header();
		
		int number = 1;
		for(Car c: getCars()) {
			System.out.print(String.format("%-4d", number++, ' '));
			System.out.println(c);
		}
	}
	
	public void showEstimatePrice() {
		if(getCars().isEmpty()) {
			System.out.println("Автопарк пустий");
			return;
		}
		System.out.print("Загальна вартість автопарку = ");
		
		int sum = 0;
		for(Car c: getCars()) {
			sum += c.getPrice();
		}
		
		System.out.println(sum + "$");
	}
	
	public void showCarsInAccelerationRange(double min, double max) {
		if(getCars().isEmpty()) {
			System.out.println("Автопарк пустий");
			return;
		}
		header();
		
		int number = 1;
		for(Car c: cars) {
			if(c.getAccelerationToOneHundred() >= min && c.getAccelerationToOneHundred() <= max) {
				System.out.print(String.format("%-4d", number++, ' '));
				System.out.println(c);
			}
		}
	}
	
	public void sort(carFeatures feature) {
		System.out.println(feature);
		//cars.sort(Comparator.comparing(.get));
		
		switch(feature) {
		case releaseYear:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getReleaseYear(), c2.getReleaseYear());
					else
						return Integer.compare(c2.getReleaseYear(), c1.getReleaseYear());
				  }
			});
			break;
		case engineHorsePower:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getEngineHorsePower(), c2.getEngineHorsePower());
					else
						return Integer.compare(c2.getEngineHorsePower(), c1.getEngineHorsePower());
				  }
			});
			break;
		case numberOfSits:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getNumberOfSits(), c2.getNumberOfSits());
					else
						return Integer.compare(c2.getNumberOfSits(), c1.getNumberOfSits());
				  }
			});
			break;
		case highwayMpg:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getHighwayMpg(), c2.getHighwayMpg());
					else
						return Integer.compare(c2.getHighwayMpg(), c1.getHighwayMpg());
				  }
			});
			break;
		case cityMpg:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getCityMpg(), c2.getCityMpg());
					else
						return Integer.compare(c2.getCityMpg(), c1.getCityMpg());
				  }
			});
		case price:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Integer.compare(c1.getPrice(), c2.getPrice());
					else
						return Integer.compare(c2.getPrice(), c1.getPrice());
				  }
			});
			break;
		case acceleration:
			Collections.sort(getCars(), new Comparator<Car>() {
				sortingType st = sType;
				  @Override
				  public int compare(Car c1, Car c2) {
					if(st == sortingType.ascending)
						return Double.compare(c1.getAccelerationToOneHundred(), c2.getAccelerationToOneHundred());
					else
						return Double.compare(c2.getAccelerationToOneHundred(), c1.getAccelerationToOneHundred());
				  }
			});
			break;
		}
		
		
		
	}


	public void saveAutoPark() {
		if(getCars().isEmpty()) {
			System.out.println("Автопарк пустий");
			return;
		}
		
		try {
			FileOutputStream f = new FileOutputStream(dataFile);
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			for(Car c: cars)
				o.writeObject(c);
		} catch (FileNotFoundException e) {
			System.out.println("Файл не знайдено");
		} catch (IOException e) {
			System.out.println("Помилка ініціалізації");
		}
		
		System.out.println("Autopark saved!\n\n");
	}
	
	public void loadAutoPark() {
		try {
			FileInputStream fi = new FileInputStream(dataFile);
			ObjectInputStream oi = new ObjectInputStream(fi);
		
			cars = new ArrayList<Car>();
			
			
			while(true)
				cars.add((Car) oi.readObject());
			
			
			//fi.close();
			//oi.close();
		} catch (FileNotFoundException e) {
			System.out.println("Файл не знайдено");
			return;
		} catch (IOException e) {
			System.out.println("Autopark loaded!\n\n");
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	public sortingType getSortType() {
		return sType;
	}

	public void setSortType(sortingType sType) {
		this.sType = sType;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void removeCarByIndex(int index) {
		cars.remove(index - 1);
	}
	
	private void header() {
		System.out.println(String.format("%-4c%-20s%-25s%-12s%-15s%-18s%-15s%-15s%-20s%-15s%-15s%s\n", '№', "Виробник", "Модель", "Рік", "Потужність",
				"Розгін до 100", "Місця", "Стиль", "Highway MPG", "City Mpg", "Ціна", "Категорія"));
	}
	
	
}
