package com.phat_store_mvc.model.goods;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "brand", cascade=CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public Brand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", items=" + items
//                .stream()
//                .map(Item::getId)
//                .collect(Collectors.toSet()) +
                '}';
    }
}
