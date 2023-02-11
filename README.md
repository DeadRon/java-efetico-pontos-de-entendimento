<div style="text-align: justify">

# Anotações do Livro Java Efetivo

## Capítulo 1 - Criar e destruir objetos

### Item 1 - métodos static no lugar dos construtores

#### Vantagens

- Possuem nomes que diferente

- Conceito de static factory: É um método estático declarado na própria classe, seu propósito consiste em retornar uma instância da própria classe,

- possuem nomes que diferente dos construtores não tem. Uma classe pode possuir diversos construtores,  isso pode causar confusão para o programador e isso pode acarretar em um objeto que não atende ao que o usuário da api precisava.  Usar métodos ** state factorys** aliados com à bom nome descritivo acerca do que faz com os parâmetros corretos evita o cenário de confusão de inúmeros construtores.

- A Invocação de um método estático é feita chamado direto da classe Onde está declarado, por isso não é preciso gerar instâncias para ser chamado inúmeras vezes.

- Podem retornar qualquer subtipo do tipo do retorno, coisa que os construtores não podem fazer porque um construtor consegue apenas instanciar objetos de uma classe e não de seus subtipos.

#### desvantagem

- Classes que forneçam apenas métodos estáticos e que tenham um construtor privado não podem ser subdivididas em outras classes através da herança pois é esperado um construtor público ou padrão para à relação de herança existir

- Static factories são difíceis de serem encontrados porque não tem destaque na documentação como os construtores têm. Isso torna difícil achar Static fatores capazes de instanciar uma classe.

- Não são adequados para uma grande quantia de parâmetros

- **Convenção de nomes comuns para factorys**:
  - ***from***: converte um tipo em outro, tem apenas um parâmetro.
    ````java
    Date date = Date.from(instant);
    ````
  - ***of***: converte um tipo em outro através de vários parâmetros.
    ````java
    Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
    ````
  - ***valueOf***: alternativa verbosa aos nomes from / of
    ````java
    BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
    ````
  - ***Instance / getInstance***: retorna uma instância de acordo com os parâmetros usados, mas não pode ter os mesmo valores mais de uma vez.
    ````java
    StackWalker tuke = StackWalker.getInstance(options);
    ````
  - ***create / newInstance***: semelhante ao instance / getInstance mas garante que haverá uma instância.
    ````java
    Object newArray = Array.newInstance(classObject, arrayLen);
    ````
  - ***getType / newType / type***: semelhante ao getInstance, porém é um static factory que retorna um objeto de Type invocado a partir de outra classe. Type se refere ao nome da classe/tipo.
    ````java
    FileStore fs = Files.getFileStore(path);
    BufferedReader bf = Files.newBufferedReader(path);
    Lisy<Complaint> litany = Collections.list(legacyLitany);
    ````

### Item 2 - Uso de Builders em cenários onde há muitos construtores

Static factorys e construtores não se adequam tão bem quando há a presença de muitos parâmetros opcionais porque tornam-se difíceis de se ler.

#### Soluções

- **Telescoping Constructor Pattern**: 
A classe fornece construtor necessário para os parâmetros obrigatórios e um conjunto de construtores para os parâmetros obrigatórios e opcionais.
<br>&nbsp;&nbsp;&nbsp;&nbsp;O Telescoping Constructor Pattern funciona da seguinte forma: há construtores 
que iniciam um, dois ou mais parâmetros chamando dentro de si outros construtores de forma que são iniciados apenas 
os atributos esperados/obrigatóros e os demais parâmetros opcionais recebem um valor padrão. 
Esse encadeamento de chamadas internas de construtores da classe dura até que seja chamado o construtor final (este responsável inicializar 
todos os parâmetros da classe) seja chamado. Exemplo do livro abaixo:
  ````java
  public class NutritionFacts {

    private final int servingsSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(int servingsSize, int servings) {
       this(servingsSize, servings, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories) {
        this(servingsSize, servings, calories, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories, int fat) {
        this(servingsSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories, int fat, int sodium) {
        this(servingsSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingsSize = servingsSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

  }
  ````
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; A desvantagem do uso deste Pattern fica evidente à medida que a quantidade de parâmetros aumenta, pois isso torna o código difícil de ler. 
Essa desvantagem pode induzir o usuário da api a chamar um dos construtores de forma errada, dessa forma pode ocorrer um erro em tempo de execução ao acessar um atributo que não foi inicializado devidamente ou da forma como era esperado.

- **2 solução - Java Beans** 
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consiste em usar um construtor vazio para utilizar os métodos setters para definir os atributos obrigatórios
e opcionais da instância. Como desvantagem, as chamadas de métodos setters podem ser prolixas podendo 
causar algumas inconsistências durante a construção do objeto além de tornar a classe mutável.
  ````java
    NutritionFacts cocaCola = new NutritionFacts();
    cocaCola.setServings(8);
    cocaCola.setServingsSize(240);
    cocaCola.setCalories(100);
    cocaCola.setSodium(33);
    cocaCola.setCarbohydrate(27);
  ````


</div>