package com.bigelin.bigelin.OrtakEkranlar.Pojo;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SD
 * on 1.09.2018.
 */

public class Gelinlikci {

    private static final String TAG = "Gelinlikci";

    private int userID;
    private String name;
    private String fname;
    private String email;
    private String pass;
    private String image;
    private String mobil;
    private String adres;
    private String paket;
    private int status;
    private String visitDate;
    private String regDate;
    private String resetCode;
    private String code;
    private String about;
    private String distriction;
    private String city;
    private String website;
    private String oneSignalID;
    private Boolean login;

    public Gelinlikci(JSONObject jsonObject) {
        try {
            this.userID = jsonObject.getInt("userID");
            this.name = jsonObject.getString("name");
            this.fname = jsonObject.getString("fname");
            this.email = jsonObject.getString("email");
            this.pass = jsonObject.getString("pass");
            this.image = jsonObject.getString("image");
            this.mobil = jsonObject.getString("mobil");
            this.adres = jsonObject.getString("adres");
            this.paket = jsonObject.getString("paket");
            this.status = jsonObject.getInt("status");
            this.visitDate = jsonObject.getString("visitDate");
            this.regDate = jsonObject.getString("regDate");
            this.resetCode = jsonObject.getString("resetCode");
            this.code = jsonObject.getString("code");
            this.about = jsonObject.getString("about");
            this.distriction = jsonObject.getString("distriction");
            this.city = jsonObject.getString("city");
            this.website = jsonObject.getString("website");
            this.oneSignalID = jsonObject.getString("oneSignalID");
            this.login = jsonObject.getBoolean("login");
        } catch (JSONException e) {
            Log.wtf(TAG, "json parse catche dustu : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getImage() {
        return image;
    }

    public String getMobil() {
        return mobil;
    }

    public String getAdres() {
        return adres;
    }

    public String getPaket() {
        return paket;
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

    public String getAbout() {
        return about;
    }

    public String getDistriction() {
        return distriction;
    }

    public String getCity() {
        return city;
    }

    public String getWebsite() {
        return website;
    }

    public String getOneSignalID() {
        return oneSignalID;
    }

    public Boolean getLogin() {
        return login;
    }

}
