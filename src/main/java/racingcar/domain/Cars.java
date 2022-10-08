package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private static final String SPLIT_STRING = ",";

    private final List<Car> cars;
    
    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {
        List<Car> cars = new ArrayList<>();
        
        for (String name : carNames.split(SPLIT_STRING)) {
            cars.add(Car.from(name));
        }

        return new Cars(cars);
    }

    public static Cars of(Car... carArr) {
        List<Car> cars = new ArrayList<>();

        for (Car car : carArr) {
            cars.add(car);
        } 
        
        return new Cars(cars);
    }

    public void moveAllByRandom() {
        for (Car car : cars) {
            car.move(JudgmentNumber.newJudgmentNumber());
        }
    }

    public List<String> getStatusList() {
        List<String> result = new ArrayList<>();
        
        for (Car car : cars) {
            result.add(car.getStatus());
        }

        return result;
    }

    public int size() {
        return cars.size();
    } 

    public List<Car> getLongestDistanceCars() {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            addLongestDistanceCars(result, car);
        }

        return result;
    }

    private void addLongestDistanceCars(List<Car> result, Car car) {
        if (isNewLongestDistance(result, car)) {
            result.clear();
        }

        if (isLongestDistance(result, car)) {
            result.add(car);
        }
    }

    private boolean isNewLongestDistance(List<Car> result, Car car) {
        return (!result.isEmpty() && result.get(0).compareTo(car) == -1);
    }

    private boolean isLongestDistance(List<Car> result, Car car) {
        return (result.isEmpty() || result.get(0).compareTo(car) == 0);
    }
}
