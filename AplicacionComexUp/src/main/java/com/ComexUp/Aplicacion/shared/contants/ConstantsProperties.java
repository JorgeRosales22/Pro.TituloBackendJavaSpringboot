package com.ComexUp.Aplicacion.shared.contants;

public final class ConstantsProperties {
    //Propiedad universal
    public static final String GLOBAL_PATH = "/all";
    public static final String DELETE_ID = "/delete/{id}";
    public static final String GET_BY_ID_PATH = "/{id}";
    //Propiedades de usuario
    public static final String LOGIN_PATH = "/login_user";
    public static final String REGISTER_PATH = "/register_user";
    public static final String DELETE_USER = "/delete/";

    //Propiedades de boleto

    public static final String GET_USER_TICKET_PATH = "/ticket";
    public static final String SAVE_TICKET_PATH = "/editar";
    public static final String SEND_TICKET_PATH = "/send-message";

    //Propiedades de comprobante
    public static final String GET_VOUCHER_BY_ID_PATH ="/voucher/{id}";

}
