package com.phat_store_mvc.model.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phat_store_mvc.model.item_attributes.Color;
import com.phat_store_mvc.model.item_attributes.Sex;
import com.phat_store_mvc.model.item_attributes.Size;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name="size")
    private String size;

    @Column(name="sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name="price")
    private Integer price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

//    public Item(String madel, Brand brand, Category category) {
//        this.model = madel;
//        this.brand = brand;
//        this.category = category;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", amount=" + amount +
                ", size=" + size +
                ", price=" + price +
                ", brand=" + brand.getName() +
                ", category=" + category.getName() +
                '}';
    }
}
