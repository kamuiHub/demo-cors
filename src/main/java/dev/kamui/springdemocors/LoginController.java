package dev.kamui.springdemocors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {


    private final Map<String,Object> json = new HashMap<>();

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
            User user = (User) authentication.getPrincipal();
            json.put("status", "success");
            json.put("username", user.getUsername());
            return ResponseEntity.ok().body(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            json.put("status", "error");
            json.put("message", "Authentication failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(json);
        }
    }
}

