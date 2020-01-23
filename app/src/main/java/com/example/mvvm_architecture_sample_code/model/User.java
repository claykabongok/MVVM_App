package com.example.mvvm_architecture_sample_code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {

    //user POJO
    private int id;
    private String name;
    private String username;
    private String email;

    private String phone;
    private String website;
    private address address;
    private company company;
    @AllArgsConstructor
    @Getter
    @Setter
    public class  address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private geo geo;


        @AllArgsConstructor
        @Getter
        @Setter
        public class geo{
            private String lat;
            private String lng;

        }


    }
    @AllArgsConstructor
    @Getter
    @Setter
    public class company{
        private String name;
        private String catchPhrase;
        private String bs;
    }





}
