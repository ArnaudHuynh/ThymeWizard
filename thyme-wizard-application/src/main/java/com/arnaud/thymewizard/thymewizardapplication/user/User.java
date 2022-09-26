package com.arnaud.thymewizard.thymewizardapplication.user;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
import io.github.wimdeblauwe.jpearl.AbstractEntityId;
import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tt_user")
public class User extends AbstractVersionedEntity<UserId> {

//    @Id
////    @GeneratedValue(generator = "UUID")
////    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", columnDefinition = "char(26)")
//    @Type(type = "org.hibernate.type.UUIDCharType")
//    private UUID id;
    @NotNull
    private UserName userName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private Email email;
    @NotNull
    private PhoneNumber phoneNumber;

    protected User() {
    }

    public User(UserId id,
                UserName userName,
                Gender gender,
                LocalDate birthday,
                Email email,
                PhoneNumber phoneNumber) {
        super(id);
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserName getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}