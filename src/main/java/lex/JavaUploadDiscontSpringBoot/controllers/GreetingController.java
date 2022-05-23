package lex.JavaUploadDiscontSpringBoot.controllers;


import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_card_client;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_cards;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_classifclients;
import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_clients;
import lex.JavaUploadDiscontSpringBoot.enumumeration.StatusChange;
import lex.JavaUploadDiscontSpringBoot.excel.ExcelBean;
import lex.JavaUploadDiscontSpringBoot.excel.ExcelUtils;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_card_clientRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_cardsRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_classifclientsRepository;
import lex.JavaUploadDiscontSpringBoot.repository.Trm_in_clientsRepository;
import lex.JavaUploadDiscontSpringBoot.tz.ClassifClientSelect;
import lex.JavaUploadDiscontSpringBoot.tz.TZClientsChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    Trm_in_classifclients requestclassifclient = new Trm_in_classifclients();

    //-------------выбор груп клиентов
    List<ClassifClientSelect>  classifClientSelectList = new ArrayList<>();
    String currenSelectClassi ="";






    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        viewPagwe(model);
        //model.addAttribute("classifclient", new Trm_in_classifclients());

        return "greeting";
    }

    public void initSeelct(){
        Iterable<Trm_in_classifclients> trm_in_classifclientsIterable = trm_in_classifclientsRepository.findAll();
        List<Trm_in_classifclients> trm_in_classifclientsList = new ArrayList<>();
        for (Trm_in_classifclients classif:
                trm_in_classifclientsIterable) {
            classifClientSelectList.add(new ClassifClientSelect(
                    classif.getId().toString(),
                    classif.getName(),
                    false
            ));
         }


    }

    public void updClassifClientList(String current){
        for (ClassifClientSelect classif1:
                classifClientSelectList) {

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
        /*for (ClassifClientSelect classif1:
                classifClientSelectList) {

            System.out.println(classif1.toString());
        }*/
        if (classifClientSelectList.size()==0){
            initSeelct();
        }
        model.addAttribute("classifclients",classifClientSelectList);
        model.addAttribute("clients",tzClientsChangeList);


    }


    @RequestMapping(value = "/greeting", params = "onСlickSelectBtn", method = RequestMethod.POST)
    public String uploadExcel(@RequestParam("file") MultipartFile file,@RequestParam("requestclassifclient") String requestclassifclient,   Model model) {
        //@RequestParam("classifclient.id") Long selectid,
        updClassifClientList(requestclassifclient);
        tzClientsChangeList.clear();
        String name = file.getOriginalFilename (); // Получаем имя файла при загрузке
        if (name.length() < 6 || !name.substring(name.length() - 5).equals(".xlsx")) {
            System.out.println("Ошибка формата файла");
            model.addAttribute("file",file);
            viewPagwe(model);
            return "greeting";
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
            Trm_in_card_client trm_in_card_client = trm_in_card_clientRepository.findByCard(trm_in_card.getId()).get();
            System.out.println(trm_in_card_client.toString());
            Trm_in_clients trm_in_client = trm_in_clientsRepository.findById(trm_in_card_client.getClient()).get();
            System.out.println(trm_in_client.toString());

            StatusChange status = StatusChange.NOTHING;
            if (trm_in_client.getClassifclient().toString().equals(requestclassifclient) || trm_in_client.getSurName().equals(str.getSub_name())){
                status = StatusChange.RENAME_OR_REPLACE;
            }
           tzClientsChangeList.add(new TZClientsChange(
                    trm_in_client.getId(),
                    str.getPhone(),
                    trm_in_client.getClassifclient().toString(),
                    trm_in_client.getSurName(),
                    requestclassifclient,
                    str.getSub_name(),
                    status
                    ));

      }
        for (TZClientsChange cli:
             tzClientsChangeList) {
            System.out.println(cli.toString());
        }
        //System.out.println(classifclient.toString());
        model.addAttribute("tzClientsChangeList",tzClientsChangeList);
         return "greeting";
    }


    @RequestMapping(value = "/greeting", params = "onСlickUploadBtn", method = RequestMethod.POST)
    public String uploadExcel(Model model, @RequestParam("requestclassifclient") String requestclassifclient) {

        updClassifClientList(requestclassifclient);
        System.out.println("---");
        System.out.println(requestclassifclient);
        System.out.println("---");
        viewPagwe(model);
        System.out.println("---");
        //System.out.println(classifclient.toString());
        System.out.println("---");
        return "greeting";
    }



}