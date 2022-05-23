package noora.demo.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import noora.demo.Entity.Editor;
import noora.demo.Entity.Maker;
import noora.demo.Entity.Product;
import noora.demo.Entity.Departement;
import noora.demo.Entity.ProductDTO;
import noora.demo.Service.DepartementService;
import noora.demo.Service.EditorService;
import noora.demo.Service.MakerService;
import noora.demo.Service.ProductService;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    @Autowired
    ProductService productService;
    @Autowired
    EditorService editorService;
    @Autowired
    MakerService makerService;
    @Autowired
    DepartementService departementService;
    
    @GetMapping("/adminHome")
    public String adminHome() {
        return "adminHome";
    }
    /* Departement */
  
	@GetMapping("/admin/departement")
	public String getDepartement(Model model) {
		model.addAttribute("departement", departementService.listAllDepartement());
		return "departement";
	}

	@GetMapping("/admin/departement/add")
	public String getDepAdd(Model model) {
		model.addAttribute("departement", new Departement());
		return "addDepartement";
	}

	@PostMapping("/admin/departement/add")
	public String postDepaAdd(@ModelAttribute("departement") Departement departement) {
		departementService.addDepartement(departement);;
		return "redirect:/admin/departement";
	}

	@GetMapping("/admin/departement/delete/{id}")
	public String deleteDep(@PathVariable Long id) {
		departementService.removeDepartemet(id);
		return "redirect:/admin/departement";
	}

	@GetMapping("/admin/departement/update/{id}")
	public String updateDep(@PathVariable Long id, Model model) {
		Optional<Departement> departement = departementService.getDepartementById(id);
		if (departement.isPresent()) {
			model.addAttribute("departement", departement.get());
			return "addDepartement";
		}
		return "404";

	}


    /* Prduct*/
    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        model.addAttribute("product", productService.listAllProduct());
        return "product";
    }
    @GetMapping("/admin/product/add")
    public String getProductAdd(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("departement", departementService.listAllDepartement());
        return "addProduct";
    }

    @PostMapping("/admin/product/add")
    public String postProductAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
    @RequestParam("productImage") MultipartFile file,
    @RequestParam("image") String image) throws IOException {
       
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setDepartement(departementService.getDepartementById(productDTO.getDepartementId()).get());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir,  imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = image;
        }
        product.setImage(imageUUID);
        productService.addProduct(product);

        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.removeProductById(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDepartementId(product.getDepartement().getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(product.getImage());

        model.addAttribute("departement", departementService.listAllDepartement());
        model.addAttribute("productDTO", productDTO);
        return "addProduct";
    }

    /* EDitor */

    @GetMapping("/admin/editor")
    public String getEditor(Model model) {
        model.addAttribute("editor",editorService.listAllEditor());
        return "editor";
    }
    @GetMapping("/admin/editor/add")
    public String getEditorAdd(Model model) {
        model.addAttribute("editor", new Editor());
        return "addEditor";
    }
    @PostMapping("/admin/editor/add")
    public String postEditorAdd(@ModelAttribute("editor") Editor editor) {
        editorService.addEditor(editor);
        return "redirect:/admin/editor";

    }

    @GetMapping("/admin/editor/delete/{id}")
    public String deleteEditor(@PathVariable Long id) {
        editorService.removeEditorById(id);
        return "redirect:/admin/editor";
    }
    @GetMapping("/admin/editor/update/{id}")
    public String updateEditor(@PathVariable Long id, Model model) {
        Optional<Editor> editor = editorService.getEditorById(id);
        if (editor.isPresent()) {
            model.addAttribute("editor", editor.get());
            return "addEditor";
        } else 
        return "404";
        }
        
    
    /* Maker */


    @GetMapping("/admin/maker")
    public String getMaker(Model model) {
        model.addAttribute("maker",makerService.listAllMaker());
        return "maker";
    }
    @GetMapping("/admin/maker/add")
    public String getMakerAdd(Model model) {
        model.addAttribute("maker", new Maker());
        return "addMaker";
    }
    @PostMapping("/admin/maker/add")
    public String postMakerAdd(@ModelAttribute("maker") Maker maker) {
        makerService.addMaker(maker);
        return "redirect:/admin/maker";
    }
    @GetMapping("/admin/maker/delete/{id}")
    public String deleteMaker(@PathVariable Long id) {
        makerService.removeMakerById(id);
        return "redirect:/admin/maker";
    }
    @GetMapping("/admin/maker/update/{id}")
    public String updateMaker(@PathVariable Long id, Model model) {
        Optional<Maker> maker = makerService.getMakerById(id);
        if (maker.isPresent()) {
            model.addAttribute("maker", maker.get());
            return "addMaker";
        } else 
        return "404";
        }
    
}
