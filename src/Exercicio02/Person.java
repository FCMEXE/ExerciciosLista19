package Exercicio02;

import java.util.ArrayList;

public class Person {
    private int codigo;
    private String nome;
    private ArrayList<Automovel> automoveis = new ArrayList<Automovel>();

    public Person() {

    }

    public Person(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public void inserirAutomovel(Automovel automovel) {
        this.automoveis.add(automovel);
    }

    public void removerAutomovel(int index) {
        this.automoveis.remove(index);
    }

    public String imprimir() {
        return "\nCodigo: " + codigo +
                "\nNome: " + nome;
    }

    public String imprimirCompleto() {
        String retorno = imprimir() + "\n";
        for(Automovel automovel : automoveis){
            retorno += automovel.imprimir() + "\n";
        }
        return retorno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
