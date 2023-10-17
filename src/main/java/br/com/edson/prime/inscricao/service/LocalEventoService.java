package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.LocalEvento;
import br.com.edson.prime.inscricao.repository.LocalEventoRepository;

@Service
public class LocalEventoService {

	
	
	@Autowired
	private LocalEventoRepository localEventoRepository;
	
	
	
	
	
	
	
	

	
public List<LocalEvento> getAll() {
		
		List<LocalEvento> list =  localEventoRepository.findAll();

		return list;
		
	}

	
public LocalEvento getById(Integer id) {
		
		Optional<LocalEvento> Omot =  localEventoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new LocalEvento();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<LocalEvento> Omot =  localEventoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			localEventoRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public LocalEvento update(LocalEvento dto) {
		
		Optional<LocalEvento> Omot =  localEventoRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			LocalEvento mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setTipoEventoEnum(dto.getTipoEventoEnum());
				
			localEventoRepository.save(mot);
			return mot;
		}else {
			return new LocalEvento();
		}
	}





@Transactional
public LocalEvento save(LocalEvento dto) {
	
	

		LocalEvento LocalEventoSaved =     localEventoRepository.save(dto);
		
		
		return LocalEventoSaved;
		
	
}
	
	
}
