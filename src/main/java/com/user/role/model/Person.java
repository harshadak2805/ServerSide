package com.user.role.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="person")
public class Person implements Serializable {

    public Person(){
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personid")
    private Integer personid;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="gender")
    private String gender;

    @Column(name="birth_date")
    private Date dateofBirth;

    @Column(name="age")
    private int age;

    @Column(name="address")
    private String address;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    @Column(name="pin_code")
    private String pinCode;

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="mobile_no")
    private String mobileNo;

    @Column(name="maritial_status")
    private String maritalStatus;

    @Column(name="education_status")
    private String educationStatus;

    @Column(name="disability")
    private String disability;

    @Column(name="birth_sign")
    private String birthSign;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User personUser;

    public Integer getPersonid() {
        return personid;
    }

    public User getPersonUser() {
        return personUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonUser(User personUser) {
        this.personUser = personUser;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getBirthSign() {
        return birthSign;
    }

    public void setBirthSign(String birthSign) {
        this.birthSign = birthSign;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }
}
