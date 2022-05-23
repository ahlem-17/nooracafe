package noora.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import noora.demo.Service.DepartementService;
import noora.demo.Service.EditorService;
import noora.demo.Service.MakerService;
import noora.demo.Service.ProductService;
import noora.demo.global.GlobalData;

@Controller
public class HomeController {
    
    @Autowired DepartementService departementService;
    @Autowired ProductService productService;
    @Autowired EditorService editorService;
    @Autowired MakerService makerService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "home";
    }

    @GetMapping("/shopping/departement/{id}")
    public String shopByDepartement(Model model, @PathVariable Long id) {
        model.addAttribute("maker", makerService.listAllMaker());
        model.addAttribute("editor", editorService.listAllEditor());
        model.addAttribute("departement", departementService.listAllDepartement());
        model.addAttribute("product", productService.getAllProductByDepartementId(id));
      
        return "shopping";
    }

    @GetMapping("/shopping/detailProduct/{id}")
    public String DetailProduct(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "detailProduct";
    }

   

}
