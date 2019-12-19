package menu;

import java.util.Scanner;

import cars.Car;
import cars.carFeatures;
import data.Autopark;
import data.TaxiService;

public class MenuReceiver {
	
	private Autopark autoPark;
	private TaxiService taxiService;
	private Scanner in;
	private boolean open = false;
	
	public MenuReceiver() {
		autoPark = new Autopark();
		taxiService = new TaxiService(autoPark);
		in = new Scanner(System.in);
	}
	
	public void homeMenu() {
		if(open)
			newPage();
		else
			open = true;
		System.out.println("\tTaxi Manager");
		System.out.println("1. Переглянути автопарк");
		System.out.println("2. Створити новий випадковий автопарк");
		System.out.println("3. Загрузити дані про автопарк з файлу");
		System.out.println("4. Зберегти автопарк");
		System.out.println("5. Послуги таксі");
		System.out.println("9. Про програму");
		System.out.println("0. Вихід");
	}
	
	public void showPark() {
		newPage();
		autoPark.showPark();
		System.out.println("\n\n");
		System.out.println("1. Сортування");
		System.out.println("2. Загальна вартість автопарку");
		System.out.println("3. Показати авто із заданою швидкістю розгону");
		System.out.println("4. Добавити автомобіль");
		System.out.println("5. Вилучити автомобіль");
		System.out.println("0. Назад");
	}
	
	public void addCar() {
		newPage();
		Car car = new Car();
		System.out.println("Введіть дані про авто");
		
		System.out.print("Виробник ---> ");
		String make = in.nextLine();
		car.setMake(make);
		
		System.out.print("Модель ---> ");
		String model = in.nextLine();
		car.setModel(model);
		
		System.out.print("Дата випуску ---> ");
		int releaseYear = in.nextInt();
		car.setReleaseYear(releaseYear);
		
		System.out.print("Потужність двигуна (кс) ---> ");
		int engineHorsePower = in.nextInt();
		car.setEngineHorsePower(engineHorsePower);
		
		System.out.print("Кількість місць (без водія) ---> ");
		int numberOfSits = in.nextInt();
		car.setNumberOfSits(numberOfSits);
		
		System.out.print("Категорія ---> ");
		String marketCategory = in.next();
		car.setMarketCategory(marketCategory);
		
		System.out.print("Стиль ---> ");
		String style = in.next();
		car.setStyle(style);
		
		System.out.print("Розхід топлива: шосе ---> ");
		int highwayMpg = in.nextInt();
		car.setHighwayMpg(highwayMpg);
		
		System.out.print("Розхід топлива: місто ---> ");
		int cityMpg = in.nextInt();
		car.setCityMpg(cityMpg);
		
		System.out.print("Ціна $ ---> ");
		int price = in.nextInt();
		car.setPrice(price);
		
		System.out.print("Розгін до 100км/год (с) ---> ");
		double accelerationToOneHundred = in.nextDouble();
		car.setAccelerationToOneHundred(accelerationToOneHundred);
		
		autoPark.addCar(car);
		System.out.println("Автомобіль добавлено!");
		waitAnim();
	}
	
	public void deleteCar() {
		newPage();
		autoPark.showPark();
		if(!autoPark.getCars().isEmpty()) {
			System.out.println("\n\nВилучити машину");
			System.out.print("Номер ---> ");
			int index = in.nextInt();
			autoPark.removeCarByIndex(index);
			System.out.println("Автомобіль вилучено!");
		}
		waitAnim();
	}
	
	public void sortPark() {
		newPage();
		System.out.println("Сортування:");
		System.out.println("1. За роком випуску авто");
		System.out.println("2. За потужністю");
		System.out.println("3. За кількістю місць");
		System.out.println("4. За використанням пального на шосе");
		System.out.println("5. За використанням пального у місті");
		System.out.println("6. За вартістю автомобіля");
		System.out.println("7. За швидістю розгону до 100 км/год");
		System.out.println("0. Назад");
		
		System.out.print("\n\n\n\n\n\n\n\n\n\nВведіть номер пункту ----> ");
		int choice = in.nextInt();
		carFeatures feature;
		
		switch(choice) {
		case 1: feature = carFeatures.releaseYear; break;
		case 2: feature = carFeatures.engineHorsePower; break;
		case 3: feature = carFeatures.numberOfSits; break;
		case 4: feature = carFeatures.highwayMpg; break;
		case 5: feature = carFeatures.highwayMpg; break;
		case 6: feature = carFeatures.price; break;
		case 7: feature = carFeatures.acceleration; break;
		case 0: return;
		default:sortPark();return;
		}
		
		sortAscendingDescending();
		autoPark.sort(feature);
	}
	
	public void showCarsByAcceleration() {
		newPage();
		double min, max;
		System.out.println("Введіть дані:");
		System.out.print("Мінімальний час розгону ---> ");
		min = in.nextDouble();
		System.out.print("Максимальний час розгону ---> ");
		max = in.nextDouble();
		
		newPage();
		autoPark.showCarsInAccelerationRange(min, max);
		System.out.println("\n0. Назад");
	}
	
	private void sortAscendingDescending() {
		newPage();
		System.out.println("Сортування:");
		System.out.println("1. За спаданням");
		System.out.println("2. За зростанням");
		System.out.print("\n\n\n\n\n\n\n\n\n\nВведіть номер пункту ----> ");
		int choice = in.nextInt();
		
		switch(choice) {
		case 1: autoPark.setSortType(Autopark.sortingType.descending); break;
		case 2: autoPark.setSortType(Autopark.sortingType.ascending); break;
		default: sortAscendingDescending(); break;
		}
	}
	
	public void parkPrice() {
		newPage();
		autoPark.showEstimatePrice();
		System.out.println("0. Назад");
	}
	
	public void createNewRandomAutoPark() {
		newPage();
		System.out.print("Введіть кількість машин в автопарку ----> ");
		int size = in.nextInt();
		autoPark.generateAutopark(size);
		System.out.println("Autopark Created!");
		waitAnim();
	}
	
	public void loadAutoPark() {
		newPage();
		autoPark.loadAutoPark();
		waitAnim();
	}
	
	public void saveAutoPark() {
		newPage();
		autoPark.saveAutoPark();
		waitAnim();
	}
	
	public void taxiServices() {
		newPage();
		System.out.println("\tПослуги таксі");
		taxiService.showStatistic();
		System.out.println("1. Показати тарифи");
		System.out.println("2. Змінити тарифи");
		System.out.println("3. Добавити поїздку");
		System.out.println("4. Історія поїздок");
		System.out.println("0. Назад");
	}
	
	public void showTariffs() {
		newPage();
		taxiService.showTariffs();
		System.out.println("0. Назад");
	}
	
	public void changeTariffs() {
		newPage();
		taxiService.changeTariffs();
		System.out.println("Тарифи змінено!");
		waitAnim();
	}
	
	public void addTrip() {
		newPage();
		taxiService.addTrip();
		waitAnim();
	}
	
	public void tripHistory() {
		newPage();
		taxiService.tripHistory();
		System.out.println("\n0. Назад");
	}
	
	public void about() {
		newPage();
		System.out.println("Taxi Manager");
		System.out.println("Розробник - Ярослав Городиський");
		System.out.println("Версія - 1.0");
		System.out.println("Програма використовується для полегшення");
		System.out.println("управлінням таксопарку.");
	}
	
	private void newPage() {
		for(int i = 0; i < 25; i++) {
			System.out.println("\n");
		}
	}
	
	private void waitAnim() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
