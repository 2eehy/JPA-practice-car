package hooyoung.practicecar.car.repository;


import hooyoung.practicecar.car.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByCategoryCode(Integer categoryCode);


}
