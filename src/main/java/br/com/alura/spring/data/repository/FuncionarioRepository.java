package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

//PagingAndSortingRepository para fazer paginação, jparepository serve para trabalhar em lotes
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,

//Derived Query = findBy para consulta
		JpaSpecificationExecutor<Funcionario> {
	List<Funcionario> findByNome(String nome);
//Usando JPQL e @Query ao ivés de derived query
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
			+ "AND f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

//Usando native query
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
			nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);

//Utilizando interface para pesquisar atributos de funcionário especifico e nao retornar tds os atributos
	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}