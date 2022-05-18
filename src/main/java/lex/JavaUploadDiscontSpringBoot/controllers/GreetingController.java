package lex.JavaUploadDiscontSpringBoot.controllers;


import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_card_client;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_cards;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_classifclients;
import lex.JavaUploadDiscontSpringBoot.excel.ExcelBean;
import lex.JavaUploadDiscontSpringBoot.excel.ExcelUtils;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_card_clientRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_cardsRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_classifclientsRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_clientsRepository;
import lex.JavaUploadDiscontSpringBoot.tz.TZClientsChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    List<ExcelBean> listExcel = null;
    List<TZClientsChange> tzClientsChangeList = new ArrayList<>();

    @Autowired
    Trm_in_classifclientsRepository trm_in_classifclientsRepository;
    @Autowired
    Trm_in_card_clientRepository trm_in_card_clientRepository;
    @Autowired
    Trm_in_cardsRepository trm_in_cardsRepository;
    @Autowired
    Trm_in_clientsRepository trm_in_clientsRepository;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {



        model.addAttribute("name", name);
        viewPagwe(model);
        return "greeting";
    }

    public void viewPagwe(Model model){
        Iterable<Trm_in_classifclients> trm_in_classifclientsIterable = trm_in_classifclientsRepository.findAll();
        List<Trm_in_classifclients> trm_in_classifclientsList = new ArrayList<>();
        for (Trm_in_classifclients classif:
             trm_in_classifclientsIterable) {
            trm_in_classifclientsList.add(classif);
           // System.out.println(classif.toString());
        }

        for (Trm_in_classifclients classif1:
                trm_in_classifclientsList) {

            System.out.println(classif1.toString());
        }
        model.addAttribute("classifclients",trm_in_classifclientsList);

    }


    @RequestMapping(value = "/greeting", params = "onСlickSelectBtn", method = RequestMethod.POST)
    public String uploadExcel(@RequestParam("file") MultipartFile file,  Model model) {
        String name = file.getOriginalFilename (); // Получаем имя файла при загрузке
        if (name.length() < 6 || !name.substring(name.length() - 5).equals(".xlsx")) {
            return "Ошибка формата файла";
        }
        try {
            listExcel = ExcelUtils.excelToShopIdList(file.getInputStream());
            if (listExcel == null || listExcel.size() <= 0) {
                return "Импортированные данные пусты";
            }
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        System.out.println(listExcel.size());


        model.addAttribute("file",file);
        viewPagwe(model);
        for (ExcelBean str :
                listExcel) {
            System.out.println(str.toString());
            Trm_in_cards trm_in_card =  trm_in_cardsRepository.findByStart_card_code(str.getPhone()).get();
            System.out.println(trm_in_card.toString());
            /*Trm_in_card_client trm_in_card_client = trm_in_card_clientRepository.findByCard(trm_in_card.getId()).get();
            System.out.println(trm_in_card_client.toString());*/
        }


        return "greeting";
    }


    @RequestMapping(value = "/greeting", params = "onСlickUploadBtn", method = RequestMethod.POST)
    public String uploadExcel(Model model) {




        viewPagwe(model);
        return "greeting";
    }



}