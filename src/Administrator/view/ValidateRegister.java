/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.project.view;

import com.fpt.project.entity.Account;
import com.fpt.project.entity.AdminInfor;
import com.fpt.project.validate.Validate;
import java.util.HashMap;

/**
 *
 * @author Nam Nguyen
 */
public class ValidateRegister {

    public HashMap<String, String> ValidateRegisterAcc(Account account, AdminInfor adminInfor) {
        HashMap<String, String> errorsRegister = new HashMap<>();
        if (account.getAccount().length() < 6) {
            errorsRegister.put("txtAccount", "*Tài khoản phải lớn hơn 6 kí tự! ");
        }
        if (account.getPassword().length() < 6) {
            errorsRegister.put("txtPassword", "*Mật khẩu phải lớn hơn 6 kí tự!");
        }
        if (adminInfor.getFullName().isEmpty()) {
            errorsRegister.put("txtFullName", "*Vui lòng nhập họ và tên! ");
        }
        if (adminInfor.getEmail().isEmpty()) {
            errorsRegister.put("txtEmail", "*Vui lòng nhập email!");
        } else if (Validate.valiEmail(adminInfor.getEmail()) == false) {
            errorsRegister.put("txtEmail", "*Nhập đúng định dạng email: abc@xyz.com");
        }
        if (adminInfor.getPhoneNumber()== null) {
            errorsRegister.put("txtPhoneNumber", "*Vui lòng nhập số điện thoại!");
        } else if (Validate.valiPhoneNumber(adminInfor.getPhoneNumber()) == false) {
            errorsRegister.put("txtPhoneNumber", "*Nhập đúng định dạng số điện thoại: +841.. or +8491.. ");
        }
        if (adminInfor.getBirthday().isEmpty()) {
            errorsRegister.put("txtBirthday", "*Vui lòng nhập ngày sinh!");
        } else if (Validate.valiBirthday(adminInfor.getBirthday()) == false) {
            errorsRegister.put("txtBirthday", "*Nhập đúng định dạng ngày tháng: 13/12/1995 ");
        }
        if (adminInfor.getAddress().isEmpty()) {
            errorsRegister.put("txtAddress", "*Vui lòng nhập địa chỉ!");
        }
        return errorsRegister;
    }
}
