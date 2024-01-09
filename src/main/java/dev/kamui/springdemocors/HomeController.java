package dev.kamui.springdemocors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    //@CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("home")
    public ResponseEntity<Map<String,Object>> home() {
        Map<String,Object> json = new HashMap<>();
        json.put("status","success");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("secure")
    public ResponseEntity<Map<String,Object>> secure() {
        Map<String,Object> json = new HashMap<>();
        json.put("status","success");
        json.put("msg","Hello, secure page");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
