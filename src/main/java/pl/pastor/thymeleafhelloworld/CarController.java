package pl.pastor.thymeleafhelloworld;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {


        private List<Car> cars;

    public CarController() {
        Car car1 = new Car("BMW", "i8");
        Car car2 = new Car("Polonez", "Caro");
        Car car3 = new Car("Hyundai", "i30");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

         @GetMapping("/car")
         public String getCar(Model model){
            model.addAttribute("name","Maciej");
            model.addAttribute("cars", cars);
            model.addAttribute("newCar",new Car());
         return "car";
    }

        @PostMapping ("/add-car")
        public String addCar (@ModelAttribute Car car) {
                cars.add(car);
              System.out.println(car);
              return "redirect:/car";
        }
}
