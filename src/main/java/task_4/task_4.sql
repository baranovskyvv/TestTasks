--21-00 27.05.2021
--22-05 27.05.2021
--Получить количество неактивных (не было сессий) клиентов.
select u.* from users u left join usersessions s on u.userid=s.userid where s.userid is null

--Получить список уникальных UserId активных пользователей, которые не пользовались каналом 1.
select distinct userid from usersessions where userid not in(select userid from usersessions where channeltype=1)

--Получить максимальное UserId активного пользователя, статус которого также не равен 1.
select max(s.userid) from usersessions s join (select userid as id from users where status!=1) c on c.id=s.userid

---Получить список количества сессий с разделением на MobAppVersion.
--То есть список, сгруппированный по MobAppVersion, в котором для каждой из MobAppVersion
--будет подсчитано количество сессий со "старой" mobosversion, "старой" версией считается версия ниже 80 или неуказанная.
select count(sessionid), MOBAPPVERSION from usersessions group by MOBAPPVERSION, mobosversion having mobosversion <80 or mobosversion is null
