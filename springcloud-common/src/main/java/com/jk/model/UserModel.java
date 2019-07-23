package com.jk.model;




import java.io.Serializable;

public class UserModel implements Serializable {
    private static final long serialVersionUID = -8408283779267781401L;
   /* private  Integer   userid;
    private  String    username;
    private   String    userpwd;

*/

    private String userid;//id

    private String usercode;//用户昵称  登录账号

   // private String username;//用户姓名

    private String password;//密码

    private String salt;

    private   String    userphone;

    //private String locked;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
}
