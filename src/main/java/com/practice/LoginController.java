package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JunyaShirahama
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
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
    public ModelAndView doSignup(@Validated LoginForm form, ModelAndView mav) {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(encodedPassword);
        userService.create(user);
        mav.setViewName("redirect:/login");
        return mav;
    }
}
