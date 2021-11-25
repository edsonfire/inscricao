package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Evento;
import br.com.edson.prime.inscricao.repository.EventoRepository;

@Service
public class EventoService {

	
	
	@Autowired
	private EventoRepository eventoRepository;
	
	
	
	
	
	
	
	

	
public List<Evento> getAll() {
		
		List<Evento> list =  eventoRepository.findAll();

		
	//	Eventos = list.stream().map(x-> new EventoDTO(x)).collect(Collectors.toList());
		
		return list;
		
	}

	
public Evento getById(Integer id) {
		
		Optional<Evento> Omot =  eventoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new Evento();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<Evento> Omot =  eventoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			eventoRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public Evento update(Evento dto) {
		
		Optional<Evento> Omot =  eventoRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			Evento mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setData(dto.getData());
			mot.setAtivo(dto.getAtivo());
			mot.setBanner1(dto.getBanner1());
			mot.setBanner2(dto.getBanner2());
			mot.setDepartamento(dto.getDepartamento());
			mot.setResponsavel(dto.getResponsavel());
			mot.setResumo(dto.getResumo());
			
			
			
			eventoRepository.save(mot);
			return mot;
		}else {
			return new Evento();
		}
	}





@Transactional
public Evento save(Evento dto) {
	
	

		Evento EventoSaved =     eventoRepository.save(dto);
		
		
		return EventoSaved;
		
	
}
	
	
}
