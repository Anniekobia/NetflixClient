
package com.example.demo.Model;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class User {

    private Long mId;
    private Long mIdentificationNumber;
    private String mName;

    public User(Long mIdentificationNumber, String mName) {
        this.mIdentificationNumber = mIdentificationNumber;
        this.mName = mName;
    }
     private User(){

     }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getIdentificationNumber() {
        return mIdentificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        mIdentificationNumber = identificationNumber;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mIdentificationNumber=" + mIdentificationNumber +
                ", mName='" + mName + '\'' +
                '}';
    }
}
