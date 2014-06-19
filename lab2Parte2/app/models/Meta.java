package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.google.common.base.Objects;

@Entity(name="Meta")
public class Meta{
	
	@Id
	@SequenceGenerator(name = "METa_SEQUENCE", sequenceName = "META_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column
	private String meta;
	
	@Column
	private String descricao;

	public class Meta(){}

	public getId(){
		return id;
	}
	
	public setId(Long id){
		this.id = id;
	}
	
	public getMeta(){
		return meta;
	}
	
	public setMeta(String meta){
		this.meta = meta;
	}
	
	public getDescricao(){
		return descricao;
	}
	
	public setDescricao(String descricao){
		this.descricao = descricao;
	}

}