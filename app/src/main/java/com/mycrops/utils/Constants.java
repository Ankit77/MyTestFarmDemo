package com.mycrops.utils;


public class Constants {
    public static final String BASE_URL = "http://mycrop.hnyb.in/api";
//    validation
    public static final int OTP_LENGTH = 6;
    public static final int FORGOT_PASSWORD_OTP_REQUEST = 2;
    public static final int REGISTRATION_OTP_REQUEST = 1;
    //Api method name
    public static final String MODULE = "user";
    public static final String MODULE_LAND = "land";
    public static final String MODULE_FM = "fm";
    public static final String MODULE_FARMER = "farmer";
    public static final String MODULE_FARMER_FAMILY = "farmerfamily";
    public static final String CHECK_USER = "registereduser";
    public static final String LOGIN = "login";
    public static final String OTP_REQUEST = "otprequest";
    public static final String OTP_VERIFICATION = "otpverification";
    public static final String RESET_PASSWORD = "registration";
    public static final String USER_REGISTRATION = "registration";
    public static final String FARM_MITRA_MYDETAIL_REGISTRATION = "savefmprofile";
    public static final String FARM_MITRA_MYDETAIL_UPDATE = "updatefmprofile";
    public static final String FARM_MITRA_BANK_DETAIL_REGISTRATION = "bankdetails";
    public static final String FARMER_LIST = "farmerlist";
    public static final String SAVE_FARMER_PROFILE = "savefarmerprofile";
    public static final String SAVE_FARMER_FAMILY_DETAIL_SPOUSE = "spousedetails";
    public static final String SAVE_FARMER_FAMILY_DETAIL_KIDS = "kidsdetails";
    public static final String SAVE_FARMER_FAMILY_DETAIL_DEPENDENT = "dependentdetails";
    public static final String LANDLOCATION_LIST = "getlandlocations";

    public static final String GET_USERNAME = "get-username";
    public static final String SELECT_FARMER_PROFILE = "getfarmerprofile";
    public static final String UPDATE_FARMER_PROFILE = "updatefarmerprofile";

    public static final String GET_LANDS = "get";
    public static final String SAVE_LANDS = "save";
    public static final String DELETE_LANDS = "remove";

    public static final String MODULE_CROP = "cropinfo";
    public static final String GET_CROP = "get";
    public static final String SAVE_CROP = "save";
    public static final String DELETE_CROP = "remove";
}
