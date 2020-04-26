package WeddingAgency.Controllers;

import WeddingAgency.DAO.UserDAO;
import WeddingAgency.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDAO userDao;

    @RequestMapping("/viewUsers")//Пояснение: указание какой url будет обрабатываться
    public String viewUsers(Model m){
        List<User> list=userDao.getAllUsers();//Пояснение: добавление атрибутов в представление
        m.addAttribute("list",list);
        return "ViewUsers";
    }

    @RequestMapping("/entry")
    public String entry(){ return "Entry"; }

    @RequestMapping("/userIndex")
    public String userIndex(){ return "UserIndex"; }

    @RequestMapping("/organizatorIndex")
    public String organizatorIndex(){ return "OrganizatorIndex"; }

    @RequestMapping("/organizatorRegistration")
    public String organizatorRegistration(){ return "OrganizatorRegistration"; }

    @RequestMapping("/userRegistration")
    public String userRegistration(){ return "UserRegistration"; }

    @RequestMapping("/weddingHosts")
    public String weddingHosts(){ return "WeddingHosts"; }

    @RequestMapping("/photographer")
    public String photographer(){ return "Photographer"; }

    @RequestMapping("/videographer")
    public String videographer(){ return "Videographer"; }

    @RequestMapping("/restaurant")
    public String restaurant(){ return "Restaurant"; }

    @RequestMapping("/decor")
    public String decor(){ return "Decor"; }

    @RequestMapping("/hairMakeUpMaster")
    public String hairMakeUpMaster(){ return "HairMakeUpMaster"; }

    @RequestMapping("/bridalShop")
    public String bridalShop(){ return "BridalShop"; }

    @RequestMapping("/showProgram")
    public String showProgram(){ return "ShowProgram"; }

    @RequestMapping("/transport")
    public String transport(){ return "Transport"; }

    @RequestMapping("/cake")
    public String cake(){ return "Cake"; }

    @RequestMapping("/music")
    public String music(){ return "Music"; }

    @RequestMapping("/dance")
    public String dance(){ return "Dance"; }

    @RequestMapping("/hotel")
    public String hotel(){ return "Hotel"; }

    @RequestMapping("index")
    public String back(){
        return "../../index";
    }

    @RequestMapping(value="/show/{id}")//Пояснение: @PathVariable используется для работы с параметрами, передаваемыми через адрес запроса
    public String edit(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        m.addAttribute("command",user);
        return "EditUser";
    }

    @RequestMapping(value = "show/editsave")
    public String editSave(@ModelAttribute("command") User user){
        int id = userDao.update(user);
        if (id!=-1) return  "redirect:../viewUsers";
        else return "redirect:/Error";
    }

    @RequestMapping(value="/saveuser")
    public String saveUser(@ModelAttribute("command") User user){
        int id = userDao.insert(user);
        if (id!=-1) return "redirect:/viewUsers";
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
