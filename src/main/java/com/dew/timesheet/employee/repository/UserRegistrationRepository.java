package com.dew.timesheet.employee.repository;

import com.dew.timesheet.employee.domain.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository  extends JpaRepository<UserRegistration, Long> {
}
