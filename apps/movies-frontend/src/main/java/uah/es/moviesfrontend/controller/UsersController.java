package uah.es.moviesfrontend.controller;

import uah.es.moviesfrontend.model.Role;
import uah.es.moviesfrontend.model.User;
import uah.es.moviesfrontend.paginator.PageRender;
import uah.es.moviesfrontend.service.IRolesService;
import uah.es.moviesfrontend.service.IUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    IUsersService usersService;

    @Autowired
    IRolesService rolesService;

    @GetMapping("/find")
    public String buscar(Model model) {
        return "users/searchUser";
    }

    @GetMapping("/list")
    public String listUser(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> list = usersService.findAll(pageable);
        PageRender<User> pageRender = new PageRender<User>("/users/list", list);
        model.addAttribute("title", "Listado de todos los usuarios");
        model.addAttribute("userList", list);
        model.addAttribute("page", pageRender);
        return "users/listUser";
    }

    @GetMapping("/username")
    public String findUserByUsername(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("username") String username) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> userList;
        if (username.equals("")) {
            userList = usersService.findAll(pageable);
        } else {
            userList = usersService.findUserByUsername(username, pageable);
        }
        PageRender<User> pageRender = new PageRender<User>("/list", userList);
        model.addAttribute("title", "Listado de usuarios por nombre");
        model.addAttribute("userList", userList);
        model.addAttribute("page", pageRender);
        return "users/listUser";
    }

    @GetMapping("/email")
    public String findUserByEmail(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("email") String email) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> userList;
        if (email.equals("")) {
            userList = usersService.findAll(pageable);
        } else {
            userList = usersService.findUserByEmail(email, pageable);
        }
        PageRender<User> pageRender = new PageRender<User>("/list", userList);
        model.addAttribute("title", "Listado de usuarios por email");
        model.addAttribute("userList", userList);
        model.addAttribute("page", pageRender);
        return "users/listUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        List<Role> roles = rolesService.findAll();
        model.addAttribute("title", "Nuevo usuario");
        model.addAttribute("allRoles", roles);
        User user = new User();
        model.addAttribute("user", user);
        return "users/formUser";
    }

    @PostMapping("/save")
    public String saveUser(Model model, User user, RedirectAttributes attributes) {
        // si existe un user con el mismo correo no lo guardamos
        if (user.getId() == null && usersService.findUserByEmail(user.getEmail()) != null) {
            attributes.addFlashAttribute("msga", "Error al guardar, ya existe el correo!");
            return "redirect:/users/list";
        }
        List<Role> roles = rolesService.findAll();
        model.addAttribute("allRoles", roles);
        usersService.saveUser(user);
        model.addAttribute("title", "Nuevo user");
        attributes.addFlashAttribute("msg", "Los datos del user fueron guardados!");
        return "redirect:/users/list";
    }

    @PostMapping("/signup")
    public String verifyUser(Model model, User user, RedirectAttributes attributes) {
        // si existe un user con el mismo correo no lo guardamos
        if (usersService.findUserByEmail(user.getEmail()) != null) {
            attributes.addFlashAttribute("msga", "Error al guardar, ya existe el correo!");
            return "redirect:/login";
        }
        user.setEnable(true);
        Role role = rolesService.findRoleById(2);
        user.setRoles(Arrays.asList(role));
        usersService.saveUser(user);
        attributes.addFlashAttribute("msg", "Los datos del registro fueron guardados!");
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Nuevo registro");
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id) {
        User user = usersService.findUserById(id);
        model.addAttribute("title", "Editar user");
        model.addAttribute("user", user);
        List<Role> roles = rolesService.findAll();
        model.addAttribute("allRoles", roles);
        return "users/formUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        User user = usersService.findUserById(id);
        if (user != null) {
            usersService.deleteUser(id);
            attributes.addFlashAttribute("msg", "Los datos del user fueron borrados!");
        } else {
            attributes.addFlashAttribute("msg", "User no encontrado!");
        }

        return "redirect:/users/list";
    }

}
