package com.taahaagul.easySecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "customer_id")
    private long id;
    private String name;
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;
    private String role;
    @Column(name = "create_dt")
    private String createDt;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Authority> authorities;
}
