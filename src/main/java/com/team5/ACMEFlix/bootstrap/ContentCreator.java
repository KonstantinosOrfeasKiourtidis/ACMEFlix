package com.team5.ACMEFlix.bootstrap;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.CardType;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.repository.*;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


import java.util.Date;



@Component
@AllArgsConstructor
public class ContentCreator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final ProfileRepository profileRepository;
    private final CreditCardRepository creditCardRepository;
    private final AddressRepository addressRepository;
    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final WriterRepository writerRepository;
    private final DirectorRepository directorRepository;
    private final TVSeriesRepository tVSeriesRepository;
    private final EpisodeRepository episodeRepository;
    private final SeasonRepository seasonRepository;
    private final CreatorRepository creatorRepository;


    @Override
    public void run(final String... args) throws Exception {

        //region Account 1
        //-----------------Account 1----------------//
        Account account1 = Account.builder()
                .email("dave@hotmail.com")
                .username("Dave")
                .firstname("David")
                .lastname("Johnson")
                .password("mypass")
                .phoneNo("2101234567")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA1P1 = Profile.builder()
                .firstname("Dave")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account1)
                .build();

        Profile profileA1P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account1)
                .build();

        Profile profileA1P3 = Profile.builder()
                .firstname("Jessica")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account1)
                .build();

        CreditCard creditCardA1C1 = CreditCard.builder()
                .cardNo("1244563591912121")
                .cardCvc("123")
                .cardName("Dave Johnson")
                .cardType(CardType.AMERICAN_EXPRESS)
                .account(account1)
                .build();

        Address addressA1A1 = Address.builder()
                .country("United States")
                .postalCode("123456")
                .streetName("Main Street")
                .province("Texas")
                .streetNo("32")
                .account(account1)
                .build();


        accountRepository.save(account1);
        profileRepository.save(profileA1P1);
        profileRepository.save(profileA1P2);
        profileRepository.save(profileA1P3);
        creditCardRepository.save(creditCardA1C1);
        addressRepository.save(addressA1A1);
        //endregion

        //region Account 2
        //-----------------Account 2----------------//
        Account account2 = Account.builder()
                .email("rachel94@hotmail.com")
                .username("rache")
                .firstname("Rachel")
                .lastname("Green")
                .password("wewereonabreak")
                .phoneNo("0135899160")
                .subscriptionType(SubscriptionType.BASIC)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA2P1 = Profile.builder()
                .firstname("Rachel")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account2)
                .build();

        Profile profileA2P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account2)
                .build();

        CreditCard creditCardA2C1 = CreditCard.builder()
                .cardNo("1244563591912121")
                .cardCvc("456")
                .cardName("Rachel Green")
                .cardType(CardType.VISA)
                .account(account2)
                .build();

        Address addressA2A1 = Address.builder()
                .country("United Kingdom")
                .postalCode("15155")
                .streetName("Paddigton Street")
                .province("London")
                .streetNo("64")
                .account(account2)
                .build();


        accountRepository.save(account2);
        profileRepository.save(profileA2P1);
        profileRepository.save(profileA2P2);
        creditCardRepository.save(creditCardA2C1);
        addressRepository.save(addressA2A1);
        //endregion

        //region Account 3
        //-----------------Account 3----------------//
        Account account3 = Account.builder()
                .email("tom_92@hotmail.com")
                .username("tommy")
                .firstname("Tomas")
                .lastname("Crane")
                .password("123456")
                .phoneNo("5802360576")
                .subscriptionType(SubscriptionType.STANDARD)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA3P1 = Profile.builder()
                .firstname("Tomas")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account3)
                .build();

        Profile profileA3P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account3)
                .build();

        Profile profileA3P3 = Profile.builder()
                .firstname("Marry")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account3)
                .build();

        CreditCard creditCardA3C1 = CreditCard.builder()
                .cardNo("5586278084797458")
                .cardCvc("551")
                .cardName("Tomas Crane")
                .cardType(CardType.MASTERCARD)
                .account(account3)
                .build();

        CreditCard creditCardA3C2 = CreditCard.builder()
                .cardNo("6319087600983084")
                .cardCvc("574")
                .cardName("Rachel Green")
                .cardType(CardType.VISA)
                .account(account3)
                .build();

        Address addressA3A1 = Address.builder()
                .country("United Kingdom")
                .postalCode("15155")
                .streetName("Canal Street")
                .province("Manchester")
                .streetNo("12")
                .account(account3)
                .build();

        Address addressA3A2 = Address.builder()
                .country("United Kingdom")
                .postalCode("15155")
                .streetName("Kings Passing")
                .province("London")
                .streetNo("36")
                .account(account3)
                .build();


        accountRepository.save(account3);
        profileRepository.save(profileA3P1);
        profileRepository.save(profileA3P2);
        profileRepository.save(profileA3P3);
        creditCardRepository.save(creditCardA3C1);
        creditCardRepository.save(creditCardA3C2);
        addressRepository.save(addressA3A1);
        addressRepository.save(addressA3A2);
        //endregion

        //region Account 4
        //-----------------Account 4----------------//
        Account account4 = Account.builder()
                .email("kath71@hotmail.com")
                .username("kath")
                .firstname("Kathleen")
                .lastname("Nelson")
                .password("randompass")
                .phoneNo("7826469165")
                .subscriptionType(SubscriptionType.STANDARD)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA4P1 = Profile.builder()
                .firstname("Kath")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account4)
                .build();

        Profile profileA4P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account4)
                .build();


        CreditCard creditCardA4C1 = CreditCard.builder()
                .cardNo("6505241162470006")
                .cardCvc("392")
                .cardName("Kathleen Nelson")
                .cardType(CardType.PAYPAL)
                .account(account4)
                .build();


        Address addressA4A1 = Address.builder()
                .country("Brazil")
                .postalCode("111111")
                .streetName("Avenida Epitacio Pessoa")
                .province("Rio de Janeiro")
                .streetNo("145")
                .account(account4)
                .build();




        accountRepository.save(account4);
        profileRepository.save(profileA4P1);
        profileRepository.save(profileA4P2);
        creditCardRepository.save(creditCardA4C1);
        addressRepository.save(addressA4A1);
        //endregion

        //region Account 5
        //-----------------Account 5----------------//
        Account account5 = Account.builder()
                .email("sam@hotmail.com")
                .username("samir")
                .firstname("Samir")
                .lastname("Rangel")
                .password("test")
                .phoneNo("0489464334")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA5P1 = Profile.builder()
                .firstname("Samir")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account5)
                .build();

        Profile profileA5P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account5)
                .build();

        Profile profileA5P3 = Profile.builder()
                .firstname("Aamir")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account5)
                .build();


        CreditCard creditCardA5C1 = CreditCard.builder()
                .cardNo("4514169755894494")
                .cardCvc("154")
                .cardName("Samir Rangel")
                .cardType(CardType.VISA)
                .account(account5)
                .build();

        CreditCard creditCardA5C2 = CreditCard.builder()
                .cardNo("6505212716586258")
                .cardCvc("551")
                .cardName("Aamir Rangel")
                .cardType(CardType.PAYPAL)
                .account(account5)
                .build();


        Address addressA5A1 = Address.builder()
                .country("Afghanistan")
                .postalCode("121212")
                .streetName("Kabul Kandahar")
                .province("Kabul")
                .streetNo("33")
                .account(account5)
                .build();


        accountRepository.save(account5);
        profileRepository.save(profileA5P1);
        profileRepository.save(profileA5P2);
        profileRepository.save(profileA5P3);
        creditCardRepository.save(creditCardA5C1);
        creditCardRepository.save(creditCardA5C2);
        addressRepository.save(addressA5A1);
        //endregion


        //region Content 1
        //-----------------Content 1----------------//
        Content content1 = Content.builder()
                .title("Glass Onion: A Knives Out Mystery")
                .description("Famed Southern detective Benoit Blanc travels to Greece for his latest case.")
                .spokenLanguage("English")
                .releaseDate("23 Dec 2022")
                .imageUrl("https://images2.alphacoders.com/128/1287184.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/-xR_lBtEvSc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(140)
                .build();

        Genre genreC1G1 = Genre.builder()
                .name("Comedy")
                .content(content1)
                .build();

        Genre genreC1G2 = Genre.builder()
                .name("Drama")
                .content(content1)
                .build();

        Genre genreC1G3 = Genre.builder()
                .name("Crime")
                .content(content1)
                .build();

        Actor actorC1A1 = Actor.builder()
                .fullname("Daniel Craig")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Daniel_Craig_in_2021.jpg/330px-Daniel_Craig_in_2021.jpg")
                .content(content1)
                .build();

        Actor actorC1A2 = Actor.builder()
                .fullname("Edward Norton")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/3/35/Ed_Norton_Shankbone_Metropolitan_Opera_2009.jpg")
                .content(content1)
                .build();

        Actor actorC1A3 = Actor.builder()
                .fullname("Kate Hudson")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/6/61/Kate_Hudson_%288033413872%29_%28cropped%29.jpg")
                .content(content1)
                .build();

        Movie movie1 = Movie.builder()
                .content(content1)
                .build();

        Writer writerM1W1 = Writer.builder()
                .fullname("Rian Johnson")
                .imageUrl(null)
                .movie(movie1)
                .build();

        Director directorM1D1 = Director.builder()
                .fullname("Rian Johnson")
                .imageUrl(null)
                .movie(movie1)
                .build();

        movieRepository.save(movie1);
        genreRepository.save(genreC1G1);
        genreRepository.save(genreC1G2);
        genreRepository.save(genreC1G3);
        actorRepository.save(actorC1A1);
        actorRepository.save(actorC1A2);
        actorRepository.save(actorC1A3);
        writerRepository.save(writerM1W1);
        directorRepository.save(directorM1D1);
        //endregion

        //region Content 2
        //-----------------Content 2----------------//
        Content content2 = Content.builder()
                .title("The Exorcist")
                .description("When a teenage girl is possessed by a mysterious entity, her mother seeks the help of two priests to save her daughter.")
                .spokenLanguage("English")
                .releaseDate("26 Dec 1973")
                .imageUrl("https://www.classic-monsters.com/shop/wp-content/uploads/2021/10/Exorcist-1973-Cover-Inline-1.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=0iS59iV2Ffs&ab_channel=6xordorigma2011\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.MOVIE)
                .runtime(122)
                .build();

        Genre genreC2G1 = Genre.builder()
                .name("Horror")
                .content(content2)
                .build();

        Actor actorC2A1 = Actor.builder()
                .fullname("Ellen Burstyn")
                .imageUrl("https://en.wikipedia.org/wiki/Ellen_Burstyn#/media/File:Ellen_Burstyn_at_the_2009_Tribeca_Film_Festival.jpg")
                .content(content2)
                .build();

        Actor actorC2A2 = Actor.builder()
                .fullname("Max von Sydow")
                .imageUrl("https://en.wikipedia.org/wiki/Max_von_Sydow#/media/File:Max_von_Sydow_Cannes_2016.jpg")
                .content(content2)
                .build();

        Actor actorC2A3 = Actor.builder()
                .fullname("Lee J. Cobb")
                .imageUrl("https://en.wikipedia.org/wiki/Lee_J._Cobb#/media/File:Lee_J._Cobb_1960s.JPG")
                .content(content2)
                .build();

        Movie movie2 = Movie.builder()
                .content(content2)
                .build();

        Writer writerM2W1 = Writer.builder()
                .fullname("William Peter Blatty")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/4/44/William-Peter-Blatty-2009.jpg")
                .movie(movie2)
                .build();

        Director directorM2D1 = Director.builder()
                .fullname("William Friedkin")
                .imageUrl("https://en.wikipedia.org/wiki/William_Friedkin#/media/File:William_Friedkin,_Festival_de_Sitges_2017_(cropped).jpg")
                .movie(movie2)
                .build();



        movieRepository.save(movie2);
        genreRepository.save(genreC2G1);
        actorRepository.save(actorC2A1);
        actorRepository.save(actorC2A2);
        actorRepository.save(actorC2A3);
        writerRepository.save(writerM2W1);
        directorRepository.save(directorM2D1);
        //endregion

        //region Content 3
        //-----------------Content 3----------------//
        Content content3 = Content.builder()
                .title("Hereditary")
                .description("A grieving family is haunted by tragic and disturbing occurrences.")
                .spokenLanguage("English")
                .releaseDate("21 Jan 2018")
                .imageUrl("https://gravereviews.com/wp-content/uploads/2018/06/her.jpeg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=V6wWKNij_1M&ab_channel=A24\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.MOVIE)
                .runtime(127)
                .build();

        Genre genreC3G1 = Genre.builder()
                .name("Horror")
                .content(content3)
                .build();

        Genre genreC3G2 = Genre.builder()
                .name("Drama")
                .content(content3)
                .build();

        Genre genreC3G3 = Genre.builder()
                .name("Mystery")
                .content(content3)
                .build();

        Actor actorC3A1 = Actor.builder()
                .fullname("Alex Wolff")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Human_Capital_01_%2848816385573%29.jpg/1024px-Human_Capital_01_%2848816385573%29.jpg")
                .content(content3)
                .build();

        Actor actorC3A2 = Actor.builder()
                .fullname("Gabriel Byrne")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/ff/Gabriel_Byrne_2010.jpg")
                .content(content3)
                .build();

        Actor actorC3A3 = Actor.builder()
                .fullname("Toni Collette")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/6/69/Toni_Collette_%286902407861%29_%28cropped%29.jpg")
                .content(content3)
                .build();

        Movie movie3 = Movie.builder()
                .content(content3)
                .build();

        Writer writerM3W1 = Writer.builder()
                .fullname("Ari Aster")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/a1/Ari_Aster%2C_2018_%28crop%29.jpg")
                .movie(movie3)
                .build();

        Director directorM3D1 = Director.builder()
                .fullname("Ari Aster")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/a1/Ari_Aster%2C_2018_%28crop%29.jpg")
                .movie(movie3)
                .build();



        movieRepository.save(movie3);
        genreRepository.save(genreC3G1);
        genreRepository.save(genreC3G2);
        genreRepository.save(genreC3G3);
        actorRepository.save(actorC3A1);
        actorRepository.save(actorC3A2);
        actorRepository.save(actorC3A3);
        writerRepository.save(writerM3W1);
        directorRepository.save(directorM3D1);
        //endregion

        //region Content 4
        //-----------------Content 4----------------//
        Content content4 = Content.builder()
                .title("The VVitch: A New-England Folktale")
                .description("A family in 1630s New England is torn apart by the forces of witchcraft, black magic and possession.")
                .spokenLanguage("English")
                .releaseDate("23 Jan 2015")
                .imageUrl("https://upload.wikimedia.org/wikipedia/en/b/bf/The_Witch_poster.png")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=iQXmlf3Sefg&ab_channel=A24\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.MOVIE)
                .runtime(92)
                .build();

        Genre genreC4G1 = Genre.builder()
                .name("Horror")
                .content(content4)
                .build();

        Genre genreC4G2 = Genre.builder()
                .name("Drama")
                .content(content4)
                .build();

        Genre genreC4G3 = Genre.builder()
                .name("Fantasy")
                .content(content4)
                .build();

        Actor actorC4A1 = Actor.builder()
                .fullname("Anya Taylor-Joy")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Anya_Taylor-Joy_by_Patrick_Lovell%2C_January_2019.jpg/800px-Anya_Taylor-Joy_by_Patrick_Lovell%2C_January_2019.jpg")
                .content(content4)
                .build();

        Actor actorC4A2 = Actor.builder()
                .fullname("Ralph Ineson")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/1/13/Ralphinesonadjusted.jpg")
                .content(content4)
                .build();

        Actor actorC4A3 = Actor.builder()
                .fullname("Kate Dickie")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/8/8b/Kate_Dickie_by_Gage_Skidmore.jpg")
                .content(content4)
                .build();

        Movie movie4 = Movie.builder()
                .content(content4)
                .build();

        Writer writerM4W1 = Writer.builder()
                .fullname("Robert Eggers")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/2/2e/Robert_Eggers_-_The_Witch%2CFantastic_Fest_2015-1667_%2828894993650%29_%28cropped%29.jpg")
                .movie(movie4)
                .build();

        Director directorM4D1 = Director.builder()
                .fullname("Robert Eggers")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/2/2e/Robert_Eggers_-_The_Witch%2CFantastic_Fest_2015-1667_%2828894993650%29_%28cropped%29.jpg")
                .movie(movie4)
                .build();



        movieRepository.save(movie4);
        genreRepository.save(genreC4G1);
        genreRepository.save(genreC4G2);
        genreRepository.save(genreC4G3);
        actorRepository.save(actorC4A1);
        actorRepository.save(actorC4A2);
        actorRepository.save(actorC4A3);
        writerRepository.save(writerM4W1);
        directorRepository.save(directorM4D1);
        //endregion

        //region Content 5
        //-----------------Content 5----------------//
        Content content5 = Content.builder()
                .title("Avatar: The Way of Water")
                .description("Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home.")
                .spokenLanguage("English")
                .releaseDate("6 Dec 2022")
                .imageUrl("https://mickeyblog.com/wp-content/uploads/2022/11/Avatar-Poster.png")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=4InRFMo3FM8&ab_channel=VILLAGE\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(192)
                .build();

        Genre genreC5G1 = Genre.builder()
                .name("Action")
                .content(content5)
                .build();

        Genre genreC5G2 = Genre.builder()
                .name("Adventure")
                .content(content5)
                .build();

        Genre genreC5G3 = Genre.builder()
                .name("Fantasy")
                .content(content5)
                .build();

        Actor actorC5A1 = Actor.builder()
                .fullname("Sam Worthington")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/2/2b/Avatar_The_Way_of_Water_Tokyo_Press_Conference_Sam_Worthington_%2852563252594%29_%28cropped%29.jpg")
                .content(content5)
                .build();

        Actor actorC5A2 = Actor.builder()
                .fullname("Zoe Saldana")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/0/0d/Avatar_The_Way_of_Water_Tokyo_Press_Conference_Zoe_Salda%C3%B1a_%2852563431865%29_%28cropped2%29.jpg")
                .content(content5)
                .build();

        Actor actorC5A3 = Actor.builder()
                .fullname("Sigourney Weaver")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/8/8d/Sigourney_Weaver_by_Gage_Skidmore_4.jpg")
                .content(content5)
                .build();

        Movie movie5 = Movie.builder()
                .content(content5)
                .build();

        Writer writerM5W1 = Writer.builder()
                .fullname("James Cameron")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fe/James_Cameron_by_Gage_Skidmore.jpg")
                .movie(movie5)
                .build();

        Director directorM5D1 = Director.builder()
                .fullname("James Cameron")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fe/James_Cameron_by_Gage_Skidmore.jpg")
                .movie(movie5)
                .build();

        Director directorM5D2 = Director.builder()
                .fullname("Rick Jaffa")
                .imageUrl("https://resizing.flixster.com/CpVnGlljHFroHExIS8JrP8Ui_j4=/218x280/v2/https://flxt.tmsimg.com/assets/481362_v9_bb.jpg")
                .movie(movie5)
                .build();

        Director directorM5D3 = Director.builder()
                .fullname("Amanda Silver")
                .imageUrl("https://images.squarespace-cdn.com/content/v1/5fa01c645d57767f8542f968/1604359273629-HZOJXLVB9MWJ13X74IM8/Screen+Shot+2020-11-02+at+6.21.03+PM.png?format=500w")
                .movie(movie5)
                .build();



        movieRepository.save(movie5);
        genreRepository.save(genreC5G1);
        genreRepository.save(genreC5G2);
        genreRepository.save(genreC5G3);
        actorRepository.save(actorC5A1);
        actorRepository.save(actorC5A2);
        actorRepository.save(actorC5A3);
        writerRepository.save(writerM5W1);
        directorRepository.save(directorM5D1);
        directorRepository.save(directorM5D2);
        directorRepository.save(directorM5D3);
        //endregion

        //region Content 6
        //-----------------Content 6----------------//
        Content content6 = Content.builder()
                .title("The Green Mile")
                .description("The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.")
                .spokenLanguage("English")
                .releaseDate("6 Dec 1999")
                .imageUrl("https://images.moviesanywhere.com/3875280af5270deacfc628d591b89847/ac6a8771-3fca-41a0-9be2-be20a14b983a.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=Ki4haFrqSrw&ab_channel=RottenTomatoesClassicTrailers\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(189)
                .build();

        Genre genreC6G1 = Genre.builder()
                .name("Crime")
                .content(content6)
                .build();

        Genre genreC6G2 = Genre.builder()
                .name("Drama")
                .content(content6)
                .build();

        Genre genreC6G3 = Genre.builder()
                .name("Fantasy")
                .content(content6)
                .build();

        Actor actorC6A1 = Actor.builder()
                .fullname("Tom Hanks")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fb/Tom_Hanks_2016.jpg")
                .content(content6)
                .build();

        Actor actorC6A2 = Actor.builder()
                .fullname("David Morse")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/2/22/David_Morse_%282015%29.jpg")
                .content(content6)
                .build();

        Actor actorC6A3 = Actor.builder()
                .fullname("Bonnie Hunt")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/5/57/Bonniehunt06.jpg")
                .content(content6)
                .build();

        Movie movie6 = Movie.builder()
                .content(content6)
                .build();

        Writer writerM6W1 = Writer.builder()
                .fullname("Stephen King")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/e/e3/Stephen_King%2C_Comicon.jpg")
                .movie(movie6)
                .build();

        Director directorM6D1 = Director.builder()
                .fullname("Frank Darabont")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/1/19/Frank_Darabont_at_the_PaleyFest_2011_-_The_Walking_Dead_panel.jpg")
                .movie(movie6)
                .build();


        movieRepository.save(movie6);
        genreRepository.save(genreC6G1);
        genreRepository.save(genreC6G2);
        genreRepository.save(genreC6G3);
        actorRepository.save(actorC6A1);
        actorRepository.save(actorC6A2);
        actorRepository.save(actorC6A3);
        writerRepository.save(writerM6W1);
        directorRepository.save(directorM6D1);
        //endregion

        //region Content 7
        //-----------------Content 7----------------//
        Content content7 = Content.builder()
                .title("Game of Thrones")
                .description("Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.")
                .spokenLanguage("English")
                .releaseDate("17 Apr 2011")
                .imageUrl("https://images.alphacoders.com/478/478372.jpg")
                .trailerUrl("<iframe width=\\\"560\\\" height=\\\"315\\\" src=\\\"https://www.youtube.com/embed/KPLWWIOCOOQ\\\" title=\\\"YouTube video player\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\\\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.TV_SERIES)
                .runtime(57)
                .build();

        Genre genreC7G1 = Genre.builder()
                .name("Action")
                .content(content7)
                .build();

        Genre genreC7G2 = Genre.builder()
                .name("Adventure")
                .content(content7)
                .build();

        Genre genreC7G3 = Genre.builder()
                .name("Drama")
                .content(content7)
                .build();

        Actor actorC7A1 = Actor.builder()
                .fullname("Emilia Clarke")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Emilia_Clarke_Dior_Rose_des_Vents.jpg/900px-Emilia_Clarke_Dior_Rose_des_Vents.jpg")
                .content(content7)
                .build();

        Actor actorC7A2 = Actor.builder()
                .fullname("Peter Dinklage")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Peter_Dinklage_by_Gage_Skidmore.jpg/330px-Peter_Dinklage_by_Gage_Skidmore.jpg")
                .content(content7)
                .build();

        Actor actorC7A3 = Actor.builder()
                .fullname("Kit Harington")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/3/32/Kit_harrington_by_sachyn_mital_%28cropped_2%29.jpg")
                .content(content7)
                .build();

        TVSeries tvSeries1 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content7)
                .build();

        Creator creatorT1C1 = Creator.builder()
                .fullname("David Benioff")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/1/18/David_Benioff_by_Gage_Skidmore_2.jpg")
                .tvSeries(tvSeries1)
                .build();

        Creator creatorT1C2 = Creator.builder()
                .fullname("D.B. Weiss")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/8/83/D._B._Weiss_by_Gage_Skidmore_2.jpg")
                .tvSeries(tvSeries1)
                .build();

        Season seasonT1S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Winter Is Coming")
                .description("Eddard Stark is torn between his family and an old friend when asked to serve at the side of King Robert Baratheon; Viserys plans to wed his sister to a nomadic warlord in exchange for an army.")
                .releaseDate("17 Apr 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E2 = Episode.builder()
                .episodeNo(2)
                .title("The Kingsroad")
                .description("While Bran recovers from his fall, Ned takes only his daughters to Kings Landing. Jon Snow goes with his uncle Benjen to the Wall. Tyrion joins them.")
                .releaseDate("24 Apr 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Lord Snow")
                .description("Jon begins his training with the Nights Watch; Ned confronts his past and future at Kings Landing; Daenerys finds herself at odds with Viserys.")
                .releaseDate("1 May 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Cripples, Bastards, and Broken Things")
                .description("Eddard investigates Jon Arryns murder. Jon befriends Samwell Tarly, a coward who has come to join the Nights Watch.")
                .releaseDate("8 May 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E5 = Episode.builder()
                .episodeNo(5)
                .title("The Wolf and the Lion")
                .description("Catelyn has captured Tyrion and plans to bring him to her sister, Lysa Arryn, at the Vale, to be tried for his, supposed, crimes against Bran. Robert plans to have Daenerys killed, but Eddard refuses to be a part of it and quits.")
                .releaseDate("15 May 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E6 = Episode.builder()
                .episodeNo(6)
                .title("A Golden Crown")
                .description("While recovering from his battle with Jaime, Eddard is forced to run the kingdom while Robert goes hunting. Tyrion demands a trial by combat for his freedom. Viserys is losing his patience with Drogo.")
                .releaseDate("22 May 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E7 = Episode.builder()
                .episodeNo(7)
                .title("You Win or You Die")
                .description("Robert has been injured while hunting and is dying. Jon and the others finally take their vows to the Nights Watch. A man, sent by Robert, is captured for trying to poison Daenerys. Furious, Drogo vows to attack the Seven Kingdoms.")
                .releaseDate("29 May 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E8 = Episode.builder()
                .episodeNo(8)
                .title("The Pointy End")
                .description("The Lannisters press their advantage over the Starks; Robb rallies his fathers northern allies and heads south to war; The White Walkers attack the Wall; Tyrion returns to his father with some new friends.")
                .releaseDate("5 Jun 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E9 = Episode.builder()
                .episodeNo(9)
                .title("Baelor")
                .description("Robb goes to war against the Lannisters. Jon finds himself struggling on deciding if his place is with Robb or the Nights Watch. Drogo has fallen ill from a fresh battle wound. Daenerys is desperate to save him.")
                .releaseDate("12 Jun 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Episode episodeT1S1E10 = Episode.builder()
                .episodeNo(10)
                .title("Fire and Blood")
                .description("Robb vows to get revenge on the Lannisters. Jon must officially decide if his place is with Robb or the Nights Watch. Daenerys says her final goodbye to Drogo.")
                .releaseDate("19 Jun 2011")
                .imageUrl(null)
                .season(seasonT1S1)
                .build();

        Season seasonT1S2 = Season.builder()
                .seasonNo(2)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S2E1 = Episode.builder()
                .episodeNo(1)
                .title("The North Remembers")
                .description("Tyrion arrives at Kings Landing to take his fathers place as Hand of the King. Stannis Baratheon plans to take the Iron Throne for his own. Robb tries to decide his next move in the war. The Nights Watch arrive at the house of Craster.")
                .releaseDate("1 Apr 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E2 = Episode.builder()
                .episodeNo(2)
                .title("The Night Lands")
                .description("Arya makes friends with Gendry. Tyrion tries to take control of the Small Council. Theon arrives at his home, Pyke, in order to persuade his father into helping Robb with the war. Jon tries to investigate Crasters secret.")
                .releaseDate("8 Apr 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E3 = Episode.builder()
                .episodeNo(3)
                .title("What Is Dead May Never Die")
                .description("Tyrion tries to see who he can trust in the Small Council. Catelyn visits Renly to try and persuade him to join Robb in the war. Theon must decide if his loyalties lie with his own family or with Robb.")
                .releaseDate("15 Apr 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E4 = Episode.builder()
                .episodeNo(4)
                .title("Garden of Boness")
                .description("Lord Baelish arrives at Renlys camp just before he faces off against Stannis. Daenerys and her company are welcomed into the city of Qarth. Arya, Gendry, and Hot Pie find themselves imprisoned at Harrenhal.")
                .releaseDate("22 Apr 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E5 = Episode.builder()
                .episodeNo(5)
                .title("The Ghost of Harrenhal")
                .description("Tyrion investigates a secret weapon that King Joffrey plans to use against Stannis. Meanwhile, as a token for saving his life, Jaqen Hghar offers to kill three people that Arya chooses.")
                .releaseDate("29 Apr 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E6 = Episode.builder()
                .episodeNo(6)
                .title("The Old Gods and the New")
                .description("Theon seizes control of Winterfell. Jon captures a wildling, named Ygritte. The people of Kings Landing begin to turn against King Joffrey. Daenerys looks to buy ships to sail for the Seven Kingdoms.")
                .releaseDate("6 May 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E7 = Episode.builder()
                .episodeNo(7)
                .title("A Man Without Honor")
                .description("Bran and Rickon have escaped Winterfell. Theon tries to hunt them down. Daenerys dragons have been stolen. Jon travels through the wilderness with Ygritte as his prisoner. Sansa has bled and is now ready to have Joffreys children.")
                .releaseDate("13 May 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E8 = Episode.builder()
                .episodeNo(8)
                .title("The Prince of Winterfell")
                .description("Stannis is just days from Kings Landing. Tyrion prepares for his arrival. Jon and Qhorin are taken prisoner by the wildlings. Catelyn is arrested for releasing Jaime. Arya, Gendry, and Hot Pie plan to escape from Harrenhal.")
                .releaseDate("20 May 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E9 = Episode.builder()
                .episodeNo(9)
                .title("Blackwater")
                .description("Stannis Baratheons fleet and army arrive at Kings Landing and the battle for the city begins. Cersei plans for her and her childrens future.")
                .releaseDate("27 May 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Episode episodeT1S2E10 = Episode.builder()
                .episodeNo(10)
                .title("Valar Morghulis")
                .description("Joffrey puts Sansa aside for Margaery Tyrell. Robb marries Talisa Maegyr. Jon prepares to meet Mance Rayder. Arya says farewell to Jaqen Hghar. Daenerys tries to rescue her dragons.")
                .releaseDate("3 Jun 2012")
                .imageUrl(null)
                .season(seasonT1S2)
                .build();

        Season seasonT1S3 = Season.builder()
                .seasonNo(3)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S3E1 = Episode.builder()
                .episodeNo(1)
                .title("Valar Dohaeris")
                .description("Jon is brought before Mance Rayder, the King Beyond the Wall, while the Night's Watch survivors retreat south. In King's Landing, Tyrion asks for his reward. Littlefinger offers Sansa a way out.")
                .releaseDate("31 Mar 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E2 = Episode.builder()
                .episodeNo(2)
                .title("Dark Wings, Dark Words")
                .description("Bran and company meet Jojen and Meera Reed. Arya, Gendry, and Hot Pie meet the Brotherhood. Jaime travels through the wilderness with Brienne. Sansa confesses her true feelings about Joffery to Margaery.")
                .releaseDate("7 Apr 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E3 = Episode.builder()
                .episodeNo(3)
                .title("Walk of Punishment")
                .description("Robb and Catelyn arrive at Riverrun for Lord Hoster Tully's funeral. Tywin names Tyrion the new Master of Coin. Arya says goodbye to Hot Pie. The Night's Watch returns to Craster's. Brienne and Jaime are taken prisoner.")
                .releaseDate("14 Apr 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E4 = Episode.builder()
                .episodeNo(4)
                .title("And Now His Watch Is Ended")
                .description("Jaime mopes over his lost hand. Cersei is growing uncomfortable with the Tyrells. The Night's Watch is growing impatient with Craster. Daenerys buys the Unsullied.")
                .releaseDate("21 Apr 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E5 = Episode.builder()
                .episodeNo(5)
                .title("Kissed by Fire")
                .description("Robb's army is falling apart. Jaime reveals a story, to Brienne, that he has never told anyone. Jon breaks his vows. The Hound is granted his freedom. The Lannisters hatch a new plan")
                .releaseDate("28 Apr 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E6 = Episode.builder()
                .episodeNo(6)
                .title("The Climb")
                .description("Jon and the wildlings scale the Wall. The Brotherhood sells Gendry to Melisandre. Robb does what he can to win back the Freys. Tyrion tells Sansa about their engagement.")
                .releaseDate("5 May 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E7 = Episode.builder()
                .episodeNo(7)
                .title("The Bear and the Maiden Fair")
                .description("Jon and the wildlings travel south of the Wall. Talisa tells Robb that she's pregnant. Arya runs away from the Brotherhood. Daenerys arrives at Yunkai. Jaime leaves Brienne behind at Harrenhal.")
                .releaseDate("12 May 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E8 = Episode.builder()
                .episodeNo(8)
                .title("Second Sons")
                .description("Daenerys tries to persuade the Second Sons to join her against Yunkai. Stannis releases Davos from the dungeons. Sam and Gilly are attacked by a White Walker. Sansa and Tyrion wed.")
                .releaseDate("19 May 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E9 = Episode.builder()
                .episodeNo(9)
                .title("The Rains of Castamere")
                .description("Robb and Catelyn arrive at the Twins for the wedding. Jon is put to the test to see where his loyalties truly lie. Bran's group decides to split up. Daenerys plans an invasion of Yunkai.")
                .releaseDate("2 Jun 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Episode episodeT1S3E10 = Episode.builder()
                .episodeNo(10)
                .title("Mhysa")
                .description("Bran and company travel beyond the Wall. Sam returns to Castle Black. Jon says goodbye to Ygritte. Jaime returns to King's Landing. The Night's Watch asks for help from Stannis.")
                .releaseDate("2 Jun 2013")
                .imageUrl(null)
                .season(seasonT1S3)
                .build();

        Season seasonT1S4 = Season.builder()
                .seasonNo(4)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S4E1 = Episode.builder()
                .episodeNo(1)
                .title("Two Swords")
                .description("Tyrion welcomes a guest to King's Landing. At Castle Black, Jon stands trial. Daenerys is pointed to Meereen, the mother of all slave cities. Arya runs into an old enemy.")
                .releaseDate("6 Apr 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E2 = Episode.builder()
                .episodeNo(2)
                .title("The Lion and the Rose")
                .description("Joffrey and Margaery's wedding has come. Tyrion breaks up with Shae. Ramsay tries to prove his worth to his father. Bran and company find a Weirwood tree.")
                .releaseDate("13 Apr 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E3 = Episode.builder()
                .episodeNo(3)
                .title("Breaker of Chains")
                .description("Tyrion is arrested for the murder of Joffrey and awaits trial. Sansa escapes King's Landing. Sam sends Gilly to Mole's Town as the Night's Watch finds itself in a tight spot. Meereen challenges Daenerys.")
                .releaseDate("20 Apr 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E4 = Episode.builder()
                .episodeNo(4)
                .title("Oathkeeper")
                .description("Jaime entrusts a task to Brienne. Daenerys frees Meereen. Jon is given permission to lead a group of Night's Watchmen to Craster's Keep. Bran and company are taken hostage.")
                .releaseDate("27 Apr 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E5 = Episode.builder()
                .episodeNo(5)
                .title("First of His Name")
                .description("Tommen is crowned King of the Seven Kingdoms. Cersei builds her case against Tyrion. Sansa and Lord Baelish arrive at the Eyrie. The Night's Watch attacks Craster's Keep.")
                .releaseDate("4 May 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E6 = Episode.builder()
                .episodeNo(6)
                .title("The Laws of Gods and Men")
                .description("Tyrion's trial has come. Yara and her troops storm the Dreadfort to free Theon. Daenerys meets Hizdar zo Loraq. Stannis makes a deal with the Iron Bank of Braavos.")
                .releaseDate("11 May 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E7 = Episode.builder()
                .episodeNo(7)
                .title("Mockingbird")
                .description("Tyrion tries to find a champion. Daenerys sleeps with Daario. The Hound becomes wounded. Jon's advice is ignored at Castle Black. Brienne and Podrick receive a tip on Arya's whereabouts.")
                .releaseDate("18 May 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E8 = Episode.builder()
                .episodeNo(8)
                .title("The Mountain and the Viper")
                .description("Theon helps Ramsay seize Moat Cailin. The wildlings attack Mole's Town. Sansa comes up with a story to protect Lord Baelish. Daenerys finds out a secret about Jorah Mormont. Oberyn Martell faces Gregor Clegane, the Mountain.")
                .releaseDate("1 Jun 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E9 = Episode.builder()
                .episodeNo(9)
                .title("The Watchers on the Wall")
                .description("The battle between the Night's Watch and the wildlings has come.")
                .releaseDate("8 Jun 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Episode episodeT1S4E10 = Episode.builder()
                .episodeNo(10)
                .title("The Children")
                .description("Jon makes an important decision. Daenerys experiences new consequences. Brienne and Podrick have an unexpected encounter. Bran achieves a goal, while Tyrion makes an important discovery.")
                .releaseDate("15 Jun 2014")
                .imageUrl(null)
                .season(seasonT1S4)
                .build();

        Season seasonT1S5 = Season.builder()
                .seasonNo(5)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S5E1 = Episode.builder()
                .episodeNo(1)
                .title("The Wars to Come")
                .description("Cersei and Jaime adjust to a world without Tywin. Tyrion and Varys arrive at Pentos. In Meereen, a new enemy emerges. Jon is caught between two kings.")
                .releaseDate("12 Apr 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E2 = Episode.builder()
                .episodeNo(2)
                .title("The House of Black and White")
                .description("Arya arrives in Braavos. Jaime takes on a secret mission. Ellaria Sand seeks revenge for Oberyn's death. Stannis makes Jon a generous offer as the Night's Watch elects a new Lord Commander. Daenerys is faced with a difficult decision.")
                .releaseDate("19 Apr 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E3 = Episode.builder()
                .episodeNo(3)
                .title("High Sparrow")
                .description("Tommen and Margaery wed. Arya has trouble adapting to her new life. Littlefinger reveals his plans to Sansa. Jon gives his first orders as Lord Commander. Tyrion and Varys arrive in Volantis.")
                .releaseDate("26 Apr 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E4 = Episode.builder()
                .episodeNo(4)
                .title("Sons of the Harpy")
                .description("Jorah Mormont sets sail alongside his prisoner, Tyrion. Cersei makes a move against the Tyrells. Jaime and Bronn sneak into Dorne. Ellaria and the Sand Snakes make their plans. Melisandre tempts Jon. The Harpies attack.")
                .releaseDate("3 May 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E5 = Episode.builder()
                .episodeNo(5)
                .title("Kill the Boy")
                .description("Daenerys arrests the heads of Meereen's great families. Jon makes a difficult decision. Theon is forced to face Sansa. Stannis rides south. Tyrion and Jorah enter the ruins of Old Valyria.")
                .releaseDate("10 May 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E6 = Episode.builder()
                .episodeNo(6)
                .title("Unbowed, Unbent, Unbroken")
                .description("Arya is put to the test. Tyrion and Jorah are captured by slavers. Loras Tyrell is judged by the Sparrows. Jaime and Bronn face the Sand Snakes. Sansa marries Ramsay Bolton.")
                .releaseDate("17 May 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E7 = Episode.builder()
                .episodeNo(7)
                .title("The Gift")
                .description("Jon heads east as trouble begins to stir for Sam and Gilly at Castle Black. Sansa asks Theon for help. Tyrion and Jorah are sold as slaves. Cersei savors her triumph over the Tyrells as new plots are developed in the shadows.")
                .releaseDate("24 May 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E8 = Episode.builder()
                .episodeNo(8)
                .title("Hardhome")
                .description("Tyrion advises Daenerys. Sansa forces Theon to tell her a secret. Cersei remains stubborn. Arya meets her first target. Jon and Tormund meet with the wildling elders.")
                .releaseDate("31 May 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E9 = Episode.builder()
                .episodeNo(9)
                .title("The Dance of Dragons")
                .description("Jon and the wildlings return to Castle Black. Jaime meets with Doran Martell. Stannis makes a hard choice. Arya runs into Meryn Trant. Daenerys attends the grand reopening of the fighting pits.")
                .releaseDate("7 Jun 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Episode episodeT1S5E10= Episode.builder()
                .episodeNo(10)
                .title("Mother's Mercy")
                .description("Stannis arrives at Winterfell. Tyrion runs Meereen as Daario and Jorah go after Daenerys. Jaime and Myrcella leave Dorne. Jon sends Sam and Gilly to Oldtown. Arya challenges the Many-Faced God. Cersei confesses her sins.")
                .releaseDate("14 Jun 2015")
                .imageUrl(null)
                .season(seasonT1S5)
                .build();

        Season seasonT1S6 = Season.builder()
                .seasonNo(6)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S6E1= Episode.builder()
                .episodeNo(1)
                .title("The Red Woman")
                .description("The fate of Jon Snow is revealed. Daenerys is brought before Khal Moro. Tyrion gets used to living in Meereen. Ramsay sends his dogs after Theon and Sansa. Ellaria and the Sand Snakes make their move. Cersei mourns for Myrcella.")
                .releaseDate("24 Apr 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E2= Episode.builder()
                .episodeNo(2)
                .title("Home")
                .description("Bran trains with the Three-Eyed Raven. Tommen meets with Cersei. Tyrion makes a bold move. Theon leaves while at Pyke new issues arise. Ramsay's brother is born. Davos asks Melisandre for a miracle.")
                .releaseDate("1 May 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E3= Episode.builder()
                .episodeNo(3)
                .title("Oathbreaker")
                .description("Daenerys arrives at Vaes Dothrak. Sam and Gilly sail for Horn Hill. Arya trains as No One. Varys finds information on the Sons of the Harpy. Ramsay receives a gift. Tommen meets with the High Sparrow. At Castle Black, a miracle occurs.")
                .releaseDate("8 May 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E4= Episode.builder()
                .episodeNo(4)
                .title("Book of the Stranger")
                .description("Sansa arrives at Castle Black. Tyrion makes a deal with the slave masters. Jorah and Daario sneak into Vaes Dothrak. Ramsay sends a letter to Jon. Theon arrives at Pyke. Cersei and Olenna Tyrell plot against the High Sparrow.")
                .releaseDate("15 May 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();


        Episode episodeT1S6E5= Episode.builder()
                .episodeNo(5)
                .title("The Door")
                .description("Sansa and Jon make plans. Arya is given another chance to prove herself. Jorah confesses a secret to Daenerys. Tyrion meets with a red priestess. Yara finds her rule tested. Bran discovers the origin of the White Walkers.")
                .releaseDate("22 May 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E6= Episode.builder()
                .episodeNo(6)
                .title("Blood of My Blood")
                .description("Bran and Meera find a new ally. Gilly meets Sam's family. Arya makes a difficult choice. The Lannisters and Tyrells march against the High Sparrow.")
                .releaseDate("29 May 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E7= Episode.builder()
                .episodeNo(7)
                .title("The Broken Man")
                .description("Jon and Sansa gather troops. Jaime arrives at Riverrun. Olenna Tyrell plans to leave King's Landing. Theon and Yara plan a destination. Arya makes plans to leave.")
                .releaseDate("5 Jun 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E8= Episode.builder()
                .episodeNo(8)
                .title("No One")
                .description("Brienne arrives at Riverrun. Arya seeks shelter. Jaime meets with Edmure Tully. Cersei challenges the Faith. Sandor Clegane hunts for revenge. Tyrion faces the consequences of earlier decisions.")
                .releaseDate("12 Jun 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E9= Episode.builder()
                .episodeNo(9)
                .title("Battle of the Bastards")
                .description("Jon and Sansa face Ramsay Bolton on the fields of Winterfell. Daenerys strikes back at her enemies. Theon and Yara arrive in Meereen.")
                .releaseDate("19 Jun 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Episode episodeT1S6E10= Episode.builder()
                .episodeNo(10)
                .title("The Winds of Winter")
                .description("Cersei and Loras Tyrell stand trial by the gods. Daenerys prepares to set sail for Westeros. Davos confronts Melisandre. Sam and Gilly arrive in the Citadel. Bran discovers a long-kept secret. Lord Frey has an uninvited guest.")
                .releaseDate("26 Jun 2016")
                .imageUrl(null)
                .season(seasonT1S6)
                .build();

        Season seasonT1S7 = Season.builder()
                .seasonNo(7)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S7E1= Episode.builder()
                .episodeNo(1)
                .title("Dragonstone")
                .description("Jon organizes the North's defenses. Cersei tries to even the odds. Daenerys comes home. Arya reminds the Freys \"the North remembers.\" Sam adapts to life in Oldtown. The Night King makes his way south.")
                .releaseDate("16 Jul 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E2= Episode.builder()
                .episodeNo(2)
                .title("Stormborn")
                .description("Daenerys receives an unexpected visitor. Jon faces resistance. Tyrion plans the conquest of Westeros. Cersei gathers her allies. Arya has a reunion with old friends. Sam risks his career and life.")
                .releaseDate("23 Jul 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E3= Episode.builder()
                .episodeNo(3)
                .title("The Queen's Justice")
                .description("Jon and Daenerys finally meet. Cersei gains a new ally. Sansa receives an unexpected visitor. Sam is confronted for his actions.")
                .releaseDate("30 Jul 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E4= Episode.builder()
                .episodeNo(4)
                .title("The Spoils of War")
                .description("Daenerys takes matters into her own hands. Arya reaches her destination. Jaime and Bronn collect the spoils from the war with the Tyrells.")
                .releaseDate("6 Aug 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E5= Episode.builder()
                .episodeNo(5)
                .title("Eastwatch")
                .description("Daenerys demands loyalty from the surviving Lannister soldiers; Jon heeds Bran's warning about White Walkers on the move; Cersei vows to vanquish anyone or anything that stands in her way.")
                .releaseDate("13 Aug 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E6= Episode.builder()
                .episodeNo(6)
                .title("Beyond the Wall")
                .description("Jon and his team go beyond the wall to capture a wight. Daenerys has to make a tough decision.")
                .releaseDate("20 Aug 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Episode episodeT1S7E7= Episode.builder()
                .episodeNo(7)
                .title("The Dragon and the Wolf")
                .description("Everyone meets in King's Landing to discuss the fate of the realm. In Winterfell, Sansa confronts Arya. Sam reaches Winterfell, where he and Bran discover a shocking secret about Jon Snow.")
                .releaseDate("27 Aug 2017")
                .imageUrl(null)
                .season(seasonT1S7)
                .build();

        Season seasonT1S8 = Season.builder()
                .seasonNo(8)
                .tvSeries(tvSeries1)
                .build();

        Episode episodeT1S8E1= Episode.builder()
                .episodeNo(1)
                .title("Winterfell")
                .description("Jon and Daenerys arrive in Winterfell and are met with skepticism. Sam learns about the fate of his family. Cersei gives Euron the reward he aims for. Theon follows his heart.")
                .releaseDate("14 Apr 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        Episode episodeT1S8E2= Episode.builder()
                .episodeNo(2)
                .title("Winterfell")
                .description("Jon and Daenerys arrive in Winterfell and are met with skepticism. Sam learns about the fate of his family. Cersei gives Euron the reward he aims for. Theon follows his heart.")
                .releaseDate("14 Apr 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        Episode episodeT1S8E3= Episode.builder()
                .episodeNo(3)
                .title("A Knight of the Seven Kingdoms")
                .description("Jaime faces judgment and Winterfell prepares for the battle to come.")
                .releaseDate("21 Apr 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        Episode episodeT1S8E4= Episode.builder()
                .episodeNo(4)
                .title("The Long Night")
                .description("The Night King and his army have arrived at Winterfell and the great battle begins.")
                .releaseDate("28 Apr 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        Episode episodeT1S8E5= Episode.builder()
                .episodeNo(5)
                .title("The Bells")
                .description("Forces have arrived at King's Landing for the final battle.")
                .releaseDate("12 May 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        Episode episodeT1S8E6 = Episode.builder()
                .episodeNo(6)
                .title("The Iron Throne")
                .description("In the aftermath of the devastating attack on King's Landing, Daenerys must face the survivors.")
                .releaseDate("19 May 2019")
                .imageUrl(null)
                .season(seasonT1S8)
                .build();

        tVSeriesRepository.save(tvSeries1);
        creatorRepository.save(creatorT1C1);
        creatorRepository.save(creatorT1C2);
        seasonRepository.save(seasonT1S1);
        episodeRepository.save(episodeT1S1E1);
        episodeRepository.save(episodeT1S1E2);
        episodeRepository.save(episodeT1S1E3);
        episodeRepository.save(episodeT1S1E4);
        episodeRepository.save(episodeT1S1E5);
        episodeRepository.save(episodeT1S1E6);
        episodeRepository.save(episodeT1S1E7);
        episodeRepository.save(episodeT1S1E8);
        episodeRepository.save(episodeT1S1E9);
        episodeRepository.save(episodeT1S1E10);
        seasonRepository.save(seasonT1S2);
        episodeRepository.save(episodeT1S2E1);
        episodeRepository.save(episodeT1S2E2);
        episodeRepository.save(episodeT1S2E3);
        episodeRepository.save(episodeT1S2E4);
        episodeRepository.save(episodeT1S2E5);
        episodeRepository.save(episodeT1S2E6);
        episodeRepository.save(episodeT1S2E7);
        episodeRepository.save(episodeT1S2E8);
        episodeRepository.save(episodeT1S2E9);
        episodeRepository.save(episodeT1S2E10);
        seasonRepository.save(seasonT1S3);
        episodeRepository.save(episodeT1S3E1);
        episodeRepository.save(episodeT1S3E2);
        episodeRepository.save(episodeT1S3E3);
        episodeRepository.save(episodeT1S3E4);
        episodeRepository.save(episodeT1S3E5);
        episodeRepository.save(episodeT1S3E6);
        episodeRepository.save(episodeT1S3E7);
        episodeRepository.save(episodeT1S3E8);
        episodeRepository.save(episodeT1S3E9);
        episodeRepository.save(episodeT1S3E10);
        seasonRepository.save(seasonT1S4);
        episodeRepository.save(episodeT1S4E1);
        episodeRepository.save(episodeT1S4E2);
        episodeRepository.save(episodeT1S4E3);
        episodeRepository.save(episodeT1S4E4);
        episodeRepository.save(episodeT1S4E5);
        episodeRepository.save(episodeT1S4E6);
        episodeRepository.save(episodeT1S4E7);
        episodeRepository.save(episodeT1S4E8);
        episodeRepository.save(episodeT1S4E9);
        episodeRepository.save(episodeT1S4E10);
        seasonRepository.save(seasonT1S5);
        episodeRepository.save(episodeT1S5E1);
        episodeRepository.save(episodeT1S5E2);
        episodeRepository.save(episodeT1S5E3);
        episodeRepository.save(episodeT1S5E4);
        episodeRepository.save(episodeT1S5E5);
        episodeRepository.save(episodeT1S5E6);
        episodeRepository.save(episodeT1S5E7);
        episodeRepository.save(episodeT1S5E8);
        episodeRepository.save(episodeT1S5E9);
        episodeRepository.save(episodeT1S5E10);
        seasonRepository.save(seasonT1S6);
        episodeRepository.save(episodeT1S6E1);
        episodeRepository.save(episodeT1S6E2);
        episodeRepository.save(episodeT1S6E3);
        episodeRepository.save(episodeT1S6E4);
        episodeRepository.save(episodeT1S6E5);
        episodeRepository.save(episodeT1S6E6);
        episodeRepository.save(episodeT1S6E7);
        episodeRepository.save(episodeT1S6E8);
        episodeRepository.save(episodeT1S6E9);
        episodeRepository.save(episodeT1S6E10);
        seasonRepository.save(seasonT1S7);
        episodeRepository.save(episodeT1S7E1);
        episodeRepository.save(episodeT1S7E2);
        episodeRepository.save(episodeT1S7E3);
        episodeRepository.save(episodeT1S7E4);
        episodeRepository.save(episodeT1S7E5);
        episodeRepository.save(episodeT1S7E6);
        episodeRepository.save(episodeT1S7E7);
        seasonRepository.save(seasonT1S8);
        episodeRepository.save(episodeT1S8E1);
        episodeRepository.save(episodeT1S8E2);
        episodeRepository.save(episodeT1S8E3);
        episodeRepository.save(episodeT1S8E4);
        episodeRepository.save(episodeT1S8E5);
        episodeRepository.save(episodeT1S8E6);
        genreRepository.save(genreC7G1);
        genreRepository.save(genreC7G2);
        genreRepository.save(genreC7G3);
        actorRepository.save(actorC7A1);
        actorRepository.save(actorC7A2);
        actorRepository.save(actorC7A3);

        //endregion

        //region Content 8
        //-----------------Content 8----------------//
        Content content8 = Content.builder()
                .title("All Quiet on the Western Front")
                .description("A young German soldier's terrifying experiences and distress on the western front during World War I.")
                .spokenLanguage("German")
                .releaseDate("28 Oct 2022")
                .imageUrl("https://images5.alphacoders.com/128/1288456.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/hf8EYbVxtCY\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.MOVIE)
                .runtime(148)
                .build();

        Genre genreC8G1 = Genre.builder()
                .name("Action")
                .content(content8)
                .build();

        Genre genreC8G2 = Genre.builder()
                .name("Drama")
                .content(content8)
                .build();

        Genre genreC8G3 = Genre.builder()
                .name("War")
                .content(content8)
                .build();

        Actor actorC8A1 = Actor.builder()
                .fullname("Felix Kammerer")
                .imageUrl(null)
                .content(content8)
                .build();

        Actor actorC8A2 = Actor.builder()
                .fullname("Albrecht Schuch")
                .imageUrl(null)
                .content(content8)
                .build();

        Actor actorC8A3 = Actor.builder()
                .fullname("Aaron Hilmer")
                .imageUrl(null)
                .content(content8)
                .build();

        Movie movie7 = Movie.builder()
                .content(content8)
                .build();

        Writer writerM7W1 = Writer.builder()
                .fullname("Edward Berger")
                .imageUrl(null)
                .movie(movie6)
                .build();

        Writer writerM7W2 = Writer.builder()
                .fullname("Lesley Paterson")
                .imageUrl(null)
                .movie(movie6)
                .build();

        Writer writerM7W3 = Writer.builder()
                .fullname("Ian Stokell")
                .imageUrl(null)
                .movie(movie6)
                .build();

        Director directorM7D1 = Director.builder()
                .fullname("Edward Berger")
                .imageUrl(null)
                .movie(movie7)
                .build();


        movieRepository.save(movie7);
        genreRepository.save(genreC8G1);
        genreRepository.save(genreC8G2);
        genreRepository.save(genreC8G3);
        actorRepository.save(actorC8A1);
        actorRepository.save(actorC8A2);
        actorRepository.save(actorC8A3);
        writerRepository.save(writerM7W1);
        writerRepository.save(writerM7W2);
        writerRepository.save(writerM7W3);
        directorRepository.save(directorM7D1);
        //endregion

        //region Content 9
        //-----------------Content 9----------------//
        Content content9 = Content.builder()
                .title("Howl's Moving Castle")
                .description("When an unconfident young woman is cursed with an old body by a spiteful witch, her only chance of breaking the spell lies with a self-indulgent yet insecure young wizard and his companions in his legged, walking castle.")
                .spokenLanguage("Japanese")
                .releaseDate("17 Jun 2005")
                .imageUrl("https://images7.alphacoders.com/113/1137731.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iwROgK94zcM\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(119)
                .build();

        Genre genreC9G1 = Genre.builder()
                .name("Animation")
                .content(content9)
                .build();

        Genre genreC9G2 = Genre.builder()
                .name("Adventure")
                .content(content9)
                .build();

        Genre genreC9G3 = Genre.builder()
                .name("Family")
                .content(content9)
                .build();

        Actor actorC9A1 = Actor.builder()
                .fullname("Chieko Baishô")
                .imageUrl(null)
                .content(content8)
                .build();

        Actor actorC9A2 = Actor.builder()
                .fullname("Takuya Kimura")
                .imageUrl(null)
                .content(content9)
                .build();

        Actor actorC9A3 = Actor.builder()
                .fullname("Tatsuya Gashûin")
                .imageUrl(null)
                .content(content9)
                .build();

        Movie movie8 = Movie.builder()
                .content(content9)
                .build();

        Writer writerM8W1 = Writer.builder()
                .fullname("Hayao Miyazaki")
                .imageUrl(null)
                .movie(movie8)
                .build();

        Writer writerM8W2 = Writer.builder()
                .fullname("Diana Wynne Jones")
                .imageUrl(null)
                .movie(movie8)
                .build();


        Director directorM8D1 = Director.builder()
                .fullname("Hayao Miyazaki")
                .imageUrl(null)
                .movie(movie8)
                .build();


        movieRepository.save(movie8);
        genreRepository.save(genreC9G1);
        genreRepository.save(genreC9G2);
        genreRepository.save(genreC9G3);
        actorRepository.save(actorC9A1);
        actorRepository.save(actorC9A2);
        actorRepository.save(actorC9A3);
        writerRepository.save(writerM8W1);
        writerRepository.save(writerM8W2);
        directorRepository.save(directorM8D1);
        //endregion

        //region Content 10
        //-----------------Content 10----------------//
        Content content10 = Content.builder()
                .title("The Terminal")
                .description("An Eastern European tourist unexpectedly finds himself stranded in JFK airport, and must take up temporary residence there.")
                .spokenLanguage("English")
                .releaseDate("18 Jun 2004")
                .imageUrl("https://images6.alphacoders.com/652/652954.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iZqQRmhRvyg\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(119)
                .build();

        Genre genreC10G1 = Genre.builder()
                .name("Comedy")
                .content(content10)
                .build();

        Genre genreC10G2 = Genre.builder()
                .name("Drama")
                .content(content10)
                .build();

        Genre genreC10G3 = Genre.builder()
                .name("Romance")
                .content(content10)
                .build();

        Actor actorC10A1 = Actor.builder()
                .fullname("Tom Hanks")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fb/Tom_Hanks_2016.jpg")
                .content(content10)
                .build();

        Actor actorC10A2 = Actor.builder()
                .fullname("Catherine Zeta-Jones")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Catherine_Zeta-Jones_VF_2012_Shankbone_2.jpg/800px-Catherine_Zeta-Jones_VF_2012_Shankbone_2.jpg")
                .content(content10)
                .build();

        Actor actorC10A3 = Actor.builder()
                .fullname("Chi McBride")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/1/13/Chi_McBride_2.jpg")
                .content(content10)
                .build();

        Movie movie9 = Movie.builder()
                .content(content10)
                .build();

        Writer writerM9W1 = Writer.builder()
                .fullname("Andrew Niccol")
                .imageUrl(null)
                .movie(movie9)
                .build();

        Writer writerM9W2 = Writer.builder()
                .fullname("Sacha Gervasi")
                .imageUrl(null)
                .movie(movie9)
                .build();

        Writer writerM9W3 = Writer.builder()
                .fullname("Jeff Nathanson")
                .imageUrl(null)
                .movie(movie9)
                .build();


        Director directorM9D1 = Director.builder()
                .fullname("Steven Spielberg")
                .imageUrl(null)
                .movie(movie9)
                .build();


        movieRepository.save(movie9);
        genreRepository.save(genreC10G1);
        genreRepository.save(genreC10G2);
        genreRepository.save(genreC10G3);
        actorRepository.save(actorC10A1);
        actorRepository.save(actorC10A2);
        actorRepository.save(actorC10A3);
        writerRepository.save(writerM9W1);
        writerRepository.save(writerM9W2);
        writerRepository.save(writerM9W2);
        directorRepository.save(directorM9D1);
        //endregion

        //region Content 11
        //-----------------Content 11----------------//
        Content content11 = Content.builder()
                .title("Django Unchained")
                .description("With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi.")
                .spokenLanguage("English")
                .releaseDate("25 Dec 2012")
                .imageUrl("https://images6.alphacoders.com/652/652954.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iZqQRmhRvyg\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.MOVIE)
                .runtime(165)
                .build();

        Genre genreC11G1 = Genre.builder()
                .name("Drama")
                .content(content11)
                .build();

        Genre genreC11G2 = Genre.builder()
                .name("Western")
                .content(content11)
                .build();

        Actor actorC11A1 = Actor.builder()
                .fullname("Jamie Foxx")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/e/ed/Jamie_Foxx_Django_avp.jpg")
                .content(content11)
                .build();

        Actor actorC11A2 = Actor.builder()
                .fullname("Christoph Waltz")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/d/d8/Christoph_Waltz_Viennale_2017_f_%28cropped%29.jpg")
                .content(content11)
                .build();

        Actor actorC11A3 = Actor.builder()
                .fullname("Leonardo DiCaprio")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/2/25/Leonardo_DiCaprio_2014.jpg")
                .content(content11)
                .build();

        Movie movie10 = Movie.builder()
                .content(content11)
                .build();

        Writer writerM10W1 = Writer.builder()
                .fullname("Quentin Tarantino")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/0/0b/Quentin_Tarantino_by_Gage_Skidmore.jpg")
                .movie(movie10)
                .build();

        Director directorM10D1 = Director.builder()
                .fullname("Quentin Tarantino")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/0/0b/Quentin_Tarantino_by_Gage_Skidmore.jpg")
                .movie(movie10)
                .build();


        movieRepository.save(movie10);
        genreRepository.save(genreC11G1);
        genreRepository.save(genreC11G2);
        actorRepository.save(actorC11A1);
        actorRepository.save(actorC11A2);
        actorRepository.save(actorC11A3);
        writerRepository.save(writerM10W1);
        directorRepository.save(directorM10D1);
        //endregion

        //region Content 12
        //-----------------Content 12----------------//
        Content content12 = Content.builder()
                .title("Peaky Blinders")
                .description("A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.")
                .spokenLanguage("English")
                .releaseDate("30 Sep 2014")
                .imageUrl("https://images.alphacoders.com/125/1254595.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/oVzVdvGIC7U\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.TV_SERIES)
                .runtime(60)
                .build();

        Genre genreC12G1 = Genre.builder()
                .name("Crime")
                .content(content12)
                .build();

        Genre genreC12G2 = Genre.builder()
                .name("Drama")
                .content(content12)
                .build();

        Actor actorC12A1 = Actor.builder()
                .fullname("Cillian Murphy")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg")
                .content(content12)
                .build();

        Actor actorC12A2 = Actor.builder()
                .fullname("Paul Anderson")
                .imageUrl(null)
                .content(content12)
                .build();

        Actor actorC12A3 = Actor.builder()
                .fullname("Sophie Rundle")
                .imageUrl(null)
                .content(content12)
                .build();

        TVSeries tvSeries2 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content12)
                .build();

        Creator creatorT2C1 = Creator.builder()
                .fullname("Steven Knight")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/f9/Portrait_of_Steven_Knight_by_Taylor_Rooke%2C_March_5th_2020.jpg")
                .tvSeries(tvSeries2)
                .build();


        Season seasonT2S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #1.1")
                .description("Thomas Shelby plans to fix a horse race; some guns turn up stolen.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Episode episodeT2S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #1.2")
                .description("Thomas Shelby starts a feud with a gypsy family and finally meets with Inspector Campbell to talk about the stolen guns.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Episode episodeT2S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #1.3")
                .description("Thomas is livid to find out that Ada and Freddie are married; IRA sympathizers tries to get information from Thomas about the stolen guns.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Episode episodeT2S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #1.4")
                .description("Thomas attempts to make a deal with Campbell; The Peaky's war with the Lees intensifies.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Episode episodeT2S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #1.5")
                .description("The Shelbys get a surprise visit by an almost forgotten relative. Thomas has one more dangerous plan with the cops.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Episode episodeT2S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #1.6")
                .description("Tommy and the Peaky Blinders prepare for a big operation, that quickly becomes way trickier than they thought.")
                .releaseDate("30 Sep. 2014")
                .imageUrl(null)
                .season(seasonT2S1)
                .build();

        Season seasonT2S2 = Season.builder()
                .seasonNo(2)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S2E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #2.1")
                .description("When Birmingham crime boss Tommy Shelby's beloved Garrison pub is bombed, he finds himself blackmailed into murdering an Irish dissident.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Episode episodeT2S2E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #2.2")
                .description("After murdering an Irish dissident, Tommy has no choice but to be a pawn in Inspector Campbell's treacherous political game.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Episode episodeT2S2E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #2.3")
                .description("After joining London crime boss Alfie Solomons in a business venture, Tommy worries that Alfie's newly revealed volatility could pose a problem.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Episode episodeT2S2E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #2.4")
                .description("The Peaky Blinders take over London's Eden Club; Sabini convinces his old adversary Alfie Solomons to join forces and eradicate the gang.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Episode episodeT2S2E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #2.5")
                .description("The Peaky Blinders are under attack. Tommy's power base in London is obliterated, and both Arthur and Michael are arrested and imprisoned.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Episode episodeT2S2E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #2.6")
                .description("Tommy plans to execute the mission given to him by Campbell: the assassination of a high-ranking member of the military establishment.")
                .releaseDate("2 Oct 2014")
                .imageUrl(null)
                .season(seasonT2S2)
                .build();

        Season seasonT2S3 = Season.builder()
                .seasonNo(3)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S3E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #3.1")
                .description("It is Thomas Shelby's long-awaited wedding day. A mysterious visitor imperils the entire Shelby family, and Tommy finds himself pulled into a web of intrigue more lethal than anything he has yet encountered.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Episode episodeT2S3E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #3.2")
                .description("Tommy discovers the extent of the mission given to him and the extreme lengths his new paymasters are willing to go to in their quest for power. Meanwhile his own family's activities lead to escalating danger in Birmingham.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Episode episodeT2S3E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #3.3")
                .description("Tommy travels to Wales seeking absolution and uncovers a traitor in the Economic League. Michael develops a taste for guns. Arthur gets good news.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Episode episodeT2S3E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #3.4")
                .description("Polly goes to confession, igniting a chain of events that reveals a trap being laid at the Shelbys' expense. Tommy plans an exit from dirty business.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Episode episodeT2S3E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #3.5")
                .description("As the Russians test the Peaky Blinders, Tommy realises that he is seriously outmaneuvered. But he has an ace up his sleeve.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Episode episodeT2S3E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #3.6")
                .description("As Tommy prepares to commit the most audacious crime of his career, an unexpected blow forces him to face his worst fears in a race against time.")
                .releaseDate("31 May 2016")
                .imageUrl(null)
                .season(seasonT2S3)
                .build();

        Season seasonT2S4 = Season.builder()
                .seasonNo(4)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S4E1 = Episode.builder()
                .episodeNo(1)
                .title("The Noose")
                .description("It is Christmas and Tommy Shelby receives a letter that makes him realize that he and every member of the family are in danger. He knows that it is time for the family to bury their differences and face the enemy together.")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Episode episodeT2S4E2 = Episode.builder()
                .episodeNo(2)
                .title("Heathens")
                .description("As the Shelbys come to terms with shocking events, Tommy makes a decision he may come to regret. Meanwhile, a bold new enemy makes his move.")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Episode episodeT2S4E3 = Episode.builder()
                .episodeNo(3)
                .title("Blackbird")
                .description("Luca Changretta understands the complexity of his enemy, as the weight of gypsy tradition hangs upon Arthur. But could there be a traitor within the Peaky Blinders' midst?")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Episode episodeT2S4E4 = Episode.builder()
                .episodeNo(4)
                .title("Dangerous")
                .description("In a daring cat and mouse chase, will Tommy be outwitted by his enemies? And with the return of an old friend, Tommy tries to distract himself with other pursuits.")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Episode episodeT2S4E5 = Episode.builder()
                .episodeNo(5)
                .title("The Duel")
                .description("Tommy prepares himself as the bloody battle lines are drawn between the Peaky Blinders and Changretta. A deal is struck - with potentially devastating consequences.")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Episode episodeT2S4E6 = Episode.builder()
                .episodeNo(6)
                .title("The Company")
                .description("During the fight between Goliath and Bonnie Gold events escalate. Then Audrey Changretta appears at a funeral, waving a white flag. She proposes to declare the Vendetta between her family and the Shelbys settled. And she names her price.")
                .releaseDate("21 Dec 2017")
                .imageUrl(null)
                .season(seasonT2S4)
                .build();

        Season seasonT2S5 = Season.builder()
                .seasonNo(5)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S5E1 = Episode.builder()
                .episodeNo(1)
                .title("Black Tuesday")
                .description("In the wake of the Wall Street Crash, Tommy faces new dangers from unexpected quarters.")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();

        Episode episodeT2S5E2 = Episode.builder()
                .episodeNo(2)
                .title("Black Cats")
                .description("As the Peaky Blinders come under fire, Tommy is warned about a traitor in his midst.")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();

        Episode episodeT2S5E3 = Episode.builder()
                .episodeNo(3)
                .title("Strategy")
                .description("As the charismatic Mosley shows his hand, Tommy makes a treacherous new alliance.")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();

        Episode episodeT2S5E4 = Episode.builder()
                .episodeNo(4)
                .title("The Loop")
                .description("Tommy agrees to dangerous new partnerships, and a Shelby party promises fireworks.")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();


        Episode episodeT2S5E5 = Episode.builder()
                .episodeNo(5)
                .title("The Shock")
                .description("As Tommy reveals his intentions for Mosley, someone close to the Shelbys is targeted.")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();

        Episode episodeT2S5E6 = Episode.builder()
                .episodeNo(6)
                .title("Mr. Jones")
                .description("Family tensions surface after an unexpected announcement. Tommy puts his plan for Oswald Mosley into action, but has he underestimated his opponent?")
                .releaseDate("4 Oct 2019")
                .imageUrl(null)
                .season(seasonT2S5)
                .build();

        Season seasonT2S6 = Season.builder()
                .seasonNo(6)
                .tvSeries(tvSeries2)
                .build();

        Episode episodeT2S6E1 = Episode.builder()
                .episodeNo(1)
                .title("Black Day")
                .description("Tommy sets off to North America, where the end of Prohibition brings new opportunities. But he faces new danger from an old adversary who is finally making his move.")
                .releaseDate("27 Feb 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        Episode episodeT2S6E2 = Episode.builder()
                .episodeNo(2)
                .title("Black Shirt")
                .description("Tommy gets involved in a power game with fascists, freedom fighters and Boston gangsters. As the players plan to double cross him, Tommy visits an old ally in Camden.")
                .releaseDate("6 Mar 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        Episode episodeT2S6E3 = Episode.builder()
                .episodeNo(3)
                .title("Gold")
                .description("Faced with devastating news, Tommy goes on a quest to discover who it was that placed a curse on his family. In Birmingham, Ada takes charge, and Arthur takes on some new recruits")
                .releaseDate("13 Mar 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        Episode episodeT2S6E4 = Episode.builder()
                .episodeNo(4)
                .title("Sapphire")
                .description("Tommy establishes a connection between crime and political power that could alter the course of history. He also receives life-changing news from an unexpected source.")
                .releaseDate("20 Mar 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        Episode episodeT2S6E5 = Episode.builder()
                .episodeNo(5)
                .title("The Road to Hell")
                .description("In the light of extraordinary personal revelations, Tommy takes a course of action that will change everything. Meanwhile, his enemies' plans start to fall into place.")
                .releaseDate("27 Mar 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        Episode episodeT2S6E6 = Episode.builder()
                .episodeNo(6)
                .title("The Road to Hell")
                .description("As the clouds of the coming storm gather, Tommy Shelby faces the consequences of his experiences and his actions")
                .releaseDate("3 Apr 2022")
                .imageUrl(null)
                .season(seasonT2S6)
                .build();

        tVSeriesRepository.save(tvSeries2);
        creatorRepository.save(creatorT2C1);
        seasonRepository.save(seasonT2S1);
        episodeRepository.save(episodeT2S1E1);
        episodeRepository.save(episodeT2S1E2);
        episodeRepository.save(episodeT2S1E3);
        episodeRepository.save(episodeT2S1E4);
        episodeRepository.save(episodeT2S1E5);
        episodeRepository.save(episodeT2S1E6);
        seasonRepository.save(seasonT2S2);
        episodeRepository.save(episodeT2S2E1);
        episodeRepository.save(episodeT2S2E2);
        episodeRepository.save(episodeT2S2E3);
        episodeRepository.save(episodeT2S2E4);
        episodeRepository.save(episodeT2S2E5);
        episodeRepository.save(episodeT2S2E6);
        seasonRepository.save(seasonT2S3);
        episodeRepository.save(episodeT2S3E1);
        episodeRepository.save(episodeT2S3E2);
        episodeRepository.save(episodeT2S3E3);
        episodeRepository.save(episodeT2S3E4);
        episodeRepository.save(episodeT2S3E5);
        episodeRepository.save(episodeT2S3E6);
        seasonRepository.save(seasonT2S4);
        episodeRepository.save(episodeT2S4E1);
        episodeRepository.save(episodeT2S4E2);
        episodeRepository.save(episodeT2S4E3);
        episodeRepository.save(episodeT2S4E4);
        episodeRepository.save(episodeT2S4E5);
        episodeRepository.save(episodeT2S4E6);
        seasonRepository.save(seasonT2S5);
        episodeRepository.save(episodeT2S5E1);
        episodeRepository.save(episodeT2S5E2);
        episodeRepository.save(episodeT2S5E3);
        episodeRepository.save(episodeT2S5E4);
        episodeRepository.save(episodeT2S5E5);
        episodeRepository.save(episodeT2S5E6);
        seasonRepository.save(seasonT2S6);
        episodeRepository.save(episodeT2S6E1);
        episodeRepository.save(episodeT2S6E2);
        episodeRepository.save(episodeT2S6E3);
        episodeRepository.save(episodeT2S6E4);
        episodeRepository.save(episodeT2S6E5);
        episodeRepository.save(episodeT2S6E6);
        genreRepository.save(genreC12G1);
        genreRepository.save(genreC12G2);
        actorRepository.save(actorC12A1);
        actorRepository.save(actorC12A2);
        actorRepository.save(actorC12A3);

        //endregion
    }
}
