package neobis.week5.service;


import neobis.week5.config.JwtUtil;
import neobis.week5.dto.AuthResponse;
import neobis.week5.dto.Login;
import neobis.week5.dto.Register;
import neobis.week5.entity.Role;
import neobis.week5.entity.User;
import neobis.week5.exception.ResourceNotFoundException;
import neobis.week5.exception.UserAlreadyExistsException;
import neobis.week5.exception.UserNotFoundException;
import neobis.week5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
@Autowired
    private  UserRepository userRepository;
@Autowired
    private PasswordEncoder passwordEncoder;
@Autowired
    private  JwtUtil jwtUtil;
@Autowired
    private AuthenticationManager authenticationManager;

public ResponseEntity<User> findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));
        return ResponseEntity.ok(user);
    }

    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));
        userRepository.deleteById(id);
        return ResponseEntity.ok(user);
    }

    public void register(Register request) throws UserAlreadyExistsException {
        User user = new User();
                user.setName(request.getName());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setRole(Role.USER);
        if(userRepository.findByName(request.getName()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(user);
    }
    public AuthResponse login(Login request) throws UserNotFoundException {
        User user = userRepository.findByName(request.getEmail())
                .orElseThrow(UserNotFoundException::new);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        String userEmail = user.getName();
        var jwtToken = jwtUtil.generateToken(userEmail);
        System.out.println(jwtToken);
        return AuthResponse.builder().token(jwtToken).build();
    }


}
