package generator;

import model.Address;
import model.Person;
import java.util.Arrays;
import java.util.List;

public class GeneratePerson {
    private final List<Person> shippers = generate();
    private final List<Person> transporters = createTransporters();
    private final List<Person> destinators = createDestinators();

    public List<Person> getShippers() {
        return shippers;
    }

    public List<Person> getTransporters() {
        return transporters;
    }

    public List<Person> getDestinators() {
        return destinators;
    }

    private List<Person> generate(){
        Person person1 = new Person(
                "Filipe e Marlene Advocacia Ltda",
                "presidencia@filipeemarleneadvocacialtda.com.br",
                "19998704861",
                "60498536000100",
                "15/11/2018",
                new Address(
                        "Brasil",
                        "SP",
                        "Taboão da Serra",
                        "Rua Francisco Perez",
                        "148",
                        "Jardim Monte Alegre",
                        "06755270"
                )
        );

        Person person2 = new Person(
                "Raquel e Luciana Marcenaria Ltda",
                "presidencia@raquelelucianamarcenarialtda.com.br",
                "19986074926",
                "46251901000157",
                "22/10/2018",
                new Address(
                        "Brasil",
                        "SP",
                        "Valinhos",
                        "Rua Elizabeth Gebauer Pimentel Zampelli",
                        "510",
                        "Dois Córregos",
                        "13278150"
                )
        );

        Person person3 = new Person(
                "Marina e Paulo Telecom Ltda",
                "ouvidoria@marinaepaulotelecomltda.com.br",
                "1138359299",
                "77689595000169",
                "18/03/2018",
                new Address(
                        "Brasil",
                        "SP",
                        "São Paulo",
                        "Rua Henrique Klein",
                        "758",
                        "Jardim Santa Margarida",
                        "04930100"
                )
        );

        Person person4 = new Person(
                "Alice e Mariah Vidros ME",
                "estoque@aliceemariahvidrosme.com.br",
                "55981183665",
                "47000462000172",
                "27/08/2002",
                new Address(
                        "Brasil",
                        "RS",
                        "Santa Maria",
                        "Rua A Seis",
                        "230",
                        "Pé de Plátano",
                        "97110568"
                )
        );

        Person person5 = new Person(
                "Lívia e Olivia Lavanderia Ltda",
                "fabricacao@liviaeolivialavanderialtda.com.br",
                "38998459451",
                "29070419000100",
                "02/09/2015",
                new Address(
                        "Brasil",
                        "MG",
                        "Montes Claros",
                        "Avenida das Nações",
                        "353",
                        "Conjunto Residencial JK",
                        "39404014"
                )
        );

        Person person6 = new Person(
                "Diego e Sophia Alimentos ME",
                "contato@diegoesophiaalimentosme.com.br",
                "49987958200",
                "37363444000100",
                "24/01/2011",
                new Address(
                        "Brasil",
                        "SC",
                        "Chapecó",
                        "Rua São João - D",
                        "484",
                        "Pinheirinho",
                        "89806724"
                )
        );

        Person person7 = new Person(
                "Lúcia e Bruno Ferragens ME",
                "producao@luciaebrunoferragensme.com.br",
                "2426829175",
                "12608592000108",
                "11/07/2019",
                new Address(
                        "Brasil",
                        "RJ",
                        "Barra Mansa",
                        "Rua B",
                        "258",
                        "Morada Verde",
                        "27350490"
                )
        );

        Person person8 = new Person(
                "Benjamin e Vicente Buffet ME",
                "juridico@benjaminevicentebuffetme.com.br",
                "65982011192",
                "55352905000112",
                "25/08/2019",
                new Address(
                        "Brasil",
                        "MT",
                        "Cuiabá",
                        "Rua Benedito Antônio",
                        "592",
                        "Pascoal Ramos",
                        "78098971"
                )
        );

        Person person9 = new Person(
                "Cecília e Lorena Limpeza ME",
                "cobranca@ceciliaelorenalimpezame.com.br",
                "84985960305",
                "13024679000109",
                "19/03/2019",
                new Address(
                        "Brasil",
                        "RN",
                        "Natal",
                        "Rua Buenos Aires",
                        "775",
                        "Felipe Camarão",
                        "59072010"
                )
        );

        Person person10 = new Person(
                "Bento e Sophie Publicidade e Propaganda Ltda",
                "suporte@bentoesophiepublicidadeepropagandaltda.com.br",
                "67983350737",
                "54110950000106",
                "15/04/2004",
                new Address(
                        "Brasil",
                        "MS",
                        "Campo Grande",
                        "Rua Jobe de Matos",
                        "665",
                        "Bom Retiro",
                        "79116710"
                )
        );

        return Arrays.asList(person1, person2, person3, person4, person5, person6,
                person7, person8, person9, person10);
    }

    private List<Person> createTransporters() {
        Person person1 = new Person(
                "Vitor e Gabriela Entulhos ME",
                "auditoria@vitoregabrielaentulhosme.com.br",
                "6835350852",
                "11362541000186",
                "03/05/2016",
                new Address(
                        "Brasil",
                        "AC",
                        "Rio Branco",
                        "Travessa Estado da Guanabara",
                        "983",
                        "Aeroporto Velho",
                        "69911112"
                )
        );

        Person person2 = new Person(
                "Nathan e Olivia Construções Ltda",
                "auditoria@vitoregabrielaentulhosme.com.br",
                "1135016477",
                "32884882000191",
                "13/11/2016",
                new Address(
                        "Brasil",
                        "SP",
                        "São Paulo",
                        "Rua Manuel Peixoto",
                        "741",
                        "Jardim Virginia Bianca",
                        "02356120"
                )
        );

        Person person3 = new Person(
                "Patrícia e Guilherme Locações de Automóveis Ltda",
                "rh@patriciaeguilhermelocacoesdeautomoveisltda.com.br",
                "11991219899",
                "13701920000189",
                "13/11/2016",
                new Address(
                        "Brasil",
                        "SP",
                        "Cotia",
                        "Estrada Jaboticabeiras",
                        "836",
                        "Jardim dos Pereiras (Caucaia do Alto)",
                        "06728110"
                )
        );

        Person person4 = new Person(
                "Geraldo e Kevin Locações de Automóveis ME",
                "posvenda@geraldoekevinlocacoesdeautomoveisme.com.br",
                "83987531193",
                "51206855000104",
                "18/09/2018",
                new Address(
                        "Brasil",
                        "PB",
                        "João Pessoa",
                        "Rua Carreteiro João Simeão Sobrinho",
                        "664",
                        "João Paulo II",
                        "58076015"
                )
        );

        Person person5 = new Person(
                "Pedro Henrique e Fernanda Mudanças ME",
                "almoxarifado@pedrohenriqueefernandamudancasme.com.br",
                "51996691302",
                "30856603000150",
                "08/10/2022",
                new Address(
                        "Brasil",
                        "RS",
                        "Porto Alegre",
                        "Acesso Um",
                        "1165",
                        "Santa Tereza",
                        "90810132"
                )
        );

        Person person6 = new Person(
                "Kaique e Nicole Transportes Ltda",
                "juridico@kaiqueenicoletransportesltda.com.br",
                "51993598438",
                "80770262000174",
                "11/08/2008",
                new Address(
                        "Brasil",
                        "RS",
                        "Alvorada",
                        "Rua Dom Vital",
                        "415",
                        "Tijucas",
                        "94852110"
                )
        );

        Person person7 = new Person(
                "Kevin e Nathan Entregas Expressas Ltda",
                "orcamento@kevinenathanentregasexpressasltda.com.br",
                "44996662111",
                "72420739000163",
                "15/09/2017",
                new Address(
                        "Brasil",
                        "PR",
                        "Maringá",
                        "Praça Emiliano Perneta",
                        "771",
                        "Zona 03",
                        "87050070"
                )
        );

        Person person8 = new Person(
                "Vera e Eliane Telecom Ltda",
                "suporte@veraeelianetelecomltda.com.br",
                "11994676752",
                "02035389000136",
                "14/01/2016",
                new Address(
                        "Brasil",
                        "SP",
                        "São Paulo",
                        "Rua Sarambé",
                        "820",
                        "Vila Arapuã",
                        "04258120"
                )
        );

        Person person9 = new Person(
                "Benício e Eduardo Locações de Automóveis ME",
                "faleconosco@benicioeeduardolocacoesdeautomoveisme.com.br",
                "67999053869",
                "47973484000119",
                "01/09/2006",
                new Address(
                        "Brasil",
                        "MS",
                        "Campo Grande",
                        "Rua Jorge Ward",
                        "569",
                        "Guanandi",
                        "79086210"
                )
        );

        Person person10 = new Person(
                "Alice e Marcela Ferragens Ltda",
                "ti@aliceemarcelaferragensltda.com.br",
                "61984143096",
                "55063912000102",
                "23/09/2010",
                new Address(
                        "Brasil",
                        "DF",
                        "Brasília",
                        "Quadra QNP 22 Conjunto L",
                        "847",
                        "Ceilândia Sul (Ceilândia)",
                        "72235212"
                )
        );

        return Arrays.asList(person1, person2, person3, person4, person5, person6,
                person7, person8, person9, person10);
    }

    private List<Person> createDestinators(){
        Person person1 = new Person(
                "Vitória Ana Jaqueline Souza",
                "vitoria.ana.souza@outloock.com.br",
                "98993920799",
                "71473455685",
                "04/01/1987",
                new Address(
                        "Brasil",
                        "MA",
                        "São Luís",
                        "Rua 09",
                        "762",
                        "Cidade Operária",
                        "65058163"
                )
        );
        Person person2 = new Person(
                "Leandro Martin Luan Santos",
                "leandro_santos@hersa.com.br",
                "6226760452",
                "05173888202",
                "23/01/1984",
                new Address(
                        "Brasil",
                        "GO",
                        "Goiânia",
                        "Rua Chuí",
                        "885",
                        "Jardim Luz",
                        "74850390"
                )
        );
        Person person3 = new Person(
                "Cauã Victor Joaquim da Silva",
                "caua_victor_dasilva@delfrateinfo.com.br",
                "71998255814",
                "15598424827",
                "02/01/1958",
                new Address(
                        "Brasil",
                        "BA",
                        "Salvador",
                        "Rua da Boa Paz",
                        "565",
                        "Sete de Abril",
                        "41385000"
                )
        );
        Person person4 = new Person(
                "Eduardo Luís Pedro Henrique Nascimento",
                "eduardo-nascimento75@broutdoor.com.br",
                "41997383731",
                "49080359033",
                "19/01/1958",
                new Address(
                        "Brasil",
                        "PR",
                        "Fazenda Rio Grande",
                        "Avenida Brasil",
                        "194",
                        "Nações",
                        "83823034"
                )
        );
        Person person5 = new Person(
                "Mirella Raquel Analu da Costa",
                "mirella.raquel.dacosta@goldenhotel.com.br",
                "43989767007",
                "34752615533",
                "01/01/1978",
                new Address(
                        "Brasil",
                        "PR",
                        "Londrina",
                        "Rua Manoel Alves dos Santos",
                        "950",
                        "Aurora",
                        "86047490"
                )
        );
        Person person6 = new Person(
                "Clara Lívia Silveira",
                "clara.livia.silveira@valdulion.com.br",
                "81997504477",
                "80730240398",
                "06/01/1972",
                new Address(
                        "Brasil",
                        "PE",
                        "São Lourenço da Mata",
                        "Rua Osasco",
                        "846",
                        "Chá da Tábua",
                        "54745810"
                )
        );

        Person person7 = new Person(
                "Anthony Arthur Cardoso",
                "anthony-cardoso75@terra.com",
                "94988614282",
                "61453442375",
                "0/01/1961",
                new Address(
                        "Brasil",
                        "PA",
                        "Tucuruí",
                        "Travessa Porto Alegr",
                        "179",
                        "Palmares",
                        "68460116"
                )
        );

        Person person8 = new Person(
                "Daiane Manuela Maya Nunes",
                "daiane-nunes84@operaconstrutora.com.br",
                "94988614282",
                "87560485995",
                "0/01/1961",
                new Address(
                        "Brasil",
                        "CE",
                        "Fortaleza",
                        "Rua de Pedestre B",
                        "548",
                        "Lagoa Redonda",
                        "60831494"
                )
        );

        Person person9 = new Person(
                "Sandra Liz Vanessa Lima",
                "sandra-lima98@toyota.com.br",
                "66989360741",
                "64851355610",
                "01/01/2003",
                new Address(
                        "Brasil",
                        "CE",
                        "Fortaleza",
                        "Rua Governador Ponce de Arruda",
                        "291",
                        "Centro",
                        "60831494"
                )
        );

        Person person10 = new Person(
                "Benício Antonio Giovanni Silva",
                "benicio_silva@signa.net.br",
                "86998535894",
                "06543286504",
                "07/01/1961",
                new Address(
                        "Brasil",
                        "PI",
                        "Parnaíba",
                        "Rua Poeta Guido Vaz",
                        "669",
                        "São Vicente de Paula",
                        "64217475"
                )
        );

        return Arrays.asList(person1, person2, person3, person4, person5, person6,
                person7, person8, person9, person10);
    }
}
