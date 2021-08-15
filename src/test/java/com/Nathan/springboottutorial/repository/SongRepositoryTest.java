package com.Nathan.springboottutorial.repository;

import com.Nathan.springboottutorial.dao.Item;
import com.Nathan.springboottutorial.dao.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SongRepositoryTest {
    @Autowired
    SongRepository songRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveAndFindTest() {


        Song song = new Song();
        song.setSongTitle("Ed Sheeran - Shape of You");
        song.setSongURL("https://www.youtube.com/watch?v=JGwWNGJdvx8&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu");

        Long songId = songRepository.create(song);
        Song songRetrieved = songRepository.retrieve(songId);


        assertThat(songRetrieved).isNotNull();
        assertThat(songRetrieved.getSongTitle())
                .isEqualTo("Ed Sheeran - Shape of You");
        assertThat(songRetrieved.getSongURL())
                .isEqualTo("https://www.youtube.com/watch?v=JGwWNGJdvx8&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu");
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void inputManySongs() {
        songRepository.create(
                new Song(null,
                        "Mark Ronson - Uptown Funk ft. Bruno Mars",
                        "https://www.youtube.com/watch?v=OPf0YbXqDm0&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu&index=2"));

        songRepository.create(
                new Song(null,
                        "Maroon 5 - Sugar",
                        "https://www.youtube.com/watch?v=09R8_2nJtjg&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu&index=3"));

        songRepository.create(
                new Song(null,
                        "OneRepublic - Counting Stars",
                        "https://www.youtube.com/watch?v=hT_nvWreIhg&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu&index=4"));

        songRepository.create(
                new Song(null,
                        "Taylor Swift - Shake It Off",
                        "https://www.youtube.com/watch?v=nfWlot6h_JM&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu&index=6"));

        songRepository.create(
                new Song(null,
                        "Meghan Trainor - All About That Bass",
                        "https://www.youtube.com/watch?v=7PCkvCPvDXk&list=PLAQ7nLSEnhWTEihjeM1I-ToPDJEKfZHZu&index=9"));

        songRepository.create(
                new Song(null,
                        "Wiz Khalifa - See You Again ft. Charlie Puth",
                        "https://www.youtube.com/watch?v=RgKAFK5djSk&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=3"));

        songRepository.create(
                new Song(null,
                        "Olivia Rodrigo - drivers license",
                        "https://www.youtube.com/watch?v=ZmDBbnmKpqQ&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=11"));

        songRepository.create(
                new Song(null,
                        "Charlie Puth - We Don't Talk Anymore",
                        "https://www.youtube.com/watch?v=3AtDnEC4zak&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=15"));

        songRepository.create(
                new Song(null,
                        "Alan Walker - Faded",
                        "https://www.youtube.com/watch?v=60ItHLz5WEA&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=20"));

        songRepository.create(
                new Song(null,
                        "Adele - Hello",
                        "https://www.youtube.com/watch?v=YQHsXMglC9A&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=28"));

        songRepository.create(
                new Song(null,
                        "Adele - Rolling in the Deep",
                        "https://www.youtube.com/watch?v=rYEDA3JcQqw&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=43"));

        songRepository.create(
                new Song(null,
                        "Ed Sheeran - Perfect",
                        "https://www.youtube.com/watch?v=2Vv-BfVoq4g&list=PL7v1FHGMOadDghZ1m-jEIUnVUsGMT9jbH"));

        songRepository.create(
                new Song(null,
                        "Justin Timberlake, Anna Kendrick - True Colors",
                        "https://www.youtube.com/watch?v=la0-5QFLr14&list=PL7v1FHGMOadDghZ1m-jEIUnVUsGMT9jbH&index=45"));

        songRepository.create(
                new Song(null,
                        "Lauv - Paris in the Rain",
                        "https://www.youtube.com/watch?v=3AtDnEC4zak&list=PLQdn7YisXz3MXKqoULiuUy2qSQmwu_2_P&index=15"));

        songRepository.create(
                new Song(null,
                        "Adele - Send My Love",
                        "https://www.youtube.com/watch?v=fk4BbF7B29w"));

        songRepository.create(
                new Song(null,
                        "Christina Perri - A Thousand Years",
                        "https://www.youtube.com/watch?v=rtOvBOTyX00&list=RDQMsxW3SHWWpz8&start_radio=1"));
        songRepository.create(
                new Song(null,
                        "Justin Bieber - Love Yourself",
                        "https://www.youtube.com/watch?v=oyEuk8j8imI&list=RDQMsxW3SHWWpz8&index=10"));



    }
}

