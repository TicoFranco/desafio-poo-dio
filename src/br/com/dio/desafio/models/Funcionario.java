package br.com.dio.desafio.models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class Funcionario {

    private String nome;
    private String senha;
    private int cargaHoraria;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;;
    private int diasTrabalhados;
    private double salarioDiario;

    public Funcionario(String nome,String senha,int cargaHoraria,double salarioDiario){
        this.nome=nome;
        this.senha=senha;
        this.cargaHoraria=cargaHoraria;
        this.salarioDiario=salarioDiario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioDiario() {
        return salarioDiario;
    }

    public void setSalarioDiario(double salarioDiario) {
        this.salarioDiario = salarioDiario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void iniciarJornada(LocalTime horario){
        horarioEntrada=horario;
        horarioSaida=horario.plusHours(cargaHoraria);
        System.out.println("jornada iniciada,seu horario de saida sera as "+horarioSaida);
    }

    public void terminarJornada(LocalTime horario){
        try{
            if(horario.isAfter(horarioSaida)){
                System.out.println("jornada concluida");
                diasTrabalhados++;
            }else{
                System.out.println("ainda faltam "+horario.until(horarioSaida, ChronoUnit.MINUTES)+" minutos");
            }
        }catch (NullPointerException e){
            System.out.println("A jornada de trabalho nao foi iniciada");
        }
    }

    public abstract void receberSalario();

}
