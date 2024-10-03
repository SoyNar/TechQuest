package com.riwi.techq.domain.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserSkiilId implements Serializable {
    private Long userId;
    private Long skillId;
}
