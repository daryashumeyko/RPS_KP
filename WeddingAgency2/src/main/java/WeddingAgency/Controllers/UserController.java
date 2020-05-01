package WeddingAgency.Controllers;

import WeddingAgency.DAO.UserDAO;
import WeddingAgency.DAO.CategoryDAO;
import WeddingAgency.Models.User;
import WeddingAgency.Models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes({"userJSP", "backRef"})
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDAO userDao;

    @Autowired
    CategoryDAO categoryDao;

    @ModelAttribute("userJSP")
    public User createUser() {
        return new User();
    }

    @RequestMapping("/viewUsers") //Пояснение: указание какой url будет обрабатываться
    public String viewUsers(Model m){
        List<User> list=userDao.getAllUsers(); //Пояснение: добавление атрибутов в представление
        m.addAttribute("list",list);
        return "ViewUsers";
    }

    @RequestMapping("/entry")
    public String entry(Model m){
        m.addAttribute("command", new User());
        return "Entry";
    }

    @RequestMapping("/userIndex")
    public String userIndex(){ return "UserIndex"; }

    @RequestMapping("/organizatorIndex")
    public String organizatorIndex(){ return "OrganizatorIndex"; }

    @RequestMapping("/organizatorRegistration")
    public String organizatorRegistration(Model m){
        logger.info("Выполнение метода organizatorRegistration");
        m.addAttribute("command", new User());
        return "OrganizatorRegistration";
    }

    @RequestMapping("/userRegistration")
    public String userRegistration(Model m){
        logger.info("Выполнение метода userRegistration");
        m.addAttribute("command", new User());
        return "UserRegistration";
    }

    @RequestMapping(value="/organizatorInf/{id}")
    public String organizatorInf(@PathVariable int id,  @ModelAttribute("userJSP") User userjsp, Model m){
        User user=userDao.getUserById(id);  //Вывод организатора
        logger.info(user.toString());
        m.addAttribute("user", user);
        int type = userjsp.getTypeOfUser();
        if (type==1) {m.addAttribute("backRef", "userIndex");}
        else if (type==2) {m.addAttribute("backRef", "organizatorIndex");}
        else if (type==3) {m.addAttribute("backRef", "adminIndex");}
        else {m.addAttribute("backRef", "Error");}
        return "OrganizatorInf";
    }

    @RequestMapping(value="/weddingHosts/{category}")
    public String weddingHosts(@PathVariable int category, @ModelAttribute("userJSP") User user, Model m){
        int type = user.getTypeOfUser();
        logger.info(user.getName()+type);
        if (type==1) {m.addAttribute("backRef", "userIndex");}
        else if (type==2) {m.addAttribute("backRef", "organizatorIndex");}
        else if (type==3) {m.addAttribute("backRef", "adminIndex");}
        else {m.addAttribute("backRef", "Error");}
        List<User> list=userDao.getByCategory(category);  //Вывод списка пользователей по категориям и вывод названия категории
        Category cat=categoryDao.getCategory(category);
        m.addAttribute("list",list);
        m.addAttribute("cat",cat.getName());
        return "WeddingHosts";
    }

    @RequestMapping("index")
    public String back(@ModelAttribute("userJSP") User user, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "../../index";
    }

    @RequestMapping(value="/show/{id}")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String edit(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        m.addAttribute("command", user);
        return "EditUser";
    }

    @RequestMapping(value="/myInf")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String userInf(@ModelAttribute("userJSP") User user, Model m){
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "userIndex");
        return "UserInf";
    }

    @RequestMapping(value="/myOrgInf")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String myOrgInf(@ModelAttribute("userJSP") User user, Model m){
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "organizatorIndex");
        return "MyOrgInf";
    }

 /*   @RequestMapping(value="/userInf/{id}")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String userInf(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "userIndex");
        return "UserInf";
    }*/

    @RequestMapping(value = "show/editsave")
    public String editSave(@ModelAttribute("command") User user){
        int id = userDao.update(user);
        if (id!=-1) return  "redirect:../entry";
        else return "redirect:/Error";
    }

    @RequestMapping(value="/saveuser")  //добавление нового пользователя
    public String saveUser(@ModelAttribute("command") User user){
        int id = userDao.insert(user);
        logger.info("Выполнение метода saveUser" + id);
        if (id!=-1) return "redirect:/entry";
        else return "redirect:/Error";//Пояснение: возвращаем страницу error если при изменении записи произошли ошибки
    }

    @RequestMapping(value="/checkUser")  //проверка пользователя
    public String checkUser(@ModelAttribute("command") User user, Model m){
        User foundedUser=userDao.checkUser(user);
        logger.info("Выполнение метода checkUser " + user.getLogin());
        if (foundedUser==null) return "redirect:/Error";
        m.addAttribute("userJSP", foundedUser);
        if (foundedUser.getTypeOfUser()==1) return "redirect:/userIndex";//Пояснение: возвращаем страницу error если при изменении записи произошли ошибки
        if (foundedUser.getTypeOfUser()==2) return "redirect:/organizatorIndex";
        if (foundedUser.getTypeOfUser()==3) return "redirect:/adminIndex";
        return "redirect:/Error";
    }

    @RequestMapping(value="/saveorganizator")  //добавление нового пользователя
    public String saveOrganizator(@ModelAttribute("command") User user){
        int id = userDao.insertOrg(user);
        logger.info("Выполнение метода saveOrganizator" + id);
        if (id!=-1) return "redirect:/entry";
        else return "redirect:/Error";//Пояснение: возвращаем страницу error если при изменении записи произошли ошибки
    }

    @RequestMapping("/addUser")
    public String addUser(Model m){
        m.addAttribute("command", new User());
        return "AddUser";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        int i = userDao.delete(id);
        if (i!=-1) return "redirect:/viewUsers";
        else return "redirect:/Error";
    }

    @RequestMapping("/error")
    public String viewUsers(){
        return "Error";
    }
}
