drop table album if exists;
drop table song if exists;

CREATE TABLE `album` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `album_title` varchar(255) NOT NULL,
    `locale` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--CREATE TABLE `locale` (
--    `id` bigint NOT NULL AUTO_INCREMENT,
--    `album_id` bigint NOT NULL,
--    `code` varchar(255) NOT NULL,
--    PRIMARY KEY (`id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `song` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `album_id` bigint NOT NULL,
    `length` bigint NOT NULL,
    `title` varchar(255) NOT NULL,
    `track` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into album values (1, 'Please Please Me (1963.3)', 'en,kr');
insert into song values (null, 1, 123, 'Please Please Me (1963.3) song-1', 1);
insert into song values (null, 1, 123, 'Please Please Me (1963.3) song-2', 2);
insert into song values (null, 1, 123, 'Please Please Me (1963.3) song-3', 3);

insert into album values (2, 'Cold water (1963.3)', 'ja,kr');
insert into song values (null, 2, 123, 'Dog (1963.3) song-1', 1);
insert into song values (null, 2, 123, 'Cat (1963.3) song-2', 2);
insert into song values (null, 2, 123, 'Orange (1963.3) song-3', 3);

insert into album values (3, ' water resistence (1963.3)', 'ja,en');
insert into song values (null, 3, 123, 'Dog water (1963.3) song-1', 1);
insert into song values (null, 3, 123, 'Cat water (1963.3) song-2', 2);
insert into song values (null, 3, 123, 'Orange water (1963.3) song-3', 3);

select * from song;
select a.id, a.album_title, a.locale, s.id as song_id, s.length, s.title, s.track from album a, song s where a.id = s.album_id;