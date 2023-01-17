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
    private final RatingRepository ratingRepository;


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
                .cardExpirationDate("12/2025")
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
                .cardExpirationDate("05/2030")
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
                .cardExpirationDate("03/2027")
                .cardType(CardType.MASTERCARD)
                .account(account3)
                .build();

        CreditCard creditCardA3C2 = CreditCard.builder()
                .cardNo("6319087600983084")
                .cardCvc("574")
                .cardName("Rachel Green")
                .cardExpirationDate("01/2040")
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
                .cardExpirationDate("03/2042")
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
        //-----------------Account 4----------------//
        Account account5 = Account.builder()
                .email("aris95@hotmail.com")
                .username("aris")
                .firstname("Aristarxos")
                .lastname("Aximastos")
                .password("password")
                .phoneNo("7826496165")
                .subscriptionType(SubscriptionType.STANDARD)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA5P1 = Profile.builder()
                .firstname("Aris")
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


        CreditCard creditCardA5C1 = CreditCard.builder()
                .cardNo("6505241792470006")
                .cardCvc("987")
                .cardName("Aristarxos Aximastos")
                .cardExpirationDate("07/2035")
                .cardType(CardType.MASTERCARD)
                .account(account5)
                .build();


        Address addressA5A1 = Address.builder()
                .country("Greece")
                .postalCode("15561")
                .streetName("Voutsina")
                .province("Holargos")
                .streetNo("29")
                .account(account5)
                .build();




        accountRepository.save(account5);
        profileRepository.save(profileA5P1);
        profileRepository.save(profileA5P2);
        creditCardRepository.save(creditCardA5C1);
        addressRepository.save(addressA5A1);
        //endregion

        //region Account 6
        //-----------------Account 6----------------//
        Account account6 = Account.builder()
                .email("john@hotmail.com")
                .username("john")
                .firstname("John")
                .lastname("Papageorgiou")
                .password("5678")
                .phoneNo("04894544334")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA6P1 = Profile.builder()
                .firstname("John")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account6)
                .build();

        Profile profileA6P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account6)
                .build();

        Profile profileA6P3 = Profile.builder()
                .firstname("Helen")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account6)
                .build();


        CreditCard creditCardA6C1 = CreditCard.builder()
                .cardNo("4514143755894494")
                .cardCvc("301")
                .cardName("John Papageorgiou")
                .cardExpirationDate("04/2032")
                .cardType(CardType.VISA)
                .account(account6)
                .build();

        CreditCard creditCardA6C2 = CreditCard.builder()
                .cardNo("6505232716586258")
                .cardCvc("777")
                .cardName("Helen Papageorgiou")
                .cardExpirationDate("03/2027")
                .cardType(CardType.PAYPAL)
                .account(account6)
                .build();


        Address addressA6A1 = Address.builder()
                .country("Greece")
                .postalCode("15561")
                .streetName("Sarandaporou")
                .province("Holargos")
                .streetNo("72")
                .account(account6)
                .build();


        accountRepository.save(account6);
        profileRepository.save(profileA6P1);
        profileRepository.save(profileA6P2);
        profileRepository.save(profileA6P3);
        creditCardRepository.save(creditCardA6C1);
        creditCardRepository.save(creditCardA6C2);
        addressRepository.save(addressA6A1);
        //endregion

        //region Account 7
        //-----------------Account 7----------------//
        Account account7 = Account.builder()
                .email("maria75@hotmail.com")
                .username("maria")
                .firstname("Maria")
                .lastname("Georgiou")
                .password("9999")
                .phoneNo("04694544334")
                .subscriptionType(SubscriptionType.STANDARD)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA7P1 = Profile.builder()
                .firstname("Maria")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account7)
                .build();

        Profile profileA7P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account7)
                .build();


        CreditCard creditCardA7C1 = CreditCard.builder()
                .cardNo("4514121755894494")
                .cardCvc("444")
                .cardName("Maria Georgiou")
                .cardExpirationDate("02/2031")
                .cardType(CardType.AMERICAN_EXPRESS)
                .account(account7)
                .build();


        Address addressA7A1 = Address.builder()
                .country("Greece")
                .postalCode("15569")
                .streetName("Sokratous")
                .province("Halandri")
                .streetNo("21")
                .account(account7)
                .build();


        accountRepository.save(account7);
        profileRepository.save(profileA7P1);
        profileRepository.save(profileA7P2);
        creditCardRepository.save(creditCardA7C1);
        addressRepository.save(addressA7A1);
        //endregion

        //region Account 8
        //-----------------Account 8----------------//
        Account account8 = Account.builder()
                .email("sotos@hotmail.com")
                .username("sotos")
                .firstname("Sotiris")
                .lastname("Bikos")
                .password("171717")
                .phoneNo("04694894334")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA8P1 = Profile.builder()
                .firstname("Sotos")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account8)
                .build();

        Profile profileA8P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account8)
                .build();


        CreditCard creditCardA8C1 = CreditCard.builder()
                .cardNo("4514121905894494")
                .cardCvc("111")
                .cardName("Sotos Bikos")
                .cardExpirationDate("01/2080")
                .cardType(CardType.VISA)
                .account(account8)
                .build();


        Address addressA8A1 = Address.builder()
                .country("Greece")
                .postalCode("15569")
                .streetName("Menalou")
                .province("Vrilissia")
                .streetNo("67")
                .account(account8)
                .build();


        accountRepository.save(account8);
        profileRepository.save(profileA8P1);
        profileRepository.save(profileA8P2);
        creditCardRepository.save(creditCardA8C1);
        addressRepository.save(addressA8A1);
        //endregion

        //region Account 9
        //-----------------Account 9----------------//
        Account account9 = Account.builder()
                .email("georgeTakis93@hotmail.com")
                .username("george")
                .firstname("George")
                .lastname("Takis")
                .password("888888")
                .phoneNo("08994894334")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA9P1 = Profile.builder()
                .firstname("George")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account9)
                .build();

        Profile profileA9P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account9)
                .build();


        CreditCard creditCardA9C1 = CreditCard.builder()
                .cardNo("4517621905894494")
                .cardCvc("333")
                .cardName("George Takis")
                .cardExpirationDate("06/2057")
                .cardType(CardType.VISA)
                .account(account9)
                .build();


        Address addressA9A1 = Address.builder()
                .country("Greece")
                .postalCode("15580")
                .streetName("Leof. Spaton")
                .province("Spata")
                .streetNo("7")
                .account(account9)
                .build();


        accountRepository.save(account9);
        profileRepository.save(profileA9P1);
        profileRepository.save(profileA9P2);
        creditCardRepository.save(creditCardA9C1);
        addressRepository.save(addressA9A1);
        //endregion

        //region Account 10
        //-----------------Account 10----------------//
        Account account10 = Account.builder()
                .email("georgeBilias95@hotmail.com")
                .username("george")
                .firstname("George")
                .lastname("Bilias")
                .password("333mypass")
                .phoneNo("08994894334")
                .subscriptionType(SubscriptionType.PREMIUM)
                .creationDate(new Date())
                .subscriptionDate(new Date())
                .build();

        Profile profileA10P1 = Profile.builder()
                .firstname("George")
                .imageUrl(null)
                .ageRestricted(false)
                .account(account10)
                .build();

        Profile profileA10P2 = Profile.builder()
                .firstname("KIDS")
                .imageUrl(null)
                .ageRestricted(true)
                .account(account10)
                .build();


        CreditCard creditCardA10C1 = CreditCard.builder()
                .cardNo("4517781905894494")
                .cardCvc("123")
                .cardName("George Bilias")
                .cardExpirationDate("08/2044")
                .cardType(CardType.PAYPAL)
                .account(account10)
                .build();


        Address addressA10A1 = Address.builder()
                .country("Greece")
                .postalCode("15564")
                .streetName("Gravias")
                .province("Marousi")
                .streetNo("97")
                .account(account10)
                .build();


        accountRepository.save(account10);
        profileRepository.save(profileA10P1);
        profileRepository.save(profileA10P2);
        creditCardRepository.save(creditCardA10C1);
        addressRepository.save(addressA10A1);
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
        writerRepository.save(writerM9W3);
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


        //region Content 19
        //-----------------Content 19----------------//
        Content content19 = Content.builder()
                .title("The Invisible Guest")
                .description("A successful entrepreneur accused of murder and a witness preparation expert have less than three hours to come up with an impregnable defense.")
                .spokenLanguage("English")
                .releaseDate("20 Jul 2017")
                .imageUrl("https://s.kaskus.id/images/2020/07/16/10867266_202007161115010282.png")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/epCg2RbyF80\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(106)
                .build();

        Genre genreC19G1 = Genre.builder()
                .name("Crime")
                .content(content19)
                .build();

        Genre genreC19G2 = Genre.builder()
                .name("Drama")
                .content(content19)
                .build();

        Genre genreC19G3 = Genre.builder()
                .name("Mystery")
                .content(content19)
                .build();

        Actor actorC19A1 = Actor.builder()
                .fullname("Mario Casas")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/MJK35177_Mario_Casas_%28El_Bar%2C_Berlinale_2017%29_%28cropped%29.jpg/800px-MJK35177_Mario_Casas_%28El_Bar%2C_Berlinale_2017%29_%28cropped%29.jpg")
                .content(content19)
                .build();

        Actor actorC19A2 = Actor.builder()
                .fullname("Ana Wagener")
                .imageUrl("http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcS1pmOAo2Ba-ArEMqGLMiAEUfNEMzcpQoxdvcdIjjoYx2bOdQQ6NjTuH5DHW80yXPRh")
                .content(content19)
                .build();

        Actor actorC19A3 = Actor.builder()
                .fullname("Jose Coronado")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Jos%C3%A9_Coronado_at_Premios_Goya_2017_%28cropped%29.jpg/800px-Jos%C3%A9_Coronado_at_Premios_Goya_2017_%28cropped%29.jpg")
                .content(content19)
                .build();

        Movie movie19 = Movie.builder()
                .content(content19)
                .build();

        Writer writerM19W1 = Writer.builder()
                .fullname("Oriol Paulo")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/ab/Festival_de_cinema_de_Sitges_2018_%2831305141408%29_%28cropped4%29.jpg")
                .movie(movie19)
                .build();

         Writer writerM19W2 = Writer.builder()
                .fullname("Lara Sendim")
                .imageUrl("https://m.media-amazon.com/images/M/MV5BYjUwYWQxMWEtYTQ0OS00ZTI4LTliNTAtNDAwOTk4N2QzYWIxXkEyXkFqcGdeQXVyNjUxMjc1OTM@._V1_.jpg")
                .movie(movie19)
                .build();

        Director directorM19D1 = Director.builder()
                .fullname("Oriol Paulo")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/ab/Festival_de_cinema_de_Sitges_2018_%2831305141408%29_%28cropped4%29.jpg")
                .movie(movie19)
                .build();

        movieRepository.save(movie19);
        genreRepository.save(genreC19G1);
        genreRepository.save(genreC19G2);
        genreRepository.save(genreC19G3);
        actorRepository.save(actorC19A1);
        actorRepository.save(actorC19A2);
        actorRepository.save(actorC19A3);
        writerRepository.save(writerM19W1);
        writerRepository.save(writerM19W2);
        directorRepository.save(directorM19D1);
        //endregion

        //region Content 20
        // -----------------Content 20----------------//
        Content content20 = Content.builder()
                .title("The Sea Inside")
                .description("The factual story of Spaniard Ramon Sampedro, who fought a 28-year campaign in favor of euthanasia and his own right to die.")
                .spokenLanguage("Spanish")
                .releaseDate("7 Jan 2005 ")
                .imageUrl("https://i0.wp.com/25.media.tumblr.com/bb6ff40ee64b916ea3c8816311b75383/tumblr_mg9tt14QPP1r37w3co1_1280.png?zoom=2")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/afrVh6ksKII\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(126)
                .build();

        Genre genreC20G1 = Genre.builder()
                .name("Biography")
                .content(content20)
                .build();

        Genre genreC20G2 = Genre.builder()
                .name("Drama")
                .content(content20)
                .build();


        Actor actorC20A1 = Actor.builder()
                .fullname("Javier Bardem")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Premios_Goya_2018_-_Javier_Bardem_%28cropped%29.jpg/800px-Premios_Goya_2018_-_Javier_Bardem_%28cropped%29.jpg")
                .content(content20)
                .build();

        Actor actorC20A2 = Actor.builder()
                .fullname("Belen Rueda")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Premios_Goya_2018_-_Bel%C3%A9n_Rueda.jpg/800px-Premios_Goya_2018_-_Bel%C3%A9n_Rueda.jpg")
                .content(content20)
                .build();

        Actor actorC20A3 = Actor.builder()
                .fullname("Lola Duenas")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fb/Lola_Duenas_Cabourg_2013.jpg")
                .content(content20)
                .build();

        Movie movie20 = Movie.builder()
                .content(content20)
                .build();

        Writer writerM20W1 = Writer.builder()
                .fullname("Alejandro Amenabar")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Amenabar_%2822022306905%29_%28cropped%29.jpg/330px-Amenabar_%2822022306905%29_%28cropped%29.jpg")
                .movie(movie20)
                .build();

         Writer writerM20W2 = Writer.builder()
                .fullname("Mateo Gil")
                .imageUrl("https://1.bp.blogspot.com/-xTxSwN7SwPU/WdOFrkn0VuI/AAAAAAABPR0/VmWozMjKD9QAP5ZFS8SlFW3xwGBrT5BGQCLcBGAs/s1600/Mateo-Gil-intensamente-Proyecto-Lazaro_EDIIMA20150219_0388_5.jpg")
                .movie(movie20)
                .build();

        Director directorM20D1 = Director.builder()
                .fullname("Alejandro Amenabar")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Amenabar_%2822022306905%29_%28cropped%29.jpg/330px-Amenabar_%2822022306905%29_%28cropped%29.jpg")
                .movie(movie20)
                .build();

        movieRepository.save(movie20);
        genreRepository.save(genreC20G1);
        genreRepository.save(genreC20G2);
        actorRepository.save(actorC20A1);
        actorRepository.save(actorC20A2);
        actorRepository.save(actorC20A3);
        writerRepository.save(writerM20W1);
        writerRepository.save(writerM20W2);
        directorRepository.save(directorM20D1);
        //endregion

        //region Content 21
        //-----------------Content 21----------------//
        Content content21 = Content.builder()
                .title("La La Land")
                .description("While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.")
                .spokenLanguage("English")
                .releaseDate("22 Dec 2016 ")
                .imageUrl("https://upload.wikimedia.org/wikipedia/el/a/ab/La_La_Land_%28film%29.png")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/0pdqf4P9MB8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(128)
                .build();

        Genre genreC21G1 = Genre.builder()
                .name("Comedy")
                .content(content21)
                .build();

        Genre genreC21G2 = Genre.builder()
                .name("Drama")
                .content(content21)
                .build();


        Actor actorC21A1 = Actor.builder()
                .fullname("Ryan Gosling")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Ryan_Gosling_at_SSIFF_2018_%281%29_%28cropped%29.jpg/800px-Ryan_Gosling_at_SSIFF_2018_%281%29_%28cropped%29.jpg")
                .content(content21)
                .build();

        Actor actorC21A2 = Actor.builder()
                .fullname("Emma Stone")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/3/31/Emma_Stone_at_Maniac_UK_premiere_%28cropped%29.jpg")
                .content(content21)
                .build();

        Actor actorC21A3 = Actor.builder()
                .fullname("Rosemarie DeWitt")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Rosemarie_DeWitt.jpg/800px-Rosemarie_DeWitt.jpg")
                .content(content21)
                .build();

        Movie movie21 = Movie.builder()
                .content(content21)
                .build();

        Writer writerM21W1 = Writer.builder()
                .fullname("Damien Chazelle")
                .imageUrl("https://s3.amazonaws.com/static.rogerebert.com/uploads/blog_post/primary_image/interviews/damien-chazelle-interview-babylon/bab17760r2.jpg")
                .movie(movie21)
                .build();

        Director directorM21D1 = Director.builder()
                .fullname("Damien Chazelle")
                .imageUrl("https://s3.amazonaws.com/static.rogerebert.com/uploads/blog_post/primary_image/interviews/damien-chazelle-interview-babylon/bab17760r2.jpg")
                .movie(movie21)
                .build();

        movieRepository.save(movie21);
        genreRepository.save(genreC21G1);
        genreRepository.save(genreC21G2);
        actorRepository.save(actorC21A1);
        actorRepository.save(actorC21A2);
        actorRepository.save(actorC21A3);
        writerRepository.save(writerM21W1);
        directorRepository.save(directorM21D1);
        //endregion

        //region Content 22
        //-----------------Content 22----------------//
        Content content22 = Content.builder()
                .title("How To Lose A Guy In 10 Days")
                .description("Benjamin Barry is an advertising executive and ladies' man who, to win a big campaign, bets that he can make a woman fall in love with him in 10 days.")
                .spokenLanguage("English")
                .releaseDate("9 May 2003 ")
                .imageUrl("https://m.media-amazon.com/images/I/71QLcAJVGEL._AC_SL1500_.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/2ZMGk_Ml1fc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(116)
                .build();

        Genre genreC22G1 = Genre.builder()
                .name("Comedy")
                .content(content22)
                .build();

        Genre genreC22G2 = Genre.builder()
                .name("Romance")
                .content(content22)
                .build();


        Actor actorC22A1 = Actor.builder()
                .fullname("Kate Hudson")
                .imageUrl("https://media.vanityfair.com/photos/6269919a2cb5cd8155013335/master/pass/1205187607")
                .content(content22)
                .build();

        Actor actorC22A2 = Actor.builder()
                .fullname("Matthew McConaughey")
                .imageUrl("https://hips.hearstapps.com/hmg-prod/images/1-1665084333.jpg")
                .content(content22)
                .build();

        Actor actorC22A3 = Actor.builder()
                .fullname("Adam Goldberg")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/a/a2/Actor%2C_filmmaker%2C_musician_Adam_Goldberg_in_Brooklyn%2C_NY_in_2016.jpg")
                .content(content22)
                .build();

        Movie movie22 = Movie.builder()
                .content(content22)
                .build();

        Writer writerM22W1 = Writer.builder()
                .fullname("Michele Alexander")
                .imageUrl("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQUEi06MKkigGAtU-Fyn01gNJR2Q6SPBcVqca-EqSh7zZ_U9E_M")
                .movie(movie22)
                .build();

         Writer writerM22W2 = Writer.builder()
                .fullname("Jeannie Long")
                .imageUrl(null)
                .movie(movie22)
                .build();

         Writer writerM22W3 = Writer.builder()
                .fullname("Kristen Buckley")
                .imageUrl("https://m.media-amazon.com/images/M/MV5BNzAyNGI3MGItZDVhYi00MTJiLTg3NGItMzdhOWI2NTIxYjQ2XkEyXkFqcGdeQXVyODY2NTc3ODY@._V1_.jpg")
                .movie(movie22)
                .build();

        Director directorM22D1 = Director.builder()
                .fullname("Donald Petrie")
                .imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBVGQtZyA1lvkxYCbfxAVyhl9fiWfDz_eJ6PMflnyRfzx_wr1o")
                .movie(movie22)
                .build();

        movieRepository.save(movie22);
        genreRepository.save(genreC22G1);
        genreRepository.save(genreC22G2);
        actorRepository.save(actorC22A1);
        actorRepository.save(actorC22A2);
        actorRepository.save(actorC22A3);
        writerRepository.save(writerM22W1);
        writerRepository.save(writerM22W2);
        writerRepository.save(writerM22W3);
        directorRepository.save(directorM22D1);
        //endregion

        //region Content 23
        //-----------------Content 23----------------//
        Content content23 = Content.builder()
                .title("The Pale Blue Eye")
                .description("A world-weary detective is hired to investigate the murder of a West Point cadet. Stymied by the cadets' code of silence, he enlists one of their own to help unravel the case - a young man the world would come to know as Edgar Allan Poe.")
                .spokenLanguage("English")
                .releaseDate("6 Jan 2023 ")
                .imageUrl("https://m.media-amazon.com/images/M/MV5BZDg2YThlMTItYzhhMy00OWE3LTljYTAtYTExMDM5NzRjOGFhXkEyXkFqcGdeQXVyMTEzMTI1Mjk3._V1_FMjpg_UX1000_.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/ddbL9jvg77w\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(128)
                .build();

        Genre genreC23G1 = Genre.builder()
                .name("Crime")
                .content(content23)
                .build();

        Genre genreC23G2 = Genre.builder()
                .name("Horror")
                .content(content23)
                .build();

        Genre genreC23G3 = Genre.builder()
                .name("Mystery")
                .content(content23)
                .build();


        Actor actorC23A1 = Actor.builder()
                .fullname("Christian Bale")
                .imageUrl("https://www.onthisday.com/images/people/christian-bale-medium.jpg")
                .content(content23)
                .build();

        Actor actorC23A2 = Actor.builder()
                .fullname("Harry Melling")
                .imageUrl("https://imgix.bustle.com/uploads/getty/2022/12/22/e4b57707-9362-40b2-9a52-e20a4d2eb3b6-getty-1449312995.jpg?w=800&fit=crop&crop=faces&auto=format%2Ccompress")
                .content(content23)
                .build();

        Actor actorC23A3 = Actor.builder()
                .fullname("Simon McBurney")
                .imageUrl("https://i.guim.co.uk/img/media/f09e00eb4392e94b72f0fb6d769d030c0a16cc68/0_544_5792_3474/master/5792.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=656be9e8bbbef99cc376f920c302d2ce")
                .content(content23)
                .build();

        Movie movie23 = Movie.builder()
                .content(content23)
                .build();

        Writer writerM23W1 = Writer.builder()
                .fullname("Scott Cooper")
                .imageUrl("https://deadline.com/wp-content/uploads/2020/03/scott-cooper.jpg")
                .movie(movie23)
                .build();

        Director directorM23D1 = Director.builder()
                .fullname("Scott Cooper")
                .imageUrl("https://deadline.com/wp-content/uploads/2020/03/scott-cooper.jpg")
                .movie(movie23)
                .build();

        movieRepository.save(movie23);
        genreRepository.save(genreC23G1);
        genreRepository.save(genreC23G2);
        genreRepository.save(genreC23G3);
        actorRepository.save(actorC23A1);
        actorRepository.save(actorC23A2);
        actorRepository.save(actorC23A3);
        writerRepository.save(writerM23W1);
        directorRepository.save(directorM23D1);
        //endregion

        //region Content 24
        //-----------------Content 24----------------//
        Content content24 = Content.builder()
                .title("Something In The Rain")
                .description("Yoon Jin Ah is a woman in her mid-30s who doesn't know yet what it's like to date a man. She's been dumped by a man many times because of her clumsy, reckless and foolish behavior....")
                .spokenLanguage("Korean")
                .releaseDate("30 Mar 2018")
                .imageUrl("https://m.media-amazon.com/images/M/MV5BZmU0NTY3YmUtNzhhMy00Mjg2LWFjMWEtMmI5MDAxNDBlZjZkXkEyXkFqcGdeQXVyNDI3NjU1NzQ@._V1_.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/7RGk6NXwbrY\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(75)
                .build();

        Genre genreC24G1 = Genre.builder()
                .name("Romance")
                .content(content24)
                .build();

        Genre genreC24G2 = Genre.builder()
                .name("Drama")
                .content(content24)
                .build();

        Actor actorC24A1 = Actor.builder()
                .fullname("Son Ye-jin")
                .imageUrl(null)
                .content(content24)
                .build();

        Actor actorC24A2 = Actor.builder()
                .fullname("Jung Hae-in")
                .imageUrl(null)
                .content(content24)
                .build();

        Actor actorC24A3 = Actor.builder()
                .fullname("Joo Min-Kyung")
                .imageUrl(null)
                .content(content24)
                .build();

        TVSeries tvSeries24 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content24)
                .build();

        Creator creatorT24C1 = Creator.builder()
                .fullname("Ahn Pan-seok")
                .imageUrl(null)
                .tvSeries(tvSeries24)
                .build();


        Season seasonT24S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries24)
                .build();

        Episode episodeT24S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #1")
                .description("Life is tiresome for Jin-ah, from a bad breakup to a office stressful job. Out of the blue Joon-hee arrives home in Korea after 3 years out of the country. ")
                .releaseDate("30 Mar 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #2")
                .description("One of Jin-ah's coworkers takes a liking to Joon-hee which rubs her the wrong way; Jin-a's mom begins to worry because Jin-a isn't preparing to get married like others her age.")
                .releaseDate("30 Mar 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #3")
                .description("Gyoo-min tries to convince others about Jin-ah's feelings toward Joon-hee; Joon-hee suspects that Jin-a still has feelings for Gyu-min.")
                .releaseDate("6 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #4")
                .description("Although happy with her relationship, Jin-ah still has concerns about it. At work she gets tricked into going on a business trip that no one else wants to take on.")
                .releaseDate("7 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #5")
                .description("Setting aside her guilt, Jin-A spends the night at Jun-Hui's place. Back at work after the business trip, she gets called to director Nam's office.")
                .releaseDate("13 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #6")
                .description("Jin Ah and Joon Hee struggle to hide their relationship from friends and family.")
                .releaseDate("14 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E7 = Episode.builder()
                .episodeNo(7)
                .title("Episode #7")
                .description("Jin Ah wonders how she can tell her family that she's dating Joon Hee. Meanwhile, her ex just can't seem to let her go. ")
                .releaseDate("20 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E8 = Episode.builder()
                .episodeNo(8)
                .title("Episode #8")
                .description("Jin Ah's ex-boyfriend does the unthinkable.")
                .releaseDate("21 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E9 = Episode.builder()
                .episodeNo(9)
                .title("Episode #9")
                .description("The truth about Jin Ah and Joon Hee's relationship is finally out. Will Jin Ah's friendship with Joon Hee's sister survive? ")
                .releaseDate("27 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();


        Episode episodeT24S1E10 = Episode.builder()
                .episodeNo(10)
                .title("Episode #10")
                .description("Jin Ah's mother doesn't take the news of her daughter's relationship too well. ")
                .releaseDate("28 Apr 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E11 = Episode.builder()
                .episodeNo(11)
                .title("Episode #11")
                .description("Joon Hee and Jin Ah's relationship is put to the test.")
                .releaseDate("4 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E12 = Episode.builder()
                .episodeNo(12)
                .title("Episode #12")
                .description("Jin Ah and Joon Hee struggle to appease Jin Ah's mother. Kyung Sun sees her father for the first time in years. ")
                .releaseDate("5 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E13 = Episode.builder()
                .episodeNo(13)
                .title("Episode #13")
                .description("Joon Hee and Kyung Sun's father tries to learn more about his kids' lives. ")
                .releaseDate("11 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E14 = Episode.builder()
                .episodeNo(14)
                .title("Episode #14")
                .description("As Jin Ah's company is embroiled in scandal, Joon Hee asks Jin Ah to make a big decision.")
                .releaseDate("12 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E15 = Episode.builder()
                .episodeNo(15)
                .title("Episode #15")
                .description("Yoon Jin Ah makes a drastic decision. ")
                .releaseDate("18 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();

        Episode episodeT24S1E16 = Episode.builder()
                .episodeNo(16)
                .title("Episode #16")
                .description("Joon Hee and Jin Ah meet again. Can they rekindle their relationship? ")
                .releaseDate("19 May 2018")
                .imageUrl(null)
                .season(seasonT24S1)
                .build();



        tVSeriesRepository.save(tvSeries24);
        creatorRepository.save(creatorT24C1);
        seasonRepository.save(seasonT24S1);
        episodeRepository.save(episodeT24S1E1);
        episodeRepository.save(episodeT24S1E2);
        episodeRepository.save(episodeT24S1E3);
        episodeRepository.save(episodeT24S1E4);
        episodeRepository.save(episodeT24S1E5);
        episodeRepository.save(episodeT24S1E6);
        episodeRepository.save(episodeT24S1E7);
        episodeRepository.save(episodeT24S1E8);
        episodeRepository.save(episodeT24S1E9);
        episodeRepository.save(episodeT24S1E10);
        episodeRepository.save(episodeT24S1E11);
        episodeRepository.save(episodeT24S1E12);
        episodeRepository.save(episodeT24S1E13);
        episodeRepository.save(episodeT24S1E14);
        episodeRepository.save(episodeT24S1E15);
        episodeRepository.save(episodeT24S1E16);
        genreRepository.save(genreC24G1);
        genreRepository.save(genreC24G2);
        actorRepository.save(actorC24A1);
        actorRepository.save(actorC24A2);
        actorRepository.save(actorC24A3);
        //endregion

        //region Content 25
        //-----------------Content 25----------------//
         Content content25 = Content.builder()
                 .title("Crash Landing On You")
                 .description("The absolute top secret love story of a chaebol heiress who made an emergency landing in North Korea because of a paragliding accident and a North Korean special officer who falls in love with her and who is hiding and protecting her.")
                 .spokenLanguage("Korean")
                 .releaseDate("14 Dec 2019")
                 .imageUrl("https://m.media-amazon.com/images/M/MV5BZWQyZTkwMTMtYTJiZS00MGNlLThhN2EtYzEzOGQzYjFiZGQxXkEyXkFqcGdeQXVyMTEzMjQ4NzEw._V1_.jpg")
                 .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/eXMjTXL2Vks\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                 .isAgeRestricted(false)
                 .contentType(ContentType.TV_SERIES)
                 .runtime(70)
                 .build();

         Genre genreC25G1 = Genre.builder()
                 .name("Romance")
                 .content(content25)
                 .build();

         Genre genreC25G2 = Genre.builder()
                 .name("Adventure")
                 .content(content25)
                 .build();

         Genre genreC25G3 = Genre.builder()
                 .name("Comedy")
                 .content(content25)
                 .build();

         Actor actorC25A1 = Actor.builder()
                 .fullname("Son Ye-jin")
                 .imageUrl(null)
                 .content(content25)
                 .build();

         Actor actorC25A2 = Actor.builder()
                 .fullname("Hyun Bin")
                 .imageUrl(null)
                 .content(content25)
                 .build();

         Actor actorC25A3 = Actor.builder()
                 .fullname("Seon Ji-hye")
                 .imageUrl(null)
                 .content(content25)
                 .build();

         TVSeries tvSeries25 = TVSeries.builder()
                 .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                 .content(content25)
                 .build();

         Creator creatorT25C1 = Creator.builder()
                 .fullname("Lee Jeong-hyo")
                 .imageUrl(null)
                 .tvSeries(tvSeries25)
                 .build();

         Season seasonT25S1 = Season.builder()
                 .seasonNo(1)
                 .tvSeries(tvSeries25)
                 .build();

         Episode episodeT25S1E1 = Episode.builder()
                 .episodeNo(1)
                 .title("Episode #1")
                 .description(null)
                 .releaseDate("14 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E2 = Episode.builder()
                 .episodeNo(2)
                 .title("Episode #2")
                 .description(null)
                 .releaseDate("15 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E3 = Episode.builder()
                 .episodeNo(3)
                 .title("Episode #3")
                 .description(null)
                 .releaseDate("21 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E4 = Episode.builder()
                 .episodeNo(4)
                 .title("Episode #4")
                 .description(null)
                 .releaseDate("22 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E5 = Episode.builder()
                 .episodeNo(5)
                 .title("Episode #5")
                 .description(null)
                 .releaseDate("28 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E6 = Episode.builder()
                 .episodeNo(6)
                 .title("Episode #6")
                 .description(null)
                 .releaseDate("29 Dec 2019")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E7 = Episode.builder()
                 .episodeNo(7)
                 .title("Episode #7")
                 .description(null)
                 .releaseDate("11 Jan 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E8 = Episode.builder()
                 .episodeNo(8)
                 .title("Episode #8")
                 .description(null)
                 .releaseDate("12 Jan 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E9 = Episode.builder()
                 .episodeNo(9)
                 .title("Episode #9")
                 .description(null)
                 .releaseDate("18 Jan 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();


         Episode episodeT25S1E10 = Episode.builder()
                 .episodeNo(10)
                 .title("Episode #10")
                 .description(null)
                 .releaseDate("19 Jan 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E11 = Episode.builder()
                 .episodeNo(11)
                 .title("Episode #11")
                 .description(null)
                 .releaseDate("1 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E12 = Episode.builder()
                 .episodeNo(12)
                 .title("Episode #12")
                 .description(null)
                 .releaseDate("2 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E13 = Episode.builder()
                 .episodeNo(13)
                 .title("Episode #13")
                 .description(null)
                 .releaseDate("8 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

        Episode episodeT25S1E14 = Episode.builder()
                 .episodeNo(14)
                 .title("Episode #14")
                 .description(null)
                 .releaseDate("9 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

         Episode episodeT25S1E15 = Episode.builder()
                 .episodeNo(15)
                 .title("Episode #15")
                 .description(null)
                 .releaseDate("15 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();

          Episode episodeT25S1E16 = Episode.builder()
                 .episodeNo(16)
                 .title("Episode #16")
                 .description(null)
                 .releaseDate("16 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT25S1)
                 .build();



         tVSeriesRepository.save(tvSeries25);
         creatorRepository.save(creatorT25C1);
         seasonRepository.save(seasonT25S1);
         episodeRepository.save(episodeT25S1E1);
         episodeRepository.save(episodeT25S1E2);
         episodeRepository.save(episodeT25S1E3);
         episodeRepository.save(episodeT25S1E4);
         episodeRepository.save(episodeT25S1E5);
         episodeRepository.save(episodeT25S1E6);
         episodeRepository.save(episodeT25S1E7);
         episodeRepository.save(episodeT25S1E8);
         episodeRepository.save(episodeT25S1E9);
         episodeRepository.save(episodeT25S1E10);
         episodeRepository.save(episodeT25S1E11);
         episodeRepository.save(episodeT25S1E12);
         episodeRepository.save(episodeT25S1E13);
         episodeRepository.save(episodeT25S1E14);
         episodeRepository.save(episodeT25S1E15);
         episodeRepository.save(episodeT25S1E16);
         genreRepository.save(genreC25G1);
         genreRepository.save(genreC25G2);
         genreRepository.save(genreC25G3);
         actorRepository.save(actorC25A1);
         actorRepository.save(actorC25A2);
         actorRepository.save(actorC25A3);
        //endregion

        //region Content 26
        //-----------------Content 26----------------//
        Content content26 = Content.builder()
                .title("Little Women")
                .description("Three sisters with a close bond who grew up in poverty. It is the exciting story of the sisters as they get embroiled in a major incident and face off against the wealthiest family in the nation.")
                .spokenLanguage("Korean")
                .releaseDate("3 Sept 2022")
                .imageUrl("https://sa.kapamilya.com/absnews/abscbnnews/media/2022/tvpatrol/08/29/little-women.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/Y52PRIHr-YI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(75)
                .build();

        Genre genreC26G1 = Genre.builder()
                .name("Mystery")
                .content(content26)
                .build();

        Genre genreC26G2 = Genre.builder()
                .name("Drama")
                .content(content26)
                .build();

        Actor actorC26A1 = Actor.builder()
                .fullname("Kim Go-eun")
                .imageUrl(null)
                .content(content26)
                .build();

        Actor actorC26A2 = Actor.builder()
                .fullname("Nam Ji-hyun")
                .imageUrl(null)
                .content(content25)
                .build();

        Actor actorC26A3 = Actor.builder()
                .fullname("Park Ji-hu")
                .imageUrl(null)
                .content(content26)
                .build();

        TVSeries tvSeries26 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content26)
                .build();

        Creator creatorT26C1 = Creator.builder()
                .fullname("Kim Hee-won")
                .imageUrl(null)
                .tvSeries(tvSeries26)
                .build();

        Season seasonT26S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries26)
                .build();

        Episode episodeT26S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #1")
                .description("Oh In-joo turns to a work friend for help when an incident with her mother leaves her cash-strapped. Oh In-kyung digs into a four-year-old case. ")
                .releaseDate("3 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #2")
                .description("After discovering Jin Hwa-young's surprising secret, In-joo comes to suspect a finance director to be the culprit of the murderous scheme. ")
                .releaseDate("4 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #3")
                .description("In-kyung causes a scene at a party celebrating Park Hyo-rin's win in a contest. In-joo heads to a mental hospital to deliver an orchid and seek advice")
                .releaseDate("10 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #4")
                .description("In a secret garden, Won Sang-ah commissions Oh In-hye to draw a portrait of her. In-joo and In-kyung debate over the fate of the found money. ")
                .releaseDate("11 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #5")
                .description("In-joo and In-kyung start new jobs and dig deeper into unanswered questions. Sang-ah takes a sudden trip, inciting a surprising reaction.")
                .releaseDate("17 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #6")
                .description("In-joo and In-hye debate what to do with a shocking piece of evidence. In-kyung contends with fallout from a media firestorm. ")
                .releaseDate("18 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E7 = Episode.builder()
            .episodeNo(7)
            .title("Episode #7")
            .description("Reeling from recent events, the sisters must look further into the past in hopes of finding the truth. In-kyung unlocks a secret. In-joo hatches a plan.")
            .releaseDate("24 Sept 2022")
            .imageUrl(null)
            .season(seasonT26S1)
            .build();

        Episode episodeT26S1E8 = Episode.builder()
                .episodeNo(8)
                .title("Episode #8")
                .description("In-joo travels abroad and receives an unexpected welcome, leading to more questions. In-hye and Hyo-rin attempt to help Sang-ah, who's in isolation")
                .releaseDate("25 Sept 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E9 = Episode.builder()
                .episodeNo(9)
                .title("Episode #9")
                .description("In-joo is in grave danger following an encounter with a mysterious visitor abroad. In-kyung offers to make a deal to save her older sister. ")
                .releaseDate("1 Oct 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();


        Episode episodeT26S1E10 = Episode.builder()
                .episodeNo(10)
                .title("Episode #10")
                .description("Park Jae-sang faces a threat. With some help, In-hye and Hyo-rin set out to start fresh. In-kyung finds her own way of shining light on the truth.")
                .releaseDate("2 Oct 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E11 = Episode.builder()
                .episodeNo(11)
                .title("Episode #11")
                .description("Jae-sang makes a drastic move. In the aftermath, the sisters face the wrath of familiar adversaries, newly emboldened with great power. ")
                .releaseDate("8 Oct 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        Episode episodeT26S1E12 = Episode.builder()
                .episodeNo(12)
                .title("Episode #12")
                .description("During one sister's hearing, a bombshell courtroom appearance causes a stir. Emotions run high as lingering questions are finally answered. ")
                .releaseDate("9 Oct 2022")
                .imageUrl(null)
                .season(seasonT26S1)
                .build();

        tVSeriesRepository.save(tvSeries26);
        creatorRepository.save(creatorT26C1);
        seasonRepository.save(seasonT26S1);
        episodeRepository.save(episodeT26S1E1);
        episodeRepository.save(episodeT26S1E2);
        episodeRepository.save(episodeT26S1E3);
        episodeRepository.save(episodeT26S1E4);
        episodeRepository.save(episodeT26S1E5);
        episodeRepository.save(episodeT26S1E6);
        episodeRepository.save(episodeT26S1E7);
        episodeRepository.save(episodeT26S1E8);
        episodeRepository.save(episodeT26S1E9);
        episodeRepository.save(episodeT26S1E10);
        episodeRepository.save(episodeT26S1E11);
        episodeRepository.save(episodeT26S1E12);
        genreRepository.save(genreC26G1);
        genreRepository.save(genreC26G2);
        actorRepository.save(actorC26A1);
        actorRepository.save(actorC26A2);
        actorRepository.save(actorC26A3);
        //endregion

        //region Content 27
        //-----------------Content 27----------------//
         Content content27 = Content.builder()
                 .title("Itaewon Class")
                 .description("An ex-con opens a street bar in Itaewon, while also seeking revenge on the family who was responsible for his father's death.")
                 .spokenLanguage("Korean")
                 .releaseDate("31 Jan 2020")
                 .imageUrl("https://m.media-amazon.com/images/M/MV5BODY1NWE2OTctOTU5MC00NTlmLWI2MzktMmYzMTUzYjk4YjEzXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_.jpg")
                 .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/NeaHNQJ1kCo\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                 .isAgeRestricted(false)
                 .contentType(ContentType.TV_SERIES)
                 .runtime(70)
                 .build();

         Genre genreC27G1 = Genre.builder()
                 .name("Romance")
                 .content(content27)
                 .build();

         Genre genreC27G2 = Genre.builder()
                 .name("Drama")
                 .content(content27)
                 .build();

         Actor actorC27A1 = Actor.builder()
                 .fullname("Park Seo-joon")
                 .imageUrl(null)
                 .content(content27)
                 .build();

         Actor actorC27A2 = Actor.builder()
                 .fullname("Kim Da-mi")
                 .imageUrl(null)
                 .content(content27)
                 .build();

         Actor actorC27A3 = Actor.builder()
                 .fullname("Yoo Jae-myung")
                 .imageUrl(null)
                 .content(content27)
                 .build();

         TVSeries tvSeries27 = TVSeries.builder()
                 .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                 .content(content27)
                 .build();

         Creator creatorT27C1 = Creator.builder()
                 .fullname("Kim Seong-yoon")
                 .imageUrl(null)
                 .tvSeries(tvSeries27)
                 .build();

         Season seasonT27S1 = Season.builder()
                 .seasonNo(1)
                 .tvSeries(tvSeries27)
                 .build();

         Episode episodeT27S1E1 = Episode.builder()
                 .episodeNo(1)
                 .title("Episode #1")
                 .description(null)
                 .releaseDate("31 Jan 2020")
                 .imageUrl("On his first day at a new high school, Park Sae Ro Yi stands by his principles in front of powerful bullies. Oh Soo Ah works on getting into college.")
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E2 = Episode.builder()
                 .episodeNo(2)
                 .title("Episode #2")
                 .description("While serving his time, Park Sae Ro Yi develops a bold game plan for his future. Soo Ah can't ignore a generous offer from Jang Dae Hee")
                 .releaseDate("1 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E3 = Episode.builder()
                 .episodeNo(3)
                 .title("Episode #3")
                 .description("Park Sae Ro Yi crosses paths with Jo Yi Seo, who seems to have a knack for bringing him trouble. Meanwhile, Dan Bam struggles to attract customers")
                 .releaseDate("7 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E4 = Episode.builder()
                 .episodeNo(4)
                 .title("Episode #4")
                 .description("Choi Seung Kwon regrets reverting back to his old ways. When Yi Seo's night out takes an ugly turn, Sae Ro Yi is there to help")
                 .releaseDate("8 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E5 = Episode.builder()
                 .episodeNo(5)
                 .title("Episode #5")
                 .description("Before its reopening, Dan Bam gets a few upgrades. Yi Seo, Seung Kwon and Jang Geun Soo have a surprise encounter at a nightclub")
                 .releaseDate("14 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E6 = Episode.builder()
                 .episodeNo(6)
                 .title("Episode #6")
                 .description("Dae Hee keeps tabs on Dan Bam's progress. Sae Ro Yi runs into Jang Geun Won at the TV station. Yi Seo faces her mother's disappointment.")
                 .releaseDate("15 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E7 = Episode.builder()
                 .episodeNo(7)
                 .title("Episode #7")
                 .description("Dan Bam gets an unwelcome visitor. Sae Ro Yi approaches Kang Min Jung with a weighty proposition, and shares his entire story with Yi Seo.")
                 .releaseDate("21 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E8 = Episode.builder()
                 .episodeNo(8)
                 .title("Episode #8")
                 .description("Bad news strikes Dan Bam, but Sae Ro Yi isn't one to bow under pressure. Geun Soo learns a horrible truth. Kim Tony deals with discrimination")
                 .releaseDate("22 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E9 = Episode.builder()
                 .episodeNo(9)
                 .title("Episode #9")
                 .description("The bar's move to a quieter street poses fresh problems for the crew. Dae Hee takes an interest in Sae Ro Yi's people.")
                 .releaseDate("28 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();


         Episode episodeT27S1E10 = Episode.builder()
                 .episodeNo(10)
                 .title("Episode #10")
                 .description("Jangga finds itself in hot water with the public. With the future of the company hanging in the balance, Dae Hee must make his choice.")
                 .releaseDate("29 Feb 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

         Episode episodeT27S1E11 = Episode.builder()
                 .episodeNo(11)
                 .title("Episode #11")
                 .description("After Ma Hyun Yi makes a buzzy TV appearance, a big opportunity comes knocking for Dan Bam. Geun Soo goes after what he wants.")
                 .releaseDate("6 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E12 = Episode.builder()
                 .episodeNo(12)
                 .title("Episode #12")
                 .description("While navigating their latest crisis, Sae Ro Yi and Yi Seo come across a potential investor. Hyun Yi preps for the competition's final round.")
                 .releaseDate("7 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

       Episode episodeT27S1E13 = Episode.builder()
                 .episodeNo(13)
                 .title("Episode #13")
                 .description("Geun Soo moves closer to his goal. With their sights set high, Sae Ro Yi and his team take the business to the next level.")
                 .releaseDate("13 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E14 = Episode.builder()
                 .episodeNo(14)
                 .title("Episode #14")
                 .description("Yi Seo overworks herself as she steps into a critical role for the team's new strategy against Jangga, worrying Sae Ro Yi.")
                 .releaseDate("14 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E15 = Episode.builder()
                 .episodeNo(15)
                 .title("Episode #15")
                 .description("Searching for Yi Seo, Seung Kwon pays his old boss a visit. Dae Hee receives a warning from Soo Ah, and a disturbing call from Geun Won")
                 .releaseDate("20 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();

        Episode episodeT27S1E16 = Episode.builder()
                 .episodeNo(16)
                 .title("Episode #16")
                 .description("Yi Seo runs from Geun Won, who's out to put an end to everything. Desperate to salvage his crumbling legacy, Dae Hee heads to DanBam.")
                 .releaseDate("21 Mar 2020")
                 .imageUrl(null)
                 .season(seasonT27S1)
                 .build();



         tVSeriesRepository.save(tvSeries27);
         creatorRepository.save(creatorT27C1);
         seasonRepository.save(seasonT27S1);
         episodeRepository.save(episodeT27S1E1);
         episodeRepository.save(episodeT27S1E2);
         episodeRepository.save(episodeT27S1E3);
         episodeRepository.save(episodeT27S1E4);
         episodeRepository.save(episodeT27S1E5);
         episodeRepository.save(episodeT27S1E6);
         episodeRepository.save(episodeT27S1E7);
         episodeRepository.save(episodeT27S1E8);
         episodeRepository.save(episodeT27S1E9);
         episodeRepository.save(episodeT27S1E10);
         episodeRepository.save(episodeT27S1E11);
         episodeRepository.save(episodeT27S1E12);
         episodeRepository.save(episodeT27S1E13);
         episodeRepository.save(episodeT27S1E14);
         episodeRepository.save(episodeT27S1E15);
         episodeRepository.save(episodeT27S1E16);
         genreRepository.save(genreC27G1);
         genreRepository.save(genreC27G2);
         actorRepository.save(actorC27A1);
         actorRepository.save(actorC27A2);
         actorRepository.save(actorC27A3);
        //endregion

        //region Content 28
        //-----------------Content 28----------------//
         Content content28 = Content.builder()
                 .title("Twenty Five Twenty One")
                 .description("In a time when dreams seem out of reach, a teen fencer pursues big ambitions and meets a hardworking young man who seeks to rebuild his life.")
                 .spokenLanguage("Korean")
                 .releaseDate("12 Feb 2022")
                 .imageUrl("https://www.patsonic.com/wp-content/uploads/2022/01/twenty-five-twenty-one-synopsis-featured.jpg")
                 .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://youtu.be/gYp4cKumTwU\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                 .isAgeRestricted(false)
                 .contentType(ContentType.TV_SERIES)
                 .runtime(70)
                 .build();

         Genre genreC28G1 = Genre.builder()
                 .name("Romance")
                 .content(content28)
                 .build();

         Genre genreC28G2 = Genre.builder()
                 .name("Drama")
                 .content(content28)
                 .build();

         Actor actorC28A1 = Actor.builder()
                 .fullname("Nam Joo-hyuk")
                 .imageUrl(null)
                 .content(content28)
                 .build();

         Actor actorC28A2 = Actor.builder()
                 .fullname("Kim Ji-yeon")
                 .imageUrl(null)
                 .content(content28)
                 .build();

         Actor actorC28A3 = Actor.builder()
                 .fullname("Choi Hyun-wook")
                 .imageUrl(null)
                 .content(content28)
                 .build();

         TVSeries tvSeries28 = TVSeries.builder()
                 .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                 .content(content28)
                 .build();

         Creator creatorT28C1 = Creator.builder()
                 .fullname("Jung Ji-hyun")
                 .imageUrl(null)
                 .tvSeries(tvSeries28)
                 .build();

         Season seasonT28S1 = Season.builder()
                 .seasonNo(1)
                 .tvSeries(tvSeries28)
                 .build();

         Episode episodeT28S1E1 = Episode.builder()
                 .episodeNo(1)
                 .title("Episode #1")
                 .description("When the IMF financial crisis threatens to slash Na Hee-do's dreams, she sets out to get herself transferred to another school with a fencing program. ")
                 .releaseDate("12 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E2 = Episode.builder()
                 .episodeNo(2)
                 .title("Episode #2")
                 .description("Though taken aback by Ko Yu-rim's cold attitude, Hee-do gives it her best in their first face-off. More of Back Yi-jin's situation comes into focus.")
                 .releaseDate("13 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E3 = Episode.builder()
                 .episodeNo(3)
                 .title("Episode #3")
                 .description("When a fortuitous opportunity presents itself, Hee-do begs her coach for extra training. An unanticipated visitor comes around hoping to see Yi-jin. ")
                 .releaseDate("19 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E4 = Episode.builder()
                 .episodeNo(4)
                 .title("Episode #4")
                 .description("In exchange for a favor, Hee-do carries out a daily errand for Moon Ji-woong. She happens across a drunk Yi-jin after he fails another job interview. ")
                 .releaseDate("20 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E5 = Episode.builder()
                 .episodeNo(5)
                 .title("Episode #5")
                 .description("Hee-do takes one giant leap closer to her dream. She's eager to tell Yi-jin the good news - but realizes he's disappeared without a trace.")
                 .releaseDate("26 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E6 = Episode.builder()
                 .episodeNo(6)
                 .title("Episode #6")
                 .description("Tensions run high between Hee-do and Yu-rim before an important event. Yi-jin takes on a new assignment and spots a familiar face in the crowd.")
                 .releaseDate("27 Feb 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

        Episode episodeT28S1E7 = Episode.builder()
                 .episodeNo(7)
                 .title("Episode #7")
                 .description("A frustrating media narrative dampens a monumental moment for Hee-do. Yi-jin chases down the only person who may be able to set things right.")
                 .releaseDate("5 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

        Episode episodeT28S1E8 = Episode.builder()
                 .episodeNo(8)
                 .title("Episode #8")
                 .description("Hee-do perceives a growing distance between herself and Yi-jin, even as he moves back into the neighborhood. Trouble at home adds to Yoo-rim's stress. ")
                 .releaseDate("6 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

        Episode episodeT28S1E9 = Episode.builder()
                 .episodeNo(9)
                 .title("Episode #9")
                 .description("As Yu-rim's perspective on Hee-do shifts, so does her behavior. While Hee-do avoids seeing Yi-jin, he volunteers for a special documentary project. ")
                 .releaseDate("12 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();


         Episode episodeT28S1E10 = Episode.builder()
                 .episodeNo(10)
                 .title("Episode #10")
                 .description("Under the guise of work, Yi-jin takes Hee-do and Yu-rim on a weekend getaway to the ocean - and agrees to let Ji Seung-wan and Ji-woong tag along. ")
                 .releaseDate("13 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

         Episode episodeT28S1E11 = Episode.builder()
                 .episodeNo(11)
                 .title("Episode #11")
                 .description("Hee-do grows upset when her career-obsessed mother fails to keep a promise. Yi-jin helps out Ji-woong's plans for a grand gesture at a music festival.")
                 .releaseDate("19 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

        Episode episodeT28S1E12 = Episode.builder()
                 .episodeNo(12)
                 .title("Episode #12")
                 .description("Unable to hold back from putting an end to a teacher's abusive behavior, Seung Wan stands her ground. Hee Do and Yu Rim support a distraught teammate.")
                 .releaseDate("20 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

       Episode episodeT28S1E13 = Episode.builder()
                 .episodeNo(13)
                 .title("Episode #13")
                 .description("Warnings about allowing his personal ties affect his work weight heavily on Yi-jin. The school fencing team enter their last competition together.")
                 .releaseDate("26 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

       Episode episodeT28S1E14 = Episode.builder()
                 .episodeNo(14)
                 .title("Episode #14")
                 .description("Shouldering the burdens of a sudden misfortune in her family, Yu-rim arrives at a decision that places her in hot water with the public.")
                 .releaseDate("27 Mar 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

       Episode episodeT28S1E15 = Episode.builder()
                 .episodeNo(15)
                 .title("Episode #15")
                 .description("Hee-do once again finds herself opposite her most formidable opponent. Yi-jin is busier than ever after transferring to another department.")
                 .releaseDate("2 Apr 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();

       Episode episodeT28S1E16 = Episode.builder()
                 .episodeNo(16)
                 .title("Episode #16")
                 .description("In an emotionally charged exchange, Hee-do and Yi-jin confront the state of their relationship. Hee-do accidentally leaves her diary on a bus.")
                 .releaseDate("3 Apr 2022")
                 .imageUrl(null)
                 .season(seasonT28S1)
                 .build();



         tVSeriesRepository.save(tvSeries28);
         creatorRepository.save(creatorT28C1);
         seasonRepository.save(seasonT28S1);
         episodeRepository.save(episodeT28S1E1);
         episodeRepository.save(episodeT28S1E2);
         episodeRepository.save(episodeT28S1E3);
         episodeRepository.save(episodeT28S1E4);
         episodeRepository.save(episodeT28S1E5);
         episodeRepository.save(episodeT28S1E6);
         episodeRepository.save(episodeT28S1E7);
         episodeRepository.save(episodeT28S1E8);
         episodeRepository.save(episodeT28S1E9);
         episodeRepository.save(episodeT28S1E10);
         episodeRepository.save(episodeT28S1E11);
         episodeRepository.save(episodeT28S1E12);
         episodeRepository.save(episodeT28S1E13);
         episodeRepository.save(episodeT28S1E14);
         episodeRepository.save(episodeT28S1E15);
         episodeRepository.save(episodeT28S1E16);
         genreRepository.save(genreC28G1);
         genreRepository.save(genreC28G2);
         actorRepository.save(actorC28A1);
         actorRepository.save(actorC28A2);
         actorRepository.save(actorC28A3);
        //endregion


        //region Content 32
        //-----------------Content 32----------------//

        Content content32 = Content.builder()
                .title("The Gray Man")
                .description("When a shadowy CIA agent uncovers damning agency secrets, he’s hunted across the globe by a sociopathic operative who’s put a bounty on his head. Ryan Gosling and Chris Evans star in this action thriller from the Russo brothers ")
                .spokenLanguage("English")
                .releaseDate("19 Mar 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(129)
                .build();

        Genre genreC32G1 = Genre.builder()
                .name("Action")
                .content(content32)
                .build();

        Genre genreC32G2 = Genre.builder()
                .name("Adventure")
                .content(content32)
                .build();

        Actor actorC32A1 = Actor.builder()
                .fullname("Ryan Gosling")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A2 = Actor.builder()
                .fullname("Chris Evans")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A3 = Actor.builder()
                .fullname("Ana de Armas")
                .imageUrl(null)
                .content(content32)
                .build();
        Actor actorC32A4 = Actor.builder()
                .fullname("Jessica Henwick")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A5 = Actor.builder()
                .fullname("Regé-Jean Page")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A6 = Actor.builder()
                .fullname("Wagner Moura")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A7 = Actor.builder()
                .fullname("Julia Butters")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A8 = Actor.builder()
                .fullname("Dhanush")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A9 = Actor.builder()
                .fullname("Alfre Woodard")
                .imageUrl(null)
                .content(content32)
                .build();

        Actor actorC32A10 = Actor.builder()
                .fullname("Billy Bob Thornton")
                .imageUrl(null)
                .content(content32)
                .build();

        Movie movie32 = Movie.builder()
                .content(content32)
                .build();


        Writer writerM32W1 = Writer.builder()
                .fullname("Joe Russo")
                .imageUrl(null)
                .movie(movie32)
                .build();

        Writer writerM32W2 = Writer.builder()
                .fullname("Cristopher Markus")
                .imageUrl(null)
                .movie(movie32)
                .build();

        Writer writerM32W3 = Writer.builder()
                .fullname("Stephen McFeely")
                .imageUrl(null)
                .movie(movie32)
                .build();

        Director directorM32D1 = Director.builder()
                .fullname("Anthony Russo")
                .imageUrl(null)
                .movie(movie32)
                .build();

        Director directorM32D2 = Director.builder()
                .fullname("Joe Russo")
                .imageUrl(null)
                .movie(movie32)
                .build();

        movieRepository.save(movie32);
        genreRepository.save(genreC32G1);
        genreRepository.save(genreC32G2);
        actorRepository.save(actorC32A1);
        actorRepository.save(actorC32A2);
        actorRepository.save(actorC32A3);
        actorRepository.save(actorC32A4);
        actorRepository.save(actorC32A5);
        actorRepository.save(actorC32A6);
        actorRepository.save(actorC32A7);
        actorRepository.save(actorC32A8);
        actorRepository.save(actorC32A9);
        actorRepository.save(actorC32A10);

        writerRepository.save(writerM32W1);
        writerRepository.save(writerM32W2);
        writerRepository.save(writerM32W3);

        directorRepository.save(directorM32D1);
        directorRepository.save(directorM32D2);

        //endregion

        //region Content 33
        //-----------------Content 33----------------//
        Content content33 = Content.builder()
                .title("Red Notice")
                .description("An FBI profiler pursuing the world's most wanted art thief becomes his reluctant partner in crime to catch an elusive crook who's always one step ahead.")
                .spokenLanguage("English")
                .releaseDate("24 Nov 2021")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(118)
                .build();

        Genre genreC33G1 = Genre.builder()
                .name("Action")
                .content(content33)
                .build();

        Genre genreC33G2 = Genre.builder()
                .name("Adventure")
                .content(content33)
                .build();

        Genre genreC33G3 = Genre.builder()
                .name("Comedies")
                .content(content33)
                .build();

        Genre genreC33G4 = Genre.builder()
                .name("Crime")
                .content(content33)
                .build();

        Actor actorC33A1 = Actor.builder()
                .fullname("Dwayne Johnson")
                .imageUrl(null)
                .content(content33)
                .build();

        Actor actorC33A2 = Actor.builder()
                .fullname("Ryan Reynolds")
                .imageUrl(null)
                .content(content33)
                .build();

        Actor actorC33A3 = Actor.builder()
                .fullname("Gal Gadot")
                .imageUrl(null)
                .content(content33)
                .build();
        Actor actorC33A4 = Actor.builder()
                .fullname("Ritu Arya")
                .imageUrl(null)
                .content(content33)
                .build();

        Actor actorC33A5 = Actor.builder()
                .fullname("Chris Diamantopoulos")
                .imageUrl(null)
                .content(content33)
                .build();

        Movie movie33 = Movie.builder()
                .content(content33)
                .build();

        Writer writerM33W1 = Writer.builder()
                .fullname("Rawson Marshall Thurber")
                .imageUrl(null)
                .movie(movie33)
                .build();

        Director directorM33D1 = Director.builder()
                .fullname("Rawson Marshall Thurber")
                .imageUrl(null)
                .movie(movie33)
                .build();

        movieRepository.save(movie33);
        genreRepository.save(genreC33G1);
        genreRepository.save(genreC33G2);
        genreRepository.save(genreC33G3);
        genreRepository.save(genreC33G4);

        actorRepository.save(actorC33A1);
        actorRepository.save(actorC33A2);
        actorRepository.save(actorC33A3);
        actorRepository.save(actorC33A4);
        actorRepository.save(actorC33A5);

        writerRepository.save(writerM33W1);

        directorRepository.save(directorM33D1);


        //endregion

        //region Content 34
        //-----------------Content 34----------------//

        Content content34 = Content.builder()
                .title("The Adam Project")
                .description("After accidentally crash-landing in 2022, time-traveling fighter pilot Adam Reed teams up with his 12-year-old self on a mission to save the future.")
                .spokenLanguage("English")
                .releaseDate("16 Feb 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(106)
                .build();

        Genre genreC34G1 = Genre.builder()
                .name("Action")
                .content(content34)
                .build();

        Genre genreC34G2 = Genre.builder()
                .name("Adventure")
                .content(content34)
                .build();


        Genre genreC34G3 = Genre.builder()
                .name("Sci-Fi")
                .content(content34)
                .build();

        Genre genreC34G4 = Genre.builder()
                .name("Comedies")
                .content(content34)
                .build();

        Genre genreC34G5 = Genre.builder()
                .name("Family")
                .content(content34)
                .build();


        Actor actorC34A1 = Actor.builder()
                .fullname("Ryan Reynolds")
                .imageUrl(null)
                .content(content34)
                .build();

        Actor actorC34A2 = Actor.builder()
                .fullname("Mark Ruffalo")
                .imageUrl(null)
                .content(content34)
                .build();

        Actor actorC34A3 = Actor.builder()
                .fullname("Zoe Saldaña")
                .imageUrl(null)
                .content(content34)
                .build();
        Actor actorC34A4 = Actor.builder()
                .fullname("Walker Scobell")
                .imageUrl(null)
                .content(content34)
                .build();

        Actor actorC34A5 = Actor.builder()
                .fullname("Catherine Keener")
                .imageUrl(null)
                .content(content34)
                .build();

        Actor actorC34A6 = Actor.builder()
                .fullname("Alex Mallari Jr")
                .imageUrl(null)
                .content(content34)
                .build();

        Actor actorC34A7 = Actor.builder()
                .fullname("Jennifer Garner")
                .imageUrl(null)
                .content(content34)
                .build();

        Movie movie34 = Movie.builder()
                .content(content34)
                .build();


        Writer writerM34W1 = Writer.builder()
                .fullname("Jonathan Tropper")
                .imageUrl(null)
                .movie(movie34)
                .build();

        Writer writerM34W2 = Writer.builder()
                .fullname("T.S. Nowlin")
                .imageUrl(null)
                .movie(movie34)
                .build();

        Writer writerM34W3 = Writer.builder()
                .fullname("Jennifer Flackett")
                .imageUrl(null)
                .movie(movie34)
                .build();

        Writer writerM34W4 = Writer.builder()
                .fullname("Mark Levin")
                .imageUrl(null)
                .movie(movie34)
                .build();

        Director directorM34D1 = Director.builder()
                .fullname("Shawn Levy")
                .imageUrl(null)
                .movie(movie34)
                .build();

        movieRepository.save(movie34);
        genreRepository.save(genreC34G1);
        genreRepository.save(genreC34G2);
        genreRepository.save(genreC34G3);
        genreRepository.save(genreC34G4);
        genreRepository.save(genreC34G5);


        actorRepository.save(actorC34A1);
        actorRepository.save(actorC34A2);
        actorRepository.save(actorC34A3);
        actorRepository.save(actorC34A4);
        actorRepository.save(actorC34A5);
        actorRepository.save(actorC34A6);
        actorRepository.save(actorC34A7);

        writerRepository.save(writerM34W1);
        writerRepository.save(writerM34W2);
        writerRepository.save(writerM34W3);
        writerRepository.save(writerM34W4);

        directorRepository.save(directorM34D1);

        //endregion

        //region Content 35
        //-----------------Content 35----------------//
        Content content35 = Content.builder()
                .title("Baywatch")
                .description("To save their beach, elite lifeguard Mitch Buchannon and a former Olympian probe a criminal plot that threatens the future of the bay.")
                .spokenLanguage("English")
                .releaseDate("22 Aug 2017")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(117)
                .build();

        Genre genreC35G1 = Genre.builder()
                .name("Action")
                .content(content35)
                .build();

        Genre genreC35G2 = Genre.builder()
                .name("Adventure")
                .content(content35)
                .build();

        Genre genreC35G3 = Genre.builder()
                .name("Comedies")
                .content(content35)
                .build();

        Actor actorC35A1 = Actor.builder()
                .fullname("Dwayne Johnson")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A2 = Actor.builder()
                .fullname("Zac Efron")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A3 = Actor.builder()
                .fullname("Priyanka Chopra Jonas")
                .imageUrl(null)
                .content(content35)
                .build();
        Actor actorC35A4 = Actor.builder()
                .fullname("Alexandra Daddario")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A5 = Actor.builder()
                .fullname("Kelly Rohrbach")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A6 = Actor.builder()
                .fullname("Ilfenesh Hadera")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A7 = Actor.builder()
                .fullname("Jon Bass")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A8 = Actor.builder()
                .fullname("Yahya Abdul-Mateen II")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A9 = Actor.builder()
                .fullname("Hannibal Buress")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A10 = Actor.builder()
                .fullname("Rob Huebel")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A11 = Actor.builder()
                .fullname("Amin Joseph")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A12 = Actor.builder()
                .fullname("Jack Kesy")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A13 = Actor.builder()
                .fullname("Pamela Anderson")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A14 = Actor.builder()
                .fullname("Belinda")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A15 = Actor.builder()
                .fullname("Charlotte McKinney")
                .imageUrl(null)
                .content(content35)
                .build();

        Actor actorC35A16 = Actor.builder()
                .fullname("David Hasselhof")
                .imageUrl(null)
                .content(content35)
                .build();


        Movie movie35 = Movie.builder()
                .content(content35)
                .build();

        Writer writerM35W1 = Writer.builder()
                .fullname("Jay Scherick")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Writer writerM35W2 = Writer.builder()
                .fullname("David Ronn")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Writer writerM35W3 = Writer.builder()
                .fullname("Thomas Lennon")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Writer writerM35W4 = Writer.builder()
                .fullname("Robert Ben Garant")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Writer writerM35W5 = Writer.builder()
                .fullname("Mark Swift")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Writer writerM35W6 = Writer.builder()
                .fullname("Damian Shannon")
                .imageUrl(null)
                .movie(movie35)
                .build();

        Director directorM35D1 = Director.builder()
                .fullname("Seth Gordon")
                .imageUrl(null)
                .movie(movie35)
                .build();

        movieRepository.save(movie35);
        genreRepository.save(genreC35G1);
        genreRepository.save(genreC35G2);
        genreRepository.save(genreC35G3);


        actorRepository.save(actorC35A1);
        actorRepository.save(actorC35A2);
        actorRepository.save(actorC35A3);
        actorRepository.save(actorC35A4);
        actorRepository.save(actorC35A5);
        actorRepository.save(actorC35A6);
        actorRepository.save(actorC35A7);
        actorRepository.save(actorC35A8);
        actorRepository.save(actorC35A9);
        actorRepository.save(actorC35A10);
        actorRepository.save(actorC35A11);
        actorRepository.save(actorC35A12);
        actorRepository.save(actorC35A13);
        actorRepository.save(actorC35A14);
        actorRepository.save(actorC35A15);
        actorRepository.save(actorC35A16);

        writerRepository.save(writerM35W1);
        writerRepository.save(writerM35W2);
        writerRepository.save(writerM35W3);
        writerRepository.save(writerM35W4);
        writerRepository.save(writerM35W5);
        writerRepository.save(writerM35W6);

        directorRepository.save(directorM35D1);

        //endregion

        //region Content 36
        //-----------------Content 36----------------//

        Content content36 = Content.builder()
                .title("Faster")
                .description("A bank robber just released from prison goes on a rampage to avenge his dead brother and is pursued by two relentless cops and an eccentric hit man." )
                .spokenLanguage("English")
                .releaseDate("6 Apr 2010")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(98)
                .build();

        Genre genreC36G1 = Genre.builder()
                .name("Action")
                .content(content36)
                .build();

        Genre genreC36G2 = Genre.builder()
                .name("Adventure")
                .content(content36)
                .build();

        Genre genreC36G3 = Genre.builder()
                .name("Crime")
                .content(content36)
                .build();

        Actor actorC36A1 = Actor.builder()
                .fullname("Dwayne Johnson")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A2 = Actor.builder()
                .fullname("Oliver Jackson-Cohen")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A3 = Actor.builder()
                .fullname("Carla Gugino")
                .imageUrl(null)
                .content(content36)
                .build();
        Actor actorC36A4 = Actor.builder()
                .fullname("Maggie Grace")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A5 = Actor.builder()
                .fullname("Billy Bob Thornton")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A6 = Actor.builder()
                .fullname("Moon Bloodgood")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A7 = Actor.builder()
                .fullname("Adewale Akinnuoye-Agbaje")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A8 = Actor.builder()
                .fullname("Tom Berenger")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A9 = Actor.builder()
                .fullname("Matt Gerald")
                .imageUrl(null)
                .content(content36)
                .build();

        Actor actorC36A10 = Actor.builder()
                .fullname("Rob Huebel")
                .imageUrl(null)
                .content(content36)
                .build();


        Movie movie36 = Movie.builder()
                .content(content36)
                .build();


        Writer writerM36W1 = Writer.builder()
                .fullname("Tony Gayton")
                .imageUrl(null)
                .movie(movie36)
                .build();

        Writer writerM36W2 = Writer.builder()
                .fullname("Joe Gayton")
                .imageUrl(null)
                .movie(movie36)
                .build();


        Director directorM36D1 = Director.builder()
                .fullname("George Tillman Jr")
                .imageUrl(null)
                .movie(movie36)
                .build();

        movieRepository.save(movie36);
        genreRepository.save(genreC36G1);
        genreRepository.save(genreC36G2);
        genreRepository.save(genreC36G3);


        actorRepository.save(actorC36A1);
        actorRepository.save(actorC36A2);
        actorRepository.save(actorC36A3);
        actorRepository.save(actorC36A4);
        actorRepository.save(actorC36A5);
        actorRepository.save(actorC36A6);
        actorRepository.save(actorC36A7);
        actorRepository.save(actorC36A8);
        actorRepository.save(actorC36A9);
        actorRepository.save(actorC36A10);

        writerRepository.save(writerM36W1);
        writerRepository.save(writerM36W2);

        directorRepository.save(directorM36D1);

        //endregion

        //region Content 37
        //-----------------Content 37----------------//
        Content content37 = Content.builder()
                .title("DreamWorks Happy Holidays from Madagascar")
                .description("Madagascar goes wild with holiday spirit in this set of Valentine's Day and Christmas-themed tales featuring everyone's favorite animal characters.")
                .spokenLanguage("English")
                .releaseDate("17 Apr 2005")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(35)
                .build();

        Genre genreC37G1 = Genre.builder()
                .name("Kids")
                .content(content37)
                .build();

        Genre genreC37G2 = Genre.builder()
                .name("Cartoons")
                .content(content37)
                .build();

        Genre genreC37G3 = Genre.builder()
                .name("Family")
                .content(content37)
                .build();

        Genre genreC37G4 = Genre.builder()
                .name("Comedy")
                .content(content37)
                .build();

        Actor actorC37A1 = Actor.builder()
                .fullname("Tom McGrath")
                .imageUrl(null)
                .content(content37)
                .build();

        Actor actorC37A2 = Actor.builder()
                .fullname("Chris Miller")
                .imageUrl(null)
                .content(content37)
                .build();

        Actor actorC37A3 = Actor.builder()
                .fullname("Christopher Knights")
                .imageUrl(null)
                .content(content37)
                .build();

        Actor actorC37A4 = Actor.builder()
                .fullname("John DiMaggio")
                .imageUrl(null)
                .content(content37)
                .build();

        Actor actorC37A5 = Actor.builder()
                .fullname("Ben Stiller")
                .imageUrl(null)
                .content(content37)
                .build();

        TVSeries tvSeries37 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content37)
                .build();

        Creator creatorT37C1 = Creator.builder()
                .fullname("DreamWorks")
                .imageUrl(null)
                .tvSeries(tvSeries37)
                .build();


        Season seasonT37S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries37)
                .build();

        Episode episodeT37S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Play All Three: Madagascar Short Stories")
                .description("Romance is in the air after Julien discovers a magic perfume./ Private gets stuck on a shopping trip./ Santa crashes onto the island of Madagascar.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT37S1)
                .build();

        Episode episodeT37S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Madly Madagascar")
                .description("Romance is in the air for Alex, Marty, Gloria and Melman after King Julien discovers a magical perfume and takes on the role as \\\"King of Love.\\")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT37S1)
                .build();

        Episode episodeT37S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Madagascar Penguins in a Cristmas Caper")
                .description("Just before Christmas, Private decides to go into the city for some last-minute shopping but along the way winds up stuffed into a Christmas stocking.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT37S1)
                .build();

        Episode episodeT37S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Merry Madagascar")
                .description("When Santa and his reindeer crash onto the island of Madagascar, it's up to Alex, Marty, Gloria, Melman and those wacky penguins to save Christmas.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT37S1)
                .build();

        tVSeriesRepository.save(tvSeries37);

        creatorRepository.save(creatorT37C1);

        seasonRepository.save(seasonT37S1);

        episodeRepository.save(episodeT37S1E1);
        episodeRepository.save(episodeT37S1E2);
        episodeRepository.save(episodeT37S1E3);
        episodeRepository.save(episodeT37S1E4);

        genreRepository.save(genreC37G1);
        genreRepository.save(genreC37G2);
        genreRepository.save(genreC37G3);
        genreRepository.save(genreC37G4);


        actorRepository.save(actorC37A1);
        actorRepository.save(actorC37A2);
        actorRepository.save(actorC37A3);
        actorRepository.save(actorC37A4);
        actorRepository.save(actorC37A5);
        //endregion

        //region Content 38
        //-----------------Content 38----------------//
        Content content38 = Content.builder()
                .title("Our Universe")
                .description("Witness the remarkable story of our universe over billions of years and its inextricable link to life on Earth in this sweeping documentary series.")
                .spokenLanguage("English")
                .releaseDate("8 Jun 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(43)
                .build();

        Genre genreC38G1 = Genre.builder()
                .name("Documentary")
                .content(content38)
                .build();

        Genre genreC38G2 = Genre.builder()
                .name("Science")
                .content(content38)
                .build();

        Genre genreC38G3 = Genre.builder()
                .name("Nature")
                .content(content38)
                .build();


        Actor actorC38A1 = Actor.builder()
                .fullname("Morgan Freeman")
                .imageUrl(null)
                .content(content38)
                .build();


        TVSeries tvSeries38 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content38)
                .build();

        Creator creatorT38C1 = Creator.builder()
                .fullname("BBC")
                .imageUrl(null)
                .tvSeries(tvSeries38)
                .build();


        Season seasonT38S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries38)
                .build();

        Episode episodeT38S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Chasing Starlight")
                .description("A penetrating look at the sun as a vital source of energy and its impact on one cheetah’s search for food in the sprawling plains of the Serengeti.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        Episode episodeT38S1E2 = Episode.builder()
                .episodeNo(2)
                .title("The Cosmic Clock")
                .description("From the womb to a final moment of peace, witness the steady ticking of the universe’s clock through the eyes of the chimpanzee.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        Episode episodeT38S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Turning Seasons")
                .description("Dive into the long year of the Alaskan brown bear through the Earth's seasonal cycle amid the frigid winter months and into the warmth of summer.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        Episode episodeT38S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Elemental")
                .description("The elements that constitute every living being were formed within the very first stars. Today, a green sea turtle searches the ocean for them.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        Episode episodeT38S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Water World")
                .description("The story of water's miraculous arrival onto our planet and its pivotal role in the survival — and amusement — of a herd of elephants.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        Episode episodeT38S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Force of Attraction")
                .description("Shaping our entire universe, gravity has set the stage for life. For two king penguins, it steered them toward their soulmates.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT38S1)
                .build();

        tVSeriesRepository.save(tvSeries38);

        creatorRepository.save(creatorT38C1);

        seasonRepository.save(seasonT38S1);

        episodeRepository.save(episodeT38S1E1);
        episodeRepository.save(episodeT38S1E2);
        episodeRepository.save(episodeT38S1E3);
        episodeRepository.save(episodeT38S1E4);
        episodeRepository.save(episodeT38S1E5);
        episodeRepository.save(episodeT38S1E6);

        genreRepository.save(genreC38G1);
        genreRepository.save(genreC38G2);
        genreRepository.save(genreC38G3);


        actorRepository.save(actorC38A1);
        //endregion

        //region Content 39
        //-----------------Content 39----------------//
        Content content39 = Content.builder()
                .title("Island of the Sea Wolves")
                .description("Explore wild, wondrous Vancouver Island, where the ocean nurtures all life, from bald eagles who go fishing to sea wolves who swim in frigid waters.")
                .spokenLanguage("English")
                .releaseDate("8 Jul 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(45)
                .build();

        Genre genreC39G1 = Genre.builder()
                .name("Documentary")
                .content(content39)
                .build();

        Genre genreC39G2 = Genre.builder()
                .name("Science")
                .content(content39)
                .build();

        Genre genreC39G3 = Genre.builder()
                .name("Nature")
                .content(content39)
                .build();

        Actor actorC39A1 = Actor.builder()
                .fullname("Will Arnett")
                .imageUrl(null)
                .content(content39)
                .build();


        TVSeries tvSeries39 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content39)
                .build();

        Creator creatorT39C1 = Creator.builder()
                .fullname("BBC")
                .imageUrl(null)
                .tvSeries(tvSeries39)
                .build();


        Season seasonT39S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries39)
                .build();

        Episode episodeT39S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Spring")
                .description("On Vancouver Island, the ocean feeds new life in the spring. But for Cedar, a pregnant sea wolf ousted by her pack, food is hard to come by.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT39S1)
                .build();

        Episode episodeT39S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Summer")
                .description("Summer arrives and the island's inhabitants battle for ebbing resources. But when Cedar approaches the alpha female's den, something remarkable happens.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT39S1)
                .build();

        Episode episodeT39S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Fall")
                .description("A week after being left behind on the beach, wolf pup Blaze sets off to look for the pack. The animals spend fall fueling up for a harsh winter ahead.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT39S1)
                .build();

        tVSeriesRepository.save(tvSeries39);

        creatorRepository.save(creatorT39C1);

        seasonRepository.save(seasonT39S1);

        episodeRepository.save(episodeT39S1E1);
        episodeRepository.save(episodeT39S1E2);
        episodeRepository.save(episodeT39S1E3);

        genreRepository.save(genreC39G1);
        genreRepository.save(genreC39G2);
        genreRepository.save(genreC39G3);


        actorRepository.save(actorC39A1);
        //endregion

        //region Content 40
        //-----------------Content 40----------------//
        Content content40 = Content.builder()
                .title("The Hidden Lives of Pets")
                .description("Bow wows and purr-fect pets! Meet amazing creatures from around the world and dig into the latest science on our animal friends' senses and skills.")
                .spokenLanguage("English")
                .releaseDate("16 May 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(30)
                .build();

        Genre genreC40G1 = Genre.builder()
                .name("Documentary")
                .content(content40)
                .build();

        Genre genreC40G2 = Genre.builder()
                .name("Science")
                .content(content40)
                .build();

        Genre genreC40G3 = Genre.builder()
                .name("Nature")
                .content(content40)
                .build();

        Actor actorC40A1 = Actor.builder()
                .fullname("Hugh Bonneville")
                .imageUrl(null)
                .content(content40)
                .build();


        TVSeries tvSeries40 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content40)
                .build();

        Creator creatorT40C1 = Creator.builder()
                .fullname("BBC")
                .imageUrl(null)
                .tvSeries(tvSeries40)
                .build();


        Season seasonT40S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries40)
                .build();

        Episode episodeT40S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Intelligence")
                .description("A BASE jumping border collie, a bopping cockatoo and racing rats show that animal intelligence can get a big boost in the right enriched environment.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT40S1)
                .build();

        Episode episodeT40S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Communication")
                .description("If we could talk to the animals... While chatty canine Bunny paves the way in pet communication, parrots have mastered the art of vocal expression.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT40S1)
                .build();

        Episode episodeT40S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Super Senses")
                .description("Heat-seeking dogs. GPS-outfitted cats. Sporty goldfish with squad goals. Our super friends in the animal world possess so many hidden superpowers.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT40S1)
                .build();

        Episode episodeT40S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Athletes")
                .description("Survival in the wild has led to these critters' ace athletic abilities. Just try to keep up with speedy greyster dogs — and endurance champ tortoises.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT40S1)
                .build();

        tVSeriesRepository.save(tvSeries40);

        creatorRepository.save(creatorT40C1);

        seasonRepository.save(seasonT40S1);

        episodeRepository.save(episodeT40S1E1);
        episodeRepository.save(episodeT40S1E2);
        episodeRepository.save(episodeT40S1E3);
        episodeRepository.save(episodeT40S1E4);

        genreRepository.save(genreC40G1);
        genreRepository.save(genreC40G2);
        genreRepository.save(genreC40G3);

        actorRepository.save(actorC40A1);
        //endregion

        //region Content 41
        //-----------------Content 41----------------//
        Content content41 = Content.builder()
                .title("MANvsBEE")
                .description("Bumbling dad Trevor tries to get the best of a cunning bee while house-sitting a posh mansion — but only unleashes more chaos in this comedy series.")
                .spokenLanguage("English")
                .releaseDate("1 Apr 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(18)
                .build();

        Genre genreC41G1 = Genre.builder()
                .name("Family")
                .content(content41)
                .build();

        Genre genreC41G2 = Genre.builder()
                .name("Comedy")
                .content(content41)
                .build();

        Actor actorC41A1 = Actor.builder()
                .fullname("Rowan Atkinson")
                .imageUrl(null)
                .content(content41)
                .build();

        Actor actorC41A2 = Actor.builder()
                .fullname("William Davies")
                .imageUrl(null)
                .content(content41)
                .build();


        TVSeries tvSeries41 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content41)
                .build();

        Creator creatorT41C1 = Creator.builder()
                .fullname("BBC")
                .imageUrl(null)
                .tvSeries(tvSeries41)
                .build();


        Season seasonT41S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries41)
                .build();

        Episode episodeT41S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Chapter 1")
                .description("Doting dad Trevor Bingley arrives at a couple's lavish home to house-sit while they're away. A bee follows closely behind — and the battle begins.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Chapter 2")
                .description("Trevor tries to remember the codes to unlock the library and prevent further damage. Later, he must reschedule upcoming plans with his daughter.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Chapter 3")
                .description("A police officer checks in on things. Cupcake ruins her prescription dog diet with peanut butter. Trevor releases the bee outside — but not for long.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();


        Episode episodeT41S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Chapter 4")
                .description("With Cupcake's help, Trevor finds a messy way back inside and deals major damage with a kitchen hand mixer before the police officer arrives again.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Chapter 5")
                .description("Trevor cleans up with a shower under flashy lights and a groovy soundtrack. Later, the bee leads Trevor to the couple's grand piano.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Chapter 6")
                .description("Trevor tries to repair more damaged art. After chatting with Maddy, Trevor becomes too preoccupied with the bee to notice art burglars have broken in.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E7 = Episode.builder()
                .episodeNo(7)
                .title("Chapter 7")
                .description("The burglars reveal themselves at an opportune time. Trevor must take Cupcake to the vet after his bee trap doesn't go as planned.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E8 = Episode.builder()
                .episodeNo(8)
                .title("Chapter 8")
                .description("Trevor gets behind the wheel of Christian's expensive car to head to the vet. Later, a desperate Trevor devises a way to get rid of the bee for good.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        Episode episodeT41S1E9 = Episode.builder()
                .episodeNo(9)
                .title("Chapter 9")
                .description("With Nina and Christian on their way back home, Trevor goes in pursuit of his unrelenting rival with blazing fury.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT41S1)
                .build();

        tVSeriesRepository.save(tvSeries41);

        creatorRepository.save(creatorT41C1);

        seasonRepository.save(seasonT41S1);

        episodeRepository.save(episodeT41S1E1);
        episodeRepository.save(episodeT41S1E2);
        episodeRepository.save(episodeT41S1E3);
        episodeRepository.save(episodeT41S1E4);
        episodeRepository.save(episodeT41S1E5);
        episodeRepository.save(episodeT41S1E6);
        episodeRepository.save(episodeT41S1E7);
        episodeRepository.save(episodeT41S1E8);
        episodeRepository.save(episodeT41S1E9);


        genreRepository.save(genreC41G1);
        genreRepository.save(genreC41G2);


        actorRepository.save(actorC41A1);
        actorRepository.save(actorC41A2);
        //endregion



        Content content42 = Content.builder()
                .title("Pulp Fiction")
                .description("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption")
                .spokenLanguage("English")
                .releaseDate("14 Oct 1994")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(129)
                .build();

        Genre genreC42G1 = Genre.builder()
                .name("Comedy")
                .content(content42)
                .build();

        Genre genreC42G2 = Genre.builder()
                .name("Drama")
                .content(content42)
                .build();

        Actor actorC42A1 = Actor.builder()
                .fullname("Uma Thurman")
                .imageUrl(null)
                .content(content42)
                .build();

        Actor actorC42A2 = Actor.builder()
                .fullname("John Travolta")
                .imageUrl(null)
                .content(content42)
                .build();

        Actor actorC42A3 = Actor.builder()
                .fullname("Samuel L. Jackson")
                .imageUrl(null)
                .content(content42)
                .build();

        Movie movie42 = Movie.builder()
                .content(content42)
                .build();


        Writer writerM42W1 = Writer.builder()
                .fullname("Quentin Tarantino")
                .imageUrl(null)
                .movie(movie42)
                .build();

        Director director422D1 = Director.builder()
                .fullname("Quentin Tarantino")
                .imageUrl(null)
                .movie(movie42)
                .build();

        movieRepository.save(movie42);
        genreRepository.save(genreC42G1);
        genreRepository.save(genreC42G2);
        actorRepository.save(actorC42A1);
        actorRepository.save(actorC42A2);
        actorRepository.save(actorC42A3);

        writerRepository.save(writerM42W1);

        directorRepository.save(director422D1);

        //endregion


        Content content43 = Content.builder()
                .title("A Clockwork Orange")
                .description("A Clockwork Orange is a 1971 dystopian crime film adapted, produced, and directed by Stanley Kubrick, based on Anthony Burgess's 1962 novel of the same name.")
                                .spokenLanguage("English")
                                .releaseDate("19 Dec 1971")
                                .imageUrl(null)
                                .trailerUrl(null)
                                .isAgeRestricted(true)
                                .contentType(ContentType.MOVIE)
                                .runtime(118)
                                .build();

        Genre genreC43G1 = Genre.builder()
                .name("Crime")
                .content(content43)
                .build();

        Actor actorC43A1 = Actor.builder()
                .fullname("Malcolm McDowell")
                .imageUrl(null)
                .content(content43)
                .build();

        Actor actorC43A2 = Actor.builder()
                .fullname("Patrick Magee")
                .imageUrl(null)
                .content(content43)
                .build();

        Actor actorC43A3 = Actor.builder()
                .fullname("Adrienne Corri")
                .imageUrl(null)
                .content(content43)
                .build();

        Movie movie43 = Movie.builder()
                .content(content43)
                .build();

        Writer writerM43W1 = Writer.builder()
                .fullname("Stanley Kubrick")
                .imageUrl(null)
                .movie(movie43)
                .build();

        Director directorM43D1 = Director.builder()
                .fullname("Stanley Kubrick")
                .imageUrl(null)
                .movie(movie43)
                .build();

        movieRepository.save(movie43);
        genreRepository.save(genreC43G1);

        actorRepository.save(actorC43A1);
        actorRepository.save(actorC43A2);
        actorRepository.save(actorC43A3);

        writerRepository.save(writerM43W1);

        directorRepository.save(directorM43D1);


        //endregion

        Content content44 = Content.builder()
                .title("Cast Away")
                .description("A FedEx executive undergoes a physical and emotional transformation after crash landing on a deserted island")
                .spokenLanguage("English")
                .releaseDate("22 Dec 2000")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(106)
                .build();

        Genre genreC44G1 = Genre.builder()
                .name("Drama")
                .content(content44)
                .build();

        Genre genreC44G2 = Genre.builder()
                .name("Mystery")
                .content(content44)
                .build();

        Actor actorC44A1 = Actor.builder()
                .fullname("Tom Hanks")
                .imageUrl(null)
                .content(content44)
                .build();

        Actor actorC44A2 = Actor.builder()
                .fullname("Helen Hunt")
                .imageUrl(null)
                .content(content44)
                .build();

        Actor actorC44A3 = Actor.builder()
                .fullname("Nick Searcy")
                .imageUrl(null)
                .content(content44)
                .build();

        Movie movie44 = Movie.builder()
                .content(content44)
                .build();

        Writer writerM44W1 = Writer.builder()
                .fullname("William Broyles Jr")
                .imageUrl(null)
                .movie(movie44)
                .build();

        Director directorM44D1 = Director.builder()
                .fullname("Robert Zemeckis")
                .imageUrl(null)
                .movie(movie44)
                .build();

        movieRepository.save(movie44);
        genreRepository.save(genreC44G1);
        genreRepository.save(genreC44G2);

        actorRepository.save(actorC44A1);
        actorRepository.save(actorC44A2);
        actorRepository.save(actorC44A3);

        writerRepository.save(writerM44W1);

        directorRepository.save(directorM44D1);

        //endregion

        Content content45 = Content.builder()
                .title("Forrest Gump")
                .description("The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.")
                                .spokenLanguage("English")
                                .releaseDate("23 Jun 1994")
                                .imageUrl(null)
                                .trailerUrl(null)
                                .isAgeRestricted(false)
                                .contentType(ContentType.MOVIE)
                                .runtime(117)
                                .build();

        Genre genreC45G1 = Genre.builder()
                .name("Comedy")
                .content(content45)
                .build();

        Genre genreC45G2 = Genre.builder()
                .name("Drama")
                .content(content45)
                .build();

        Actor actorC45A1 = Actor.builder()
                .fullname("Tom Hanks")
                .imageUrl(null)
                .content(content45)
                .build();

        Actor actorC45A2 = Actor.builder()
                .fullname("Robin Wright")
                .imageUrl(null)
                .content(content45)
                .build();

        Actor actorC45A3 = Actor.builder()
                .fullname("Gary Sinise")
                .imageUrl(null)
                .content(content45)
                .build();

        Movie movie45 = Movie.builder()
                .content(content45)
                .build();

        Writer writerM45W1 = Writer.builder()
                .fullname("Eric Roth")
                .imageUrl(null)
                .movie(movie45)
                .build();


        Director directorM45D1 = Director.builder()
                .fullname("Robert Zemeckis")
                .imageUrl(null)
                .movie(movie45)
                .build();

        movieRepository.save(movie45);
        genreRepository.save(genreC45G1);
        genreRepository.save(genreC45G2);


        actorRepository.save(actorC45A1);
        actorRepository.save(actorC45A2);
        actorRepository.save(actorC45A3);

        writerRepository.save(writerM45W1);

        directorRepository.save(directorM45D1);

        //endregion


        Content content46 = Content.builder()
                .title("Die Welle")
                .description("A high school teacher's experiment to demonstrate to his students what life is like under a dictatorship spins horribly out of control when he forms a social unit with a life of its own" )
                .spokenLanguage("German")
                .releaseDate("18 January 2008")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.MOVIE)
                .runtime(98)
                .build();

        Genre genreC46G1 = Genre.builder()
                .name("Thriller")
                .content(content46)
                .build();

        Genre genreC46G2 = Genre.builder()
                .name("Drama")
                .content(content46)
                .build();

        Actor actorC46A1 = Actor.builder()
                .fullname("Jürgen Vogel")
                .imageUrl(null)
                .content(content46)
                .build();

        Actor actorC46A2 = Actor.builder()
                .fullname("Frederick Lau")
                .imageUrl(null)
                .content(content46)
                .build();

        Actor actorC46A3 = Actor.builder()
                .fullname("Max Riemelt")
                .imageUrl(null)
                .content(content46)
                .build();

        Movie movie46 = Movie.builder()
                .content(content46)
                .build();


        Writer writerM46W1 = Writer.builder()
                .fullname("Ron Jones")
                .imageUrl(null)
                .movie(movie46)
                .build();

        Director directorM46D1 = Director.builder()
                .fullname("Dennis Gansel")
                .imageUrl(null)
                .movie(movie46)
                .build();

        movieRepository.save(movie46);
        genreRepository.save(genreC46G1);
        genreRepository.save(genreC46G2);

        actorRepository.save(actorC46A1);
        actorRepository.save(actorC46A2);
        actorRepository.save(actorC46A3);

        writerRepository.save(writerM46W1);

        directorRepository.save(directorM46D1);

        //endregion



        Content content47 = Content.builder()
                .title("Breaking Bad")
                .description("A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family's future.")
                .spokenLanguage("English")
                .releaseDate(" 20 Jan 2008")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(35)
                .build();

        Genre genreC47G1 = Genre.builder()
                .name("Crime")
                .content(content47)
                .build();

        Genre genreC47G2 = Genre.builder()
                .name("Drama")
                .content(content47)
                .build();

        Actor actorC47A1 = Actor.builder()
                .fullname("Bryan Cranston")
                .imageUrl(null)
                .content(content47)
                .build();

        Actor actorC47A2 = Actor.builder()
                .fullname("Anna Gunn")
                .imageUrl(null)
                .content(content47)
                .build();

        Actor actorC47A3 = Actor.builder()
                .fullname("Aaron Paul")
                .imageUrl(null)
                .content(content47)
                .build();

        Actor actorC47A4 = Actor.builder()
                .fullname("Bob Odenkirk")
                .imageUrl(null)
                .content(content47)
                .build();

        Actor actorC47A5 = Actor.builder()
                .fullname("Giancarlo Esposito")
                .imageUrl(null)
                .content(content47)
                .build();

        TVSeries tvSeries47 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content47)
                .build();

        Creator creatorT47C1 = Creator.builder()
                .fullname("High Bridge Entertainment")
                .imageUrl(null)
                .tvSeries(tvSeries47)
                .build();


        Season seasonT47S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries47)
                .build();

        Episode episodeT47S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Pilot")
                .description("Diagnosed with terminal lung cancer, chemistry teacher Walter White teams up with former student Jesse Pinkman to cook and sell crystal meth.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT47S1)
                .build();

        Episode episodeT47S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Cat's in the Bag...")
                .description("After their first drug deal goes terribly wrong, Walt and Jesse are forced to deal with a corpse and a prisoner. Meanwhile, Skyler grows suspicious of Walt's activities.44")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT47S1)
                .build();

        Episode episodeT47S1E3 = Episode.builder()
                .episodeNo(3)
                .title("...And the Bag's in the River")
                .description("Walt and Jesse clean up after the bathtub incident before Walt decides what course of action to take with their prisoner Krazy-8.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT47S1)
                .build();

        Episode episodeT47S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Cancer Man")
                .description("Walt tells the rest of his family about his cancer. Jesse tries to make amends with his own parents.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT47S1)
                .build();

        tVSeriesRepository.save(tvSeries47);

        creatorRepository.save(creatorT47C1);

        seasonRepository.save(seasonT47S1);

        episodeRepository.save(episodeT47S1E1);
        episodeRepository.save(episodeT47S1E2);
        episodeRepository.save(episodeT47S1E3);
        episodeRepository.save(episodeT47S1E4);

        genreRepository.save(genreC47G1);
        genreRepository.save(genreC47G2);

        actorRepository.save(actorC47A1);
        actorRepository.save(actorC47A2);
        actorRepository.save(actorC47A3);
        actorRepository.save(actorC47A4);
        actorRepository.save(actorC47A5);

        //endregion

        Content content48 = Content.builder()
                .title("Better Call Saul")
                .description("The trials and tribulations of criminal lawyer Jimmy McGill in the years leading up to his fateful run-in with Walter White and Jesse Pinkman.")
                .spokenLanguage("English")
                .releaseDate(" 8 February 2015")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(43)
                .build();

        Genre genreC48G1 = Genre.builder()
                .name("Crime")
                .content(content48)
                .build();

        Genre genreC48G2 = Genre.builder()
                .name("Drama")
                .content(content48)
                .build();

        Actor actorC48A1 = Actor.builder()
                .fullname("Bob Odenkirk")
                .imageUrl(null)
                .content(content48)
                .build();

        Actor actorC48A2 = Actor.builder()
                .fullname("Jonathan Banks")
                .imageUrl(null)
                .content(content47)
                .build();

        Actor actorC48A3 = Actor.builder()
                .fullname("Rhea Seehorn")
                .imageUrl(null)
                .content(content47)
                .build();



        TVSeries tvSeries48 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content48)
                .build();

        Creator creatorT48C1 = Creator.builder()
                .fullname("High Bridge Productions")
                .imageUrl(null)
                .tvSeries(tvSeries48)
                .build();


        Season seasonT48S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries48)
                .build();

        Episode episodeT48S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Uno")
                .description("Struggling public defender Jimmy McGill constructs an elaborate yet questionable plan for winning back a pair of wealthy potential clients.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        Episode episodeT48S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Mijo")
                .description("Jimmy's latest scam has gone horribly wrong and he's face-to-face with violent criminals and being forced to talk his way out of a life-threatening situation.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        Episode episodeT48S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Nacho")
                .description("Jimmy must prove that Nacho is innocent when he is wrongly suspected of kidnapping.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        Episode episodeT48S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Hero")
                .description("Jimmy makes a bold move against Hamlin in an effort to attract potential clients.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        Episode episodeT48S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Alpine Shepherd Boy")
                .description("After a strange encounter with the police, Chuck ends up in the hospital. Jimmy meets up with a series of unruly clients.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        Episode episodeT48S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Five-O")
                .description("Mike's days as a police officer in Philadelphia catch up to him when he's questioned about a tragic event from his past.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT48S1)
                .build();

        tVSeriesRepository.save(tvSeries48);

        creatorRepository.save(creatorT48C1);

        seasonRepository.save(seasonT48S1);

        episodeRepository.save(episodeT48S1E1);
        episodeRepository.save(episodeT48S1E2);
        episodeRepository.save(episodeT48S1E3);
        episodeRepository.save(episodeT48S1E4);
        episodeRepository.save(episodeT48S1E5);
        episodeRepository.save(episodeT48S1E6);

        genreRepository.save(genreC48G1);
        genreRepository.save(genreC48G2);

        actorRepository.save(actorC48A1);
        actorRepository.save(actorC48A2);
        actorRepository.save(actorC48A3);


        //endregion

        Content content49 = Content.builder()
                .title("Sons Of Anarchy")
                .description("A biker struggles to balance being a father and being involved in an outlaw motorcycle club.")
                .spokenLanguage("English")
                .releaseDate("3 September 2008")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(45)
                .build();

        Genre genreC49G1 = Genre.builder()
                .name("Crime")
                .content(content49)
                .build();

        Genre genreC49G2 = Genre.builder()
                .name("Drama")
                .content(content49)
                .build();

        Genre genreC49G3 = Genre.builder()
                .name("Thriller")
                .content(content49)
                .build();

        Actor actorC49A1 = Actor.builder()
                .fullname("Charlie Hunnam")
                .imageUrl(null)
                .content(content49)
                .build();

        Actor actorC49A2 = Actor.builder()
                .fullname("Katey Sagal")
                .imageUrl(null)
                .content(content49)
                .build();

        Actor actorC49A3 = Actor.builder()
                .fullname("Mark Boone Junior")
                .imageUrl(null)
                .content(content49)
                .build();

        Actor actorC49A4 = Actor.builder()
                .fullname("Kim Coates")
                .imageUrl(null)
                .content(content49)
                .build();

        TVSeries tvSeries49 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content49)
                .build();

        Creator creatorT49C1 = Creator.builder()
                .fullname("Fox 21")
                .imageUrl(null)
                .tvSeries(tvSeries49)
                .build();


        Season seasonT49S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries49)
                .build();

        Episode episodeT49S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Pilot")
                .description("A rival gang steals the Sons' stockpile of assault rifles, while Jax's ex-wife's drug overdose leads to an emergency c-section and life-threatening surgery for their baby.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT49S1)
                .build();

        Episode episodeT49S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Seeds")
                .description("The club deals with the aftermath of their firearms warehouse attack as a new Deputy Chief of Police poses a new threat to SAMCRO.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT49S1)
                .build();

        Episode episodeT49S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Fun Town")
                .description("When a daughter of a Charming family is assaulted during a carnival, SAMCRO seeks justice and races against authorities to capture the assailant.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT49S1)
                .build();

        tVSeriesRepository.save(tvSeries49);

        creatorRepository.save(creatorT49C1);

        seasonRepository.save(seasonT49S1);

        episodeRepository.save(episodeT49S1E1);
        episodeRepository.save(episodeT49S1E2);
        episodeRepository.save(episodeT49S1E3);

        genreRepository.save(genreC49G1);
        genreRepository.save(genreC49G2);
        genreRepository.save(genreC49G3);

        actorRepository.save(actorC49A1);
        actorRepository.save(actorC49A2);
        actorRepository.save(actorC49A3);
        actorRepository.save(actorC49A4);

        //endregion

        Content content50 = Content.builder()
                .title("Vikings: Valhalla")
                .description("Follow-up series to 'Vikings' set 100 years afterward and centering on the adventures of Leif Erikson, Freydis, Harald Hardrada and the Norman King William the Conqueror.")
                .spokenLanguage("English")
                .releaseDate("25 February 2022")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(30)
                .build();

        Genre genreC50G1 = Genre.builder()
                .name("Action")
                .content(content50)
                .build();

        Genre genreC50G2 = Genre.builder()
                .name("Adventure")
                .content(content50)
                .build();

        Genre genreC50G3 = Genre.builder()
                .name("Drama")
                .content(content50)
                .build();

        Actor actorC50A1 = Actor.builder()
                .fullname("Sam Corlett")
                .imageUrl(null)
                .content(content50)
                .build();


        TVSeries tvSeries50 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content50)
                .build();

        Creator creatorT50C1 = Creator.builder()
                .fullname("Netflix Streaming Services")
                .imageUrl(null)
                .tvSeries(tvSeries50)
                .build();


        Season seasonT50S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries50)
                .build();

        Episode episodeT50S1E1 = Episode.builder()
                .episodeNo(1)
                .title("The Web of Fate")
                .description("Olaf lands in a terrible position after Forkbeard invades Kattegat. In hiding, Freydis and Harald must decide whether to fight for the throne or flee.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT50S1)
                .build();

        Episode episodeT50S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Towers of Faith")
                .description("Freydis founds a new home. Harald formulates a new plan to take back Norway, but Leif's not on board. A new threat appears in London.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT50S1)
                .build();

        Episode episodeT50S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Pieces of the Gods")
                .description("While preparing for a journey to Constantinople, Harald assembles an unlikely crew, each with their own motives. Emma suspects Godwin of treachery.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT50S1)
                .build();

        Episode episodeT50S1E4 = Episode.builder()
                .episodeNo(4)
                .title("The Thaw")
                .description("The travellers makes a deadly miscalculation on the way to Constantinople. Olaf sets off after Harald, and Emma's paranoia pushes her over the edge.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT50S1)
                .build();

        tVSeriesRepository.save(tvSeries50);

        creatorRepository.save(creatorT50C1);

        seasonRepository.save(seasonT50S1);

        episodeRepository.save(episodeT50S1E1);
        episodeRepository.save(episodeT50S1E2);
        episodeRepository.save(episodeT50S1E3);
        episodeRepository.save(episodeT50S1E4);

        genreRepository.save(genreC50G1);
        genreRepository.save(genreC50G2);
        genreRepository.save(genreC50G3);

        actorRepository.save(actorC50A1);

        //endregion

        Content content51 = Content.builder()
                .title("Top Boy")
                .description("Two London drug dealers ply their lucrative trade at a public housing estate in East London.")
                .spokenLanguage("English")
                .releaseDate("31 October 2011")
                .imageUrl(null)
                .trailerUrl(null)
                .isAgeRestricted(false)
                .contentType(ContentType.TV_SERIES)
                .runtime(18)
                .build();

        Genre genreC51G1 = Genre.builder()
                .name("Crime")
                .content(content51)
                .build();

        Genre genreC51G2 = Genre.builder()
                .name("Drama")
                .content(content51)
                .build();

        Actor actorC51A1 = Actor.builder()
                .fullname("Ashley Walters")
                .imageUrl(null)
                .content(content51)
                .build();

        Actor actorC51A2 = Actor.builder()
                .fullname("Kane Robinson")
                .imageUrl(null)
                .content(content51)
                .build();


        TVSeries tvSeries51 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content51)
                .build();

        Creator creatorT51C1 = Creator.builder()
                .fullname("DreamCrew")
                .imageUrl(null)
                .tvSeries(tvSeries51)
                .build();


        Season seasonT51S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries51)
                .build();

        Episode episodeT51S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Chapter 1")
                .description("Young people living on the edge and, for the most part, living out of sight in East London today based around inner-city drug and gang culture.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT51S1)
                .build();

        Episode episodeT51S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Chapter 2")
                .description("Raikes gives Sully and Dushane two weeks to retrieve the stash stolen by rival Kamale and they find a mysterious present of guns to help them.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT51S1)
                .build();

        Episode episodeT51S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Chapter 3")
                .description("After Heather has shown him the flat she hopes to buy with her drugs money Ra'Nell welcomes his mother home. Sully visits his daughter but Chris bars Dushane from his house as a liability. ")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT51S1)
                .build();


        Episode episodeT51S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Chapter 4")
                .description("Dushane is shocked that Sully still has the gun which killed three people but he refuses to go along with Raikes' plan to sell him out as a liability.")
                .releaseDate(null)
                .imageUrl(null)
                .season(seasonT51S1)
                .build();

        tVSeriesRepository.save(tvSeries51);

        creatorRepository.save(creatorT51C1);

        seasonRepository.save(seasonT51S1);

        episodeRepository.save(episodeT51S1E1);
        episodeRepository.save(episodeT51S1E2);
        episodeRepository.save(episodeT51S1E3);
        episodeRepository.save(episodeT51S1E4);

        genreRepository.save(genreC51G1);
        genreRepository.save(genreC51G2);


        actorRepository.save(actorC51A1);
        actorRepository.save(actorC51A2);



        //region Content 99
        //-----------------Content 99----------------//
        Content content99 = Content.builder()
                .title("House of the Dragon")
                .description("An internal succession war within House Targaryen at the height of its power, 172 years before the birth of Daenerys Targaryen.")
                .spokenLanguage("English")
                .releaseDate("21 Aug 2022")
                .imageUrl("https://images3.alphacoders.com/124/1249834.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/DotnJ7tTA34\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.TV_SERIES)
                .runtime(57)
                .build();

        Genre genreC99G1 = Genre.builder()
                .name("Action")
                .content(content99)
                .build();

        Genre genreC99G2 = Genre.builder()
                .name("Adventure")
                .content(content99)
                .build();

        Genre genreC99G3 = Genre.builder()
                .name("Drama")
                .content(content99)
                .build();

        Actor actorC99A1 = Actor.builder()
                .fullname("Rhys Ifans")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/5/51/Rhys_Ifans_2011_cropped_%28cropped%29.jpg")
                .content(content99)
                .build();

        Actor actorC99A2 = Actor.builder()
                .fullname("Matt Smith")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b3/SDCC_2015_-_Matt_Smith.jpg")
                .content(content99)
                .build();

        Actor actorC99A3 = Actor.builder()
                .fullname("Fabien Frankel")
                .imageUrl(null)
                .content(content99)
                .build();

        TVSeries tvSeries99 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.ONGOING)
                .content(content99)
                .build();

        Creator creatorT99C99C1 = Creator.builder()
                .fullname("Ryan J. Condal")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/8/8a/RyanCondal.jpg")
                .tvSeries(tvSeries99)
                .build();

        Creator creatorT99C99C2 = Creator.builder()
                .fullname("George R.R. Martin")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/e/ed/Portrait_photoshoot_at_Worldcon_75%2C_Helsinki%2C_before_the_Hugo_Awards_%E2%80%93_George_R._R._Martin.jpg")
                .tvSeries(tvSeries99)
                .build();


        Season seasonT99S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries99)
                .build();

        Episode episodeT99S1E1 = Episode.builder()
                .episodeNo(1)
                .title("The Heirs of the Dragon")
                .description("Viserys hosts a tournament to celebrate the birth of his second child. Rhaenyra welcomes her uncle Daemon back to the Red Keep.")
                .releaseDate("21 Aug 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E2 = Episode.builder()
                .episodeNo(2)
                .title("The Rogue Prince")
                .description("Rhaenyra oversteps at the Small Council. Viserys is urged to secure the succession through marriage. Daemon announces his intentions.")
                .releaseDate("28 Aug 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Second of His Name")
                .description("Daemon and the Sea Snake battle the Crabfeeder. The realm celebrates Aegon's second nameday. Rhaenyra faces the prospect of marriage.")
                .releaseDate("4 Sep 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E4 = Episode.builder()
                .episodeNo(4)
                .title("King of the Narrow Sea")
                .description("Rhaenyra continues her search for a suitable match, Daemon returns to Kings Landing and stirs more trouble for the King. Rhaenyra learns a valuable lesson.")
                .releaseDate("11 Sep 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E5 = Episode.builder()
                .episodeNo(5)
                .title("We Light the Way")
                .description("Daemon visits his wife in the Vale. Viserys and Rhaenyra broker agreements with the Velaryons. Alicent seeks the truth about the princess.")
                .releaseDate("18 Sep 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E6 = Episode.builder()
                .episodeNo(6)
                .title("The Princess and the Queen")
                .description("Ten years later. Rhaenyra navigates Alicent's continued speculation about her children, while Daemon and Laena weigh an offer in Pentos.")
                .releaseDate("25 Sep 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E7 = Episode.builder()
                .episodeNo(7)
                .title("Driftmark")
                .description("As the families gather on Driftmark for a funeral, Viserys calls for an end to infighting and Alicent demands justice.")
                .releaseDate("2 Oct 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E8 = Episode.builder()
                .episodeNo(8)
                .title("The Lord of the Tides")
                .description("Six years later. With the Driftmark succession suddenly critical, Rhaenyra attempts to strike a bargain with Rhaenys.")
                .releaseDate("9 Oct 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E9 = Episode.builder()
                .episodeNo(9)
                .title("The Green Council")
                .description("While Alicent enlists Cole and Aemond to track down Aegon, Otto gathers the great houses of Westeros to affirm their allegiance.")
                .releaseDate("16 Oct 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();

        Episode episodeT99S1E10 = Episode.builder()
                .episodeNo(10)
                .title("The Black Queen")
                .description("While mourning a tragic loss, Rhaenyra tries to hold the realm together, and Daemon prepares for war.")
                .releaseDate("23 Oct 2022")
                .imageUrl(null)
                .season(seasonT99S1)
                .build();


        tVSeriesRepository.save(tvSeries99);
        creatorRepository.save(creatorT99C99C1);
        creatorRepository.save(creatorT99C99C2);
        seasonRepository.save(seasonT99S1);
        episodeRepository.save(episodeT99S1E1);
        episodeRepository.save(episodeT99S1E2);
        episodeRepository.save(episodeT99S1E3);
        episodeRepository.save(episodeT99S1E4);
        episodeRepository.save(episodeT99S1E5);
        episodeRepository.save(episodeT99S1E6);
        episodeRepository.save(episodeT99S1E7);
        episodeRepository.save(episodeT99S1E8);
        episodeRepository.save(episodeT99S1E9);
        episodeRepository.save(episodeT99S1E10);

        genreRepository.save(genreC99G1);
        genreRepository.save(genreC99G2);
        genreRepository.save(genreC99G3);
        actorRepository.save(actorC99A1);
        actorRepository.save(actorC99A2);
        actorRepository.save(actorC99A3);

        //endregion

        //region Content 100
        //-----------------Content 100----------------//
        Content content100 = Content.builder()
                .title("The Punisher")
                .description("After his revenge on those who murdered his family, aimless Marine veteran Frank Castle finds a new meaning in life as a vigilante known as \"The Punisher\".")
                .spokenLanguage("English")
                .releaseDate("17 Nov 2017")
                .imageUrl("https://images3.alphacoders.com/865/865776.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sDp4AuNen0Y\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.TV_SERIES)
                .runtime(53)
                .build();

        Genre genreC100G1 = Genre.builder()
                .name("Action")
                .content(content100)
                .build();

        Genre genreC100G2 = Genre.builder()
                .name("Crime")
                .content(content100)
                .build();

        Genre genreC100G3 = Genre.builder()
                .name("Drama")
                .content(content100)
                .build();

        Actor actorC100A1 = Actor.builder()
                .fullname("Jon Bernthal")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/c/c3/Crop_of_Jon_Bernthal_by_Gage_Skidmore_3.jpg")
                .content(content100)
                .build();

        Actor actorC100A2 = Actor.builder()
                .fullname("Amber Rose Revah")
                .imageUrl(null)
                .content(content100)
                .build();

        Actor actorC100A3 = Actor.builder()
                .fullname("Ben Barnes")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/5/5e/Stuttgart_2021_-Comic_Con_Germany-_by-RaBoe_236.jpg")
                .content(content100)
                .build();

        TVSeries tvSeries100 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content100)
                .build();

        Creator creatorT100C100C1 = Creator.builder()
                .fullname("Steve Lightfoot")
                .imageUrl(null)
                .tvSeries(tvSeries100)
                .build();


        Season seasonT100S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries100)
                .build();

        Episode episodeT100S1E1 = Episode.builder()
                .episodeNo(1)
                .title("3 AM")
                .description("Former Marine Frank Castle takes the law into his own hands while struggling to come to terms with his traumatic past.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Two Dead Men")
                .description("A mysterious phone call forces Frank's hand. Meanwhile, Madani goes digging for suspects and Curtis delivers a message.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();


        Episode episodeT100S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Kandahar")
                .description("Frank skips the subtlety while interrogating Micro. Brutal memories of top-secret missions shed light on Frank's past.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Resupply")
                .description("Madani and Sam plan a delicate operation, Curtis tries to connect with Lewis, and Frank encourages Micro to get his hands dirty.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Gunner")
                .description("Frank and Micro go looking for answers from a reluctant witness. Madani and Sam learn of a looming investigation. Rawlins sees a ghost.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E6 = Episode.builder()
                .episodeNo(6)
                .title("The Judas Goat")
                .description("With Frank in bad shape, Micro calls on Curtis for help. Madani and Russo continue to mix business with pleasure. Lewis stands up for his rights.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E7 = Episode.builder()
                .episodeNo(7)
                .title("Crosshairs")
                .description("Lewis struggles with the ramifications of his actions. Frank and Micro pursue another face from the past. Madani and Sam go bug hunting.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E8 = Episode.builder()
                .episodeNo(8)
                .title("Cold Steel")
                .description("Russo opens up to Madani about his past, Sarah shares her concerns about her son with Frank, and a decoy operation takes a turn.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E9 = Episode.builder()
                .episodeNo(9)
                .title("Front Toward Enemy")
                .description("Following a deadly explosion, Karen lands in a bomber's crosshairs -- and Frank isn't happy about it. Meanwhile, Curtis makes a grisly discovery.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E10 = Episode.builder()
                .episodeNo(10)
                .title("Virtue of the Vicious")
                .description("An attack on a high-profile politician is examined (and reexamined) through different perspectives. Madani faces a painful truth.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E11 = Episode.builder()
                .episodeNo(11)
                .title("Danger Close")
                .description("As danger knocks on Sarah's door, Frank takes his quest for vengeance to the next level with some help from an unexpected ally.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E12 = Episode.builder()
                .episodeNo(12)
                .title("Home")
                .description("Frank makes a damning confession. A shootout leaves Sarah wondering what to believe. Rawlins goes in for the kill, once and for all.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Episode episodeT100S1E13= Episode.builder()
                .episodeNo(12)
                .title("Memento Mori")
                .description("As the authorities close in, an exhausted but unbroken Frank vows to put an end to the war that has consumed his life.")
                .releaseDate("17 Nov 2017")
                .imageUrl(null)
                .season(seasonT100S1)
                .build();

        Season seasonT100S2 = Season.builder()
                .seasonNo(2)
                .tvSeries(tvSeries100)
                .build();

        Episode episodeT100S2E1 = Episode.builder()
                .episodeNo(1)
                .title("Roadhouse Blues")
                .description("While driving through Michigan, Frank stops for a beer at a roadside bar. But staying out of trouble has never been his strong suit.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E2 = Episode.builder()
                .episodeNo(2)
                .title("Fight or Flight")
                .description("Frank and a reluctant Rachel go on the run as a menacing adversary gives chase. Meanwhile, Madani pays Russo an unwelcome visit.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();


        Episode episodeT100S2E3 = Episode.builder()
                .episodeNo(3)
                .title("Trouble the Water")
                .description("As Pilgrim's past comes into focus, Frank and Rachel find themselves in police custody, where they're anything but safe.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();


        Episode episodeT100S2E4 = Episode.builder()
                .episodeNo(4)
                .title("Scar Tissue")
                .description("Rachel recalls the night everything changed and lets Frank in on the truth about her name. Russo sits down with a face from his childhood.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E5 = Episode.builder()
                .episodeNo(5)
                .title("One-Eyed Jacks")
                .description("It's not a trap if you know it's coming: That's Frank's philosophy. Madani opens up and Pilgrim plans a visit to an unholy land.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E6 = Episode.builder()
                .episodeNo(6)
                .title("Nakazat")
                .description("Amy (formerly Rachel) develops photographs that point to a conspiracy. Russo reads his own report. Madani's story about Russo comes under fire.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E7 = Episode.builder()
                .episodeNo(7)
                .title("One Bad Day")
                .description("Madani's quest to ID Pilgrim hits a wall. Russo and his crew put their plan into action. Frank encounters someone from the past.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E8 = Episode.builder()
                .episodeNo(8)
                .title("My Brother's Keeper")
                .description("Painful memories take ahold of Russo. Frank's frustration frightens those closest to him. Madani receives a visitor bearing a warning.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E9 = Episode.builder()
                .episodeNo(9)
                .title("Flustercluck")
                .description("A big bounty inspires New York's worst to pursue the Punisher. A restless Amy seeks help from a fellow grifter. Russo and Krista consider the future.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E10 = Episode.builder()
                .episodeNo(10)
                .title("The Dark Hearts of Men")
                .description("As Madani and Krista debate who's worth saving, Frank prepares to storm Russo's territory. A brutal encounter pushes Pilgrim back into old habits.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E11 = Episode.builder()
                .episodeNo(11)
                .title("The Abyss")
                .description("Amy rushes to protect Frank, who lies defenseless in a hospital. Pilgrim gets some crushing news, and Karen Page calls in a favor.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E12 = Episode.builder()
                .episodeNo(12)
                .title("Collision Course")
                .description("Buckle up -- Mahoney and Frank are about to take a ride to remember. Amy makes an entrance, Russo cashes out, and Madani comes clean to Krista.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();

        Episode episodeT100S2E13 = Episode.builder()
                .episodeNo(13)
                .title("The Whirlwind")
                .description("Frank, Pilgrim, Madani, Russo, Amy, Curt and the Schultz family. No bullet is left unspent as season two comes to an explosive conclusion.")
                .releaseDate("18 Jan 2019")
                .imageUrl(null)
                .season(seasonT100S2)
                .build();



        tVSeriesRepository.save(tvSeries100);
        creatorRepository.save(creatorT100C100C1);

        seasonRepository.save(seasonT100S1);
        episodeRepository.save(episodeT100S1E1);
        episodeRepository.save(episodeT100S1E2);
        episodeRepository.save(episodeT100S1E3);
        episodeRepository.save(episodeT100S1E4);
        episodeRepository.save(episodeT100S1E5);
        episodeRepository.save(episodeT100S1E6);
        episodeRepository.save(episodeT100S1E7);
        episodeRepository.save(episodeT100S1E8);
        episodeRepository.save(episodeT100S1E9);
        episodeRepository.save(episodeT100S1E10);
        episodeRepository.save(episodeT100S1E11);
        episodeRepository.save(episodeT100S1E12);
        episodeRepository.save(episodeT100S1E13);
        seasonRepository.save(seasonT100S2);
        episodeRepository.save(episodeT100S2E1);
        episodeRepository.save(episodeT100S2E2);
        episodeRepository.save(episodeT100S2E3);
        episodeRepository.save(episodeT100S2E4);
        episodeRepository.save(episodeT100S2E5);
        episodeRepository.save(episodeT100S2E6);
        episodeRepository.save(episodeT100S2E7);
        episodeRepository.save(episodeT100S2E8);
        episodeRepository.save(episodeT100S2E9);
        episodeRepository.save(episodeT100S2E10);
        episodeRepository.save(episodeT100S2E11);
        episodeRepository.save(episodeT100S2E12);
        episodeRepository.save(episodeT100S2E13);

        genreRepository.save(genreC100G1);
        genreRepository.save(genreC100G2);
        genreRepository.save(genreC100G3);
        actorRepository.save(actorC100A1);
        actorRepository.save(actorC100A2);
        actorRepository.save(actorC100A3);

        //endregion

        //region Content 101
        //-----------------Content 101----------------//
        Content content101 = Content.builder()
                .title("Taboo")
                .description("Adventurer James Keziah Delaney returns to London during the War of 1812 to rebuild his late father's shipping empire. However, both the government and his biggest competitor want his inheritance at any cost--even murder.")
                .spokenLanguage("English")
                .releaseDate("10 Jan 2017")
                .imageUrl("https://images6.alphacoders.com/907/907236.jpg")
                .trailerUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/W1fiijqrKuc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")
                .isAgeRestricted(true)
                .contentType(ContentType.TV_SERIES)
                .runtime(59)
                .build();

        Genre genreC101G1 = Genre.builder()
                .name("Drama")
                .content(content101)
                .build();

        Genre genreC101G2 = Genre.builder()
                .name("Mystery")
                .content(content101)
                .build();

        Genre genreC101G3 = Genre.builder()
                .name("Thriller")
                .content(content101)
                .build();

        Actor actorC101A1 = Actor.builder()
                .fullname("Tom Hardy")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/4/43/Tom_Hardy_by_Gage_Skidmore.jpg")
                .content(content101)
                .build();

        Actor actorC101A2 = Actor.builder()
                .fullname("David Hayman")
                .imageUrl(null)
                .content(content101)
                .build();

        Actor actorC101A3 = Actor.builder()
                .fullname("Jonathan Pryce")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7b/Jonathan_Pryce_Cannes_2018.jpg")
                .content(content101)
                .build();

        TVSeries tvSeries101 = TVSeries.builder()
                .tvSeriesStatusType(TVSeriesStatusType.COMPLETED)
                .content(content101)
                .build();

        Creator creatorT101C101C1 = Creator.builder()
                .fullname("Steven Knight")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/f/f9/Portrait_of_Steven_Knight_by_Taylor_Rooke%2C_March_5th_2020.jpg")
                .tvSeries(tvSeries101)
                .build();

        Creator creatorT101C101C2 = Creator.builder()
                .fullname("Chips Hardy")
                .imageUrl(null)
                .tvSeries(tvSeries101)
                .build();

        Creator creatorT101C101C3 = Creator.builder()
                .fullname("Tom Hardy")
                .imageUrl("https://upload.wikimedia.org/wikipedia/commons/4/43/Tom_Hardy_by_Gage_Skidmore.jpg")
                .tvSeries(tvSeries101)
                .build();


        Season seasonT101S1 = Season.builder()
                .seasonNo(1)
                .tvSeries(tvSeries101)
                .build();

        Episode episodeT101S1E1 = Episode.builder()
                .episodeNo(1)
                .title("Episode #1.1")
                .description("After being presumed dead, James Delaney resurfaces in London seeking revenge for the death of his father and inheriting the family shipping empire, which threatens the ambitions of his half-sister and the East India Company.")
                .releaseDate("10 Jan 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E2 = Episode.builder()
                .episodeNo(2)
                .title("Episode #1.2")
                .description("Despite Delaney's return to London setting tongues wagging, he enlists allies in his quest to reclaim his legacy, while an unexpected arrival at the reading of the will disrupts his plans and reveals the nature of his inheritance.")
                .releaseDate("17 Jan 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E3 = Episode.builder()
                .episodeNo(3)
                .title("Episode #1.3")
                .description("Delaney receives medical help from an unexpected source, before outwitting the East India Company, which turns its attentions to Delaney's new ally, Lorna.")
                .releaseDate("24 Jan. 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E4 = Episode.builder()
                .episodeNo(4)
                .title("Episode #1.4")
                .description("The plot against Delaney puts Lorna in danger, Delaney enlists help for a scheme of his own, and an invitation to an opulent ball leads to unexpected consequences.")
                .releaseDate("31 Jan. 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E5 = Episode.builder()
                .episodeNo(5)
                .title("Episode #1.5")
                .description("A duel at dawn takes a surprising turn, Zilpha is met with darkness, the East India Company is under investigation, and Delaney faces a race against time to keep his plot a secret.")
                .releaseDate("7 Feb 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E6 = Episode.builder()
                .episodeNo(6)
                .title("Episode #1.6")
                .description("When his plot is betrayed and Zilpha takes drastic action against her husband, Delaney faces all out chaos, complicated further by a family revelation and the increasingly desperate East India Company.")
                .releaseDate("14 Feb 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E7 = Episode.builder()
                .episodeNo(7)
                .title("Episode #1.7")
                .description("A tragic event leads to the betrayal of Delaney, who must use all of his wits and strength to salvage his plans.")
                .releaseDate("21 Feb 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();

        Episode episodeT101S1E8 = Episode.builder()
                .episodeNo(8)
                .title("Episode #1.8")
                .description("Delaney delivers an ultimatum, arrangements for immediate departure begin, while Strange has a final ace to play.")
                .releaseDate("28 Feb. 2017")
                .imageUrl(null)
                .season(seasonT101S1)
                .build();


        tVSeriesRepository.save(tvSeries101);
        creatorRepository.save(creatorT101C101C1);
        creatorRepository.save(creatorT101C101C2);
        creatorRepository.save(creatorT101C101C3);

        seasonRepository.save(seasonT101S1);
        episodeRepository.save(episodeT101S1E1);
        episodeRepository.save(episodeT101S1E2);
        episodeRepository.save(episodeT101S1E3);
        episodeRepository.save(episodeT101S1E4);
        episodeRepository.save(episodeT101S1E5);
        episodeRepository.save(episodeT101S1E6);
        episodeRepository.save(episodeT101S1E7);
        episodeRepository.save(episodeT101S1E8);


        genreRepository.save(genreC101G1);
        genreRepository.save(genreC101G2);
        genreRepository.save(genreC101G3);
        actorRepository.save(actorC101A1);
        actorRepository.save(actorC101A2);
        actorRepository.save(actorC101A3);

        //endregion


        //region Rating 1
        //-----------------Rating 1----------------//
        Rating rating1 = Rating.builder()
                .rating(7.4f)
                .profile(profileA1P1)
                .content(content1)
                .build();

        ratingRepository.save(rating1);
        //endregion

        //region Rating 2
        //-----------------Rating 2----------------//
        Rating rating2 = Rating.builder()
                .rating(6.6f)
                .profile(profileA1P3)
                .content(content1)
                .build();

        ratingRepository.save(rating2);
        //endregion

        //region Rating 3
        //-----------------Rating 3----------------//
        Rating rating3 = Rating.builder()
                .rating(6.8f)
                .profile(profileA1P1)
                .content(content2)
                .build();

        ratingRepository.save(rating3);
        //endregion

        //region Rating 4
        //-----------------Rating 4----------------//
        Rating rating4 = Rating.builder()
                .rating(6.5f)
                .profile(profileA3P1)
                .content(content2)
                .build();

        ratingRepository.save(rating4);
        //endregion

        //region Rating 5
        //-----------------Rating 5----------------//
        Rating rating5 = Rating.builder()
                .rating(6.5f)
                .profile(profileA1P1)
                .content(content3)
                .build();

        ratingRepository.save(rating5);
        //endregion

        //region Rating 6
        //-----------------Rating 6----------------//
        Rating rating6 = Rating.builder()
                .rating(7.2f)
                .profile(profileA2P1)
                .content(content3)
                .build();

        ratingRepository.save(rating6);
        //endregion

        //region Rating 7
        //-----------------Rating 7----------------//
        Rating rating7 = Rating.builder()
                .rating(5.2f)
                .profile(profileA3P1)
                .content(content3)
                .build();

        ratingRepository.save(rating7);
        //endregion

        //region Rating 8
        //-----------------Rating 8----------------//
        Rating rating8 = Rating.builder()
                .rating(7.0f)
                .profile(profileA5P1)
                .content(content4)
                .build();

        ratingRepository.save(rating8);
        //endregion

        //region Rating 9
        //-----------------Rating 9----------------//
        Rating rating9 = Rating.builder()
                .rating(6.3f)
                .profile(profileA2P1)
                .content(content4)
                .build();

        ratingRepository.save(rating9);
        //endregion

        //region Rating 10
        //-----------------Rating 10----------------//
        Rating rating10 = Rating.builder()
                .rating(8.8f)
                .profile(profileA1P3)
                .content(content6)
                .build();

        ratingRepository.save(rating10);
        //endregion

        //region Rating 11
        //-----------------Rating 11----------------//
        Rating rating11 = Rating.builder()
                .rating(8.2f)
                .profile(profileA6P2)
                .content(content6)
                .build();

        ratingRepository.save(rating11);
        //endregion


    }
}
