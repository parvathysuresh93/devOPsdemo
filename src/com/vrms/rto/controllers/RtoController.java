package com.vrms.rto.controllers;
import java.util.List;


import javax.validation.*; 
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod; 
import com.vrms.rto.bean.Rto;    
import com.vrms.rto.dao.RtoDao;
@Controller 
public class RtoController {
	@Autowired    
    RtoDao dao;//will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/rtoform")    
    public String showform(Model m){    
        m.addAttribute("rto", new Rto());  
        return "admin/rtoform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@Valid @ModelAttribute("rto") Rto rto, BindingResult br){ 
    	 if(br.hasErrors())  

         {  
    		 return "admin/rtoform";  
         }
    	 else
    	{
        dao.save(rto);    
        return "redirect:/viewrto";//will redirect to viewemp request mapping    
    	} 
    }
    /* It provides list of employees in model object */    
    @RequestMapping("/viewrto")    
    public String viewemp(Model m){    
        List<Rto> list=dao.getRtos();    
        m.addAttribute("list",list);  
        return "admin/viewrto";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editrto/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Rto rto=dao.getRtoById(id);    
        m.addAttribute("rto",rto);  
        return "admin/rtoeditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@Valid @ModelAttribute("rto") Rto rto, BindingResult br){ 
    	 if(br.hasErrors())  

         {  
    		 return "admin/rtoeditform";  
         }
    	 else
    	 {
    	 
        dao.update(rto);    
        return "redirect:/viewrto";  
    	 }
    }   
    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleterto/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewrto";    
    }     


}
