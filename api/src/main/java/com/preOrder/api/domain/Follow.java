package com.preOrder.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import lombok.*;
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "memberId")
    long memberId;
    @Column(name = "followingUser")
    long followingUser;
}
