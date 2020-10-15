INSERT INTO artist (artist_name) VALUES ('Jimi Hendrix');

INSERT INTO album (album_name) VALUES ('Are You Experienced');

INSERT INTO song (song_name, duration, album_id) VALUES ('Hey Joe', '3:30', 1);
INSERT INTO song (song_name, duration, album_id) VALUES ('Purple Haze', '2:51', 1);
INSERT INTO song (song_name, duration, album_id) VALUES ('The Wind Cries Mary', '3:21', 1);

INSERT INTO artist_albums (artists_id, albums_id) VALUES (1, 1)