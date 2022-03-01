
--CHOVEK
insert into chovek (id_chovek,ime,prezime,email,tel_broj,adresa,EMBG,username,password)
values (1,'huma','sejdini','humasejdini@gmail.com','070123456','adresa1,kicevo','1122334455667','hs','pass123'),
	   (2,'toni','trajanov','tonitrajanov@gmail.com','070112233','adresa2,negotino','1111222233334','tt','pass456'),
	   (3,'toma','simena','tomasimena@gmail.com','070222333','adresa3,krusevo','1111222233444','ts','pass789');
select * from chovek;


--NAJAVA
insert into authentication(log_id,timestamp_log,id_chovek)
values (1,now(),1),
	   (2,now(),2),
	   (3,now(),3);
	  
select * from authentication;


--CHLEN
insert into chlen (id_chovek,broj,datum_na_zachlenuvanje)
values (1,1,now()),
	   (2,2,now());
	  
select * from chlen;


--BIBLIOTEKAR
insert into bibliotekar (id_chovek,id_na_bibliotekar)
values (3,3);
select * from bibliotekar;

--AVTOR
insert into avtor (id_na_avtor,ime)
values (1,'Goce Smilevski'),
	   (2,'Frosina Parmakovska'),
	   (3,'Bert Stajn'),
	   (4,'Rumena Buzharovska'),
	   (5,'Mihajlo Sviderski');
select * from avtor;


--KATEOGORIJA
insert into kategorija (id_na_kategorija,ime_kategorija)
values (1,'drama'),
	   (2,'komedija'),
	   (3,'roman'),
	   (4,'raskazi');
select * from kategorija;

--IZDAVAC
insert into izdavac (id_na_izdavac,email,lokacija,ime_na_izdavac)
values (1,'kocoracin@hotmail.com','Todor Aleksandrov (Salvador Aljende) 2 , Skopje','Koco Racin'),
	   (2,'info@kultura.com.mk','ул. „Македонија“ бр. 33, Скопје','Kultura'),
	   (3,'info@feniks.net.mk','ул. Костурски Херои бр. 35 1000 Скопје','Feniks');
	  
select * from izdavac;


--DOBAVUVAC
insert into dobavuvac (id_na_dobavuvac,ime_na_dobavuvac)
values (1,'dobavuvac1'),
	   (2,'dobavuvac2');
select * from dobavuvac;


--KNIGI
insert into knigi (id_na_kniga,opis,naslov,id_izdavac)
values 	(1,'Потресен, трогателен, мајсторски напишан. „Сестрата на Зигмунд Фројд“ има одлична приказна и уште подобра нарација која ќе ви ги отвори очите за еден од највлијателните ликови во областа на психоанализата.','Сестрата на Зигмунд Фројд',1),
		(2,'Со исклучителна наративна техника, овој несекојдневен роман на Фросина Пармаковска е хроника за растењето, раскажана од перспективата на мало детенце, а подоцна момче. Тој е толку уникатен колку и неговиот необичен живот и патот кој ќе го однесе од мало прашливо македонско селце до Париз. Времето кое не запира со сите премрежија и настаните кои се македонски, а всушност толку универзално познати длабоко ќе ве потресат.','"Вишнова хроника"',2),
		(3,'3 минути и 53 секунди е просечното траење на една модерна поп-песна, а од прилика толку време му е потребно на читателот за да прочита еден расказ од книгата.Секоја глава е најавена од песна популарна во тој одреден временски период која остава своја неизбришлива трага врз животот на авторот.','3 минути и 53 секунди',3),
		(4,'Жените кои зборуваат за своите мажи низ низа од импресивни раскази, всушност се соголуваат себеси: своите најдлабоки тајни, стравови, желби и фрустрации.Жената во „Мојот маж“ менува толку многу улоги, таа е домаќинка, посветена сопруга, но и жена која е способна да изневери, таа е соучесник во злосторство, таа е нестабилна и плашлива, но и истовремено неверојатно силна и храбра.','Мојот маж',3),
		(5,'Објавен во 2014 година, краткиот роман „Бело и црвено“ се чита во еден здив. Сместен е во специфични историски околности, но се чини дека случките, настаните и луѓето се безвременски. Кога ќе се тргнат борбата и идеологиите на една страна од кантарот, на другата секогаш натежнуваат суровоста, страдањето, немоќта и згазените соништа.','Бело и црвено',2);
	select * from knigi;
	

--RELACIJA IZDAVA
insert into izdava (id_avtor,id_knigi)
values (1,1),
	   (2,2),
	   (3,3);
select * from izdava;


--RELACIJA E_OD
insert into e_od(id_na_kategorija,id_knigi)
values (3,1),
	   (3,2),
	   (3,3),
	   (3,4),
	   (4,5);
select * from e_od;


--OCENA
insert into ocena(id_na_ocena,ocena,komentar,id_chovek_dava,ocena_id_kniga)
values (3,5,'Одлична книга, презадоволен сум',1,1);
	   
select * from ocena;


--INSTANCA OD KNIGA
insert into instanca_od_kniga (id_na_kniga,unique_id,dali_e_ostetena,status,id_na_dobavuvac)
values (1,12345678,false,true,2),
	   (2,22318907,false,true,1);

select * from instanca_od_kniga;

--POZAJMICA
insert into pozajmica (id_na_pozajmica,datum_na_zemanje,datum_na_vrakjanje,status,id_chovek_odobruva,id_chovek_prave,unique_id,id_na_kniga)
values (1,now(),now(),false,3,1,12345678,1),
	   (2,now(),now(),false,3,2,22318907,2);

select * from pozajmica;


--KAZNA
insert into kazna(id_kazna,datum,cena_vo_denari,id_pozajmica_proverka,id_chovek_imakazna)
values (1,now(),400.00,1,1);

select * from kazna;