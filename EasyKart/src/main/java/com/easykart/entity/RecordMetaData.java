package com.easykart.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * The Class RecordMetaData.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class RecordMetaData {
    
    /** The created at. */
    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
    
    /** The created by. */
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    
    /** The updated at. */
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    /** The updated by. */
    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;
    
}
