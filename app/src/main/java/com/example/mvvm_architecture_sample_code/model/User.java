package com.example.mvvm_architecture_sample_code.model;

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

    public User(int id, String name, String username, String email, String phone, String website, User.address address, User.company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }

    public User.address getAddress() {
        return address;
    }

    public User.company getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }


    public class  address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private geo geo;

        public address(String street, String suite, String city, String zipcode, User.address.geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public User.address.geo getGeo() {
            return geo;
        }

        public class geo{
            private String lat;
            private String lng;

            public geo(String lat, String lng) {
                this.lat = lat;
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }
        }


    }
    public class company{
        private String name;
        private String catchPhrase;
        private String bs;

        public company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }
    }





}
