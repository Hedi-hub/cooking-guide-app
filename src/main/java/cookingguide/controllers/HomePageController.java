package cookingguide.controllers;

import cookingguide.models.Recipe;
import cookingguide.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value={"/", "/index", "/home"})
    public String showHomePage(Model model){
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        List<Recipe> topThreeRecipes = new ArrayList<>();
        topThreeRecipes.add(allRecipes.get(0));
        topThreeRecipes.add(allRecipes.get(1));
        topThreeRecipes.add(allRecipes.get(2));
        model.addAttribute("recipes",topThreeRecipes );

        return "index";
    }

    @RequestMapping("/showNewRecipeForm")
    public String showNewRecipePage(){

        return"add-new-recipe";
    }
}
