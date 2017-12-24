package me.ennevor.sandbox.controller;


import me.ennevor.sandbox.SandboxApplication;
import me.ennevor.sandbox.entity.Entry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class MainController {

    @RequestMapping("/puppet")
    public List<Entry> returnOneHundredThousandsRows(){
        return SandboxApplication.entryList;
    }
}
