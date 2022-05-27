package lex.JavaUploadDiscontSpringBoot.controllers;

import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_classifclients;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_clients;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_classifclientsRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_clientsRepository;
import lex.JavaUploadDiscontSpringBoot.tz.ClassifClientSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ChangeClassificClientController {

    @Autowired
    Trm_in_classifclientsRepository trm_in_classifclientsRepository;;
    @Autowired
    Trm_in_clientsRepository trm_in_clientsRepository;

    List<ClassifClientSelect> classifClientSelectListFrom = new ArrayList<>();
    List<ClassifClientSelect> classifClientSelectListTo = new ArrayList<>();
    String currenSelectClassiFrom ="";
    String currenSelectClassiTo ="";

    @GetMapping("/changeclassificclient")
    public String changeclassificclient(Model model) {
        initSeelct();
        viewPagwe(model);
        return "changeclassificclient";
    }

    @RequestMapping(value = "/changeclassificclient", params = "onСlickUploadBtn", method = RequestMethod.POST)
    public String moveClient(@RequestParam("requestclassifclientfrom") String requestclassifclientfrom,@RequestParam("requestclassifclientto") String requestclassifclientto,Model model){
        updClassifClientList(requestclassifclientfrom,classifClientSelectListFrom);
        updClassifClientList(requestclassifclientto,classifClientSelectListTo);

        Iterable<Trm_in_clients> trmInClientsListfrom = trm_in_clientsRepository.findAllByClassifclient(Long.parseLong(requestclassifclientfrom));
        List<Trm_in_clients> trmInClientslistto = new ArrayList<>();
        for (Trm_in_clients clien :
                trmInClientsListfrom) {
            System.out.println(clien);
            clien.setClassifclient(Long.parseLong(requestclassifclientto));
            System.out.println(clien);
            trmInClientslistto.add(clien);
        }

        trm_in_clientsRepository.saveAll(trmInClientslistto);


        viewPagwe(model);
        return "changeclassificclient";
    }


    public void initSeelct(){
        Iterable<Trm_in_classifclients> trm_in_classifclientsIterable = trm_in_classifclientsRepository.findAll();
        List<Trm_in_classifclients> trm_in_classifclientsList = new ArrayList<>();
        classifClientSelectListFrom.clear();
        classifClientSelectListTo.clear();
        for (Trm_in_classifclients classif:
                trm_in_classifclientsIterable) {
            classifClientSelectListFrom.add(new ClassifClientSelect(
                    classif.getId().toString(),
                    classif.getName(),
                    false
            ));
            classifClientSelectListTo.add(new ClassifClientSelect(
                    classif.getId().toString(),
                    classif.getName(),
                    false
            ));
        }
    }

    public void updClassifClientList(String current,List<ClassifClientSelect> cList ){
        for (ClassifClientSelect classif1:
                cList) {

            if (classif1.getId().equals(current)){
                classif1.setSelected(true);
            }
            else
            {
                classif1.setSelected(false);
            }
        }

    }

    public void viewPagwe(Model model){
        if ((classifClientSelectListFrom.size()==0) && (classifClientSelectListTo.size()==0)){
            initSeelct();
        }

        model.addAttribute("classifClientSelectListFrom",classifClientSelectListFrom);
        model.addAttribute("classifClientSelectListTo",classifClientSelectListTo);

    }





}
