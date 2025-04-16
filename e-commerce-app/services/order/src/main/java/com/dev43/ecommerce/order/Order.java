package com.dev43.ecommerce.order;

import com.dev43.ecommerce.orderline.OrderLine;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)      //
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    private String reference;
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String customerId;      // String, customerId uses NoSql db

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @CreatedDate    //
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate   //
//    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;
}
