package com.dharbor.talent.managervacations.domain;

final class Constants {
    static class UsersTable{
        static final String NAME = "users_table";
        static class Id{
            static final String NAME = "users_id";
        }
        static  class Email{
            static final String NAME = "users_email";
            static final int LENGTH = 100;
        }
        static class Password{

            static final String NAME = "users_password";
            static final int LENGTH = 100;
        }

        static class UserType{

            static final String NAME="users_type";

            static final int LENGTH = 50;
        }
        static class CreateDate{
            static final String NAME="users_create_date";
        }

    }
    static class VacationsTable{
        static final String NAME="vacations_table";

        static class Id{
            static final String NAME="vacations_table";
        }
        static class Type{
            static final String NAME ="vacations_type";
            static final int LENGTH =15;
        }
        static class DayOff{
            static final String NAME="vacations_day_off";
        }
        static class Status{
            static final  String NAME ="vacations_status";
            static final int LENGTH = 9;
        }
        static class User{
            static final String NAME= "vacations_user";
        }
    }
}
