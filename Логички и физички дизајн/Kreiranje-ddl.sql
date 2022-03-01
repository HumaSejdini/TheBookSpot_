--BRISENJE TABELI
drop table if exists chovek cascade;
drop table if exists authentication cascade;
drop table if exists chlen cascade;
drop table if exists bibliotekar cascade;
drop table if exists avtor cascade;
drop table if exists kategorija cascade;
drop table if exists izdavac cascade;
drop table if exists dobavuvac cascade;
drop table if exists knigi cascade;
drop table if exists izdava cascade;
drop table if exists e_od cascade;
drop table if exists ocena cascade;
drop table if exists instanca_od_kniga cascade;
drop table if exists pozajmica cascade;
drop table if exists kazna cascade;


--DODAVANJE TABELI
-----------------------------------------

create table chovek(
id_chovek serial primary key,
ime varchar(50) not null,
prezime varchar(50) not null,
email varchar(50) not null,
tel_broj varchar(25) not null,
adresa varchar(150) not null,
embg char(13) not null,
username varchar(50) not null,
password varchar(100) not null
);

-----------------------------------------

create table authentication(
log_id serial primary key,
timestamp_log timestamp not null,
id_chovek integer not null,
constraint fk_id_chovek foreign key (id_chovek) references chovek (id_chovek)
);

-----------------------------------------

create table chlen(
id_chovek serial primary key,
broj integer not null,
datum_na_zachlenuvanje timestamp not null,
constraint fk_id_chovek foreign key (id_chovek) references chovek (id_chovek)
);

-----------------------------------------

create table bibliotekar(
id_chovek serial primary key,
id_na_bibliotekar integer not null,
constraint fk_id_chovek foreign key (id_chovek) references chovek (id_chovek)
);

-----------------------------------------

create table avtor(
id_na_avtor serial primary key,
ime varchar(100) not null
);

-----------------------------------------

create table kategorija(
id_na_kategorija serial primary key,
ime_kategorija varchar(30) not null
);

-----------------------------------------

create table izdavac(
id_na_izdavac serial primary key,
email varchar(50) not null,
lokacija varchar(200) not null,
ime_na_izdavac varchar(100) not null
);

-----------------------------------------

create table dobavuvac(
id_na_dobavuvac serial primary key,
ime_na_dobavuvac varchar(100) not null
);

-----------------------------------------

create table knigi(
id_na_kniga serial primary key,
opis varchar(5500) not null,
naslov varchar (100) not null,
id_izdavac integer not null,
constraint fk_id_izdavac foreign key (id_izdavac) references izdavac(id_na_izdavac)
);

-----------------------------------------

create table izdava(
id_avtor serial not null,
id_knigi serial not null,
constraint pk_izdadeno primary key (id_knigi, id_avtor),
constraint fk_id_avtor foreign key (id_avtor) references avtor (id_na_avtor),
constraint fk_id_knigi foreign key (id_knigi) references knigi (id_na_kniga)
);

-----------------------------------------

create table e_od(
id_na_kategorija serial not null,
id_knigi serial not null,
constraint pk_e_od primary key (id_knigi, id_na_kategorija),
constraint fk_id_na_kategorija foreign key (id_na_kategorija) references kategorija (id_na_kategorija),
constraint fk_id_knigi foreign key (id_knigi) references knigi(id_na_kniga)
);

-----------------------------------------

create table ocena(
id_na_ocena serial primary key,
ocena integer not null,
komentar varchar(500) not null,
id_chovek_dava integer not null,
ocena_id_kniga integer,
ocena_id_avtor integer,
constraint fk_id_chovek_dava foreign key (id_chovek_dava) references chlen (id_chovek),
constraint fk_ocena_id_kniga foreign key (ocena_id_kniga) references knigi (id_na_kniga),
constraint fk_ocena_id_avtor foreign key (ocena_id_avtor) references avtor (id_na_avtor)
);

-----------------------------------------

create table instanca_od_kniga(
unique_id serial,
dali_e_ostetena boolean not null,
status boolean not null,
id_na_dobavuvac integer not null,
id_na_kniga integer not null,
constraint pk_id_na_kniga primary key (id_na_kniga,unique_id), 
constraint fk_id_na_kniga foreign key (id_na_kniga) references knigi (id_na_kniga),
constraint fk_id_na_dobavuvac foreign key (id_na_dobavuvac) references dobavuvac (id_na_dobavuvac)
);

-----------------------------------------

create table pozajmica(
id_na_pozajmica serial primary key,
datum_na_zemanje date not null,
datum_na_vrakjanje date not null,
status boolean not null,
id_chovek_odobruva integer not null,
id_chovek_prave integer not null,
unique_id integer not null,
id_na_kniga integer not null,
constraint fk_id_chovek_odobruva foreign key (id_chovek_odobruva) references bibliotekar (id_chovek),
constraint fk_id_chovek_prave foreign key (id_chovek_prave) references chlen (id_chovek),--, 
constraint fk_unique_id foreign key (id_na_kniga,unique_id) references instanca_od_kniga(id_na_kniga,unique_id)
);

-----------------------------------------

create table kazna(
id_kazna serial primary key,
datum date not null,
cena_vo_denari FLOAT not null,
id_pozajmica_proverka integer not null,
id_chovek_imakazna integer not null,
constraint fk_id_pozajmica_proverka foreign key (id_pozajmica_proverka) references pozajmica (id_na_pozajmica),
constraint fk_id_chovek_imakazna foreign key (id_chovek_imakazna) references chlen (id_chovek)
);

-----------------------------------------

