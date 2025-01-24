package org.example.carebridge.domain.payment.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.example.carebridge.domain.clinic.entity.Clinic;
import org.example.carebridge.global.entity.BaseEntity;

@Entity
@Table(name = "payment")
@Getter
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column
    private String orderId;

    @Column
    private String tid;

    @Column(nullable = false)
    private String paymentInfo;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    public Payment() {}

    @Builder
    public Payment(PaymentMethod paymentMethod, String orderId, String tid, String paymentInfo, Integer price, Clinic clinic) {
        this.paymentMethod = paymentMethod;
        this.orderId = orderId;
        this.tid = tid;
        this.paymentInfo = paymentInfo;
        this.price = price;
        this.clinic = clinic;
    }
}
