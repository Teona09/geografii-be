package org.geografii.controller;

import org.geografii.dto.LoginDTO;
import org.geografii.dto.TokenDTO;
import org.geografii.dto.UserModelDTO;
import org.geografii.exception.CustomException;
import org.geografii.service.UserService;
import org.geografii.service.security.AuthenticationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> loginUser(@Valid @RequestBody LoginDTO loginDTO) throws CustomException {
        TokenDTO authentication = authenticationService.loginUser(loginDTO);
        return new ResponseEntity<>(authentication, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UserModelDTO userDTO) throws CustomException {
        UserModelDTO user = userService.registerUser(userDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/email")
    public ResponseEntity checkEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.existsByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity checkEmail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@Valid @RequestBody UserModelDTO userDTO) throws CustomException {
        UserModelDTO user = userService.updateUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/password/{id}")
    public ResponseEntity resetPassword(@PathVariable("id") Long id,@RequestParam String password) throws CustomException {
        userService.resetPassword(id,password);
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws CustomException {
        userService.deleteAccount(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }
}
