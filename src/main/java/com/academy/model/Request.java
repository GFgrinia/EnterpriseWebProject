package com.academy.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "rent_duration")
    private Integer rentDuration;
    @Column(name = "last_change_date")
    private Timestamp lastChangeDate = Timestamp.valueOf(LocalDateTime.now());
    @ManyToOne()
    @JoinColumn(name = "request_status_id")
    private RequestStatus requestStatus;
    @Column
    private String comment;
}

