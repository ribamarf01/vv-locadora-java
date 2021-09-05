package com.mycompany.projetolocadora.model;

public class Filme {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao == "" || descricao == null) {
            this.descricao = "Sem descrição disponível.";
        } else if (descricao.length() > 300) {
            this.descricao = descricao.substring(0, 299);
        } else {
            this.descricao = descricao;
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        if(ano.length() == 2) {
            if(Integer.parseInt(ano) > 21) ano = "19" + ano;
            else ano = "20" + ano;
        }
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    
    private long id; 
    private String titulo;
    private String descricao;
    private String genero;
    private String ano;
    private String duracao; // Em minutos
    private String diretor;
    private String estudio;
    
    public Filme() {};
    
    public Filme(String titulo, String descricao, String genero, String ano, String duracao, String diretor, String estudio) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.diretor = diretor;
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Filme [ano=" + ano + ", descricao=" + descricao + ", diretor=" + diretor + ", duracao=" + duracao
                + ", estudio=" + estudio + ", genero=" + genero + ", id=" + id + ", titulo=" + titulo + "]\n";
    }
    
    /**
    public Filme(long id, String titulo, String descricao, String genero, String ano, String duracao, String diretor, String estudio) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.diretor = diretor;
        this.estudio = estudio;
    }
    */
}
