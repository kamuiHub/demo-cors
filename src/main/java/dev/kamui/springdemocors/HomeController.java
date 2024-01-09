package dev.kamui.springdemocors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    //@CrossOrigin("http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<Map<String,Object>> home() {
        Map<String,Object> json = new HashMap<>();
        json.put("status","success");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
