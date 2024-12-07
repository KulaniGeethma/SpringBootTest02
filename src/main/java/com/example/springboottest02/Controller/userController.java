//package com.example.springboottest02.Controller;
//import com.example.springboottest02.service.userService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.example.springboottest02.DTO.userDTO;
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping(value="api/v1/")
//public class userController {
//    @Autowired
//    private userService userService;
//    private com.example.springboottest02.DTO.userDTO userDTO;
//
//    @GetMapping("/getUsers")
//    public  List<userDTO> getUsers() {
//        return userService.getAllUsers();
//    }
//    @PostMapping("/addUsers")
//    public userDTO saveUser(@RequestBody userDTO userId){
//        return userService.saveUser(userDTO);
//    }
//    @PutMapping("/updateUser")
//    public userDTO updateUser(@RequestBody userDTO userId){
//        return userService.updateUser(userDTO);
//    }
//    @DeleteMapping("/deleteUser")
//    public String DeleteUser(@RequestBody userDTO userId){
//        return userService.deleteUser(userDTO);
//    }
//
//}
package com.example.springboottest02.Controller;

import com.example.springboottest02.DTO.userDTO;
import com.example.springboottest02.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users")
public class userController {
    @Autowired
    private userService userService;
    //@Autowired
//    public userController(userService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/getUsers")
    public List<userDTO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/saveUsers")
    public userDTO saveUser(@RequestBody userDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUsers")
    public userDTO updateUser(@RequestBody userDTO userDTO) {
        return userService.updateUser(userDTO);
    }

//    public ResponseEntity<userDTO> saveUser(@RequestBody userDTO userDTO) {
//        return ResponseEntity.ok(userService.saveUser(userDTO));
//    }

//    @PutMapping("/updateUsers")
//    public userDTO updateUser(@RequestBody userDTO userDTO) {
//        return userService.updateUser(userDTO);
//    }
//
    @DeleteMapping("deleteUsers")
    public String deleteUser(@RequestBody userDTO userDTO) {
        return userService.deleteUser(userDTO);
    }
}
//}