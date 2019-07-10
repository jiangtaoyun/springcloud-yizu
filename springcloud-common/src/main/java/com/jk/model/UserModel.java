package com.jk.model;


import lombok.Data;

import java.io.Serializable;
@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID = -8408283779267781401L;
    private  Integer   userid;
    private  String    username;
    private   String    userpwd;
    private   String    userphone;

}
