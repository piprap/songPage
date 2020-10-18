INSERT INTO artist (artist_name) VALUES ('Jimi Hendrix');
INSERT INTO artist (artist_name) VALUES ('Led Zeppelin');

INSERT INTO album (album_name) VALUES ('Are You Experienced');
INSERT INTO album (album_name) VALUES ('Physical Graffiti');


INSERT INTO song (song_name, duration, album_id) VALUES ('Hey Joe', '3:30', 1);
INSERT INTO song (song_name, duration, album_id) VALUES ('Purple Haze', '2:51', 1);
INSERT INTO song (song_name, duration, album_id) VALUES ('The Wind Cries Mary', '3:21', 1);
INSERT INTO song (song_name, duration, album_id) VALUES ('Ten Years Gone', '6:35', 2);

INSERT INTO artist_albums (id, artists_id, albums_id) VALUES (1, 1, 1);
INSERT INTO artist_albums (id, artists_id, albums_id) VALUES (2, 2, 2);