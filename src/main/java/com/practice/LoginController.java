package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JunyaShirahama
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ModelAndView signup(ModelAndView mav) {
        mav.setViewName("signup");
        return mav;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ModelAndView doSignup(@ModelAttribute("loginForm") @Validated LoginForm form, @AuthenticationPrincipal LoginUserDetails userDetails, ModelAndView mav) {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        mav.setViewName("redirect:/login");
        return mav;
    }
}
