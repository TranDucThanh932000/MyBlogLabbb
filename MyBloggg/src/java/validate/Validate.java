/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.regex.Pattern;

/**
 *
 * @author asus
 */
public class Validate {
    public boolean checkPhone(String phone){
        String regex="^[0-9]{10,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phone).matches();
    }
    public boolean checkEmail(String email){
        String regex="^[A-Za-z0-9.+-_%]+@[A-Za-z]+\\.[A-Za-z]{2,4}(\\.[a-z]{2,4})?$";
        if(email.matches(regex)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Validate v= new Validate();
        System.out.println(v.checkEmail("asdasd@gmail.@vv"));
    }
}
