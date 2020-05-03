package WeddingAgency.Controllers;
import WeddingAgency.DAO.UserDAO;
import WeddingAgency.DAO.CategoryDAO;
import WeddingAgency.DAO.GuestsDAO;
import WeddingAgency.Models.Guests;
import WeddingAgency.Models.User;
import WeddingAgency.Models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes({"userJSP", "backRef"})   //Сессионные атрибуты для извлечения данных о пользователе после входа.
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class); //подключение логгера

    @Autowired
    UserDAO userDao;

    @Autowired
    CategoryDAO categoryDao;

    @Autowired
    GuestsDAO guestsDao;

    @ModelAttribute("userJSP")
    public User createUser() {
        return new User();
    }

    @RequestMapping("/entry")      //открытие страницы входа
    public String entry(Model m){
        m.addAttribute("command", new User());
        return "Entry";
    }

    @RequestMapping("/userIndex")   //открытие главной страницы клиента после входа в систему
    public String userIndex(){ return "UserIndex"; }

    @RequestMapping("/organizatorIndex")       //открытие главной страницы организатора после входа в систему
    public String organizatorIndex(){ return "OrganizatorIndex"; }

    @RequestMapping("/organizatorRegistration")    //открытие страницы регистрации организатора
    public String organizatorRegistration(Model m){
        logger.info("Выполнение метода organizatorRegistration");
        m.addAttribute("command", new User());
        return "OrganizatorRegistration";
    }

    @RequestMapping("/userRegistration")    //открытие страницы регистрации клиента
    public String userRegistration(Model m){
        logger.info("Выполнение метода userRegistration");
        m.addAttribute("command", new User());
        return "UserRegistration";
    }

    @RequestMapping(value="/organizatorInf/{id}")   //просмотр страницы организатора и реализация кнопки вернуться на главную страницу в зависимости от типа пользователя
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

    @RequestMapping(value="/weddingHosts/{category}")     //просмотр списка организаторов по категориям и полуение навания категории и реализация кнопки Вернуться назад в заависимости от типа пользователя который вошел
    public String weddingHosts(@PathVariable int category, @ModelAttribute("userJSP") User user, Model m){
        int type = user.getTypeOfUser();
        logger.info(user.getName()+type);
        if (type==1) {m.addAttribute("backRef", "userIndex");}
        else if (type==2) {m.addAttribute("backRef", "organizatorIndex");}
        else if (type==3) {m.addAttribute("backRef", "adminIndex");}
        else {m.addAttribute("backRef", "Error");}
        List<User> list = userDao.getByCategory(category);  //Вывод списка пользователей по категориям и вывод названия категории
        Category cat = categoryDao.getCategory(category);
        m.addAttribute("list",list);
        m.addAttribute("cat",cat.getName());
        return "WeddingHosts";
    }

    @RequestMapping(value="/guests")     //просмотр списка гостей
    public String guests(@ModelAttribute("userJSP") User user, Model m){
        int userId = user.getUserId();
        List<Guests> list = guestsDao.getGuestsById(userId);
        m.addAttribute("list",list);
        m.addAttribute("command", new Guests());
        return "Guests";
    }

    @RequestMapping("index")     //при нажати на кнопку Выход, сессия будет завершена и пользователь вернется на главную страницу, где не выполнен вход
    public String back(@ModelAttribute("userJSP") User user, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "../../index";
    }

    @RequestMapping(value="/myInf")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String userInf(@ModelAttribute("userJSP") User user, Model m){    //возможность клиента просматривать информацию о себе
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "userIndex");
        return "UserInf";
    }

    @RequestMapping(value="/myOrgInf")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String myOrgInf(@ModelAttribute("userJSP") User user, Model m){       //возможность организатора просматривать информацию о себе
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "organizatorIndex");
        return "MyOrgInf";
    }

    @RequestMapping(value="/saveuser")  //добавление нового пользователя
    public String saveUser(@ModelAttribute("command") User user){
        int id = userDao.insert(user);    //вызов метода insert
        logger.info("Выполнение метода saveUser" + id);
        if (id!=-1) return "redirect:/entry";  //возвращаем страницу входа
        else return "redirect:/Error"; //Пояснение: возвращаем страницу error если при добавлении пользователя произошли ошибки
    }

    @RequestMapping(value="/saveguest")  //добавление нового гостя
    public String saveGuest(@ModelAttribute("command") Guests guest, @ModelAttribute("userJSP") User user){
        int id = guestsDao.insertGuest(user.getUserId(), guest);    //вызов метода insertGuest
        logger.info("Выполнение метода insertGuest" + id);
        if (id!=-1) return "redirect:/guests";  //возвращаем страницу входа
        else return "redirect:/Error"; //Пояснение: возвращаем страницу error если при добавлении произошли ошибки
    }

    @RequestMapping(value = "/deleteGuest/{id}")
    public String deleteGuest(@PathVariable int id){
        int i = guestsDao.deleteGuest(id);
        if (i!=-1) return "redirect:/guests";
        else return "redirect:/Error";
    }

    @RequestMapping(value="/checkUser")  //проверка пользователя при входе
    public String checkUser(@ModelAttribute("command") User user, Model m){
        User foundedUser=userDao.checkUser(user);    //Выполнение метода checkUser
        logger.info("Выполнение метода checkUser " + user.getLogin());
        if (foundedUser==null) return "redirect:/Error";
        m.addAttribute("userJSP", foundedUser);
        if (foundedUser.getTypeOfUser()==1) return "redirect:/userIndex";   //вход в зависимости от типа пользователя
        if (foundedUser.getTypeOfUser()==2) return "redirect:/organizatorIndex";
        if (foundedUser.getTypeOfUser()==3) return "redirect:/adminIndex";
        return "redirect:/Error";
    }

    @RequestMapping(value="/saveorganizator")  //добавление нового организатора
    public String saveOrganizator(@ModelAttribute("command") User user, @RequestParam("image2") MultipartFile image) {
        logger.info("Выполнение метода saveOrganizator " + image.getSize());
        try {
            user.setImage(image.getBytes());
        } catch (Exception e) {
            return "redirect:/Error";
            //return new ModelAndView("index", "msg", "Error: " + e.getMessage());
        }
        int id = userDao.insertOrg(user);    //вызов метода insertOrg
        logger.info("Выполнение метода saveOrganizator " + id);
         if (id!=-1) return "redirect:/entry";
        else return "redirect:/Error";//Пояснение: возвращаем страницу error если при изменении записи произошли ошибки
    }

    @RequestMapping("/error")   //возврат страницы с ошибкой
    public String viewUsers(){
        return "Error";
    }

    /*   @RequestMapping(value="/userInf/{id}")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String userInf(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        logger.info(user.toString());
        m.addAttribute("user", user);
        m.addAttribute("backRef", "userIndex");
        return "UserInf";
    }*/

  /*  @RequestMapping(value = "show/editsave")
    public String editSave(@ModelAttribute("command") User user){
        int id = userDao.update(user);
        if (id!=-1) return  "redirect:../entry";
        else return "redirect:/Error";
    }*/

  /*  @RequestMapping("/viewUsers") //Пояснение: указание какой url будет обрабатываться
    public String viewUsers(Model m){
        List<User> list=userDao.getAllUsers();
        m.addAttribute("list",list);
        return "ViewUsers";
    }*/

        /*@RequestMapping(value="/show/{id}")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String edit(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        m.addAttribute("command", user);
        return "EditUser";
    }*/

        /*@RequestMapping("/addUser")
    public String addUser(Model m){
        m.addAttribute("command", new User());
        return "AddUser";
    }*/



}
