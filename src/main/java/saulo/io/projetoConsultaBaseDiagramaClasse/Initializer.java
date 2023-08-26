package saulo.io.projetoConsultaBaseDiagramaClasse;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import saulo.io.projetoConsultaBaseDiagramaClasse.entity.Funcionalidades;
import saulo.io.projetoConsultaBaseDiagramaClasse.entity.Perfil;
import saulo.io.projetoConsultaBaseDiagramaClasse.entity.Usuario;
import saulo.io.projetoConsultaBaseDiagramaClasse.enun.StatusPerfil;
import saulo.io.projetoConsultaBaseDiagramaClasse.repository.PerfilRepository;
import saulo.io.projetoConsultaBaseDiagramaClasse.repository.UsuarioRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Funcionalidades funcionalidades = new Funcionalidades();
		funcionalidades.setNome("ADD");

		Funcionalidades funcionalidades2 = new Funcionalidades();
		funcionalidades2.setNome("DELETE");

		Perfil perfil = new Perfil("ADMIN", StatusPerfil.ATIVO, Arrays.asList(funcionalidades));

		Perfil perfil2 = new Perfil("ALUNO", StatusPerfil.ATIVO, Arrays.asList(funcionalidades2));

		Usuario usuario = new Usuario();

		usuario.setNome("Saulo Costa");
		usuario.setEmail("saulo.costa@");
		usuario.setPerfils(Arrays.asList(perfil, perfil2));

		this.usuarioRepository.save(usuario);

		Perfil perfil3 = new Perfil("ADMIN", StatusPerfil.ATIVO);

		Perfil perfil4 = new Perfil("ALUNO", StatusPerfil.ATIVO);

		usuario = new Usuario();

		usuario.setNome("Gabriel Costa");
		usuario.setEmail("gabriel.costa@");
		usuario.setPerfils(Arrays.asList(perfil3, perfil4));

		this.usuarioRepository.save(usuario);

		List<Usuario> user = this.usuarioRepository.findAll();

		for (Usuario usua : user) {
			getPerfil(usua);
		}

	}

	@Transactional
	private void getPerfil(Usuario usua) {

		/*
		 * Como a busca é FETCH, então é recomendado que acione o repositorio para
		 * carregar o relacionamento. Fazendo isto ganha-se performance e evita trazer
		 * dados desnecessários
		 */
		List<Perfil> perfil = this.usuarioRepository.findPerfisByUsuarioId(usua.getId());

		for (Perfil perfil2 : perfil) {
			System.out.println(usua.getNome().concat(" - ").concat(perfil2.getNome()));
		}

	}

}
