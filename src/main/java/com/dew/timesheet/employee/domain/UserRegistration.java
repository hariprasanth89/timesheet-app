package com.dew.timesheet.employee.domain;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.MDC;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees", schema = "timesheet")
@Data
@NoArgsConstructor
public class UserRegistration {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company_name")
    private String companyName;

    @CreationTimestamp
    @Column(name = "created_ts", updatable = false)
    private LocalDateTime createdTs;

    @UpdateTimestamp
    @Column(name = "updated_ts")
    private LocalDateTime updatedTs;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "email")
    private String email;

    @PrePersist
    protected void prePersist() {
        String requestUser = MDC.get("");

        if (StringUtils.isBlank(requestUser)) {
            setCreatedBy("Hari");
            setUpdatedBy("Hari");
        } else {
            setCreatedBy(requestUser);
            setUpdatedBy(requestUser);
        }

    }

    @PreUpdate
    protected void preUpdate() {
        String requestUser = MDC.get("");
        if (StringUtils.isBlank(requestUser)) {
            setUpdatedBy("Hari");
        } else {
            setUpdatedBy(requestUser);
        }
    }

}
