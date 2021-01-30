package com.cicdlectures.menuserver.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import com.cicdlectures.menuserver.dto.DishDto;

@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Dish {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "dishes")
  @EqualsAndHashCode.Exclude
  private Set<Menu> menus;

  public Dish(){
  }

  public Dish(Long id, String name){
    this.id = id;
    this.name = name;
  }

  public Dish(Long id, String name, Set<Menu> menus) {
    this.id = id;
    this.name = name;
    this.menus = menus;
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

  public Set<Menu> getMenus() {
    return menus;
  }

  public void setMenus(Set<Menu> menus) {
    this.menus = menus;
  }

  public static Set<Dish> fromDtoSet(Set<DishDto> dtos) {
    Set dishes = new HashSet<>();

    for (DishDto dto : dtos) {
      dishes.add(Dish.fromDto(dto));
    }

    return dishes;
  }

  public static Dish fromDto(DishDto dto) {
    return new Dish(dto.getId(),dto.getName());
  }
}
