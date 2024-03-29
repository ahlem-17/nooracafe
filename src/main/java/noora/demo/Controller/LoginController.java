package noora.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import noora.demo.Entity.Role;
import noora.demo.Entity.User;
import noora.demo.Repository.RoleRepository;
import noora.demo.Repository.UserRepository;



@Controller
public class LoginController {
    
    @Autowired 
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired UserRepository userRepository;
    @Autowired RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        
        return "login";
    }
    
    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }
    @PostMapping("/register")
    public String createUser(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        
        user.setRoles(roles);
        userRepository.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/";
    }
    @GetMapping("/password")
    public String passwordGet() {
        return "password";
    }
    @PostMapping("/password")
    public String resetPassword(@RequestParam String email, @RequestParam String password){
        return "redirect:/login";
    }
}
