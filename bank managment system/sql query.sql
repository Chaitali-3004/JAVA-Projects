create database bankmanagementsystem;

show databases;
use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20),email varchar(30),marital varchar(20),address varchar(40),city varchar(25),state varchar(25),pincode varchar(20));
show tables;
select * from signup;

create table signuptwo(formno varchar(20), riligon varchar(20), category varchar(20), income varchar(20), education varchar(20),occupation varchar(30),pan varchar(20),adhaar varchar(20),seniorcitizen varchar(20),existaccount varchar(20));
select * from signuptwo;

create table signupthree(formno varchar(20), accountType varchar(20), cardnumber varchar(20), pinnumber varchar(20), facility varchar(100));
select * from signupthree;

create table login(formno varchar(20),cardnumber varchar(20), pinnumber varchar(20));
select * from login;

create table bank(pin varchar(20),date varchar(50), type varchar(20), amount varchar(20));
select * from bank;



