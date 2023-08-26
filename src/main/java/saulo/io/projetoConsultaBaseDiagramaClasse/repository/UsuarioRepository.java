package saulo.io.projetoConsultaBaseDiagramaClasse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import saulo.io.projetoConsultaBaseDiagramaClasse.entity.Perfil;
import saulo.io.projetoConsultaBaseDiagramaClasse.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u.perfils FROM Usuario u WHERE u.id = :id")
	List<Perfil> findPerfisByUsuarioId(@Param("id") Long id);	
}
