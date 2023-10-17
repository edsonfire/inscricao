package br.com.edson.prime.inscricao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	private String descricao;
	  @JsonFormat(
    	      shape = JsonFormat.Shape.STRING,
    	      pattern = "dd/MM/yyyy")
	private LocalDate data;
	  
	  @JsonFormat(
    	      shape = JsonFormat.Shape.STRING,
    	      pattern = "dd/MM/yyyy")
	private LocalDate data_fin;
	
	  @JsonFormat(
    	      shape = JsonFormat.Shape.STRING,
    	      pattern = "yyyy-MM-dd")
	@Column(name = "data", insertable = false, updatable = false )
	private LocalDate dataEvento;
	
	  @JsonFormat(
    	      shape = JsonFormat.Shape.STRING,
    	      pattern = "yyyy-MM-dd")
	@Column(name = "data_fin", insertable = false, updatable = false )
	private LocalDate dataFinalEvento;
	  
	private LocalDateTime dataevento;
	
	private LocalDateTime dataeventofin;
	
	private String responsavel;
	
	private String resumo;
	
	private String banner1;
	
	private String banner2;
	
	@ManyToOne
	@JoinColumn(name = "localEvento", nullable = true)
	private LocalEvento localEvento;
	
	private PeriodoEnum periodo;
	
	private int ativo;
	
	@Transient
	private String color;

	public int getId() {
		return id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalDate getData_fin() {
		return data_fin;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public LocalDate getDataFinalEvento() {
		
		
		if(!this.dataFinalEvento.isEqual(dataEvento)) {
		this.dataFinalEvento =	this.dataFinalEvento.plusDays(1);
		}
		
		return dataFinalEvento;
	}

	public LocalDateTime getDataevento() {
		return dataevento;
	}

	public LocalDateTime getDataeventofin() {
		return dataeventofin;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public String getResumo() {
		return resumo;
	}

	public String getBanner1() {
		return banner1;
	}

	public String getBanner2() {
		return banner2;
	}

	public LocalEvento getLocalEvento() {
		return localEvento;
	}

	public PeriodoEnum getPeriodo() {
		return periodo;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setDataevento(LocalDateTime dataevento) {
		this.dataevento = dataevento;
	}

	public String getColor() {
		
	
		
		if(this.localEvento!=null&&this.localEvento.getTipoEventoEnum().equals(TipoEventoEnum.EXTERNO)&&this.localEvento.getId()==3) {
			
			return "#B8860B";
		}else {
			
			return this.departamento.getColor();
		}
		

	}

	
	
	
	
}
