package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
        private WebDriver navegador;

        public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
            this.navegador = navegador;
        }
    public FormularioDeAdicaoDeProdutoPage inserirNomeDoProduto(String produtonome) {
        navegador.findElement(By.id("produtonome")).sendKeys(produtonome);

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }
    public FormularioDeAdicaoDeProdutoPage inserirValor (String produtovalor){
        navegador.findElement(By.id("produtovalor")).sendKeys(produtovalor);

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }
    public FormularioDeAdicaoDeProdutoPage inserircores (String produtocores){
        navegador.findElement(By.id("produtocores")).sendKeys(produtocores);

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }
    public ListaDeProdutosPage submeteFormularioDeAdicaoComErro(){
        navegador.findElement(By.name("action")).click();

        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDeProdutoPage submeterFomularioDeAdicaoComSucesso(){
        navegador.findElement(By.name("action")).click();

        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }
}
