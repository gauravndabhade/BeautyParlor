package com.gaurav.beautyparlor;

import java.io.Serializable;

public class Customer implements Serializable {
    private String mName;
    private String timeslot;
    private String mStatus;

    public Customer() {
        mName = "";
        timeslot = "";
        mStatus = "";
    }

    public Customer(String mName, String time_slot, String status) {
        this.mName = mName;
        this.timeslot = time_slot;
        this.mStatus = status;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String slot) {
        timeslot = slot;
    }
}
