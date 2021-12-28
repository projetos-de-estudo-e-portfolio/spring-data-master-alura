package br.com.alura.spring.data.orm;
//Interface based Projection
//Criar uma entidade projetada contendo os atributos que queremos apresentar, clean code
//ou usamos uma classe Dto com getter, setter e construtor c atributos
//vantagem dto: criar métodos q fazem sentido pra view como formatação
public interface FuncionarioProjecao {
	Integer getId();
	String getNome();
	Double getSalario();
}
