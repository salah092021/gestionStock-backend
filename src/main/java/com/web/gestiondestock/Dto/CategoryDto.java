package com.web.gestiondestock.Dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.gestiondestock.Model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {


    private Integer id;

    private String code;

    private String designation;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ArticleDto> articleDtos;

    public CategoryDto fromEntity(Category category){
        if (category==null){
            // TODO throw on exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public Category toEntity(CategoryDto categoryDto){
        if (categoryDto==null){
            // TODO throw on exception
        }
        Category category= new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;
    }
}
