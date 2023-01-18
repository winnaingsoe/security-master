package com.pneumo.securitymaster.security.annotation.departments;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.pneumo.securitymaster.security.SecurityRoles.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Secured(ROLES_PREFIX + DEPARTMENTS_CREATE)
public @interface DepartmentsCreate {
}
