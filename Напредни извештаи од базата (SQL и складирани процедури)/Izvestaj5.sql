select mesectri.naslov, mesectri.ime,mesectri.pozajmuvanja_pomegju_2_3_meseci_nanazad,
mesecdva.naslov, mesecdva.ime,mesecdva.pozajmuvanja_pomegju_1_2_meseci_nanazad, meseceden.naslov, meseceden.ime,meseceden.pozajmuvanja_za_posledniot_mesec
 from
(
                select k.naslov, a.ime, count(p.id_na_pozajmica) as pozajmuvanja_za_posledniot_mesec from
                pozajmica as p
                
                join knigi as k on p.id_na_kniga=k.id_na_kniga
                join izdava as i on k.id_na_kniga = i.id_knigi
                join avtor as a on i.id_avtor = a.id_na_avtor
                where a.ime like '%Goce%' and p.datum_na_zemanje between now() - interval'1 month' and now()
                
                group by 1,2
                order by pozajmuvanja_za_posledniot_mesec desc
                                fetch first row only

) as meseceden
join
(
                select k.naslov, a.ime, count(p.id_na_pozajmica) as pozajmuvanja_pomegju_1_2_meseci_nanazad from
                pozajmica as p
                
                join knigi as k on p.id_na_kniga=k.id_na_kniga
                join izdava as i on k.id_na_kniga = i.id_knigi
                join avtor as a on i.id_avtor = a.id_na_avtor
                where a.ime like '%Goce%' and p.datum_na_zemanje between now() - interval'2 months' and now() - interval'1month'
                
                group by 1,2
                order by pozajmuvanja_pomegju_1_2_meseci_nanazad desc
                                fetch first row only

) as mesecdva on meseceden.ime = mesecdva.ime
join
(
                select k.naslov, a.ime, count(p.id_na_pozajmica) as pozajmuvanja_pomegju_2_3_meseci_nanazad from
                pozajmica as p
                
                join knigi as k on p.id_na_kniga=k.id_na_kniga
                join izdava as i on k.id_na_kniga = i.id_knigi
                join avtor as a on i.id_avtor = a.id_na_avtor
                where a.ime like '%Goce%' and p.datum_na_zemanje between now() - interval'3 months' and now() - interval'2 months'
                
                group by 1,2
                order by pozajmuvanja_pomegju_2_3_meseci_nanazad desc
                fetch first row only
) as mesectri on mesecdva.ime = mesectri.ime
