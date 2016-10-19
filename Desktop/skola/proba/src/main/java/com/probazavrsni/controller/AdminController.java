
package com.probazavrsni.controller;

import com.probazavrsni.model.Automobil;
import com.probazavrsni.model.AutomobilDao;
import com.probazavrsni.model.Marka;
import com.probazavrsni.model.MarkaDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MarkaDao markaDao;
    
    @Autowired
    AutomobilDao automobilDao;
    
    
    
    @RequestMapping("/")
    public String index(ModelMap mode){
    List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        return "admin";
    }
    
    @RequestMapping("marka")
    public String marka(@RequestParam(required = false) Integer id, ModelMap mode){
        
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        if(id!=null){
        
        
        Marka selectedMarka = markaDao.getById(id);
        mode.addAttribute("selectedMarka", selectedMarka);
        }
        return "/marka";
    }
    
    @RequestMapping("/updatemarka")
    public String updateMarka(ModelMap mode,
            @RequestParam Integer id,
            @RequestParam String ime,
            @RequestParam String opis
    ){
        
        
        Marka selectedMarka = markaDao.getById(id);
        selectedMarka.setIme(ime);
        selectedMarka.setOpis(opis);
        markaDao.update(selectedMarka); 
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        mode.addAttribute("selectedMarka", selectedMarka);
        
        
    
        return "/marka";
    }
    @RequestMapping("/deletemarka")
    public String deleteMarka(ModelMap mode,
            @RequestParam Integer id,
            @RequestParam String ime,
            @RequestParam String opis
    ){
        
        
        Marka selectedMarka = markaDao.getById(id);
        selectedMarka.setIme(ime);
        selectedMarka.setOpis(opis);
        markaDao.delete(selectedMarka); 
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        mode.addAttribute("selectedMarka", selectedMarka);
        
        
    
        return "/markadelete";
    }
    
     @RequestMapping("markadelete")
    public String markaDelete(@RequestParam(required = false) Integer id, ModelMap mode){
        
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
        if(id!=null){
        
        
        Marka selectedMarka = markaDao.getById(id);
        mode.addAttribute("selectedMarka", selectedMarka);
        }
        return "/markadelete";
    }
    
    @RequestMapping("/markaadd")
    public String markaAdd (@ModelAttribute("newMarka") Marka marka){
        if (marka.getIme() != null && marka.getOpis() != null) {
            marka.setIme(marka.getIme());
            marka.setOpis(marka.getOpis());
            System.out.println(marka.getIme());
            markaDao.add(marka);
        }else {
            System.out.println("aaa");
        }
        return "markaadd";
    }
    
    @RequestMapping("/automobil")
    public String automobil(ModelMap mode){
     List<Automobil> automobil=automobilDao.find();
     mode.addAttribute("automobil", automobil);     
        List<Marka> marka = markaDao.find();
        mode.addAttribute("marka", marka);
     
        
    
    
        return"automobil";
    }
    
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(@RequestParam Integer id, ModelMap mode){
    Automobil automobil = automobilDao.getById(id);
    mode.addAttribute("automobil", automobil);
    List<Marka> marke = markaDao.find();
    mode.addAttribute("marka", marke);
        return "/update";
    }
   
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updatePost(
            @RequestParam Integer id,
            @RequestParam Integer cena,
            @RequestParam String model,
            @RequestParam String opis,
            @RequestParam Integer marka,
            @RequestParam MultipartFile photo,
            
            
            
            
            ModelMap mode,HttpServletRequest request) throws FileNotFoundException, IOException{
        List<Marka> marke = markaDao.find();
        mode.addAttribute("marka", marke);
        Automobil automobil = automobilDao.getById(id);
        automobil.setCena(cena);
        automobil.setModel(model);
        
        if(photo!=null&&!photo.isEmpty()){
                String filepath=request.getServletContext().getRealPath("resorsi/images");
                FileOutputStream fos = new FileOutputStream(filepath+"/"+photo.getOriginalFilename());
                automobil.setSlika(photo.getOriginalFilename());
                fos.write(photo.getBytes());
                fos.close();
    }
        
        automobil.setOpis(opis);
        automobil.setMarka(marka);
        automobilDao.update(automobil);
        mode.addAttribute("automobil", automobil);
        
            return "/update";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam Integer id,ModelMap mode){
    
            Automobil automobil = automobilDao.getById(id);
            mode.addAttribute("automobil", automobil);
            List<Marka> marke = markaDao.find();
            mode.addAttribute("marka", marke);
            automobilDao.delete(automobil);

        return "/delete";
    }
//    @RequestMapping("/add")
//    public String addAutomobil (@ModelAttribute("newAutomobil") Automobil automobil,
//             
//            
//            ModelMap mode){
//        
//        List<Marka> marke = markaDao.find();
//        mode.addAttribute("marka", marke);
//      
//        if (automobil.getCena()!= null && automobil.getOpis() != null && automobil.getMarka()!= null && automobil.getModel()!= null) {
//            automobil.setCena(automobil.getCena());
//            automobil.setOpis(automobil.getOpis());
//            automobil.setMarka(automobil.getMarka());
//            automobil.setModel(automobil.getModel());
//            System.out.println(automobil.getMarka());
//            automobilDao.add(automobil);
//        }else {
//            System.out.println("aaa");
//        }
//       
//        return "/add";
//    }
    
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String AddGet(ModelMap mode){
        List<Marka> marke = markaDao.find();
        mode.addAttribute("marka", marke);

    return "add";
}
    
    
    
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String Add (@ModelAttribute("newAutomobil") Automobil automobil,ModelMap mode,HttpServletRequest request,MultipartFile photo) throws FileNotFoundException, IOException{
        List<Marka> marke = markaDao.find();
        mode.addAttribute("marka", marke);
        
        
        if (automobil.getModel()!= null && automobil.getOpis() != null && automobil.getCena()!= null && automobil.getMarka()!= null && photo!=null&&!photo.isEmpty()) {
            automobil.setModel(automobil.getModel());
            automobil.setOpis(automobil.getOpis());
            automobil.setCena(automobil.getCena());
            automobil.setMarka(automobil.getMarka());
            String filepath=request.getServletContext().getRealPath("resorsi/images");
                FileOutputStream fos = new FileOutputStream(filepath+"/"+photo.getOriginalFilename());
                automobil.setSlika(photo.getOriginalFilename());
                fos.write(photo.getBytes());
                fos.close();

            
            
            System.out.println(automobil.getModel());
            automobilDao.add(automobil);
        }else {
            System.out.println("aaa");
        }
        return "add";
    }
    
   
 
}
 