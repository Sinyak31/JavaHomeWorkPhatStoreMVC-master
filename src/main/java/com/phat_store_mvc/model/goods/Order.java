package com.phat_store_mvc.model.goods;

import com.phat_store_mvc.model.order_attributes.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private OrderStatus status;

    @CreatedDate
    @Column(name="ordered")
    private LocalDate ordered;

    @Column(name="is_paid")
    private Boolean isPaid;

    @OneToMany(mappedBy="order")
    private Set<OrderItem> positions = new HashSet<>();

    public Integer totalPrice() {
//       return positions.stream().reduce(0, (acc, oi) -> oi.getAmount() * oi.getItem().getPrice(), Integer::sum);
        return positions.stream().map(p -> p.getItem().getPrice() * p.getAmount()).reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", ordered=" + ordered +
                ", isPaid=" + isPaid +
                ", positions=" + positions.stream()
                                            .map(OrderItem::getId).toList() +
                '}';
    }
}
