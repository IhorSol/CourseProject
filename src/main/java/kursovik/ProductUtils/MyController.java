package kursovik.ProductUtils;

import kursovik.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Ihor Solohub.
 */
@Controller
@RequestMapping("/")
public class MyController {
    @Autowired
    private ProductService productService;


    @RequestMapping("/")   // виведення інфи на головну(початкову сторінку)
    public  String index (Model model){
        model.addAttribute("baitTypes", BaitType.values());
        model.addAttribute("coilTypes", CoilType.values());
        model.addAttribute("rodTypes", RodType.values());
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST) // SEARCH PRODUCTS BY NAME!!!
    public String search(@RequestParam String pattern, Model model) {
        if (productService.showSearchedBaits(pattern) != null) {
            model.addAttribute("searchedProducts", productService.showSearchedBaits(pattern));
        } else if (productService.showSearchedCoils(pattern) != null){
            model.addAttribute("searchedProducts", productService.showSearchedCoils(pattern));
        } else if (productService.showSearchedRods(pattern) != null){
            model.addAttribute("searchedProducts", productService.showSearchedRods(pattern));
        } else model.addAttribute("searchedProducts", "No product with this name!");

        return "search_results";
    }

             /*------- Controller for Baits -------*/

    @RequestMapping("/bait_types") // при переході виводиться сторінка з типами наживки
    public String baitTypes(Model model){
        model.addAttribute("baitTypes", BaitType.values());
        return "bait_types"; // сторінка з типами наживки
    }

    @RequestMapping(value = "/all_baits/bait_add_page", method = RequestMethod.POST) // додавання наживки, тільки для адміністратора
    public String baitAdd (@RequestParam String name,
                           @RequestParam int price,
                           @RequestParam BaitType baitType,
                           @RequestParam String color,
                           @RequestParam int weight,
                           @RequestParam MultipartFile photo, Model model) // add photo
    {
        try {
            Bait bait = new Bait(name, price, baitType, color,weight,
                    photo.isEmpty() ? null : new Photo(photo.getBytes()));
            productService.addBait(bait);
        } catch (IOException e) {
            e.printStackTrace(); // УТОЧНИТЬ ШО ТУТ МОЖНА ЗРОБИТЬ
            return null;
        }

        model.addAttribute("baits", productService.viewAllBaits());
        return "all_baits"; // сторінка для перевірки чи додано товар в категорію нажика
    }

    @RequestMapping(value = "/all_baits/delete_bait", method = RequestMethod.POST) // deleting bait
    public ResponseEntity<Void> deleteBait(@RequestParam(value = "toDelete[]", required = false)long[] toDelete, Model model){
        if (toDelete != null)
            productService.deleteBait(toDelete);

            model.addAttribute("baits", productService.viewAllBaits());
            return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/all_baits")
    public String showAllBaits(Model model){
        model.addAttribute("allBaits", productService.viewAllBaits());
        return "all_baits";
    }

    @RequestMapping("/all_baits/from_min_to_max_price") // показ усіх наживок від мін до макс ціни
    public String showBaitsFromMinToMaxPrice(Model model){
        model.addAttribute("baitsFromMinToMaxPrice", productService.showBaitsFromMinToMaxPrice());
        return "all_baits";
    }

    @RequestMapping("/all_baits/from_max_to_min_price")
    public String showBaitsFromMaxToMinPrice(Model model){
        model.addAttribute("baitsFromMaxToMinPrice", productService.showBaitsFromMaxToMinPrice());
        return "all_baits";
    }

    @RequestMapping(value = "/bait_types")
    public String showBaitTypes (Model model){
        model.addAttribute("baitTypes", BaitType.values());
        return "bait_types";
    }

    @RequestMapping("/bait_types/wobbler") // БЛІН!!!! РЕКВЕСТ ПАРАМ БЕЙТТАЙП ТРЕБА ВИДИРАТЬ!!!! ПЕРЕРОБИТЬ!!!
    public String showBaitsOfSelectedType(BaitType baitType, Model model){ // ХЗ ЧИ МОЖНА КИДАТЬ СЮДИ ОБ'ЄКТ ЧИ КРАЩЕ СТРІНГУ?
        model.addAttribute("baitsOfSelectedType", productService.showBaitsByType(baitType));
        return "wobblers";
    }

                /*------- Controller for Coils -------*/

    @RequestMapping("/coil_types") //при переході виводиться сторінка з типами котушок
    public String coilTypes(Model model){
        model.addAttribute("coilTypes", CoilType.values());
        return "coil_types"; // сторінка з типами котушок
    }

    @RequestMapping(value = "/all_coils/coil_add_page", method = RequestMethod.POST)// додавання котушок
    public String coilAdd(@RequestParam CoilType coilType,
                          @RequestParam String name,
                          @RequestParam int price,
                          @RequestParam int numberOfBearings,
                          @RequestParam String isSecondSpoolHas,
                          @RequestParam MultipartFile photo,Model model)
    {
        try {
            Coil coil = new Coil(name, price, coilType, numberOfBearings, isSecondSpoolHas,
                    photo.isEmpty() ? null : new Photo(photo.getBytes()));
            productService.addCoil(coil);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        model.addAttribute("coils", productService.viewAllCoils());
        return "all_coils"; // page for checking adding coils
    }

    @RequestMapping(value = "/all_coil/delete_coil", method = RequestMethod.POST) // deleting bait
    public ResponseEntity<Void> deleteCoil(@RequestParam(value = "toDelete[]", required = false)long[] toDelete, Model model){
        if (toDelete != null)
            productService.deleteCoil(toDelete);

        model.addAttribute("coils", productService.viewAllCoils()); // тут поки хз що відображать і куди переходить
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/all_coils")
    public String showAllCoils(Model model){
        model.addAttribute("allCoils", productService.viewAllCoils());
        return "all_coils";
    }

    @RequestMapping("/all_coils/from_min_to_max_price") // показ усіх наживок від мін до макс ціни
    public String showCoilsFromMinToMaxPrice(Model model){
        model.addAttribute("coilsFromMinToMaxPrice", productService.showCoilsFromMinToMaxPrice());
        return "all_coils";
    }

    @RequestMapping("/all_coils/from_max_to_min_price")
    public String showCoilsFromMaxToMinPrice(Model model){
        model.addAttribute("coilsFromMaxToMinPrice", productService.showCoilsFromMaxToMinPrice());
        return "all_coils";
    }



                /*------- Controller for Rods -------*/

    @RequestMapping("/rod_types") // виводить сторінку з типами вудок
    public String rodTypes (Model model){
        model.addAttribute("rodTypes", RodType.values());
        return "rod_types"; // page with rod types
    }

    @RequestMapping (value = "/all_rods/rod_add_page", method = RequestMethod.POST) // for adding rod
    public String rodAdd (@RequestParam String name,
                          @RequestParam int price,
                          @RequestParam RodType rodType,
                          @RequestParam int castingMin,
                          @RequestParam int castingMax,
                          @RequestParam MultipartFile photo, Model model)
    {
        try {
            Rod rod = new Rod(name, price, rodType, castingMin, castingMax,
                    photo.isEmpty() ? null : new Photo(photo.getBytes()));
            productService.addRod(rod);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        model.addAttribute("rods", productService.viewAllRods());
        return "all_rods"; // page for checking adding rods
    }

    @RequestMapping(value = "/all_rods/delete_rod", method = RequestMethod.POST) // deleting bait
    public ResponseEntity<Void> deleteRod(@RequestParam(value = "toDelete[]", required = false)long[] toDelete, Model model){
        if (toDelete != null)
            productService.deleteBait(toDelete);

        model.addAttribute("rods", productService.viewAllRods());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/all_rods")
    public String showAllRods(Model model){
        model.addAttribute("allRods", productService.viewAllRods());
        return "all_rods";
    }

    @RequestMapping("/all_rods/from_min_to_max_price") // показ усіх наживок від мін до макс ціни
    public String showRodsFromMinToMaxPrice(Model model){
        model.addAttribute("rodsFromMinToMaxPrice", productService.showRodsFromMinToMaxPrice());
        return "all_rods";
    }

    @RequestMapping("/all_rods/from_max_to_min_price")
    public String showRodsFromMaxToMinPrice(Model model){
        model.addAttribute("rodsFromMaxToMinPrice", productService.showRodsFromMaxToMinPrice());
        return "all_rods";
    }
}
