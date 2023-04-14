package com.cbi.cbi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cbi.cbi.models.entity.Authentication;
import com.cbi.cbi.models.entity.Rol;
import com.cbi.cbi.models.entity.User;
import com.cbi.cbi.models.service.IRolService;
import com.cbi.cbi.models.service.IUserService;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
	private IUserService userService;

	@Autowired
	private IRolService rolService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("users", userService.findAll());
        model.addAttribute("title", "Usuarios");
		return "users";
	}

	@GetMapping(value = "/user/{id}")
	public String view(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {
		User user = userService.findById(id);
		if (user == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "redirect:/users";
		}
		model.addAttribute("user", user);
        model.addAttribute("title", "Detalle de usuario");
		return "view";
	}

	@RequestMapping(value = "/newUser")
	public String createUser(Model model) {
		User user = new User();
        Authentication authentication = new Authentication();
        
        user.setAuthentication(authentication);

        model.addAttribute("user", user);
        model.addAttribute("roles", roles());
        model.addAttribute("title", "Crear usuario");
		return "user";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUser(@Valid User user, BindingResult binding, Model model, RedirectAttributes flash, SessionStatus status) {
		if (binding.hasErrors())
			return "user";
	
		String message = (user.getId() == null)? "Usuario editado con éxito" : "Usuario creado con éxito";

        if (isValidPassword(user.getAuthentication().getPassword()))
            userService.save(user);
        
        userService.save(user);
        
		status.setComplete();
		flash.addFlashAttribute("success", message);
		return "redirect:/user/users";
	}

	@RequestMapping(value = "/editUser/{id}")
	public String update(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {
		User user = null;
		if (id > 0) {
			user = userService.findById(id);
			if (user == null) {
				flash.addFlashAttribute("error", "El ID del usuario no existe en la base de datos");
				return "redirect:/users";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser 0.");
			return "redirect:/users";
		}
		model.addAttribute("user", user);
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("title", "Editar usuario");
		return "user";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
		if (id > 0) {
			userService.delete(id);
			flash.addFlashAttribute("success", "Usuario eliminado con éxito.");
		}
		return "redirect:/user/users";
	}

    public List<Rol> roles() {
        System.out.println(rolService.findAll().size() + " elementos");
	    return rolService.findAll();
	}

    private boolean isValidPassword(String password) {
		if (password != null && password.length() >= 5 && password.length() <= 50) {
			return true;
		}
		return false;
	}
}