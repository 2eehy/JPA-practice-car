package hooyoung.practicecar.car.controller;


import hooyoung.practicecar.car.dto.CarDTO;
import hooyoung.practicecar.car.dto.CategoryDTO;
import hooyoung.practicecar.car.service.CarService;
import hooyoung.practicecar.common.Pagenation;
import hooyoung.practicecar.common.PagingButton;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/{carCode}")
    public String findCarByCode(@PathVariable int carCode, Model model) {
        System.out.println(carCode);
        CarDTO resultCar = carService.findCarByCarCode(carCode);
        model.addAttribute("car", resultCar);
        return "car/detail";
    }


    @GetMapping("/list")
    public String findCarList(Model model, @PageableDefault Pageable pageable) {

        Page<CarDTO> carList = carService.findCarList(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(carList);


        model.addAttribute("carList", carList);
        model.addAttribute("paging", paging);

        return "car/list";
    }




    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer categoryCode, Model model) {
        List<CarDTO> carList = carService.findByCategory(categoryCode);
        model.addAttribute("carList", carList);
        model.addAttribute("categoryCode", categoryCode);

        return "car/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return carService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registNewCar(CarDTO carDTO) {
        carService.registNewCar(carDTO);

        return "redirect:/car/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyCar(CarDTO modifyCar) {
        carService.modifyCar(modifyCar);
        return "redirect:/car/" + modifyCar.getCarCode();
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam Integer carCode) {
        carService.deleteCar(carCode);
        return "redirect:/car/list";
    }

}
