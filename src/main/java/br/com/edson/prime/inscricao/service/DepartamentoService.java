package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Departamento;
import br.com.edson.prime.inscricao.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	
	
	
	
	
	

	
public List<Departamento> getAll() {
		
		List<Departamento> list =  departamentoRepository.findAll();

		
	//	Departamentos = list.stream().map(x-> new DepartamentoDTO(x)).collect(Collectors.toList());
		
		return list;
		
	}

	
public Departamento getById(Integer id) {
		
		Optional<Departamento> Omot =  departamentoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new Departamento();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<Departamento> Omot =  departamentoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			departamentoRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public Departamento update(Departamento dto) {
		
		Optional<Departamento> Omot =  departamentoRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			Departamento mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setAtivo(dto.getAtivo());
			mot.setIgreja(dto.getIgreja());
			mot.setLider(dto.getLider());
			mot.setResumo(dto.getResumo());
			
			
			
			departamentoRepository.save(mot);
			return mot;
		}else {
			return new Departamento();
		}
	}





@Transactional
public Departamento save(Departamento dto) {
	
	

		Departamento DepartamentoSaved =     departamentoRepository.save(dto);
		
		
		return DepartamentoSaved;
		
	
}
	
	
}
