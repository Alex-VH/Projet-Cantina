package com.cicdlectures.menuserver.dto;

import java.util.Set;
import java.util.HashSet;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

import com.cicdlectures.menuserver.model.Dish;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class DishDto {

  private Long id;

  private String name;

  public DishDto() {
  }

  public DishDto(Long id, String name) {
    this.setId(id);
    this.setName(name);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Set<DishDto> fromModelSet(Set<Dish> models) {
    Set<DishDto> dishes = new HashSet<>();

    for (Dish model : models) {
      dishes.add(DishDto.fromModel(model));
    }

    return dishes;
  }

  public static DishDto fromModel(Dish dish) {
    return new DishDto().setId(dish.getId()).setName(dish.getName());
  }
}
