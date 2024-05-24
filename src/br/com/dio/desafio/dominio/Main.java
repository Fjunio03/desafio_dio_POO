package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("descriçao curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso JS"); 
		curso2.setDescricao("descriçao curso JS");
		curso2.setCargaHoraria(8);
		
		
		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("Mentoria de java");
		mentoria1.setDescricao("descrisao da mentoria");
		mentoria1.setData(LocalDate.now());
		
		//System.out.println(curso1);
		//System.out.println(curso2);
		//System.out.println(mentoria1);
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java developer");
		bootcamp.setDescricao("Descricao");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria1);
		
		Dev flavio = new Dev();
		flavio.setNome("Flavio");
		flavio.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos inscritos " + flavio.getConteudosInscristos());
		
		System.out.println("-----------------------------------");
		
		flavio.progredir();
		flavio.progredir();
		flavio.progredir();
		System.out.println("Conteudos inscritos " + flavio.getConteudosInscristos());
		System.out.println("Conteudos concluidos " + flavio.getConteudosConcluidos());
		
		System.out.println("XP: " + flavio.calcularTotalXp());
		
		System.out.println("-----------------------------------");
		
		Dev camila = new Dev();
		camila.setNome("Camila");
		camila.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos inscritos " + camila.getConteudosInscristos());
		
		System.out.println("-----------------------------------");
		
		camila.progredir();
		System.out.println("Conteudos inscritos " + camila.getConteudosInscristos());
		System.out.println("Conteudos concluidos " + camila.getConteudosConcluidos());
		
		System.out.println("XP: " + camila.calcularTotalXp());
		
	}
}
