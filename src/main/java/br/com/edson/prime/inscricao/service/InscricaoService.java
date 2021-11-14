package br.com.edson.prime.inscricao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Inscricao;
import br.com.edson.prime.inscricao.model.InscricaoDTO;
import br.com.edson.prime.inscricao.repository.InscricaoRepository;

@Service
public class InscricaoService {
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	
	
	
public List<InscricaoDTO> getAll() {
		
		List<Inscricao> list =  inscricaoRepository.findAll();
		List<InscricaoDTO> inscricoes = new ArrayList<>();
		
		
		inscricoes = list.stream().map(x-> new InscricaoDTO(x)).collect(Collectors.toList());
		
		return inscricoes;
		
	}

	
	public boolean pesquisaEmail(String email) {
		
		if(inscricaoRepository.findByEmail(email).isPresent())
		{
			return true;
		}else {
			return false;
		}
	}
	
	
	public InscricaoDTO getByEmail(String email) {
		
		Optional<Inscricao> Oinsc =  inscricaoRepository.findByEmail(email);
		
		if(Oinsc.isPresent())
		{
			return new InscricaoDTO(Oinsc.get());
		}else {
			return new InscricaoDTO();
		}
	}
	
	
public InscricaoDTO getById(Long id) {
		
		Optional<Inscricao> Oinsc =  inscricaoRepository.findById(id);
		
		if(Oinsc.isPresent())
		{
			return new InscricaoDTO(Oinsc.get());
		}else {
			return new InscricaoDTO();
		}
	}
	



public boolean delete(Long id) {
		
		Optional<Inscricao> Oinsc =  inscricaoRepository.findById(id);
		
		if(Oinsc.isPresent())
		{
			inscricaoRepository.delete(Oinsc.get());
			return true;
		}else {
			return false;
		}
	}
	



public InscricaoDTO save(InscricaoDTO dto) {
	
	
	if(!pesquisaEmail(dto.getEmail())) {
		
		
		
		Inscricao inscricaoToSave = new Inscricao(dto);
		
		Inscricao inscricaoSaved =     inscricaoRepository.save(inscricaoToSave);
		
		
		return new InscricaoDTO(inscricaoSaved);
		
		
		
	}else {
		return null;
	}
	
	
	
	
	
	
}
	
	
	
	

}
