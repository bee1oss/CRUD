package com.example.crud.controller;


import com.example.crud.repository.User;
import com.example.crud.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController//annotation is a specialized version of @Controller that automatically serializes return objects into JSON/XML responses.
//It is equivalent to @Controller + @ResponseBody.
@RequestMapping(path = "api/users")//this annotation add our api specific path
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping//It maps HTTP GET requests
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping//it for HTTP POST reqs
    public User create(@RequestBody User user) {//@RequestBody with this we can get object from user
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestParam(required = false) String email,
                       @RequestParam(required = false) String name
    ){
        userService.update(id,email,name);
    }

}
