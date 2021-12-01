package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();



    @Test
    public void testeLocacao() {
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificação
        error.checkThat(locacao.getValor(), is(5.0));
        error.checkThat(isMesmaData(locacao.getDataLocacao(),new Date()));
        error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)));
    }
}
