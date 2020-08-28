package com.findsportmates.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import wrapper.IUser;
import wrapper.User;
import wrapper.IUserServiceImpl;
import wrapper.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
// only use when generic parameter bc it takes memory
@Controller
@SessionAttributes("userid")
public class UserController {
    private IUserServiceImpl userService;

    @Autowired(required = true)
    @Qualifier("userService")
    public void setUserService(IUserServiceImpl us) {
    	System.err.println("UserController setter called to place user service bean "+((Proxy) us).getProxyId());
        this.userService = us;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model) {
        System.err.println("register GET called");
        IUser user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(ModelMap model, User user) {
        System.err.println("register POST called");
        System.out.println(user);
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam
    String username, @RequestParam
    String password, ModelMap model) {
        if (!userService.isUserValid(username, password)) {
            model.put("errorMsg", "Invalid user");
            return "login";
        }
        System.out.println("username: " + username);
        model.addAttribute("userid", Integer.toString(userService.getUserByName(username).getId()));
        System.err.println("model userid: " + model.getAttribute("userid"));
        return "redirect:/event";
    }

    @RequestMapping(value = "/search-user", method = RequestMethod.GET)
    public String showSearchUserPage(ModelMap model) {
        // model.addAttribute("user", new User());
        return "searchuser";
    }

    @RequestMapping(value = "/search-user", method = RequestMethod.POST)
    public String searchtEvent(ModelMap model, @RequestParam("username")
    String username) {
        IUser result = this.userService.getUserByName(username);
        model.addAttribute("user", result);
        return "searchuser_result";
    }
}