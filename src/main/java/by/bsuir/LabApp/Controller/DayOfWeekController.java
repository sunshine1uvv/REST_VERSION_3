package by.bsuir.LabApp.Controller;

import by.bsuir.LabApp.Service.DayOfWeekService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/")
public class DayOfWeekController {

    private final DayOfWeekService service;
    private static final Logger logger = LoggerFactory.getLogger(DayOfWeekController.class);

    @Autowired
    DayOfWeekController(DayOfWeekService service) {
        this.service = service;
    }

    @GetMapping("getDay")
    public String getDay(@RequestParam(value = "year", required = false) Integer year,
                         @RequestParam(value = "day", required = false) Integer day) {
        logger.info("*LOGGER* Method getDay() was called with params in controller: year - " + year + " day - " + day);
        service.validateParameters(year,day);
        return service.getDay(year, day);
    }
}