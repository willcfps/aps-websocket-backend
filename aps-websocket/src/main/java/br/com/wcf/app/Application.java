package br.com.wcf.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.wcf.jpa.repository.ProjetoRepository;
import br.com.wcf.jpa.repository.UsuarioRepository;
import br.com.wcf.model.project.ProjetoModel;
import br.com.wcf.model.user.PerfilUsuarioModel;
import br.com.wcf.model.user.UsuarioModel;
import br.com.wcf.model.user.inspector.InspetorModel;

@EntityScan(value = { "br.com.wcf.model" })
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "br.com.wcf" })
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepository dao, ProjetoRepository pDao) {
		return (args) -> {

			PerfilUsuarioModel p1 = new PerfilUsuarioModel();
			p1.setDescription("ADM");
			p1.setWeight(9);

			PerfilUsuarioModel p2 = new PerfilUsuarioModel();
			p2.setDescription("INSPETOR");
			p2.setWeight(3);

			p1 = dao.guardarPerfilUsuario(p1);
			p2 = dao.guardarPerfilUsuario(p2);

			UsuarioModel u = new UsuarioModel("admin");
			u.setProfile(p1);
			u.setPassword("123");
			u = dao.guardarUsuario(u);
			
			InspetorModel insp = new InspetorModel();
			insp.setName("William");
			insp.setUser(u);
			insp = dao.guardarInspetor(insp);
			
			UsuarioModel u1 = new UsuarioModel("teste");
			u1.setProfile(p2);
			u1.setPassword("123");
			u1 = dao.guardarUsuario(u1);
			
			InspetorModel insp1 = new InspetorModel();
			insp1.setName("Teste");
			insp1.setUser(u1);
			insp1 = dao.guardarInspetor(insp1);

			ProjetoModel proj = new ProjetoModel();
			proj.setDescription("Secretaria de Estado do" + 
					"Meio Ambiente deseja saber quais atividades industriais estão gerando poluição do" + 
					"Rio Tietê desde sua nascente em Salesópolis (SP) até a sua passagem pela região" + 
					"da grande São Paulo.");
			proj.setOwner(insp);
			proj.getParticipants().add(insp1);
			proj.setTitle("Rio Tietê");
			proj = pDao.guardarProjeto(proj);
			
			proj = new ProjetoModel();
			proj.setDescription("Secretaria de Estado do" + 
					"Meio Ambiente deseja saber quais atividades industriais estão gerando poluição do" + 
					"Rio Tietê desde sua nascente em Salesópolis (SP) até a sua passagem pela região" + 
					"da grande São Paulo.");
			proj.setOwner(insp1);
			proj.getParticipants().add(insp);
			proj.setTitle("Rio Pinheiros");
			proj = pDao.guardarProjeto(proj);
			
			proj = new ProjetoModel();
			proj.setDescription("Secretaria de Estado do" + 
					"Meio Ambiente deseja saber quais atividades industriais estão gerando poluição do" + 
					"Rio Tietê desde sua nascente em Salesópolis (SP) até a sua passagem pela região" + 
					"da grande São Paulo.");
			proj.setOwner(insp);
			proj.getParticipants().add(insp1);
			proj.setTitle("Rio de Janeiro");
			proj = pDao.guardarProjeto(proj);
			
			pDao.getAllInpectorParticipant(u1).forEach(p -> {
				System.out.println(p.getProjectId() + " " + p.getProjectName());
			});
			
		};
	}
}