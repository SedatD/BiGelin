package com.bigelin.bigelin.OrtakEkranlar.Pojo;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SD
 * on 1.09.2018.
 */

public class Gelin {

    private static final String TAG = "Gelin";

    private String name;
    private String email;
    private String pass;
    private int status;
    private String visitDate;
    private String regDate;
    private String resetCode;
    private String code;
    private String city;
    private String oneSignalID;
    private Boolean login;
    private int gelinID;
    private String phone;
    private String district;

    public Gelin(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString("name");
            this.email = jsonObject.getString("email");
            this.pass = jsonObject.getString("pass");
            this.status = jsonObject.getInt("status");
            this.visitDate = jsonObject.getString("visitDate");
            this.regDate = jsonObject.getString("regDate");
            this.resetCode = jsonObject.getString("resetCode");
            this.code = jsonObject.getString("code");
            this.city = jsonObject.getString("city");
            this.oneSignalID = jsonObject.getString("oneSignalID");
            this.login = jsonObject.getBoolean("login");
            this.gelinID = jsonObject.getInt("gelinID");
            this.phone = jsonObject.getString("phone");
            this.district = jsonObject.getString("district");
        } catch (JSONException e) {
            Log.wtf(TAG, "json parse catche dustu : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public int getStatus() {
        return status;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getResetCode() {
        return resetCode;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getOneSignalID() {
        return oneSignalID;
    }

    public Boolean getLogin() {
        return login;
    }

    public int getGelinID() {
        return gelinID;
    }

    public String getPhone() {
        return phone;
    }

    public String getDistrict() {
        return district;
    }

}
