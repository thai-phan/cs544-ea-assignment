package myapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
  @GetMapping("/info")
  public ResponseEntity<?> getInfo() {
    return new ResponseEntity<String>("info", HttpStatus.OK);
  }

  @GetMapping("/user")
  public ResponseEntity<?> getUserInfo() {
    return new ResponseEntity<String>("user info", HttpStatus.OK);
  }

  @GetMapping("/admin")
  public ResponseEntity<?> getAdminInfo() {
    return new ResponseEntity<String>("admin info", HttpStatus.OK);
  }

  @GetMapping("/manager")
  public ResponseEntity<?> getManagerInfo() {
    return new ResponseEntity<String>("manager info", HttpStatus.OK);
  }

  @GetMapping("/topmanager")
  public ResponseEntity<?> getTopManagerInfo() {
    return new ResponseEntity<String>("top manager info", HttpStatus.OK);
  }
}


