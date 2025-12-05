package com.nfsystems.techsyncar_api.common.models.entity;

import com.nfsystems.techsyncar_api.common.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tscar_st")
    private Status status = Status.ACTIVE;

    @CreatedDate
    @Column(name = "tscar_cre_at",nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "tscar_up_at",insertable = false)
    private LocalDateTime lastModifiedDate;

    public void updateSt(){
        if(this.status == Status.ACTIVE){
            this.status = Status.INACTIVE;
        } else {
            this.status = Status.ACTIVE;
        }
    }
}
