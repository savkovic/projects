package com.probazavrsni.controller;

import com.probazavrsni.model.Automobil;
import com.probazavrsni.model.AutomobilDao;
import com.probazavrsni.model.Korisnik;
import com.probazavrsni.model.KorisnikDao;
import com.probazavrsni.model.Marka;
import com.probazavrsni.model.MarkaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.websocket.server.PathParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    @Autowired
    MarkaDao markaDao;

    @Autowired
    AutomobilDao automobilDao;

    @Autowired
    KorisnikDao korisnikDao; 

    @RequestMapping(value = "/loginn", method = RequestMethod.POST)
    
public String provera(@RequestParam String username,@RequestParam String password) {
       
    
    
    boolean exist = korisnikDao.provera(username, password);
        if (exist == true) {
            return "/admin";
        } else {
            String poruka = "Los unos, pokusajte ponovo!";
                
            return "/login";
        }
        
        
}

// public boolean provera(String username,String password){
//        Session s = sessionFactory.getCurrentSession();
//        Korisnik k  = (Korisnik) s.getNamedQuery("Korisnik.findByUsername").setString(0, username).setString(1, password).uniqueResult();
//        return k != null;
//    }
 
    @RequestMapping("/")
    public String index(ModelMap mode) {
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        return "index";
    }

    @RequestMapping("/{id}")
    public String byMarka(@PathVariable int id, ModelMap mode) {
        List<Marka> marka = markaDao.find();
        List<Automobil> automobili = automobilDao.findByMarka(id);
        mode.addAttribute("marka", marka);
        mode.addAttribute("automobili", automobili);
        return "index";
    }

    @RequestMapping("/opis/{id}")
    public String byOpis(@PathVariable int id, ModelMap mode) {

        List<Marka> marka = markaDao.find();
        List<Automobil> automobili = automobilDao.findByMarka(id);
        mode.addAttribute("marka", marka);
        Automobil automobil = automobilDao.getById(id);
        mode.addAttribute("automobil", automobil);
        return "opis";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("newKorisnik") Korisnik korisnik, ModelMap mode) {
        List<Korisnik> kori = korisnikDao.listaKorisnika();
        mode.addAttribute("korisnik", kori);

        if (korisnik.getPassword() != null && korisnik.getUsername() != null) {
            korisnik.setUsername(korisnik.getUsername());
            korisnik.setPassword(korisnik.getPassword());
            System.out.println(korisnik.getUsername());
            korisnikDao.add(korisnik);

        } else {
            System.out.println("greska majstore");
        }

        return "login";
    }
//     @RequestMapping("/register")
//    public String register(@ModelAttribute("registerUser") User user, Model model) {
//        List<Brand> brand = getUserService().listaKategorija();
//        model.addAttribute("brand", brand);
//        if (user.getEmail() != null && user.getFirstName() != null && user.getLastName() != null && user.getPassword() != null && user.getSsoId() != null) {
//            user.setFirstName(user.getFirstName());
//            user.setLastName(user.getLastName());
//            user.setSsoId(user.getSsoId());
//            user.setPassword(user.getPassword());
//            user.setEmail(user.getEmail());
//            System.out.println(user.getFirstName());
//            getUserService().register(user);
//        } else {
//        }
//        return "register";

    @RequestMapping("/register")
    public String register() {

        return "register";
    }
}
