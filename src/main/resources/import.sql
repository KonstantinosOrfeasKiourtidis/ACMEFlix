insert into CONTENTS (ID, CONTENT_TYPE, DESCRIPTION, IMAGE_URL, IS_AGE_RESTRICTED, RELEASE_DATE, RUNTIME, SPOKEN_LANGUAGE, TITLE, TRAILER_URL) values (1, 'TV_SERIES', 'Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.', 'https://images.alphacoders.com/478/478372.jpg', TRUE, '17 Apr 2011', 57, 'English', 'Game of Thrones', '<iframe width="560" height="315" src="https://www.youtube.com/embed/KPLWWIOCOOQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>');
insert into CONTENTS (ID, CONTENT_TYPE, DESCRIPTION, IMAGE_URL, IS_AGE_RESTRICTED, RELEASE_DATE, RUNTIME, SPOKEN_LANGUAGE, TITLE, TRAILER_URL) values (2, 'TV_SERIES', 'When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.', 'https://images2.alphacoders.com/879/879599.png', FALSE, '15 Jul 2016', 51, 'English', 'Stranger Things', '<iframe width="560" height="315" src="https://www.youtube.com/embed/b9EkMc79ZSU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>');
insert into CONTENTS (ID, CONTENT_TYPE, DESCRIPTION, IMAGE_URL, IS_AGE_RESTRICTED, RELEASE_DATE, RUNTIME, SPOKEN_LANGUAGE, TITLE, TRAILER_URL) values (3, 'MOVIE', 'Famed Southern detective Benoit Blanc travels to Greece for his latest case.', 'https://images2.alphacoders.com/128/1287184.jpg', FALSE, '23 Dec 2022', 140, 'English', 'Glass Onion: A Knives Out Mystery', '<iframe width="560" height="315" src="https://www.youtube.com/embed/-xR_lBtEvSc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>');
insert into CONTENTS (ID, CONTENT_TYPE, DESCRIPTION, IMAGE_URL, IS_AGE_RESTRICTED, RELEASE_DATE, RUNTIME, SPOKEN_LANGUAGE, TITLE, TRAILER_URL) values (4, 'MOVIE', 'Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Navi race to protect their home.', 'https://images6.alphacoders.com/128/1286476.jpg', FALSE, '16 Dec 2022', 192, 'English', 'Avatar: The Way of Water', '<iframe width="560" height="315" src="https://www.youtube.com/embed/d9MyW72ELq0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>');

insert into GENRES (ID, NAME, CONTENT_ID) values (1, 'Action', 1);
insert into GENRES (ID, NAME, CONTENT_ID) values (2, 'Adventure', 1);
insert into GENRES (ID, NAME, CONTENT_ID) values (3, 'Drama', 1);
insert into GENRES (ID, NAME, CONTENT_ID) values (4, 'Drama', 2);
insert into GENRES (ID, NAME, CONTENT_ID) values (5, 'Fantasy', 2);
insert into GENRES (ID, NAME, CONTENT_ID) values (6, 'Horror', 2);
insert into GENRES (ID, NAME, CONTENT_ID) values (7, 'Comedy', 3);
insert into GENRES (ID, NAME, CONTENT_ID) values (8, 'Drama', 3);
insert into GENRES (ID, NAME, CONTENT_ID) values (9, 'Crime', 3);
insert into GENRES (ID, NAME, CONTENT_ID) values (10, 'Action', 4);
insert into GENRES (ID, NAME, CONTENT_ID) values (11, 'Adventure', 4);
insert into GENRES (ID, NAME, CONTENT_ID) values (12, 'Fantasy', 4);

insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (1, 'Emilia Clarke', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Emilia_Clarke_Dior_Rose_des_Vents.jpg/900px-Emilia_Clarke_Dior_Rose_des_Vents.jpg', 1);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (2, 'Peter Dinklage', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Peter_Dinklage_by_Gage_Skidmore.jpg/330px-Peter_Dinklage_by_Gage_Skidmore.jpg', 1);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (3, 'Kit Harington', 'https://upload.wikimedia.org/wikipedia/commons/3/32/Kit_harrington_by_sachyn_mital_%28cropped_2%29.jpg', 1);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (4, 'Millie Bobby Brown', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Millie_Bobby_Brown_-_MBB_-_Portrait_1_-_SFM5_-_July_10%2C_2022_at_Stranger_Fan_Meet_5_People_Convention_%28cropped%29.jpg/330px-Millie_Bobby_Brown_-_MBB_-_Portrait_1_-_SFM5_-_July_10%2C_2022_at_Stranger_Fan_Meet_5_People_Convention_%28cropped%29.jpg', 2);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (5, 'Finn Wolfhard', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Finn_Wolfhard_by_Gage_Skidmore_2.jpg/654px-Finn_Wolfhard_by_Gage_Skidmore_2.jpg', 2);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (6, 'Winona Ryder', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Winona_Ryder_2010_TIFF.jpg/800px-Winona_Ryder_2010_TIFF.jpg', 2);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (7, 'Daniel Craig', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Daniel_Craig_in_2021.jpg/330px-Daniel_Craig_in_2021.jpg', 3);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (8, 'Edward Norton', 'https://upload.wikimedia.org/wikipedia/commons/3/35/Ed_Norton_Shankbone_Metropolitan_Opera_2009.jpg', 3);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (9, 'Kate Hudson', 'https://upload.wikimedia.org/wikipedia/commons/6/61/Kate_Hudson_%288033413872%29_%28cropped%29.jpg', 3);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (10, 'Sam Worthington', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Sam_Worthington_4%2C_2013.jpg/330px-Sam_Worthington_4%2C_2013.jpg', 4);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (11, 'Zoe Saldana', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Zoe_Saldana_by_Gage_Skidmore_3.jpg/582px-Zoe_Saldana_by_Gage_Skidmore_3.jpg', 4);
insert into ACTORS (ID, FULLNAME, IMAGE_URL, CONTENT_ID) values (12, 'Sigourney Weaver', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Sigourney_Weaver_by_Gage_Skidmore_4.jpg/330px-Sigourney_Weaver_by_Gage_Skidmore_4.jpg', 4);

insert into MOVIES (ID, CONTENT_ID) values (1, 3);
insert into MOVIES (ID, CONTENT_ID) values (2, 4);

insert into TV_SERIES (ID, TV_SERIES_STATUS_TYPE, CONTENT_ID) values (1, 'COMPLETED', 1);
insert into TV_SERIES (ID, TV_SERIES_STATUS_TYPE, CONTENT_ID) values (2, 'ONGOING', 2);

insert into SEASONS (ID, SEASON_NO, TV_SERIES_ID) values (1, 1, 1);
insert into SEASONS (ID, SEASON_NO, TV_SERIES_ID) values (2, 2, 1);
insert into SEASONS (ID, SEASON_NO, TV_SERIES_ID) values (3, 1, 2);

insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (1, 'Eddard Stark is torn between his family and an old friend when asked to serve at the side of King Robert Baratheon; Viserys plans to wed his sister to a nomadic warlord in exchange for an army.', 1, NULL, '17 Apr. 2011', 'Winter Is Coming', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (2, 'While Bran recovers from his fall, Ned takes only his daughters to Kings Landing. Jon Snow goes with his uncle Benjen to the Wall. Tyrion joins them.', 2, NULL, '24 Apr. 2011', 'The Kingsroad', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (3, 'Jon begins his training with the Nights Watch; Ned confronts his past and future at Kings Landing; Daenerys finds herself at odds with Viserys.', 3, NULL, '1 May 2011', 'Lord Snowg', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (4, 'Eddard investigates Jon Arryns murder. Jon befriends Samwell Tarly, a coward who has come to join the Nights Watch.', 4, NULL, '8 May 2011', 'Cripples, Bastards, and Broken Things', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (5, 'Catelyn has captured Tyrion and plans to bring him to her sister, Lysa Arryn, at the Vale, to be tried for his, supposed, crimes against Bran. Robert plans to have Daenerys killed, but Eddard refuses to be a part of it and quits.', 5, NULL, '15 May 2011', 'The Wolf and the Lion', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (6, 'While recovering from his battle with Jaime, Eddard is forced to run the kingdom while Robert goes hunting. Tyrion demands a trial by combat for his freedom. Viserys is losing his patience with Drogo.', 6, NULL, '22 May 2011', 'A Golden Crown', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (7, 'Robert has been injured while hunting and is dying. Jon and the others finally take their vows to the Nights Watch. A man, sent by Robert, is captured for trying to poison Daenerys. Furious, Drogo vows to attack the Seven Kingdoms.', 7, NULL, '29 May 2011', 'You Win or You Die', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (8, 'The Lannisters press their advantage over the Starks; Robb rallies his fathers northern allies and heads south to war; The White Walkers attack the Wall; Tyrion returns to his father with some new friends.', 8, NULL, '5 Jun. 2011', 'The Pointy End', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (9, 'Robb goes to war against the Lannisters. Jon finds himself struggling on deciding if his place is with Robb or the Nights Watch. Drogo has fallen ill from a fresh battle wound. Daenerys is desperate to save him.', 9, NULL, '12 Jun. 2011', 'Baelor', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (10, 'Robb vows to get revenge on the Lannisters. Jon must officially decide if his place is with Robb or the Nights Watch. Daenerys says her final goodbye to Drogo.', 10, NULL, '19 Jun. 2011', 'Fire and Blood', 1);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (11, 'Tyrion arrives at Kings Landing to take his fathers place as Hand of the King. Stannis Baratheon plans to take the Iron Throne for his own. Robb tries to decide his next move in the war. The Nights Watch arrive at the house of Craster.', 1, NULL, '1 Apr. 2012', 'The North Remembers', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (12, 'Arya makes friends with Gendry. Tyrion tries to take control of the Small Council. Theon arrives at his home, Pyke, in order to persuade his father into helping Robb with the war. Jon tries to investigate Crasters secret.', 2, NULL, '8 Apr. 2012', 'The Night Lands', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (13, 'Tyrion tries to see who he can trust in the Small Council. Catelyn visits Renly to try and persuade him to join Robb in the war. Theon must decide if his loyalties lie with his own family or with Robb.', 3, NULL, '15 Apr. 2012', 'What Is Dead May Never Die', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (14, 'Lord Baelish arrives at Renlys camp just before he faces off against Stannis. Daenerys and her company are welcomed into the city of Qarth. Arya, Gendry, and Hot Pie find themselves imprisoned at Harrenhal.', 4, NULL, '22 Apr. 2012', 'Garden of Boness', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (15, 'Tyrion investigates a secret weapon that King Joffrey plans to use against Stannis. Meanwhile, as a token for saving his life, Jaqen Hghar offers to kill three people that Arya chooses.', 5, NULL, '29 Apr. 2012', 'The Ghost of Harrenhal', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (16, 'Theon seizes control of Winterfell. Jon captures a wildling, named Ygritte. The people of Kings Landing begin to turn against King Joffrey. Daenerys looks to buy ships to sail for the Seven Kingdoms.', 6, NULL, '6 May 2012', 'The Old Gods and the New', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (17, 'Bran and Rickon have escaped Winterfell. Theon tries to hunt them down. Daenerys dragons have been stolen. Jon travels through the wilderness with Ygritte as his prisoner. Sansa has bled and is now ready to have Joffreys children.', 7, NULL, '13 May 2012', 'A Man Without Honor', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (18, 'Stannis is just days from Kings Landing. Tyrion prepares for his arrival. Jon and Qhorin are taken prisoner by the wildlings. Catelyn is arrested for releasing Jaime. Arya, Gendry, and Hot Pie plan to escape from Harrenhal.', 8, NULL, '20 May 2012', 'The Prince of Winterfell', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (19, 'Stannis Baratheons fleet and army arrive at Kings Landing and the battle for the city begins. Cersei plans for her and her childrens future.', 9, NULL, '27 May 2012', 'Blackwater', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (20, 'Joffrey puts Sansa aside for Margaery Tyrell. Robb marries Talisa Maegyr. Jon prepares to meet Mance Rayder. Arya says farewell to Jaqen Hghar. Daenerys tries to rescue her dragons.', 10, NULL, '3 Jun. 2012', 'Valar Morghulis', 2);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (21, 'At the U.S. Dept. of Energy an unexplained event occurs. Then when a young Dungeons and Dragons playing boy named Will disappears after a night with his friends, his mother Joyce and the town of Hawkins are plunged into darkness.', 1, NULL, '15 Jul. 2016', 'Chapter One: The Vanishing of Will Byers', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (22, 'Mike hides the mysterious girl in his house. Joyce gets a strange phone call.', 2, NULL, '15 Jul. 2016', 'Chapter Two: The Weirdo on Maple Street', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (23, 'An increasingly concerned Nancy looks for Barb and finds out what Jonathans been up to. Joyce is convinced Will is trying to talk to her.', 3, NULL, '15 Jul. 2016', 'Chapter Three: Holly, Jolly', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (24, 'Refusing to believe Will is dead, Joyce tries to connect with her son. The boys give Eleven a makeover. Jonathan and Nancy form an unlikely alliance.', 4, NULL, '15 Jul. 2016', 'Chapter Four: The Body', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (25, 'Hopper breaks into the lab to find the truth about Wills death. The boys try to locate the "gate" that will take them to Will.', 5, NULL, '15 Jul. 2016', 'Chapter Five: The Flea and the Acrobat', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (26, 'Hopper and Joyce find the truth about the labs experiments. After their fight, the boys look for the missing Eleven.', 6, NULL, '15 Jul. 2016', 'Chapter Six: The Monster', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (27, 'The government comes searching for Eleven. Eleven looks for Will and Barb in the Upside Down', 7, NULL, '15 Jul. 2016', 'Chapter Seven: The Bathtub', 3);
insert into EPISODES (ID, DESCRIPTION, EPISODE_NO, IMAGE_URL, RELEASE_DATE, TITLE, SEASON_ID) values (28, 'Joyce and Hopper are taken in for questioning. Nancy and Jonathan prepare to fight the monster and save Will.', 8, NULL, '15 Jul. 2016', 'Chapter Eight: The Upside Down', 3);

insert into CREATORS (ID, FULLNAME, IMAGE_URL, TV_SERIES_ID) values (1, 'David Benioff', NULL, 1);
insert into CREATORS (ID, FULLNAME, IMAGE_URL, TV_SERIES_ID) values (2, 'D.B. Weiss', NULL, 1);
insert into CREATORS (ID, FULLNAME, IMAGE_URL, TV_SERIES_ID) values (3, 'Matt Duffer', NULL, 2);
insert into CREATORS (ID, FULLNAME, IMAGE_URL, TV_SERIES_ID) values (4, 'Ross Duffer', NULL, 2);

insert into DIRECTORS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (1, 'Rian Johnson', NULL, 1);
insert into DIRECTORS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (2, 'James Cameron', NULL, 2);

insert into WRITERS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (1, 'Rian Johnson', NULL, 1);
insert into WRITERS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (2, 'James Cameron', NULL, 2);
insert into WRITERS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (2, 'Rick Jaffa', NULL, 2);
insert into WRITERS (ID, FULLNAME, IMAGE_URL, MOVIE_ID) values (2, 'Amanda Silver', NULL, 2);

insert into ACCOUNTS (ID, CREATION_DATE, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, PHONE_NO, SUBSCRIPTION_DATE, SUBSCRIPTION_TYPE, USERNAME) values (1, '2022-12-25T01:32:55.081931', 'test@hotmail.com', 'David', 'Johnson', 'mypass', '2101234567', NULL, 'NO_SUBSCRIPTION', 'Dave');
insert into ACCOUNTS (ID, CREATION_DATE, EMAIL, FIRSTNAME, LASTNAME, PASSWORD, PHONE_NO, SUBSCRIPTION_DATE, SUBSCRIPTION_TYPE, USERNAME) values (2, '2022-12-25T01:32:55.081123', 'something@hotmail.com', 'Maggie', 'Simpson', '123456', '2107654321', '2022-12-25T01:23:52.092133', 'PREMIUM',  'Mags');

insert into ADDRESSES (ID, COUNTRY, POSTAL_CODE, PROVINCE, STREET_NAME, STREET_NO, ACCOUNT_ID) values (1, 'United Kingdom', '181818', 'Essex', 'Church Street', '56', 1);
insert into ADDRESSES (ID, COUNTRY, POSTAL_CODE, PROVINCE, STREET_NAME, STREET_NO, ACCOUNT_ID) values (2, 'United States', '123456', 'Texas', 'Main Street', '32', 2);

insert into PROFILES (ID, AGE_RESTRICTED, FIRSTNAME, IMAGE_URL, ACCOUNT_ID) values (1, FALSE, 'David', NULL, 1);
insert into PROFILES (ID, AGE_RESTRICTED, FIRSTNAME, IMAGE_URL, ACCOUNT_ID) values (2, TRUE, 'KIDS', NULL, 1);
insert into PROFILES (ID, AGE_RESTRICTED, FIRSTNAME, IMAGE_URL, ACCOUNT_ID) values (3, TRUE, 'Maggie', NULL, 2);
insert into PROFILES (ID, AGE_RESTRICTED, FIRSTNAME, IMAGE_URL, ACCOUNT_ID) values (4, TRUE, 'KIDS', NULL, 2);
insert into PROFILES (ID, AGE_RESTRICTED, FIRSTNAME, IMAGE_URL, ACCOUNT_ID) values (5, FALSE, 'Homer', NULL, 2);

insert into CREDIT_CARDS (ID, CARD_CVC, CARD_NAME, CARD_NO, CARD_TYPE, ACCOUNT_ID) values (1, '123', 'H. SIMPSON', '1234567891011121', 'AMERICAN_EXPRESS', 2);
insert into CREDIT_CARDS (ID, CARD_CVC, CARD_NAME, CARD_NO, CARD_TYPE, ACCOUNT_ID) values (2, '555', 'H. SIMPSON', '9454667891718191', 'VISA', 2);