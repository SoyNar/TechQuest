//package com.riwi.techq.domain.Model;
//
//import jakarta.persistence.*;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.LastModifiedBy;
//@Entity
//public class UserSkills {
//
//    @EmbeddedId
//    private UserSkiilId id = new UserSkiilId();
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//
//    @ManyToOne
//    @JoinColumn(name = "skill_id")
//    private Skills skill;
//
//    @CreatedBy
//    private String createdBy;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
//}
