package br.com.alura.desafio.principal;

import br.com.alura.desafio.model.Artista;
import br.com.alura.desafio.model.Musica;
import br.com.alura.desafio.model.TipoArtista;
import br.com.alura.desafio.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {


    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repository;

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }
    public void exibeMenu() {
        var menu = """
                1- Cadastrar artistas
                2- Cadastrar músicas
                3- Listar músicas
                4- Buscar músicas por artistas
                5- Pesquisar dados sobre um artista
                9- Sair
                """;
        var opcao = -1;

        while (opcao != 9) {
            System.out.println(menu);

            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 5:
                    pesquisarDadosArtista();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void pesquisarDadosArtista() {

    }

    private void buscarMusicasPorArtistas() {

    }

    private void listarMusicas() {

    }

    private void cadastrarMusicas() {

        System.out.println("nome do artista: ");
        var nomeArtista = leitura.nextLine().trim();

        var artistaEncontrado = repository.buscarPorNome(nomeArtista);

        if(artistaEncontrado.isPresent()){
            var artista  = artistaEncontrado.get();

            System.out.println("nome da música: ");
            var nomeMusica = leitura.nextLine().trim();

            var musica = new Musica(nomeMusica);

            artista.adicionarMusica(musica);
            repository.save(artista);

        }

        else{
            System.out.println("Artista não encontrado. Cadastre o artista primeiro.");
        }

        System.out.println("Música cadastrada com sucesso!");



    }

    private void cadastrarArtistas() {

        System.out.println("nome do artista: ");
        var nome = leitura.nextLine();

        System.out.println("tipo do artista: ");
        var tipoDigitado = leitura.nextLine();

        TipoArtista tipo = TipoArtista.valueOf(tipoDigitado.trim().toUpperCase());

        Artista artista = new Artista(nome.trim(), tipo);

        repository.save(artista);


    }
}
