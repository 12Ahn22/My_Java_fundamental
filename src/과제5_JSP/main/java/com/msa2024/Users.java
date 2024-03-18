package com.msa2024;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Users {
   private String userid;
   private String username;
   private String userpassword;
   private int    userage;
   private String useremail;
}