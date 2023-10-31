package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.Article;
import com.web.gestiondestock.Model.MvtStk;
import com.web.gestiondestock.Model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {


    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto articleDto;

    private TypeMvtStk typeMvtStk;

    public MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk==null){
            return null;
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .articleDto(articleDto.fromEntity(mvtStk.getArticle()))
                .typeMvtStk(mvtStk.getTypeMvtStk())
                .build();
    }
    public MvtStk toEntity(MvtStkDto mvtStkDto){
        if (mvtStkDto==null){
            return null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setArticle(articleDto.toEntity(mvtStkDto.getArticleDto()));
        mvtStk.setTypeMvtStk(mvtStkDto.getTypeMvtStk());
        return mvtStk;

    }
}
