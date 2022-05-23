package noora.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import noora.demo.Entity.CustomUserDetail;
import noora.demo.Repository.UserRepository;
import noora.demo.Entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired UserRepository userRepository; 

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return user.map(CustomUserDetail::new).get();
        
    }

}
