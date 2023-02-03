package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarroServiceImplTest {

    CarroService carroService;
    Carro celtinha;

    @Before
    public void setup(){
        carroService = new CarroServiceImpl();
        celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);
    }

    @Test
    public void deveAcelerarCorretamente() {

        // Given
        carroService.ligar(celtinha);

        // When
        carroService.acelerar(celtinha, 10);

        // Then
        // Assertivas
        // O Junit busca por Asserts no método para validar que o teste passou
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamente() {

        // Dado

        // Quando
        carroService.ligar(celtinha);

        // Então
        Assert.assertTrue(celtinha.isLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {
        // O Junit busca por Assets no método para validar que o teste passou

        // Dado:
        carroService.ligar(celtinha); // velocidade zero

        // Quando:
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Dado:

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void oCarroDeveIniciarDesligado() {
        // Dado:

        // Quando:

        // Então:
        Assert.assertFalse(celtinha.isLigado());
    }

    @Test
    public void naoDeveAcelerarComCarroDesligado() {
        // Dado:

        // Quando:
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertFalse(celtinha.isLigado());
        Assert.assertFalse(celtinha.getVelocidadeAtual() != 0);
    }

    @Test
    public void naoDevefrearComCarroDesligado() {
        // Dado:

        // Quando:
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertFalse(celtinha.isLigado());
        Assert.assertFalse(celtinha.getVelocidadeAtual() != 0);
    }

    @Test
    public void naoDeveDesligarComCarroEmMovimento() {
        // Dado:

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 50);
        carroService.desligar(celtinha);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertTrue(celtinha.getVelocidadeAtual() != 0);
    }

    @Test
    public void naoExisteVelocidadeNegativa() {
        // Dado:

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 50);
        carroService.frear(celtinha, 70);

        // Então:
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void oCarroNaoDevePassarDeSuaVelocidadeMaxima() {
        // Dado:

        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 40);
        carroService.acelerar(celtinha, 20);

        // Então:
        Assert.assertEquals(celtinha.getVelocidadeAtual(), celtinha.getVelocidadeMaxima());
    }
}
