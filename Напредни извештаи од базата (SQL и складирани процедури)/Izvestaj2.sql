select mesectri.ime, mesectri.prezime,  mesecTri.pozajmuvanja_pomegju_2_3_meseci_nanazad,meseceden.ime, meseceden.prezime, meseceden.pozajmuvanja_za_prethodniot_mesec,
mesecdva.ime, mesecdva.prezime, mesecdva.pozajmuvanja_pomegju_1_2_meseci_nanazad
from
(
                select ch.ime,ch.prezime,count(ch.ime) as pozajmuvanja_za_prethodniot_mesec
                from pozajmica as p
                join chlen as chl on p.id_chovek_prave = chl.id_chovek
                join chovek as ch on chl.id_chovek = ch.id_chovek
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                where p.datum_na_zemanje between now() - interval'1 month' and now()
                group by 1,2
                order by pozajmuvanja_za_prethodniot_mesec desc
) as meseceden
join
(
                select ch.ime,ch.prezime,(count(ch.id_chovek)) as pozajmuvanja_pomegju_1_2_meseci_nanazad
                from pozajmica as p
                join chlen as chl on p.id_chovek_prave = chl.id_chovek
                join chovek as ch on chl.id_chovek = ch.id_chovek
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                where p.datum_na_zemanje between now() - interval'2 months' and now() - interval '1 month'
                group by 1,2
                order by pozajmuvanja_pomegju_1_2_meseci_nanazad desc
) as mesecdva on meseceden.ime = mesecdva.ime
join 
(
                select ch.ime,ch.prezime,(count(ch.id_chovek)) as pozajmuvanja_pomegju_2_3_meseci_nanazad
                from pozajmica as p
                join chlen as chl on p.id_chovek_prave = chl.id_chovek
                join chovek as ch on chl.id_chovek = ch.id_chovek
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                where p.datum_na_zemanje between now() - interval'3 months' and now() - interval '2 months'
                group by 1,2
                order by pozajmuvanja_pomegju_2_3_meseci_nanazad desc
) as mesectri on mesecdva.ime = mesectri.ime
