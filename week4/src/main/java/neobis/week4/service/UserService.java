package neobis.week4.service;


import neobis.week4.config.MyUserDetails;
import neobis.week4.entity.User;
import neobis.week4.exception.ResourceNotFoundException;
import neobis.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
@Autowired
    private  UserRepository userRepository;
@Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

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

    public void addUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}
