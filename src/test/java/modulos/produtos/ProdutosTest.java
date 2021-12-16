package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Módulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // Vou abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Vou acessar a Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

        // Vou fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovosProdutos()
                .inserirNomeDoProduto("Capa de Invisibilidade")
                .inserirValor("0")
                .inserircores("incolor")
                .submeteFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


        // Vou validar que a mensagem de erro foi apresentada

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

        }
        @Test
        @DisplayName("É Possível Registrar Um Produto Com Valor Igual a Sete Mil")
        public void testPossívelRegistrarUmProdutoComValorIgualaSeteMil() {

            // Vou fazer Login
            String mensagemApresentada = new LoginPage(navegador)
                    .informarOUsuario("admin")
                    .informarSenha("admin")
                    .submeterFormularioDeLogin()
                    .acessarFormularioAdicaoNovosProdutos()
                    .inserirNomeDoProduto("Capa de Invisibilidade")
                    .inserirValor("700000")
                    .inserircores("incolor")
                    .submeterFomularioDeAdicaoComSucesso()
                    .capturarMensagemApresentada();



            // Vou validar que a mensagem de Sucesso foi apresentada

            Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
        }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor acima de 7000")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDeSeteMil() {

        // Vou fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovosProdutos()
                .inserirNomeDoProduto("Capa de Invisibilidade")
                .inserirValor("700001")
                .inserircores("incolor")
                .submeteFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


        // Vou validar que a mensagem de erro foi apresentada

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

        @AfterEach
    public void afterEach(){
        // Vou fechar o navegador
        navegador.quit();
    }

}

