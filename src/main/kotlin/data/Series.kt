package data

data class Series(
    val title: String,
    val logo: String,
    val genre: String,
    val releaseYears: Int,
    val tagline: String,
    val age_rating: Int,
    val kinopoisk: Int,
    var watched: Boolean,
    var recommendation: Boolean
)

fun seriesList() =
    arrayOf(
        Series(
            "Game of Thrones",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/dd78edfd-6a1f-486c-9a86-6acbca940418/300x450",
            "Fantasy",
            2011,
            "Victory or death",
            18,
            9,
            false,
            true

        ),
        Series(
            "Kiseijuu: Sei no Kakuritsu",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/b507db53-42ed-43fb-b21f-767306a1d3a1/300x450",
            "Anime",
            2015,
            "You, no one else can help you, only the one who inflicted a wound on you",
            18,
            9,
            true,
            true

        ),
        Series(
            "Spartacus: Blood and Sand",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/24bb9899-af80-4650-a5de-6045f027c952/300x450",
            "Biographical film",
            2010,
            "Joyous screams of the crowd pacify dashing tongues",
            18,
            8,
            false,
            false

        ),
        Series(
            "Ликвидация",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/5fd40d16-f1e2-4e63-a958-a52442ae8c64/300x450",
            "Action film",
            2007,
            "Граждане менты! Я имею кое-что сказать!",
            18,
            10,
            false,
            true

        ),
        Series(
            "Firefly ",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/feedbde9-cfb0-45c1-b639-b29d5ad5fd6f/300x450",
            "Western",
            2002,
            "I constantly break the laws, but my conscience is clear.",
            18,
            8,
            false,
            false

        ),
        Series(
            "Диверсант",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/c113e250-00a9-4dc3-8d17-895781322beb/300x450",
            "War film",
            2020,
            "Одно скажу, никогда не опережай действием мысль. Запомни это.",
            18,
            8,
            false,
            true

        ),
        Series(
            "Atlanta's Missing and Murdered",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/c3ce586f-502d-4c92-955b-cbb21db517a5/300x450",
            "Documentary",
            2020,
            "The best documentary series connect the subject to larger issues that go beyond one case",
            18,
            8,
            false,
            false

        ),
        Series(
            "Marco Polo",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/5b97580a-66a4-480a-a1b6-5f7c2949208c/300x450",
            "Drama",
            2014,
            "I have not told half of what I saw",
            18,
            10,
            false,
            true

        ),
        Series(
            "Versailles",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/d59d239c-26ce-4740-8744-751c58eb891c/300x450",
            "Historical film",
            2015,
            "Ne jamais s'approcher trop près du soleil",
            18,
            9,
            false,
            false

        ),
        Series(
            "Патриот",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/96487e11-5981-4751-a67a-71fedb604030/300x450",
            "Comedy",
            2015,
            "Реальная жизнь — это не армия, в которой все устроено четко по уставу — особенно в отношениях",
            18,
            4,
            false,
            false

        ),
        Series(
            "Bonnie and Clyde",  //title
            "https://st.kp.yandex.net/images/film_iphone/iphone360_516.jpg",
            "Short film",
            2013,
            "We rob banks",
            16,
            2013,
            false,
            false

        ),
        Series(
            "How I Met Your Mother",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/961dfa1a-60fb-478d-b841-3f39ac051698/300x450",
            "Music film",
            2010,
            "Lying is a beautiful story that spoils the truth.",
            18,
            8,
            false,
            false

        ),
        Series(
            "Castlevania",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/0533be2c-cf17-4ea8-942c-74cd4756c718/300x450",
            "Cartoon",
            2017,
            "A warrior will come tonight. A knight in shiny armor carrying death. He is coming after you, children of the night!",
            18,
            8,
            true,
            true

        ),
        Series(
            "Lost in Space",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/36bc6f60-f4e0-42cd-a1f0-2abfbc0a4a99/300x450",
            "Sci-fi",
            2018,
            "Is there enough room for two?",
            18,
            8,
            true,
            true

        ),
        Series(
            "Once Upon a Time",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/9f91eb22-2848-48c8-92e9-5ff219e153da/300x450",
            "Adventure",
            2012,
            "To feel nothing at all is tempting when you feel sucky.",
            16,
            8,
            false,
            true

        ),
        Series(
            "Doctor Who",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/d22bd4c9-a371-4507-9b6b-81bdd540eaf4/300x450",
            "Family Film",
            2006,
            "It's not about time, someone in twenty years does more than another in eighty.",
            12,
            3,
            true,
            true

        ),
        Series(
            "Молодёжка",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/dcaf68e8-741a-4cfa-ac64-061e8e4d6711/300x450",
            "Sports movie",
            2013,
            "Не путай два понятия: гордость и гордыня..",
            12,
            8,
            true,
            true

        ),
        Series(
            "Hemlock Grove",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/506c6c0f-7ed1-4008-ba81-630863b32aa8/300x450",
            "Thriller",
            2013,
            "Do you know what real ugliness is? Its worst and most disgusting form is stupidity",
            18,
            10,
            false,
            true

        ),
        Series(
            "Stranger Things",  //title
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/2f4bd9ea-ec01-4fa9-9812-575158aa71f2/300x450",
            "Horror",
            2016,
            "Friends don't lie.",
            18,
            8,
            true,
            true

        )
    )










