package org.talent.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.todolist.domain.HttpResponse;
import org.talent.todolist.dto.NewCategoryRequest;
import org.talent.todolist.entity.Category;
import org.talent.todolist.service.CategoryService;

import java.util.List;

import static org.talent.todolist.domain.HttpResponse.createResponse;

@RestController  // By using this, every methods will returns a domain object instead of a view. shorthand for @Controller and @ResponseBody
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<HttpResponse<Category>> saveNewCategory(@RequestBody NewCategoryRequest request) {  // @RequestBody annotation is used to bind the parameter with the body of the HTTP request
        Category category = categoryService.saveNewCategory(request);
        return createResponse(category, HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<HttpResponse<List<Category>>> getAllCategory(){
        List<Category> categoryList = categoryService.findAll();
        return createResponse(categoryList, HttpStatus.OK);
    }
}
