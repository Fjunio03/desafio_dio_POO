package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	
	private String nome;
	private Set<Conteudo> conteudosInscristos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscristos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscristos().add(this);
		}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscristos.stream()
		.findFirst();
		
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscristos.remove(conteudo.get());		
			}else {
				System.err.println("Você não está matriculado em nenhum conteudo!");
			}
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluidos.stream()
		.mapToDouble(Conteudo :: calcularXP)
		.sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscristos() {
		return conteudosInscristos;
	}

	public void setConteudosInscristos(Set<Conteudo> conteudosInscristos) {
		this.conteudosInscristos = conteudosInscristos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscristos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscristos, other.conteudosInscristos) && Objects.equals(nome, other.nome);
	}
	
	
}
