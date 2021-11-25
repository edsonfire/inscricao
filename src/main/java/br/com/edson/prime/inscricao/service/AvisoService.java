package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.prime.inscricao.model.Aviso;
import br.com.edson.prime.inscricao.repository.AvisoRepository;

@Service
public class AvisoService {

	
	
	@Autowired
	private AvisoRepository avisoRepository;
	
	
	
	
	
	
	
	

	
public List<Aviso> getAll() {
		
		List<Aviso> list =  avisoRepository.findAll();

		
	//	Avisos = list.stream().map(x-> new AvisoDTO(x)).collect(Collectors.toList());
		
		return list;
		
	}

	
public Aviso getById(Integer id) {
		
		Optional<Aviso> Omot =  avisoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			return Omot.get();
		}else {
			return new Aviso();
		}
	}
	


@Transactional
public boolean delete(Integer id) {
		
		Optional<Aviso> Omot =  avisoRepository.findById(id);
		
		if(Omot.isPresent())
		{
			avisoRepository.delete(Omot.get());
			return true;
		}else {
			return false;
		}
	}
	




@Transactional
public Aviso update(Aviso dto) {
		
		Optional<Aviso> Omot =  avisoRepository.findById(dto.getId());
		
		
		
		
		if(Omot.isPresent())
		{
			Aviso mot = Omot.get();
			
			mot.setDescricao(dto.getDescricao());
			mot.setDataAviso(dto.getDataAviso());
			mot.setFimDataAviso(dto.getFimDataAviso());
			mot.setFoto(dto.getFoto());
			mot.setTitulo(dto.getTitulo());
			
			
			
			avisoRepository.save(mot);
			return mot;
		}else {
			return new Aviso();
		}
	}





@Transactional
public Aviso save(Aviso dto) {
	
	

		Aviso AvisoSaved =     avisoRepository.save(dto);
		
		
		return AvisoSaved;
		
	
}
	
	
}
