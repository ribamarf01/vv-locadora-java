package com.mycompany.projetolocadora.model;

import com.mycompany.projetolocadora.utils.FormatarString;

public class Pessoa {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = new FormatarString().formatarString(cpf, "###.###.###-##");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = new FormatarString().formatarString(telefone, "## #####-####");
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        String data = new FormatarString().formatarString(dataNascimento, "##/##/####");
        String[] data_splitd = data.split("/");
        data_splitd[2] = data_splitd[2].replaceAll(" ", "");
        if(data_splitd[2].length() == 2) {
            
            if(Integer.parseInt(data_splitd[2]) > 21) data_splitd[2] = "19" + data_splitd[2];
            else data_splitd[2] = "20" + data_splitd[2];
            
            data = data_splitd[0] + "/" + data_splitd[1] + "/" + data_splitd[2];
        }
        
        this.dataNascimento = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    private long id;
    private String nomeCompleto;
    private String cpf; 
    private String telefone;
    private String sexo;
    private String dataNascimento;
    private String endereco;
    private String email;
    
    public Pessoa() {};
    
    public Pessoa(String nomeCompleto, String cpf, String telefone, String sexo, String dataNascimento, String endereco, String email) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", endereco="
                + endereco + ", id=" + id + ", nomeCompleto=" + nomeCompleto + ", sexo=" + sexo + ", telefone="
                + telefone + "]";
    }
    
    /**
    public Pessoa(long id, String nomeIdent, String nomeCompleto, String cpf, String telefone, String sexo, String dataNascimento, String endereco) {
    *   this.id = id;
        this.nomeIdent = nomeIdent;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    */
}
