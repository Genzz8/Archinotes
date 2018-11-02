package it.risolo.ArchiNotes.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.risolo.ArchiNotes.model.dto.UserDto;
import it.risolo.ArchiNotes.services.user.UserService;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(path="/getUser", produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<UserDto> getUser(@RequestParam String name) {
		List<UserDto> users = userService.findUserByName(name);
		return users;
	}
	
	@PostMapping("/sign-up")
    public void signUp(@RequestBody UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.insertUser(user);
    }
	
}
