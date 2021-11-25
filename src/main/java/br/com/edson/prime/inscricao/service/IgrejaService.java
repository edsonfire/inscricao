package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Igreja;
import br.com.edson.prime.inscricao.repository.IgrejaRepository;

@Service
public class IgrejaService {

	
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	
	
	
	
	
	
	
	

	
public List<Igreja> getAll() {
		
		List<Igreja> list =  igrejaRepository.findAll();

		
	//	Igrejas = list.stream().map(x-> new IgrejaDTO(x)).collect(Collectors.toList());
		
		return list;
		
	}

	
public Igreja getById(Long id) {
		
		Optional<Igreja> Omot =  igrejaRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new Igreja();
		}
	}
	


@Transactional
public boolean delete(Long id) {
		
		Optional<Igreja> Omot =  igrejaRepository.findById(id);
		
		if(Omot.isPresent())
		{
			igrejaRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public Igreja update(Igreja dto) {
		
		Optional<Igreja> Omot =  igrejaRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			Igreja mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setBairro(dto.getBairro());
			mot.setCidade(dto.getCidade());
			mot.setDescricao(dto.getDescricao());
			mot.setDirigente(dto.getDirigente());
			mot.setEmail(dto.getEmail());
			mot.setEndereco(dto.getEndereco());
			mot.setNumero(dto.getNumero());
			mot.setTelefone(dto.getTelefone());
			mot.setUf(dto.getUf());
			
			
			igrejaRepository.save(mot);
			return mot;
		}else {
			return new Igreja();
		}
	}





@Transactional
public Igreja save(Igreja dto) {
	
	
	if(!igrejaRepository.findByDescricao(dto.getDescricao()).isPresent()) {
		
		
		
		
		
		Igreja IgrejaSaved =     igrejaRepository.save(dto);
		
		
		return IgrejaSaved;
		
		
		
	}else {
		return null;
	}
	
	
	
	
	
	
}
	
	
}
