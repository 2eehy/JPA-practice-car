package hooyoung.practicecar.car.service;


import hooyoung.practicecar.car.dto.CarDTO;
import hooyoung.practicecar.car.dto.CategoryDTO;
import hooyoung.practicecar.car.entity.Car;
import hooyoung.practicecar.car.entity.Category;
import hooyoung.practicecar.car.repository.CarRepository;
import hooyoung.practicecar.car.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public CarService(CarRepository carRepository,
                      ModelMapper modelMapper,
                      CategoryRepository categoryRepository) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }


    public CarDTO findCarByCarCode(int carCode) {
        Car foundCar = carRepository.findById(carCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(foundCar, CarDTO.class);
    }


    public Page<CarDTO> findCarList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
                                pageable.getPageSize()
                                );

        Page<Car> carList = carRepository.findAll(pageable);

        return carList.map(car -> modelMapper.map(car, CarDTO.class));
    }


    public List<CarDTO> findByCategory(Integer categoryCode){
        List<Car> carList = carRepository.findByCategoryCode(categoryCode);

        return carList.stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public void registNewCar(CarDTO newCar) {
        carRepository.save(modelMapper.map(newCar, Car.class));
    }


    @Transactional
    public void modifyCar(CarDTO modifyCar) {
        Car foundCar = carRepository.findById(modifyCar.getCarCode()).orElseThrow(IllegalArgumentException::new);
        foundCar = foundCar.carName(modifyCar.getCarName()).builder();


    }

    @Transactional
    public void deleteCar(Integer carCode) {
        carRepository.deleteById(carCode);
    }
}
