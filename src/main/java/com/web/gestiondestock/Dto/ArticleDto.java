package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class ArticleDto {


    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto categoryDto;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtos;

    private List<MvtStkDto> mvtStkDtos;

    public ArticleDto fromEntity(Article article){
        if (article==null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .categoryDto(categoryDto.fromEntity(article.getCategory()))
                .build();
    }
    public Article toEntity(ArticleDto articleDto){
        if (articleDto==null){
            return null;
        }
        Article article= new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(categoryDto.toEntity(articleDto.getCategoryDto()));
        return article;
    }
}
