package com.cicdlectures.menuserver.model;

import java.util.Set;

import com.cicdlectures.menuserver.dto.MenuDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @EqualsAndHashCode.Exclude
  private Set<Dish> dishes;

  public Menu(Long id, String name){
    this.id = id;
    this.name = name;
  }

  public Menu(Long id, String name, Set<Dish> dishes) {
    this.id = id;
    this.name = name;
    this.dishes = dishes;
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

  public Set<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<Dish> dishes) {
    this.dishes = dishes;
  }

  public static Menu fromDto(MenuDto menuDto) {
    return new Menu(menuDto.getId(), menuDto.getName(), Dish.fromDtoSet(menuDto.getDishes()));
  }
}
