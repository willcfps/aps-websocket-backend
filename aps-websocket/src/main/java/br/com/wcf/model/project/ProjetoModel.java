package br.com.wcf.model.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.wcf.model.user.inspector.InspetorModel;

@Entity
public class ProjetoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8593837741837707479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	private String title;

	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	private InspetorModel owner;

	@ManyToMany
	@JoinTable(name = "PROJECT_PARTICIPANTS", joinColumns = @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "FK_PROJ_PART")), inverseJoinColumns = @JoinColumn(name = "PARTICIPANT_ID", foreignKey = @ForeignKey(name = "FK_PART_PROJ")))
	private List<InspetorModel> participants;
	
	public ProjetoModel() {
		this.participants = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InspetorModel getOwner() {
		return owner;
	}

	public void setOwner(InspetorModel owner) {
		this.owner = owner;
	}

	public List<InspetorModel> getParticipants() {
		return participants;
	}

	public void setParticipants(List<InspetorModel> participants) {
		this.participants = participants;
	}

}
