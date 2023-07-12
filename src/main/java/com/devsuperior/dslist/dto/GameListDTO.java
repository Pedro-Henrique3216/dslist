package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
