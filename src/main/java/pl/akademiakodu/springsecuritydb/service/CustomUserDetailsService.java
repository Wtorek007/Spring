package pl.akademiakodu.springsecuritydb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.akademiakodu.springsecuritydb.model.CustomUserDetails;
import pl.akademiakodu.springsecuritydb.model.User;
import pl.akademiakodu.springsecuritydb.repository.UserRepository;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(s);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Not Found"));

        return optionalUser.map(CustomUserDetails::new).get();
    }
}
