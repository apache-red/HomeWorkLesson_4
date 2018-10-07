package com.homeWorkLesson_4.house;


import com.homeWorkLesson_4.house.domain.Message;
import com.homeWorkLesson_4.house.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam Integer apartmentNumber, @RequestParam Double area,
                      @RequestParam Integer floor, @RequestParam Integer numberOfRooms,
                      @RequestParam String street, @RequestParam String buildingType,
                      @RequestParam Integer lifetime,
                      Map<String, Object> model) {
        Message message = new Message(apartmentNumber,area,floor,numberOfRooms,street,buildingType,lifetime);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterCondition1")
    public String filterCondition1(@RequestParam Integer filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && filter !=0 && filter >0) {
            messages = messageRepo.findByNumberOfRooms(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filterCondition2")
    public String filterCondition2(@RequestParam Integer filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && filter !=0 && filter >0) {
            messages = messageRepo.findByNumberOfRooms(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filterCondition3")
    public String filterCondition3(@RequestParam Double filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && filter !=0 && filter >0) {

           messages = messageRepo.findByAreaGreaterThan(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }


}